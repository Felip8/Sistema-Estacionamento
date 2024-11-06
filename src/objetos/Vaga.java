package objetos;

public class Vaga {

	private int idNumeroVaga;
	private int tamanhoVaga;
	private boolean disponibilidade;
	
	public Vaga() {
		
	}
	
	public Vaga(int idNumeroVaga, int tamanhoVaga, boolean disponibilidade) {
		this.idNumeroVaga = idNumeroVaga;
		this.tamanhoVaga = tamanhoVaga;
		this.disponibilidade = disponibilidade;
	}
	
	public int getidNumeroVaga() {
		return idNumeroVaga;
	}
	public void setidNumeroVaga(int numeroVaga) {
		this.idNumeroVaga = numeroVaga;
	}
	public int getTamanhoVaga() {
		return tamanhoVaga;
	}
	public void setTamanhoVaga(int tamanhoVaga) {
		this.tamanhoVaga = tamanhoVaga;
	}
	public boolean isDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	@Override
	public String toString() {
		return "Vaga [numeroVaga=" + idNumeroVaga + ", tamanhoVaga=" + tamanhoVaga + ", disponibilidade="
				+ disponibilidade + "]";
	}
	
	
	
	
}
