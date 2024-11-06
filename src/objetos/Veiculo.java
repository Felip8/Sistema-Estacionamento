package objetos;


import java.time.LocalTime;

public class Veiculo {
	
	private int idCarro;
	private String placaCarro;
	 private String modeloCarro;
	 private int tamanhoCarro;
	 private LocalTime horaEntrada;
	 private LocalTime horaSaida;
	 
	 public Veiculo() {
		 
	 }
	 
	 public Veiculo(String placaCarro, String modeloCarro, int tamanhoCarro, LocalTime horaEntrada, LocalTime horaSaida) {
		 this.placaCarro = placaCarro;
		 this.modeloCarro = modeloCarro;
		 this.tamanhoCarro = tamanhoCarro;
		 this.horaEntrada = horaEntrada;
		 this.horaSaida = horaSaida;
	 }
	 
	 public int getIdCarro() {
			return idCarro;
		}

		public void setIdCarro(int idCarro) {
			this.idCarro = idCarro;
		}

	 
	public String getPlacaCarro() {
		return placaCarro;
	}
	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}
	public String getModeloCarro() {
		return modeloCarro;
	}
	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}
	public int getTamanhoCarro() {
		return tamanhoCarro;
	}
	public void setTamanhoCarro(int tamanhoCarro) {
		this.tamanhoCarro = tamanhoCarro;
	}
	public LocalTime getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(LocalTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public LocalTime getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(LocalTime horaSaida) {
		this.horaSaida = horaSaida;
	}
	
	@Override
	public String toString() {
		return "Veiculo [placaCarro=" + placaCarro + ", modeloCarro=" + modeloCarro + ", tamanhoCarro=" + tamanhoCarro
				+ ", horaEntrada=" + horaEntrada + ", horaSaida=" + horaSaida + "]";
	}

	 

}
