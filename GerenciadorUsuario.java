package br.com.fuctura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GerenciadorUsuario {

	public void inserir(Connection conexao, Usuario usu, Usuario resultado) throws SQLException {
		// 1 2 3 4
		String sql = "INSERT INTO USUARIO (NOME, IDADE, ALTURA, EMAIL, SEXO) VALUES(?, ?, ?, ?, ?)";
		
		
		PreparedStatement pst = conexao.prepareStatement(sql);
		
		
		
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
	}

	public void excluir() {

	}

	public void atualizar() {

	}

}
