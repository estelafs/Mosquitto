/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mosquitto;

import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;
/**
 *
 * @author estel
 */
public class Ouvinte implements IMqttMessageListener {

    public Ouvinte(Cliente clienteMQTT, String topico, int qos) {
        clienteMQTT.subscribe(qos, this, topico);
    }

    @Override
    public void messageArrived(String topico, MqttMessage mm) throws Exception {
        System.out.println("Mensagem recebida:");
        System.out.println("\nTopico: " + topico);
        System.out.println("\nMensagem: " + new String(mm.getPayload()));
        System.out.println("");
    }

}