package br.com.ToDoList.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	
	private Statement statement;
	private Connection conn ;

	public ConnectionFactory() throws SQLException {
		
		String Conexao = "jdbc:mysql://localhost/todolist?useTimezone=true&serverTimezone=UTC" ;
		String usuario = "root";
		String senha = "0910";
		conn = DriverManager.getConnection(Conexao,usuario,senha);
		System.out.println("Conectou!!");
		
	}
	
	public void FechaDB() throws SQLException {
		conn.close();
	
	}
}
//"jdbc:mysql://localhost/todolist?useTimezone=true&serverTimezone=UTC","root","0910"