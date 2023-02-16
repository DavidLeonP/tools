package com.aplicaciones13.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author omargo33@hotmail.com
 *
 */
@Slf4j
public class Archivo {
    private final String pathArchivoBase;
    private static String separador = System.getProperty("file.separator");

    /**
     * Creates new ArchivoBase.
     *
     * @param pathArchivoBase
     */
    public Archivo(String pathArchivoBase) {
        this.pathArchivoBase = pathArchivoBase;
    }

    /**
     * propiedad texto recupera un archivo de texto a partir de su path.
     *
     * @return contenido de user.txt
     */
    public String getTexto() {
        File fichaEntrada = new File(pathArchivoBase);
        try (FileInputStream canalEntrada = new FileInputStream(fichaEntrada)) {
            byte[] bt = new byte[(int) fichaEntrada.length()];
            canalEntrada.read(bt);
            canalEntrada.close();
            return new String(bt);
        } catch (IOException e) {
            log.error(e.toString());
        }
        return "";
    }

    /**
     * propiedad texto Guarda un archivo de texto a partir de su path.
     *
     * @param text cid a guardar
     */
    public void setTexto(String text) {
        byte[] b = text.getBytes();
        File fichaSalida = new File(pathArchivoBase);
        try (FileOutputStream canalSalida = new FileOutputStream(fichaSalida)) {
            canalSalida.write(b);
            canalSalida.close();
        } catch (IOException e) {
            log.error(e.toString());
        }
    }

    /**
     * Metodo para crear un directorio agrega fecha
     *
     * @param pathBase
     * @param producto
     * @param accion
     * @param nombreArchivo
     * @return
     */
    public static String creaDirectorio(String pathBase, String producto, String accion, String nombreArchivo) {        
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        String directorioFecha = formatter.format(LocalDate.now());
        String path = pathBase + producto + separador + accion + separador + directorioFecha;
        File stockDir = new File(path);
        try {
            stockDir.setWritable(true, true);
            stockDir.setReadable(true, true);
            stockDir.setExecutable(true, true);
            stockDir.mkdirs();
        } catch (SecurityException e) {
            log.error(e.toString());
        }
        return path + separador + nombreArchivo;
    }

    /**
     * Get texto de forma estandar.
     *
     * @return
     */
    @Override
    public String toString() {
        return getTexto();
    }
}