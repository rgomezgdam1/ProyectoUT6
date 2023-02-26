package es.mariaanasanz.proyecto6.ejercicios;

import javafx.scene.input.KeyCode;

import java.util.*;

public class Estadisticas {

    private static LinkedHashMap<KeyCode, Integer> contadorEventosTeclado;
    private static HashMap<String, HashMap<String, Integer>> contadorObjetosRecogidos;
    private static ArrayList<Boolean> historicoDisparos;

    public Estadisticas() {
        contadorEventosTeclado = new LinkedHashMap<>();
        contadorObjetosRecogidos = new HashMap<>();
        historicoDisparos = new ArrayList<Boolean>();
    }

    public static void mostrarEstadisticasSeguro(){
        try {
            System.out.println("****************************************");
            mostrarEventosTeclado();
            System.out.println("****************************************");
            KeyCode code = teclaMasPulsada();
            if(code!=null) {
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
        switch (code){
            case RIGHT: contadorEventosTeclado.put(KeyCode.RIGHT,new Integer(contadorEventosTeclado.size()));
            break;
            case LEFT: contadorEventosTeclado.put(KeyCode.LEFT,new Integer(contadorEventosTeclado.size()));
            break;
            case SHIFT: contadorEventosTeclado.put(KeyCode.SHIFT,new Integer(contadorEventosTeclado.size()));
            break;
            case ESCAPE: contadorEventosTeclado.put(KeyCode.ESCAPE,new Integer(contadorEventosTeclado.size()));
            break;
            default: contadorEventosTeclado.put(KeyCode.ASTERISK,new Integer(contadorEventosTeclado.size()));
            break;
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
    public static void mostrarEventosTeclado(){

        Set<Map.Entry<KeyCode, Integer>> entradas = contadorEventosTeclado.entrySet();
        StringBuilder sb = new StringBuilder("Teclas pulsadas durante la partida:\n");

        int countRight = 0;
        int countLeft = 0;
        int countShift = 0;
        int countEscape = 0;
        int countElse = 0;
        for (Map.Entry<KeyCode, Integer> entrada : entradas) {
            if (entrada.getKey().equals(KeyCode.RIGHT)){
                countRight++;
            }
            else if (entrada.getKey().equals(KeyCode.LEFT)){
                countLeft++;
            }
            else if (entrada.getKey().equals(KeyCode.SHIFT)){
                countShift++;
            }
            else if (entrada.getKey().equals(KeyCode.ESCAPE)){
                countEscape++;
            }
            else {
                countElse++;
            }
        }
        if (countRight == 1){
            sb.append("     - RIGHT: ").append(countRight).append(" vez\n");
        }
        else {
            sb.append("     - RIGHT: ").append(countRight).append(" veces\n");
        }
        if (countLeft == 1){
            sb.append("     - LEFT: ").append(countLeft).append(" vez\n");
        }
        else {
            sb.append("     - LEFT: ").append(countLeft).append(" veces\n");
        }
        if (countShift == 1){
            sb.append("     - SHIFT: ").append(countShift).append(" vez\n");
        }
        else {
            sb.append("     - SHIFT: ").append(countShift).append(" veces\n");
        }
        if (countEscape == 1){
            sb.append("     - ESCAPE: ").append(countEscape).append(" vez\n");
        }
        else {
            sb.append("     - ESCAPE: ").append(countEscape).append(" veces\n");
        }
        if (countElse == 1){
            sb.append("     - OTROS: ").append(countElse).append(" vez\n");
        }
        else {
            sb.append("     - OTROS: ").append(countElse).append(" veces\n");
        }
        System.out.println(sb.toString());
    }

    /**
     * TODO: debera devolver el evento con mas ocurrencias del LinkedHashMap contadorEventosTeclado (6 puntos)
     * IMPORTANTE: Se debera emplear el metodo keySet() para recorrer las entradas
     * IMPORTANTE: Si el juego se cierra sin pulsar ninguna tecla, devera devolver KeyCode.ESCAPE
     * @return KeyCode mas frecuente
     */
    public static KeyCode teclaMasPulsada(){
        return null;
    }

    /**
     * TODO: se debera almacenar la relacion de objetos que recoge cada actor en el HashMap contadorObjetosRecogidos (12 puntos)
     * IMPORTANTE: la primera clave del HashMap contadorObjetosRecogidos sera el actor
     * IMPORTANTE: para cada actor habra otro hashmap asociado con la relacion de objetos y las veces que estos se han recogido
     * IMPORTANTE: Se debera evitar el autoboxing y el unboxing
     * @param actor sera o el jugador o la zarigueya
     * @param objeto sera o la comida o la gema
     */
    public static void objetoRecogido(String actor, String objeto){

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
    public static void mostrarObjetosRecogidos(){

    }

    /**
     * TODO: Se debera mostrar por consola quien ha recogido mas objetos en base al HashMap contadorObjetosRecogidos con el siguiente formato (14 puntos)
     * Quien ha recogido mas objetos ha sido... ¡[JUGADOR/ZARIGUEYA] con un total de [XX] objetos!
     * IMPORTANTE: Se debera emplear el metodo values() para sumar la cantidad de objetos
     * IMPORTANTE: Se debera evitar el autoboxing y el unboxing
     * IMPORTANTE: Se debera emplear StringBuilder para construir la cadena a mostrar
     */
    public static void mostrarQuienHaRecogidoMasObjetos(){

    }

    /**
     * TODO: Se debera incluir al ArrayList historicoDisparos los disparos que se efectuen durante el juego (el orden SI importa) (6 puntos)
     * AVISO: Cuando es certero, se invoca dos veces este metodo, no os preocupeis. Para eso luego teneis que implementar borrarDisparo
     * IMPORTANTE: Se debera evitar el autoboxing y el unboxing
     * @param exito representa si el disparo es certero (true) o fallido (false)
     */
    public static void capturarDisparo(boolean exito){

    }

    /**
     * TODO: Se debera eliminar el ULTIMO disparo QUE SE INDIQUE del ArrayList historicoDisparos (no vale eliminar cualquiera) (6 puntos)
     * AVISO: Es muy importante implementar correctamente este metodo para que el metodo mostrarRatioPrecision funcione correctamente
     * IMPORTANTE: Se debera evitar el autoboxing y el unboxing
     * @param exito representa si el disparo es certero (true) o fallido (false)
     */
    public static void borrarDisparo(boolean exito){

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
    public static void mostrarRatioPrecision(){

    }

    public static LinkedHashMap<KeyCode, Integer> getContadorEventosTeclado() {
        return contadorEventosTeclado;
    }
}
