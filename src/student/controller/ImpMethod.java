/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.controller;

import com.mysql.cj.protocol.Resultset;
import java.util.List;
import student.model.Model;
import java.sql.Connection;
import student.db.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
/**
 *
 * @author Acer
 */

public class ImpMethod implements DBOperation{

    @Override
    public void save(Model obj) {
        
        try {
            
            Connection conn = DBConnection.dbConnection();
            String sql = "INSERT INTO detailsstudent (Name, Course, Fee) VALUES (?,?,?) ";
            PreparedStatement pt = conn.prepareCall(sql);
            pt.setString(1, obj.getName());
            pt.setString(2, obj.getCourse());
            pt.setInt(3, obj.getFee());
            pt.executeLargeUpdate();
            
            JOptionPane.showMessageDialog(null, "saved");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "error");
            
        }
    }

    @Override
    public void delete(Model obj) {
        
        Connection conn;
        try {
            conn = DBConnection.dbConnection();
            String sql = "DELETE FROM detailsstudent WHERE student_Id = ?";
            PreparedStatement pt = conn.prepareCall(sql);
            pt.setInt(1, obj.getId());
            pt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "error");
        }
            
       
        
        
    }

    @Override
    public void update(Model obj) {
        
        try {
            Connection conn = DBConnection.dbConnection();
            String sql = "UPDATE detailsstudent SET Name =?, Course=?, Fee=? WHERE student_Id = ?";
            PreparedStatement pt = conn.prepareCall(sql);
            pt.setString(1, obj.getName());
            pt.setString(2, obj.getCourse());
            pt.setInt(3, obj.getFee());
            pt.setInt(4, obj.getId());
            pt.executeLargeUpdate();
            
            JOptionPane.showMessageDialog(null, "successfully updated");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "error");
        }
        
        
   }

    @Override
    public Model getInfo(int id) {
        Model obj = new Model();
        try {
          
        Connection conn = DBConnection.dbConnection();
        String sql = "Select * From detailsstudent Where student_Id = ?";
        PreparedStatement pt = conn.prepareCall(sql);
        pt.setInt(1, id);
        ResultSet rs = pt.executeQuery();
        
        if(rs.next())
        {
            obj.setId(rs.getInt("student_Id"));
            obj.setName(rs.getString("Name"));
            obj.setCourse(rs.getString("Course"));
            obj.setFee(rs.getInt("Fee"));
            
            
        }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "error");
        }
       
        
        return  obj;
        }

    @Override
    public List<Model> list() {
        List <Model> list = new ArrayList<Model>();
        
        try {
            Connection conn = DBConnection.dbConnection();
            String sql = "Select * From detailsstudent ";
            PreparedStatement pt = conn.prepareCall(sql);
            ResultSet rs = pt.executeQuery();
            
            while (rs.next()) {
                Model obj = new Model();
                obj.setId(rs.getInt("student_Id"));
                obj.setName(rs.getString("Name"));
                obj.setCourse(rs.getString("Course"));
                obj.setFee(rs.getInt("Fee"));
                
                list.add(obj);
                
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "error");
        }
        
        
        return list;
         }
    
    
    
    
}
