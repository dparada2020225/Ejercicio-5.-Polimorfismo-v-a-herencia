/**
* UNIVERSIDAD DEL VALLE DE GUATEMALA
* DEPARTAMENTO DE CIENCIA DE LA COMPUTACION 
* CC2008
* AUTOR: Denil Parada
* FECHA: 26/09/2024 
* DESCRIPCION: Clase que interactúa con el usuario para ingresar y calcular el presupuesto necesario para aceptar un animal.
*/
import java.io.IOException;
import java.util.Scanner;

public class Interfaz {
    public static void main(String[] args) {
        Gestionador gestionador = new Gestionador();
        Scanner scanner = new Scanner(System.in);

        // Cargar los datos desde el archivo CSV al iniciar el programa
        if (gestionador.cargarDesdeCSV("animales.csv")) {
            System.out.println("Datos cargados correctamente o archivo creado.");
        } else {
            System.out.println("Error al cargar o crear el archivo CSV.");
        }

        // Ingresar el presupuesto anual
        System.out.print("Ingrese el presupuesto anual: ");
        double presupuesto = scanner.nextDouble();
        scanner.nextLine();  // Consumir el salto de línea

        // Preguntar si es felino o primate
        System.out.print("¿El animal es un Felino o Primate? (F/P): ");
        char tipoAnimal = scanner.nextLine().toUpperCase().charAt(0);

        Mamifero mamifero = null;  // Declarar el mamífero

        if (tipoAnimal == 'F') {
            // Ingresar datos del felino
            System.out.println("Ingrese los datos del felino:");
            System.out.print("Nombre científico: ");
            String nombreCientifico = scanner.nextLine();
            System.out.print("Hábitat: ");
            String habitat = scanner.nextLine();
            System.out.print("Esperanza de vida (años): ");
            int esperanzaDeVida = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea
            System.out.print("Tipo de pelaje (Corto/Largo/Grueso/Ausente): ");
            String tipoPelaje = scanner.nextLine();
            System.out.print("Cantidad de crías por camada: ");
            int cantidadCrias = scanner.nextInt();
            System.out.print("Peso (kg): ");
            double peso = scanner.nextDouble();
            System.out.print("Tiempo de gestación (meses): ");
            int tiempoGestacion = scanner.nextInt();
            System.out.print("¿Está en peligro de extinción? (true/false): ");
            boolean enPeligro = scanner.nextBoolean();
            scanner.nextLine();  // Consumir el salto de línea
            System.out.print("Dieta (Carnivoro/Omnivoro): ");
            String dieta = scanner.nextLine();
            System.out.print("Especie: ");
            String especie = scanner.nextLine();
            System.out.print("Longitud de la cola (cm): ");
            int longitudCola = scanner.nextInt();
            System.out.print("Velocidad máxima (km/h): ");
            double velocidadMaxima = scanner.nextDouble();

            // Crear el felino
            mamifero = new Felinos(nombreCientifico, habitat, esperanzaDeVida, tipoPelaje, cantidadCrias, peso, tiempoGestacion, enPeligro, dieta, especie, longitudCola, velocidadMaxima);

        } else if (tipoAnimal == 'P') {
            // Ingresar datos del primate
            System.out.println("Ingrese los datos del primate:");
            System.out.print("Nombre científico: ");
            String nombreCientifico = scanner.nextLine();
            System.out.print("Hábitat: ");
            String habitat = scanner.nextLine();
            System.out.print("Esperanza de vida (años): ");
            int esperanzaDeVida = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea
            System.out.print("Tipo de pelaje (Corto/Largo/Grueso/Ausente): ");
            String tipoPelaje = scanner.nextLine();
            System.out.print("Cantidad de crías por camada: ");
            int cantidadCrias = scanner.nextInt();
            System.out.print("Peso (kg): ");
            double peso = scanner.nextDouble();
            System.out.print("Tiempo de gestación (meses): ");
            int tiempoGestacion = scanner.nextInt();
            System.out.print("¿Está en peligro de extinción? (true/false): ");
            boolean enPeligro = scanner.nextBoolean();
            scanner.nextLine();  // Consumir el salto de línea
            System.out.print("Dieta (Carnivoro/Omnivoro): ");
            String dieta = scanner.nextLine();
            System.out.print("Especie: ");
            String especie = scanner.nextLine();
            System.out.print("Estructura social (Solitario/Grupal/Familiar/Jerárquico): ");
            String estructuraSocial = scanner.nextLine();
            System.out.print("Nivel de inteligencia (1-100): ");
            int nivelInteligencia = scanner.nextInt();
            System.out.print("Tamaño del cerebro (gramos): ");
            double tamanoCerebro = scanner.nextDouble();

            // Crear el primate con los datos ingresados
            mamifero = new Primates(nombreCientifico, habitat, esperanzaDeVida, tipoPelaje, cantidadCrias, peso, tiempoGestacion, enPeligro, dieta, especie, estructuraSocial, nivelInteligencia, tamanoCerebro);
        } else {
            System.out.println("Tipo de animal no válido.");
            scanner.close();
            return;  // Salir si no se ingresa un tipo válido
        }

        // Mostrar los datos del animal ingresado
        imprimirDatosMamiferoBonitos(mamifero.toString());

        // Calcular si el presupuesto es suficiente
        double costoRecinto = mamifero.calcularEspacioRecintoValor() * 13000;  // Costo del recinto (13000 por metro)
        double costoComidaAnual = mamifero.calcularCostoComidaAnual();  // Costo anual de la comida
        double costoMantenimientoDiario = (mamifero.calcularEspacioRecintoValor() > 100) ? 400 : ((mamifero.calcularEspacioRecintoValor() > 50) ? 250 : 100);  // Costo de mantenimiento diario
        double costoMantenimientoAnual = costoMantenimientoDiario * 365;  // Mantenimiento anual
        double costoTotalAnual = costoRecinto + costoComidaAnual + costoMantenimientoAnual;

        // Mostrar los costos calculados
        System.out.println("\n============================");
        System.out.println("  Cálculos de Costo");
        System.out.println("============================");
        System.out.println("Costo del recinto: Q" + costoRecinto);
        System.out.println("Costo de comida anual: Q" + costoComidaAnual);
        System.out.println("Costo de mantenimiento anual: Q" + costoMantenimientoAnual);
        System.out.println("Costo total anual: Q" + costoTotalAnual);

        // Determinar si el presupuesto alcanza
        System.out.println("\n============================");
        System.out.println("  Recomendación");
        System.out.println("============================");

        if (costoTotalAnual <= presupuesto) {
            System.out.println("Recomendación: El presupuesto alcanza. Se recomienda aceptar al animal.");
        } else {
            System.out.println("Recomendación: El presupuesto no alcanza. Se recomienda no aceptar al animal.");
        }

        //Preguntar si el usuario aceptará al animal
        System.out.print("¿Desea aceptar al animal? (S/N): ");
        char aceptar = scanner.next().toUpperCase().charAt(0);

        //Si el animal es aceptado, guardar en el archivo CSV
        if (aceptar == 'S') {
            System.out.println("\nEl animal ha sido aceptado.");
            try {
                if (mamifero instanceof Felinos) {
                    gestionador.agregarFelino(mamifero.getNombreCientifico(), (Felinos) mamifero);
                } else if (mamifero instanceof Primates) {
                    gestionador.agregarPrimate(mamifero.getNombreCientifico(), (Primates) mamifero);
                }
                gestionador.guardarEnCSV("animales.csv");
                System.out.println("Datos guardados en animales.csv");
            } catch (IOException e) {
                System.out.println("Error al guardar los datos: " + e.getMessage());
            }
        } else {
            System.out.println("\nEl animal NO ha sido aceptado.");
        }

        scanner.close();
    }

    // Método para imprimir los datos de manera visualmente atractiva
    private static void imprimirDatosMamiferoBonitos(String datos) {
        System.out.println("\n============================");
        System.out.println("  Información del Mamífero");
        System.out.println("============================");
        String[] lineas = datos.split(", ");
        for (String linea : lineas) {
            System.out.println("| " + linea);
        }
        System.out.println("============================\n");
    }
}
