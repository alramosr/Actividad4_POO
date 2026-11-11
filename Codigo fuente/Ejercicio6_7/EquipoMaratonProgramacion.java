package Ejercicio6_7;

//Creación de la clase EquipoMaratonProgramacion (equipo de programadores que participa en una maratón de programación).
public class EquipoMaratonProgramacion {

    //Sección para declaración de atributos.
    String NombreEquipo;
    String Universidad;
    String LenguajeProgramacion;
    Programador[] Programadores; //Programadores que conforman el equipo.
    int TamanioEquipo; //Cantidad de programadores que hay en el equipo.

    //Creamos el constructor que inicializa los atributos del equipo.
    public EquipoMaratonProgramacion(String NombreEquipo, String Universidad, String LenguajeProgramacion){

        //Asignamos los valores recibidos a los atributos.
        this.NombreEquipo = NombreEquipo;
        this.Universidad = Universidad;
        this.LenguajeProgramacion = LenguajeProgramacion;

        //El tamaño del equipo inicialmente es cero y se crea un array para máximo tres programadores.
        TamanioEquipo = 0;
        Programadores = new Programador[3];
    }

    //Creamos un método get para el nombre del equipo.
    public String GetNombreEquipo(){

        //Retornamos el nombre del equipo.
        return NombreEquipo;
    }

    //Creamos un método get para la universidad.
    public String GetUniversidad(){

        //Retornamos la universidad.
        return Universidad;
    }

    //Creamos un método get para el lenguaje de programación.
    public String GetLenguajeProgramacion(){

        //Retornamos el lenguaje de programación.
        return LenguajeProgramacion;
    }

    //Creamos un método get para los programadores.
    public Programador[] GetProgramadores(){

        //Retornamos los programadores.
        return Programadores;
    }

    //Creamos un método get para el tamaño del equipo.
    public int GetTamanioEquipo(){

        //Retornamos el tamaño del equipo.
        return TamanioEquipo;
    }

    //Creamos un método set para el nombre del equipo.
    public void SetNombreEquipo(String NombreEquipo){

        //Asignamos el nuevo nombre del equipo.
        this.NombreEquipo = NombreEquipo;
    }

    //Creamos un método set para la universidad.
    public void SetUniversidad(String Universidad){

        //Asignamos la nueva universidad.
        this.Universidad = Universidad;
    }

    //Creamos un método set para el lenguaje de programación.
    public void SetLenguajeProgramacion(String LenguajeProgramacion){

        //Asignamos el nuevo lenguaje de programación.
        this.LenguajeProgramacion = LenguajeProgramacion;
    }

    //Creamos un método set para los programadores.
    public void SetProgramadores(Programador[] Programadores){

        //Asignamos los nuevos programadores.
        this.Programadores = Programadores;
    }

    //Creamos un método set para el tamaño del equipo.
    public void SetTamanioEquipo(int TamanioEquipo){

        //Asignamos el nuevo tamaño del equipo.
        this.TamanioEquipo = TamanioEquipo;
    }

    //Creamos un método para determinar si el equipo está lleno (tiene tres programadores).
    public boolean EstaLleno(){

        //Retornamos si el tamaño del equipo es igual a la capacidad del array.
        return TamanioEquipo == Programadores.length;
    }

    //Creamos un método para añadir un programador al equipo.
    public void Aniadir(Programador MiProgramador) throws Exception {

        //Si el equipo está lleno se lanza la excepción correspondiente.
        if (EstaLleno()){
            throw new Exception("El equipo está completo. No se pudo agregar programador.");
        }

        //Asignamos el programador al array y aumentamos el tamaño del equipo.
        Programadores[TamanioEquipo] = MiProgramador;
        TamanioEquipo = TamanioEquipo + 1;
    }

    //Creamos un método para verificar que el equipo tenga mínimo dos programadores.
    public void VerificarTamanioMinimo() throws Exception {

        //Si el equipo tiene menos de dos programadores se lanza la excepción correspondiente.
        if (TamanioEquipo < 2){
            throw new Exception("El equipo debe tener mínimo dos programadores.");
        }
    }

    //Creamos un método para validar que un campo obligatorio no esté vacío.
    public static void ValidarObligatorio(String Campo, String NombreCampo) throws Exception {

        //Si el campo está vacío se lanza la excepción correspondiente.
        if (Campo.trim().isEmpty()){
            throw new Exception("El campo " + NombreCampo + " es obligatorio.");
        }
    }

    //Creamos un método para validar el nombre o los apellidos de un programador.
    public static void ValidarCampo(String Campo) throws Exception {

        //El campo es obligatorio, si está vacío se lanza la excepción correspondiente.
        if (Campo.trim().isEmpty()){
            throw new Exception("El nombre y los apellidos no pueden estar vacíos.");
        }

        //Recorremos el campo, si un carácter es un dígito se lanza la excepción correspondiente.
        for (int j = 0; j < Campo.length(); j++){
            char Caracter = Campo.charAt(j);
            if (Character.isDigit(Caracter)){
                throw new Exception("El campo \"" + Campo + "\" no puede tener dígitos.");
            }
        }

        //Si la longitud del campo es igual o superior a 20 caracteres se lanza la excepción correspondiente.
        if (Campo.length() >= 20){
            throw new Exception("La longitud del campo no debe ser igual o superior a 20 caracteres.");
        }
    }

    //Creamos un método que retorna los datos del equipo para imprimirlos en la ventana.
    public String Imprimir(){

        //Inicializamos una variable con los datos del equipo.
        String Datos = "Equipo: " + NombreEquipo + "\n"
                + "Universidad: " + Universidad + "\n"
                + "Lenguaje de programación: " + LenguajeProgramacion + "\n"
                + "Integrantes (" + TamanioEquipo + "):\n";

        //Recorremos los programadores agregando el nombre y los apellidos de cada uno.
        for (int i = 0; i < TamanioEquipo; i++){
            Datos = Datos + "   " + (i + 1) + ". " + Programadores[i].GetNombre() + " " + Programadores[i].GetApellidos() + "\n";
        }

        //Retornamos la variable.
        return Datos;
    }
}
