/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import bancodedados.CriaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logica.Contato;

/**
 *
 * @author DEBYREGIS
 */
public class ContatoDao {
    
    private Connection conexao; 

    //Criando uma conexão
    public ContatoDao() {
        this.conexao = new CriaConexao().getConnection(); 
    }
    
    //Método para inserir contato
    public void inserirContato(Contato contato) throws SQLException{
        String sql = "insert into contato (nome, endereco, email, fone, sexo) values (?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        //Seta os valores
        stmt.setString(1, contato.getNome());
        stmt.setString(2, contato.getEndereco());
        stmt.setString(3, contato.getEmail());
        stmt.setString(4, contato.getFone());
        stmt.setString(5, contato.getSexo());
        
        //Excuta o código SQL e fecha conexão
        stmt.execute();
        stmt.close();
        
    }
  
    //Método para pesquisar contatos
    public List<Contato> getLista(String nome) throws SQLException{
        String sql = "select * from contato where nome like ? ";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Contato> meusContatos = new ArrayList<>();
        
        while(rs.next()){
            Contato c = new Contato();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setEndereco(rs.getString("endereco"));
            c.setEmail(rs.getString("email"));
            c.setFone(rs.getString("fone"));
            c.setSexo(rs.getString("sexo"));
            meusContatos.add(c);
        }
        
        //Excuta o código SQL e fecha conexão
        rs.close();
        stmt.close();
        return meusContatos;
    }  
          
    //Método para alterar contato
    public void alteraContato(Contato contato) throws SQLException{
        String sql = "update contato set nome=?, endereco=?, email=?, fone=?, sexo=? where id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        //Seta valores
        stmt.setString(1, contato.getNome());
        stmt.setString(2, contato.getEndereco());
        stmt.setString(3, contato.getEmail());
        stmt.setString(4, contato.getFone());
        stmt.setString(5, contato.getSexo());
        stmt.setString(6, String.valueOf(contato.getId()));
        
        //Excuta o código SQL e fecha conexão
        stmt.execute();
        stmt.close();
    }
    
    //Método para remover contato
    public void removerCotato(Contato contato) throws SQLException{
        String sql = "delete from contato where id = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        
        //seta id
        stmt.setString(1, String.valueOf(contato.getId()));
        
         //Excuta o código SQL
        stmt.execute();
        stmt.close();
        
    }
    
    //Método para verificar duplicidade
    public boolean verificaDuplicidade(String email) throws SQLException{
        String sql = "select email from contato where email = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, email);
        
        ResultSet rs = stmt.executeQuery();
        
        if(rs.next()){
            return false;
        }
        
        //Excuta o código SQL e fecha conexão
        rs.close();
        stmt.close();
        return true;
        
    }
    
}
