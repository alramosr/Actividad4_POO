package Ejercicio6_8;

//Importamos las clases necesarias para leer archivos.
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//Creación de la clase LeerArchivo (lee los datos de un archivo de texto con un flujo de bytes).
public class LeerArchivo {

    //Creamos un método que lee un archivo de texto línea por línea y retorna su contenido.
    public static String Leer(String NombreArchivo) throws IOException {

        //Creamos el flujo de bytes, el conversor de bytes a caracteres y el búfer de lectura.
        FileInputStream Archivo = new FileInputStream(NombreArchivo);
        InputStreamReader Conversor = new InputStreamReader(Archivo, "UTF-8");
        BufferedReader Filtro = new BufferedReader(Conversor);

        //Inicializamos una variable para guardar el contenido del archivo.
        String Contenido = "";

        //Leemos la primera línea y, mientras haya líneas, las agregamos al contenido.
        String Linea = Filtro.readLine();
        while (Linea != null){
            Contenido = Contenido + Linea + "\n";
            Linea = Filtro.readLine();
        }

        //Cerramos el archivo.
        Filtro.close();

        //Retornamos el contenido del archivo.
        return Contenido;
    }
}
