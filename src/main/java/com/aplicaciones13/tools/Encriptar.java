package com.aplicaciones13.tools;

import java.io.UnsupportedEncodingException;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 * Objeto para dar soporte a una encripcion.
 *
 * @author omargo33@hotmail.com
 *
 */
public class Encriptar {
    private static final byte[] SEED = {74, 82, 70, 71, 46, 65, 100, 109, 105, 110, 46, 50, 52, 56, 51, 55, 48, 48};
    private static final String CHAR_SET = "UTF-8";

    /**
     * Metodo para crear tools.
     */
    protected Encriptar() {
        super();
    }

    /**
     * Metodo para encriptar un codigo.
     *
     * @param cadena
     * @return
     */
    public static String decifrar(String cadena) {
        if (cadena == null) {
            return cadena;
        }
        try {
            StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
            standardPBEStringEncryptor.setPassword(new String(SEED, CHAR_SET));
            return standardPBEStringEncryptor.decrypt(cadena);
        } catch (UnsupportedEncodingException e) {
            LogTemp.escribir(e);
        }
        return cadena;
    }

    /**
     * Metodo para encriptar un codigo.
     *
     * @param semilla
     * @param cadena
     * @return
     */
    public static String decifrar(Object semilla, String cadena) {
        if (cadena == null) {
            return cadena;
        }
        try {
            StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
            standardPBEStringEncryptor.setPassword(
                    new String(semilla.toString().getBytes(), CHAR_SET));
            return standardPBEStringEncryptor.decrypt(cadena);
        } catch (UnsupportedEncodingException e) {
            LogTemp.escribir(e);
        }
        return cadena;
    }

    /**
     * Metodo para desencriptar un codigo.
     *
     * @param cadena
     * @return
     */
    public static String cifrar(String cadena) {
        if (cadena == null) {
            return cadena;
        }
        try {
            StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
            standardPBEStringEncryptor.setPassword(new String(SEED, CHAR_SET));
            return standardPBEStringEncryptor.encrypt(cadena);
        } catch (UnsupportedEncodingException e) {
            LogTemp.escribir(e);
        }
        return null;
    }

}
