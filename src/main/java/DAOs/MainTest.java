package DAOs;

import DbManager.DbManager;
import java.sql.SQLException;
import java.sql.Date;

public class MainTest {
public static void main(String[] args) {
    
  DbManager db= new DbManager();  
  db.conectar();
  AccesoDAO acceso = new AccesoDAO(db);
  
    try{
    //    acceso.acceso_insert(8, 6, 5, Date.valueOf("2022-02-17"), 5);
    //    film.filmografia_listall();
    //    film.filmografia_update(8, "Johny Glamour", Date.valueOf("2001-07-28"), "Aventura hipnótica", 4, 1);
    //    film.filmografia_listall();
    //    film.filmografia_delete(8);
       acceso.acceso_listall();

    }catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    
  db.desconectar();
 }   
}
