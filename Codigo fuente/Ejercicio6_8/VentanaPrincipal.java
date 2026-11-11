package Ejercicio6_8;

//Importamos las clases necesarias para la interfaz gráfica, los eventos y los archivos.
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//Creación de la clase VentanaPrincipal (ventana para leer el archivo prueba.txt y mostrar su contenido).
public class VentanaPrincipal extends JFrame implements ActionListener {

    //Sección para declaración de atributos.
    Container Contenedor; //Contenedor de los elementos gráficos.
    JLabel Archivo, TituloContenido; //Etiquetas de la ventana.
    JButton Leer, Limpiar; //Botones para leer el archivo y para borrar el contenido mostrado.
    JTextArea Contenido; //Área de texto donde se muestra el contenido del archivo.
    JScrollPane Desplazamiento; //Barras de desplazamiento del área de texto.
    String NombreArchivo; //Ruta del archivo prueba.txt que se va a leer.

    //Creamos el constructor de la ventana.
    public VentanaPrincipal(){

        //Buscamos el archivo prueba.txt que acompaña al programa; si no se encuentra se deja solo el nombre.
        try {
            NombreArchivo = new File(getClass().getResource("prueba.txt").toURI()).getPath();
        } catch (Exception Error){
            NombreArchivo = "prueba.txt";
        }

        //Creamos los componentes gráficos de la ventana.
        Inicio();

        //Establecemos el título, el tamaño y la posición de la ventana.
        setTitle("Lectura de archivos");
        setSize(560, 400);
        setLocationRelativeTo(null);

        //Establecemos que el botón de cerrar termina la aplicación y que el tamaño no se puede cambiar.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    //Creamos un método para crear la ventana con sus componentes gráficos.
    private void Inicio(){

        //Obtenemos el panel de contenidos de la ventana y le quitamos el layout.
        Contenedor = getContentPane();
        Contenedor.setLayout(null);

        //Establecemos la etiqueta con el nombre del archivo que se va a leer.
        Archivo = new JLabel();
        Archivo.setText("Archivo: " + new File(NombreArchivo).getName());
        Archivo.setToolTipText(NombreArchivo);
        Archivo.setBounds(20, 20, 300, 23);

        //Establecemos el botón Leer archivo y le agregamos el oyente de eventos.
        Leer = new JButton();
        Leer.setText("Leer archivo");
        Leer.setBounds(320, 20, 200, 25);
        Leer.addActionListener(this);

        //Establecemos el área de texto donde se muestra el contenido del archivo.
        TituloContenido = new JLabel();
        TituloContenido.setText("Contenido del archivo:");
        TituloContenido.setBounds(20, 60, 300, 23);
        Contenido = new JTextArea();
        Contenido.setEditable(false);
        Contenido.setFont(new Font("Monospaced", Font.PLAIN, 13));
        Desplazamiento = new JScrollPane(Contenido);
        Desplazamiento.setBounds(20, 85, 500, 225);

        //Establecemos el botón Limpiar y le agregamos el oyente de eventos.
        Limpiar = new JButton();
        Limpiar.setText("Limpiar");
        Limpiar.setBounds(420, 320, 100, 25);
        Limpiar.addActionListener(this);

        //Añadimos cada componente gráfico al contenedor de la ventana.
        Contenedor.add(Archivo);
        Contenedor.add(Leer);
        Contenedor.add(TituloContenido);
        Contenedor.add(Desplazamiento);
        Contenedor.add(Limpiar);
    }

    //Creamos un método para gestionar los eventos generados en la ventana.
    @Override
    public void actionPerformed(ActionEvent Evento){

        //Si se pulsa Leer archivo se lee el archivo prueba.txt y se muestra su contenido.
        if (Evento.getSource() == Leer){
            try {
                Contenido.setText(LeerArchivo.Leer(NombreArchivo));
            } catch (IOException Error){
                //Si el archivo no se puede leer se muestra un mensaje de error.
                Contenido.setText("");
                JOptionPane.showMessageDialog(this, "No se pudo leer el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        //Si se pulsa Limpiar se borra el contenido mostrado.
        if (Evento.getSource() == Limpiar){
            Contenido.setText("");
        }
    }
}
