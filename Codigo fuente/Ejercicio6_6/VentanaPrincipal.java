package Ejercicio6_6;

//Importamos las clases necesarias para la interfaz gráfica y los eventos.
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//Creación de la clase VentanaPrincipal (ventana para calcular el logaritmo neperiano y la raíz cuadrada de un valor).
public class VentanaPrincipal extends JFrame implements ActionListener {

    //Sección para declaración de atributos.
    Container Contenedor; //Contenedor de los elementos gráficos.
    JLabel Valor; //Etiqueta del valor a ingresar.
    JLabel Logaritmo, Raiz; //Etiquetas de los resultados.
    JTextField CampoValor; //Campo de ingreso del valor numérico.
    JButton Calcular; //Botón para hacer los cálculos.

    //Creamos el constructor de la ventana.
    public VentanaPrincipal(){

        //Creamos los componentes gráficos de la ventana.
        Inicio();

        //Establecemos el título, el tamaño y la posición de la ventana.
        setTitle("Cálculos numéricos");
        setSize(520, 200);
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

        //Establecemos la etiqueta y el campo de texto para el valor numérico.
        Valor = new JLabel();
        Valor.setText("Valor numérico:");
        Valor.setBounds(20, 20, 140, 23);
        CampoValor = new JTextField();
        CampoValor.setBounds(160, 20, 150, 23);

        //Establecemos el botón Calcular y le agregamos el oyente de eventos.
        Calcular = new JButton();
        Calcular.setText("Calcular");
        Calcular.setBounds(330, 20, 150, 23);
        Calcular.addActionListener(this);

        //Establecemos las etiquetas de los resultados.
        Logaritmo = new JLabel();
        Logaritmo.setText("Logaritmo neperiano =");
        Logaritmo.setBounds(20, 70, 470, 23);
        Raiz = new JLabel();
        Raiz.setText("Raíz cuadrada =");
        Raiz.setBounds(20, 100, 470, 23);

        //Añadimos cada componente gráfico al contenedor de la ventana.
        Contenedor.add(Valor);
        Contenedor.add(CampoValor);
        Contenedor.add(Calcular);
        Contenedor.add(Logaritmo);
        Contenedor.add(Raiz);
    }

    //Creamos un método que muestra un resultado en una etiqueta (en rojo si es un error).
    private void MostrarResultado(JLabel Etiqueta, String Texto, boolean EsError){

        //Escribimos el texto y elegimos su color.
        Etiqueta.setText(Texto);
        if (EsError){
            Etiqueta.setForeground(Color.RED);
        } else {
            Etiqueta.setForeground(Color.BLACK);
        }
    }

    //Creamos un método para gestionar los eventos generados en la ventana.
    @Override
    public void actionPerformed(ActionEvent Evento){

        //Si se pulsa Calcular se calculan el logaritmo neperiano y la raíz cuadrada, cada uno con sus catch.
        if (Evento.getSource() == Calcular){

            //Cálculo del logaritmo neperiano.
            try {
                double ValorNumerico = Double.parseDouble(CampoValor.getText().trim());
                double Resultado = CalculosNumericos.CalcularLogaritmoNeperiano(ValorNumerico);
                MostrarResultado(Logaritmo, "Logaritmo neperiano = " + String.format("%.4f", Resultado), false);
            } catch (ArithmeticException Error){
                //Si el valor no es positivo se muestra el mensaje de la excepción aritmética.
                MostrarResultado(Logaritmo, Error.getMessage(), true);
            } catch (NumberFormatException Error){
                //Si el valor no es numérico se muestra el mensaje correspondiente.
                MostrarResultado(Logaritmo, "El valor debe ser numérico para calcular el logaritmo", true);
            }

            //Cálculo de la raíz cuadrada.
            try {
                double ValorNumerico = Double.parseDouble(CampoValor.getText().trim());
                double Resultado = CalculosNumericos.CalcularRaizCuadrada(ValorNumerico);
                MostrarResultado(Raiz, "Raíz cuadrada = " + String.format("%.4f", Resultado), false);
            } catch (ArithmeticException Error){
                //Si el valor es negativo se muestra el mensaje de la excepción aritmética.
                MostrarResultado(Raiz, Error.getMessage(), true);
            } catch (NumberFormatException Error){
                //Si el valor no es numérico se muestra el mensaje correspondiente.
                MostrarResultado(Raiz, "El valor debe ser numérico para calcular la raíz cuadrada", true);
            }
        }
    }
}
