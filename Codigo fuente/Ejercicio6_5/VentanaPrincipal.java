package Ejercicio6_5;

//Importamos las clases necesarias para la interfaz gráfica y los eventos.
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//Creación de la clase VentanaPrincipal (ventana para ingresar los datos de un vendedor y verificar su edad).
public class VentanaPrincipal extends JFrame implements ActionListener {

    //Sección para declaración de atributos.
    Container Contenedor; //Contenedor de los elementos gráficos.
    JLabel Nombre, Apellidos, Edad, TituloDatos; //Etiquetas de la ventana.
    JTextField CampoNombre, CampoApellidos, CampoEdad; //Campos de ingreso de los datos.
    JButton VerificarEdad; //Botón para crear el vendedor y verificar su edad.
    JTextArea Datos; //Área de texto donde se muestran los datos del vendedor.

    //Creamos el constructor de la ventana.
    public VentanaPrincipal(){

        //Creamos los componentes gráficos de la ventana.
        Inicio();

        //Establecemos el título, el tamaño y la posición de la ventana.
        setTitle("Vendedor");
        setSize(440, 330);
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

        //Establecemos la etiqueta y el campo de texto para el nombre.
        Nombre = new JLabel();
        Nombre.setText("Nombre:");
        Nombre.setBounds(20, 20, 120, 23);
        CampoNombre = new JTextField();
        CampoNombre.setBounds(130, 20, 270, 23);

        //Establecemos la etiqueta y el campo de texto para los apellidos.
        Apellidos = new JLabel();
        Apellidos.setText("Apellidos:");
        Apellidos.setBounds(20, 50, 120, 23);
        CampoApellidos = new JTextField();
        CampoApellidos.setBounds(130, 50, 270, 23);

        //Establecemos la etiqueta y el campo de texto para la edad.
        Edad = new JLabel();
        Edad.setText("Edad:");
        Edad.setBounds(20, 80, 120, 23);
        CampoEdad = new JTextField();
        CampoEdad.setBounds(130, 80, 270, 23);

        //Establecemos el botón para verificar la edad y le agregamos el oyente de eventos.
        VerificarEdad = new JButton();
        VerificarEdad.setText("Verificar edad");
        VerificarEdad.setBounds(130, 120, 180, 25);
        VerificarEdad.addActionListener(this);

        //Establecemos el área de texto donde se muestran los datos del vendedor.
        TituloDatos = new JLabel();
        TituloDatos.setText("Datos del vendedor:");
        TituloDatos.setBounds(20, 160, 200, 23);
        Datos = new JTextArea();
        Datos.setEditable(false);
        Datos.setBounds(20, 185, 380, 80);

        //Añadimos cada componente gráfico al contenedor de la ventana.
        Contenedor.add(Nombre);
        Contenedor.add(CampoNombre);
        Contenedor.add(Apellidos);
        Contenedor.add(CampoApellidos);
        Contenedor.add(Edad);
        Contenedor.add(CampoEdad);
        Contenedor.add(VerificarEdad);
        Contenedor.add(TituloDatos);
        Contenedor.add(Datos);
    }

    //Creamos un método para gestionar los eventos generados en la ventana.
    @Override
    public void actionPerformed(ActionEvent Evento){

        //Si se pulsa Verificar edad se crea el vendedor y luego se verifica su edad.
        if (Evento.getSource() == VerificarEdad){
            try {
                //Obtenemos y convertimos la edad ingresada.
                int ValorEdad = Integer.parseInt(CampoEdad.getText().trim());

                //Creamos el vendedor y verificamos su edad.
                Vendedor MiVendedor = new Vendedor(CampoNombre.getText(), CampoApellidos.getText());
                MiVendedor.VerificarEdad(ValorEdad);

                //Si no se lanzó ninguna excepción mostramos los datos del vendedor.
                Datos.setText(MiVendedor.Imprimir());
            } catch (NumberFormatException Error){
                //Si la edad no es un número entero se muestra un mensaje de error.
                JOptionPane.showMessageDialog(this, "La edad debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException Error){
                //Si la edad no cumple los requisitos se muestra la excepción lanzada.
                Datos.setText("");
                JOptionPane.showMessageDialog(this, "IllegalArgumentException: " + Error.getMessage(), "Excepción", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
