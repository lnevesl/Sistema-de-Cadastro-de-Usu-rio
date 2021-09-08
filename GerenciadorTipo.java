package br.com.fuctura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GerenciadorTipo {

	public static void inserir(Tipo tipo) throws SQLException {
		FabricaDeConexao fabricaDeConexao = new FabricaDeConexao();
		Connection conexao = fabricaDeConexao.obterConexao();
		
		try {
			String sql = "INSERT INTO TIPO (NOME) VALUES(?)";

			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, tipo.getNome());
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

	public void alterar() {

	}

	public void exluir() {

	}



	

}
