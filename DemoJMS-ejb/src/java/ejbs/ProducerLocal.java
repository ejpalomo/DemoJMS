/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import javax.ejb.Local;
import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 *
 * @author Esteban
 */
@Local
public interface ProducerLocal {
    public void sendMessageToQueue(String message) throws JMSException, NamingException;
}
