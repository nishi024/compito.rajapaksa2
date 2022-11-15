package it.rajapaksa;

import java.io.*;
import java.net.*;

public class ServerStr {
    ServerSocket server = null;
    Socket client = null;
    String stringRicevuta = null;
    String stringModifica = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;

    public Socket attendi() {
        try {
            System.out.print("server in esecuzione");
            server = new ServerSocket(6789);// creo un server sulla porta (6789)  
            client = server.accept();// in attesa di un client

            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outVersoClient = new DataOutputStream(client.getOutputStream());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore");
            System.exit(1);
        }
        return client;
    }

public void comunica()
{
    try
    {
        System.out.println("");
        stringRicevuta = inDalClient.readLine();
        System.out.println(""+stringRicevuta);

        //modifico e riinvio
        stringModifica=stringRicevuta.toUpperCase();
        System.out.println("stringa modificata");
        outVersoClient.writeBytes(stringModifica+'\n');

        //chiudo connessione dei client
        System.out.println("chiudo connessione");
        client.close();

    } catch(Exception e){
        System.out.println(e.getMessage());
        System.out.println("....");
    }
    
}
}
