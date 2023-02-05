package datos;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import javafx.stage.Stage;

/**
 * Controlador encargado de el modal citar por defecto crea el objeto cita y lo
 * añade al controlador principal
 * 
 * @author Moisés Jiménez García
 * @version 4.5
 *
 */
public class ControllerDatos2 {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField apellidosLabel;

	@FXML
	private TextField edadLabel;

	@FXML
	private TextField emailLabel;

	@FXML
	private TextField nombreLabel;

	@FXML
	private Label numCitas;

	@FXML
	private TextField telefonoLabel;

	private Stage dialogStage; // para poder recibir la ventana que necesita
	private Citas cita;

	@FXML
	void initialize() {

	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Metodo que es llamado desde controllerDatos que es el que tiene toda la
	 * información de las citas/clintes central. El cual manda los datos que este
	 * controlador necesita para poder mostrarlos en su escena en este caso un modal
	 * que nos permite una consulta rápida a la información y generar una cita de
	 * ese cliente automática En este caso a los campos de la venta les da el valor
	 * de la cita correspondiente el cual previamente ha sido filtrado por el método
	 * buscar Recogemos el valor de esa cita/cliente en nuestra variable cita para
	 * poder usarla en método citarDefecto de esta clase
	 */
	public void setCitas(Citas cita, int num) {
		this.cita = cita;
		nombreLabel.setText(cita.getNombre());
		apellidosLabel.setText(cita.getApellidos());
		edadLabel.setText(Integer.toString(cita.getEdad()));
		telefonoLabel.setText(Integer.toString(cita.getTelefono()));
		emailLabel.setText(cita.getEmail());
		numCitas.setText(Integer.toString(num));

	}

	@FXML
	private void salirConsulta() {
		dialogStage.close();
	}

	/**
	 * Al pulsar a citar añade a la lista general una nueva cita que es la que este
	 * propio controlador tiene guardada en su variable cita, esa variable siempre
	 * que se busque un cliente se sobreescribe con los datos actuales
	 * 
	 */
	@FXML
	private void citarDefecto() {
		ControllerDatos.nuevoCliente(cita);
		dialogStage.close();
	}

}