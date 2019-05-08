/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agil.util;
import agil.Const.Messagem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Carlos
 */
public abstract class MetodoAuxiliar {
    private static int Dia = 0, Mes = 0, Ano = 0;
    static SimpleDateFormat sdfBR = new SimpleDateFormat("dd/mm/yyyy");
    static SimpleDateFormat sdfUS = new SimpleDateFormat("yyyy/mm/dd");
    static Date data;
    /** 
     * 
     * @param dia
     * @param mes
     * @param ano
     * @return 
     */
    
    public static String dataBRs(int dia, int mes, int ano) {
        if (dia == 0) {
			 Messagem.chamarTela("Dia se encontra Vazia");
            return null;
            
           
        } else if (mes == 0) {
			 Messagem.chamarTela("MES se encontra Vazia");
            return null;
        } else if (ano == 0) {
			 Messagem.chamarTela("ANO se encontra Vazia");
            return null;
        } else {
            data = new Date(ano, mes, dia);
            return sdfBR.format(data);
        }
    }
    /**
     * @param dia
     * @param mes
     * @param ano
     * @return
     */
    public static Date dataBRd(int dia, int mes, int ano) {
        try {
            if (dia == 0) {
                return null;
            } else if (mes == 0) {
                return null;
            } else if (ano == 0) {
                return null;
            } else {
                data = sdfBR.parse(dataBRs(dia, mes, ano));
                return data;
            }
        } catch (ParseException ex) {
            Messagem.chamarTela(ex);
        }
        return null;
    }
    /**
     * @param dia
     * @param mes
     * @param ano
     * @return
     */
    public static String dataBRs() {
        if (getAno() == 0) {
            return null;
        } else if (getMes() == 0) {
            return null;
        } else if (getDia() == 0) {
            return null;
            
        } else {
            data = new Date(getAno(), getMes(), getDia());
            return sdfBR.format(data);
        }
    }
    /**
     *
     * @return
     */
    public static Date dataBRd() {
        try {
            if (getAno() == 0) {
                return null;
            } else if (getMes() == 0) {
                return null;
            } else if (getDia() == 0) {
                return null;
            } else {
                data = sdfBR.parse(dataBRs(getDia(), getMes(), getAno()));
                return data;
            }
        } catch (ParseException ex) {
            Messagem.chamarTela(ex);
        }
        return null;
    }
    /**
     * @param dia
     * @param mes
     * @param ano
     * @return
     */
    public static String dataUSs(int dia, int mes, int ano) {
        if (dia == 0) {
            return null;
        } else if (mes == 0) {
            return null;
        } else if (ano == 0) {
            return null;
        } else {
            data = new Date(mes, ano, dia);
            return sdfUS.format(data);
        }
    }
    /**
     * @param dia
     * @param mes
     * @param ano
     * @return
     */
    public static Date dataUSd(int dia, int mes, int ano) {
        try {
            if (dia == 0) {
                return null;
            } else if (mes == 0) {
                return null;
            } else if (ano == 0) {
                return null;
            } else {
                data = sdfUS.parse(dataBRs(dia, mes, ano));
                return data;
            }
        } catch (ParseException ex) {
            Messagem.chamarTela(ex);
        }
        return null;
    }
    /**
     *
     * @return
     */
    public static String dataUSs() {
        if (getAno() == 0) {
            return null;
        } else if (getMes() == 0) {
            return null;
        } else if (getDia() == 0) {
            return null;
        } else {
            data = new Date(getAno(), getMes(), getDia());
            return sdfUS.format(data);
        }
    }
    /**
     *
     * @return
     */
    public static Date dataUSd() {
        try {
            if (getAno() == 0) {
                return null;
            } else if (getMes() == 0) {
                return null;
            } else if (getDia() == 0) {
                return null;
            } else {
                data = sdfUS.parse(dataBRs(getDia(), getMes(), getAno()));
                return data;
            }
        } catch (ParseException ex) {
            Messagem.chamarTela(ex);
        }
        return null;
    }
//Gets e Sets
    public static int getDia() {
        return Dia;
    }
    public static void setDia(int Dia) {
        MetodoAuxiliar.Dia = Dia;
    }
    public static int getMes() {
        return Mes;
    }
    public static void setMes(int Mes) {
        MetodoAuxiliar.Mes = Mes;
    }
    public static int getAno() {
        return Ano;
    }
    public static void setAno(int Ano) {
        MetodoAuxiliar.Ano = Ano;
    }
}