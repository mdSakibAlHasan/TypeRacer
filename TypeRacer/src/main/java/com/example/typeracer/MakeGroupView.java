package com.example.typeracer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MakeGroupView {

    @FXML
    Label connected = new Label();
    @FXML
    Button button = new Button();


    private Stage stage;
    private Scene scene;
    private Parent root;

    private Socket socket   = null;
    private ServerSocket server   = null;
    private DataInputStream in       =  null;
    private DataOutputStream out     = null;

    //MakeGroupView makeGroupView;

//    public MakeGroupView()
//    {
//        //makeGroupView.server(5321);
//        server(5321);
//
//    }

    // constructor with port
    public void server(int port)
    {
        button.setDisable(true);
        // starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");
            connected.setText("CONNECTED");
            button.setDisable(false);


            // takes input from the client socket
            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            out    = new DataOutputStream(socket.getOutputStream());



            // close connection
//            socket.close();
//            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }


    public String clientWordNumber(int currentWord)
    {
        String line = null;
        try {
            line = in.readUTF();
            //System.out.println(line);
            out.writeUTF(String.valueOf(currentWord));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return line;
    }

   public DataInputStream getDataInputStream()
   {
       return in;
   }

   public DataOutputStream getOutPutStream()
   {
       return out;
   }

   @FXML
   public void searchClient(ActionEvent event)
   {
       server(5321);
   }

    @FXML
    public void startButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load((getClass().getResource("group-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        new GroupController();
        out.writeUTF("start");
    }

}
