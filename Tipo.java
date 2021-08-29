package Entidade;

public class Tipo {
	
// ATRIBUTOS DA CONT
		
		private double desepesa;
		private double receita;
		
//CONSTRUTORES	
		
		public Tipo() {
		}

		public Tipo(double despesa, double receita) {
			super();
			this.desepesa = despesa;
			this.receita = receita;

			
		}
		
// GET AND SET	
		
		public double getDesepesa() {
			return desepesa;
		}
		public void setDesepesa(double desepesa) {
			this.desepesa = desepesa;
		}
		public double getReceita() {
			return receita;
		}
		public void setReceita(double receita) {
			this.receita = receita;
		}


}
