package es.cursoangularjs.inyecciondependencias.json;

public interface JsonTransformer {
    String toJson(Object data);
    Object fromJson(String json, Class clazz);
}
