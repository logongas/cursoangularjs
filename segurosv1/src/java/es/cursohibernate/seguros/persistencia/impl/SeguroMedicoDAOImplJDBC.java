package es.cursohibernate.seguros.persistencia.impl;

import es.cursohibernate.seguros.persistencia.BussinessException;
import es.cursohibernate.seguros.persistencia.SeguroMedicoDAO;
import es.cursohibernate.seguros.dominio.SeguroMedico;
import es.cursohibernate.seguros.dominio.Sexo;
import es.cursohibernate.seguros.persistencia.BussinessMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SeguroMedicoDAOImplJDBC implements SeguroMedicoDAO {

    @Override
    public void insert(SeguroMedico seguroMedico) throws BussinessException {

        if ("11111111A".equals(seguroMedico.getNif())) {
            throw new BussinessException(new BussinessMessage("nif","La letra no es válida"));
        }
        
        
        Connection connection = null;

        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `seguromedico` (`nif`, `nombre`, `ape1`, `edad`, `sexo`, `casado`, `numhijos`, `embarazada`, `coberturaoftalmologica`, `coberturadental`, `coberturafecundacioninvitro`, `enfermedadcorazon`, `enfermedadestomacal`, `enfermedadrinyones`, `enfermedadalergia`, `nombrealergia`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, seguroMedico.getNif());
            preparedStatement.setString(2, seguroMedico.getNombre());
            preparedStatement.setString(3,seguroMedico.getApe1() );
            preparedStatement.setInt(4,seguroMedico.getEdad() );
            preparedStatement.setString(5,seguroMedico.getSexo().name() );
            preparedStatement.setBoolean(6,seguroMedico.isCasado() );
            preparedStatement.setInt(7,seguroMedico.getNumHijos() );
            preparedStatement.setBoolean(8, seguroMedico.isEmbarazada());
            preparedStatement.setBoolean(9,seguroMedico.getCoberturas().isOftalmologia() );
            preparedStatement.setBoolean(10,seguroMedico.getCoberturas().isDental() );
            preparedStatement.setBoolean(11,seguroMedico.getCoberturas().isFecundacionInVitro() );
            preparedStatement.setBoolean(12, seguroMedico.getEnfermedades().isCorazon());
            preparedStatement.setBoolean(13, seguroMedico.getEnfermedades().isEstomacal() );
            preparedStatement.setBoolean(14, seguroMedico.getEnfermedades().isRinyones() );
            preparedStatement.setBoolean(15, seguroMedico.getEnfermedades().isAlergia() );
            preparedStatement.setString(16,  seguroMedico.getEnfermedades().getNombreAlergia());


            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {

                }
            }
        }
    }

    @Override
    public void update(int idSeguroMedico, SeguroMedico seguroMedico) throws BussinessException {

        Connection connection = null;

        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `seguromedico` SET `nif`=?, `nombre`=?, `ape1`=?, `edad`=?, `sexo`=?, `casado`=?, `numhijos`=?, `embarazada`=?, `coberturaoftalmologica`=?, `coberturadental`=?, `coberturafecundacioninvitro`=?, `enfermedadcorazon`=?, `enfermedadestomacal`=?, `enfermedadrinyones`=?, `enfermedadalergia`=?, `nombrealergia`=? WHERE IdSeguroMedico=?");

            preparedStatement.setString(1, seguroMedico.getNif());
            preparedStatement.setString(2, seguroMedico.getNombre());
            preparedStatement.setString(3,seguroMedico.getApe1() );
            preparedStatement.setInt(4,seguroMedico.getEdad() );
            preparedStatement.setString(5,seguroMedico.getSexo().name() );
            preparedStatement.setBoolean(6,seguroMedico.isCasado() );
            preparedStatement.setInt(7,seguroMedico.getNumHijos() );
            preparedStatement.setBoolean(8, seguroMedico.isEmbarazada());
            preparedStatement.setBoolean(9,seguroMedico.getCoberturas().isOftalmologia() );
            preparedStatement.setBoolean(10,seguroMedico.getCoberturas().isDental() );
            preparedStatement.setBoolean(11,seguroMedico.getCoberturas().isFecundacionInVitro() );
            preparedStatement.setBoolean(12, seguroMedico.getEnfermedades().isCorazon());
            preparedStatement.setBoolean(13, seguroMedico.getEnfermedades().isEstomacal() );
            preparedStatement.setBoolean(14, seguroMedico.getEnfermedades().isRinyones() );
            preparedStatement.setBoolean(15, seguroMedico.getEnfermedades().isAlergia() );
            preparedStatement.setString(16,  seguroMedico.getEnfermedades().getNombreAlergia());
            preparedStatement.setInt(17,  idSeguroMedico);

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {

                }
            }
        }
    }

    @Override
    public SeguroMedico get(int idSeguroMedico) throws BussinessException {
        Connection connection = null;

        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM SeguroMedico WHERE idSeguroMedico=?");
            
            preparedStatement.setInt(1, idSeguroMedico);
            
            ResultSet rst = preparedStatement.executeQuery();

            if (rst.next()) {
                return createSeguroMedico(rst);
            } else {
                return null;
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {

                }
            }
        }
    }

    @Override
    public void delete(int idSeguroMedico) throws BussinessException {
        
        if (idSeguroMedico==1) {
            throw new BussinessException(new BussinessMessage(null,"No es posible borrar el seguro médico"));
        }
        
        Connection connection = null;

        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM SeguroMedico WHERE idSeguroMedico=?");

            preparedStatement.setInt(1, idSeguroMedico);

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {

                }
            }
        }
    }

    @Override
    public List<SeguroMedico> findAll() throws BussinessException {
        Connection connection = null;
        List<SeguroMedico> segurosMedicos = new ArrayList<>();

        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM SeguroMedico");
            ResultSet rst = preparedStatement.executeQuery();

            while (rst.next()) {
                segurosMedicos.add(createSeguroMedico(rst));
            }

            return segurosMedicos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {

                }
            }
        }
    }

    private SeguroMedico createSeguroMedico(ResultSet rst) {
        try {
            SeguroMedico seguroMedico = new SeguroMedico();

            seguroMedico.setIdSeguro(rst.getInt("idSeguroMedico"));
            seguroMedico.setNif(rst.getString("nif"));
            seguroMedico.setNombre(rst.getString("nombre"));
            seguroMedico.setApe1(rst.getString("ape1"));
            seguroMedico.setEdad(rst.getInt("edad"));
            seguroMedico.setSexo(Sexo.valueOf(rst.getString("sexo")));
            seguroMedico.setCasado(rst.getBoolean("casado"));
            seguroMedico.setNumHijos(rst.getInt("numhijos"));
            seguroMedico.setEmbarazada(rst.getBoolean("embarazada"));
            seguroMedico.getCoberturas().setOftalmologia(rst.getBoolean("coberturaoftalmologica"));
            seguroMedico.getCoberturas().setDental(rst.getBoolean("coberturadental"));
            seguroMedico.getCoberturas().setFecundacionInVitro(rst.getBoolean("coberturafecundacioninvitro"));

            seguroMedico.getEnfermedades().setCorazon(rst.getBoolean("enfermedadcorazon"));
            seguroMedico.getEnfermedades().setEstomacal(rst.getBoolean("enfermedadestomacal"));
            seguroMedico.getEnfermedades().setRinyones(rst.getBoolean("enfermedadrinyones"));
            seguroMedico.getEnfermedades().setAlergia(rst.getBoolean("enfermedadalergia"));
            seguroMedico.getEnfermedades().setNombreAlergia(rst.getString("nombrealergia"));
            
            
            return seguroMedico;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private Connection getConnection() {
        try {
            InitialContext initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource dataSource = (DataSource) envCtx.lookup("jdbc/seguromedico");

            return dataSource.getConnection();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
