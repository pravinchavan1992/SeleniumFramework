package common;


import org.yaml.snakeyaml.Yaml;
import utils.FrameworkConstant;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadYamlFile {
    private static ReadYamlFile instance = new ReadYamlFile();

    private AppDetails appDetails;

    private ReadYamlFile() {
        Yaml yaml =new Yaml();
        Path path = FrameworkConstant.getConfigYamlFilePath();
        try (InputStream in = Files.newInputStream(path)) {
            appDetails = yaml.loadAs(in, AppDetails.class);
        } catch (IOException ie) {
            //TODO:Log exception.
            ie.printStackTrace();
            throw new ExceptionInInitializerError(ie);
        }
    }

    private static ReadYamlFile getInstance() {
        if (instance == null) {
            //synchronized block to remove overhead
            synchronized (ReadYamlFile.class) {
                if (instance == null) {
                    // if instance is null, initialize
                    instance = new ReadYamlFile();
                }
            }
        }
        return instance;
    }

    public static AppDetails getSettings() {
        return getInstance().appDetails;
    }
}
