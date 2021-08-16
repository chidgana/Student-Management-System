package main;

import Database.DBHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by chidgana on 02-Dec-17.
 */
public class Login {

    public TextField txtuid, txtpwd;
    public Label lblmsg;
    public Button btnlogin;
    String us ,pw;
    Connection connection;
    ResultSet rs;
    DBHandler handler = new DBHandler();

    public void loginClicked() throws Exception {
        us=txtuid.getText();
        pw=txtpwd.getText();
        if(us.isEmpty() || pw.isEmpty()){
            lblmsg.setText("Please enter username and password");
        }
        else {
            this.login();}
    }

    public void login() throws SQLException, IOException {
        connection = handler.getConnection();
        String query1 = "select * from usertable where username=? and password=?";
        PreparedStatement pst;
        pst = connection.prepareStatement(query1);
        pst.setString(1, us);
        pst.setString(2, pw);
        rs = pst.executeQuery();
        if (rs.next()) {
            Stage primaryStage = new Stage();
            URL url = new File("src/fxml/Main.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            primaryStage.setTitle("Student Management System");
            primaryStage.setMaximized(true);
            primaryStage.setScene(new Scene(root, 1368, 710));
            primaryStage.getIcons().add(new Image("icons/Student.png"));
            primaryStage.show();
            btnlogin.getScene().getWindow().hide();
        } else {
            lblmsg.setText("Please enter valid username and password");
        }
        rs.close();
        pst.close();
        connection.close();
    }
}
