/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agil.util.endereco;

/**
 *
 * @author Carlos
 */
public enum ESTADO {
    AC,
    AL,
    AP,
    AM,
    BA,
    CE,
    DF,
    ES,
    GO,
    MA,
    MT,
    MS,
    MG,
    PA,
    PB,
    PR,
    PE,
    PI,
    RJ,
    RN,
    RS,
    RO,
    RR,
    SC,
    SP,
    SE,
    TO;

    private int estado;

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
    
    private String[] eAC = new String[3];
    

    /**
     * @return the eAC
     */
    public String[] geteAC() {
        return eAC;
    }

    
    
    
    
    
    public String geteAC(int pos) {
        this.seteAC();
        return eAC[pos];
    }

    /**
     * @param eAC the eAC to set
     */
    public void seteAC(String[] eAC) {
        this.eAC = eAC;
    }

    public void seteAC() {
        this.eAC[0] = " (1,Salvador,01 de Maio,Pero Vaz,40335-505,Avenida)";
        this.eAC[1] = " ('Salvador','01-Proflurb','Tancredo Neves','41205-560','Caminho')";
        this.eAC[2]="";
    }
    
}
