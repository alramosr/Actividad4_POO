package Ejercicio6_4;

//Creación de la clase PruebaExcepciones (lanza diferentes excepciones en situaciones específicas del programa).
public class PruebaExcepciones {

    //Creamos un método con los dos bloques try del libro que generan excepciones.
    public static String EjecutarPrueba(){

        //Inicializamos una variable para guardar los mensajes que se van generando.
        String Resultado = "";

        //Primer bloque try.
        try {
            Resultado = Resultado + "Ingresando al primer try\n";
            double Cociente = 10000 / 0; //Se lanza una excepción.
            Resultado = Resultado + "Después de la división\n"; //Esta instrucción nunca será ejecutada.
        } catch (ArithmeticException Error){
            //Se captura la excepción y se guarda este mensaje.
            Resultado = Resultado + "División por cero\n";
        } finally {
            //La sentencia finally siempre se ejecuta, ocurra o no una excepción.
            Resultado = Resultado + "Ingresando al primer finally\n";
        }

        //Segundo bloque try.
        try {
            Resultado = Resultado + "Ingresando al segundo try\n";
            Object Objeto = null;
            Objeto.toString(); //Se lanza una excepción.
            Resultado = Resultado + "Imprimiendo objeto\n"; //Esta instrucción nunca será ejecutada.
        } catch (ArithmeticException Error){
            //La excepción lanzada no es de este tipo.
            Resultado = Resultado + "División por cero\n";
        } catch (Exception Error){
            //Se captura la excepción y se guarda este mensaje.
            Resultado = Resultado + "Ocurrió una excepción\n";
        } finally {
            //La sentencia finally siempre se ejecuta, ocurra o no una excepción.
            Resultado = Resultado + "Ingresando al segundo finally\n";
        }

        //Retornamos los mensajes generados.
        return Resultado;
    }
}
