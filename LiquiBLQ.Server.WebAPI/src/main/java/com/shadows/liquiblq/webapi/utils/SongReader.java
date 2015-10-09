/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.shadows.liquiblq.webapi.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author toshiba
 */
public class SongReader {
    
    public static void main(String[] args) {

		File file = new File("filedir");
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);

			System.out.println("Total file size to read (in bytes) : "
					+ fis.available());

			int content;
			while ((content = fis.read()) != -1) {
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
