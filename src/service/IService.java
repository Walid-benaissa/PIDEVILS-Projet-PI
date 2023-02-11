/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author walid
 */
public interface IService<T> {
    
    List<T> afficheListe() throws SQLException;
    void ajouter (T p) throws SQLException;
    void supprimer (T p) throws SQLException;
    void modifier (T p) throws SQLException;
    
}
