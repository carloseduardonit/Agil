/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agil.util.endereco;

import agil.Const.Messagem;
import agil.dado.ModuloConector;
import java.sql.*;

/**
 *
 * @author Carlos
 */
public class CEP {

    static Connection conexao;
    static Statement stmt;
    static PreparedStatement pst;
    static ResultSet rs;
    static int linha = 1;
    private static String[] SQL = new String[30];
static String campo="(id,cidade,logradouro,bairro,cep,tp_logradouro)";
    public static void CEP() {
        conexao = ModuloConector.getConecction();
    }
/** 
 * OK
 */
    public static void CriarCEP() {
        try {
            for (ESTADO e : ESTADO.values()) {
                CEP();
                String sql = "CREATE TABLE if not existes`" + e + "` (\n"
                        + "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n"
                        + "  `cidade` varchar(50) DEFAULT NULL,\n"
                        + "  `logradouro` varchar(70) DEFAULT NULL,\n"
                        + "  `bairro` varchar(72) DEFAULT NULL,\n"
                        + "  `cep` varchar(9) NOT NULL,\n"
                        + "  `tp_logradouro` varchar(20) DEFAULT NULL,\n"
                        + "  PRIMARY KEY (`id`),\n"
                        + "  KEY `idx_log_loc1` (`cidade`)\n"
                        + ") ENGINE=MyISAM AUTO_INCREMENT=845 DEFAULT CHARSET=latin1";
                stmt = conexao.createStatement();
                int Criada = stmt.executeUpdate(sql);
                if (Criada == 0) {
                    Messagem.criadoTabela(e.toString());
                    ModuloConector.fecharConexao(conexao, rs, pst, stmt);

                }
            }
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }

    }
/** 
 * OK
 */
    public static void DeletarCEP() {
        try {
            for (ESTADO e : ESTADO.values()) {
                CEP();
                String sql = "drop table if exists " + e;
                stmt = conexao.createStatement();
                int deleta = stmt.executeUpdate(sql);
                if (deleta == 0) {
                    Messagem.deletadaTabela(e.toString());
                    ModuloConector.fecharConexao(conexao, rs, pst, stmt);
                }
            }
        } catch (Exception e) {
        }

    }

    public static void InserirCEP(String sql) {
        try {
            CEP();
            pst = conexao.prepareStatement(sql);
            int adicionar = pst.executeUpdate();
            if (adicionar > 0) {
                Messagem.chamarTela(Messagem.ADICIONADO("Dado"));
            }
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }
    }
    public static void InserirCEP(long id,String cidade,String logradouro,String bairro,String cep,String tp_logradouro) {
        try { 
            CEP();
            String sql="insert into ac "+" values (?,?,?,?,?,?)" ;
            
            pst = conexao.prepareStatement(sql);
            pst.setLong(1, id);
            pst.setString(2, cidade);
            pst.setString(3, logradouro);
            pst.setString(4, bairro);
            pst.setString(5, sql);
            pst.setString(6, tp_logradouro);
            int adicionar = pst.executeUpdate();
            if (adicionar > 0) {
                Messagem.chamarTela(Messagem.ADICIONADO("Dado"));
            }
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }
    }

    /*public static void InserirCEP() {
        try {
            setSQL();
            for (String sql : getSQL()) {
                pst = conexao.prepareStatement(sql);
                int adicionar = pst.executeUpdate();
                if (adicionar > 0) {
                    Messagem.chamarTela(Messagem.ADICIONADO("linha " + linha++));
                }
            }
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }
    }*/

    public static String[] getSQL() {
        return SQL;
    }

    public static void setSQL() {
        try {
            for (ESTADO e : ESTADO.values()) {
                String sql = "insert into " + e.toString().toLowerCase()+campo+" values";
                for (int i = 0;i<e.geteAC().length;) {
                    
                    sql +=e.geteAC(i);
                    System.out.println(""+sql);
                            
                    stmt = conexao.createStatement();
                    int adiciona = pst.executeUpdate();
                    if (adiciona > 0) {
                        Messagem.chamarTela(sql);
                        ModuloConector.fecharConexao(conexao, rs, pst, stmt);
                    }
                }
            }
        } catch (Exception e) {
            Messagem.chamarTela(e);
        }
    }
}
