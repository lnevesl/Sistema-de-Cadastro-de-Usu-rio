package br.com.fuctura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GerenciadorTipo {

	public void inserir(Connection conexao, Tipo tipo) throws SQLException {
		String sql = "INSERT INTO TIPO (ID, NOME) VALUES(?, ?)";

		PreparedStatement pst = conexao.prepareStatement(sql);

		pst.setInt(1, tipo.getId());
		pst.setString(2, tipo.getNome());

		pst.execute();

		System.out.println("Dados inseridos com sucesso!");
	}

	public void alterar() {

	}

	public void exluir() {

	}



	

}
