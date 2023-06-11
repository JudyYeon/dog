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
}

