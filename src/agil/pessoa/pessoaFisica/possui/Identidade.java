/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agil.pessoa.pessoaFisica.possui;

import java.sql.Date;

/**
 *
 * @author Carlos
 */
public class Identidade extends CertidaoNascimento{
    private Date dataEmissaoIdentidade;
    private String orgaoEmissao,estadoEmissao;
    private int numIdentidade;
    private CertidaoNascimento cn;
    private CPF cpf;

    public Date getDataEmissaoIdentidade() {
        return dataEmissaoIdentidade;
    }

    public void setDataEmissaoIdentidade(Date dataEmissaoIdentidade) {
        this.dataEmissaoIdentidade = dataEmissaoIdentidade;
    }

    public String getOrgaoEmissao() {
        return orgaoEmissao;
    }

    public void setOrgaoEmissao(String orgaoEmissao) {
        this.orgaoEmissao = orgaoEmissao;
    }

    public String getEstadoEmissao() {
        return estadoEmissao;
    }

    public void setEstadoEmissao(String estadoEmissao) {
        this.estadoEmissao = estadoEmissao;
    }

    public int getNumIdentidade() {
        return numIdentidade;
    }

    public void setNumIdentidade(int numIdentidade) {
        this.numIdentidade = numIdentidade;
    }
    
    
}
