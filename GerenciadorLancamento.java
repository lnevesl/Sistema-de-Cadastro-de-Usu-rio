package br.com.fuctura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GerenciadorLancamento {

	public void inserir(Lancamento lancamento) throws SQLException {
		FabricaDeConexao fabricaDeConexao = new FabricaDeConexao();
		Connection conexao = fabricaDeConexao.obterConexao();
		
		try {
			String sql = "INSERT INTO LANCAMENTO (NOME, VALOR) VALUES(?, ?)";

			PreparedStatement pst = conexao.prepareStatement(sql);

			pst.setString(1, lancamento.getNome());
			pst.setDouble(2, lancamento.getValor());

			if (lancamento.getNome() != null) {
				pst.setString(1, lancamento.getNome());
			}

			pst.execute();

			System.out.println("Dados inseridos com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro executando comando no banco: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			conexao.close();
		}
	}

}
