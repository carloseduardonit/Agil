/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agil.pessoa;

import agil.Const.Messagem;
import agil.dado.ModuloConector;
import agil.util.email.Email;
import agil.util.telefone.Telefone;
import java.sql.*;

/**
 *
 * @author Carlos
 */
public abstract class Pessoa {

    private String nome;
            private  static String tipoPessoa;
    private int id;
    private String login, senha, conSenha;
    private static Telefone telefone;
    private static Email email;
    static Connection conexao = null;
    static PreparedStatement pst = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    public static void pessoa() {
        conexao = ModuloConector.getConecction();
    }

    public static void criadoPessoa() {
        pessoa();
        String sql = "create table if not exists pessoa("
                + "id int  not null auto_increment primary key,"
                + "nomeCompleto varchar(200) not null,"
                + "tipoPessoa varchar(2) not null,"
                + "login varchar(20) unique not null,"
                + "senha varchar(10) not null)";
        try {
            stmt = conexao.createStatement();
            Messagem.criadoTabela(Pessoa.class.getSimpleName());
            if (Messagem.getCriada() == 0) {
                int adicionar = stmt.executeUpdate(sql);
                if (adicionar > 0) {
                    Messagem.chamarTela(Messagem.tabelaCriada(Pessoa.class.getSimpleName()));
                }
            }
            ModuloConector.fecharConexao(conexao, rs, pst);
        } catch (SQLException ex) {
            Messagem.chamarTela(ex);
        }
    }

    public static void deletadaPessoa() {
        pessoa();
        String sql = "drop table if exists pessoa";
        try {
            stmt = conexao.createStatement();
            Messagem.deletadaTabela(Pessoa.class.getSimpleName());
            if(Messagem.getDeleta()==0){
                int deleta = stmt.executeUpdate(sql);
                if(deleta ==0){
                    Messagem.chamarTela(Messagem.tabelaDeletada(Pessoa.class.getSimpleName()));
                }
            }
            ModuloConector.fecharConexao(conexao, rs, pst);
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }
        ModuloConector.fecharConexao(conexao, rs, pst);
    }

    /**
     *
     * @param nome
     * @param login
     * @param senha
     * @param conSenha
     * @param telefone
     * @param email
     *
     */
    public abstract void cadastrarPessoa(String nome, String login, String senha, String conSenha, Telefone telefone, Email email);

    /**
     *
     * @param nome
     * @param login
     * @param senha
     * @param conSenha
     * @param telefone
     * @param email
     *
     */
    public abstract void editarPessoa(String nome, String login, String senha, String conSenha, Telefone telefone, Email email);

    /**
     *
     * @param nome
     * @param login
     * @param senha
     * @param conSenha
     * @param telefone
     * @param email
     *
     */
    public abstract void excluirPessoa(String nome, String login, String senha, String conSenha, Telefone telefone, Email email);

    /**
     * @param nome
     * @param login
     * @param senha
     * @param conSenha
     * @param telefone
     * @param email
     */
    public abstract void pesquisarPessoa(String nome, String login, String senha, String conSenha, Telefone telefone, Email email);

    /**
     * @param login
     */
    public abstract int obterIdPessoa(String login);

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static String getTipoPessoa() {
        return tipoPessoa;
    }

    public static void setTipoPessoa(String tipoPessoa) {
        Pessoa.tipoPessoa = tipoPessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConSenha() {
        return conSenha;
    }

    public void setConSenha(String conSenha) {
        this.conSenha = conSenha;
    }

    public static Telefone getTelefone() {
        return telefone;
    }

    public static void setTelefone(Telefone telefone) {
        Pessoa.telefone = telefone;
    }

    public static Email getEmail() {
        return email;
    }

    public static void setEmail(Email email) {
        Pessoa.email = email;
    }

}
