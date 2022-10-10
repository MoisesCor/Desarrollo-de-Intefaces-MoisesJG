package TEMA2.main.clase.EjercicioDESAROLLO;

import java.util.ArrayList;
import java.util.Comparator;

public class Agenda implements Comparable<Contactos> {

private ArrayList<Contactos> lista = new ArrayList<Contactos>();



    public Agenda(ArrayList<Contactos> lista) {
    this.lista = lista;

}

    public boolean anyadirContacto(Contactos c){
        boolean existe=true;
        for(Contactos p: lista){
            if(p.sIdentificador.equals(c.sIdentificador)){
                
                existe=false;
                break;
        }    
    }
    if(existe){
        lista.add(c);
        
    }
    return existe;
    }
    public boolean eliminarContacto(String ident){
        boolean existe=false;
        for(Contactos c: lista){
            if(c.sIdentificador.equals(ident)){
                lista.remove(lista.indexOf(c));
                existe=true;
                break;
            }

        }
        return existe;
    }

    public boolean existeContacto(String ident){
        boolean existe=false;
        for(Contactos c: lista){
            if(c.sIdentificador.equals(ident)){
                existe=true;
                break;
            }
        }
       
        return existe;
    }

    public int buscaContacto(String ident){
        int existe=0;
        for(Contactos c: lista){
            if(c.sIdentificador.equals(ident)){
                existe=lista.indexOf(c);
                break;
            }
        }
       
        return existe;
    }
    public void listarContactos(){
        lista.forEach(System.out::println);
    }




    @Override
    public String toString() {
        return "Agenda [lista=" + lista + "]";
    }





    @Override 
    /* No se usar esta interfaz dentro de este método
     * sabría usarla dentro de contactos
     */
    public int compareTo(Contactos o) {
       
        return 0;
    }

    public void ordenaConta(){
        lista.sort(Comparator.comparing(Contactos::getsIdentificador));
    }
    
}
