package com.example.application.views.inicio;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;


    

@PageTitle("Inicio")
@Route(value = "")
@RouteAlias(value = "")
@Uses(Icon.class)
public class InicioView extends Composite<VerticalLayout> {
    // Método para calcular la seguridad social (ejemplo de un 10% fijo)
    public static double calcularSeguridadSocial(double salarioBruto) {
        return salarioBruto * 0.1; // Puedes ajustar el porcentaje según lo necesites
    }

    // Método para calcular la salud (ejemplo de un 5% fijo)
    public static double calcularSalud(double salarioBruto) {
        return salarioBruto * 0.05; // Puedes ajustar el porcentaje según lo necesites  
    }

    public InicioView() {
        H1 h1 = new H1();
        TextField textField = new TextField();
        NumberField numberField = new NumberField();
        NumberField numberField2 = new NumberField();
        TextField textField2 = new TextField();
        Button buttonPrimary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        h1.setText("Calculadora de nomina");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h1);
        h1.setWidth("max-content");

        textField.setLabel("Nombre");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, textField);
        textField.setWidth("400px");

        numberField.setLabel("Horas trabajadas");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, numberField);
        numberField.setWidth("400px");

        numberField2.setLabel("Tarifa por horas");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, numberField2);
        numberField2.setWidth("400px");

        textField2.setLabel("Tipo de contrato(Fijo u hora)");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, textField2);
        textField2.setWidth("400px");

        buttonPrimary.setText("Calcular");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary);
        buttonPrimary.setWidth("300px");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        
        // Cuando se hace click al botón "Calcular" se ejecute la siguiente acción/evento
        buttonPrimary.addClickListener(evento -> {
            // Variables tipo travesti
            String nombre = textField.getValue();
            double horasTrabajadas = numberField.getValue();
            double tarifaPorHora = numberField2.getValue();
            String tipoContrato = textField2.getValue();

            //Varibles de resultado de proceso
            double salarioBruto = horasTrabajadas * tarifaPorHora; // Calcular salario bruto

            double seguridadSocial = calcularSeguridadSocial(salarioBruto);
            double salud = calcularSalud(salarioBruto);
            
            double salarioNeto = salarioBruto - seguridadSocial - salud;

            String url = "my-view?" + "nombre= " + nombre + " horas trabajadas= " + horasTrabajadas + " tarifa por hora= " + tarifaPorHora + " tipo de contrato= "  + tipoContrato + " salario neto " + salarioNeto;
            UI.getCurrent().navigate(url);
        });
        getContent().add(h1);
        getContent().add(textField);
        getContent().add(numberField);
        getContent().add(numberField2);
        getContent().add(textField2);
        getContent().add(buttonPrimary);
    }
}