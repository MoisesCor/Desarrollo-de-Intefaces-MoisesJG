package TEMA2.main.clase.EjercicioDESAROLLO;

import java.util.ArrayList;

public class programaAgenda {
    public static void main(String[] args) throws Exception {
        
        personas per1= new personas("CCC", 666666, "mOIS", "jim", "gar", "12/09/92", "50992980W");
        personas per2= new personas("BBB", 777777, "pedro", "lopez", "marck", "12/09/92", "50992980W");
        empresas em1 = new empresas("XXX", 888888, "PAN", "WWWW");
        empresas em2 = new empresas("AAA", 999999, "MUEBLES", "WWWW");

        ArrayList<Contactos> listaAUX = new ArrayList<Contactos>();
        listaAUX.add(per1);
        listaAUX.add(per2);
        listaAUX.add(em1);
        listaAUX.add(em2);

        personas per3= new personas("DDD", 111111, "Marta", "seaone", "lopez", "12/09/92", "50992980W");
        empresas em3 = new empresas("NNN", 222222, "ACEITUNA", "WWWW");

        Agenda agn1 = new Agenda(listaAUX);
        agn1.listarContactos();

        //Método buscar contacto y devuelve la posición que ocupa en la agenda
        System.out.println(agn1.buscaContacto("CCC"));

        //Método que te dice si el contacto existe o no existe
        System.out.println(agn1.existeContacto("FFF"));

        // Método añadir contacto, si no existe previamente lo introducce
        System.out.println(agn1.anyadirContacto(em3));
        System.out.println(agn1.anyadirContacto(em1));// este caso dara false ya que ya esta introduccido
        System.out.println(agn1.anyadirContacto(per3));
        

        //Eliminamos contacto.
        System.out.println(agn1.eliminarContacto("CCC"));
        //Comprobamos si el contacto ha sido eliminado, siendo false si ya no existe
        System.out.println(agn1.existeContacto("CCC"));

        /* Miramos si la posición que ocupann en la agenda ha cambiado al borrar
         * para ello comprobamos el contacto que estaba en posición 1 ahora debe estar en 0
         */
        System.out.println(agn1.buscaContacto("BBB"));

        //Ordena contactos según el identificador
       // agn1.ordenaConta();
        agn1.listarContactos();
        


    }
}
