package com.spring.dog.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.spring.dog.service.DogDo;
import org.springframework.stereotype.Repository;
import com.spring.dog.common.JDBCUtil;
@Repository("ddao")
public class DogInfoDao {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;



    /*
    * 1. DO를 이용하여 입력된 데이터를 DB에 저장하는 메소드
    * */
    public void insertDogInfo(DogDo ddo) {
        conn = JDBCUtil.getConnection();
        String sql = "insert into dog (name, kind, age, color, owner) values (?, ?, ?, ?, ?);";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ddo.getName());
            pstmt.setString(2, ddo.getKind());
            pstmt.setInt(3, ddo.getAge());
            pstmt.setString(4, ddo.getColor());
            pstmt.setString(5, ddo.getOwner());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtil.closeConnection(conn, pstmt, rs);
    }


    /*
    * 2. DB에 저장되어 있는 전체 데이터 출력 메소드
    * */
    public void getAllDogInfo(){

        conn = JDBCUtil.getConnection();
        String sql = "select num, name, kind, age, color, owner from dog;";
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet result = pstmt.executeQuery();
            System.out.println("데이터 결과는? ");
            System.out.println("no \t name \t kind \t age \t color \t owner");
            System.out.println("==================================================");
            while (result.next()){
                System.out.println(result.getInt("num")
                        + "\t" + result.getString("name")
                        + "    \t" + result.getString("kind")
                        + "    \t" + result.getInt("age")
                        + "    \t" + result.getString("color")
                        + "    \t" + result.getString("owner"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtil.closeConnection(conn, pstmt, rs);
    }
}

