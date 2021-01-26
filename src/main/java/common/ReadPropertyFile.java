package common;

import enums.Config;
import exceptions.PropertyFileUsageException;
import utils.FrameworkConstant;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {
    private static Properties prop = null;

    private ReadPropertyFile() {
        prop = new Properties();
        try (InputStream in = Files.newInputStream(FrameworkConstant.getConfigReaderFilePath())) {
            prop.load(in);
        } catch (IOException e) {
            throw  new PropertyFileUsageException("Not Able to load: "+FrameworkConstant.getConfigReaderFilePath(), e.getCause());
        }
    }

    public static String getProperty(Config config)  {
        if (Objects.isNull(prop)) {
            new ReadPropertyFile();
        }
        if (Objects.isNull(config.name())) {
            throw  new PropertyFileUsageException("Property Name " + config.name() + " is null");
        }
        if (Objects.isNull(prop.getProperty(config.name()))) {
            throw  new PropertyFileUsageException("Value for  " + config.name() + " is null");
        }
        return prop.getProperty(config.name());
    }
}
