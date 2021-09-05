package br.com.fuctura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GerenciadorLancamento {

	public void inserir(Connection conexao, Lancamento lancamento) throws SQLException {
		
		String sql = "INSERT INTO LANCAMENTO (NOME, VALOR) VALUES(?, ?)";

		PreparedStatement pst = conexao.prepareStatement(sql);

		pst.setString(1, lancamento.getNome());
		pst.setDouble(2, lancamento.getValor());

		if (lancamento.getNome() != null) {
			pst.setString(1, lancamento.getNome());
		}
		
		pst.execute();

		System.out.println("Dados inseridos com sucesso!");
	}

}
