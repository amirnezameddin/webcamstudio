/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webcamstudio.streams;

import java.awt.image.BufferedImage;
import webcamstudio.externals.ProcessRenderer;
import webcamstudio.externals.FME;
import webcamstudio.mixers.MasterMixer;

/**
 *
 * @author patrick (modified by karl)
 */
public class SinkBroadcast extends Stream {

    private ProcessRenderer capture = null;
    private FME fme = null;
    private boolean isPlaying = false;
    private String standard = "STD";
    public SinkBroadcast(FME fme) {
        this.fme=fme;
        name=fme.getName();
        url = fme.getUrl()+"/"+fme.getStream();
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public void read() {
        isPlaying=true;
        rate = MasterMixer.getInstance().getRate();
        captureWidth = MasterMixer.getInstance().getWidth();
        captureHeight = MasterMixer.getInstance().getHeight();
        if (name.toLowerCase().equals("red5")){
            if (standard.equals("STD")) {
                capture = new ProcessRenderer(this,fme,"broadcastR5");
            } else {
                capture = new ProcessRenderer(this,fme,"broadcastR5HQ");
            }  
        } else if (name.toLowerCase().equals("icecast")){
            if (standard.equals("STD")) {
                capture = new ProcessRenderer(this,fme,"iceCast");
            } else {
                capture = new ProcessRenderer(this,fme,"iceCastHQ");
            }
            } else {
            if (standard.equals("STD")) {
                capture = new ProcessRenderer(this,fme,"broadcast");
            } else {
                capture = new ProcessRenderer(this,fme,"broadcastHQ");
            }
        }
        capture.writeCom();
    }

    @Override
    public void stop() {
        isPlaying=false;
        if  (capture!=null){
            capture.stop();
            capture=null;
        }
    }
    @Override
    public boolean needSeek() {
            return needSeekCTRL=false;
    }

    @Override
    public boolean isPlaying() {
        return isPlaying;
        }

    @Override
    public BufferedImage getPreview() {
        return null;
    }
    public void setStandard(String gStandard) {
        standard = gStandard;
    }
    
    public String getStandard() {
        return standard;
    }
    
    @Override
    public boolean hasAudio() {
        return true;
    }

    @Override
    public boolean hasVideo() {
        return true;
    }

    @Override
    public void readNext() {
        
    }
}