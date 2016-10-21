package com.example.aske.multiconsole.data.entities;

/**
 * Created by abasurto on 20/10/2016.
 */

public class Videogame {
    private int id;
    private String screenshot;
    private String titulo;
    private String descripcion;
    private String compañia;
    private String fecha;
    private String plataforma;

    public Videogame(){
    }

    public Videogame(String screenshot, String titulo, String descripcion){
        this.screenshot = screenshot;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCompañia() {
        return compañia;
    }

    public void setCompañia(String compañia) {
        this.compañia = compañia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
