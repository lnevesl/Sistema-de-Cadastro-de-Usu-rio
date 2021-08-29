package Controle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import Entidade.Usuario;

public class Menu{

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

    String USUARIO = "system";
    String SENHA = "123";
    String HOST = "localhost"; //MUDAR PARA: localhost

    
    Connection conexao = DriverManager.getConnection("jdbc:oracle:thin:@" + HOST + ":1521:xe", USUARIO, SENHA);

    Usuario u = new Usuario();
    Scanner scan = new Scanner(System.in);
    
	boolean sair = true;
	
	do {
		System.out.println("==========================================================");
		System.out.println("================  Cadastro de Usuários  ==================");
		System.out.println("==========================================================");
		System.out.println("=======================   MENU  ==========================");
		System.out.println(" [1] - Cadastrar");
		System.out.println(" [2] - Listar");
		System.out.println(" [3] - Sair");
		System.out.println(" ---------------------------------------------------------");
		String operacao = scan.next();
	

		switch (operacao) {
		case "1": //Cadastrar Usuário
			System.out.println( "Nome: ");
			u.setNome(scan.next());
			System.out.println("Idade: ");
			u.setIdade(scan.nextInt());
			System.out.println("Altura: ");
			u.setAltura(scan.nextDouble());
			System.out.println("Email: ");
			u.setEmail(scan.next());
		
			break;
		case "2": //Listar Usuários
			System.out.println("Lista dos Usuários.");
			u.Listar(scan.nextInt());
					
			break;
		case "3": // sair do programa
			sair = true;
			System.out.println("Até logo");
			break;
		default: // caso nenhuma das operações 
			System.out.println("Operação Inválida. Informe umas das Opções.");
		
		}
	} while (sair);
	scan.close();
}
}
