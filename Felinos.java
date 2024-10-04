/**
* UNIVERSIDAD DEL VALLE DE GUATEMALA
* DEPARTAMENTO DE CIENCIA DE LA COMPUTACION 
* CC2008
* AUTOR: Denil Parada
* FECHA: 26/09/2024 
* DESCRIPCION: Clase que representa un felino, incluye detalles como el tamaño, longitud de la cola y velocidad máxima.
*/
public class Felinos extends Mamifero {
    private String especie;
    private int longitudCola;
    private double velocidadMaxima;

    // Constructor
    public Felinos(String nombreCientifico, String habitat, int esperanzaDeVida, String tipoPelaje, int cantidadCrias, double peso, int tiempoDeGestacion, boolean enPeligroDeExtincion, String dieta, String especie, int longitudCola, double velocidadMaxima) {
        super(nombreCientifico, habitat, esperanzaDeVida, tipoPelaje, cantidadCrias, peso, tiempoDeGestacion, enPeligroDeExtincion, dieta);
        this.especie = especie;
        this.longitudCola = longitudCola;
        this.velocidadMaxima = velocidadMaxima;
    }

    // Implementación del cálculo del espacio del recinto
    @Override
    public double calcularEspacioRecintoValor() {
        switch (especie.trim().toLowerCase()) {
            case "gato montes":
                return 50;  // metros cuadrados
            case "puma":
                return 100;  // metros cuadrados
            case "leopardo":
                return 150;  // metros cuadrados
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

    public int getLongitudCola() {
        return longitudCola;
    }

    public void setLongitudCola(int longitudCola) {
        this.longitudCola = longitudCola;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + ", Especie: " + especie + ", Longitud de la cola: " + longitudCola + " cm, Velocidad máxima: " + velocidadMaxima + " km/h";
    }
}
