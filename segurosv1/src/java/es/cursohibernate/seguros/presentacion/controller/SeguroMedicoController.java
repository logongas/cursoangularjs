package es.cursohibernate.seguros.presentacion.controller;

import es.cursohibernate.seguros.dominio.SeguroMedico;
import es.cursohibernate.seguros.persistencia.BussinessException;
import es.cursohibernate.seguros.persistencia.BussinessMessage;
import es.cursohibernate.seguros.persistencia.SeguroMedicoDAO;
import es.cursohibernate.seguros.presentacion.json.JsonTransformer;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SeguroMedicoController {

    @Autowired
    JsonTransformer jsonTransformer;

    @Autowired
    SeguroMedicoDAO seguroMedicoDAO;  
    
    @RequestMapping(value = "/SeguroMedico/{idSeguroMedico}", method = RequestMethod.GET, produces = "application/json")
    public void read(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idSeguroMedico") int idSeguroMedico) {
        try {
            SeguroMedico seguroMedico = seguroMedicoDAO.get(idSeguroMedico);
            String jsonSalida = jsonTransformer.toJson(seguroMedico);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);
            
        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage=ex.getBussinessMessages();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                Logger.getLogger(SeguroMedicoController.class.getName()).log(Level.SEVERE, null, ex1);
            }
            
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            
        }

    }

    @RequestMapping(value = "/SeguroMedico", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        try {
            SeguroMedico seguroMedico = (SeguroMedico) jsonTransformer.fromJson(jsonEntrada, SeguroMedico.class);
            seguroMedicoDAO.insert(seguroMedico);
            String jsonSalida = jsonTransformer.toJson(seguroMedico);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);
            
        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage=ex.getBussinessMessages();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                Logger.getLogger(SeguroMedicoController.class.getName()).log(Level.SEVERE, null, ex1);
            }

            
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                Logger.getLogger(SeguroMedicoController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    
    @RequestMapping(value = "/SeguroMedico", method = RequestMethod.GET, produces = "application/json")
    public void find(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            List<SeguroMedico> segurosMedicos = seguroMedicoDAO.findAll();
            String jsonSalida = jsonTransformer.toJson(segurosMedicos);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);
            
        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage=ex.getBussinessMessages();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                Logger.getLogger(SeguroMedicoController.class.getName()).log(Level.SEVERE, null, ex1);
            }
            
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            
        }

    }   
    
    @RequestMapping(value = "/SeguroMedico/{idSeguroMedico}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada, @PathVariable("idSeguroMedico") int idSeguroMedico) {
        try {
            SeguroMedico seguroMedico = (SeguroMedico) jsonTransformer.fromJson(jsonEntrada, SeguroMedico.class);
            seguroMedicoDAO.update(idSeguroMedico,seguroMedico);
            String jsonSalida = jsonTransformer.toJson(seguroMedico);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);
            
        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage=ex.getBussinessMessages();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                Logger.getLogger(SeguroMedicoController.class.getName()).log(Level.SEVERE, null, ex1);
            }

            
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                Logger.getLogger(SeguroMedicoController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @RequestMapping(value = "/SeguroMedico/{idSeguroMedico}", method = RequestMethod.DELETE, produces = "application/json")
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idSeguroMedico") int idSeguroMedico) {
        try {
            seguroMedicoDAO.delete(idSeguroMedico);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            
        } catch (BussinessException ex) {
            List<BussinessMessage> bussinessMessage=ex.getBussinessMessages();
            String jsonSalida = jsonTransformer.toJson(bussinessMessage);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            try {
                httpServletResponse.getWriter().println(jsonSalida);
            } catch (IOException ex1) {
                Logger.getLogger(SeguroMedicoController.class.getName()).log(Level.SEVERE, null, ex1);
            }
            
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            
        }

    }    
    
}
