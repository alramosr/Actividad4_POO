package Ejercicio6_7;

//Importamos las clases necesarias para la interfaz gráfica y los eventos.
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//Creación de la clase VentanaPrincipal (ventana para crear un equipo de la maratón y añadir sus integrantes).
public class VentanaPrincipal extends JFrame implements ActionListener {

    //Sección para declaración de atributos.
    Container Contenedor; //Contenedor de los elementos gráficos.
    JLabel DatosEquipo, NombreEquipo, Universidad, Lenguaje; //Etiquetas de los datos del equipo.
    JLabel DatosIntegrante, Nombre, Apellidos, Estado; //Etiquetas de los datos de cada integrante y del estado.
    JTextField CampoNombreEquipo, CampoUniversidad, CampoLenguaje; //Campos de ingreso de los datos del equipo.
    JTextField CampoNombre, CampoApellidos; //Campos de ingreso de los datos de cada integrante.
    JButton CrearEquipo, AniadirIntegrante, RegistrarEquipo; //Botones de la ventana.
    JTextArea Integrantes; //Área de texto con los integrantes del equipo.
    JScrollPane Desplazamiento; //Barras de desplazamiento del área de texto.
    EquipoMaratonProgramacion MiEquipo; //Equipo que se crea en la ventana.

    //Creamos el constructor de la ventana.
    public VentanaPrincipal(){

        //Creamos los componentes gráficos de la ventana.
        Inicio();

        //Establecemos el título, el tamaño y la posición de la ventana.
        setTitle("Equipo maratón de programación");
        setSize(545, 500);
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

        //Establecemos las etiquetas y los campos de texto de los datos del equipo.
        DatosEquipo = new JLabel();
        DatosEquipo.setText("Datos del equipo");
        DatosEquipo.setBounds(20, 10, 300, 23);
        NombreEquipo = new JLabel();
        NombreEquipo.setText("Nombre del equipo:");
        NombreEquipo.setBounds(20, 40, 170, 23);
        CampoNombreEquipo = new JTextField();
        CampoNombreEquipo.setBounds(200, 40, 310, 23);
        Universidad = new JLabel();
        Universidad.setText("Universidad:");
        Universidad.setBounds(20, 70, 170, 23);
        CampoUniversidad = new JTextField();
        CampoUniversidad.setBounds(200, 70, 310, 23);
        Lenguaje = new JLabel();
        Lenguaje.setText("Lenguaje de programación:");
        Lenguaje.setBounds(20, 100, 180, 23);
        CampoLenguaje = new JTextField();
        CampoLenguaje.setBounds(200, 100, 310, 23);

        //Establecemos el botón Crear equipo y le agregamos el oyente de eventos.
        CrearEquipo = new JButton();
        CrearEquipo.setText("Crear equipo");
        CrearEquipo.setBounds(200, 132, 150, 25);
        CrearEquipo.addActionListener(this);

        //Establecemos las etiquetas y los campos de texto de los datos de cada integrante.
        DatosIntegrante = new JLabel();
        DatosIntegrante.setText("Datos del integrante");
        DatosIntegrante.setBounds(20, 170, 300, 23);
        Nombre = new JLabel();
        Nombre.setText("Nombre:");
        Nombre.setBounds(20, 200, 170, 23);
        CampoNombre = new JTextField();
        CampoNombre.setBounds(200, 200, 310, 23);
        Apellidos = new JLabel();
        Apellidos.setText("Apellidos:");
        Apellidos.setBounds(20, 230, 170, 23);
        CampoApellidos = new JTextField();
        CampoApellidos.setBounds(200, 230, 310, 23);

        //Establecemos los botones para añadir integrantes y registrar el equipo.
        AniadirIntegrante = new JButton();
        AniadirIntegrante.setText("Añadir integrante");
        AniadirIntegrante.setBounds(200, 262, 150, 25);
        AniadirIntegrante.addActionListener(this);
        RegistrarEquipo = new JButton();
        RegistrarEquipo.setText("Registrar equipo");
        RegistrarEquipo.setBounds(360, 262, 150, 25);
        RegistrarEquipo.addActionListener(this);

        //Establecemos el área de texto con los integrantes y la etiqueta del estado del equipo.
        Integrantes = new JTextArea();
        Integrantes.setEditable(false);
        Desplazamiento = new JScrollPane(Integrantes);
        Desplazamiento.setBounds(20, 300, 490, 115);
        Estado = new JLabel();
        Estado.setText("Primero cree el equipo.");
        Estado.setBounds(20, 422, 490, 23);

        //Añadimos cada componente gráfico al contenedor de la ventana.
        Contenedor.add(DatosEquipo);
        Contenedor.add(NombreEquipo);
        Contenedor.add(CampoNombreEquipo);
        Contenedor.add(Universidad);
        Contenedor.add(CampoUniversidad);
        Contenedor.add(Lenguaje);
        Contenedor.add(CampoLenguaje);
        Contenedor.add(CrearEquipo);
        Contenedor.add(DatosIntegrante);
        Contenedor.add(Nombre);
        Contenedor.add(CampoNombre);
        Contenedor.add(Apellidos);
        Contenedor.add(CampoApellidos);
        Contenedor.add(AniadirIntegrante);
        Contenedor.add(RegistrarEquipo);
        Contenedor.add(Desplazamiento);
        Contenedor.add(Estado);
    }

    //Creamos un método para mostrar cuántos integrantes tiene el equipo y si está lleno.
    private void ActualizarEstado(){

        //Escribimos el estado del equipo en la etiqueta.
        Estado.setText("Integrantes: " + MiEquipo.GetTamanioEquipo() + " de 3   |   Equipo lleno: " + (MiEquipo.EstaLleno() ? "sí" : "no"));
    }

    //Creamos un método para mostrar una excepción en un cuadro de diálogo.
    private void MostrarExcepcion(Exception Error){

        //Mostramos el mensaje de la excepción.
        JOptionPane.showMessageDialog(this, "Exception: " + Error.getMessage(), "Excepción", JOptionPane.ERROR_MESSAGE);
    }

    //Creamos un método para gestionar los eventos generados en la ventana.
    @Override
    public void actionPerformed(ActionEvent Evento){

        //Si se pulsa Crear equipo se validan los campos obligatorios y se crea el equipo.
        if (Evento.getSource() == CrearEquipo){
            try {
                EquipoMaratonProgramacion.ValidarObligatorio(CampoNombreEquipo.getText(), "nombre del equipo");
                EquipoMaratonProgramacion.ValidarObligatorio(CampoUniversidad.getText(), "universidad");
                EquipoMaratonProgramacion.ValidarObligatorio(CampoLenguaje.getText(), "lenguaje de programación");
                MiEquipo = new EquipoMaratonProgramacion(CampoNombreEquipo.getText().trim(), CampoUniversidad.getText().trim(), CampoLenguaje.getText().trim());
                Integrantes.setText("Equipo " + MiEquipo.GetNombreEquipo() + " creado. Integrantes:\n");
                ActualizarEstado();
            } catch (Exception Error){
                MostrarExcepcion(Error);
            }
        }

        //Si se pulsa Añadir integrante se validan el nombre y los apellidos y se añade el programador.
        if (Evento.getSource() == AniadirIntegrante){

            //Si todavía no hay equipo no se puede añadir el integrante.
            if (MiEquipo == null){
                JOptionPane.showMessageDialog(this, "Primero debe crear el equipo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                String NombreIntegrante = CampoNombre.getText().trim();
                String ApellidosIntegrante = CampoApellidos.getText().trim();
                EquipoMaratonProgramacion.ValidarCampo(NombreIntegrante);
                EquipoMaratonProgramacion.ValidarCampo(ApellidosIntegrante);
                MiEquipo.Aniadir(new Programador(NombreIntegrante, ApellidosIntegrante));
                Integrantes.append("   " + MiEquipo.GetTamanioEquipo() + ". " + NombreIntegrante + " " + ApellidosIntegrante + "\n");
                CampoNombre.setText("");
                CampoApellidos.setText("");
                ActualizarEstado();
            } catch (Exception Error){
                MostrarExcepcion(Error);
            }
        }

        //Si se pulsa Registrar equipo se verifica que tenga mínimo dos integrantes y se muestran sus datos.
        if (Evento.getSource() == RegistrarEquipo){

            //Si todavía no hay equipo no se puede registrar.
            if (MiEquipo == null){
                JOptionPane.showMessageDialog(this, "Primero debe crear el equipo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                MiEquipo.VerificarTamanioMinimo();
                JOptionPane.showMessageDialog(this, "Equipo registrado correctamente.\n\n" + MiEquipo.Imprimir(), "Equipo registrado", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception Error){
                MostrarExcepcion(Error);
            }
        }
    }
}
