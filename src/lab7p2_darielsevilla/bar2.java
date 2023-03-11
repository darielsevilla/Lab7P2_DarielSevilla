/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7p2_darielsevilla;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author HP
 */
public class bar2 extends Thread{
    private JProgressBar barra;
    private Archivo archivo;
    private int size;
    public bar2() {
    }

    public bar2(JProgressBar barra, Archivo archivo) {
        this.barra = barra;
        this.archivo = archivo;
        this.size =(int) archivo.getSize() / 10;
        barra.setMaximum(size);
        if(size == 0){
            barra.setMaximum(1);
        }
    }
    
    public void run(){
        
        while(barra.getValue() != barra.getMaximum()){
            
                barra.setValue(barra.getValue()+1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(bar2.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
        
        barra.setValue(0);
    }
    
}
