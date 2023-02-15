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
public interface IOffre<T> {
        public void ajouterO(T o) throws SQLException;

    /**
     *
     * @param o
     * @throws SQLException
     */
    public void ajouterOO(T o) throws SQLException;

    /**
     *
     * @return
     * @throws SQLException
     */
    public List<T> afficherOffre() throws SQLException;
    
    /**
     *
     * @param o
     * @throws SQLException
     */
    public void supprimerO(T o) throws SQLException;
    
    /**
     *
     * @param c
     * @throws SQLException
     */
    public void modifierO(T o) throws SQLException;
    
}
