
package es.cursohibernate.basedatos.persistencia;


public class Enfermedades {

    private boolean corazon;
    private boolean estomacal;
    private boolean rinyones;
    private boolean alergia;
    private String nombreAlergia;

    public Enfermedades() {
    }

    public Enfermedades(boolean corazon, boolean estomacal, boolean rinyones, boolean alergia, String nombreAlergia) {
        this.corazon = corazon;
        this.estomacal = estomacal;
        this.rinyones = rinyones;
        this.alergia = alergia;
        this.nombreAlergia = nombreAlergia;
    }
    
    /**
     * @return the corazon
     */
    public boolean isCorazon() {
        return corazon;
    }

    /**
     * @param corazon the corazon to set
     */
    public void setCorazon(boolean corazon) {
        this.corazon = corazon;
    }

    /**
     * @return the estomacal
     */
    public boolean isEstomacal() {
        return estomacal;
    }

    /**
     * @param estomacal the estomacal to set
     */
    public void setEstomacal(boolean estomacal) {
        this.estomacal = estomacal;
    }

    /**
     * @return the rinyones
     */
    public boolean isRinyones() {
        return rinyones;
    }

    /**
     * @param rinyones the rinyones to set
     */
    public void setRinyones(boolean rinyones) {
        this.rinyones = rinyones;
    }

    /**
     * @return the alergia
     */
    public boolean isAlergia() {
        return alergia;
    }

    /**
     * @param alergia the alergia to set
     */
    public void setAlergia(boolean alergia) {
        this.alergia = alergia;
    }

    /**
     * @return the nombreAlergia
     */
    public String getNombreAlergia() {
        return nombreAlergia;
    }

    /**
     * @param nombreAlergia the nombreAlergia to set
     */
    public void setNombreAlergia(String nombreAlergia) {
        this.nombreAlergia = nombreAlergia;
    }
}
