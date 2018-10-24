package com.iotek.dao.impl;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaohuang on 2018/7/3.
 * ----------------The heart withered--------*/


public class BaseDao<T> {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/auction";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123456";

    static {
        //        1   加载驱动
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

    }

    public Connection getConn() {
        Connection connection = null;
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    //        5关闭资源
    protected   void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {

            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean update(String sql,Connection conn, Object... params) {
      //  Connection conn = null;
        if (conn == null){
            conn = getConn();
        }
        PreparedStatement ps = null;
        int i = 0;
        try {
            ps = conn.prepareStatement(sql);
            if (params != null) {
                for (int j = 0; j < params.length; j++) {
                    ps.setObject(j + 1, params[j]);

                }
            }
            i = ps.executeUpdate();
            if (i > 0)
                return true;
        } catch (SQLException e) {

        } finally {
            if(conn == null) {
                close(null, ps, conn);
            }
        }
        return false;
    }


    public   List<T> query(Class<T> tClass,String sql,Connection conn,Object... params){
//        存储查询的内容
        List<T> list=new ArrayList<T>();
       // Connection conn = null;
        if (conn == null){
            conn = getConn();
        }
        PreparedStatement ps = null;
        ResultSet rs=null;
      //  conn = getConn();
        try {
            ps  = conn.prepareStatement(sql);
            if (params != null) {
                //            循环占位
                for (int j = 0; j < params.length; j++) {
                    ps.setObject(j + 1, params[j]);
                }
            }
            rs  = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
//            metaData.getColumnCount()  // 查询结果的列数
//            metaData.getColumnLabel()  //列的别名
            int columnCount = metaData.getColumnCount();
//            外层循环创建对象
            while (rs.next()){
                T t = tClass.newInstance();
//                内层循环给对象的每个属性赋值
                for (int i =1; i <=columnCount; i++) {
//                   列的名字
                    String columnLabel = metaData.getColumnLabel(i);
//                    将列的名字转换字段的名字
                    String filedName=parse(columnLabel);
                    try {
                        Field field = tClass.getDeclaredField(filedName);
                        field.setAccessible(true);
                        field.set(t,rs.getObject(columnLabel));
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                }
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  list;
    }

    //将列名字格式转换成字段格式
    public static  String   parse(String  cname){
        if (cname == null||cname.length()==0) {
            throw  new  NullPointerException();
        }
        String[] strings = cname.trim().toLowerCase().split("_");
        String  s=strings[0];
        for (int i = 1; i <strings.length ; i++) {
            String  s1= strings[i].trim();
            char c = s1.charAt(0);
            c-=32;
            s+=c;
            s+=s1.substring(1,s1.length());
        }
        return  s;


    }
}
