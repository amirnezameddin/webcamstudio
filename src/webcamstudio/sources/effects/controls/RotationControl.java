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

import webcamstudio.sources.effects.Rotation;

/**
 *
 * @author pballeux
 */
public class RotationControl extends javax.swing.JPanel {

    Rotation effect = null;
    /** Creates new form MosaicControl
     * @param effect */
    public RotationControl(Rotation effect) {
        initComponents();
        this.effect=effect;
        sliderAngle.setValue(effect.getAngle());
//        txtRadius.setText((int)effect.getRadius()+"");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        sliderAngle = new javax.swing.JSlider();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        jLabel1.setText(bundle.getString("ANGLE")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        sliderAngle.setMaximum(359);
        sliderAngle.setMinorTickSpacing(30);
        sliderAngle.setPaintLabels(true);
        sliderAngle.setPaintTicks(true);
        sliderAngle.setName("sliderAngle"); // NOI18N
        sliderAngle.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderAngleStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderAngle, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sliderAngle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(84, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sliderAngleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderAngleStateChanged
        effect.setAngle(sliderAngle.getValue());
    }//GEN-LAST:event_sliderAngleStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSlider sliderAngle;
    // End of variables declaration//GEN-END:variables

}