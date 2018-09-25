package config;


import Exceptions.FileUtilityException;
import constants.Constants;
import org.json.JSONObject;
import utils.FileUtils;

import java.io.FileWriter;
import java.io.IOException;

//import com.sun.javafx.runtime.SystemProperties;

/**
 *
 */
public final class CommonConfigHolder {
    private static final CommonConfigHolder INSTANCE = new CommonConfigHolder();
    private JSONObject configJson;

    private CommonConfigHolder() {
    }

    public static CommonConfigHolder getInstance() {
        return INSTANCE;
    }

    public JSONObject getConfigJson() {
        return configJson;
    }

    public void setConfigUsingResource(String peerName) throws FileUtilityException {
        String resourcePath = System.getProperty(Constants.REGISTRY_HOME)
                + "/src/main/resources/" + peerName + ".json";
        this.configJson = new JSONObject(FileUtils.readFileContentAsText(resourcePath));
        System.out.println(resourcePath);
    }

    public void savePeersIPsandPorts(String data) throws IOException {
        String resourcePath = System.getProperty(Constants.REGISTRY_HOME)
                + "/src/main/resources/";
        try (FileWriter file = new FileWriter(resourcePath + "peersDetails.txt")) {
            file.write(data);

            System.out.println("written into file");

        }


    }

}

