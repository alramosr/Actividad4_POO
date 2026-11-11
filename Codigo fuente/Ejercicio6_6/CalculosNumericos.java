package Ejercicio6_6;

//Creación de la clase CalculosNumericos (cálculos matemáticos que lanzan excepciones si los datos no son correctos).
public class CalculosNumericos {

    //Creamos un método para calcular el logaritmo neperiano de un valor.
    public static double CalcularLogaritmoNeperiano(double Valor){

        //Si el valor no es positivo se lanza una excepción aritmética.
        if (Valor <= 0){
            throw new ArithmeticException("El valor debe ser un número positivo para calcular el logaritmo");
        }

        //Inicializamos una variable para guardar el cálculo del logaritmo neperiano.
        double Resultado = Math.log(Valor);

        //Retornamos la variable.
        return Resultado;
    }

    //Creamos un método para calcular la raíz cuadrada de un valor.
    public static double CalcularRaizCuadrada(double Valor){

        //Si el valor es negativo se lanza una excepción aritmética.
        if (Valor < 0){
            throw new ArithmeticException("El valor debe ser un número positivo para calcular la raíz cuadrada");
        }

        //Inicializamos una variable para guardar el cálculo de la raíz cuadrada.
        double Resultado = Math.sqrt(Valor);

        //Retornamos la variable.
        return Resultado;
    }
}
