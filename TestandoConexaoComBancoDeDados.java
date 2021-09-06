package br.com.fuctura;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class TestandoConexaoComBancoDeDados {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		GerenciadorUsuario gerenciadorUsuario = new GerenciadorUsuario();
		GerenciadorLancamento gerenciadorLancamento = new GerenciadorLancamento();
		GerenciadorTipo gerenciadorTipo = new GerenciadorTipo();
		MenuUsuario menuUser = new MenuUsuario();
		// exibirSubMenuTipo menuUser1 = exibirSubMenuTipo();

		String opcaoEscolhida = "";

		while (!opcaoEscolhida.equals("3")) {

			menuUser.exibirCabecalho();

			opcaoEscolhida = JOptionPane.showInputDialog("Digite a opção escolhida: ");

			if (opcaoEscolhida.equals("1")) {

				menuUser.exibirSubmenu();

				opcaoEscolhida = JOptionPane.showInputDialog("Digite a opção escolhida: ");
				if (opcaoEscolhida.equals("1")) {
					Usuario user = menuUser.cadastrar();
					gerenciadorUsuario.inserir(user, user);
				} else if (opcaoEscolhida.equals("2")) {
					String nome = JOptionPane.showInputDialog("Digite o do lançamento: ");
					String valor = JOptionPane.showInputDialog("Digite o valor do lançamento: ");

					Lancamento lancamento = new Lancamento(nome, Double.valueOf(valor));
					gerenciadorLancamento.inserir(lancamento);
				}
			} else if (opcaoEscolhida.equals("3")) {
				
				menuUser.exibirSubMenuTipo();
				opcaoEscolhida = JOptionPane.showInputDialog("Digite a opção escolhida: ");

				if (opcaoEscolhida.equals("1")) {
					Tipo user = menuUser.cadastrarTipo();
					gerenciadorTipo.inserir(user);
				} else if (opcaoEscolhida.equals("2")) {
					JOptionPane.showInputDialog("Editar");
					// cirar editar				}
			} else if (opcaoEscolhida.equals("3")) {
				JOptionPane.showInputDialog("Excluir:");
				// cirar excluir
			}
		}
	}

}
}
