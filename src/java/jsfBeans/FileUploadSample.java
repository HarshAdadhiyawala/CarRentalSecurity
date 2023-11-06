package jsfBeans;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
/**
 *
 * @author Admin
 */
@Named(value = "fileUploadSample")
@Dependent
public class FileUploadSample {
String fname="";
    /**
     * Creates a new instance of FileUploadSample
     */
String errmsg;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
    public FileUploadSample() {
    }
    public void handleFileUpload(FileUploadEvent event)
    {
                Random random = new Random();
	        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");   
	        FacesContext.getCurrentInstance().addMessage(null, msg);   
                try {
                    //C:\Users\SONY\Documents\NetBeansProjects\PrimeFaces\web\images
                    ExternalContext extContext=FacesContext.getCurrentInstance().getExternalContext();
       
                    int pos1= extContext.getRealPath("").lastIndexOf("\\");
                    String path1=extContext.getRealPath("").substring(0,pos1) ;
                    int pos2= path1.lastIndexOf("\\");
                    String path2=path1.substring(0,pos2);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
                    int pos3= path2.lastIndexOf("\\");
                    String path3=path2.substring(0,pos3);//+"\\OnlineClubHolidayProject-war\\web\\clubimage\\" ;
                    int pos4= path3.lastIndexOf("\\");
                    String path4=path2+"\\web\\upload\\" ;

                    // "E:\Project\projrun\OnlineClubHolidayProject\OnlineClubHolidayProject-war"
                    File targetFolder = new File(path4);
                    int pos=event.getFile().getFileName().lastIndexOf("\\");
                    String dfname=random.nextInt(10000) + "";
                    if (pos>0)
                        dfname+=event.getFile().getFileName().substring(pos);
                    else
                        dfname+=event.getFile().getFileName();

//                    fname=dfname;
fname = dfname;
                    InputStream inputStream = event.getFile().getInputstream();
                    OutputStream out = new FileOutputStream(new File(targetFolder,dfname));
                    int read = 0;
                    byte[] bytes = new byte[1024];
                    while ((read = inputStream.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                    }
                    
                    inputStream.close();
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }	    
        
    }

    
}
