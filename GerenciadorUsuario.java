package br.com.fuctura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GerenciadorUsuario {

	public void inserir(Usuario usu, Usuario resultado) throws SQLException {
		FabricaDeConexao fabricaDeConexao = new FabricaDeConexao();
		Connection conexao = fabricaDeConexao.obterConexao();
		
		// 1 2 3 4
		String sql = "INSERT INTO USUARIO (NOME, IDADE, ALTURA, EMAIL, SEXO) VALUES(?, ?, ?, ?, ?)";

		PreparedStatement pst = conexao.prepareStatement(sql);

		try {
			pst.setString(1, usu.getNome());
			pst.setInt(2, usu.getIdade());
			pst.setDouble(3, usu.getAltura());
			pst.setString(4, usu.getEmail());
			pst.setString(5, usu.getSexo());

			if (usu.getNome() != null) {
				pst.setString(1, usu.getNome());
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

	public void excluir() {

	}

	public void atualizar() {

	}

}
