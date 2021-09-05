package br.com.fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {

	String USUARIO = "System";
	String SENHA = "123";

	
	public Connection obterConexao() throws SQLException {
		Connection conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", USUARIO, SENHA);
		System.out.println("Conectado com sucesso!");
		return conexao;
	}

	
}
