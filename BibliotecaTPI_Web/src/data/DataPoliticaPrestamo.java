package data;


import java.util.LinkedList;
import java.util.Date;
import entities.*;

import java.sql.*;

public class DataPoliticaPrestamo {

	public LinkedList<PoliticaPrestamo> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<PoliticaPrestamo> politicas = new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select idPolitica,fechaAlta,cantMaximaSocio,cantMaximaNoSocio from politica_prestamo");
			//intencionalmente no se recupera la password
			if(rs!=null) {
				while(rs.next()) {
					PoliticaPrestamo pp = new PoliticaPrestamo();
					pp.setIdPoliticaPrestamo(rs.getInt("idPolitica"));
					pp.setFechaAlta(rs.getDate("fechaAlta"));
					pp.setCantMaximaNoSocio(rs.getInt("cantMaximaSocio"));
					pp.setCantMaximaSocio(rs.getInt("cantMaximaNoSocio"));
					
					politicas.add(pp);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return politicas;
	}
	
	public PoliticaPrestamo add(PoliticaPrestamo pp) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into politica_prestamo(fechaAlta,cantMaximaSocio,cantMaximaNoSocio) values(?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			
			java.util.Date d = new Date();  
			stmt.setTimestamp(1, new java.sql.Timestamp(d.getTime()));
			stmt.setInt(2, pp.getCantMaximaSocio());
			stmt.setInt(3, pp.getCantMaximaNoSocio());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                pp.setIdPoliticaPrestamo(keyResultSet.getInt(1));
            }

			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		
		return pp;
    }

	public PoliticaPrestamo getById(PoliticaPrestamo poliprest) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		PoliticaPrestamo pp = null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select idPolitica,fechaAlta,cantMaximaSocio,cantMaximaNoSocio from politica_prestamo where idPolitica=?"
					);
			stmt.setInt(1, poliprest.getIdPoliticaPrestamo());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				pp = new PoliticaPrestamo();
				pp.setIdPoliticaPrestamo(rs.getInt("idPolitica"));
				pp.setCantMaximaSocio(rs.getInt("cantMaximaSocio"));
				pp.setCantMaximaNoSocio(rs.getInt("cantMaximaNoSocio"));
				pp.setFechaAlta(rs.getDate("fechaAlta"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return pp;
	}

	public PoliticaPrestamo editPolitica(PoliticaPrestamo pp) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE `biblioteca`.`politica_prestamo` SET `cantMaximaSocio` = ?, `cantMaximaNoSocio` = ? WHERE (`idPolitica` = ?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1,pp.getCantMaximaSocio());
			stmt.setInt(2,pp.getCantMaximaNoSocio());
			stmt.setInt(3, pp.getIdPoliticaPrestamo());
			stmt.executeUpdate();
			
			/*keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                pp.setIdPoliticaPrestamo(keyResultSet.getInt(1));
            }*/

			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		
		return pp;
	}
	
	public PoliticaPrestamo deletePolitica(PoliticaPrestamo pp) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"DELETE FROM `biblioteca`.`politica_prestamo` WHERE (`idPolitica` = ?);",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setLong(1, pp.getIdPoliticaPrestamo());
			stmt.executeUpdate();	
			keyResultSet=stmt.getGeneratedKeys();
			 if(keyResultSet!=null && keyResultSet.next()){
	               pp.setIdPoliticaPrestamo(keyResultSet.getInt(1));
	            }
            
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		return pp;
		
	}


}
