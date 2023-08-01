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
	        	
	            String tarefa= createParameter.CreateString("tarefa: ");
	            String descricao = createParameter.CreateString("descrição: ");
	            String data = createParameter.CreateString("data(AAAA/MM/DD: ");
	            String status = createParameter.CreateString("status: ");
	            connectionFactory.InsertIntoTable(tarefa,descricao,data,status);
	            
	        }else if (option == 2 ) {
	        	connectionFactory.SelectTables();
        
	        }else if (option == 3) {
	        	
	        }else if (option == 4) {
	        	
	        }else if (option == 5) {
	        	
	        	System.out.println("Saindo...");
	        	Thread.sleep(1000);
	        	connectionFactory.CloseDB();
	        	break;
	        }

}
}
}       