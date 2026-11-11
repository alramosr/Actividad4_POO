package Ejercicio6_7;

//Creación de la clase Programador (integrante de un equipo de la maratón de programación).
public class Programador {

    //Sección para declaración de atributos.
    String Nombre;
    String Apellidos;

    //Creamos el constructor que inicializa el nombre y los apellidos del programador.
    public Programador(String Nombre, String Apellidos){

        //Asignamos los valores recibidos a los atributos.
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
    }

    //Creamos un método get para el nombre.
    public String GetNombre(){

        //Retornamos el nombre.
        return Nombre;
    }

    //Creamos un método get para los apellidos.
    public String GetApellidos(){

        //Retornamos los apellidos.
        return Apellidos;
    }

    //Creamos un método set para el nombre.
    public void SetNombre(String Nombre){

        //Asignamos el nuevo nombre.
        this.Nombre = Nombre;
    }

    //Creamos un método set para los apellidos.
    public void SetApellidos(String Apellidos){

        //Asignamos los nuevos apellidos.
        this.Apellidos = Apellidos;
    }
}
