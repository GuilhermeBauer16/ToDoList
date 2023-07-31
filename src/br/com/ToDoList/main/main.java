package br.com.ToDoList.main;

import java.sql.SQLException;


import br.com.ToDoList.conexao.testaConexao;
class main {
	
	public static void main(String[] args) throws SQLException {
        System.out.println("Hello world!");
        testaConexao testaConexao = new testaConexao();
        testaConexao.conecta();
   
    }

}
