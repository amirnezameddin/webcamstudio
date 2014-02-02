/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MosaicControl.java
 *
 * Created on 2010-01-15, 01:51:51
 */

package webcamstudio.sources.effects.controls;

import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import webcamstudio.sources.effects.NoBackground;

/**
 *
 * @author pballeux
 */
public class NoBackgroundControl extends javax.swing.JPanel {

    NoBackground effect = null;
    /** Creates new form MosaicControl
     * @param effect */
    public NoBackgroundControl(NoBackground effect) {
        initComponents();
        this.effect=effect;
        sliderR.setValue(effect.getRThreshold());
        sliderG.setValue(effect.getGThreshold());
        sliderB.setValue(effect.getBThreshold());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSnapShot = new javax.swing.JButton();
        lblPreview = new javax.swing.JLabel();
        sliderR = new javax.swing.JSlider();
        sliderG = new javax.swing.JSlider();
        sliderB = new javax.swing.JSlider();

        btnSnapShot.setText("Take Snapshot");
        btnSnapShot.setName("btnSnapShot"); // NOI18N
        btnSnapShot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSnapShotActionPerformed(evt);
            }
        });

        lblPreview.setText(" ");
        lblPreview.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        lblPreview.setName("lblPreview"); // NOI18N

        sliderR.setBackground(java.awt.Color.red);
        sliderR.setMinorTickSpacing(1);
        sliderR.setPaintLabels(true);
        sliderR.setPaintTicks(true);
        sliderR.setValue(50);
        sliderR.setName("sliderR"); // NOI18N
        sliderR.setOpaque(true);
        sliderR.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderRStateChanged(evt);
            }
        });

        sliderG.setBackground(java.awt.Color.green);
        sliderG.setMinorTickSpacing(1);
        sliderG.setPaintLabels(true);
        sliderG.setPaintTicks(true);
        sliderG.setValue(50);
        sliderG.setName("sliderG"); // NOI18N
        sliderG.setOpaque(true);
        sliderG.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderGStateChanged(evt);
            }
        });

        sliderB.setBackground(java.awt.Color.blue);
        sliderB.setMinorTickSpacing(1);
        sliderB.setPaintLabels(true);
        sliderB.setPaintTicks(true);
        sliderB.setValue(50);
        sliderB.setName("sliderB"); // NOI18N
        sliderB.setOpaque(true);
        sliderB.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderBStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSnapShot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE))
                    .addComponent(sliderR, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                    .addComponent(sliderG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                    .addComponent(sliderB, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSnapShot))
                    .addComponent(lblPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSnapShotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSnapShotActionPerformed
        effect.setBackgroundImage(null);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(NoBackgroundControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedImage img = effect.getLastImage();
        effect.setBackgroundImage(img);
        lblPreview.setIcon(new ImageIcon(img.getScaledInstance(160, 120, BufferedImage.SCALE_FAST)));
        lblPreview.repaint();

    }//GEN-LAST:event_btnSnapShotActionPerformed

    private void sliderRStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderRStateChanged
        effect.setRThreshold(sliderR.getValue());
    }//GEN-LAST:event_sliderRStateChanged

    private void sliderGStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderGStateChanged
        effect.setGThreshold(sliderG.getValue());
    }//GEN-LAST:event_sliderGStateChanged

    private void sliderBStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderBStateChanged
        effect.setBThreshold(sliderB.getValue());
    }//GEN-LAST:event_sliderBStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSnapShot;
    private javax.swing.JLabel lblPreview;
    private javax.swing.JSlider sliderB;
    private javax.swing.JSlider sliderG;
    private javax.swing.JSlider sliderR;
    // End of variables declaration//GEN-END:variables

}