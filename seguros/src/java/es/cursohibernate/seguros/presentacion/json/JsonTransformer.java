package es.cursohibernate.seguros.presentacion.json;

public interface JsonTransformer {
    String toJson(Object data);
    Object fromJson(String json, Class clazz);
}
