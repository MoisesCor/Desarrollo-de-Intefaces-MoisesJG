package estadisticas;

import datos.Citas;
import datos.ControllerDatos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.Label;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

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
	  private URL location;
	  
	 
	  

 @FXML
  void initialize() {
	 pieSexos();
	 lineChart();
	 
 }
 //Método para cargar los datos de los sexos, Recorremos la lista
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
 	
 	/*Método para calcular citas por meses*/
 	private void lineChart() {
 		
 		int[] mesesContador = new int[12];
 		
 		 ObservableList<String> meses = FXCollections.observableArrayList();
 		meses.addAll("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Sept","Octubre","Nov","Diciembre");
 		AxisBarChart.setCategories(meses);
 		
 		for(Citas c: Estadisticas) {
 			mesesContador[convertirMesesNumeros(c.getFecha())]++;
 			
 		}
 		
 		Series<String, Integer> ratio = new Series<>();
 		
 	   for (int i = 0; i < mesesContador.length; i++) {
 		  ratio.getData().add(new Data<>(meses.get(i), mesesContador[i]));
       }
 	   
 	  barchartMESES.getData().add(ratio);
 		
 		
 		
 	}
	 public int convertirMesesNumeros(String fecha) {
		 DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	      LocalDate local_date = LocalDate.parse(fecha, JEFormatter);
	      
	      
	      
	      return local_date.getMonthValue()-1;
	      
	  
    	
    }

}
