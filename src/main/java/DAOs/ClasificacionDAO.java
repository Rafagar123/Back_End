package DAOs;

import DbManager.DbManager;
import Models.Clasificacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClasificacionDAO {
    private Connection db;
    private static final String INSERT = "INSERT INTO clasificacion (id, nombre) VALUES (?,?)";
    private static final String LISTALL = "SELECT * FROM clasificacion";
    private static final String LISTONE = "SELECT * FROM clasificacion WHERE id = ?";
    private static final String DELETE = "DELETE FROM clasificacion WHERE id = ?";
    private static final String UPDATE = "UPDATE clasificacion SET nombre = ? WHERE id = ?";

    public ClasificacionDAO(DbManager db) {
        this.db = db.getConnection();
    }
    
    public void clasificacion_listall () throws SQLException{
        PreparedStatement stmt = db.prepareStatement(LISTALL);
        ResultSet rs = stmt.executeQuery();
        
        try{
            while(rs.next()){
                Clasificacion clasificacion = new Clasificacion
                (rs.getInt("id"),
                rs.getString("nombre"));
                System.out.println(clasificacion.toString());    
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    };
    
    public void clasificacion_listone (int id) throws SQLException{
        PreparedStatement stmt = db.prepareStatement(LISTONE);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        
        try{
                Clasificacion clasificacion = new Clasificacion
                (rs.getInt("id"),
                rs.getString("nombre"));
                System.out.println(clasificacion.toString());    
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    };

    
    public void clasificacion_delete (int id) throws SQLException{
        try{
            PreparedStatement stmt = db.prepareStatement(DELETE);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    };
    
    public void clasificacion_insert (int id, String nombre) throws SQLException{
         try{
            PreparedStatement stmt = db.prepareStatement(INSERT);
            stmt.setInt(1, id);
            stmt.setString(2, nombre); 
            stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    };
    
    public void clasificacion_update (int id, String nombre) throws SQLException{
         try{
            PreparedStatement stmt = db.prepareStatement(UPDATE);
            stmt.setInt(2, id);
            stmt.setString(1, nombre); 
            stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    };
  
}
