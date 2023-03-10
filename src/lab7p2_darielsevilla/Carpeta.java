/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7p2_darielsevilla;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Carpeta implements Serializable{
    private final static long SerialVersionUID = 372;
    private String nombre;
    private String link;
    private ArrayList<Archivo> archivos = new ArrayList();
    private ArrayList<Carpeta> carpetas = new ArrayList();
    private int favorito = 0;
    private int trash = 0;
    private SecureRandom random = new SecureRandom();
    public Carpeta() {
    }

    public Carpeta(String nombre) {
        this.nombre = nombre;
      
        
        String path = "dive.google.com/";
        for (int i = 0; i < 5; i++) {
            int op = random.nextInt(2);
            
            if(op == 0){
               //letras 
               String t2 = Integer.toString(random.nextInt(26)+65);
               int op2 = random.nextInt(2);
               
               if(op2 == 0){
                   t2 = t2.toLowerCase();
               }else{
                   t2 = t2.toUpperCase();
               }
               
               link += t2;
            }else if(op == 1){
               ///numeros
               link += random.nextInt(10) + 48;
            }
        }
        this.link = path;
      
    }
    
    public Carpeta(String nombre,Carpeta c) {
        this.nombre = nombre;
        
        String path = c.getLink();
        
        for (int i = 0; i < 5; i++) {
            int op = random.nextInt(2);
            
            if(op == 0){
               //letras 
               String t2 = Integer.toString(random.nextInt(26)+65);
               int op2 = random.nextInt(2);
               
               if(op2 == 0){
                   t2 = t2.toLowerCase();
               }else{
                   t2 = t2.toUpperCase();
               }
               
               link += t2;
            }else if(op == 1){
               ///numeros
               link += random.nextInt(10) + 48;
            }
        }
        this.link = path;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    

    public ArrayList<Archivo> getArchivos() {
        return archivos;
    }

    public void setArchivos(ArrayList<Archivo> archivos) {
        this.archivos = archivos;
    }

    public ArrayList<Carpeta> getCarpetas() {
        return carpetas;
    }

    public void setCarpetas(ArrayList<Carpeta> carpetas) {
        this.carpetas = carpetas;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

    public int getTrash() {
        return trash;
    }

    public void setTrash(int trash) {
        this.trash = trash;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
     
    
    
}
