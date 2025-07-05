package br.com.thiagoodev.bankqueuesimulator;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final RandomClientNameGenerator clientNameGenerator = new RandomClientNameGenerator();
    private static final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private static final LinkedBlockingQueue<Client> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        System.out.println("Simulador de Fila de Banco iniciado!");

        executor.scheduleAtFixedRate(() -> {
            try {
                final Client client = new Client(clientNameGenerator.generate());
                queue.add(client);
                System.out.println(">>> Cliente " +
                        client.getName() +
                        " chegou à fila. Fila agora com " +
                        queue.size() + " clientes.");
            } catch (Exception error) {
                Thread.currentThread().interrupt();
                System.err.println("Erro ao gerar cliente: " + error.getMessage());
            }
        }, 0 , 2, TimeUnit.SECONDS);

        try {
            while(true) {
                final int queueSize = queue.size();
                final String nextClientName = queue.peek() != null ? queue.peek().getName() : "Nenhum";

                System.out.println("-------------------------------------");
                System.out.println("Clientes na fila: " + queueSize);
                System.out.println("Próximo cliente na fila: " + nextClientName);
                System.out.println("-------------------------------------");
                Thread.sleep(2000);
            }
        } catch (Exception error) {
            Thread.currentThread().interrupt();
            System.out.println("Simulador de Fila interrompido.");
        } finally {
            if(!executor.isShutdown()) {
                executor.shutdown();
                try {
                    if(!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                        executor.shutdownNow();
                        System.err.println("Gerador de clientes forçado a desligar.");
                    }
                } catch (Exception error) {
                    executor.shutdownNow();
                    Thread.currentThread().interrupt();
                    System.err.println("Desligamento do gerador de clientes interrompido.");
                }

                System.out.println("Simulador de Fila de Banco parado.");
            }
        }
    }
}
