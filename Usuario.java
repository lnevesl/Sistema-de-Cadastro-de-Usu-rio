package br.com.fuctura;

public class Usuario {

	private String nome;
	private String email;
	private int idade;
	private double altura;
	private String sexo;

	public Usuario(String nome, int idade, String email, double altura,  String sexo) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.altura = altura;
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}

	