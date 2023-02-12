package com.aplicaciones13.hebras;

import com.aplicaciones13.comun.SobrecargaAcciones;

import lombok.extern.slf4j.Slf4j;

/**
 * Objeto para hacer que deteminados objetos se lancen como un proceso back ground, ayuda con la
 * eficiencia del sistema, por la utilizacion de hilo de ejecucion.
 *
 * @author omargo33@hotmail.com
 *
 */
@Slf4j
public class ThreadBase extends Thread {
    private boolean parar;
    private String mensaje;
    private SobrecargaAcciones documentListenerBean;

    /**
     * Creates a new instance of thProceso.
     */
    @Override
    public synchronized void run() {
        if (getMensaje() != null) {
            log.warn(".run() mensaje: {}", mensaje);
        }
        documentListenerBean.accionExtra();
        if (isParar()) {
            parada();
        }
    }

    /**
     * Metodo de parada de las acciones.
     *
     */
    private void parada() {
        this.stop();        
    }

    /**
     * Este metodo es el que logra la presentaciond de nuestro datos extras, remplaza a no model
     * es decir funciona de la siguiente manera.
     *
     * @param documentTemp Objeto de ejecucion temporal
     *
     */
    public void addHebra(SobrecargaAcciones documentTemp) {
        documentListenerBean = documentTemp;
    }

    /**
     * Getter for property mensaje.
     *
     * @return Value of property mensaje.
     */
    public String getMensaje() {
        return this.mensaje;
    }

    /**Metodo para obtener los mensajes.
     *
     * @param mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
        setParar(true);
    }

    /**
     * @return
     */
    public boolean isParar() {
        return parar;
    }

    /**
     * @param parar
     */
    public void setParar(boolean parar) {
        this.parar = parar;
    }
}
