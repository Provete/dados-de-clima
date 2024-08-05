/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package org.dadosdeclima.view;

/**
 *
 * @author Ruan Ribeiro
 */
public class UltimaAtt extends javax.swing.JInternalFrame {

    /**
     * Creates new form UltimaAtt
     */
    public UltimaAtt() {
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

        ultTemp = new javax.swing.JLabel();
        ultUmi = new javax.swing.JLabel();
        ultPress = new javax.swing.JLabel();
        ultDat = new javax.swing.JLabel();
        ultTemperatura = new javax.swing.JTextField();
        ultUmidade = new javax.swing.JTextField();
        ultPressão = new javax.swing.JTextField();
        ultdData = new javax.swing.JTextField();

        setTitle("Ultima Atualização do Tempo");

        ultTemp.setText("Temperatura");

        ultUmi.setText("Umidade");

        ultPress.setText("Pressão");

        ultDat.setText("Data");

        ultTemperatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ultTemperaturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ultTemp)
                        .addGap(30, 30, 30)
                        .addComponent(ultTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ultUmi)
                            .addComponent(ultPress)
                            .addComponent(ultDat))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ultUmidade)
                            .addComponent(ultPressão)
                            .addComponent(ultdData))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ultTemp)
                    .addComponent(ultTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ultUmi)
                    .addComponent(ultUmidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ultPress)
                    .addComponent(ultPressão, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ultDat)
                    .addComponent(ultdData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ultTemperaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ultTemperaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ultTemperaturaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ultDat;
    private javax.swing.JLabel ultPress;
    private javax.swing.JTextField ultPressão;
    private javax.swing.JLabel ultTemp;
    private javax.swing.JTextField ultTemperatura;
    private javax.swing.JLabel ultUmi;
    private javax.swing.JTextField ultUmidade;
    private javax.swing.JTextField ultdData;
    // End of variables declaration//GEN-END:variables
}
