package beans;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.CaptureEvent;

import controller.Controlador;
 
@ManagedBean
@ViewScoped
public class PhotoCamView {
     
    private String filename;
    private Blob blob;
    
    public PhotoCamView(){
    	//this.blob = this.consultarImagem(1);
    }
    
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
    
    public InputStream consultarImagem(int id){
    	InputStream blob = Controlador.getcontrolador().consultarImagem(id);
		return blob;
    }

	public Blob getBlob() {
		return blob;
	}

	public void setBlob(Blob blob) {
		this.blob = blob;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
    
}