package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n--- Calculadora de Nomina ---");
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

        // salario bruto
        double salarioBruto = horasTrabajadas * tarifaPorHora;

        // deducciones
        double seguridadSocial = calcularSeguridadSocial(salarioBruto);
        double salud = calcularSalud(salarioBruto);

        // salario neto
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

    // Método para calcular la seguridad social (de un 10% fijo)
    public static double calcularSeguridadSocial(double salarioBruto) {
        return salarioBruto * 0.1;
    }

    // Método para calcular la salud (de un 5% fijo)
    public static double calcularSalud(double salarioBruto) {
        return salarioBruto * 0.05; 

        
    }
    
}

