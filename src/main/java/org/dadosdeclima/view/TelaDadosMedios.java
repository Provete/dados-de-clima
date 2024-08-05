/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package org.dadosdeclima.view;

import org.dadosdeclima.model.DadoClimatico;
import org.dadosdeclima.observable.Observer;
import org.dadosdeclima.presenter.DadosPresenter;

/**
 *
 * @author Ruan Ribeiro
 */
public class TelaDadosMedios extends javax.swing.JInternalFrame implements Observer
{

    DadosPresenter presenter;

    /**
     * Creates new form TelaDadosMedios
     */
    public TelaDadosMedios(DadosPresenter presenter) {
        this.presenter = presenter;
        initComponents();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        medTemperatura = new javax.swing.JLabel();
        medUmidade = new javax.swing.JLabel();
        medPressao = new javax.swing.JLabel();
        medNumReg = new javax.swing.JLabel();
        MedTemp = new javax.swing.JLabel();
        MedUmi = new javax.swing.JLabel();
        MedPress = new javax.swing.JLabel();
        MedReg = new javax.swing.JLabel();

        setTitle("Dados Médios");

        medTemperatura.setText("Temperatura");

        medUmidade.setText("Umidade");

        medPressao.setText("Pressão");

        medNumReg.setText("Número de Registros");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(medTemperatura)
                    .addComponent(medNumReg)
                    .addComponent(medPressao)
                    .addComponent(medUmidade))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MedTemp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MedUmi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MedPress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MedReg, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medTemperatura)
                    .addComponent(MedTemp))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medUmidade)
                    .addComponent(MedUmi))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medPressao)
                    .addComponent(MedPress))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medNumReg)
                    .addComponent(MedReg))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MedPress;
    private javax.swing.JLabel MedReg;
    private javax.swing.JLabel MedTemp;
    private javax.swing.JLabel MedUmi;
    private javax.swing.JLabel medNumReg;
    private javax.swing.JLabel medPressao;
    private javax.swing.JLabel medTemperatura;
    private javax.swing.JLabel medUmidade;

    @Override
    public void update(DadoClimatico event)
    {
        DadosPresenter.DadosMedios dadosMedios = presenter.dadosMedia();
        System.out.println("hello");

        MedReg.setText(String.valueOf(dadosMedios.numeroRegistros));
        MedPress.setText(String.valueOf(dadosMedios.pressaoPascalMedia));
        MedUmi.setText(String.valueOf(dadosMedios.humidadePorcentagemMedia));
        MedTemp.setText(String.valueOf(dadosMedios.temperaturaCelsiusMedia));
    }
    // End of variables declaration//GEN-END:variables
}
