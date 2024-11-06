package logica;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import objetos.Veiculo;

public class logicaVeiculo {
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
	static List<Veiculo>listaDeVeiculo = new ArrayList <Veiculo>();
	
	public static void cadastroVeiculo() {
		Veiculo veiculo = new Veiculo();
		int id = listaDeVeiculo.size() + 1;
		veiculo.setIdCarro(id);
		
		LocalTime horaEntrada;
		
		System.out.println("Entre com a placa: ");
		veiculo.setPlacaCarro(app.Main.sc().nextLine());
		
		System.out.println("Entre com o modelo: ");
		veiculo.setModeloCarro(app.Main.sc().nextLine());
		
		System.out.println("**O tamanho do carro deve ser compatível com o tamanho da vaga**");
		System.out.println("Entre com o tamanho do carro: [1]Pequeno [2]Médio [3]Grande");
		int nTamanhoCarro = app.Main.sc().nextInt();
		app.Main.sc().nextLine();
		veiculo.setTamanhoCarro(nTamanhoCarro);
		logica.logicaVaga.ocuparVaga(nTamanhoCarro);
		
		System.out.println("Hora de Entrada: ");
		horaEntrada = LocalTime.parse(app.Main.sc().nextLine(), dtf);
		veiculo.setHoraEntrada(horaEntrada);
		listaDeVeiculo.add(veiculo);
	}
	
	public static void listarVeiculo() {
		if(listaDeVeiculo.isEmpty()) {
			System.out.println("Lista vazia!");
		}
		for (Veiculo veiculo : listaDeVeiculo) {
			System.out.println(veiculo.toString());
		}
	}

}
