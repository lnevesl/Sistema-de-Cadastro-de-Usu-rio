package Entidade;

public class Lancamento extends Entidade.Tipo {

// ATRIBUTOS DA CONTA
	
		private String descricao;
		private int valor;
		
		
// Get and Set	
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public int getValor() {
			return valor;
		}
		public void setValor(int valor) {
			this.valor = valor;
		}

		

}
