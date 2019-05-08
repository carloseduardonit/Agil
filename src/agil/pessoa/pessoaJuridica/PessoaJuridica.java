/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agil.pessoa.pessoaJuridica;

import agil.Const.Messagem;
import agil.dado.ModuloConector;
import agil.pessoa.Pessoa;
import static agil.pessoa.Pessoa.getTipoPessoa;
import agil.util.email.Email;
import agil.util.telefone.Telefone;
import java.sql.*;

/**
 *
 * @author Carlos
 */
public class PessoaJuridica extends Pessoa{
static Connection conexao = null;
static PreparedStatement pst =null;
static Statement stmt = null;
static ResultSet rs = null;
    public static void PessoaJuridica(){
        conexao = ModuloConector.getConecction();
        setTipoPessoa("PJ");
    }
    
    @Override
    
    public void cadastrarPessoa(String nome, String login ,String senha,String conSenha, Telefone telefone, Email email) {
        PessoaJuridica();
         String sql = "insert into pessoa(pessoa.nomeCompleto,pessoa.tipoPessoa,pessoa.login,pessoa.senha) values(?,?,?,?)";
        try {
            if (senha.equalsIgnoreCase(conSenha)) {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, nome);
                pst.setString(2, getTipoPessoa());
                pst.setString(3, login);
                pst.setString(4, senha);
                if (!nome.isEmpty() || !login.isEmpty() || !senha.isEmpty()) {
                    int adicionar = pst.executeUpdate();
                    if (adicionar > 0) {
                        Messagem.chamarTela(Messagem.ADICIONADO(PessoaJuridica.class.getSimpleName()));
                        ModuloConector.fecharConexao(conexao, rs, pst);
                    }
                }
            }
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }
    }

   
    @Override
    public void editarPessoa(String nome, String login, String senha, String conSenha, Telefone telefone, Email email) {
       PessoaJuridica();
        String sql = "update pessoa set pessoa.nomeCompleto = ?,pessoa.tipoPessoa=?,pessoa.login=?,pessoa.senha=? where id =? or login=?";
        try {
            if (senha.equalsIgnoreCase(conSenha)) {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, nome);
                pst.setString(2, getTipoPessoa());
                pst.setString(3, login);
                pst.setString(4, senha);
                pst.setString(5, "0");
                pst.setString(6, login);
                int editado = pst.executeUpdate();
                if (editado > 0) {
                    Messagem.chamarTela(Messagem.EDITADO(PessoaJuridica.class.getSimpleName()));
                }
            }
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }
    }

    @Override
    public void excluirPessoa(String nome, String login, String senha, String conSenha, Telefone telefone, Email email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pesquisarPessoa(String nome, String login, String senha, String conSenha, Telefone telefone, Email email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int obterIdPessoa(String login) {
        PessoaJuridica.class.getConstructors();
        String sql = "select id from pessoa where login =? and tipopessoa = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, getTipoPessoa());
            rs=pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }
        return 0;
    }
    
}
