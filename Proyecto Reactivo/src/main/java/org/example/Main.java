package org.example;
import io.reactivex.rxjava3.core.Observable;

public class Main {

    public static void main(String[] args) {
        // Crear dos observables "observable1", "observable2" que emiten números del 1 al 3

        Observable<Integer> observable1 = Observable.just(1, 2, 3);
        Observable<Integer> observable2 = Observable.just(4, 5, 6);

        // Concatenar los dos observables
        Observable<Integer> concatenado = Observable.concat(observable1, observable2); //Concatena "observable1", "observable2"

        // Transformar los números emisores mediante el operador map
        Observable<String> transformador = concatenado
                .map(e -> "Transformado: " + e); //Lo que hace es hacer un map a "concatenado" y agrega la palabra
                                                 //"Transformado" junto con el valor.

        // Suscribirse e imprimir los elementos transformados


        transformador.subscribe(
                informacion -> System.out.println("Recibido: " + informacion),              //"informacion" printea en pantalla lo que le llega de la suscripcion del transformador.
                error -> System.err.println("Se produjo un error: " + error.getMessage()),       //Mostrar el mensaje de error
                () -> System.out.println("¡Completo!")                                          //presenta en pantalla cuando toda la secuencia se ha completado
        );

    }

}

