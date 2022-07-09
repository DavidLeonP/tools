package com.aplicaciones13.comun;

import com.aplicaciones13.tools.LogTemp;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * Objeto para poder sobrecargar la forma de actuar de los mentods de conexion a
 * la base de datos y a procesos en backgroud.
 *
 * @author omargo33@hotmail.com
 *
 */
public class SobrecargaAcciones implements Serializable {

    @SuppressWarnings("compatibility:-2104704226177752196")
    private static final long serialVersionUID = 1L;

    /**Metodo para crear.
     *
     */
    public SobrecargaAcciones() {
    }

    /**Accion a ser invocada, la misma que tendra que ser reescrita pra su
     * funcionamiento.
     */
    public void accionExtra() {
    }

    /**Accion a ser invocada, la misma que tendra que ser reescrita pra su
     * funcionamiento
     * validacion.
     * @return si esta correcto o no
     */
    public boolean validacion() {
        return true;
    }

    /**
     * Acciones para calculos con las posicione de la tabla.
     * @param row fila
     * @param col columna
     */
    public void calculoTabla(int row, int col) {
        LogTemp.escribir(this.getClass().getName(), ".calculoTabla Falta sobrecargar ", row + col);
    }

    /**
     * Metodo para parar.
     */
    public void parar() {
    }

    /**
     * Metodo para hacer mas eficientes los sistemas que en un cursor
     * tiene que hacer alguna actividad, y en esta se encuentran ya
     * puestas las validacione.
     *
     * @throws java.sql.SQLException Sql exception
     * @throws java.lang.Exception Exception
     */
    public void eachWorkResultSet() throws SQLException, java.lang.Exception {
    }
}
