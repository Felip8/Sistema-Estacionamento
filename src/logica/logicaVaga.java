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
        
        System.out.println("Tamanho da vaga: [1]Pequeno [2]M�dio [3]Grande");
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

                // Definindo o hor�rio de entrada do ve�culo ao ocupar a vaga
                veiculo.setHoraEntrada(LocalTime.now());
                return;
            }
        }
        System.out.println("Tamanho da vaga n�o condiz com o tamanho do carro ou n�o h� vagas dispon�veis.");
    }

    public static void desocuparVaga(int idNumeroVaga) {
        for (Vaga vaga : listaDeVaga) {
            if(vaga.getidNumeroVaga() == idNumeroVaga) {
                vaga.setDisponibilidade(true);
            }
        }
    }

    public static void numeroSaidaVeiculo() {
        System.out.println("Escolha o n�mero da vaga para sa�da: ");
        int nVaga = app.Main.sc().nextInt();
        logica.logicaVaga.desocuparVaga(nVaga);
        app.Main.sc().nextLine();
    }

    public static void horaSaidaLogica() {
        System.out.println("Hor�rio de sa�da: ");
        LocalTime horasaida = LocalTime.parse(app.Main.sc().nextLine(), dtf);
        veiculo.setHoraSaida(horasaida);
        double valorAPagar = logica.logicaVaga.matematicaDaSaidaDeCarro(veiculo);
        System.out.printf("Pre�o a pagar: R$ %.2f%n", valorAPagar);
    }

    public static double matematicaDaSaidaDeCarro(Veiculo veiculo) {
        LocalTime horaEntrada = veiculo.getHoraEntrada();
        LocalTime horaSaida = veiculo.getHoraSaida();

        // Valida��o para garantir que horaEntrada e horaSaida n�o sejam nulos
        if (horaEntrada == null || horaSaida == null) {
            System.out.println("Erro: hor�rio de entrada ou sa�da n�o foi definido.");
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
