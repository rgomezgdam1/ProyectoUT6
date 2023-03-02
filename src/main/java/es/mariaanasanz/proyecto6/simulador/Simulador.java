package es.mariaanasanz.proyecto6.simulador;

import es.mariaanasanz.proyecto6.base.Comida;
import es.mariaanasanz.proyecto6.base.Gema;
import es.mariaanasanz.proyecto6.base.Jugador;
import es.mariaanasanz.proyecto6.base.Zarigueya;
import es.mariaanasanz.proyecto6.ejercicios.Estadisticas;
import javafx.scene.input.KeyCode;

import java.util.Arrays;
import java.util.Random;

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
    public static void main(String[] args) { // 2, 34, 3, 5, 6, 7, 8, 9, 10, 8, 9, 1, 4
    /**
        Random rnd = new Random();
        int i = 0;
        while (Arrays.stream(eventos).sum() > 0 && i!=3){
            i = rnd.nextInt(13);
            if (eventos[i] > 0) {
                eventos[i]--;
                hazAccion(i);
            }
        }
    }
    private static void hazAccion(int i) {
        switch (i) */
        int[] eventos = new int[13];
        for (int i = 0; i < eventos.length; i++) {
            eventos[i] = Integer.parseInt(args[i]);
        }
        for (int i = 0; i < eventos.length; i++) {
            int v = eventos[i];
            for (int j = 0; j < v; j++) {
                switch (i){
                    case 0:     capturarEventoTeclado(KeyCode.LEFT);
                        break;
                    case 1:     capturarEventoTeclado(KeyCode.RIGHT);
                        break;
                    case 2:     capturarEventoTeclado(KeyCode.SHIFT);
                        break;
                    case 3:     capturarEventoTeclado(KeyCode.ESCAPE);
                        break;
                    case 4:     capturarEventoTeclado(KeyCode.ASTERISK);
                        break;
                    case 5:     objetoRecogido("jugador","comida");
                        break;
                    case 6:     objetoRecogido("jugador","gema");
                        break;
                    case 7:     objetoRecogido("zarigueya","comida");
                        break;
                    case 8:     objetoRecogido("zarigueya","gema");
                        break;
                    case 9:     capturarDisparo(Boolean.TRUE);
                        break;
                    case 10:    capturarDisparo(Boolean.FALSE);
                        break;
                    case 11:    borrarDisparo(Boolean.TRUE);
                        break;
                    case 12:    borrarDisparo(Boolean.FALSE);
                        break;
                }
            }
        }
        mostrarEventosTeclado();
        System.out.println("La tecla más pulsada es: " + teclaMasPulsada());
        System.out.println();
        mostrarObjetosRecogidos();
        mostrarQuienHaRecogidoMasObjetos();
        mostrarRatioPrecision();
        //mostrarPajarosEscapados();
    }
}
