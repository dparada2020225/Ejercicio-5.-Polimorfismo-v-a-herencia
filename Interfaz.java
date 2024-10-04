/**
* UNIVERSIDAD DEL VALLE DE GUATEMALA
* DEPARTAMENTO DE CIENCIA DE LA COMPUTACION 
* CC2008
* AUTOR: Denil Parada
* FECHA: 26/09/2024 
* DESCRIPCION: Clase que interactúa con el usuario para ingresar y calcular el presupuesto necesario para aceptar un animal.
*/
import java.util.Scanner;

public class Interfaz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Paso 1: Ingresar el presupuesto anual
        System.out.print("Ingrese el presupuesto anual: ");
        double presupuesto = scanner.nextDouble();
        scanner.nextLine();  // Consumir el salto de línea

        // Paso 2: Preguntar si es felino o primate
        System.out.print("¿El animal es un Felino o Primate? (F/P): ");
        char tipoAnimal = scanner.nextLine().toUpperCase().charAt(0);

        Mamifero mamifero = null;  // Declarar el mamífero

        if (tipoAnimal == 'F') {
            // Si es felino, ingresar datos específicos del felino
            System.out.println("\n============================");
            System.out.println("  Ingrese los datos del felino");
            System.out.println("============================");

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
            System.out.print("Dieta (Carnivoro/Omnívoro): ");
            String dieta = scanner.nextLine();
            System.out.print("Especie: ");
            String especie = scanner.nextLine();
            System.out.print("Longitud de la cola (cm): ");
            int longitudCola = scanner.nextInt();
            System.out.print("Velocidad máxima (km/h): ");
            double velocidadMaxima = scanner.nextDouble();

            // Crear el felino con los datos ingresados
            mamifero = new Felinos(nombreCientifico, habitat, esperanzaDeVida, tipoPelaje, cantidadCrias, peso, tiempoGestacion, enPeligro, dieta, especie, longitudCola, velocidadMaxima);

        } else if (tipoAnimal == 'P') {
            // Si es primate, ingresar datos específicos del primate
            System.out.println("\n============================");
            System.out.println("  Ingrese los datos del primate");
            System.out.println("============================");

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

        // Paso 3: Calcular si el presupuesto es suficiente
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

        // Paso 4: Determinar si el presupuesto alcanza
        System.out.println("\n============================");
        System.out.println("  Recomendación");
        System.out.println("============================");

        if (costoTotalAnual <= presupuesto) {
            System.out.println("Recomendación: El presupuesto alcanza. Se recomienda aceptar al animal.");
        } else {
            System.out.println("Recomendación: El presupuesto no alcanza. Se recomienda no aceptar al animal.");
        }

        // Paso 5: Preguntar si el usuario aceptará al animal
        System.out.print("¿Desea aceptar al animal? (S/N): ");
        char aceptar = scanner.next().toUpperCase().charAt(0);

        // Paso 6: Mostrar mensaje final
        System.out.println("\n============================");
        System.out.println("  Resultado ");
        System.out.println("============================");
        if (aceptar == 'S') {
            System.out.println("El animal SI ha sido aceptado.");
        } else {
            System.out.println("El animal NO ha sido aceptado.");
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
