/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agil.util.email;

import agil.Const.Messagem;
import agil.dado.ModuloConector;
import java.sql.*;

/**
 *
 * @author Carlos
 */
public class Email {

    private static String email, tipoEmail;
    private static int quantInt;

    static Connection conexao = null;
    static PreparedStatement pst = null;
    static ResultSet rs = null;
    static Statement stmt = null;

    /**
     *
     */
    public static void Email() {
        conexao = ModuloConector.getConecction();
    }

    /**
     * OK
     */
    public static void criarEmail() {
        Email();
        String sql = "create table if not exists email ("
                + "idpessoal int not null,"
                + "quantEmail int not null,"
                + "email varchar(30) not null,"
                + "tipoemail varchar(20) not null,"
                + "foreign key email(idpessoal) references pessoa(id)" + ")";
        try {
            stmt = conexao.createStatement();
            Messagem.criadoTabela(Email.class.getSimpleName());
            if (Messagem.getCriada() == 0) {
                int criada = stmt.executeUpdate(sql);
                System.out.println(""+criada);
                if (criada > 0) {
                    Messagem.chamarTela(Messagem.tabelaCriada(Email.class.getSimpleName()));
                    ModuloConector.fecharConexao(conexao, rs, pst);
                }
            }
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }
        ModuloConector.fecharConexao(conexao, rs, pst);
    }

    /**
     *
     */
    public static void deletarEmail() {
        Email();
        String sql = "drop table if exists email";
        try {
            stmt = conexao.createStatement();
            Messagem.deletadaTabela(Email.class.getSimpleName());
            if (Messagem.getDeleta() == 0) {
                int deleta = stmt.executeUpdate(sql);
                System.out.println(""+deleta);
                if (deleta == 0) {
                    Messagem.chamarTela(Messagem.tabelaDeletada(Email.class.getSimpleName()));
                }
                ModuloConector.fecharConexao(conexao, rs, pst);
            } 
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }
        ModuloConector.fecharConexao(conexao, rs, pst);
    }

    /**
     * @param id
     * @param email
     * @param quantEmail
     * @param tipoEmail
     */
    public void cadatrarEmail(int id, String email, int quantEmail, String tipoEmail) {
        Email();
        String sql = "insert into email(email.idPessoa,email.email,email.quantEmail,email.tipoemail) values (?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, email);
            pst.setInt(3, quantEmail);
            pst.setString(4, tipoEmail);
            if (email.isEmpty() || tipoEmail.isEmpty() || Integer.toString(id).isEmpty() || Integer.toString(quantEmail).isEmpty()) {
                Messagem.chamarTela(Messagem.VAZIO(""));
            } else {
                int adicionar = pst.executeUpdate();
                if (adicionar > 0) {
                    Messagem.chamarTela(Messagem.ADICIONADO(Email.class.getSimpleName()));
                    ModuloConector.fecharConexao(conexao, rs, pst);
                }
            }
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }
    }

    /**
     * @param id
     * @param email
     * @param quantEmail
     * @param tipoEmail
     */
    public void editarEmail(int id, String email, int quantEmail, String tipoEmail) {
        Email();
        String sql = "update email set email.id = ?, email.email = ?, email.tipoEmail =";
        setEmail(email);
        try {
            Messagem.chamarTela(Messagem.EDITADO(Email.class.getSimpleName()));

        } catch (Exception e) {
            Messagem.chamarTela(e);
        }
    }

    /**
     * @param id
     * @param email
     * @param quantEmail
     * @param tipoEmail
     */
    public void excluirEmail(int id, String email, int quantEmail, String tipoEmail) {
        Email();
        String sql = "";
        setEmail(email);
        try {

        } catch (Exception e) {
            Messagem.chamarTela(e);
        }
    }

    /**
     * @param id
     * @param email
     * @param quantEmail
     * @param tipoEmail
     */
    public void pesquisarEmail(int id, String email, int quantEmail, String tipoEmail) {
        Email();
        String sql = "";
        setEmail(email);
        try {

        } catch (Exception e) {
            Messagem.chamarTela(e);
        }
    }

    /**
     * @param email
     * @return
     */
    public int obterId(String email) {
        Email();
        try {
            String sql = "select email.id from email where email=?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, email);
            pst.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            Messagem.chamarTela(e);
        }
        return 0;
        
    }

    /**
     *
     * @return
     */
    public static String getEmail() {
        return email;
    }

    /**
     *
     * @param aEmail
     */
    public static void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     *
     * @return
     */
    public static String getTipoEmail() {
        return tipoEmail;
    }

    /**
     *
     * @param tipoEmail
     */
    public static void setTipoEmail(String tipoEmail) {
        Email.tipoEmail = tipoEmail;
    }

    /**
     * @param campo
     * @return
     */
    public static String verificarCampo(String campo) {
        return "";
    }
}
