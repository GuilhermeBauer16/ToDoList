package br.com.ToDoList.main;
import java.sql.SQLException;
import br.com.ToDoList.functions.CriaParametro;
import br.com.ToDoList.conexao.testaConexao;
class main {
	
	public static void main(String[] args) throws SQLException {
		CriaParametro criaParametro = new CriaParametro();
        System.out.println("Hello world!");
        testaConexao testaConexao = new testaConexao();
        testaConexao.conecta();
        String nome = criaParametro.CriaString("Nome: ");
        System.out.println(nome);
   
    }

}
