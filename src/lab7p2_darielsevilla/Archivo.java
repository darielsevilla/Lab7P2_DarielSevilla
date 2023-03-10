/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7p2_darielsevilla;

import java.io.Serializable;
import java.security.SecureRandom;

/**
 *
 * @author HP
 */
public class Archivo implements Serializable{
    private final static long SerialVersionUID = 372;
    private String nombre;
    private String extension;
    private String path;
    private double size;
    private int favorito = 0;
    private int trash = 0;
    
    SecureRandom random = new SecureRandom();
    public Archivo() {
    }

    public Archivo(String nombre, double size, String extension) {
       
        this.nombre = nombre;
        this.size = size;
        this.extension  = extension;
        
        String link = "dive.google.com/";
        
        for (int i = 0; i < 10; i++) {
            int op = random.nextInt(2);
            
            if(op == 0){
               //letras 
               int x = random.nextInt(26)+65;
               char t1 = (char)x;
               String t2 = Character.toString(t1);
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
        this.path = link;
    }

    public Archivo(String nombre, String extension, double size, Carpeta c){
        this.nombre = nombre;
        this.size = size;
        this.extension = extension;
        String link = c.getLink();
       
        for (int i = 0; i < 10; i++) {
            int op = random.nextInt(2);
            
            if(op == 0){
               //letras 
               int x = random.nextInt(26)+65;
               char t1 = (char)x;
               String t2 = Character.toString(t1);
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
        this.path = link;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTrash() {
        return trash;
    }

    public void setTrash(int trash) {
        this.trash = trash;
    }

    public SecureRandom getRandom() {
        return random;
    }

    public void setRandom(SecureRandom random) {
        this.random = random;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

    @Override
    public String toString() {
        return nombre +"." + extension;
    }
    
    
}
