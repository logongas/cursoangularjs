package es.cursohibernate.seguros.persistencia;

import es.cursohibernate.seguros.dominio.SeguroMedico;
import java.util.List;

public interface SeguroMedicoDAO {

    void insert(SeguroMedico seguroMedico) throws BussinessException;
            
    void update(int idSeguroMedico,SeguroMedico seguroMedico) throws BussinessException;

    SeguroMedico get(int idSeguroMedico) throws BussinessException;

    void delete(int idSeguroMedico) throws BussinessException;

    List<SeguroMedico> findAll() throws BussinessException;
}
