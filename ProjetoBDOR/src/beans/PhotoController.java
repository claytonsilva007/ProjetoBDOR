/*package beans;
import java.io.File;
import java.io.IOException;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
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
        filename = getRandomImageName();
        byte[] data = captureEvent.getData();
         
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String newFileName = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "demo" +
                                    File.separator + "images" + File.separator + "photocam" + File.separator + filename + ".png";
         
        FileImageOutputStream imageOutput;
        try {
            imageOutput = new FileImageOutputStream(new File(newFileName));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
        }
        catch(IOException e) {
            throw new FacesException("Error in writing captured image.", e);
        }
    }
}*/


package beans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
import org.primefaces.event.CaptureEvent;
import org.primefaces.model.CroppedImage;

/**
 *
 * @author benignoms
 */
@ManagedBean
@ViewScoped
public class PhotoController {

    private CroppedImage imagemRecortada;
    private String foto;
    private String fotoRecortada;
    private String arquivoFoto;
    private String arquivoFotoRecortada;
    private boolean exibeImagemCapturada;
    private ServletContext servletContext;

    public String getArquivoFoto() {
        return arquivoFoto;
    }

    public void setArquivoFoto(String arquivoFoto) {
        this.arquivoFoto = arquivoFoto;
    }

    public String getArquivoFotoRecortada() {
        return arquivoFotoRecortada;
    }

    public void setArquivoFotoRecortada(String arquivoFotoRecortada) {
        this.arquivoFotoRecortada = arquivoFotoRecortada;
    }

    public boolean isExibeImagemCapturada() {
        return exibeImagemCapturada;
    }

    public void setExibeImagemCapturada(boolean exibeImagemCapturada) {
        this.exibeImagemCapturada = exibeImagemCapturada;
    }

    public String getFotoRecortada() {
        return fotoRecortada;
    }

    public void setFotoRecortada(String fotoRecortada) {
        this.fotoRecortada = fotoRecortada;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public CroppedImage getImagemRecortada() {
        return imagemRecortada;
    }

    public void setImagemRecortada(CroppedImage imagemRecortada) {
        this.imagemRecortada = imagemRecortada;
    }

    private String getNumeroRandomico() {
        int i = (int) (Math.random() * 10000);
        return String.valueOf(i);
    }

    private void criaArquivo(String arquivo, byte[] dados) {
        FileImageOutputStream imageOutput;
        try {
            imageOutput = new FileImageOutputStream(new File(arquivo));
            imageOutput.write(dados, 0, dados.length);
            imageOutput.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PhotoController.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Caminho não encontrado!", "Erro"));
        } catch (IOException ex) {
            Logger.getLogger(PhotoController.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao criar arquivo!", "Erro"));
        }
    }

    public void recortar() {
        verificaExistenciaArquivo(arquivoFotoRecortada);
        fotoRecortada = "fotoRecortada" + getNumeroRandomico() + ".png";
        arquivoFotoRecortada = servletContext.getRealPath(File.separator + "imagens" + File.separator + "tmp" + File.separator + fotoRecortada);
        criaArquivo(arquivoFotoRecortada, imagemRecortada.getBytes());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Foto RECORTADA com sucesso!", "Informação"));
    }

    public void oncapture(CaptureEvent captureEvent) {
        verificaExistenciaArquivo(arquivoFoto);
        foto = "foto" + getNumeroRandomico() + ".png";
        arquivoFoto = servletContext.getRealPath(File.separator + "imagens" + File.separator + "tmp" + File.separator + foto);
        criaArquivo(arquivoFoto, captureEvent.getData());
        exibeImagemCapturada = true;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Foto CAPTURADA com sucesso!", "Informação"));
    }

    private void verificaExistenciaArquivo(String arquivo) {
        if (arquivo != null) {
            File file = new File(arquivo);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public PhotoController() {
        exibeImagemCapturada = false;
        servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    }
}

