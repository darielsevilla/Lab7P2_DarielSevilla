/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7p2_darielsevilla;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Administrador {
    private ArrayList<Archivo> archivos = new ArrayList();
    private ArrayList<Carpeta> carpetas = new ArrayList();
    
    private File archivo;
    
    public void Administrador(){
        
    }

    public Administrador(String path) {
        archivo = new File(path);
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

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    
    
    public void escriba(){
        try {
            FileOutputStream out = new FileOutputStream(archivo, false);
            ObjectOutputStream output = new ObjectOutputStream(out);
            
            for (Archivo c : archivos) {
                output.writeObject(c);
            }
            
            for (Carpeta c : carpetas) {
                output.writeObject(c);
            }
            
            output.flush();
            out.close();
            output.close();
        } catch (Exception e) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void lea(){
        try{
            if(archivo.exists()){
                FileInputStream in = new FileInputStream(archivo);
                ObjectInputStream input = new ObjectInputStream(in);
                Object temp = new Object();
                
                try{
                    while((temp = input.readObject()) != null){
                        if(temp instanceof Archivo){
                           archivos.add((Archivo)temp);
                        }else{
                           carpetas.add((Carpeta)temp);
                            
                        
                        }
                    }
                }catch(EOFException ex){
                    
                }
            }
        }catch(Exception e){
            
        }
    }
}
