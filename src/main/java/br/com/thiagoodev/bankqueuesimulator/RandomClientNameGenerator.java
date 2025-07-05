package br.com.thiagoodev.bankqueuesimulator;

public class RandomClientNameGenerator {
    private final String[] firstNames = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
    private final String[] lastNames = {"Smith", "Jones", "Williams", "Brown", "Davis"};

    public String generate() {
        return selectRandomName(firstNames) + " " + selectRandomName(lastNames);
    }

    private String selectRandomName(String[] names) {
        return names[new java.util.Random().nextInt(names.length)];
    }
}
