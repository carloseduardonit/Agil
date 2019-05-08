/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agil.pessoa.pessoaFisica.possui;

import agil.Const.Messagem;
import agil.dado.ModuloConector;
import java.sql.*;

/**
 *
 * @author Carlos Eduardo dos Santos Figueiredo
 * @since
 */
public class CarteiraTrabalho {

    static Connection conexao;
    static PreparedStatement pst;
    static Statement stmt;
    static ResultSet rs;

    /**
     */
    public static void CarteiraTrabalho() {
        conexao = ModuloConector.getConecction();
    }

    /**
     */
    public static void criandoCarteiraTrabalho() {
        CarteiraTrabalho();
        String sql = "";
        try {
            stmt = conexao.createStatement();
            int criada = stmt.executeUpdate(sql);
            if (criada > 0) {
                Messagem.criadoTabela(CarteiraTrabalho.class.getSimpleName());
            }
            ModuloConector.fecharConexao(conexao, rs, pst, stmt);
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }
    }

    /**
     */
    public static void delatadoCarteiraTrabalho() {
        String sql = "drop table if exists CarteiraTrabalho";
        try {
            stmt = conexao.createStatement();
            int deleta = stmt.executeUpdate(sql);
            if (deleta > 0) {
                Messagem.deletadaTabela(CarteiraTrabalho.class.getSimpleName());
            }
            ModuloConector.fecharConexao(conexao, rs, pst, stmt);
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }
    }

    /**
     */
    public static void adicionarCarteiraTrabalho() {
        try {
            String sql;
            if (true) {

            }
        } catch (Exception e) {
            Messagem.chamarTela(e);
        }
    }

    /**
     */
    public static void editarCarteiraTrabalho() {
        try {
            String sql;
            if (true) {

            }
        } catch (Exception e) {
            Messagem.chamarTela(e);
        }
    }

    /**
     */
    public static void excluirCarteiraTrabalho() {
        try {
            String sql;
            if (true) {

            }
        } catch (Exception e) {
            Messagem.chamarTela(e);
        }
    }

    /**
     */
    public static void pesquisarCarteiraTrabalho() {
        try {
            String sql;
            if (true) {

            }
        } catch (Exception e) {
            Messagem.chamarTela(e);
        }
    }
}
