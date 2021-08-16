package main;

import Database.DBHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by chidgana on 03-04-18.
 */
public class Subjects implements Initializable {
    public ChoiceBox<String> choicecrs10 = new ChoiceBox<>();
    public ChoiceBox<String> choicecomb10 = new ChoiceBox<>();
    public ChoiceBox<String> choicesem10 = new ChoiceBox<>();
    public TextField txtsub1, txtsub2, txtsub3, txtsub4, txtsub5, txtsub6, txtsub7, txtsub8, txtcrsid;
    DBHandler handler = new DBHandler();
    Connection connection;
    ResultSet rs;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choicecrs10.getItems().add("BCA");
        choicecrs10.getItems().add("BCOM");
        choicecrs10.getItems().add("BSC");
        choicecrs10.getItems().add("BA");
        choicecomb10.getItems().add("-");
        choicecrs10.setOnAction(e -> {
            if (choicecrs10.getValue().equalsIgnoreCase("bca")) {
                choicecomb10.setValue("-");

            }
            if (choicecrs10.getValue().equalsIgnoreCase("bcom")) {
                choicecomb10.setValue("-");

            }
            if (choicecrs10.getValue().equalsIgnoreCase("bsc")) {
                choicecomb10.getItems().add("PCM");
                choicecomb10.getItems().add("CBZ");
            }
            if (choicecrs10.getValue().equalsIgnoreCase("ba")) {
                choicecomb10.setValue("-");

            }

        });
        choicesem10.getItems().addAll("1", "2", "3", "4", "5", "6");
    }

    public void subjectLoadClicked() {
        connection = handler.getConnection();
        String query = "Select * from subjects where Course=? and Combination=? and Semester=?";
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(query);
            pst.setString(1, choicecrs10.getValue());
            pst.setString(2, choicecomb10.getValue());
            pst.setString(3, choicesem10.getValue());
            rs = pst.executeQuery();
            while (rs.next()) {
                txtsub1.setText(rs.getString(4));
                txtsub2.setText(rs.getString(5));
                txtsub3.setText(rs.getString(6));
                txtsub4.setText(rs.getString(7));
                txtsub5.setText(rs.getString(8));
                txtsub6.setText(rs.getString(9));
                txtsub7.setText(rs.getString(10));
                txtsub8.setText(rs.getString(11));
                txtcrsid.setText(rs.getString(12));
            }
            rs.close();
            pst.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            alert.setHeaderText("Load Failed: " + e);
            alert.showAndWait();
        }


    }

    public void insertSubjectClicked() {
        String query = "insert into subjects values(?,?,?,?,?,?,?,?,?,?,?,?)";
        connection = handler.getConnection();

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, choicecrs10.getValue());
            preparedStatement.setString(2, choicecomb10.getValue());
            preparedStatement.setString(3, choicesem10.getValue());
            preparedStatement.setString(4, txtsub1.getText());
            preparedStatement.setString(5, txtsub2.getText());
            preparedStatement.setString(6, txtsub3.getText());
            preparedStatement.setString(7, txtsub4.getText());
            preparedStatement.setString(8, txtsub5.getText());
            preparedStatement.setString(9, txtsub6.getText());
            preparedStatement.setString(10, txtsub7.getText());
            preparedStatement.setString(11, txtsub8.getText());
            preparedStatement.setString(12, txtcrsid.getText());
            preparedStatement.execute();

            alert.setHeaderText("Subjects inserted Successful");
            alert.showAndWait();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            alert.setHeaderText("Subjects insertion failed: " + e);
            alert.showAndWait();
        }


    }

    public void updateSubjectClicked() {
        String query = "update subjects set sub1=?,sub2=?,sub3=?,sub4=?,sub5=?,sub6=?,sub7=?,sub8=? where Courseid='" + txtcrsid.getText() + "'";
        connection = handler.getConnection();
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(query);
            pst.setString(1, txtsub1.getText());
            pst.setString(2, txtsub2.getText());
            pst.setString(3, txtsub3.getText());
            pst.setString(4, txtsub4.getText());
            pst.setString(5, txtsub5.getText());
            pst.setString(6, txtsub6.getText());
            pst.setString(7, txtsub7.getText());
            pst.setString(8, txtsub8.getText());
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Subjects Updated Successful");
            alert.showAndWait();
            pst.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            alert.setHeaderText("Subjects Updating failed " + e);
            alert.showAndWait();
        }


    }
}
