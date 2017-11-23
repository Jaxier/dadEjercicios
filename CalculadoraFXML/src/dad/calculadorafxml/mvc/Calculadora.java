package dad.calculadorafxml.mvc;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * Implementación de la lógica de una calculadora.
 * @author Fran Vargas
 */
public class Calculadora implements Initializable  {
	
	@FXML
	private TextField pantallaTextField;
	
	@FXML
	private Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
	
	@FXML
	private Button buttonPunto;
	
	@FXML
	private Button buttonMas,buttonMenos,buttonMultiplicar,buttonDivision,buttonIgual;
	
	@FXML
	private Button buttonCE,buttonC;
	
	
	
	public static final char IGUAL = '='; 
	public static final char SUMAR = '+'; 
	public static final char RESTAR = '-'; 
	public static final char DIVIDIR = '/'; 
	public static final char MULTIPLICAR = '*';
	
	private static final char COMA = '.'; 
	
	private Double operando;
	private char operador;
	private Boolean nuevoOperando;
	private StringProperty pantalla;
	
	public Calculadora() {
	
		
	}
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pantalla = new SimpleStringProperty(this, "pantalla");
		pantallaTextField.textProperty().bind(pantalla);
		borrar();
		
		
	}
	@FXML
    public void keyPressed(KeyEvent event) {
        switch (event.getCode()) {
        case NUMPAD0:
            onNum0();
            break;
        case NUMPAD1:
            onNum1();
            break;
        case NUMPAD2:
            onNum2();
            break;
        case NUMPAD3:
            onNum3();
            break;
        case NUMPAD4:
            onNum4();
            break;
        case NUMPAD5:
            onNum5();
            break;
        case NUMPAD6:
            onNum6();
            break;
        case NUMPAD7:
            onNum7();
            break;
        case NUMPAD8:
            onNum8();
            break;
        case NUMPAD9:
            onNum9();
            break;
        case ADD:
        	onMas();
        	break;
        case SUBTRACT:
        	onMenos();
        	break;
        case DIVIDE:
        	onDividir();
        	break;
        case MULTIPLY:
        	onMultiplicar();
        	break;
        case ENTER:
        	onIgual();
        	break;
        case DECIMAL:
        	onComa();
        	break;
        default:
            break;
        }
    }
	
	
	@FXML
	public void onNum0() {
		insertar(button0.getText().charAt(0));
	}
	@FXML
	public void onNum1() {
		insertar(button1.getText().charAt(0));
	}
	@FXML
	public void onNum2() {
		insertar(button2.getText().charAt(0));
	}
	@FXML
	public void onNum3() {
		insertar(button3.getText().charAt(0));
	}
	@FXML
	public void onNum4() {
		insertar(button4.getText().charAt(0));
	}
	@FXML
	public void onNum5() {
		insertar(button5.getText().charAt(0));
	}
	@FXML
	public void onNum6() {
		insertar(button6.getText().charAt(0));
	}
	@FXML
	public void onNum7() {
		insertar(button7.getText().charAt(0));
	}
	@FXML
	public void onNum8() {
		insertar(button8.getText().charAt(0));
	}
	@FXML
	public void onNum9() {
		insertar(button9.getText().charAt(0));
	}
	@FXML
	public void onComa() {
		insertar(buttonPunto.getText().charAt(0));
	}
	@FXML
	public void onMas() {
		operar(buttonMas.getText().charAt(0));
	}
	@FXML
	public void onMenos() {
		operar(buttonMenos.getText().charAt(0));
	}
	@FXML
	public void onDividir() {
		operar(buttonDivision.getText().charAt(0));
	}
	@FXML
	public void onMultiplicar() {
		operar(buttonMultiplicar.getText().charAt(0));
	}
	@FXML
	public void onIgual() {
		operar(buttonIgual.getText().charAt(0));
	}
	
	/**
	 * Devuelve el contenido de la pantalla de la calculadora.
	 * @return Cadena de texto con el contenido de la pantalla de la calculdora.
	 */
	public String getPantalla() {
		return pantalla.get();
	}

	/**
	 * Inicializa por completo la calculadora, borrando la información que tiene memorizada y la pantalla.
	 */
	@FXML
	public void borrar() {
		operando = 0.0;
		operador = '=';
		borrarTodo();
	}
	
	/**
	 * Borra lo que hay en la pantalla (el último operando introducido).
	 */
	@FXML
	public void borrarTodo() {
		nuevoOperando = true;
		pantalla.set("0.0");
	}
	
	/**
	 * Indica a la calculadora que realice la operación indicada. 
	 * @param operador Operación a realizar; usar una constante: IGUAL, SUMAR, RESTAR, MULTIPLCIAR, DIVIDIR.
	 */
	public void operar(char operador) {
		nuevoOperando = true;
		double operando2 = Double.parseDouble(pantalla.get());
		switch (this.operador) {
			case SUMAR: operando += operando2; break;
			case RESTAR: operando -= operando2; break;
			case MULTIPLICAR: operando *= operando2; break;
			case DIVIDIR: operando /= operando2; break;
			case IGUAL: operando = operando2; break;
		}
		this.operador = operador;
		pantalla.set(operando.toString());
	}
	
	/**
	 * Inserta una coma en el operando actual (pantalla).
	 */
	public void insertarComa() {
		
		if (!pantalla.get().contains("" + COMA)) {
			pantalla.set(pantalla.get()+COMA);
		}
	}
	
	/**
	 * Inserta un dígito en el operando actual (pantalla).
	 * @param digito Digito a introducir en la pantalla.
	 */
	public void insertar(char digito) {
		if (digito >= '0' && digito <= '9') {
			if (nuevoOperando) {
				nuevoOperando = false;
				pantalla.set("");
			}
			pantalla.set(pantalla.get()+digito);
		} else if (digito == COMA) {
			insertarComa();
		}
	}
	
}
