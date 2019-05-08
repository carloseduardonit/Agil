/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agil.util.endereco;

import agil.dado.ModuloConector;
import java.sql.*;

/**
 *
 * @author Carlos
 */
public class Endereco {

    static Connection conexao;
    static PreparedStatement pst;
    static Statement stmt;
    static ResultSet rs;
    private static int nCEP;
    private static String municipioCEP, estadoCEP, CidadeCEP;
    private static String tipoLougradoCEP, LougradoCEP;

    public static void Endereco() {
        conexao = ModuloConector.getConecction();
    }

    public static void cadastrarEndereco() {
        Endereco();
        String sql;
    }

    public int getnCEP() {
        return nCEP;
    }

    public void setnCEP(int nCEP) {
        this.nCEP = nCEP;
    }

    public String getMunicipioCEP() {
        return municipioCEP;
    }

    public void setMunicipioCEP(String municipioCEP) {
        this.municipioCEP = municipioCEP;
    }

    public String getEstadoCEP() {
        return estadoCEP;
    }

    public void setEstadoCEP(String estadoCEP) {
        this.estadoCEP = estadoCEP;
    }

    public String getCidadeCEP() {
        return CidadeCEP;
    }

    public void setCidadeCEP(String CidadeCEP) {
        this.CidadeCEP = CidadeCEP;
    }

    public String getTipoLougradoCEP() {
        return tipoLougradoCEP;
    }

    public void setTipoLougradoCEP(String tipoLougradoCEP) {
        this.tipoLougradoCEP = tipoLougradoCEP;
    }

    public String getLougradoCEP() {
        return LougradoCEP;
    }

    public void setLougradoCEP(String LougradoCEP) {
        this.LougradoCEP = LougradoCEP;
    }

}
