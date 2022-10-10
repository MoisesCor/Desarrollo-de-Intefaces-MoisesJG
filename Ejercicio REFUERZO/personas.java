package TEMA2.main.clase.EjercicioDESAROLLO;

public class personas extends Contactos {

 
    protected String sNombre;
    protected String sApe1;
    protected String sApe2;
    protected String sFechaNac;
    protected String sDNI;

    /*Getters and setters */
    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getsApe1() {
        return sApe1;
    }

    public void setsApe1(String sApe1) {
        this.sApe1 = sApe1;
    }

    public String getsApe2() {
        return sApe2;
    }

    public void setsApe2(String sApe2) {
        this.sApe2 = sApe2;
    }

    public String getsFechaNac() {
        return sFechaNac;
    }

    public void setsFechaNac(String sFechaNac) {
        this.sFechaNac = sFechaNac;
    }

    public String getsDNI() {
        return sDNI;
    }

    public void setsDNI(String sDNI) {
        this.sDNI = sDNI;
    }


    /* Constructor   */
    public personas(String sIdentificador, int iNumTelf, String sNombre, String sApe1, String sApe2, String sFechaNac, String sDNI) throws Exception {
        super(sIdentificador, iNumTelf);
        this.sNombre = sNombre;
        
        if(validarDNI(sDNI)){
            this.sDNI = sDNI;
        }else{
            throw new Exception("DNI INCORRECTO");
        }
        
        this.sFechaNac = sFechaNac;
        this.sApe1 = sApe1;
        this.sApe2 = sApe2;
    }

    /* MÉTODO COMPRONAR DNI */
    public static boolean validarDNI(String DNI){
        String letras="TRWAGMYFPDXBNJZSQVHLCKE";
        int restoDiv = Integer.parseInt(DNI.substring(0, 8))%23;
    
        if(DNI.length()==9 && DNI.substring(8, 9).toUpperCase().equals(String.valueOf(letras.charAt(restoDiv))) ){
            return true;
        }else{
         
            return false;
        }
        
    }

    @Override
    public String toString() {
        return "personas [sNombre=" + sNombre + ", sApe1=" + sApe1 + ", sApe2=" + sApe2 + ", sFechaNac=" + sFechaNac
                + ", sDNI=" + sDNI +super.toString()+ "]";
    }

    

   


    
    
}
