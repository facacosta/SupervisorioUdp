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
public class SensorNivel extends Sensor {
    
    private float volume = 0;
     
    public SensorNivel() {
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }
    
    public Float CalculaVolume (float nivel,float area){
        
        float valorArea = area/1000;
        volume = nivel * valorArea;
        
        return volume;
    }
    
    
   
 }
