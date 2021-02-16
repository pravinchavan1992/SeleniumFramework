package utils;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Objects;

public final class FrameworkConstant {
    private FrameworkConstant() {
    }

    private static final Integer EXPLICITWAITTIME = 5000;

    private static final String PROJECT_PATH = System.getProperty("user.dir");

    private static String extentReportFilePath = "";

    private static final String EXTENTREPORTFOLDERPATH = getProjectPath() + "/extent-test-output/";

    public static String getProjectPath() {
        return PROJECT_PATH;
    }

    public static Duration getExplicitTime() {
        return Duration.ofMillis(EXPLICITWAITTIME.intValue());
    }

    public static Path getConfigReaderFilePath() {
        String env = Utilities.getEnv();
        if (Objects.nonNull(env)) {
            return Paths.get(getProjectPath(), "src" + File.separator + "main" + File.separator + "resources" + File.separator + "config", "config_" + env + ".properties");
        } else {
            return Paths.get(getProjectPath(), "src" + File.separator + "main" + File.separator + "resources" + File.separator + "config" + File.separator + "config.properties");
        }
    }

    public static Path getConfigYamlFilePath() {
        String env = Utilities.getEnv();
        if (Objects.nonNull(env)) {
            return Paths.get(getProjectPath(), "src" + File.separator + "main" + File.separator + "resources" + File.separator + "config" + File.separator + "config_" + env + ".yaml");
        } else {
            return Paths.get(getProjectPath(), "src" + File.separator +  "main" + File.separator + "resources" + File.separator + "config" + File.separator + "config.yaml");
        }
    }

    public static String getExtentReportFilePath() {
        if (extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    private static String createReportPath() {
        return EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "/index.html";
    }


}
