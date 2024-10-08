import java.io.*;
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

    // Método para guardar datos en CSV solo si el animal es aceptado
    public void guardarEnCSV(String nombreArchivo) throws IOException {
        File file = new File(nombreArchivo);
        boolean archivoExistente = file.exists();
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true)); // Modo 'append' para no sobrescribir
        if (!archivoExistente) {
            // Si el archivo no existe, crearlo con encabezados
            writer.write("Tipo,Nombre Científico,Hábitat,Esperanza de Vida,Tipo Pelaje,Cantidad Crías,Peso,Tiempo Gestación,En Peligro Extinción,Dieta,Especie,Longitud Cola/Inteligencia,Velocidad/Tamaño Cerebro\n");
        }

        for (Mamifero mamifero : mamiferos.values()) {
            if (mamifero instanceof Felinos) {
                Felinos felino = (Felinos) mamifero;
                writer.write("Felino," + felino.getNombreCientifico() + "," + felino.getHabitat() + "," + felino.getEsperanzaDeVida() + "," +
                             felino.getTipoPelaje() + "," + felino.getCantidadCrias() + "," + felino.getPeso() + "," + felino.getTiempoDeGestacion() + "," +
                             felino.isEnPeligroDeExtincion() + "," + felino.getDieta() + "," + felino.getEspecie() + "," + felino.getLongitudCola() + "," +
                             felino.getVelocidadMaxima() + "\n");
            } else if (mamifero instanceof Primates) {
                Primates primate = (Primates) mamifero;
                writer.write("Primate," + primate.getNombreCientifico() + "," + primate.getHabitat() + "," + primate.getEsperanzaDeVida() + "," +
                             primate.getTipoPelaje() + "," + primate.getCantidadCrias() + "," + primate.getPeso() + "," + primate.getTiempoDeGestacion() + "," +
                             primate.isEnPeligroDeExtincion() + "," + primate.getDieta() + "," + primate.getEspecie() + "," + primate.getEstructuraSocial() + "," +
                             primate.getNivelInteligencia() + "," + primate.getTamanoCerebro() + "\n");
            }
        }
        writer.close();
    }

    // Método para cargar datos desde CSV y verificar si hay algún problema al cargar o crear el archivo
    public boolean cargarDesdeCSV(String nombreArchivo) {
        File file = new File(nombreArchivo);
        if (!file.exists()) {
            // Si el archivo no existe, crear el archivo con encabezados
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
                writer.write("Tipo,Nombre Científico,Hábitat,Esperanza de Vida,Tipo Pelaje,Cantidad Crías,Peso,Tiempo Gestación,En Peligro Extinción,Dieta,Especie,Longitud Cola/Inteligencia,Velocidad/Tamaño Cerebro\n");
                return true; // Indica que el archivo fue creado
            } catch (IOException e) {
                return false; // Indica que ocurrió un error
            }
        }

        // Si el archivo existe, cargar los datos
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            reader.readLine(); // Saltar la primera línea (encabezados)
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                String tipo = datos[0];
                if (tipo.equals("Felino")) {
                    Felinos felino = new Felinos(datos[1], datos[2], Integer.parseInt(datos[3]), datos[4], Integer.parseInt(datos[5]), 
                                                 Double.parseDouble(datos[6]), Integer.parseInt(datos[7]), Boolean.parseBoolean(datos[8]), datos[9], 
                                                 datos[10], Integer.parseInt(datos[11]), Double.parseDouble(datos[12]));
                    mamiferos.put(datos[1], felino);
                } else if (tipo.equals("Primate")) {
                    Primates primate = new Primates(datos[1], datos[2], Integer.parseInt(datos[3]), datos[4], Integer.parseInt(datos[5]), 
                                                    Double.parseDouble(datos[6]), Integer.parseInt(datos[7]), Boolean.parseBoolean(datos[8]), datos[9], 
                                                    datos[10], datos[11], Integer.parseInt(datos[12]), Double.parseDouble(datos[13]));
                    mamiferos.put(datos[1], primate);
                }
            }
            return true; // Indica que los datos fueron cargados correctamente
        } catch (IOException e) {
            return false; // Indica que ocurrió un error al cargar los datos
        }
    }
}
