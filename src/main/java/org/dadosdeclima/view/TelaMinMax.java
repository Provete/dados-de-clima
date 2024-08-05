/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package org.dadosdeclima.view;

import org.dadosdeclima.model.DadoClimatico;
import org.dadosdeclima.observable.Observer;
import org.dadosdeclima.presenter.DadosPresenter;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.dadosdeclima.presenter.DadosPresenter.DadosClimaticosMaximasEMinimas;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.List;

public class TelaMinMax extends javax.swing.JInternalFrame implements Observer
{
    DadosPresenter presenter;
    
    public TelaMinMax(DadosPresenter presenter)
    {
        this.presenter = presenter;

        CategoryDataset campoVazio = gerarCamposVazios();
        ChartPanel painelDadosMaxMin = new ChartPanel(gerarGrafico(campoVazio));
        painelDadosMaxMin.setPreferredSize(new Dimension(680, 420));
        setContentPane(painelDadosMaxMin);

        initComponents();
        setVisible(true);
    }

    private CategoryDataset gerarCampos(DadosClimaticosMaximasEMinimas dadosMaxMin)
    {
        DefaultCategoryDataset campos = new DefaultCategoryDataset();

        campos.addValue(dadosMaxMin.temperaturaMaxima.getTemperaturaCelsius(), "Máxima", "Temperatura");
        campos.addValue(dadosMaxMin.temperaturaMinima.getTemperaturaCelsius(), "Minima", "Temperatura");

        campos.addValue(dadosMaxMin.humidadeMaxima.getUmidadePorcentagem(), "Máxima", "Umidade");
        campos.addValue(dadosMaxMin.humidadeMinima.getUmidadePorcentagem(), "Minima", "Umidade");

        campos.addValue(dadosMaxMin.pressaoMaxima.getPressaoPascal(), "Máxima", "Pressão");
        campos.addValue(dadosMaxMin.pressaoMinima.getPressaoPascal(), "Minima", "Pressão");

        return campos;
    }

    private CategoryDataset gerarCamposVazios()
    {
        DefaultCategoryDataset campos = new DefaultCategoryDataset();

        campos.addValue(0, "Máxima", "Temperatura");
        campos.addValue(0, "Minima", "Temperatura");

        campos.addValue(0, "Máxima", "Umidade");
        campos.addValue(0, "Minima", "Umidade");

        campos.addValue(0, "Máxima", "Pressão");
        campos.addValue(0, "Máxima", "Pressão");

        return campos;
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void update(DadoClimatico event)
    {
        DadosClimaticosMaximasEMinimas dadosMaxMin = presenter.maximasEMinimas();

        CategoryDataset campos = gerarCampos(dadosMaxMin);
        ChartPanel painelDadosMaxMin = new ChartPanel(gerarGrafico(campos));
        painelDadosMaxMin.setPreferredSize(new Dimension(680, 420));

        setContentPane(painelDadosMaxMin);
    }

    private JFreeChart gerarGrafico(CategoryDataset campos)
    {
        JFreeChart grafico =  ChartFactory.createBarChart("Máximas e Minimas", "Categoria", "Valor", campos, PlotOrientation.VERTICAL, true, true, true);

        CategoryPlot plot = (CategoryPlot)grafico.getPlot();
        BarRenderer renderizador = (BarRenderer) plot.getRenderer();

        renderizador.setDefaultItemLabelGenerator(
                new StandardCategoryItemLabelGenerator("{2}", NumberFormat.getIntegerInstance())
        );

        renderizador.setDefaultItemLabelsVisible(true);

        return grafico;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
