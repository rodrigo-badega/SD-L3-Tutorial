/**
 *
 * @author Rodrigo Oliveira Badega 2207273
 * @author Guilherme Henrique Soeiro Fontes 2320657
 */

package br.ejb;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;

@MessageDriven( activationConfig={
    @ActivationConfigProperty(
        propertyName="destinationLookup",
        propertyValue="java/Fila"),
    @ActivationConfigProperty(
        propertyName="destinationQueue",
        propertyValue="jakarta.jms.Queue")
})

public class EJBConsumidor implements MessageListener {

    @Override
    public void onMessage(Message msg){
        System.out.println("Mensagem recebida");
        try{
            TextMessage tm = (TextMessage) msg;
            System.out.println(tm.getText());
        }catch(Exception e){
            
        }
    }
}
