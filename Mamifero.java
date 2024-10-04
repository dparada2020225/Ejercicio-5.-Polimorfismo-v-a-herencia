/**
* UNIVERSIDAD DEL VALLE DE GUATEMALA
* DEPARTAMENTO DE CIENCIA DE LA COMPUTACION 
* CC2008
* AUTOR: Denil Parada
* FECHA: 26/09/2024 
* DESCRIPCION: Clase que representa un mamífero, incluye detalles adicionales como el tipo de pelaje y la dieta.
*/
public abstract class Mamifero extends Animal {
    protected String tipoPelaje;
    protected int cantidadCrias;
    protected double peso;
    protected int tiempoDeGestacion;
    protected boolean enPeligroDeExtincion;
    protected String dieta;

    // Constructor
    public Mamifero(String nombreCientifico, String habitat, int esperanzaDeVida, String tipoPelaje, int cantidadCrias, double peso, int tiempoDeGestacion, boolean enPeligroDeExtincion, String dieta) {
        super(nombreCientifico, habitat, esperanzaDeVida);
        this.tipoPelaje = tipoPelaje;
        this.cantidadCrias = cantidadCrias;
        this.peso = peso;
        this.tiempoDeGestacion = tiempoDeGestacion;
        this.enPeligroDeExtincion = enPeligroDeExtincion;
        this.dieta = dieta;
    }

    // Métodos abstractos para ser implementados en las subclases
    public abstract double calcularEspacioRecintoValor();  // Retorna el tamaño mínimo del recinto en metros cuadrados

    public abstract double calcularCostoComidaAnual();  // Retorna el costo anual de la comida según la dieta

    // Getters y Setters
    public String getTipoPelaje() {
        return tipoPelaje;
    }

    public void setTipoPelaje(String tipoPelaje) {
        this.tipoPelaje = tipoPelaje;
    }

    public int getCantidadCrias() {
        return cantidadCrias;
    }

    public void setCantidadCrias(int cantidadCrias) {
        this.cantidadCrias = cantidadCrias;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getTiempoDeGestacion() {
        return tiempoDeGestacion;
    }

    public void setTiempoDeGestacion(int tiempoDeGestacion) {
        this.tiempoDeGestacion = tiempoDeGestacion;
    }

    public boolean isEnPeligroDeExtincion() {
        return enPeligroDeExtincion;
    }

    public void setEnPeligroDeExtincion(boolean enPeligroDeExtincion) {
        this.enPeligroDeExtincion = enPeligroDeExtincion;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + ", Tipo de pelaje: " + tipoPelaje + ", Crías por camada: " + cantidadCrias + 
               ", Peso: " + peso + " kg, Gestación: " + tiempoDeGestacion + " meses, En peligro de extinción: " + enPeligroDeExtincion + ", Dieta: " + dieta;
    }
}
