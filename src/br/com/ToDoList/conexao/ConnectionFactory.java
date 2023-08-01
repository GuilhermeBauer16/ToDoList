package br.com.ToDoList.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	
	private Statement statement;
	private Connection conn ;
	private PreparedStatement preparedStatement ; 

	public ConnectionFactory() throws SQLException {
		
		String Conexao = "jdbc:mysql://localhost/todolist?useTimezone=true&serverTimezone=UTC" ;
		String usuario = "root";
		String senha = "0910";
		conn = DriverManager.getConnection(Conexao,usuario,senha);
		System.out.println("Conectou!!");
		
	}
	
	public void CloseDB() throws SQLException {
		conn.close();
	
	}
	
	public void CreateTable() throws SQLException {
		
		try {
			statement = conn.createStatement();
			
			String CreateTable = "CREATE TABLE IF NOT EXISTS tasks("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,  "
					+ "task VARCHAR(255) NOT NULL, "
					+ "description TEXT, "
					+ "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
					+ "due_data DATE,"
					+ "status VARCHAR(80) DEFAULT 'por fazer')";
			
			statement.execute(CreateTable);
			
			
			
		} catch (SQLException e) {
			System.out.println("erro ao criar a tabela" + e.getMessage());
		}
	}
		public void  InsertIntoTable(String task , String description , String due_data , String status) throws SQLException{
			
			try {
				conn.setAutoCommit(false);
				preparedStatement = conn.prepareStatement("INSERT INTO tasks (task , description , due_data, status) VALUES (? , ? , ? , ?)");
				preparedStatement.setString(1,task);
				preparedStatement.setString(2,description);
				preparedStatement.setString(3,due_data);
				preparedStatement.setString(4,status);
				preparedStatement.execute();
				conn.commit();
				
			}catch (SQLException e) {
				System.out.println("erro ao criar a tabela" + e.getMessage());
				System.out.println("ROLLBACK EXECUTADO");
				conn.rollback();
			}
			
		}
		
		
		public void SelectTables() throws SQLException {
			preparedStatement = conn.prepareStatement("SELECT * FROM tasks");
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getResultSet();
			while(resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String task = resultSet.getString("task");
				String description = resultSet.getString("description");
				String created_at = resultSet.getString("created_at");
				String due_data = resultSet.getString("due_data");
				String status = resultSet.getString("status");
				System.out.println("id: " + + id );
				System.out.println("tarefa "+ task );
				System.out.println( "Descricão "+ description );
				System.out.println(" data para terminar " + due_data  );
				System.out.println(" status " + status );
				System.out.println();
						
						    
				
				
				
			}
			
		}
		
		

	}
	
	

//"jdbc:mysql://localhost/todolist?useTimezone=true&serverTimezone=UTC","root","0910"