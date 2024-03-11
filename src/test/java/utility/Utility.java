package utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Utility {
    public static final String FS = System.getProperty("file.separator");
    public static final String SOURCE_FOLDER = System.getProperty("user.dir") + FS + "src" + FS;
    public static final String RESOURCE_FOLDER = SOURCE_FOLDER + "resources" + FS;

    public static <T> T deserializeStringToObject(String content, Class<T> castToObject) {
        try {
            return new ObjectMapper().readValue(content, castToObject);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static <T> T deserializeFileContentToObject(File file, Class<T> castToObject) {
        try {
            return new ObjectMapper().readValue(file, castToObject);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static String serializeToString(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException();
        }
    }
}
