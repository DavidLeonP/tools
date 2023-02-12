package com.aplicaciones13.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author omargo33@hotmail.com.
 *
 */
@Slf4j
public class Archivo {

    private final String pathArchivoBase;

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
     * Get texto de forma estandar.
     *
     * @return
     */
    @Override
    public String toString() {
        return getTexto();
    }
}
