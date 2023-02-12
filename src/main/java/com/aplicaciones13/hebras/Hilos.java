package com.aplicaciones13.hebras;

import com.aplicaciones13.comun.SobrecargaAcciones;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Objeto para crear un hilo de ejecucion y su respectivo procesamiento.
 * 
 *
 * @author omargo33@hotmail.com.
 *
 */
@Slf4j
public class Hilos {

    private int cantidadHilos = 1;
    private ExecutorService executor;

    /**
     * Metodo para crear el objeto.
     *
     */
    public Hilos() {
        super();
    }

    /**
     * Metodo para sobrecargar el proceso a ser invocado.
     *
     * @param objeto
     */
    public void procesar(Object objeto) {
        log.info(".procesar() metodo a sobrecargar {}", objeto);
    }

    /**
     * Metodo para ejecutar la lista.
     *
     * Toma la lista y divide para el largo de esta y genera las colas, como
     * maximo la cola seleccionada.
     *
     * @param lista
     */
    public void ejecutarLista(List lista) {
        int resultado = lista.size() / getCantidadHilos();
        int cociente = lista.size() % getCantidadHilos();
        int inicioLista = 0;
        int finLista = resultado + cociente;

        executor
                = Executors.newFixedThreadPool((resultado == 0) ? 1 : getCantidadHilos());

        while (inicioLista <= lista.size()) {
            agregarCola(lista.subList(inicioLista, finLista));
            inicioLista = finLista + 1;
            finLista += resultado;
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            System.out.println("");
        }
    }

    /**
     * Metodo para agregar procesos a la cola de ejecucion.
     * 
     * @param subLista 
     * 
     */
    private void agregarCola(List<Object> subLista) {
        final List<Object> subListaFinal = subLista;
        ThreadBase thread = new ThreadBase();
        thread.addHebra(new SobrecargaAcciones() {
            @Override
            public void accionExtra() {
                for (Object o : subListaFinal) {
                    procesar(o);
                }
            }
        });
        executor.execute(thread);
    }

    //Propiedades
    public int getCantidadHilos() {
        return cantidadHilos;
    }

    public void setCantidadHilos(int cantidadLista) {
        this.cantidadHilos = cantidadLista;
    }
}
