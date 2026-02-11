package DAOs;

import DbManager.DbManager;
import java.sql.SQLException;
import java.sql.Date;

public class MainFilmo {
public static void main(String[] args) {
    
  DbManager db= new DbManager();  
  db.conectar();
  FilmografiaDAO filmdao = new FilmografiaDAO(db);
  
    try{
    //    filmdao.filmografia_insert(8, "Rafa", Date.valueOf("2022-02-17"), "Drama dramoso", 4, 80);
    //    filmdao.filmografia_listall();
    //    filmdao.filmografia_update(8, "Johny Glamour", Date.valueOf("2001-07-28"), "Aventura hipnótica", 4, 1);
    //    filmdao.filmografia_listall();
    //    filmdao.filmografia_delete(8);
        filmdao.filmografia_listall();

    }catch (SQLException e) {
        System.out.println(e.getMessage());
    }
   
    
  db.desconectar();
 }   
}
