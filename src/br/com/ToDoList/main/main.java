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
	        int option = createParameter.CreateInt("\u001B[0msua opção: ");
	        
	        if (option == 1) {
	        	
	            String task = createParameter.CreateString("tarefa: ");
	            String description = createParameter.CreateString("descrição: ");
	            String data = createParameter.CreateString("data(AAAA/MM/DD: ");
	            String status = createParameter.CreateString("status: ");
	            connectionFactory.InsertIntoTable(task,description,data,status);
	            
	        }else if (option == 2 ) {
	        	connectionFactory.SelectTables();
        
	        }else if (option == 3) {
	        	connectionFactory.SelectTables();
	        	int deletedId = createParameter.CreateInt("Imforme o ID da tabela que deseja deletar: ");
	        	connectionFactory.DeleteTable(deletedId);
	        	
	        }else if (option == 4) {
	        	
	           int UpdateId = createParameter.CreateInt("Imforme o ID para editar a tarefa: ");
	           if (!connectionFactory.isIDAlreadyExists(UpdateId)) {
	        	        System.out.println("ID não encontrado na tabela.");
	        	    }else {
	        	
			        	String newTask = createParameter.CreateString("tarefa: ");
			            String newDescription = createParameter.CreateString("descrição: ");
			            String newData = createParameter.CreateString("data(AAAA/MM/DD: ");
			            String newStatus = createParameter.CreateString("status: ");
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