/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.webapi.SongReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mihail
 */
public class FileReader {
   
    protected File file;
    protected InputStream inputstream;
   
    protected void setFile(String path){
        this.file=new File(path);
    }
    protected File getFile(){
        return this.file;
    }
    protected void setInputStream() throws FileNotFoundException{
        try {
            this.inputstream = new FileInputStream(this.getFile());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    protected InputStream getInputStream(){ 
        return this.inputstream;
    }
    
    public  void fileGetContent() {
        try {
                int content;
                while ((content = this.getInputStream().read()) != -1) {
                        System.out.print((char) content);
                }

        } catch (IOException e) {
                e.printStackTrace();
        } finally {
            try {
                    if (this.getInputStream() != null)
                            this.getInputStream().close();
            } catch (IOException ex) {
                    ex.printStackTrace();
            }
        }
    }
}

