/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author facac
 */
public class Sensor {
    
    private int id = 0;
    private float variavel = 0;
    private String data = null;
    private String hora = null;
     
    public Sensor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getVariavel() {
        return variavel;
    }

    public void setVariavel(float variavel) {
        this.variavel = variavel;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
 }
