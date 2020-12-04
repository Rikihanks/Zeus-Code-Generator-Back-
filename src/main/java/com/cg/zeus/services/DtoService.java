package com.cg.zeus.services;

import com.cg.zeus.generators.Dto.DtoGenerator;
import com.cg.zeus.model.ObjectModel;
import com.cg.zeus.util.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DtoService {

    public static void generateDtos(List<ObjectModel> models) {
        DtoGenerator generator = new DtoGenerator();

        models.forEach(model -> {
            System.out.println(generator.generate(model.getEntityName(), (HashMap<String, String>) model.getProperties(), model.getIdParamName()));
            BufferedWriter writer = null;
            try {

                File file = new File("/tmp/ZeusGenerated");
                file.mkdirs();

                File file2 = new File(file.getPath()+"/Dto/"+ StringUtils.capitalize(model.getEntityName()));
                file2.mkdirs();

                writer = new BufferedWriter(new FileWriter(file2.getPath()+"/"+model.getEntityName()+"Dto.java"));

                writer.write(generator.generate(model.getEntityName(), (HashMap<String, String>) model.getProperties(), model.getIdParamName()));

                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
