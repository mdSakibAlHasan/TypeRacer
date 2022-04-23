package com.example.typeracer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientController {

    @FXML
    private TextField ipTextField;
    @FXML
    private Label conneted;
    private Socket socket;
    private DataInputStream input   = null;
    private DataOutputStream out     = null;

    private DataInputStream in       =  null;
    // constructor to put ip address and port
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button button;

    public void  client(String address, int port)
    {
        // establish a connection
        try
        {
            System.out.println("Connecting.....");
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            input  = new DataInputStream(System.in);

            // sends output to the socket
            out    = new DataOutputStream(socket.getOutputStream());

            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));
        }
        catch(UnknownHostException u)
        {
            System.out.println(u+" Exception created");
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

        // string to read message from input
        String line = "";

        // keep reading until "Over" is input
        while (!line.equals("Over"))
        {
            try
            {
                line = input.readLine();
                out.writeUTF(line);
                System.out.println(in.readUTF());
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }

        // close the connection
        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }


    @FXML
    public void setIpTextField(ActionEvent event) throws IOException {
        String ip = ipTextField.getText();
        //client(ip,5321);

        socket = new Socket(ip, 5321);
        conneted.setText("CONNECTED");
       // input  = new DataInputStream(System.in);
        out    = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));

       // button.setDisable(false);
        waitingHostStart(event,in);

    }

    public String connectWithServe(int numberOfWord)
    {
        String line = null;
        try {
            line = in.readUTF();
            out.writeUTF(String.valueOf(numberOfWord));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return line;
    }

    public void waitingHostStart(ActionEvent event, DataInputStream in)
    {
        String line = null;
        conneted.setText("CONNECTED wait...");
        try {
             line = in.readUTF();
            if(line.equals("start")){
                enterMainRace(event);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    @FXML
    public void enterMainRace(ActionEvent event) throws IOException {
        root = FXMLLoader.load((getClass().getResource("group-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        new GroupController();
    }

    public DataInputStream getDataInputStream()
    {
        return in;
    }

    public DataOutputStream getDataOutPutStream()
    {
        return out;
    }


}
