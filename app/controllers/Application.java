package controllers;

import play.*;
import play.data.validation.Valid;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

 /*   public static void index() {
        render();
    }	*/
   public static void about() {
        render();
    }
    
    public static void start() {
        render();
    }
    
/*    public static void login() {
        render();
    }	*/
    
    public static void blog() {
        render();
    }
    
    public static void contact() {
        render();
    }
    
    public static void gallery() {
        render();
    }
    
    public static void myaccount() {
        render();
    }
    
    public static void productdetails() {
        render();
    }
    
    public static void productgrid() {
        render();
    }
    
    public static void single() {
        render();
    }
    
    public static void buyingcart() {
        render();
    }

   public static void index() {
        if(connected() != null) {
            Application.login();
        }
        render();
    }
 //   ------------------User Save-----------------
    
    

    public static void saveUser(@Valid User user, String verifyPassword)
    
    {
        validation.required(verifyPassword);
        validation.equals(verifyPassword, user.password).message("Your password doesn't match");
        if(validation.hasErrors()) {
            render("@login", user, verifyPassword);
        }
        user.create();
        session.put("user", user.username);
        //flash.success("Welcome, " + user.name);
    
        String name = user.name;
        render("@index",name);
      
    }

    public static void login() 
    {
        render();
    
    }
    
    //-----------login session------------------------------------------------
    
    public static void login(String username, String password) {
        User user = User.find("byUsernameAndPassword", username, password).first();
        if(user != null) {
            session.put("user", user.username);
            flash.success("Welcome, " + user.name);
            Application.index();         
        }
        // Oops
        flash.put("username", username);
        flash.error("Login failed");
        index();
    }
    //------------------------------------------log out-------------
    public static void logout() {
        session.clear();
        index();
    }

    
    //-----------------------------others methods------------------------
    
    
    static void addUser() {
        User user = connected();
        if(user != null) {
            renderArgs.put("user", user);
        }
    }
    
    //-----------------------------
    
    static User connected() {
        if(renderArgs.get("user") != null) {
            return renderArgs.get("user", User.class);
        }
        
        String username = session.get("user");
        if(username != null) {
            return User.find("byUsername", username).first();
        } 
        return null;
    }
    
    
    public static void Usersession()    
    
    {
    	  String chk="asim";
    	      	 
    	 //  renderText( chk);
    	  
    	// renderText("@main",chk);
    	  
    	//  renderArgs.put("@main", chk);
    	  
    	// renderArgs.put("main", chk);
    	  
    	 render("/main.html",chk);
    		
    	   
    }

	
    

}//end braces