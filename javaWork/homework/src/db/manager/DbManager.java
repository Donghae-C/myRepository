package db.manager;

import java.sql.*;

public class DbManager {

    static {
        try {
            Class.forName(DbStore.DB_PATH);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DbStore.DB_URL, DbStore.DB_USER, DbStore.DB_PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void releaseConnection(Connection conn, Statement st, ResultSet rs) {
        try {
            if(rs != null) {
                rs.close();
            }
            releaseConnection(conn, st);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void releaseConnection(Connection conn, Statement st){
        try {
            if(st != null) {
                st.close();
            }
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
