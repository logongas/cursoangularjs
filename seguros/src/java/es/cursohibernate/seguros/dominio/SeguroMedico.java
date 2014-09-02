package es.cursohibernate.seguros.dominio;

public class SeguroMedico {
    private int idSeguro;
    private String nif;
    private String nombre;
    private String ape1;
    private int edad;
    private Sexo sexo;
    private boolean casado;
    private int numHijos;
    private boolean embarazada;
    private Coberturas coberturas=new Coberturas();
    private Enfermedades enfermedades=new Enfermedades();

    /**
     * @return the idSeguro
     */
    public int getIdSeguro() {
        return idSeguro;
    }

    /**
     * @param idSeguro the idSeguro to set
     */
    public void setIdSeguro(int idSeguro) {
        this.idSeguro = idSeguro;
    }

    /**
     * @return the nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * @param nif the nif to set
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the ape1
     */
    public String getApe1() {
        return ape1;
    }

    /**
     * @param ape1 the ape1 to set
     */
    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the sexo
     */
    public Sexo getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the casado
     */
    public boolean isCasado() {
        return casado;
    }

    /**
     * @param casado the casado to set
     */
    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    /**
     * @return the numHijos
     */
    public int getNumHijos() {
        return numHijos;
    }

    /**
     * @param numHijos the numHijos to set
     */
    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    /**
     * @return the embarazada
     */
    public boolean isEmbarazada() {
        return embarazada;
    }

    /**
     * @param embarazada the embarazada to set
     */
    public void setEmbarazada(boolean embarazada) {
        this.embarazada = embarazada;
    }

    /**
     * @return the coberturas
     */
    public Coberturas getCoberturas() {
        return coberturas;
    }

    /**
     * @param coberturas the coberturas to set
     */
    public void setCoberturas(Coberturas coberturas) {
        this.coberturas = coberturas;
    }

    /**
     * @return the enfermedades
     */
    public Enfermedades getEnfermedades() {
        return enfermedades;
    }

    /**
     * @param enfermedades the enfermedades to set
     */
    public void setEnfermedades(Enfermedades enfermedades) {
        this.enfermedades = enfermedades;
    }
}
