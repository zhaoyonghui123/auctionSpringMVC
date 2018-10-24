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
        //        1   ��������
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

    //        5�ر���Դ
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
//        �洢��ѯ������
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
                //            ѭ��ռλ
                for (int j = 0; j < params.length; j++) {
                    ps.setObject(j + 1, params[j]);
                }
            }
            rs  = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
//            metaData.getColumnCount()  // ��ѯ���������
//            metaData.getColumnLabel()  //�еı���
            int columnCount = metaData.getColumnCount();
//            ���ѭ����������
            while (rs.next()){
                T t = tClass.newInstance();
//                �ڲ�ѭ���������ÿ�����Ը�ֵ
                for (int i =1; i <=columnCount; i++) {
//                   �е�����
                    String columnLabel = metaData.getColumnLabel(i);
//                    ���е�����ת���ֶε�����
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

    //�������ָ�ʽת�����ֶθ�ʽ
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
