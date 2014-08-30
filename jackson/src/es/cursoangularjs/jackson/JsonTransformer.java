package es.cursoangularjs.jackson;

public interface JsonTransformer {
    String toJson(Object data);
    Object fromJson(String json, Class clazz);
}
