/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.dekimpe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author cdekimpe
 */
public class NeighborsPages {

    static Connection conn = null;
    static PreparedStatement statement = null;

    public int[] get(String title) throws SQLException {
        makeJDBCConnection();
        
        String query = "SELECT pl_from FROM wikipedia.pagelinks WHERE pl_title = '" + title + "'";
        statement = conn.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        
        rs.last(); // Set pointer to last element
        int total = rs.getRow(); // Get the number of the line from last element
        rs.beforeFirst(); // Set pointer back to first element
        int i = 0;
        int[] neighbors = new int[total];
        while (rs.next()) {
            neighbors[i] = rs.getInt("pl_from");
            i++;
        }
        
        statement.close();
        conn.close();
        return neighbors;
    }

    private static void makeJDBCConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://192.168.10.14:3306/wikipedia", "mysql", "csfirst");
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

    }

}
