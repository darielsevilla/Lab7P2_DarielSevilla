/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7p2_darielsevilla;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class ProgressBar extends Thread {
    private Carpeta c;
    private double size = 0;
    private ArrayList<Archivo> archivosCarpeta = new ArrayList();
    private JTable tabla;
    private JProgressBar barra;
    private JProgressBar barra2;

    public ProgressBar() {
    }

    public ProgressBar(JProgressBar barra, Carpeta c, JTable table, JProgressBar barra2) {
        this.c = c;
        this.barra = barra;
        this.tabla = table;
        this.barra2 = barra2;
        recorrerCarpeta(c);
        determineSize(archivosCarpeta);
        
        
        barra.setMaximum(archivosCarpeta.size());
    }
    
    public ProgressBar(JProgressBar barra, Archivo archivo, JTable table, JProgressBar bar2) {
   
        this.barra = barra;
        this.barra2 = bar2;
        this.tabla = table;
        archivosCarpeta.add(archivo);
        barra.setMaximum(archivosCarpeta.size());
    }
    
    public void run(){
        size = 0;
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        
        modelo.setRowCount(0);
        
        for (Archivo archivo : archivosCarpeta) {
            try {
                bar2 barr = new bar2(barra2, archivo);
                barr.start();
              
               
                while(barr.isAlive()){
                    Thread.sleep(10);
                }
                Thread.sleep(0);
                
                barra.setValue(barra.getValue()+1);
                File file = new File("./bitacora.txt");
                FileWriter writer = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(writer);
                String string = archivo.getNombre() + " " + archivo.getSize() + " " + new Date() + "\n";
                bw.write(string);
                bw.flush();
                bw.close();
               
                modelo.addRow(new Object[]{archivo.getNombre(), archivo.getSize(), archivo.getExtension()});
            } catch (Exception ex) {
                Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex);
        }
        barra.setValue(0);
        modelo.setRowCount(0);
       
        
    }
    
    public void recorrerCarpeta(Carpeta carp){
        for (Archivo a : carp.getArchivos()) {
            archivosCarpeta.add(a);
        }
        
        for (Carpeta c : carp.getCarpetas()) {
            recorrerCarpeta(carp);
        }
    }
    
    public void determineSize(ArrayList<Archivo> archivos){
        for (Archivo archivo : archivos) {
            size += archivo.getSize();
        }
    }
}
