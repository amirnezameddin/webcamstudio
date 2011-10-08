/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ControlText.java
 *
 * Created on 2010-01-12, 23:51:15
 */
package webcamstudio.controls;

import webcamstudio.components.SourceListener;
import webcamstudio.sources.VideoSourceQRCode;

/**
 *
 * @author pballeux
 */
public class ControlQRCode extends javax.swing.JPanel implements Controls {

    VideoSourceQRCode source = null;
    String label = "Code";
    private SourceListener listener=null;
    /** Creates new form ControlText */
    public ControlQRCode(VideoSourceQRCode source) {
        initComponents();
        this.source = source;
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio.Languages");
        label = bundle.getString("CODE");
        spinWidth.setValue(source.getCaptureWidth());
        spinHeight.setValue(source.getCaptureHeight());
        txtContent.setText(source.getCustomText());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblWidth = new javax.swing.JLabel();
        spinWidth = new javax.swing.JSpinner();
        lblHeight = new javax.swing.JLabel();
        spinHeight = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtContent = new javax.swing.JTextArea();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        lblWidth.setText(bundle.getString("WIDTH")); // NOI18N
        lblWidth.setName("lblWidth"); // NOI18N

        spinWidth.setName("spinWidth"); // NOI18N
        spinWidth.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinWidthStateChanged(evt);
            }
        });

        lblHeight.setText(bundle.getString("HEIGHT")); // NOI18N
        lblHeight.setName("lblHeight"); // NOI18N

        spinHeight.setName("spinHeight"); // NOI18N
        spinHeight.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinHeightStateChanged(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        txtContent.setColumns(20);
        txtContent.setRows(5);
        txtContent.setName("txtContent"); // NOI18N
        txtContent.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContentFocusLost(evt);
            }
        });
        txtContent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContentKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtContent);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblWidth)
                        .addGap(18, 18, 18)
                        .addComponent(spinWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblHeight)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWidth)
                    .addComponent(spinWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHeight)
                    .addComponent(spinHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void spinWidthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinWidthStateChanged
        source.setCaptureWidth((Integer) spinWidth.getValue());
    }//GEN-LAST:event_spinWidthStateChanged

    private void spinHeightStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinHeightStateChanged
        source.setCaptureHeight((Integer) spinHeight.getValue());
}//GEN-LAST:event_spinHeightStateChanged

    private void txtContentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContentKeyTyped
        source.updateText(txtContent.getText());

    }//GEN-LAST:event_txtContentKeyTyped

    private void txtContentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContentFocusLost
        source.updateText(txtContent.getText());
    }//GEN-LAST:event_txtContentFocusLost

    @Override
    public String getLabel() {
        return label;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeight;
    private javax.swing.JLabel lblWidth;
    private javax.swing.JSpinner spinHeight;
    private javax.swing.JSpinner spinWidth;
    private javax.swing.JTextArea txtContent;
    // End of variables declaration//GEN-END:variables

    @Override
    public void removeControl() {
        source=null;
    }

    @Override
    public void setListener(SourceListener l) {
        listener=l;
    }
}