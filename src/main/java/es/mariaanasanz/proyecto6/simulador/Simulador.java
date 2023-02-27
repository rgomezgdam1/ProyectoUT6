package es.mariaanasanz.proyecto6.simulador;

import es.mariaanasanz.proyecto6.base.Comida;
import es.mariaanasanz.proyecto6.base.Gema;
import es.mariaanasanz.proyecto6.base.Jugador;
import es.mariaanasanz.proyecto6.base.Zarigueya;
import es.mariaanasanz.proyecto6.ejercicios.Estadisticas;
import javafx.scene.input.KeyCode;

import static es.mariaanasanz.proyecto6.ejercicios.Estadisticas.*;

public class Simulador {

    /**
     * TODO: Debereis simular los datos de una partida con el objetivo de validar vuestros metodos implementados (14 puntos)
     * Es decir, tendreis que llamar desde aqui a todos vuestros metodos:
     *      - capturarEventoTeclado
     *      - mostrarEventosTeclado
     *      - teclaMasPulsada
     *      - objetoRecogido
     *      - mostrarObjetosRecogidos
     *      - mostrarQuienHaRecogidoMasObjetos
     *      - capturarDisparo
     *      - borrarDisparo
     *      - mostrarRatioPrecision
     * IMPORTANTE: tendreis que validar que llegan los parametros correctos
     * IMPORTANTE: Se debera evitar el autoboxing y el unboxing
     * Para ello, se emplearan los argumentos de entrada de la siguiente manera:
     * @param args numFlechasIzquierda numFlechasDerecha numShift numEscape numOtrasTeclas numComidaJugador
     *             numJoyaJugador numComidaZarigueya numJoyaZarigueya numDisparosCerteros numDisparosFallidos numDisparosCerterosBorrar numDisparosFallidosBorrar
     */
    public static void main(String[] args) {
        Estadisticas estadisticas = new Estadisticas();
        capturarEventoTeclado(KeyCode.RIGHT);
        capturarEventoTeclado(KeyCode.LEFT);
        capturarEventoTeclado(KeyCode.ASTERISK);
        capturarEventoTeclado(KeyCode.RIGHT);
        capturarEventoTeclado(KeyCode.LEFT);
        capturarEventoTeclado(KeyCode.SHIFT);
        capturarEventoTeclado(KeyCode.RIGHT);
        capturarEventoTeclado(KeyCode.LEFT);
        capturarEventoTeclado(KeyCode.ASTERISK);
        capturarEventoTeclado(KeyCode.SHIFT);
        capturarEventoTeclado(KeyCode.LEFT);
        capturarEventoTeclado(KeyCode.ESCAPE);
        mostrarEventosTeclado();

        objetoRecogido("jugador","gema");
        objetoRecogido("jugador","comida");
        objetoRecogido("jugador","gema");
        objetoRecogido("zarigueya","comida");
        objetoRecogido("zarigueya","gema");
        objetoRecogido("zarigueya","comida");

        mostrarObjetosRecogidos();
    }
}
