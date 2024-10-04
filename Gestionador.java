/**
* UNIVERSIDAD DEL VALLE DE GUATEMALA
* DEPARTAMENTO DE CIENCIA DE LA COMPUTACION 
* CC2008
* AUTOR: Denil Parada
* FECHA: 26/09/2024 
* DESCRIPCION: Clase que gestiona las operaciones de los mamíferos, tales como calcular espacio, alimento diario, y registrar ejemplares.
*/
import java.util.HashMap;
import java.util.Map;

public class Gestionador {
    private Map<String, Mamifero> mamiferos;

    // Constructor
    public Gestionador() {
        mamiferos = new HashMap<>();
    }

    // Métodos para agregar felinos y primates
    public void agregarFelino(String clave, Felinos felino) {
        mamiferos.put(clave, felino);
    }

    public void agregarPrimate(String clave, Primates primate) {
        mamiferos.put(clave, primate);
    }

    // Método para mostrar los datos de un mamífero
    public String mostrarDatosMamifero(String clave) {
        if (mamiferos.containsKey(clave)) {
            return mamiferos.get(clave).toString();
        } else {
            return "Mamífero no encontrado.";
        }
    }

    // Método para calcular el espacio del recinto
    public String calcularEspacioRecinto(String clave) {
        if (mamiferos.containsKey(clave)) {
            Mamifero mamifero = mamiferos.get(clave);
            double espacio = mamifero.calcularEspacioRecintoValor();
            return "El espacio necesario del recinto es: " + espacio + " metros cuadrados.";
        }
        return "Mamífero no encontrado o no aplicable para cálculo de espacio.";
    }

    // Método para calcular la cantidad de alimento diario
    public String calcularAlimento(String clave) {
        if (mamiferos.containsKey(clave)) {
            Mamifero mamifero = mamiferos.get(clave);
            double costoComidaAnual = mamifero.calcularCostoComidaAnual();
            return "El costo de la comida anual es: Q" + costoComidaAnual;
        }
        return "Mamífero no encontrado o no aplicable para cálculo de alimento.";
    }
}
