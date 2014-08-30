package es.cursoangularjs.jackson;


public class Main {


    public static void main(String[] args) {
        JsonTransformer jsonTransformer=new JsonTransformerImplJackson();
        
        Usuario usuario=new Usuario("Alberto Tortosa","alberto_tortosa@gmail.com",91);
        
        String jsonUsuario=jsonTransformer.toJson(usuario);
        
        System.out.println(jsonUsuario);
        
        
        Usuario newUsuario=(Usuario) jsonTransformer.fromJson(jsonUsuario, Usuario.class);
          
        System.out.println("Nombre:"+newUsuario.getNombre());
        System.out.println("E-Mail:"+newUsuario.getEmail());
        System.out.println("Edad:"+newUsuario.getEdad());

        
    }
    
}
