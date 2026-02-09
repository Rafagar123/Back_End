package DAOs;

import DbManager.DbManager;
import Models.Cuenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CuentaDAO {
    private Connection db;
    private static final String INSERT = "INSERT INTO cuenta (id_cuenta, tipo_cuenta, "
            + "nombre, password_hash) VALUES (?,?,?,?)";
    private static final String LISTALL = "SELECT * FROM cuenta";
    private static final String LISTONE = "SELECT * FROM cuenta WHERE id_cuenta = ?";
    private static final String DELETE = "DELETE FROM clasificacion WHERE id_cuenta = ?";
    private static final String UPDATE = "UPDATE clasificacion SET tipo_cuenta = ?,  "
            + "nombre = ?, password_hash = ? WHERE id_cuenta = ?";

    public CuentaDAO(DbManager db) {
        this.db = db.getConnection();
    }
    
    public void cuenta_listall () throws SQLException{
        PreparedStatement stmt = db.prepareStatement(LISTALL);
        ResultSet rs = stmt.executeQuery();
        
        try{
            while(rs.next()){
                Cuenta cuenta = new Cuenta
                (rs.getInt("id_cuenta"),
                rs.getString("tipo_cuenta"),
                rs.getString("nombre"),
                rs.getString("password_hash"));
                System.out.println(cuenta.toString());    
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally {
            if (stmt != null) try {
                stmt.close();
            } catch (SQLException e) {
                throw new SQLException("Error cerrando statement", e);
            }
            
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
                throw new SQLException("Error cerrando statement", e);
            }
        }
    };
    
    public void cuenta_listone (int id_cuenta) throws SQLException{
        PreparedStatement stmt = db.prepareStatement(LISTONE);
        stmt.setInt(1, id_cuenta);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        
        try{
            Cuenta cuenta = new Cuenta
            (rs.getInt("id_cuenta"),
            rs.getString("tipo_cuenta"),
            rs.getString("nombre"),
            rs.getString("password_hash"));
            System.out.println(cuenta.toString());    
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally {
            if (stmt != null) try {
                stmt.close();
            } catch (SQLException e) {
                throw new SQLException("Error cerrando statement", e);
            }
            
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
                throw new SQLException("Error cerrando statement", e);
            }
        }
    };

    
    public void cuenta_delete (int id_cuenta) throws SQLException{
            PreparedStatement stmt = db.prepareStatement(DELETE);
        try{
            stmt.setInt(1, id_cuenta);
            stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally {
            if (stmt != null) try {
                stmt.close();
            } catch (SQLException e) {
                throw new SQLException("Error cerrando statement", e);
            }
        }
    };
    
    public void cuenta_insert (int id_cuenta, String tipo_cuenta, 
            String nombre, String password_hash) throws SQLException{
            PreparedStatement stmt = db.prepareStatement(INSERT);
        try{
            stmt.setInt(1, id_cuenta);
            stmt.setString(2, tipo_cuenta); 
            stmt.setString(3, nombre); 
            stmt.setString(4, password_hash); 
            stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally {
            if (stmt != null) try {
                stmt.close();
            } catch (SQLException e) {
                throw new SQLException("Error cerrando statement", e);
            }
        }
    };
    
    public void acceso_update (int id_cuenta, String tipo_cuenta, 
            String nombre, String password_hash) throws SQLException{
            PreparedStatement stmt = db.prepareStatement(UPDATE);
        try{
            stmt.setInt(4, id_cuenta);
            stmt.setString(1, tipo_cuenta); 
            stmt.setString(2, nombre); 
            stmt.setString(3, password_hash); 
            stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally {
            if (stmt != null) try {
                stmt.close();
            } catch (SQLException e) {
                throw new SQLException("Error cerrando statement", e);
            }
        }
    };
  
}