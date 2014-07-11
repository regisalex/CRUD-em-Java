/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agendadecontatos;

import forms.jTAgendaContatos;
import java.sql.SQLException;

/**
 *
 * @author DEBYREGIS
 */
public class AgendaDeContatos {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        jTAgendaContatos form = new jTAgendaContatos();
        form.setVisible(true);
       /* Contato contato = new Contato();
        contato.setId(45);
        contato.setNome("Rochele");
        contato.setEndereco("Rua ticotico");
        contato.setEmail("rochele@gmail.com");
        contato.setFone("12345678");
        contato.setSexo("m");
        
        ContatoDao dao = new ContatoDao();
        if(dao.verificaDuplicidade(contato) == true){
            dao.inserirContato(contato);
            System.out.println("Contato adicionado com sucesso");
        }
        else {
        
            System.out.print("Contato já consta na nossa base de dados");
        }*/
        
    }
    
}
