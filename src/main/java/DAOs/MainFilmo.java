/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DbManager.DbManager;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;

public class MainFilmo {
public static void main(String[] args) {

  DbManager db= new DbManager();  
  db.conectar();
  FilmografiaDAO film = new FilmografiaDAO(db);
  
    try {
        film.filmografia_insert(8, "Rafa", 02-03-2026, "Drama dramoso", 4, 1);
    } catch (SQLException ex) {
        System.getLogger(MainFilmo.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
    }
    
  
  db.desconectar();
 }   
}
