/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

/**
 *
 * @author Familia Mora
 */
public class ArchivoAleatorio {

    private RandomAccessFile Rf;
    private long tamañoRegistro;
    private long canReg;
    private int clave;

    public ArchivoAleatorio(File Fl) {
        this.canReg = 0;
        this.tamañoRegistro = 1484;
        this.clave = 0;

        /*
        4+(20+20+100+150+150+150+150)*2=1484
         */
        try {
            Rf = new RandomAccessFile(Fl, "rw");
            
            // Se borra lo que haya en el archivo;
            Rf.setLength(0);
          

        } catch (Exception e) {
            System.exit(0);
        }
    }

    public void escribir(String nombreComun, String especie, String zonaProduccion, String habitoCrecimiento, String floracion, String bayas, String tuberculos) {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(
                System.in));
        try {
            
            this.clave = Math.round(Rf.length() / this.tamañoRegistro) + 1;
            System.out.println(tamañoRegistro + " " + Rf.length());
            System.out.println(clave);
            
            nombreComun = this.completarTamañoBytes(nombreComun, 20);
            especie = this.completarTamañoBytes(especie, 20);
            zonaProduccion = this.completarTamañoBytes(zonaProduccion, 100);
            habitoCrecimiento = this.completarTamañoBytes(habitoCrecimiento, 150);
            floracion = this.completarTamañoBytes(floracion, 150);
            bayas = this.completarTamañoBytes(bayas, 150);
            tuberculos = this.completarTamañoBytes(tuberculos, 150);

            if (Rf.length() != 0) {
                Rf.seek(Rf.length());
            }
            Rf.writeInt(clave);
            Rf.writeChars(nombreComun);
            Rf.writeChars(especie);
            Rf.writeChars(zonaProduccion);
            Rf.writeChars(habitoCrecimiento);
            Rf.writeChars(floracion);
            Rf.writeChars(bayas);
            Rf.writeChars(tuberculos);

        } catch (FileNotFoundException fnfe) {/* Archivo no encontrado */
        } catch (IOException ioe) {
            /* Error al escribir */
        }
    }

    public String lecturaRegistros() {
        int clave = 0;
        String nombreComun = "";
        String especie = "";
        String zonaProduccion = "";
        String habitoCrecimiento = "";
        String floracion = "";
        String bayas = "";
        String tuberculos = "";

        String respuesta = ("");
        try {
            Rf.seek(0);
            canReg = Rf.length() / tamañoRegistro;

            for (int r = 0; r < canReg; r++) {
                clave = Rf.readInt();
                System.out.println(clave);
                nombreComun = "";
                especie = "";
                zonaProduccion = "";
                habitoCrecimiento = "";
                floracion = "";
                bayas = "";
                tuberculos = "";
                
                for (int i = 0; i < 20; ++i) {
                    nombreComun += Rf.readChar();
                }
                
                for (int i = 0; i < 20; ++i) {
                    especie += Rf.readChar();
                }

                for (int i = 0; i < 100; ++i) {
                    zonaProduccion += Rf.readChar();
                }

                for (int i = 0; i < 150; ++i) {
                    habitoCrecimiento += Rf.readChar();
                }

                for (int i = 0; i < 150; ++i) {
                    floracion += Rf.readChar();
                }

                for (int i = 0; i < 150; ++i) {
                    bayas += Rf.readChar();
                }

                for (int i = 0; i < 150; ++i) {
                    tuberculos += Rf.readChar();
                }
                respuesta += ("\n" + clave + " " + nombreComun + " "  + especie + " " + zonaProduccion + " " + habitoCrecimiento + " " + floracion + " " + bayas + " " + tuberculos);
            }
        } catch (Exception e) {
        }
        return respuesta;
    }

    private String completarTamañoBytes(String n, int tamaño) {

        if (n.length() < tamaño + 1) {
            for (int i = n.length(); i < tamaño; i++) {
                n = n + " ";
            }

        }
        return n;
    }
}
