/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agil.dado;

import agil.Const.Messagem;
import java.sql.*;

/**
 *
 * @author Carlos
 */
public class ModuloConector {
    
    public static final String DATABASE = "teste";
    public static final String DRIVER = "com.mysql.jdbc.Driver";
     public static final String URL ="jdbc:mysql://localhost:3306/";
    public static final String URLD = URL + DATABASE;
    public static final String USER = "root";
    public static final String PASS = "";

    /** OK
     * @return  a conexao 
     */
    public static java.sql.Connection getConecction() {
        Connection conexao = null;
        try {
            Class.forName(DRIVER);
            return conexao = DriverManager.getConnection(URLD, USER, PASS);
        } catch (ClassNotFoundException cnfe) {
            Messagem.chamarTela("O Servidor ultra-passou o limite de Conexão");
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }
        return conexao;
    }

    /**TESTE
     * 
     * tem ver
     */
    public static void criarDataBase() {
        
        try {
            Connection conexao = null;
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASS);
            String sql = "create database if not exist " +DATABASE;
            
        } catch (Exception e) {
            Messagem.chamarTela(e);
        }
    }

    /**TESTE
     * @param con
     */
    public static void fecharConexao(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }
    }

    /**
     * @param con
     * @param rs
     */
    public static void fecharConexao(Connection con, ResultSet rs) {
        try {
            if (rs != null) {
                fecharConexao(con);
                rs.close();
            }
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }
    }

    /**
     * @param con
     * @param rs
     * @param pst
     */
    public static void fecharConexao(Connection con, ResultSet rs, PreparedStatement pst) {
        try {
            if (pst != null) {
                fecharConexao(con, rs);
                pst.close();
            }
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }
    }

    /**
     * @param con
     * @param rs
     * @param pst
     * @param stmt
     */
    public static void fecharConexao(Connection con, ResultSet rs, PreparedStatement pst, Statement stmt) {
        try {
            if (pst != null) {
                fecharConexao(con, rs, pst);
                stmt.close();
            }
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }
    }

    /**Fazer
     */
    public static void criarBackupdataBase() {
        Connection conexao = getConecction();
        String sql = "BACKUP DATABASE teste\n"
                + "TO DISK = 'D:\\backups\\testDB.bak'";
        try {
            Statement stmt = conexao.createStatement();
            int adicionar = stmt.executeUpdate(sql);
            if (adicionar > 0) {
                
            }
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }
    }
}
