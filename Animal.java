/**
* UNIVERSIDAD DEL VALLE DE GUATEMALA
* DEPARTAMENTO DE CIENCIA DE LA COMPUTACION 
* CC2008
* AUTOR: Denil Parada
* FECHA: 26/09/2024 
* DESCRIPCION: Clase que representa información general sobre los animales del zoológico.
*/
public class Animal {
    protected String nombreCientifico;
    protected String habitat;
    protected int esperanzaDeVida;

    // Constructor
    public Animal(String nombreCientifico, String habitat, int esperanzaDeVida) {
        this.nombreCientifico = nombreCientifico;
        this.habitat = habitat;
        this.esperanzaDeVida = esperanzaDeVida;
    }

    // Getters y Setters
    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public int getEsperanzaDeVida() {
        return esperanzaDeVida;
    }

    public void setEsperanzaDeVida(int esperanzaDeVida) {
        this.esperanzaDeVida = esperanzaDeVida;
    }

    // toString
    @Override
    public String toString() {
        return "Nombre científico: " + nombreCientifico + ", Hábitat: " + habitat + ", Esperanza de vida: " + esperanzaDeVida + " años";
    }
}
