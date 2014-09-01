/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cursohibernate.basedatos.persistencia;

/**
 *
 * @author Lorenzo
 */
public class Coberturas {

    private boolean oftalmologia;
    private boolean dental;
    private boolean fecundacionInVitro;

    public Coberturas() {
    }
    
    public Coberturas(boolean oftalmologia, boolean dental, boolean fecundacionInVitro) {
        this.oftalmologia = oftalmologia;
        this.dental = dental;
        this.fecundacionInVitro = fecundacionInVitro;
    }

    
    /**
     * @return the oftalmologia
     */
    public boolean isOftalmologia() {
        return oftalmologia;
    }

    /**
     * @param oftalmologia the oftalmologia to set
     */
    public void setOftalmologia(boolean oftalmologia) {
        this.oftalmologia = oftalmologia;
    }

    /**
     * @return the dental
     */
    public boolean isDental() {
        return dental;
    }

    /**
     * @param dental the dental to set
     */
    public void setDental(boolean dental) {
        this.dental = dental;
    }

    /**
     * @return the fecundacionInVitro
     */
    public boolean isFecundacionInVitro() {
        return fecundacionInVitro;
    }

    /**
     * @param fecundacionInVitro the fecundacionInVitro to set
     */
    public void setFecundacionInVitro(boolean fecundacionInVitro) {
        this.fecundacionInVitro = fecundacionInVitro;
    }
}
