/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bahri.servlet;

import com.bahri.dao.domain.Person;
import com.bahri.dao.service.PersonService;
import com.bahri.dao.service.impl.PersonServiceImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bahrie
 */
public class PersonServlet extends HttpServlet{

    private String show="/WEB-INF/jsp/person/list.jsp";
    private String form="/WEB-INF/jsp/person/form.jsp";
    
    private PersonService personService;
    
    public PersonServlet() {
        personService=new PersonServiceImpl();
    }

    public void showAll(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        List<Person> listPerson=personService.getAll();
        req.setAttribute("data", listPerson);
        RequestDispatcher dispatcher=req.getRequestDispatcher(show);
        dispatcher.forward(req, resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if(action !=null){
            if(action.equalsIgnoreCase("insert")){
                RequestDispatcher dispatcher=req.getRequestDispatcher(form);
                dispatcher.forward(req, resp);
            }else if(action.equalsIgnoreCase("update")){
                String id=req.getParameter("id");
                if(id!=null){
                    Person person=personService.getById(Long.parseLong(id));
                    req.setAttribute("person", person);
                    RequestDispatcher dispatcher=req.getRequestDispatcher(form);
                    dispatcher.forward(req, resp);
                }
            }else if(action.equalsIgnoreCase("delete")){
                String id=req.getParameter("id");
                if(id!=null){
                    Person person=new Person();
                    person.setId(Long.parseLong(id));
                    personService.delete(person);
                    showAll(req, resp);
                }
            }
        }else{
            showAll(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String nama=req.getParameter("nama");
        String alamat=req.getParameter("alamat");
        
        Person person=new Person();
        if(id.isEmpty()){
            person.setNama(nama);
            person.setAlamat(alamat);
            personService.save(person);
        }else{
            person.setId(Long.parseLong(id));
            person.setNama(nama);
            person.setAlamat(alamat);
            personService.save(person);
        }
        showAll(req, resp);
    }

    @Override
    public String getServletInfo() {
        return "servlet person";
    }
    
    
    
}
