/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agil.pessoa.pessoaFisica.possui;

import agil.Const.Messagem;
import agil.dado.ModuloConector;
import agil.pessoa.pessoaFisica.PessoaFisica;
import agil.util.MetodoAuxiliar;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Carlos
 */
public class CPF extends Identidade {

    public static void main(String[] args) {
        //deletarCPF();
        //criarCPF();
        nCPF =1;
        int id =1;
        MetodoAuxiliar.setDia(18);
        MetodoAuxiliar.setMes(9);
        MetodoAuxiliar.setAno(1987);
       adicionarCPF(id, String.valueOf(nCPF), MetodoAuxiliar.dataUSs());
        System.out.println(MetodoAuxiliar.getAno()+"/"+MetodoAuxiliar.getMes()+"/"+MetodoAuxiliar.getDia());
    }
    static Connection conexao;
    static PreparedStatement pst;
    static Statement stmt;
    static ResultSet rs;
    private static int nCPF;
    private static Date dataEmissaoCPF;
    private static PessoaFisica pf = new PessoaFisica();

    /**
     * TESTAR
     */
    public static void CPF() {
        conexao = ModuloConector.getConecction();
    }

    /**
     * TESTAR
     */
    public static void criarCPF() {
        CPF();
        try {
            String sql = "create table if not exists CPF("
                    + " idPessoa int not null,"
                    + " numCPF int8 not null primary key,"
                    + " dataEmissaoCPF datetime not null,"
                    + " foreign key (idPessoa) references pessoa(id)"
                    + ");";
            stmt = conexao.createStatement();
            Messagem.criadoTabela(CPF.class.getSimpleName());
            if (Messagem.getCriada() == 0) {
                int criado = stmt.executeUpdate(sql);
                if (criado == 0) {
                    Messagem.chamarTela(Messagem.tabelaCriada(CPF.class.getSimpleName()));
                    ModuloConector.fecharConexao(conexao, rs, pst, stmt);
                } 
            }
        } catch (NullPointerException npe) {
            Messagem.chamarTela("O servidor esta desligado !!!");
        } catch (SQLException e) {
            Messagem.chamarTela(e);
        }
    }

    /**
     * TESTAR
     */
    public static void deletarCPF() {
        CPF();
        try {
            String sql = "drop table if exists CPF";
            stmt = conexao.createStatement();
            Messagem.deletadaTabela(CPF.class.getSimpleName());
            if (Messagem.getDeleta() == 0) {
                int deletar = stmt.executeUpdate(sql);
                if (deletar == 0) {
                    Messagem.chamarTela(Messagem.tabelaDeletada(CPF.class.getSimpleName()));
                }
            }
        } catch (Exception e) {
            Messagem.chamarTela(e);
        }
    }

    /**
     * Testa
     *
     * @param idPessoa
     * @param nCPF
     * @param dataEmissaoCPF
     *
     */
    public static void adicionarCPF(int idPessoa, String nCPF, String dataEmissaoCPF) {
        CPF();
        try {
            String sql = "insert into CPF (idPessoa,numCPF,dataEmissaoCPF) values(?,?,?)";
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, idPessoa);
            pst.setString(2, nCPF);
            pst.setString(3, dataEmissaoCPF);
            if (nCPF.isEmpty() || dataEmissaoCPF.isEmpty() || String.valueOf(idPessoa).isEmpty()) {
                String[] vazia = new String[3];
                vazia[0] = nCPF;
                vazia[1] = dataEmissaoCPF;
                vazia[2] = String.valueOf(idPessoa);
                Messagem.VAZIO(vazia);
                ModuloConector.fecharConexao(conexao, rs, pst, stmt);
            } else {
                int adicionar = pst.executeUpdate();
                if (adicionar == 0) {
                    Messagem.chamarTela(Messagem.ADICIONADO(CPF.class.getSimpleName()));
                    ModuloConector.fecharConexao(conexao, rs, pst, stmt);
                }
            }
        } catch (Exception e) {
            Messagem.chamarTela(e);
        }
    }

    /**
     * Testa
     *
     * @param idPessoa
     * @param nCPF
     * @param dataEmissaoCPF
     *
     */
    public static void editarCPF(int idPessoa, String nCPF, String dataEmissaoCPF) {
        CPF();
        try {
            if (String.valueOf(idPessoa).isEmpty() || nCPF.isEmpty() || dataEmissaoCPF.isEmpty()) {
                ModuloConector.fecharConexao(conexao, rs, pst, stmt);
            } else {
                String sql = "update CPF set nCPF = ?,dataEmissaoCPF = ? where idPessoa = ? ";
                pst = conexao.prepareStatement(sql);
                pst.setString(1, nCPF);
                pst.setString(2, dataEmissaoCPF);
                pst.setInt(3, idPessoa);
                int editada = pst.executeUpdate();
                if (editada == 0) {
                    Messagem.chamarTela(Messagem.EDITADO(CPF.class.getSimpleName()));
                    ModuloConector.fecharConexao(conexao, rs, pst, stmt);
                }
            }
        } catch (Exception e) {
            Messagem.chamarTela(e);
        }
    }

    /**
     * Testa
     *
     * @param idPessoa
     *
     */
    public static void excluirCPF(int idPessoa) {
        CPF();
        pesquisaCPF(idPessoa);
        String cpf = "o CPF: " + getnCPF();
        try {
            if (String.valueOf(idPessoa).isEmpty()) {
                Messagem.chamarTela(Messagem.VAZIO("Id Pessoa"));
                ModuloConector.fecharConexao(conexao, rs, pst, stmt);
            } else {
                String sql = "delete from cpf where cpf.idPessoa = ?";
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, idPessoa);
                int deletado = pst.executeUpdate();
                if (deletado == 0) {
                    Messagem.chamarTela(Messagem.EXCLUIDO(sql));
                    ModuloConector.fecharConexao(conexao, rs, pst, stmt);
                }
            }
        } catch (Exception e) {
            Messagem.chamarTela(e);
        }
    }

    /**
     * Testa
     *
     * @param nCPF
     *
     */
    public static void excluirCPF(String nCPF) {
        CPF();
        String cpf = "o CPF: " + nCPF;
        try {
            if (nCPF.isEmpty()) {
                Messagem.chamarTela(Messagem.VAZIO(""));
                ModuloConector.fecharConexao(conexao, rs, pst, stmt);
            } else {
                String sql = "delete from cpf where cpf.numCPF = ?";
                pst = conexao.prepareStatement(sql);
                pst.setString(1, nCPF);
                int deletado = pst.executeUpdate();
                if (deletado == 0) {
                    Messagem.chamarTela(Messagem.EXCLUIDO(cpf));
                    ModuloConector.fecharConexao(conexao, rs, pst, stmt);
                }
            }
        } catch (Exception e) {
            Messagem.chamarTela(e);
        }
    }

    /**
     * Testa
     *
     * @param idPessoa
     * @param nCPF
     * @param igual
     *
     */
    public static void excluirCPF(int idPessoa, String nCPF, Boolean igual) {
        CPF();
        try {
            if (nCPF.isEmpty()) {
                Messagem.chamarTela(Messagem.VAZIO(""));
                ModuloConector.fecharConexao(conexao, rs, pst, stmt);
            } else {
                String sql;
                if (igual == true) {
                    sql = "delete from cpf where cpf.numCPF = ? and cpf.idPessoa = ?";
                } else {
                    sql = "delete from cpf where cpf.numCPF = ? or cpf.idPessoa = ?";
                }
                pst = conexao.prepareStatement(sql);
                pst.setString(1, nCPF);
                pst.setInt(2, idPessoa);
                int deletado = pst.executeUpdate();
                if (deletado > 0) {
                    Messagem.chamarTela(Messagem.EXCLUIDO(sql));
                    ModuloConector.fecharConexao(conexao, rs, pst, stmt);
                }
            }
        } catch (Exception e) {
            Messagem.chamarTela(e);
        }
    }

    /**
     * Testa
     *
     * @param nCPF
     */
    public static void pesquisarCPF(String nCPF) {
        CPF();
        try {
            if (nCPF.isEmpty()) {
                Messagem.chamarTela(Messagem.VAZIO("Numero do CPF"));
            } else {
                String sql = "select CPF.idPessoa,CPF.dataEmissaoCPF from CPF where nCPF=?";
                pst = conexao.prepareStatement(sql);
                pst.setString(1, nCPF);
                rs = pst.executeQuery();
                if (rs.next()) {
                    pf.setId(rs.getInt(1));
                    //setDataEmissaoCPF(rs.getString(2))
                }
            }
        } catch (Exception e) {
            Messagem.chamarTela(e);
        }
    }

    /**
     * Testa
     *
     * @param idPessoa
     */
    public static void pesquisaCPF(int idPessoa) {
        CPF();
        try {
            if (String.valueOf(id).isEmpty()) {
                Messagem.chamarTela(Messagem.VAZIO("O id da Pessoa"));
            } else {
                String sql = "select CPF.nCPF,CPF.dataEmissaoCPF from CPF where idPessoa=?";
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, id);
                rs = pst.executeQuery();
                if (rs.next()) {
                    setnCPF(rs.getInt(1));
                    //setDataEmissaoCPF(rs.getString(2))
                }
            }
        } catch (Exception e) {
            Messagem.chamarTela(e);
        }
    }

    // Gets E Sets
    /**
     * TESTAR
     *
     * @return
     */
    public static int getnCPF() {
        return nCPF;
    }

    /**
     * TESTAR
     *
     * @param nCPF
     */
    public static void setnCPF(int nCPF) {
        CPF.nCPF = nCPF;
    }

    /**
     * TESTAR
     *
     * @return
     */
    public static Date getDataEmissaoCPF() {
        return dataEmissaoCPF;
    }

    /**
     * TESTAR
     *
     * @param dataEmissaoCPF
     */
    public static void setDataEmissaoCPF(Date dataEmissaoCPF) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        
        CPF.dataEmissaoCPF = dataEmissaoCPF;
    }

    /**
     * TESTAR
     *
     * @return
     */
    public static String getDataemissaoCPF() {
        String var = getDataEmissaoCPF().toString();
        return var;
    }

    /* @SuppressWarnings("deprecation")
    public static void setDataEmissaoCPF(String dataEmissaoCPF) {
        this.dataEmissaoCPF = Date.parse(dataEmissaoCPF);
    }*/
}
