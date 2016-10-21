package com.example.aske.multiconsole.ui.model;

/**
 * Created by abasurto on 20/10/2016.
 */

public class VideogameModel {
    private int id;
    private String screeshot;
    private String titulo;
    private String descripcion;

    public VideogameModel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String title) {
        this.titulo = title;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String description) {
        this.descripcion = description;
    }

    public String getScreeshot() {
        return screeshot;
    }

    public void setScreeshot(String screeshot) {
        this.screeshot = screeshot;
    }
}
