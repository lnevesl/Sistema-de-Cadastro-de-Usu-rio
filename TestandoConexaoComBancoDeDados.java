package br.com.fuctura;

import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TestandoConexaoComBancoDeDados {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		FabricaDeConexao fabricaDeConexao = new FabricaDeConexao();

		Connection conexao = fabricaDeConexao.obterConexao();

		GerenciadorUsuario gerenciadorUsuario = new GerenciadorUsuario();
		GerenciadorLancamento gerenciadorLancamento = new GerenciadorLancamento();
		GerenciadorTipo gerenciadorTipo = new GerenciadorTipo();
		MenuUsuario menuUser = new MenuUsuario();
		// exibirSubMenuTipo menuUser1 = exibirSubMenuTipo();

		String opcaoEscolhida = "";

		while (!opcaoEscolhida.equals("5")) {

			menuUser.exibirCabecalho();

			opcaoEscolhida = JOptionPane.showInputDialog("Digite a opção escolhida: ");

			if (opcaoEscolhida.equals("1")) {

				menuUser.exibirSubmenu();

				opcaoEscolhida = JOptionPane.showInputDialog("Digite a opção escolhida: ");
				if (opcaoEscolhida.equals("1")) {
					Usuario user = menuUser.cadastrar();
					gerenciadorUsuario.inserir(conexao, user, user);
				} else if (opcaoEscolhida.equals("2")) {
					String nome = JOptionPane.showInputDialog("Digite o do lançamento: ");
					String valor = JOptionPane.showInputDialog("Digite o valor do lançamento: ");

					Lancamento lancamento = new Lancamento(nome, Double.valueOf(valor));
					gerenciadorLancamento.inserir(conexao, lancamento);
				}
			} else if (opcaoEscolhida.equals("3")) {
				
				menuUser.exibirSubMenuTipo();
				opcaoEscolhida = JOptionPane.showInputDialog("Digite a opção escolhida: ");

				if (opcaoEscolhida.equals("1")) {
					Tipo user = menuUser.cadastrarTipo();
					gerenciadorTipo.inserir(conexao, user);
				} else if (opcaoEscolhida.equals("2")) {
					JOptionPane.showInputDialog("Editar");
					// cirar editar				}
			} else if (opcaoEscolhida.equals("3")) {
				JOptionPane.showInputDialog("Excluir:");
				// cirar excluir
			}

//					
//		
		}
		conexao.close();
	}

}
}
