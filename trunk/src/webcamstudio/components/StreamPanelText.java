/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StreamPanel.java
 *
 * Created on 4-Apr-2012, 4:07:51 PM
 */
package webcamstudio.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import webcamstudio.streams.SourceQRCode;
import webcamstudio.streams.SourceText;
//import webcamstudio.streams.SourceWebcam;
import webcamstudio.streams.Stream;


/**
 *
 * @author patrick
 */
public class StreamPanelText extends javax.swing.JPanel implements Stream.Listener{

    SourceText stream = null;
    Viewer viewer = new Viewer();
    

    /** Creates new form StreamPanel */
    @SuppressWarnings("unchecked") 
    public StreamPanelText(SourceText stream) {

        initComponents();
        
        viewer.setOpaque(true);
        viewer.setVisible(true);
        viewer.setBackground(Color.red);
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] fonts = e.getAllFonts(); // Get the fonts
        for (Font f : fonts){
            model.addElement(f.getName());
        }
        cboFonts.setModel(model);
        
        this.stream = stream;
        spinX.setValue(stream.getX());
        spinY.setValue(stream.getY());
        spinW.setValue(stream.getWidth());
        spinH.setValue(stream.getHeight());
        cboFonts.setSelectedItem(stream.getFont());
        txtHexColor.setText(Integer.toHexString(stream.getColor()));
        spinZOrder.setValue(stream.getZOrder());
        
        txtContent.setText(stream.getContent());
        setToolTipText(stream.getContent());
        cboFonts.setEnabled(!(stream instanceof SourceQRCode));
        txtHexColor.setEnabled(!(stream instanceof SourceQRCode));
        btnSelectColor.setEnabled(!(stream instanceof SourceQRCode));
        stream.setListener(this);
    }
   
    public ImageIcon getIcon(){
        ImageIcon icon = null;
        if (stream.getPreview()!=null){
            icon = new ImageIcon(stream.getPreview().getScaledInstance(32, 32, BufferedImage.SCALE_FAST));
        }
        
        return icon;
    }
    public void remove() {
        stream.stop();
        stream = null;

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelFont = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        txtContent = new javax.swing.JTextField();
        cboFonts = new javax.swing.JComboBox();
        txtHexColor = new javax.swing.JFormattedTextField();
        btnSelectColor = new javax.swing.JButton();
        tglActiveStream = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        labelText = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        spinX = new javax.swing.JSpinner();
        spinY = new javax.swing.JSpinner();
        spinW = new javax.swing.JSpinner();
        spinH = new javax.swing.JSpinner();
        labelX1 = new javax.swing.JLabel();
        labelY1 = new javax.swing.JLabel();
        labelW1 = new javax.swing.JLabel();
        labelH1 = new javax.swing.JLabel();
        jSlSpinX = new javax.swing.JSlider();
        jSlSpinY = new javax.swing.JSlider();
        jSlSpinW = new javax.swing.JSlider();
        jSlSpinH = new javax.swing.JSlider();
        jSeparator5 = new javax.swing.JSeparator();
        spinZOrder = new javax.swing.JSpinner();
        labelZ1 = new javax.swing.JLabel();
        jSlSpinZOrder = new javax.swing.JSlider();
        jSeparator3 = new javax.swing.JSeparator();

        setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        setPreferredSize(new java.awt.Dimension(286, 370));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        labelFont.setText(bundle.getString("FONT")); // NOI18N
        labelFont.setName("labelFont"); // NOI18N
        add(labelFont, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 308, 72, -1));

        lblColor.setText(bundle.getString("COLOR")); // NOI18N
        lblColor.setName("lblColor"); // NOI18N
        add(lblColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 338, 72, -1));

        txtContent.setMinimumSize(new java.awt.Dimension(10, 25));
        txtContent.setName("txtContent"); // NOI18N
        txtContent.setPreferredSize(new java.awt.Dimension(10, 25));
        txtContent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContentActionPerformed(evt);
            }
        });
        txtContent.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContentFocusLost(evt);
            }
        });
        add(txtContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 152, 272, -1));

        cboFonts.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboFonts.setName("cboFonts"); // NOI18N
        cboFonts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFontsActionPerformed(evt);
            }
        });
        add(cboFonts, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 210, -1));

        try {
            txtHexColor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("HHHHHH")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHexColor.setName("txtHexColor"); // NOI18N
        txtHexColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHexColorActionPerformed(evt);
            }
        });
        txtHexColor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHexColorFocusLost(evt);
            }
        });
        add(txtHexColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 178, -1));

        btnSelectColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/applications-graphics.png"))); // NOI18N
        btnSelectColor.setToolTipText(bundle.getString("COLOR")); // NOI18N
        btnSelectColor.setName("btnSelectColor"); // NOI18N
        btnSelectColor.setPreferredSize(new java.awt.Dimension(32, 20));
        btnSelectColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectColorActionPerformed(evt);
            }
        });
        add(btnSelectColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 333, -1, -1));

        tglActiveStream.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/media-playback-start.png"))); // NOI18N
        tglActiveStream.setName("tglActiveStream"); // NOI18N
        tglActiveStream.setPreferredSize(new java.awt.Dimension(32, 20));
        tglActiveStream.setRolloverEnabled(false);
        tglActiveStream.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/media-playback-stop.png"))); // NOI18N
        tglActiveStream.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglActiveStreamActionPerformed(evt);
            }
        });
        add(tglActiveStream, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 114, 110, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/splash100.png"))); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 14, 120, 110));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setName("jSeparator4"); // NOI18N
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 7, 10, 126));

        jSeparator7.setName("jSeparator7"); // NOI18N
        jSeparator7.setPreferredSize(new java.awt.Dimension(48, 10));
        add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 135, 150, 10));

        labelText.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelText.setText(bundle.getString("ENTER_TEXT")); // NOI18N
        labelText.setToolTipText("");
        labelText.setName("labelText"); // NOI18N
        add(labelText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 142, 70, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/FontCC.png"))); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 25, -1, -1));

        spinX.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        spinX.setName("spinX"); // NOI18N
        spinX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinXStateChanged(evt);
            }
        });
        add(spinX, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 50, -1));

        spinY.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        spinY.setName("spinY"); // NOI18N
        spinY.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinYStateChanged(evt);
            }
        });
        add(spinY, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 50, -1));

        spinW.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        spinW.setName("spinW"); // NOI18N
        spinW.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinWStateChanged(evt);
            }
        });
        add(spinW, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 50, -1));

        spinH.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        spinH.setName("spinH"); // NOI18N
        spinH.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinHStateChanged(evt);
            }
        });
        add(spinH, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 50, -1));

        labelX1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelX1.setText(bundle.getString("X")); // NOI18N
        labelX1.setName("labelX1"); // NOI18N
        add(labelX1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 10, 10));

        labelY1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelY1.setText(bundle.getString("Y")); // NOI18N
        labelY1.setName("labelY1"); // NOI18N
        add(labelY1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 10, -1));

        labelW1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelW1.setText(bundle.getString("WIDTH")); // NOI18N
        labelW1.setName("labelW1"); // NOI18N
        add(labelW1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 52, -1));

        labelH1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelH1.setText(bundle.getString("HEIGHT")); // NOI18N
        labelH1.setName("labelH1"); // NOI18N
        add(labelH1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 40, -1));

        jSlSpinX.setMajorTickSpacing(10);
        jSlSpinX.setMaximum(720);
        jSlSpinX.setMinimum(-720);
        jSlSpinX.setMinorTickSpacing(1);
        jSlSpinX.setSnapToTicks(true);
        jSlSpinX.setValue(0);
        jSlSpinX.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlSpinX.setName("jSlSpinX"); // NOI18N
        jSlSpinX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlSpinXStateChanged(evt);
            }
        });
        add(jSlSpinX, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 180, 150, 20));

        jSlSpinY.setMajorTickSpacing(10);
        jSlSpinY.setMaximum(720);
        jSlSpinY.setMinimum(-720);
        jSlSpinY.setMinorTickSpacing(1);
        jSlSpinY.setValue(0);
        jSlSpinY.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlSpinY.setInverted(true);
        jSlSpinY.setName("jSlSpinY"); // NOI18N
        jSlSpinY.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlSpinYStateChanged(evt);
            }
        });
        add(jSlSpinY, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 200, 150, 20));

        jSlSpinW.setMaximum(1080);
        jSlSpinW.setSnapToTicks(true);
        jSlSpinW.setValue(0);
        jSlSpinW.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlSpinW.setName("jSlSpinW"); // NOI18N
        jSlSpinW.setOpaque(true);
        jSlSpinW.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlSpinWStateChanged(evt);
            }
        });
        add(jSlSpinW, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 220, 150, 20));

        jSlSpinH.setMaximum(1080);
        jSlSpinH.setSnapToTicks(true);
        jSlSpinH.setValue(0);
        jSlSpinH.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlSpinH.setName("jSlSpinH"); // NOI18N
        jSlSpinH.setOpaque(true);
        jSlSpinH.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlSpinHStateChanged(evt);
            }
        });
        add(jSlSpinH, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 240, 150, 20));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setName("jSeparator5"); // NOI18N
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 10, 110));

        spinZOrder.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        spinZOrder.setName("spinZOrder"); // NOI18N
        spinZOrder.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinZOrderStateChanged(evt);
            }
        });
        add(spinZOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 50, -1));

        labelZ1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        labelZ1.setText(bundle.getString("LAYER")); // NOI18N
        labelZ1.setMaximumSize(new java.awt.Dimension(30, 10));
        labelZ1.setMinimumSize(new java.awt.Dimension(30, 10));
        labelZ1.setName("labelZ1"); // NOI18N
        labelZ1.setPreferredSize(new java.awt.Dimension(30, 10));
        add(labelZ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 40, 9));

        jSlSpinZOrder.setMajorTickSpacing(10);
        jSlSpinZOrder.setMaximum(10);
        jSlSpinZOrder.setMinimum(-10);
        jSlSpinZOrder.setMinorTickSpacing(1);
        jSlSpinZOrder.setPaintTicks(true);
        jSlSpinZOrder.setSnapToTicks(true);
        jSlSpinZOrder.setValue(0);
        jSlSpinZOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlSpinZOrder.setName("jSlSpinZOrder"); // NOI18N
        jSlSpinZOrder.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlSpinZOrderStateChanged(evt);
            }
        });
        add(jSlSpinZOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 259, 150, 30));

        jSeparator3.setName("jSeparator3"); // NOI18N
        jSeparator3.setPreferredSize(new java.awt.Dimension(48, 10));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 268, 10));
    }// </editor-fold>//GEN-END:initComponents

    private void txtContentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContentFocusLost
        stream.updateContent(txtContent.getText());
        setToolTipText(stream.getContent());
    }//GEN-LAST:event_txtContentFocusLost

    private void txtContentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContentActionPerformed
         stream.updateContent(txtContent.getText());
         setToolTipText(stream.getContent());
    }//GEN-LAST:event_txtContentActionPerformed

    private void cboFontsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFontsActionPerformed
        stream.setFont(cboFonts.getSelectedItem().toString());
    }//GEN-LAST:event_cboFontsActionPerformed

    private void txtHexColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHexColorActionPerformed
        stream.setColor(Integer.parseInt(txtHexColor.getText().trim(),16));
    }//GEN-LAST:event_txtHexColorActionPerformed

    private void txtHexColorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHexColorFocusLost
        stream.setColor(Integer.parseInt(txtHexColor.getText().trim(),16));
    }//GEN-LAST:event_txtHexColorFocusLost

    private void btnSelectColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectColorActionPerformed
        ColorChooser c = new ColorChooser(null,true);
        c.setLocationRelativeTo(this);
        c.setVisible(true);
        Color color = c.getColor();
        if (color!=null){
            txtHexColor.setText(Integer.toHexString(color.getRGB()));
            stream.setColor(color.getRGB());
        }
        
        
    }//GEN-LAST:event_btnSelectColorActionPerformed

    private void tglActiveStreamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglActiveStreamActionPerformed
        if (tglActiveStream.isSelected()) {
            this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
            stream.read();
        } else {
            this.setBorder(BorderFactory.createEmptyBorder());
            stream.stop();
        }
    }//GEN-LAST:event_tglActiveStreamActionPerformed

    private void spinXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinXStateChanged
        stream.setX((Integer)spinX.getValue());
        jSlSpinX.setValue((Integer)spinX.getValue());
    }//GEN-LAST:event_spinXStateChanged

    private void spinYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinYStateChanged
        stream.setY((Integer)spinY.getValue());
        jSlSpinY.setValue((Integer)spinY.getValue());
    }//GEN-LAST:event_spinYStateChanged

    private void spinWStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinWStateChanged
        stream.setWidth((Integer)spinW.getValue());
        jSlSpinW.setValue((Integer)spinW.getValue());
    }//GEN-LAST:event_spinWStateChanged

    private void spinHStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinHStateChanged
        stream.setHeight((Integer)spinH.getValue());
        jSlSpinH.setValue((Integer)spinH.getValue());
    }//GEN-LAST:event_spinHStateChanged

    private void jSlSpinXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlSpinXStateChanged
        stream.setX((Integer)jSlSpinX.getValue());
        spinX.setValue(jSlSpinX.getValue());
    }//GEN-LAST:event_jSlSpinXStateChanged

    private void jSlSpinYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlSpinYStateChanged
        stream.setY((Integer)jSlSpinY.getValue());
        spinY.setValue(jSlSpinY.getValue());
    }//GEN-LAST:event_jSlSpinYStateChanged

    private void jSlSpinWStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlSpinWStateChanged
        stream.setWidth((Integer)jSlSpinW.getValue());
        spinW.setValue(jSlSpinW.getValue());
    }//GEN-LAST:event_jSlSpinWStateChanged

    private void jSlSpinHStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlSpinHStateChanged
        stream.setHeight((Integer)jSlSpinH.getValue());
        spinH.setValue(jSlSpinH.getValue());
    }//GEN-LAST:event_jSlSpinHStateChanged

    private void spinZOrderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinZOrderStateChanged
        stream.setZOrder((Integer) spinZOrder.getValue());
        jSlSpinZOrder.setValue((Integer) spinZOrder.getValue());
    }//GEN-LAST:event_spinZOrderStateChanged

    private void jSlSpinZOrderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlSpinZOrderStateChanged
        stream.setZOrder((Integer)jSlSpinZOrder.getValue());
        spinZOrder.setValue(jSlSpinZOrder.getValue());
    }//GEN-LAST:event_jSlSpinZOrderStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelectColor;
    private javax.swing.JComboBox cboFonts;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSlider jSlSpinH;
    private javax.swing.JSlider jSlSpinW;
    private javax.swing.JSlider jSlSpinX;
    private javax.swing.JSlider jSlSpinY;
    private javax.swing.JSlider jSlSpinZOrder;
    private javax.swing.JLabel labelFont;
    private javax.swing.JLabel labelH1;
    private javax.swing.JLabel labelText;
    private javax.swing.JLabel labelW1;
    private javax.swing.JLabel labelX1;
    private javax.swing.JLabel labelY1;
    private javax.swing.JLabel labelZ1;
    private javax.swing.JLabel lblColor;
    private javax.swing.JSpinner spinH;
    private javax.swing.JSpinner spinW;
    private javax.swing.JSpinner spinX;
    private javax.swing.JSpinner spinY;
    private javax.swing.JSpinner spinZOrder;
    private javax.swing.JToggleButton tglActiveStream;
    private javax.swing.JTextField txtContent;
    private javax.swing.JFormattedTextField txtHexColor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void sourceUpdated(Stream stream) {
        if (stream.isPlaying()){
            this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
        } else {
            this.setBorder(BorderFactory.createEmptyBorder());
        }
        spinX.setValue(stream.getX());
        spinY.setValue(stream.getY());
        spinW.setValue(stream.getWidth());
        spinH.setValue(stream.getHeight());
        cboFonts.setSelectedItem(this.stream.getFont());
        txtHexColor.setText(Integer.toHexString(this.stream.getColor()));
        spinZOrder.setValue(stream.getZOrder());
        txtContent.setText(this.stream.getContent());
        tglActiveStream.setSelected(stream.isPlaying());
    }

    @Override
    public void updatePreview(BufferedImage image) {
        viewer.setImage(image);
        viewer.repaint();
    }
}
