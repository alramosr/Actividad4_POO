package Ejercicio6_5;

//Creación de la clase Vendedor.
public class Vendedor {

    //Sección para declaración de atributos.
    String Nombre;
    String Apellidos;
    int Edad;

    //Creamos el constructor que inicializa el nombre y los apellidos del vendedor.
    public Vendedor(String Nombre, String Apellidos){

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

    //Creamos un método get para la edad.
    public int GetEdad(){

        //Retornamos la edad.
        return Edad;
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

    //Creamos un método set para la edad (la edad se verifica antes de asignarla).
    public void SetEdad(int Edad){

        //Verificamos y asignamos la nueva edad.
        VerificarEdad(Edad);
    }

    //Creamos un método que retorna los datos del vendedor para imprimirlos en la ventana.
    public String Imprimir(){

        //Inicializamos una variable con los datos del vendedor.
        String Datos = "Nombre del vendedor = " + Nombre + "\n"
                + "Apellidos del vendedor = " + Apellidos + "\n"
                + "Edad del vendedor = " + Edad;

        //Retornamos la variable.
        return Datos;
    }

    //Creamos un método que verifica la edad del vendedor y lanza las excepciones correspondientes.
    public void VerificarEdad(int Edad){

        //La edad debe estar en el rango de 0 a 120, si no se cumple se lanza una excepción de argumento ilegal.
        if (Edad < 0 || Edad > 120){
            throw new IllegalArgumentException("La edad no puede ser negativa ni mayor a 120.");
        }

        //El vendedor debe ser mayor de edad, si no se cumple se lanza una excepción de argumento ilegal.
        if (Edad < 18){
            throw new IllegalArgumentException("El vendedor debe ser mayor de 18 años.");
        }

        //Si la edad cumple los requisitos se asigna al vendedor.
        this.Edad = Edad;
    }
}
