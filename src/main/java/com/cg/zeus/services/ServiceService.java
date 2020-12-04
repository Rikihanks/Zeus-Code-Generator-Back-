package com.cg.zeus.services;

import com.cg.zeus.generators.Service.ServiceImplementationGenerator;
import com.cg.zeus.generators.Service.ServiceInterfaceGenerator;
import com.cg.zeus.model.ObjectModel;
import com.cg.zeus.util.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ServiceService {

    public static void generateServiceImplementation(List<ObjectModel> models) {
        ServiceImplementationGenerator s = new ServiceImplementationGenerator();


        models.forEach(model -> {
            System.out.println(s.generate(model.getEntityName(), (HashMap<String, String>) model.getProperties(), model.getIdParamName()));
            BufferedWriter writer = null;
            try {

                File file = new File("/tmp/ZeusGenerated");
                file.mkdirs();

                File file2 = new File(file.getPath()+"/Services/"+ StringUtils.capitalize(model.getEntityName()));
                file2.mkdirs();

                writer = new BufferedWriter(new FileWriter(file2.getPath()+"/"+s.generateServiceName(model.getEntityName())+"Imp.java"));

                writer.write(s.generate(model.getEntityName(), (HashMap<String, String>) model.getProperties(), model.getIdParamName()));

                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void generateServiceInterface(List<ObjectModel> models) {
        ServiceInterfaceGenerator s = new ServiceInterfaceGenerator();


        models.forEach(model -> {
            System.out.println(s.generate(model.getEntityName(), (HashMap<String, String>) model.getProperties(), model.getIdParamName()));
            BufferedWriter writer = null;
            try {

                File file = new File("/tmp/ZeusGenerated");
                file.mkdirs();

                File file2 = new File(file.getPath()+"/Services/"+ StringUtils.capitalize(model.getEntityName()));
                file2.mkdirs();

                writer = new BufferedWriter(new FileWriter(file2.getPath()+"/"+s.generateServiceName(model.getEntityName())+".java"));

                writer.write(s.generate(model.getEntityName(), (HashMap<String, String>) model.getProperties(), model.getIdParamName()));

                writer.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
