/**
* UNIVERSIDAD DEL VALLE DE GUATEMALA
* DEPARTAMENTO DE CIENCIA DE LA COMPUTACION 
* CC2008
* AUTOR: Denil Parada
* FECHA: 26/09/2024 
* DESCRIPCION: Clase que representa un primate, incluye detalles como la estructura social y el nivel de inteligencia.
*/
public class Primates extends Mamifero {
    private String especie;
    private String estructuraSocial;
    private int nivelInteligencia;
    private double tamanoCerebro;

    // Constructor
    public Primates(String nombreCientifico, String habitat, int esperanzaDeVida, String tipoPelaje, int cantidadCrias, double peso, int tiempoDeGestacion, boolean enPeligroDeExtincion, String dieta, String especie, String estructuraSocial, int nivelInteligencia, double tamanoCerebro) {
        super(nombreCientifico, habitat, esperanzaDeVida, tipoPelaje, cantidadCrias, peso, tiempoDeGestacion, enPeligroDeExtincion, dieta);
        this.especie = especie;
        this.estructuraSocial = estructuraSocial;
        this.nivelInteligencia = nivelInteligencia;
        this.tamanoCerebro = tamanoCerebro;
    }

    // Implementación del cálculo del espacio del recinto
    @Override
    public double calcularEspacioRecintoValor() {
        switch (especie.toLowerCase()) {
            case "mono capuchino":
                return 25;  // metros cuadrados
            case "macaco":
                return 100;  // metros cuadrados
            case "gorila":
                return 400;  // metros cuadrados
            default:
                return 0;
        }
    }

    // Implementación del cálculo del costo de comida anual
    @Override
    public double calcularCostoComidaAnual() {
        double costoPorDia = (dieta.equalsIgnoreCase("Carnivoro")) ? 25 : 20;
        return costoPorDia * 365;  // Costo de comida al año
    }

    // Getters y Setters
    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getEstructuraSocial() {
        return estructuraSocial;
    }

    public void setEstructuraSocial(String estructuraSocial) {
        this.estructuraSocial = estructuraSocial;
    }

    public int getNivelInteligencia() {
        return nivelInteligencia;
    }

    public void setNivelInteligencia(int nivelInteligencia) {
        this.nivelInteligencia = nivelInteligencia;
    }

    public double getTamanoCerebro() {
        return tamanoCerebro;
    }

    public void setTamanoCerebro(double tamanoCerebro) {
        this.tamanoCerebro = tamanoCerebro;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + ", Especie: " + especie + ", Estructura social: " + estructuraSocial + 
               ", Nivel de inteligencia: " + nivelInteligencia + "/100, Tamaño del cerebro: " + tamanoCerebro + " gramos";
    }
}
