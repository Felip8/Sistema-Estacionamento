package logica;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import objetos.Veiculo;
import objetos.Vaga;

public class logicaVaga {
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
    logicaVeiculo listaveiculo = new logicaVeiculo();
    static Veiculo veiculo = new Veiculo();
    static List<Vaga> listaDeVaga = new ArrayList<Vaga>();

    public static void cadastroVaga() {
        Vaga vaga = new Vaga();
        
        int id = listaDeVaga.size() + 1;
        vaga.setidNumeroVaga(id);
        
        System.out.println("Tamanho da vaga: [1]Pequeno [2]Médio [3]Grande");
        vaga.setTamanhoVaga(app.Main.sc().nextInt());
        app.Main.sc().nextLine();
        
        vaga.setDisponibilidade(true);
        listaDeVaga.add(vaga);
    }

    public static void listarVaga() {
        if(listaDeVaga.isEmpty()) {
            System.out.println("Lista vazia!");
        }
        
        for (Vaga vaga : listaDeVaga) {
            System.out.println(vaga.toString());
        }
    }

    public static void ocuparVaga(int tamanhoCarro) {
        for (Vaga vaga : listaDeVaga) {
            if(vaga.getTamanhoVaga() == tamanhoCarro && vaga.isDisponibilidade()) {
                vaga.setDisponibilidade(false);
                System.out.println("Vaga preenchida!");

                // Definindo o horário de entrada do veículo ao ocupar a vaga
                veiculo.setHoraEntrada(LocalTime.now());
                return;
            }
        }
        System.out.println("Tamanho da vaga não condiz com o tamanho do carro ou não há vagas disponíveis.");
    }

    public static void desocuparVaga(int idNumeroVaga) {
        for (Vaga vaga : listaDeVaga) {
            if(vaga.getidNumeroVaga() == idNumeroVaga) {
                vaga.setDisponibilidade(true);
            }
        }
    }

    public static void numeroSaidaVeiculo() {
        System.out.println("Escolha o número da vaga para saída: ");
        int nVaga = app.Main.sc().nextInt();
        logica.logicaVaga.desocuparVaga(nVaga);
        app.Main.sc().nextLine();
    }

    public static void horaSaidaLogica() {
        System.out.println("Horário de saída: ");
        LocalTime horasaida = LocalTime.parse(app.Main.sc().nextLine(), dtf);
        veiculo.setHoraSaida(horasaida);
        double valorAPagar = logica.logicaVaga.matematicaDaSaidaDeCarro(veiculo);
        System.out.printf("Preço a pagar: R$ %.2f%n", valorAPagar);
    }

    public static double matematicaDaSaidaDeCarro(Veiculo veiculo) {
        LocalTime horaEntrada = veiculo.getHoraEntrada();
        LocalTime horaSaida = veiculo.getHoraSaida();

        // Validação para garantir que horaEntrada e horaSaida não sejam nulos
        if (horaEntrada == null || horaSaida == null) {
            System.out.println("Erro: horário de entrada ou saída não foi definido.");
            return 0;
        }
        
        Duration duracao = Duration.between(horaEntrada, horaSaida);
        long horasPermanencia = duracao.toHours();

        double valor;
        if(horasPermanencia <= 1){
            valor = 5.00;
        } else if(horasPermanencia >= 2 && horasPermanencia <= 3) {
            valor = 10.00;
        } else {
            valor = 15.00;
        }

        System.out.printf("Valor a ser pago: R$ %.2f%n", valor);
        return valor;
    }
}
