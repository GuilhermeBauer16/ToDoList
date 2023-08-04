package br.com.ToDoList.main;

import java.sql.SQLException; 
import br.com.ToDoList.functions.CreateParameter;
import br.com.ToDoList.conexao.ConnectionFactory;
class main {
	
	public static void main(String[] args) throws SQLException, InterruptedException {

		CreateParameter createParameter = new CreateParameter();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        
        connectionFactory.CreateTable();
     
        while (true) {
	        System.out.println(createParameter.title("Lista de tarefas", 30));
	        System.out.println("[1]Nova tarefa");
	        System.out.println("[2]Ver suas tarefas");
	        System.out.println("[3]Deletar tarefas");
	        System.out.println("[4]Editar tarefas");
	        System.out.println("[5]Sair");
	        System.out.println(createParameter.line(30));
	        int option = createParameter.CreateInt("sua opção: ");
	        
	        if (option == 1) {
	        	System.out.println(createParameter.title("Nova tarefa ", 30));
	            String task = createParameter.CreateString("tarefa: ").replace(" ", "_").trim();
	            String description = createParameter.CreateString("descrição: ").replace(" ", "_").trim();
	            String data = createParameter.CreateString("Data para terminar(AAAA/MM/DD): ").replace(" ", "_").trim();
	            String status = createParameter.CreateString("status: ").replace(" ", "_").trim();
	            connectionFactory.InsertIntoTable(task,description,data,status);
	            
	        }else if (option == 2 ) {
	        	System.out.println(createParameter.title("Suas tarefas ", 30));
	        	connectionFactory.SelectTables();
        
	        }else if (option == 3) {
	        	
	        	System.out.println(createParameter.title("Deletar tarefas ", 30));
	        	connectionFactory.SelectTables();
	        	int deletedId = createParameter.CreateInt("Imforme o ID da tabela que deseja deletar: ");
	        	connectionFactory.DeleteTable(deletedId);
	        	
	        }else if (option == 4) {
	           System.out.println(createParameter.title("Edição de tarefas ", 30));
	           int UpdateId = createParameter.CreateInt("Imforme o ID para editar a tarefa: ");
	           if (!connectionFactory.isIDAlreadyExists(UpdateId)) {
	        	        System.out.println("ID não encontrado na tabela.");
	        	    }else {
	        	
			        	String newTask = createParameter.CreateString("tarefa: ").replace(" ", "_");
			            String newDescription = createParameter.CreateString("descrição: ").replace(" ", "_");
			            String newData = createParameter.CreateString("Data para terminar(AAAA/MM/DD): ");
			            String newStatus = createParameter.CreateString("status: ").replace(" ", "_");
			            connectionFactory.UpdateTable(newTask, newDescription, newData, newStatus,UpdateId);
	        	    }
	        }else if (option == 5) {
	        	
	        	System.out.println("Saindo...");
	        	Thread.sleep(1000);
	        	connectionFactory.CloseDB();
	        	break;
	        }

}
}
}       