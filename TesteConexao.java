package Controle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidade.Usuario;

public class TesteConexao{

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

    String USUARIO = "system";
    String SENHA = "123";
    String HOST = "localhost"; //MUDAR PARA: localhost

    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection conexao = DriverManager.getConnection("jdbc:oracle:thin:@" + HOST + ":1521:xe", USUARIO, SENHA);

    System.out.println("Conectado com sucesso!");

    inserir(conexao, "fatima", 15, 1.70, HOST);
    //inserir(conexao, "Thanos", 50, 2.75, HOST);
    System.out.println("Registro Inserido Com Sucesso!");
     
    listarTodos(conexao);
     
    conexao.close(); // liberando a conexão

    }

    public static void inserir(Connection conexao, String nome, int idade, double altura, String email) throws SQLException {
    // Vamos executar um comando de DML para inserir um registro na tabela de
    // Usuário
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
    
   public static ArrayList<Usuario> listarTodos(Connection conexao) throws SQLException {
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
}

