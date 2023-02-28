package es.mariaanasanz.proyecto6.ejercicios;

import es.mariaanasanz.proyecto6.base.Jugador;
import es.mariaanasanz.proyecto6.base.Zarigueya;
import javafx.scene.input.KeyCode;

import java.util.*;

@SuppressWarnings("removal")
public class Estadisticas {

    private static LinkedHashMap<KeyCode, Integer> contadorEventosTeclado = new LinkedHashMap<KeyCode, Integer>();
    private static HashMap<String, HashMap<String, Integer>> contadorObjetosRecogidos = new HashMap<String,HashMap<String,Integer>>();
    private static ArrayList<Boolean> historicoDisparos = new ArrayList<Boolean>();


    public static void mostrarEstadisticasSeguro() {
        try {
            System.out.println("****************************************");
            mostrarEventosTeclado();
            System.out.println("****************************************");
            KeyCode code = teclaMasPulsada();
            if (code != null) {
                System.out.println("La tecla que mas veces se ha pulsado ha sido: " + code.toString());
                System.out.println("****************************************");
            }
            mostrarObjetosRecogidos();
            System.out.println("****************************************");
            mostrarQuienHaRecogidoMasObjetos();
            System.out.println("****************************************");
            mostrarRatioPrecision();
            System.out.println("****************************************");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void capturarEventoTecladoSeguro(KeyCode code) {
        try {
            capturarEventoTeclado(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void objetoRecogidoSeguro(String actor, String objeto) {
        try {
            objetoRecogido(actor, objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * TODO: Captura todos los eventos que se produzcan durante la partida en el LinkedHashMap contadorEventosTeclado (10 puntos)
     * Acabaremos poblando un HashMap que contenga la cantidad de veces que ha ocurrido cada evento de teclado
     * Los eventos posibles que pueden llegar son:
     *      - KeyCode.RIGHT  --> para desplazarse a la derecha
     *      - KeyCode.LEFT   --> para desplazarse a la izquierda
     *      - KeyCode.SHIFT  --> para correr
     *      - KeyCode.ESCAPE --> para cerrar la ventana
     *      - KeyCode.ASTERISK --> Este evento no llegara, sino que cualquier otro evento lo almacenaremos como si fuese KeyCode.ASTERISK
     * Ejemplo de validacion:
     *      code == KeyCode.RIGHT   o bien   code == RIGHT   dependiendo de como hagais la validacion (IntelliJ os lo dira)
     * IMPORTANTE: Se debera recoger el tipo de evento mediante la clausula switch
     * IMPORTANTE: Se debera evitar el autoboxing y el unboxing
     *
     * @param code el cogido de evento capturado
     */
    public static void capturarEventoTeclado(KeyCode code) {
        if (code == null) {
            throw new NullPointerException("No se ha pulsado una tecla válida");
        } else {
            switch (code) {
                case RIGHT:
                    Integer tmp = contadorEventosTeclado.get(KeyCode.RIGHT);
                    if (tmp == null) {
                        tmp = new Integer(0);
                        contadorEventosTeclado.put(KeyCode.RIGHT, tmp);
                    }
                    contadorEventosTeclado.put(KeyCode.RIGHT, tmp + 1);
                    break;
                case LEFT:
                    Integer aux = contadorEventosTeclado.get(KeyCode.LEFT);
                    if (aux == null) {
                        aux = new Integer(0);
                        contadorEventosTeclado.put(KeyCode.LEFT, aux);
                    }
                    contadorEventosTeclado.put(KeyCode.LEFT, aux + 1);
                    break;
                case SHIFT:
                    Integer tmp1 = contadorEventosTeclado.get(KeyCode.SHIFT);
                    if (tmp1 == null) {
                        tmp1 = new Integer(0);
                        contadorEventosTeclado.put(KeyCode.SHIFT, tmp1);
                    }
                    contadorEventosTeclado.put(KeyCode.SHIFT, tmp1 + 1);
                    break;
                case ESCAPE:
                    Integer tmp2 = contadorEventosTeclado.get(KeyCode.ESCAPE);
                    if (tmp2 == null) {
                        tmp2 = new Integer(0);
                        contadorEventosTeclado.put(KeyCode.ESCAPE, tmp2);
                    }
                    contadorEventosTeclado.put(KeyCode.ESCAPE, tmp2 + 1);
                    break;
                default:
                    Integer tmp3 = contadorEventosTeclado.get(KeyCode.ASTERISK);
                    if (tmp3 == null) {
                        tmp3 = new Integer(0);
                        contadorEventosTeclado.put(KeyCode.ASTERISK, tmp3);
                    }
                    contadorEventosTeclado.put(KeyCode.ASTERISK, tmp3 + 1);
                    break;
            }
        }
    }

    /**
     * TODO: Se debera mostrar por consola toda la informacion del LinkedHashMap contadorEventosTeclado con el siguiente formato (el orden SI importa) (8 puntos)
     * Teclas pulsadas durante la partida:
     *      - RIGHT: 55 veces
     *      - LEFT: 43 veces
     *      - SHIFT: 2 veces
     *      - ESCAPE: 1 vez
     *      - OTROS: 243 veces
     * IMPORTANTE: Se debera emplear el metodo entrySet() para recorrer las entradas
     * IMPORTANTE: Se debera evitar el autoboxing y el unboxing
     * IMPORTANTE: Se debera emplear StringBuilder para construir la cadena a mostrar
     */
    public static void mostrarEventosTeclado() {

        /**/
        Set<Map.Entry<KeyCode, Integer>> entradas = contadorEventosTeclado.entrySet();
        StringBuilder sb = new StringBuilder("Teclas pulsadas durante la partida:\n");

        int countRight = 0;
        int countLeft = 0;
        int countShift = 0;
        int countEscape = 0;
        int countElse = 0;
        for (Map.Entry<KeyCode, Integer> entrada : entradas) {
            for (int i = 0; i < entrada.getValue(); i++) {
                if (entrada.getKey().equals(KeyCode.RIGHT)) {
                    countRight++;
                } else if (entrada.getKey().equals(KeyCode.LEFT)) {
                    countLeft++;
                } else if (entrada.getKey().equals(KeyCode.SHIFT)) {
                    countShift++;
                } else if (entrada.getKey().equals(KeyCode.ESCAPE)) {
                    countEscape++;
                } else {
                    countElse++;
                }
            }
        }
        if (countRight == 1) {
            sb.append("     - RIGHT: ").append(countRight).append(" vez\n");
        } else {
            sb.append("     - RIGHT: ").append(countRight).append(" veces\n");
        }
        if (countLeft == 1) {
            sb.append("     - LEFT: ").append(countLeft).append(" vez\n");
        } else {
            sb.append("     - LEFT: ").append(countLeft).append(" veces\n");
        }
        if (countShift == 1) {
            sb.append("     - SHIFT: ").append(countShift).append(" vez\n");
        } else {
            sb.append("     - SHIFT: ").append(countShift).append(" veces\n");
        }
        if (countEscape == 1) {
            sb.append("     - ESCAPE: ").append(countEscape).append(" vez\n");
        } else {
            sb.append("     - ESCAPE: ").append(countEscape).append(" veces\n");
        }
        if (countElse == 1) {
            sb.append("     - OTROS: ").append(countElse).append(" vez\n");
        } else {
            sb.append("     - OTROS: ").append(countElse).append(" veces\n");
        }
        System.out.println(sb.toString());
    }

    /**
     * TODO: debera devolver el evento con mas ocurrencias del LinkedHashMap contadorEventosTeclado (6 puntos)
     * IMPORTANTE: Se debera emplear el metodo keySet() para recorrer las entradas
     * IMPORTANTE: Si el juego se cierra sin pulsar ninguna tecla, devera devolver KeyCode.ESCAPE
     *
     * @return KeyCode mas frecuente
     */
    public static KeyCode teclaMasPulsada() {
        Set<KeyCode> claves = contadorEventosTeclado.keySet();
        if (claves.size() == 0) {
            return KeyCode.ESCAPE;
        }
        int countRight = 0;
        int countLeft = 0;
        int countShift = 0;
        int countEscape = 0;
        int countElse = 0;

        for (KeyCode clave : claves) {
            switch (clave) {
                case RIGHT:
                    countRight++;
                    break;
                case LEFT:
                    countLeft++;
                    break;
                case SHIFT:
                    countShift++;
                    break;
                case ESCAPE:
                    countEscape++;
                    break;
                case ASTERISK:
                    countElse++;
                    break;
            }
        }
        if ((countRight > countLeft) && (countRight > countShift) && (countRight > countEscape) && (countRight > countElse)) {
            return KeyCode.RIGHT;
        } else if ((countLeft > countShift) && (countLeft > countEscape) && (countLeft > countElse)) {
            return KeyCode.LEFT;
        } else if ((countShift > countEscape) && (countShift > countElse)) {
            return KeyCode.SHIFT;
        } else if (countEscape > countElse) {
            return KeyCode.ESCAPE;
        } else if (countElse > countEscape) {
            return KeyCode.ASTERISK;
        } else {
            throw new NullPointerException("Dos teclas se han pulsado las mismas veces.");
        }
    }

    /**
     * TODO: se debera almacenar la relacion de objetos que recoge cada actor en el HashMap contadorObjetosRecogidos (12 puntos)
     * IMPORTANTE: la primera clave del HashMap contadorObjetosRecogidos sera el actor
     * IMPORTANTE: para cada actor habra otro hashmap asociado con la relacion de objetos y las veces que estos se han recogido
     * IMPORTANTE: Se debera evitar el autoboxing y el unboxing
     *
     * @param actor  sera o el jugador o la zarigueya
     * @param objeto sera o la comida o la gema
     */
    public static void objetoRecogido(String actor, String objeto) {
        if (actor == null) {
            throw new NullPointerException("El actor no es válido");
        }
        if (objeto == null) {
            throw new NullPointerException("EL objeto no es válido");
        }
        HashMap<String, Integer> recogido = contadorObjetosRecogidos.get(actor);
        if (recogido == null) {
            recogido = new HashMap<String, Integer>();
            recogido.put(objeto, new Integer(1));
            contadorObjetosRecogidos.put(actor, recogido);
        } else if (recogido.get(objeto) == null) {
            recogido.put(objeto, new Integer(1));
        } else {
            recogido.put(objeto, recogido.get(objeto) + 1);
        }
        contadorObjetosRecogidos.put(actor, recogido);
    }

    /**
     * TODO: Se debera mostrar por consola toda la informacion del HashMap contadorObjetosRecogidos con el siguiente formato (el orden no importa) (16 puntos)
     * Objetos recogidos durante la partida:
     *      - JUGADOR:
     *          - comida: 7 veces
     *          - gemas: 3 veces
     *      - ZARIGUEYA:
     *          - comida: 2 veces
     *          - gemas: 1 vez
     * IMPORTANTE: Se podra emplear el metodo deseado para recorrer las entradas
     * IMPORTANTE: Se debera evitar el autoboxing y el unboxing
     * IMPORTANTE: Se debera emplear StringBuilder para construir la cadena a mostrar
     */
    public static void mostrarObjetosRecogidos() {
        if (contadorObjetosRecogidos.isEmpty()) {
            System.err.println("No se ha recogido ningún objeto");
            return;
        }
        Set<Map.Entry<String, HashMap<String, Integer>>> entradas = contadorObjetosRecogidos.entrySet();
        StringBuilder sb = new StringBuilder("Objetos recogidos durante la partida:\n");
        for (Map.Entry<String, HashMap<String, Integer>> entrada : entradas) {

            if (entrada.getKey().equalsIgnoreCase("jugador")) {
                sb.append("     - JUGADOR:\n");
                if (entrada.getValue() == null) {
                    sb.append("         - El jugador no ha recogido objetos\n");
                }
            }
            if (entrada.getKey().equalsIgnoreCase("zarigueya")) {
                sb.append("     - ZARIGUEYA:\n");
                if (entrada.getValue() == null) {
                    sb.append("         - La zarigueya no ha recogido objetos\n");
                }
            }
            Set<Map.Entry<String, Integer>> entries = entrada.getValue().entrySet();
                for (Map.Entry<String, Integer> entry : entries) {
                    if (entry.getKey().equalsIgnoreCase("comida")) {
                        sb.append("         - comida: ");
                    }
                    if (entry.getKey().equalsIgnoreCase("gema")) {
                        sb.append("         - gema: ");
                    }
                    if (entrada.getValue().get(entry.getKey()) == 1) {
                        sb.append(entrada.getValue().get(entry.getKey())).append(" vez\n");
                    } else {
                        sb.append(entrada.getValue().get(entry.getKey())).append(" veces\n");
                    }
                }
            }
        System.out.println(sb.toString());
    }

    /**
     * TODO: Se debera mostrar por consola quien ha recogido mas objetos en base al HashMap contadorObjetosRecogidos con el siguiente formato (14 puntos)
     * Quien ha recogido mas objetos ha sido... ¡[JUGADOR/ZARIGUEYA] con un total de [XX] objetos!
     * IMPORTANTE: Se debera emplear el metodo values() para sumar la cantidad de objetos
     * IMPORTANTE: Se debera evitar el autoboxing y el unboxing
     * IMPORTANTE: Se debera emplear StringBuilder para construir la cadena a mostrar
     */
    public static void mostrarQuienHaRecogidoMasObjetos() {
        Set<String> claves = contadorObjetosRecogidos.keySet();
        if (claves.size() == 0) {
            throw new NullPointerException("No existen valores");
        }
        StringBuilder sb = new StringBuilder("Quien ha recogido mas objetos ha sido... ¡");
        int objetosJugador = 0;
        int objetosZarigueya = 0;
        for (String clave : claves) {
            if (clave.equalsIgnoreCase("jugador")){
                Iterator<Integer> iterador = contadorObjetosRecogidos.get("jugador").values().iterator();
                if (iterador.hasNext()){
                objetosJugador += iterador.next();
                objetosJugador += iterador.next();
                }
            }
            if (clave.equalsIgnoreCase("zarigueya")){
                Iterator<Integer> iterador = contadorObjetosRecogidos.get("zarigueya").values().iterator();
                if (iterador.hasNext()) {
                    objetosZarigueya += iterador.next();
                    objetosZarigueya += iterador.next();
                }
            }
        }
        if (objetosZarigueya > objetosJugador){
            if (objetosZarigueya == 1){
                sb.append("ZARIGUEYA! con un total de ").append(objetosZarigueya).append(" objeto.");
            }
            else {
            sb.append("ZARIGUEYA! con un total de ").append(objetosZarigueya).append(" objetos.");}
        }
        else if (objetosJugador > objetosZarigueya){
            if (objetosJugador == 1){
            sb.append("JUGADOR! con un total de ").append(objetosZarigueya).append(" objeto.");
            }
            else {
                sb.append("JUGADOR! con un total de ").append(objetosZarigueya).append(" objetos.");
            }
        }
        else {
        throw new NullPointerException("Ambos actores tienen los mismos objetos.");
        }
        System.out.println(sb.toString());
    }


    /**
     * TODO: Se debera incluir al ArrayList historicoDisparos los disparos que se efectuen durante el juego (el orden SI importa) (6 puntos)
     * AVISO: Cuando es certero, se invoca dos veces este metodo, no os preocupeis. Para eso luego teneis que implementar borrarDisparo
     * IMPORTANTE: Se debera evitar el autoboxing y el unboxing
     *
     * @param exito representa si el disparo es certero (true) o fallido (false)
     */
    public static void capturarDisparo(boolean exito) {
        historicoDisparos.add(new Boolean(exito));
    }

    /**
     * TODO: Se debera eliminar el ULTIMO disparo QUE SE INDIQUE del ArrayList historicoDisparos (no vale eliminar cualquiera) (6 puntos)
     * AVISO: Es muy importante implementar correctamente este metodo para que el metodo mostrarRatioPrecision funcione correctamente
     * IMPORTANTE: Se debera evitar el autoboxing y el unboxing
     *
     * @param exito representa si el disparo es certero (true) o fallido (false)
     */
    public static void borrarDisparo(boolean exito) {
        int indice = historicoDisparos.lastIndexOf(new Boolean(exito));
        historicoDisparos.remove(indice);
    }

    /**
     * TODO: Se debera mostrar por consola el porcentaje de precision en base al contenido del ArrayList historicoDisparos con el siguiente formato: (8 puntos)
     * Tienes una precision del [XX]%.
     * Adicionalmente, en base a la precision, se mostrara un mensaje adicional:
     *      Si la precion es entre un 67 y un 100% --> ¡Eres insuperable!
     *      Si la precion es entre un 34 y un 66% --> No esta nada mal
     *      Si la precion es entre un 0 y un 33% --> Deberias entrenar un poco mas...
     * IMPORTANTE: La precision se mide base a los disparos acertados entre el total de disparos
     * IMPORTANTE: Se debera emplear StringBuilder para construir la cadena a mostrar
     */
    public static void mostrarRatioPrecision() {

    }
}
