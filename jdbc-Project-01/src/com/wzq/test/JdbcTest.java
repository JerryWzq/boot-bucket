package com.wzq.test;

import com.wzq.entity.Member;
import com.wzq.entity.Province;
import com.wzq.mapper.BaseMapperImpl;
import com.wzq.util.JdbcUtil;
import org.junit.Test;

import java.sql.*;
import java.util.List;

public class JdbcTest {

    @Test
    public void test01(){
        String sql = "select id, name from member where name=?";
        Object[] objects = {"Bob"};
        Member member = BaseMapperImpl.get(Member.class, sql, false, objects);
        System.err.println(member.toString());
    }

    @Test
    public void test02(){
        String sql = "select id, province_code provinceCode, province_name provinceName from province " +
                "where province_name=?";
        Object[] objects = {"江西"};
        Province province = BaseMapperImpl.get(Province.class, sql, false, objects);
        System.err.println(province.toString());
    }

    @Test
    public void test03(){
        String sql = "select id, province_code, province_name from province " +
                "where province_name=?";
        Object[] objects = {"江西"};
        Province province = BaseMapperImpl.get(Province.class, sql, true, objects);
        System.err.println(province.toString());
    }

    @Test
    public void test04(){
        String sql = "select id, province_code provinceCode, province_name provinceName from province " +
                "where province_name like ?";
        Object[] objects = {"%西%"};
        List<Province> provinces = BaseMapperImpl.getForList(Province.class, sql, objects);
        System.err.println(provinces);
    }

    @Test
    public void testDataBaseMetaData(){
        Connection connection = null;
        DatabaseMetaData data = null;
        ResultSet resultSet = null;
        try{
            connection = JdbcUtil.getConnection();
            data = connection.getMetaData();
            //可以得到数据库本身的一些基本信息
            //得到数据库的版本号
            int databaseMajorVersion = data.getDatabaseMajorVersion();
            System.err.println("数据库版本号：" + databaseMajorVersion);

            //得到连接到数据库的用户名
            String userName = data.getUserName();
            System.err.println(userName);

            //得到MySQL中有哪些数据库
            resultSet = data.getCatalogs();
            while(resultSet.next()){
                System.err.println(resultSet.getString(1));
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            JdbcUtil.release(connection, null, resultSet);
        }
    }

    /**
     * 结果集的元数据
     */
    @Test
    public void testResultSetMetaData(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = JdbcUtil.getConnection();
            String sql = "select id, province_code provinceCode, province_name provinceName from province";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();
            //获取列的个数
            int columnCount = metaData.getColumnCount();
            System.err.println(columnCount);

            for(int i=0; i<columnCount; i++){
                //列名
                String columnName = metaData.getColumnName(i + 1);
                //别名
                String columnLabel = metaData.getColumnLabel(i + 1);
                System.err.println(columnName + "--" + columnLabel);
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            JdbcUtil.release(connection, preparedStatement, resultSet);
        }
    }


}
