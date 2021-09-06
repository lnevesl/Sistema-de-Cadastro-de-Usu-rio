package br.com.fuctura;

import javax.swing.JOptionPane;

public class MenuUsuario {

	public void exibirCabecalho() {
		System.out.println("***Menu***");
		System.out.println("1 - Cadastrar ");
		System.out.println("2 - Listar Todos ");
		System.out.println("3 - Sair ");
	}

	public void exibirSubmenu() {
		System.out.println("***Menu***");
		System.out.println("1 - Usuario ");
		System.out.println("2 - Lancamento ");
		System.out.println("3 - Tipo ");
	}

	public Usuario cadastrar() {
		// pedir pra o usuário digitar os dados
		String nome = JOptionPane.showInputDialog("Digite seu nome:");
		String idade = JOptionPane.showInputDialog("Digite sua idade:");
		String altura = JOptionPane.showInputDialog("Digite sua altura:");
		String email = JOptionPane.showInputDialog("Digite seu email:");
		String sexo = JOptionPane.showInputDialog("Digite seu sexo:");

		Usuario user = new Usuario(nome, Integer.valueOf(idade), email, Double.valueOf(altura), sexo);
		return user;
	}

	public void exibirSubMenuTipo() {
		System.out.println("***Menu***");
		System.out.println("1 - Cadastrar ");
		System.out.println("2 - Editar ");
		System.out.println("3 - Excluir ");
	}
	
	public Tipo cadastrarTipo() {
		// pedir pra o usuário digitar os dados
		String nome = JOptionPane.showInputDialog("Digite Despesa ou Receita: ");


		Tipo user = new Tipo(nome);
		return user;
	}
	
	
	
//	public Tipo CadastrarNome() {
//		// pedir pra o usu�rio digitar os dados
//		//@SuppressWarnings("unused")
//		String nome = JOptionPane.showInputDialog("Digite Despesa ou Receita: ");
//		int id = 
//
//		Tipo userTipo = new Tipo(Integer.valueOf(id), nome);
//		
//		
//		return userTipo;
//	}
	
	
	
	
}
