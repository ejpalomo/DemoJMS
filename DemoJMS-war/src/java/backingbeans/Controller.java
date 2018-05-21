/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbeans;

import ejbs.ProducerLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 *
 * @author Esteban
 */
@Named(value = "controller")
@RequestScoped
public class Controller {

    @EJB
    private ProducerLocal producer;
    /**
     * Creates a new instance of Controller
     */
    public Controller() {
    }
    
    public String synchronousProcess(){
        System.out.println("Synchronous Process!!");
        return null;
    }
    
    public String asynchronousProcess(){
        try {
            producer.sendMessageToQueue("Some message!!!");
        } catch (JMSException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
