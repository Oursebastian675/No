package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);

        // Solicitar datos del empleado
        System.out.println("Ingrese el nombre del empleado:");
        String nombre = src.nextLine();

        System.out.println("Ingrese el número de horas trabajadas:");
        double horasTrabajadas = src.nextDouble();

        System.out.println("Ingrese la tarifa por hora:");
        double tarifaPorHora = src.nextDouble();

        System.out.println("Ingrese el tipo de contrato (fijo u horas):");
        String tipoContrato = src.next();

        // Calcular salario bruto
        double salarioBruto = horasTrabajadas * tarifaPorHora;

        // Calcular deducciones
        double seguridadSocial = calcularSeguridadSocial(salarioBruto);
        double salud = calcularSalud(salarioBruto);

        // Calcular salario neto
        double salarioNeto = salarioBruto - seguridadSocial - salud;

        // Mostrar resultados
        System.out.println("\n--- Nómina de Empleado ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Tipo de contrato: " + tipoContrato);
        System.out.println("Salario bruto: " + salarioBruto);
        System.out.println("Deducciones:");
        System.out.println("- Seguridad Social: " + seguridadSocial);
        System.out.println("- Salud: " + salud);
        System.out.println("Salario neto: " + salarioNeto);
        src.close();
    }

    // Método para calcular la seguridad social (ejemplo de un 10% fijo)
    public static double calcularSeguridadSocial(double salarioBruto) {
        return salarioBruto * 0.1; // Puedes ajustar el porcentaje según lo necesites
    }

    // Método para calcular la salud (ejemplo de un 5% fijo)
    public static double calcularSalud(double salarioBruto) {
        return salarioBruto * 0.05; // Puedes ajustar el porcentaje según lo necesites

        
    }
    
}

