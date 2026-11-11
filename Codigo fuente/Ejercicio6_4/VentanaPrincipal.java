package Ejercicio6_4;

//Importamos las clases necesarias para la interfaz gráfica y los eventos.
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//Creación de la clase VentanaPrincipal (ventana para ejecutar el programa PruebaExcepciones y ver su resultado).
public class VentanaPrincipal extends JFrame implements ActionListener {

    //Sección para declaración de atributos.
    Container Contenedor; //Contenedor de los elementos gráficos.
    JLabel Seleccion, TituloResultado; //Etiquetas de la ventana.
    JButton Prueba, Limpiar; //Botones para ejecutar el programa y para limpiar el resultado.
    JTextArea Resultado; //Área de texto donde se muestra lo que imprime cada programa.
    JScrollPane Desplazamiento; //Barras de desplazamiento del área de texto.

    //Creamos el constructor de la ventana.
    public VentanaPrincipal(){

        //Creamos los componentes gráficos de la ventana.
        Inicio();

        //Establecemos el título, el tamaño y la posición de la ventana.
        setTitle("Excepciones");
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

        //Establecemos la etiqueta que indica qué hacer.
        Seleccion = new JLabel();
        Seleccion.setText("Presione el botón para ejecutar el programa PruebaExcepciones:");
        Seleccion.setBounds(20, 15, 400, 23);

        //Establecemos el botón para ejecutar el programa y le agregamos el oyente de eventos.
        Prueba = new JButton();
        Prueba.setText("Ejecutar PruebaExcepciones");
        Prueba.setBounds(20, 45, 230, 25);
        Prueba.addActionListener(this);

        //Establecemos el área de texto donde se muestra el resultado de la ejecución.
        TituloResultado = new JLabel();
        TituloResultado.setText("Resultado de la ejecución:");
        TituloResultado.setBounds(20, 85, 300, 23);
        Resultado = new JTextArea();
        Resultado.setEditable(false);
        Resultado.setFont(new Font("Monospaced", Font.PLAIN, 13));
        Desplazamiento = new JScrollPane(Resultado);
        Desplazamiento.setBounds(20, 110, 500, 200);

        //Establecemos el botón Limpiar y le agregamos el oyente de eventos.
        Limpiar = new JButton();
        Limpiar.setText("Limpiar");
        Limpiar.setBounds(420, 320, 100, 25);
        Limpiar.addActionListener(this);

        //Añadimos cada componente gráfico al contenedor de la ventana.
        Contenedor.add(Seleccion);
        Contenedor.add(Prueba);
        Contenedor.add(TituloResultado);
        Contenedor.add(Desplazamiento);
        Contenedor.add(Limpiar);
    }

    //Creamos un método para gestionar los eventos generados en la ventana.
    @Override
    public void actionPerformed(ActionEvent Evento){

        //Si se pulsa el botón Ejecutar PruebaExcepciones se ejecuta el programa y se muestra lo que imprime.
        if (Evento.getSource() == Prueba){
            Resultado.append("> PruebaExcepciones\n" + PruebaExcepciones.EjecutarPrueba() + "\n");
        }

        //Si se pulsa el botón Limpiar se borra el resultado.
        if (Evento.getSource() == Limpiar){
            Resultado.setText("");
        }
    }
}
