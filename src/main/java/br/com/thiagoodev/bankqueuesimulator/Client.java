package br.com.thiagoodev.bankqueuesimulator;

import java.time.LocalDateTime;
import java.util.UUID;

public class Client {
    private final String id;
    private final String name;
    private final LocalDateTime arrivedAt;
    private LocalDateTime finishedAt;

    public Client(String name) {
      this.id = UUID.randomUUID().toString();
      this.name = name;
      this.arrivedAt = LocalDateTime.now();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public LocalDateTime getArrivedAt() { return arrivedAt; }
    public LocalDateTime getFinishedAt() { return arrivedAt; }

    public void finished() {
        this.finishedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", arrivedAt=" + arrivedAt +
                ", finishedAt=" + finishedAt +
                '}';
    }
}
