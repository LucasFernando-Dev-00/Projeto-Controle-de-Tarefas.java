package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Tarefa {

    private String titulo;
    private String status;
    private LocalDateTime data;

    public Tarefa() {

    }

    public Tarefa(String titulo, String status, LocalDateTime data) {

        this.titulo = titulo;
        this.status = status;
        this.data = data;
        }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
