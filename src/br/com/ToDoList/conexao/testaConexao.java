package br.com.ToDoList.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class testaConexao {
	
	
	public void conecta() throws SQLException {
		Connection conn = 
		DriverManager.getConnection("jdbc:mysql://localhost/todolist?useTimezone=true&serverTimezone=UTC","root","0910");
		System.out.println("Conectou!!");
		Statement statement = conn.createStatement() ;
        String criaTabela = "CREATE TABLE IF NOT EXISTS TAREFAS ("
        		+ "id INT AUTO_INCREMENT NOT NULL ,"
        		+ "nome VARCHAR(50),"
        		+ "PRIMARY KEY (id))"
        		 ;
        
        
        statement.execute(criaTabela);
		conn.close();
	}
}
