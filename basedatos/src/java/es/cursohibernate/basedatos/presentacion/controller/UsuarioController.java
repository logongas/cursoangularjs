package es.cursohibernate.basedatos.presentacion.controller;


import es.cursohibernate.basedatos.persistencia.SeguroMedicoDAO;
import es.cursohibernate.basedatos.dominio.SeguroMedico;
import es.cursohibernate.basedatos.presentacion.json.JsonTransformer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UsuarioController {
    
    @Autowired
    private JsonTransformer jsonTransformer;
    
    @Autowired
    SeguroMedicoDAO seguroMedicoDAO;
    
    @RequestMapping(value = {"/SeguroMedico"})
    public void prueba(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws Exception {
        SeguroMedico seguroMedico=seguroMedicoDAO.get(6);
        String jsonSeguroMedico=jsonTransformer.toJson(seguroMedico);
        
        httpServletResponse.getWriter().println(jsonSeguroMedico);
    }
}
