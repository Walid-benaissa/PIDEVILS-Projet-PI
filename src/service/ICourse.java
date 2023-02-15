/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author bough
 * @param <T>
 */
public interface ICourse<T> {
    
     public void ajouterC(T c) throws SQLException;

    /**
     *
     * @param c
     * @throws SQLException
     */
    public void ajouterCC(T c) throws SQLException;

    /**
     *
     * @return
     * @throws SQLException
     */
    public List<T> afficherCourse() throws SQLException;
    
    /**
     *
     * @param c
     * @throws SQLException
     */
    public void supprimerC(T c) throws SQLException;
    
    /**
     *
     * @param c
     * @throws SQLException
     */
    public void modifierC(T c) throws SQLException;
}
