package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Tarefa {

    private Integer id;
    private String titulo;
    private String status;
    private LocalDate data;

    public Tarefa() {

    }

    public Tarefa(Integer id, String titulo, String status, LocalDate data) {
        this.id = id;
        this.titulo = titulo;
        this.status = status;
        this.data = data;
        }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Título: " + titulo +
                " | Status: " + status +
                " | Data: " + data;
    }
}
