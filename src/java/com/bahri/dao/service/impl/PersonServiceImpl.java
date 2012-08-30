/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bahri.dao.service.impl;

import com.bahri.dao.connection.ConnectionUtils;
import com.bahri.dao.domain.Person;
import com.bahri.dao.service.PersonService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bahrie
 */
public class PersonServiceImpl implements PersonService{

    public void save(Person person) {
        if(person.getId()==null){
            try {
                PreparedStatement ps=ConnectionUtils.getConnection().prepareStatement("insert into person(nama,alamat) values (?,?)");
                ps.setString(1, person.getNama());
                ps.setString(2, person.getAlamat());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(PersonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                PreparedStatement ps=ConnectionUtils.getConnection().prepareStatement("update person set nama=?,alamat=? where id=?");
                ps.setString(1, person.getNama());
                ps.setString(2, person.getAlamat());
                ps.setLong(3, person.getId());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(PersonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void delete(Person person) {
        try {
                PreparedStatement ps=ConnectionUtils.getConnection().prepareStatement("delete from person where id=?");
                ps.setLong(1, person.getId());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(PersonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public List<Person> getAll() {
        List<Person> listPerson=new ArrayList<Person>();
        try {
            Statement st=ConnectionUtils.getConnection().createStatement();
            ResultSet rs=st.executeQuery("select *from person");
            while(rs.next()){
                Person person=new Person();
                person.setId(rs.getLong("id"));
                person.setNama(rs.getString("nama"));
                person.setAlamat(rs.getString("alamat"));
                listPerson.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPerson;
    }

    public Person getById(Long id) {
        Person person=new Person();
        try {
            PreparedStatement ps=ConnectionUtils.getConnection().prepareStatement("select * from person where id=?");
            ps.setLong(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                person.setId(rs.getLong("id"));
                person.setNama(rs.getString("nama"));
                person.setAlamat(rs.getString("alamat"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person;
    }
    
}
