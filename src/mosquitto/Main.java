/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mosquitto;

/**
 *
 * @author estel
 */
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Cliente clienteMQTT = new Cliente("tcp://broker.mqttdashboard.com:1883", null, null);
        clienteMQTT.iniciar();

        new Ouvinte(clienteMQTT, "novo ouvinte", 0);

        while (true) {
            Thread.sleep(1000);
            String mensagem = "A mensagem foi enviada na data e horario " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(System.currentTimeMillis());

            clienteMQTT.publicar("teste", mensagem.getBytes(), 0);
        }
    }
}