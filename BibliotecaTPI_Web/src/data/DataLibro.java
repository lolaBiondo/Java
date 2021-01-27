package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import entities.*;

public class DataLibro {
	
	public LinkedList<Libro> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Libro> libros= new LinkedList<>();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from libro");
			if(rs!=null) {
				while(rs.next()) {
					Libro lib=new Libro();
					lib.setIdLibro(rs.getInt("idLibro"));
					lib.setTitulo(rs.getString("titulo"));
					lib.setIsbn(rs.getInt("isbn"));
					lib.setFechaEdicion(rs.getDate("fechaEdicion"));
					lib.setNroEdicion( rs.getInt("nroEdicion"));
					lib.setCantDiasMaxPrestamo(rs.getInt("cantDiasMaxPrestamo"));
					lib.setGenero(rs.getString("genero"));
					lib.setCUIT(rs.getString("cuit"));
					
					libros.add(lib);
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
		
		
		return libros;
	}
	
	
	public Libro add(Libro lib) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"INSERT INTO `biblioteca`.`libro` ( `titulo`, `isbn`, `nroEdicion`, `cantDiasMaxPrestamo`, `genero`) VALUES(?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							); //, `fechaEdicion`
			stmt.setString(1, lib.getTitulo());
			stmt.setLong(2, lib.getIsbn());
			stmt.setLong(3, lib.getNroEdicion());
			stmt.setLong(4, lib.getCantDiasMaxPrestamo());
			stmt.setString(5, lib.getGenero());	
			//stmt.setTimestamp(6, new java.sql.Timestamp(lib.getFechaEdicion().getTime()));
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                lib.setIdLibro(keyResultSet.getInt(1));
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
		
		return lib;
	}
	
	public Libro getById(Libro lib) {
		Libro l = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from libro where idLibro=?");
			stmt.setInt(1, lib.getIdLibro());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				l = new Libro();
				l.setIdLibro(rs.getInt("idLibro"));
				l.setIsbn(rs.getInt("isbn"));
				l.setTitulo(rs.getString("titulo"));
				l.setFechaEdicion(rs.getDate("fechaEdicion"));
				l.setNroEdicion(rs.getInt("nroEdicion"));
				l.setCantDiasMaxPrestamo(rs.getInt("cantDiasMaxPrestamo"));
				l.setGenero(rs.getString("genero"));
				l.setCUIT(rs.getString("cuit"));
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
		
		return l;
	}

	public Libro editLibro(Libro lib) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE `biblioteca`.`libro` SET `titulo` = ?, `isbn` = ?, `nroEdicion` = ?, `cantDiasMaxPrestamo` = ?, `genero` = ?, `fechaEdicion` = ? WHERE (`idLibro` = ?);",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, lib.getTitulo());
			stmt.setLong(2, lib.getIsbn());
			stmt.setLong(3, lib.getNroEdicion());
			stmt.setLong(4, lib.getCantDiasMaxPrestamo());
			stmt.setString(5, lib.getGenero());	
			stmt.setTimestamp(6, new java.sql.Timestamp(lib.getFechaEdicion().getTime()));
			
			stmt.setInt(7,  lib.getIdLibro());
			stmt.executeUpdate();
			
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
		return lib;
	}

	public Libro deleteLibro(Libro lib) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"DELETE FROM `biblioteca`.`libro` WHERE (`idLibro` = ?);",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1, lib.getIdLibro());
			stmt.executeUpdate();	
            
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
		return lib;
	}
	
	//EJEMPLAR
	
	public LinkedList<Ejemplar> getAllEjemplares(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Ejemplar> ejemplares= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select idEjemplar, idLibro, estado from ejemplar");
			//intencionalmente no se recupera la password
			if(rs!=null) {
				while(rs.next()) {
					Ejemplar ej = new Ejemplar();
					ej.setIdEjemplar(rs.getInt("idEjemplar"));
					ej.setIdLibro(rs.getInt("idLibro"));
					ej.setEstado(rs.getBoolean("estado"));
					ejemplares.add(ej);
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
		
		
		return ejemplares;
	}

	public LinkedList<Ejemplar> getEjByIdLibro(Libro lib) {
		Ejemplar ej =null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		LinkedList<Ejemplar> ejemplares = new LinkedList<>();
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select idEjemplar,idLibro,estado from ejemplar where idLibro=?"
					);
			stmt.setLong(1, lib.getIdLibro());
			rs=stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
				ej = new Ejemplar();
				ej.setIdEjemplar(rs.getInt("idEjemplar"));
				ej.setIdLibro(rs.getInt("idLibro"));
				ej.setEstado(rs.getBoolean("estado"));
				ejemplares.add(ej);
			}}
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
		
		return ejemplares;
	}

	public Ejemplar addEjemplar(Ejemplar ej) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"INSERT INTO `biblioteca`.`ejemplar` ( `idLibro`,`estado` ) VALUES(?, ?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setLong(1, ej.getIdLibro());
			stmt.setBoolean(2,  ej.getEstado());

            stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                ej.setIdEjemplar(keyResultSet.getInt(1));
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
		
		return ej;
    }

	public Ejemplar deleteEjemplar(Ejemplar ej) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"DELETE FROM `biblioteca`.`ejemplar` WHERE (`idEjemplar` = ?);",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setLong(1, ej.getIdEjemplar());
			stmt.executeUpdate();	
			
            
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
		return ej;
		
	}
	
	public Ejemplar deleteEjemplarPorIdLibro(Ejemplar ej, Libro lib) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"DELETE FROM `biblioteca`.`ejemplar` WHERE (`idEjemplar` = ? and `idLibro` = ?);",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setLong(1, ej.getIdEjemplar());
			stmt.setLong(1, lib.getIdLibro());
			stmt.executeUpdate();	
			
            
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
		return ej;
		
	}

	/*public Ejemplar getByIdEjemplar(Ejemplar ej) {
		Ejemplar ejemp = null;
		DataLibro dl = new DataLibro();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select idEjemplar,idLibro,idLineaPrestamo from ejemplar where idEjemplar=?"
					);
			stmt.setLong(1, ej.getIdEjemplar());
			rs=stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
				ejemp = new Ejemplar();
				dl.setLibro(ejemp);
				ejemp.setIdEjemplar(rs.getInt("idEjemplar"));
				ejemp.getLib().setIdLibro(rs.getInt("idLibro"));
				ejemp.setIdLineaPrestamo(rs.getInt("idLineaPrestamo"));
				
			}}
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
		
		return ejemp;
	}*/
	
	
		
	

}
