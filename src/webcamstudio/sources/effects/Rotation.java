/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package webcamstudio.sources.effects;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.prefs.Preferences;
import javax.swing.JPanel;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import webcamstudio.sources.effects.controls.RotationControl;

/**
 *
 * @author karl
 */
public class Rotation extends Effect{
    private int angle = 0;

    @Override
    public void applyEffect(BufferedImage img) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
        int w = img.getWidth();
        int h = img.getHeight();
        int counter = 0;
        Mat dst = new Mat();
        
        int[] intData = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
        byte[] byteData = new byte[intData.length * 3];
        for (int i = 0; i < byteData.length; i += 3) {
            byteData[i] = (byte) ((intData[counter] >> 16) & 0xFF);
            byteData[i + 1] = (byte) ((intData[counter] >> 8) & 0xFF);
            byteData[i + 2] = (byte) ((intData[counter]) & 0xFF);
            counter++;
        }
        
        Mat src = new Mat(h, w, CvType.CV_8UC3);
        src.put(0, 0, byteData);
        
        // Filter ...
        Point pt = new Point(w/2., h/2.);
        Mat mapMatrix = Imgproc.getRotationMatrix2D(pt, angle, 1.0);
        Imgproc.warpAffine(src, dst, mapMatrix, new Size(w, h));
        
        byte[] data = new byte[dst.rows()*dst.cols()*(int)(dst.elemSize())];
        dst.get(0, 0, data);
        if (dst.channels() == 3) {
            for (int i = 0; i < data.length; i += 3) {
            byte temp = data[i];
            data[i] = data[i + 2];
            data[i + 2] = temp;
            }
        }
        BufferedImage temp = new BufferedImage(dst.cols(), dst.rows(), BufferedImage.TYPE_3BYTE_BGR);
        temp.getRaster().setDataElements(0, 0, dst.cols(), dst.rows(), data);
        
        Graphics2D buffer = img.createGraphics();
        buffer.setRenderingHint(RenderingHints.KEY_RENDERING,
                           RenderingHints.VALUE_RENDER_SPEED);
        buffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                           RenderingHints.VALUE_ANTIALIAS_OFF);
        buffer.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                           RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        buffer.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
                           RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        buffer.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
                           RenderingHints.VALUE_COLOR_RENDER_SPEED);
        buffer.setRenderingHint(RenderingHints.KEY_DITHERING,
                           RenderingHints.VALUE_DITHER_DISABLE);
        buffer.drawImage(temp, 0, 0,null);
        buffer.dispose();
    }
    @Override
    public boolean needApply(){
        return needApply=true;
    }
    @Override
    public JPanel getControl() {
        return new RotationControl(this);
    }

    /**
     * @return the brightness
     */
    public int getAngle() {
        return angle;
    }

    /**
     * @param angles
     */
    public void setAngle(int angles) {
        this.angle = angles;
    }

    @Override
    public void applyStudioConfig(Preferences prefs) {
//        prefs.putFloat("hFactor", hFactor);
//        prefs.putFloat("sFactor", sFactor);
//        prefs.putFloat("bFactor", bFactor);
        
    }

    @Override
    public void loadFromStudioConfig(Preferences prefs) {
//        hFactor=prefs.getFloat("hFactor", hFactor);
//        sFactor=prefs.getFloat("sFactor", sFactor);
//        bFactor=prefs.getFloat("bFactor", bFactor);
    }
}