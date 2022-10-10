package TEMA2.main.clase.EjercicioDESAROLLO;

public class empresas extends Contactos {
  
    protected String sDenoSocial;
    protected String sURL;



    /* Getters and Setters */
    public String getsDenoSocial() {
        return sDenoSocial;
    }
    public void setsDenoSocial(String sDenoSocial) {
        this.sDenoSocial = sDenoSocial;
    }
    public String getsURL() {
        return sURL;
    }
    public void setsURL(String sURL) {
        this.sURL = sURL;
    }

    /* Constructor */
    public empresas(String sIdentificador, int iNumTelf, String sDenoSocial, String sURL) {
        super(sIdentificador, iNumTelf);
        this.sURL=sURL;
        this.sDenoSocial=sDenoSocial;
        
    }
    @Override
    public String toString() {
        return "empresas [sDenoSocial=" + sDenoSocial + ", sURL=" + sURL + super.toString()+ "]";
    }

    
    
    
}
