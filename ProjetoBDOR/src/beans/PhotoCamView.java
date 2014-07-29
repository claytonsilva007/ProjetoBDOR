package beans;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;

import org.primefaces.event.CaptureEvent;

import controller.Controlador;
 
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
        
        Controlador.getcontrolador().cadastrarFoto(in);
    }
}