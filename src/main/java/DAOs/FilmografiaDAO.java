package DAOs;

import DbManager.DbManager;
import Models.Filmografia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmografiaDAO {
    private Connection db;
    private static final String INSERT = "INSERT INTO filmografia"
            + "(id, titulo, fecha_estreno, sinopsis, pais_id, clasificacion_id) VALUES (?,?,?,?,?,?)";
    private static final String LISTALL = "SELECT * FROM filmografia";
    private static final String LISTONE = "SELECT * FROM filmografia WHERE id = ?";
    private static final String DELETE = "DELETE FROM filmografia WHERE id = ?";
    private static final String UPDATE = "UPDATE filmografia SET titulo = ?, fecha_estreno= ?, "
            + "sinopsis= ?, pais_id = ?, clasificacion_id= ? WHERE id = ?";

    public FilmografiaDAO(DbManager db) {
        this.db = db.getConnection();
    }
    
    public void filmografia_listall () throws SQLException{
        Filmografia film = new Filmografia();
        PreparedStatement stmt = db.prepareStatement(LISTALL);
        ResultSet rs = stmt.executeQuery();
        
        try{
            while(rs.next()){
                film.setId(rs.getInt("id"));
                film.setTitulo(rs.getString("titulo"));
                film.setFecha_estreno(rs.getDate("fecha_estreno"));
                film.setSinopsis(rs.getString("sinopsis"));
                film.setPais_id(rs.getInt("pais_id"));
                film.setClasificacion_id(rs.getInt("clasificacion_id"));
                System.out.println(film.toString());    
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    };
    
    public void filmografia_listone (int id) throws SQLException{
        Filmografia film = new Filmografia();
        PreparedStatement stmt = db.prepareStatement(LISTONE);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        
        try{
                film.setId(rs.getInt("id"));
                film.setTitulo(rs.getString("titulo"));
                film.setFecha_estreno(rs.getDate("fecha_estreno"));
                film.setSinopsis(rs.getString("sinopsis"));
                film.setPais_id(rs.getInt("pais_id"));
                film.setClasificacion_id(rs.getInt("clasificacion_id"));
                System.out.println(film.toString());    
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    };

    
    public void filmografia_delete (int id) throws SQLException{
        try{
        PreparedStatement stmt = db.prepareStatement(DELETE);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    };
    
    public void filmografia_insert (int id, String titulo, Date fecha_Estreno,
                String sinopsis, int pais_id, int clasificacion_id) throws SQLException{
         try{
            PreparedStatement stmt = db.prepareStatement(INSERT);
            stmt.setInt(1, id);
            
            stmt.setString(2, titulo);
            stmt.setDate(3, fecha_Estreno);
            stmt.setString(4, sinopsis);
            stmt.setInt(5, pais_id);
            stmt.setInt(6, clasificacion_id); 
            stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    };
    
    public void filmografia_update (int id, String titulo, Date fecha_Estreno,
                String sinopsis, int pais_id, int clasificacion_id) throws SQLException{
         try{
            PreparedStatement stmt = db.prepareStatement(UPDATE);
            stmt.setInt(1, id);
            stmt.setString(2, titulo);
            stmt.setDate(3, fecha_Estreno);
            stmt.setString(4, sinopsis);
            stmt.setInt(5, pais_id);
            stmt.setInt(6, clasificacion_id);  
            stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    };
  
}




       