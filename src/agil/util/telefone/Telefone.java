/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agil.util.telefone;

import agil.Const.Messagem;
import agil.dado.ModuloConector;
import java.sql.*;

/**
 *
 * @author Carlos
 */
public abstract class Telefone {

    static Connection conexao = null;
    static PreparedStatement pst = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    private static String DDI, DDD;
    private static String numero, tipoTelefone;
    static String Sql;

    public static void Telefone() {
        conexao = ModuloConector.getConecction();
    }

    public static void CriadoTelefone() {
        String sql = "create table if not exists telefone("
                + "idpessoa int not null,"
                + "DDI int not null default 55,"
                + "DDD int not null,"
                + "telefone varchar(10) not null,"
                + "tipotelefone varchar(20) not null,"
                + "foreign key (idpessoa) references pessoa (id))";
        try {
            stmt = conexao.createStatement();
            int criada = stmt.executeUpdate(sql);
            if (criada > 0) {
                Messagem.criadoTabela(Telefone.class.getSimpleName());
                ModuloConector.fecharConexao(conexao, rs, pst,stmt);
            }
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }
    }

    public static void DeletadoTelefone() {
        String sql ="drop table if exists telefone";
        try {
            stmt =conexao.createStatement();
            int deleta = stmt.executeUpdate(sql);
            if(deleta>0){
                Messagem.deletadaTabela(Telefone.class.getSimpleName());
            }
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }
    }

    public static void cadastrarTelefone(int id, String DDI, String DDD, String numero, String tipoTelefone) {
        Telefone();
        Sql = "";

        setDDI(DDI);
        setDDD(DDD);
        setNumero(numero);
        setTipoTelefone(tipoTelefone);
        try {

        } catch (Exception e) {
        }

    }

    public static void editarTelefone(int id, String DDI, String DDD, String numero, String tipoTelefone) {
        Sql = "";
        setDDI(DDI);
        setDDD(DDD);
        setNumero(numero);
        setTipoTelefone(tipoTelefone);
        try {

        } catch (Exception e) {
        }
    }

    public static void excluirTelefone(int id, String DDI, String DDD, String numero, String tipoTelefone) {
        Sql = "";
        setDDI(DDI);
        setDDD(DDD);
        setNumero(numero);
        setTipoTelefone(tipoTelefone);
        try {

        } catch (Exception e) {
        }
    }

    public static void pesquisarTelefone(int id, String DDI, String DDD, String numero, String tipoTelefone) {
        Sql = "";
        setDDI(DDI);
        setDDD(DDD);
        setNumero(numero);
        setTipoTelefone(tipoTelefone);
        try {

        } catch (Exception e) {
        }
    }

    public static String getDDI() {
        return Telefone.DDI;
    }

    public static void setDDI(String DDI) {
        Telefone.DDI = DDI;
    }

    public static String getDDD() {
        return Telefone.DDD;
    }

    public static void setDDD(String DDD) {
        Telefone.DDD = DDD;
    }

    public static String getNumero() {
        return Telefone.numero;
    }

    public static void setNumero(String numero) {
        Telefone.numero = numero;
    }

    public static String getTipoTelefone() {
        return Telefone.tipoTelefone;
    }

    public static void setTipoTelefone(String tipoTelefone) {
        Telefone.tipoTelefone = tipoTelefone;
    }

}
