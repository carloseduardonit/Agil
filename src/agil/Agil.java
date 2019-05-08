/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agil;

import agil.dado.ModuloConector;
import agil.pessoa.pessoaFisica.PessoaFisica;
import agil.util.email.Email;
import agil.util.telefone.Telefone;

/**
 *
 * @author Carlos
 */
public class Agil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic herePessoaJuridica pj = new PessoaJuridica();
        String[] nomes = new String[3];
        nomes[0] = "Carlos";
        nomes[1] = "Eduardo";
        nomes[2] = "Santos";
        String nome = "Rob", login = "rob1", senha = "123", conSenha = senha, em = "Carlostecnico@gmail.com", tipoem = "profissional";
        Telefone telefone = null;
        Email email = new Email();
        PessoaFisica pf = new PessoaFisica();
        //System.out.println(""+pf.obterIdPessoa(login));
        // System.out.println(""+Messagem.VAZIO(nomes));
        //Email.criarEmail();
        //Email.deletarEmail();
        //Messagem.criadoTabela("Carlos");
       // Messagem.deletadaTabela("Carlos");
       //System.out.println(Messagem.getCriada()); 
        //System.out.println(Messagem.getDeleta());
        //CEP.CriarCEP();
        //CEP.InserirCEP(1,"Salvador","01 de Maio","Pero Vaz","40335-506","Avenida");
        ModuloConector.criarBackupdataBase();
        //email.cadatrarEmail(pf.obterIdPessoa(login), em,0, tipoem);
        //pf.cadastrarPessoa(nome, login, senha, conSenha, telefone, email);
    }

}
