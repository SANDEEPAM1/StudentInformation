/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package student.controller;

import java.util.List;
import student.model.Model;

/**
 *
 * @author Acer
 */
public interface DBOperation {
    
    public void save (Model obj);
    public void delete (Model obj);
    public void update (Model obj);
    public Model getInfo (int id);
    public List<Model> list();
    
    
    
}
