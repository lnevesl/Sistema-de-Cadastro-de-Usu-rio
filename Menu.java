package Controle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import Entidade.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Entidade.Lancamento;


public class Menu{

//conectar com banco de dados.
	
	//@SuppressWarnings("unused")
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

	    String USUARIO = "system";
	    String SENHA = "123";
	    String HOST = "localhost"; //MUDAR PARA: localhost

	   Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection conexao = DriverManager.getConnection("jdbc:oracle:thin:@" + HOST + ":1521:xe", USUARIO, SENHA);

	    System.out.println("Conectado com sucesso!");
	}
	    
	    
	    public static void menu() {
		System.out.println("==========================================================");
		System.out.println("================  SISTEMA DE CADASTRO    =================");
		System.out.println("----------------------------------------------------------");
		System.out.println("=======================   MENU  ==========================");
		System.out.println(" 1 - Cadastro Cliente   ");
		System.out.println(" 2 - Pesquisar  ");
		System.out.println(" 3 - Sair  ");
		System.out.println(" --------------------  Digite uma das Opções -------------");
	    
	    
    
public static void main () {
		
		String opcao = "0";

		Scanner ler = new Scanner(System.in);

		menu();

		opcao = ler.nextLine();

		while (!opcao.equals("3")) {
			switch (opcao) {
			case "1":
				cadastrar(ler);
				break;
			case "2":
				Listar(ler);
				break;
			case "3":
				sair(ler);
				break;
			default:
				System.out.println("Opção inválida, tente novamente.");
			}

			menu();
			opcao = ler.nextLine();
}
		

	
}


	private static void cadastrar(Scanner ler) {
		 Connection conexao; 
		 String nome; 
		 int idade; 
		 double altura; 
		 String email;
		 double valor;
		 String lancamento;
		
        // Vamos executar um comando de DML para inserir um registro na tabela de
        // Usuário
        String sql = "INSERT INTO USUARIO (NOME, IDADE, ALTURA, EMAIL) VALUES (?, ?, ?, ?)";
        String sql1 = "INSERT INTO LANCAMENTO (DESCRICAO, VALOR) VALUES (?, ?)";
        // 1
        PreparedStatement ps = conexao.prepareStatement(sql);
        PreparedStatement ps1 = conexao.prepareStatement(sql1);
//       
        // Prepara a instrução SQL
       
		System.out.println("----------------------------------------------------------");
		System.out.println("================ CADASTRO DE CLIENTES ====================");

		System.out.print("Nome: ");
		ps.setString(1, nome);
		System.out.print("Idade:  ");
		ps.setInt(2, idade);
		System.out.print("Altura:  ");
		ps.setDouble(3, altura);
		System.out.print("Email:  ");
		ps.setString(4, email);
		System.out.print("---------------------------------- ");
		System.out.print("----- Lançamento de Produto -------");
		System.out.print("Produto: ");
		ps1.setString(1, lancamento);
		System.out.print("Valor: ");
		ps1.setDouble(2, valor);
		System.out.print("\nCadastro realizado com sucesso!  ");
		
		  // Executa a instrução SQL
        ps.execute();
        ps.close();
        conexao.close(); // liberando a conexão

        } 
	private static void Listar(Scanner ler) {
	Connection conexao;
	   
			    String sql = "SELECT * FROM USUARIO";
			    // 1
			    // Prepara a instrução SQL
			    PreparedStatement ps = conexao.prepareStatement(sql);
			     
			    ResultSet resultadoDoSQL = ps.executeQuery();
			     
			    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			    Usuario usu = new Usuario();
			    //    1 2   3 4
			    //nome, idade, altura, email
			    while(resultadoDoSQL.next()) {
			    String nome = resultadoDoSQL.getString(1);
			    int idade = resultadoDoSQL.getInt(2);
			    double altura = resultadoDoSQL.getDouble(3);
			    String email = resultadoDoSQL.getString(4);
			     
			    System.out.println("Nome = " + nome);
			    System.out.println("Idade = " + idade);
			    System.out.println("Altura = " + altura);
			    System.out.println("Email = " + email);
			     
			    usu.setNome(nome);
			    usu.setIdade(idade);
			    usu.setAltura(altura);
			    usu.setEmail(email);
			     
			    usuarios.add(usu);
			     
			    System.out.println("*******************************");
			    }
			     
			    menu();
				
	 
		
	}
	private static void sair(Scanner ler) {
	// TODO Auto-generated method stub
	
}
}
  
   





/*public class Menu{

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
}*/


