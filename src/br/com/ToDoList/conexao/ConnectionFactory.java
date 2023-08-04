package br.com.ToDoList.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class ConnectionFactory {

	private Connection conn ;
	private PreparedStatement preparedStatement ; 

	public ConnectionFactory() throws SQLException {
		
		String Conexao = "jdbc:mysql://localhost/todolist?useTimezone=true&serverTimezone=UTC" ;
		String usuario = "root";
		String senha = "0910";
		conn = DriverManager.getConnection(Conexao,usuario,senha);
		
        
    }


	public void CloseDB() throws SQLException {
		conn.close();
	
	}
	
	public void CreateTable() throws SQLException {
		
		try(
			PreparedStatement  preparedStatement = conn.prepareStatement("CREATE TABLE IF NOT EXISTS tasks("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,  "
					+ "task VARCHAR(255) NOT NULL, "
					+ "description TEXT, "
					+ "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
					+ "due_data DATE,"
					+ "status VARCHAR(80) DEFAULT 'por fazer')")){
		
			conn.setAutoCommit(false);
			preparedStatement.execute();
			
			conn.commit();
			
			
			
		}catch (SQLException e) {
			System.out.println("erro ao criar a tabela" + e.getMessage());
			System.out.println("ROLLBACK EXECUTADO");
			conn.rollback();
		}
		
	}
		public void  InsertIntoTable(String task , String description , String due_data , String status) throws SQLException{
			
			try(
					PreparedStatement  preparedStatement = conn.prepareStatement("INSERT INTO tasks "
							+ "(task , description , due_data, status) VALUES (? , ? , ? , ?)"))
			{
//				preparedStatement = conn.prepareStatement("INSERT INTO tasks (task , description , due_data, status) VALUES (? , ? , ? , ?)");
				conn.setAutoCommit(false);
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
			try(ResultSet resultSet = preparedStatement.getResultSet();){
				System.out.println("=======================================================================================");
		        System.out.println("ID   | Tarefa                  | Descrição               | Data para terminar | Status");
		        System.out.println("=======================================================================================");

		        while (resultSet.next()) {
		            Integer id = resultSet.getInt("id");
		            String task = resultSet.getString("task");
		            String description = resultSet.getString("description");
		            String createdAt= resultSet.getString("created_at");
		            String due_data = resultSet.getString("due_data");
		            String status = resultSet.getString("status");
		            
		            
		            System.out.printf("%-5s| %-23s| %-25s| %-19s| %-8s%n", id, task, description, due_data, status);
		           
						
				
			}
			
		        System.out.println("=".repeat(87));
		}
		
		

	}
		
		public void DeleteTable(int id ) throws SQLException {
			
			try( PreparedStatement  preparedStatement = conn.prepareStatement("DELETE FROM tasks WHERE id = ?")){
				conn.setAutoCommit(false);
				preparedStatement.setInt(1, id);
				preparedStatement.executeUpdate();
				conn.commit();
				System.out.println("Tarefa com id " + id +" Deletada com sucesso" );
				
			}catch (SQLException e) {
				System.out.println("erro ao deletar a tabela" + e.getMessage());
				System.out.println("ROLLBACK EXECUTADO");
				conn.rollback();
			}
		}


		
		public void  UpdateTable(String task , String description , String due_data , String status,int id ) throws SQLException{
			
			try(
					PreparedStatement  preparedStatement = conn.prepareStatement("UPDATE tasks SET task = ? , description = ? , due_data = ? , status = ? WHERE id = ?"))
			{
//				preparedStatement = conn.prepareStatement("INSERT INTO tasks (task , description , due_data, status) VALUES (? , ? , ? , ?)");
				conn.setAutoCommit(false);
				preparedStatement.setString(1,task);
				preparedStatement.setString(2,description);
				preparedStatement.setString(3,due_data);
				preparedStatement.setString(4,status);
				preparedStatement.setInt(5,id);
				preparedStatement.executeUpdate();
				conn.commit();
				
			}catch (SQLException e) {
				System.out.println("erro ao editar a tabela" + e.getMessage());
				System.out.println("ROLLBACK EXECUTADO");
				conn.rollback();
			}
			
		}
		
		public boolean isIDAlreadyExists(int id )throws SQLException {
			
			try (PreparedStatement preparedStatement = conn.prepareStatement("SELECT id FROM tasks WHERE id = ?")) {
		        preparedStatement.setInt(1, id);
		        try (ResultSet resultSet = preparedStatement.executeQuery()) {
		            return resultSet.next(); 
		        }
		    }
		}
		
}	

//"jdbc:mysql://localhost/todolist?useTimezone=true&serverTimezone=UTC","root","0910"