package es.cursohibernate.seguros.presentacion.json.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.cursohibernate.seguros.presentacion.json.JsonTransformer;
import java.io.IOException;

public class JsonTransformerImplJackson implements JsonTransformer {

    @Override
    public String toJson(Object data) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Object fromJson(String json, Class clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                        
            return objectMapper.readValue(json, clazz);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
