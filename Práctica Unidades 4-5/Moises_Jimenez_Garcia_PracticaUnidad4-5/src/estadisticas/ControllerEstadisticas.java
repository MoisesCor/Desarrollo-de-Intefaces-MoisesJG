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
 * Controlador de los diferentes gr�ficos donde obtenemos los datos de la lista de cita y trabajamos con ellos
 * @author Mois�s Jim�nez Garc�a
 *
 */
public class ControllerEstadisticas {
	
	ObservableList<Citas>Estadisticas=  ControllerDatos.datos;

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
	 //Llamadas a los m�todos que se encargan de cargar la informaci�n necesaria
	 pieSexos();
	 barChart();
	 StackedBarChart();
	 
 }
 /*
  * M�todo para cargar los datos de los sexos, Recorremos la lista
  * contamos cuantos hay de cada uno, y se lo cargamos al gr�fico
  */
 	private void  pieSexos() {
 		int nuM=0;
 		int nuH=0;
 		for(Citas c: Estadisticas) {
 			if(c.getSexo().equals("Mujer")) {
 				nuM++;
 			}else {
 				nuH++;
 			}
 			
 		}
 		ObservableList<PieChart.Data> piechart= FXCollections.observableArrayList(
       		   new PieChart.Data("Mujeres", nuM),
       		    new PieChart.Data("Hombres", nuH)
       		    
       		   );
 		pieSexosGraficos.setData(piechart);
	 
 	}
 	
 	/**
 	 *  M�todo para calcular citas por meses en a�o actual, usando un m�todo que compara si el a�o de la cita
 	 *  que tiene el foco en ese momento es igual que el actual. la cuenta registrandola por mes
 	 */
 	private void barChart() {
 		
 		//Contador de meses
 		int[] mesesContador = new int[12];
 		
 		//Creamos lista para poder poner el nombre de los meses
 		 ObservableList<String> meses = FXCollections.observableArrayList();
 		meses.addAll("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Sept","Octubre","Nov","Diciembre");
 		AxisBarChart.setCategories(meses);// damos valor a las X
 		
 		//Recorremos las citas, y sacamos con un m�todo creado el numero del mes
 		for(Citas c: Estadisticas) {
 			if(LocalDate.now().getYear()== convertirAnyos(c.getFecha())) {
 				mesesContador[convertirMesesNumeros(c.getFecha())]++;
 			}
 			
 			
 		}
 		
 		// creamos una serie, y le vamos dando los valores recogidos en el array anterior
 		Series<String, Integer> ratio = new Series<>();
 		ratio.setName(LocalDate.now().getYear()+"");
 	   for (int i = 0; i < mesesContador.length; i++) {
 		  ratio.getData().add(new Data<>(meses.get(i), mesesContador[i]));
       }
 	   
 	  barchartMESES.getData().add(ratio);
 		
 		
 		
 	}
 	/**M�todo que se encarga de ir creando los registros segun los a�os que esten disponibles
 	 * se crea un arrayList de xychart donde vamos guardando las diferentes series que se van creando
 	 * recorriendo la lista de citas y filtrando por a�o
 	 * se crea un arrayList auxiliar donde voy guardando los a�os que van apareciendo
 	 * para que si unn a�o ya ha sido contado no volver a contarlo
 	 */
 	private void StackedBarChart() {
 		String fech;
 		ArrayList<String>contadorAn= new ArrayList<String>();
 		ArrayList<XYChart.Series<String, Integer>> anyos = new ArrayList<XYChart.Series<String, Integer>>();
 		
 		//for para recorrer la lista
 		for(Citas c: Estadisticas) {
 			// if que se encarga de verificar si el a�o esta ya dentro de la lista auxiliar, si no lo a�ade
 			if(!contadorAn.contains(c.getFecha().substring(0,4))) {
 				contadorAn.add(c.getFecha().substring(0,4));
 				
 				fech=c.getFecha().substring(0,4);
 				int[] mesesContador = new int[12];
 				
 				// for auxiliar para volver a recorrer los registros de nuevo, pero ahora contar� los meses de los a�os 
 				for(Citas aux: Estadisticas) {
 					
 					//si el a�o es igual al que estamos comprobando realiza el conteo de los meses
 					if(aux.getFecha().substring(0,4).equals(fech)) {
 						mesesContador[convertirMesesNumeros(aux.getFecha())]++;
 					}
 				}
 				// creaci�n de la serie y sus valores
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
 		
 		for(int i=0; i<anyos.size(); i++) {
 			StackedBarChart.getData().addAll(anyos.get(i));
 		}
 		
 		
		
 	}
 	/**
 	 *  m�todo usado para convertir el String en fecha, y devolver el numero de mes -1 para que cuadre con el array
 	 * @param fecha a consultat
 	 * @return int n�mero que ocupa en el array
 	 */
	 public int convertirMesesNumeros(String fecha) {
		 DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	      LocalDate local_date = LocalDate.parse(fecha, JEFormatter);
	      System.out.println(LocalDate.now().getYear());
	      
	      return local_date.getMonthValue()-1;
	      
	  
    	
    }
	 /**
	  * 
	  * @param fecha a sacar los a�os
	  * @return int n�mero del a�o de la fecha
	  */
	 public int convertirAnyos(String fecha) {
		 DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	      LocalDate local_date = LocalDate.parse(fecha, JEFormatter); 
	      return local_date.getYear();
	      
	  
    	
    }

}
