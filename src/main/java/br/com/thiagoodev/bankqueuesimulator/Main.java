package br.com.thiagoodev.bankqueuesimulator;

public class Main {
    public static void main(String[] args) {
        final ClientBuilder clientBuilder = new ClientBuilder();
        final ClientSchedulerGenerator clientSchedulerGenerator = new ClientSchedulerGenerator(clientBuilder);

        System.out.println("Simulador de Fila de Banco iniciado!");
        clientSchedulerGenerator.listen();
    }
}
