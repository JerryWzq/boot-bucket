package com.wzq.test;

import com.wzq.entity.Member;
import com.wzq.entity.Province;
import com.wzq.mapper.BaseMapperImpl;
import com.wzq.util.JdbcUtil;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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

    /**
     * 测试插入大文本（图片）
     */
    @Test
    public void testBlob(){
        String sql = "insert into member (name, picture) values(?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, "jerry");
            InputStream in = new FileInputStream("wallpaper.png");
            preparedStatement.setBlob(2, in);
            preparedStatement.execute();
            in.close();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            JdbcUtil.release(connection, preparedStatement, null);
        }
    }

    /**
     * 测试从数据库读取图片
     */
    @Test
    public void testReadBlob(){

        String sql = "select id, name, picture from member where id=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, 2);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.err.println(id + ">>>>" + name);

                Blob blob = resultSet.getBlob(3);
                InputStream binaryStream = blob.getBinaryStream();
                OutputStream outputStream = new FileOutputStream("wallpaper-db.png");
                byte []  bytes = new byte[1024];
                int len = 0;
                while((len = binaryStream.read(bytes)) != -1){
                    outputStream.write(bytes);
                }

                outputStream.close();
                binaryStream.close();

            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            JdbcUtil.release(connection, preparedStatement, resultSet);
        }

    }


}
