package Entidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Usuario extends Entidade.Lancamento{

// ATRIBUTOS DO USUARIO
	
	private String nome;
	private int idade;
	private double altura;
	private String email;
	public Object set;
	

	
//CONSTRUTORES
	public Usuario() {
	}

	public Usuario( String nome, int idade, double altura, String email) {
		super();
		
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
		this.email = email;
					
	}
	
// METODOS 
	
	//CADASTRAR
	public void Cadastrar(Connection conexao, String nome, int idade, double altura, String email) throws SQLException {
	    // Vamos executar um comando de DML para inserir um registro na tabela de Usuário
	    String sql = "INSERT INTO USUARIO (NOME, IDADE, ALTURA, EMAIL) VALUES (?, ?, ?, ?)";
	    // 1
	    // Prepara a instrução SQL
	    PreparedStatement ps = conexao.prepareStatement(sql);

	    ps.setString(1, nome);
	    ps.setInt(2, idade);
	    ps.setDouble(3, altura);
	    ps.setString(4, email);

	    
	    
	    // Executa a instrução SQL
	    ps.execute();
	    ps.close();
	    }
	//LISTAR
	public void Listar(int nextInt){   }
	public ArrayList<Usuario> listarTodos(Connection conexao) throws SQLException {   
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
			     
			    return usuarios;
	 
		
	}

	
// GET AND SET	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	}
	