package es.cursohibernate.basedatos.persistencia;


public class BussinessMessage  {
    private final String fieldName;
    private final String message;
 
    public BussinessMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
     
    public String getFieldName() {
        return fieldName;
    }
 
    public String getMessage() {
        return message;
    }
    
}
