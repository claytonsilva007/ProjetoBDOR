/*package beans;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.CaptureEvent;
 
@ManagedBean
@ViewScoped
public class PhotoCamView {
     
    private String filename;
     
    private String getRandomImageName() {
        int i = (int) (Math.random() * 10000000);
         
        return String.valueOf(i);
    }
 
    public String getFilename() {
        return filename;
    }
     
    public void oncapture(CaptureEvent captureEvent) {
        filename = getRandomImageName() + ".png";
                
        byte[] data = captureEvent.getData();
        InputStream in = new ByteArrayInputStream(data);
        
        //Controlador.getcontrolador().cadastrarFoto(in);
    }
}*/