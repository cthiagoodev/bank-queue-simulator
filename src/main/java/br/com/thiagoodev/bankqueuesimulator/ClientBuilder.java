package br.com.thiagoodev.bankqueuesimulator;

public class ClientBuilder {
    private final RandomClientNameGenerator randomClientNameGenerator = new RandomClientNameGenerator();

    public Client build() {
        return new Client(randomClientNameGenerator.generate());
    }
}
