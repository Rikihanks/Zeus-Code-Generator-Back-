package com.cg.zeus.controllers;

import com.cg.zeus.model.ObjectModel;
import com.cg.zeus.services.DtoService;
import com.cg.zeus.services.ServiceService;
import com.cg.zeus.util.ZipUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Base64;
import java.util.zip.ZipOutputStream;


@CrossOrigin(origins = "*")
@RestController
public class MainController {

    @PostMapping("/generate")
    public String generate(@RequestBody ObjectModel model [], HttpServletResponse response) {

        ZipUtils.deleteFolderIfExist("/tmp");
        ServiceService.generateServiceImplementation(Arrays.asList(model));
        ServiceService.generateServiceInterface(Arrays.asList(model));
        DtoService.generateDtos(Arrays.asList(model));

        try {
            FileOutputStream fos = new FileOutputStream("/tmp/dirCompressed.zip");
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            File fileToZip = new File("/tmp/ZeusGenerated");
            ZipUtils.zipFile(fileToZip, fileToZip.getName(), zipOut);

            zipOut.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


            try {
                // get your file as InputStream
                InputStream is = new FileInputStream("/tmp/dirCompressed.zip");
                // copy it to response's OutputStream
                response.setContentType("application/zip");
                byte[] targetArray = new byte[is.available()];
                is.read(targetArray);


                return Base64.getEncoder().encodeToString(targetArray);
            } catch (IOException ex) {
                throw new RuntimeException("IOError writing file to output stream");
            }


    }
}
