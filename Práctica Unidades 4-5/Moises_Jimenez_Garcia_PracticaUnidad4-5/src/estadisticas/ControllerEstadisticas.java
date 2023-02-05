package estadisticas;

import datos.Citas;
import datos.ControllerDatos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

import java.awt.Label;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

/**
 * Controlador de los diferentes gráficos donde obtenemos los datos de la lista
 * de cita y trabajamos con ellos
 * 
 * @author Moisés Jiménez García
 * @version 4.5
 *
 */
public class ControllerEstadisticas {

	ObservableList<Citas> Estadisticas = ControllerDatos.datos;

	@FXML
	private PieChart pieSexosGraficos;

	@FXML
	private ResourceBundle resources;
	@FXML
	private CategoryAxis AxisBarChart;

	@FXML
	private BarChart<String, Integer> barchartMESES;

	@FXML
	private StackedBarChart<String, Integer> StackedBarChart;

	@FXML
	private NumberAxis anyosLista;

	@FXML
	private URL location;

	@FXML
	void initialize() {
		// Llamadas a los métodos que se encargan de cargar la información necesaria
		pieSexos();
		barChart();
		StackedBarChart();

	}

	/*
	 * Método para cargar los datos de los sexos, Recorremos la lista contamos
	 * cuantos hay de cada uno, y se lo cargamos al gráfico
	 */
	private void pieSexos() {
		int nuM = 0;
		int nuH = 0;
		for (Citas c : Estadisticas) {
			if (c.getSexo().equals("Mujer")) {
				nuM++;
			} else {
				nuH++;
			}

		}
		ObservableList<PieChart.Data> piechart = FXCollections.observableArrayList(new PieChart.Data("Mujeres", nuM),
				new PieChart.Data("Hombres", nuH)

		);
		pieSexosGraficos.setData(piechart);

	}

	/**
	 * Método para calcular citas por meses en año actual, usando un método que
	 * compara si el año de la cita que tiene el foco en ese momento es igual que el
	 * actual. la cuenta registrandola por mes
	 */
	private void barChart() {

		// Contador de meses
		int[] mesesContador = new int[12];

		// Creamos lista para poder poner el nombre de los meses
		ObservableList<String> meses = FXCollections.observableArrayList();
		meses.addAll("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Sept", "Octubre", "Nov",
				"Diciembre");
		AxisBarChart.setCategories(meses);// damos valor a las X

		// Recorremos las citas, y sacamos con un método creado el numero del mes
		for (Citas c : Estadisticas) {
			if (LocalDate.now().getYear() == convertirAnyos(c.getFecha())) {
				mesesContador[convertirMesesNumeros(c.getFecha())]++;
			}

		}

		// creamos una serie, y le vamos dando los valores recogidos en el array
		// anterior
		Series<String, Integer> ratio = new Series<>();
		ratio.setName(LocalDate.now().getYear() + "");
		for (int i = 0; i < mesesContador.length; i++) {
			ratio.getData().add(new Data<>(meses.get(i), mesesContador[i]));
		}

		barchartMESES.getData().add(ratio);

	}

	/**
	 * Método que se encarga de ir creando los registros segun los años que esten
	 * disponibles se crea un arrayList de xychart donde vamos guardando las
	 * diferentes series que se van creando recorriendo la lista de citas y
	 * filtrando por año se crea un arrayList auxiliar donde voy guardando los años
	 * que van apareciendo para que si unn año ya ha sido contado no volver a
	 * contarlo
	 */
	private void StackedBarChart() {
		String fech;
		ArrayList<String> contadorAn = new ArrayList<String>();
		ArrayList<XYChart.Series<String, Integer>> anyos = new ArrayList<XYChart.Series<String, Integer>>();

		// for para recorrer la lista
		for (Citas c : Estadisticas) {
			// if que se encarga de verificar si el año esta ya dentro de la lista auxiliar,
			// si no lo añade
			if (!contadorAn.contains(c.getFecha().substring(0, 4))) {
				contadorAn.add(c.getFecha().substring(0, 4));

				fech = c.getFecha().substring(0, 4);
				int[] mesesContador = new int[12];

				// for auxiliar para volver a recorrer los registros de nuevo, pero ahora
				// contará los meses de los años
				for (Citas aux : Estadisticas) {

					// si el año es igual al que estamos comprobando realiza el conteo de los meses
					if (aux.getFecha().substring(0, 4).equals(fech)) {
						mesesContador[convertirMesesNumeros(aux.getFecha())]++;
					}
				}
				// creación de la serie y sus valores
				XYChart.Series<String, Integer> series1 = new XYChart.Series<String, Integer>();

				series1.setName(fech);
				series1.getData().add(new XYChart.Data<String, Integer>("Enero", mesesContador[0]));
				series1.getData().add(new XYChart.Data<String, Integer>("Febrero", mesesContador[1]));
				series1.getData().add(new XYChart.Data<String, Integer>("Marzo", mesesContador[2]));
				series1.getData().add(new XYChart.Data<String, Integer>("Abril", mesesContador[3]));
				series1.getData().add(new XYChart.Data<String, Integer>("Mayo", mesesContador[4]));
				series1.getData().add(new XYChart.Data<String, Integer>("Junio", mesesContador[5]));
				series1.getData().add(new XYChart.Data<String, Integer>("Julio", mesesContador[6]));
				series1.getData().add(new XYChart.Data<String, Integer>("Agosto", mesesContador[7]));
				series1.getData().add(new XYChart.Data<String, Integer>("Sept", mesesContador[8]));
				series1.getData().add(new XYChart.Data<String, Integer>("Octubre", mesesContador[9]));
				series1.getData().add(new XYChart.Data<String, Integer>("Nov", mesesContador[10]));
				series1.getData().add(new XYChart.Data<String, Integer>("Diciembre", mesesContador[11]));

				anyos.add(series1);
			}
		}

		for (int i = 0; i < anyos.size(); i++) {
			StackedBarChart.getData().addAll(anyos.get(i));
		}

	}

	/**
	 * método usado para convertir el String en fecha, y devolver el numero de mes
	 * -1 para que cuadre con el array
	 * 
	 * @param fecha a consultat
	 * @return int número que ocupa en el array
	 */
	public int convertirMesesNumeros(String fecha) {
		DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate local_date = LocalDate.parse(fecha, JEFormatter);
		System.out.println(LocalDate.now().getYear());

		return local_date.getMonthValue() - 1;

	}

	/**
	 * 
	 * @param fecha a sacar los años
	 * @return int número del año de la fecha
	 */
	public int convertirAnyos(String fecha) {
		DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate local_date = LocalDate.parse(fecha, JEFormatter);
		return local_date.getYear();

	}

}