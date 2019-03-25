package com.wzq.mapper;

import com.wzq.util.JdbcUtil;
import com.wzq.util.ReflectUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

public class BaseMapper {

    public static <T> T get(Class<T> clazz, String sql, Object... args) {
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
                //利用反射创建对象
                entity = clazz.newInstance();
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    Object object = resultSet.getObject(columnLabel);
                    values.put(columnLabel, object);
                }
            }
            //通过解析SQL语句来判断到底选择了那些列，以及需要为entity对象的那些属性赋值
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                ReflectUtil.invoke(entity, key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.release(connection, preparedStatement, resultSet);
        }

        return entity;
    }

}
