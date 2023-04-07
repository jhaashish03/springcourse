package com.springRest.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileuploaderHelp   {
    // public static final String UPLOAD_DIR="C:\\Users\\ashishjh\\OneDrive - HCL Technologies Ltd\\Desktop\\Spring (1)\\Spring\\springRest\\springRest\\src\\main\\resources\\static\\image";
    /**
     *
     */
    
        public  String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();
    
    

   



public FileuploaderHelp() throws IOException{
    }







public boolean uploadFile(MultipartFile file){
    boolean f=false;
try {
    // InputStream is=file.getInputStream();
    // byte data[]=new byte[is.available()];
    // is.read(data);

    // FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.pathSeparator+file.getOriginalFilename());
    // fos.write(data);
    // fos.flush();
    // fos.close();
   
    Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
    f=true;

} catch (Exception e) {
    // TODO: handle exception
    e.printStackTrace();
    
}

    return f;
}
}

