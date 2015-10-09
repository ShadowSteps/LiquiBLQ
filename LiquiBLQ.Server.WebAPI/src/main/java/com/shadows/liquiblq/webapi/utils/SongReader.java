/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.shadows.liquiblq.webapi.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import static jdk.nashorn.internal.objects.ArrayBufferView.buffer;
import static org.apache.tomcat.jni.Shm.buffer;

/**
 *
 * @author toshiba
 */
public class SongReader {
    
    public InputStream fis;
    public byte[] buffer; 
    public File file;
    
    public SongReader(String path,int size) throws FileNotFoundException{
        this.setFile(path);
        this.setInputStream();
        this.setBuffer(size);
    }
    
    public void setFile(String path){
        this.file = new File(path);
    }
    
    public File getFile(){
        return this.file;
    }
    
    public void setBuffer(int size){
        this.buffer = new byte[size];
    }
    
    public byte[] getBuffer(){
        return this.buffer;
    }
    
    public void setInputStream() throws FileNotFoundException{
        this.fis = new FileInputStream(this.getFile());
    }
    
    public InputStream getInputStream(){
        return this.fis;
    }
    
    public void read() {
        try {
            int content;
                while ((content = this.getInputStream().read(this.getBuffer(), 0, this.getBuffer().length)) != -1) {
                    // convert to char and display it
                    System.out.print((char) content);
                }

        } catch (IOException e) {
                e.printStackTrace();
        } finally {
            try {
                    if (fis != null)
                            fis.close();
            } catch (IOException ex) {
                    ex.printStackTrace();
            }
        }
    }
}
