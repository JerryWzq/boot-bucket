package com.wzq.mapper;

import com.wzq.util.JdbcUtil;
import com.wzq.util.ReflectUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseMapper {

    public static <T> T get(Class<T> clazz, String sql, boolean mapUnderscoreToCamelCase, Object... args) {
        T entity = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();

            Map<String, Object> values = new HashMap<>();
            ResultSetMetaData metaData = resultSet.getMetaData();
            if (resultSet.next()) {
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    Object object = resultSet.getObject(columnLabel);
                    values.put(columnLabel, object);
                }
            }
            //利用反射创建对象
            entity = clazz.newInstance();
            //通过解析SQL语句来判断到底选择了那些列，以及需要为entity对象的那些属性赋值
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                ReflectUtil.invoke(entity, key, value, mapUnderscoreToCamelCase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.release(connection, preparedStatement, resultSet);
        }
        return entity;
    }

    public static <T> List<T> getForList(Class<T> clazz, String sql, Object ... args){
        List<T> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            resultSet = preparedStatement.executeQuery();

            List<String> columnLabels = getColunmLabels(resultSet);
            List<Map<String, Object>> values = resultSetToMapList(resultSet, columnLabels);
            //通过解析SQL语句来判断到底选择了那些列，以及需要为entity对象的那些属性赋值
            list = transferMapListToBeanList(clazz, values);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.release(connection, preparedStatement, resultSet);
        }

        return list;
    }

    private static <T> List<T> transferMapListToBeanList(Class<T> clazz, List<Map<String, Object>> values) throws InstantiationException, IllegalAccessException {
        List<T> list = new ArrayList<>();
        T entity;
        if(!values.isEmpty()){
            for (Map<String, Object> value : values) {
                entity = clazz.newInstance();
                for (Map.Entry<String, Object> entry : value.entrySet()) {
                    String k = entry.getKey();
                    Object v = entry.getValue();
                    ReflectUtil.invoke(entity, k, v);
                }
                list.add(entity);
            }
        }
        return list;
    }

    private static List<Map<String, Object>> resultSetToMapList(ResultSet resultSet, List<String> columnLabels) throws SQLException {
        List<Map<String, Object>> values = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> entity = new HashMap<>();
            for (String column : columnLabels) {
                Object value = resultSet.getObject(column);
                entity.put(column, value);
            }
            values.add(entity);
        }
        return values;
    }

    private static List<String> getColunmLabels(ResultSet resultSet) throws SQLException {
        List<String> labels = new ArrayList<>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        for(int i=0; i<metaData.getColumnCount(); i++){
            labels.add(metaData.getColumnLabel(i+1));
        }
        return labels;
    }

}
