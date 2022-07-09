package com.aplicaciones13.tools;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Objeto para generar el log y auditoria de aplicaciones java.
 *
 * @author omargo33@hotmail.com
 *
 */
public class LogTemp {

    /**
     * Metodo para crear tools.
     */
    protected LogTemp() {
        super();
    }

    /**
     * Metodo para escribir un archivo de rastreo.
     *
     * Puede escribir sobre un servidor windows o un servidor Linux/AIX, no
     * probado en AS400
     *
     * @param palabras
     *
     * @return
     */
    public static boolean escribir(Object... palabras) {
        String mensaje = "";

        for (Object palabra1 : palabras) {
            String palabra = "";
            palabra = String.valueOf(palabra1).trim();
            if (palabra.startsWith(".")) {
                mensaje = mensaje.trim() + palabra + " ";
            } else {
                mensaje = mensaje + palabra + " ";
            }
        }

        String nombreArchivoTemporal = System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + "13a-" + fechaActualFormato() + ".log";

        try (FileWriter fileWriter = new FileWriter(nombreArchivoTemporal, true)) {
            StringBuilder builder = new StringBuilder();
            builder.append(new Date());
            builder.append(" ");
            builder.append(mensaje);
            builder.append(System.lineSeparator());
            fileWriter.write(builder.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.SEVERE, "escribir() {0} File: {1}", new Object[]{e.toString(), nombreArchivoTemporal});
            return false;
        }
        return true;
    }

    /**
     * Metodo para crear una fecha actaul con formato.
     *
     * @return
     */
    private static String fechaActualFormato() {
        Date now = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(now);
    }
}
