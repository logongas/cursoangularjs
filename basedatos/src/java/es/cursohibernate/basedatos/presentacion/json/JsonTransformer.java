package es.cursohibernate.basedatos.presentacion.json;

public interface JsonTransformer {
    String toJson(Object data);
    Object fromJson(String json, Class clazz);
}
