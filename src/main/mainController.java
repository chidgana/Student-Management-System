package main;

import Database.DBHandler;
import Tables.*;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class mainController implements Initializable {
    //for students module
    public Button btnbrow1, btnbrow2, btnbrow3, btninsert, btnload;
    public TextField txtadno, txtname, txtfathername, txtmothername, txtage, txtdob;
    public TextField txtstudentph, txtparentph, txtemail, txtincome, txtcaste, txtcategory, txtinstitution, txtrollno, txtsem, txtcarri;
    public RadioButton radiomale, radiofemale;
    public TextArea txtaddcorresponding, txtaddpermanent;
    public TextField txtregno, txtrollno2, txtmonth, txtsemappeared;
    public TextField Isub1, Isub2, Isub3, Isub4, Isub5, Isub6, Isub7, Isub8;
    public TextField semsub1, semsub2, semsub3, semsub4, semsub5, semsub6, semsub7, semsub8;
    public TextField sempract1, sempract2, sempract3, sempract4;
    public TextField txtsender;
    public TextArea txtfmessage;
    public RadioButton radioparent, radiostudent, radattedance, radaexam;


    public TableView<StudentTable> tableView = new TableView<>();
    public TableColumn<StudentTable, String> admissionnumber;
    public TableColumn<StudentTable, String> registernumber;
    public TableColumn<StudentTable, String> name;
    public TableColumn<StudentTable, String> dateofbirth;
    public TableColumn<StudentTable, String> phonenumber;
    public TableColumn<StudentTable, String> email;
    public TableColumn<StudentTable, String> course;
    public TableColumn<StudentTable, String> semester;
    public ImageView newimage, imageView;
    public Image image1;
    public ChoiceBox<String> choicecrs = new ChoiceBox<>();
    public ChoiceBox<String> choicecomb = new ChoiceBox<>();
    public ChoiceBox<String> choicesem = new ChoiceBox<>();
    public TextField txtsearch, txtsearch1;
    //Attendnce starts from here

    public ChoiceBox<String> choicecrs1 = new ChoiceBox<>();
    public ChoiceBox<String> choicecomb1 = new ChoiceBox<>();
    public ChoiceBox<String> choicesem1 = new ChoiceBox<>();
    public ChoiceBox<String> choicecrs2 = new ChoiceBox<>();
    public ChoiceBox<String> choicecomb2 = new ChoiceBox<>();
    public ChoiceBox<String> choicesem2 = new ChoiceBox<>();
    public ChoiceBox<String> choicecrs3 = new ChoiceBox<>();
    public ChoiceBox<String> choicecomb3 = new ChoiceBox<>();
    public ChoiceBox<String> choicesem3 = new ChoiceBox<>();
    public JFXComboBox  choicecrs31 = new JFXComboBox();
    public JFXComboBox choicecomb31 = new JFXComboBox();
    public JFXComboBox choicesem31 = new JFXComboBox();
    public ChoiceBox<String> choicecrs32 = new ChoiceBox<>();
    public ChoiceBox<String> choicecomb32 = new ChoiceBox<>();
    public ChoiceBox<String> choicesem32 = new ChoiceBox<>();

    public TextField txtsub1, txtsub2, txtsub3, txtsub4, txtsub5, txtsub6, txtsub7, txtsub8, txtcrsid;
    public TableView<AttendanceTable> tableView1 = new TableView<AttendanceTable>();
    public TableColumn<AttendanceTable, String> Rollno;
    public TableColumn<AttendanceTable, String> name1;
    public TableColumn<AttendanceTable, Boolean> Subject1;
    public TableColumn<AttendanceTable, Boolean> Subject2;
    public TableColumn<AttendanceTable, Boolean> Subject3;
    public TableColumn<AttendanceTable, Boolean> Subject4;
    public TableColumn<AttendanceTable, Boolean> Subject5;
    public TableColumn<AttendanceTable, Boolean> Subject6;
    public TableColumn<AttendanceTable, Boolean> Subject7;
    public TableColumn<AttendanceTable, Boolean> Subject8;

    public TableView<AttendanceTablecal> tableView2 = new TableView<AttendanceTablecal>();
    ;
    public TableColumn<AttendanceTablecal, String> rollno;
    public TableColumn<AttendanceTablecal, String> name2;
    public TableColumn<AttendanceTablecal, Float> subject1;
    public TableColumn<AttendanceTablecal, Float> subject2;
    public TableColumn<AttendanceTablecal, Float> subject3;
    public TableColumn<AttendanceTablecal, Float> subject4;
    public TableColumn<AttendanceTablecal, Float> subject5;
    public TableColumn<AttendanceTablecal, Float> subject6;
    public TableColumn<AttendanceTablecal, Float> subject7;
    public TableColumn<AttendanceTablecal, Float> subject8;

    public TableView<ExamTable> tableview4 = new TableView<>();
    ;
    public TableColumn<ExamTable, String> name3;
    public TableColumn<ExamTable, String> regno;
    public TableColumn<ExamTable, String> semappeared;
    public TableColumn<ExamTable, String> year;
    public TableColumn<ExamTable, Integer> total;
    public TableColumn<ExamTable, Float> percentage;
    public TableColumn<ExamTable, String> grade;

    public TableView<ReportTable> tableview5 = new TableView<>();
    public TableColumn<ReportTable, String> name5;
    public TableColumn<ReportTable, String> rollno5;
    public TableColumn<ReportTable, String> regno5;
    public TableColumn<ReportTable, String> phone5;
    public TableColumn<ReportTable, String> email5;
    public TableColumn<ReportTable, String> course5;
    public TableColumn<ReportTable, String> comb5;
    public TableColumn<ReportTable, String> sem5;

    public TableView<Attendancesms> tableview7 = new TableView<Attendancesms>();
    ;
    public TableColumn<Attendancesms, String> rollno8;
    public TableColumn<Attendancesms, String> name4;
    public TableColumn<Attendancesms, Float> subj1;
    public TableColumn<Attendancesms, Float> subj2;
    public TableColumn<Attendancesms, Float> subj3;
    public TableColumn<Attendancesms, Float> subj4;
    public TableColumn<Attendancesms, Float> subj5;
    public TableColumn<Attendancesms, Float> subj6;
    public TableColumn<Attendancesms, Float> subj7;
    public TableColumn<Attendancesms, Float> subj8;
    public TableColumn<Attendancesms, Boolean> select;


    public String roll;
    public int sub1held, sub2held, sub3held, sub4held, sub5held, sub6held, sub7held, sub8held;
    public int sub1attended, sub2attended, sub3attended, sub4attended, sub5attended, sub6attended, sub7attended, sub8attended;
    public TextField txtuser, txtpass, txtna, txtg, txtid;
    public RadioButton radioexam, radioattendance;
    DBHandler handler = new DBHandler();
    sendSMS sms;
    ObservableList<StudentTable> data;
    Statement statement = null;
    FileInputStream fis = null;
    FileOutputStream fos = null;
    ObservableList<AttendanceTable> data2;
    ObservableList<AttendanceTablecal> data3;
    ObservableList<ExamTable> data4;
    ObservableList<ReportTable> data5;
    ObservableList<Attendancesms> data6;
    String gender;
    String file1, file2, file3;
    Connection connection;
    FileChooser fileChooser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        choicecrs.getItems().add("BCA");
        choicecrs.getItems().add("BCOM");
        choicecrs.getItems().add("BSC");
        choicecrs.getItems().add("BA");
        choicecomb.getItems().add("-");
        choicecrs.setOnAction(e -> {
            if (choicecrs.getValue().equalsIgnoreCase("bca")) {
                choicecomb.setValue("-");

            }
            if (choicecrs.getValue().equalsIgnoreCase("bcom")) {
                choicecomb.setValue("-");

            }
            if (choicecrs.getValue().equalsIgnoreCase("bsc")) {
                choicecomb.getItems().add("PCM");
                choicecomb.getItems().add("CBZ");
            }
            if (choicecrs.getValue().equalsIgnoreCase("ba")) {
                choicecomb.setValue("-");

            }

        });
        choicecrs1.getItems().add("BCA");
        choicecrs1.getItems().add("BCOM");
        choicecrs1.getItems().add("BSC");
        choicecrs1.getItems().add("BA");
        choicecomb1.getItems().add("-");
        choicecrs1.setOnAction(e -> {
            if (choicecrs1.getValue().equalsIgnoreCase("bca")) {
                choicecomb1.setValue("-");

            }
            if (choicecrs1.getValue().equalsIgnoreCase("bcom")) {
                choicecomb1.setValue("-");

            }
            if (choicecrs1.getValue().equalsIgnoreCase("bsc")) {
                choicecomb1.getItems().add("PCM");
                choicecomb1.getItems().add("CBZ");
            }
            if (choicecrs1.getValue().equalsIgnoreCase("ba")) {
                choicecomb1.setValue("-");

            }
        });
        choicesem.getItems().addAll("1", "2", "3", "4", "5", "6");
        choicesem1.getItems().addAll("1", "2", "3", "4", "5", "6");
        choicecrs2.getItems().add("BCA");
        choicecrs2.getItems().add("BCOM");
        choicecrs2.getItems().add("BSC");
        choicecrs2.getItems().add("BA");
        choicecomb2.getItems().add("-");
        choicecrs2.setOnAction(e -> {
            if (choicecrs2.getValue().equalsIgnoreCase("bca")) {
                choicecomb2.setValue("-");

            }
            if (choicecrs2.getValue().equalsIgnoreCase("bcom")) {
                choicecomb2.setValue("-");

            }
            if (choicecrs2.getValue().equalsIgnoreCase("bsc")) {
                choicecomb2.getItems().add("PCM");
                choicecomb2.getItems().add("CBZ");
            }
            if (choicecrs2.getValue().equalsIgnoreCase("ba")) {
                choicecomb2.setValue("-");

            }
        });
        choicesem2.getItems().addAll("1", "2", "3", "4", "5", "6");
        choicecrs3.getItems().add("BCA");
        choicecrs3.getItems().add("BCOM");
        choicecrs3.getItems().add("BSC");
        choicecrs3.getItems().add("BA");
        choicecomb3.getItems().add("-");
        choicecrs3.setOnAction(e -> {
            if (choicecrs3.getValue().equalsIgnoreCase("bca")) {
                choicecomb3.setValue("-");

            }
            if (choicecrs3.getValue().equalsIgnoreCase("bcom")) {
                choicecomb3.setValue("-");

            }
            if (choicecrs3.getValue().equalsIgnoreCase("bsc")) {
                choicecomb3.getItems().add("PCM");
                choicecomb3.getItems().add("CBZ");
            }
            if (choicecrs3.getValue().equalsIgnoreCase("ba")) {
                choicecomb3.setValue("-");

            }
        });
        choicesem3.getItems().addAll("1", "2", "3", "4", "5", "6");
        choicecrs31.getItems().add("BCA");
        choicecrs31.getItems().add("BCOM");
        choicecrs31.getItems().add("BSC");
        choicecrs31.getItems().add("BA");
        choicecomb31.getItems().add("-");
        choicecrs31.setOnAction(e -> {
            if (choicecrs31.getValue().equals("bca")) {
                choicecomb31.setValue("-");

            }
            if (choicecrs31.getValue().equals("bcom")) {
                choicecomb31.setValue("-");

            }
            if (choicecrs31.getValue().equals("bsc")) {
                choicecomb31.getItems().add("PCM");
                choicecomb31.getItems().add("CBZ");
            }
            if (choicecrs31.getValue().equals("ba")) {
                choicecomb31.setValue("-");

            }
        });
        choicesem31.getItems().addAll("1", "2", "3", "4", "5", "6");
        choicecrs32.getItems().add("BCA");
        choicecrs32.getItems().add("BCOM");
        choicecrs32.getItems().add("BSC");
        choicecrs32.getItems().add("BA");
        choicecomb32.getItems().add("-");
        choicecrs32.setOnAction(e -> {
            if (choicecrs32.getValue().equalsIgnoreCase("bca")) {
                choicecomb32.setValue("-");

            }
            if (choicecrs32.getValue().equalsIgnoreCase("bcom")) {
                choicecomb32.setValue("-");

            }
            if (choicecrs32.getValue().equalsIgnoreCase("bsc")) {
                choicecomb32.getItems().add("PCM");
                choicecomb32.getItems().add("CBZ");
            }
            if (choicecrs32.getValue().equalsIgnoreCase("ba")) {
                choicecomb32.setValue("-");

            }
        });
        choicesem32.getItems().addAll("1", "2", "3", "4", "5", "6");

    }

    public void adduserclicked() throws IOException {
        Stage stage = new Stage();
        URL url = new File("src/fxml/user.fxml").toURI().toURL();
        Parent xyz = FXMLLoader.load(url);
        stage.setTitle(" Add User");
        stage.setScene(new Scene(xyz, 800, 700));
        stage.getIcons().add(new Image("icons/Student.png"));
        stage.showAndWait();

    }

    public void addUserClicked() throws SQLException {
        String query = "insert into usertable values(?,?,?,?,?)";
        connection = handler.getConnection();
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, txtid.getText());
        pst.setString(2, txtna.getText());
        pst.setString(3, txtg.getText());
        pst.setString(4, txtuser.getText());
        pst.setString(5, txtpass.getText());
        pst.execute();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("New User Created");
        alert.showAndWait();
        pst.close();
        connection.close();


    }

    //to search based on name,course,regno etc.
    public void searchbtnlicked() {
        FilteredList<StudentTable> filteredata = new FilteredList<>(data, e -> true);
        txtsearch.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredata.setPredicate((Predicate<? super StudentTable>) StudentTable -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowercasefilter = newValue.toLowerCase();
                if (StudentTable.getAdmissionnumber().contains(newValue)) {
                    return true;
                } else if (StudentTable.getName().toLowerCase().contains(newValue)) {
                    return true;
                } else if (StudentTable.getRegisternumber().toLowerCase().contains(newValue)) {
                    return true;
                } else if (StudentTable.getCourse().toLowerCase().contains(newValue)) {
                    return true;

                } else if (StudentTable.getSemester().toLowerCase().contains(newValue)) {
                    return true;
                }
                return false;

            });
            SortedList<StudentTable> sortedList = new SortedList<StudentTable>(filteredata);
            sortedList.comparatorProperty().bind(tableView.comparatorProperty());
            tableView.setItems(sortedList);
        }));


    }

    //create new student
    public void insertnewstudent() throws Exception {
        //get connection to the database
        connection = handler.getConnection();
        String query1, query2;
        query1 = "INSERT INTO  studentpersonal  VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        //inserting into table student personnel
        PreparedStatement pst = connection.prepareStatement(query1);
        pst.setString(1, txtadno.getText());
        pst.setString(2, txtname.getText());
        pst.setString(3, txtfathername.getText());
        pst.setString(4, txtmothername.getText());
        if (radiomale.isSelected()) gender = "Male";
        if (radiofemale.isSelected()) gender = "Female";
        pst.setString(5, gender);
        pst.setString(6, txtdob.getText());//to convert date into this format dd/MM/yyyy
        pst.setString(7, txtage.getText());
        pst.setString(8, txtaddcorresponding.getText());
        System.out.print(txtmothername.getText());
        pst.setString(9, txtaddpermanent.getText());
        pst.setString(10, txtstudentph.getText());
        pst.setString(11, txtparentph.getText());
        pst.setString(12, txtemail.getText());
        pst.setString(13, txtincome.getText());
        pst.setString(14, txtcaste.getText());
        pst.setString(15, txtcategory.getText());
        pst.setBytes(16, readFile(file1));
        pst.setBytes(17, readFile(file2));
        pst.setBytes(18, readFile(file3));
        pst.setString(19, txtinstitution.getText());
        file1 = null;
        file2 = null;
        file3 = null;
        pst.execute();
        pst.close();
        connection.close();
        //end of inserting data into student personnel table

        connection = handler.getConnection();
        // begin of inserting data onto studentacademics table
        query2 = "INSERT INTO studentacademics VALUES(?,?,?,?,?,?)";
        PreparedStatement pst2 = connection.prepareStatement(query2);
        pst2.setString(1, txtrollno.getText());
        pst2.setString(2, txtadno.getText());
        pst2.setString(3, choicecrs.getValue());
        pst2.setString(4, choicecomb.getValue());
        pst2.setString(5, choicesem.getValue());
        pst2.setString(6, txtcarri.getText());
        pst2.execute();
        pst2.close();

        connection.close();
        // end of inserting data onto studentacademics table

        connection = handler.getConnection();
        String query3 = "Insert into attendance values(?,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)";
        PreparedStatement pst3 = connection.prepareStatement(query3);
        pst3.setString(1, txtrollno.getText());
        pst3.execute();
        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Student Management System");
        alert.setContentText("New student inserted Successful");
        alert.showAndWait();
        pst3.close();
        connection.close();
//        loadbtnclk();
    }

    //update student
    public void updatestudent() throws Exception {
        //get connection to the database
        connection = handler.getConnection();
        String query1, query2;
        query1 = "update  studentpersonal set admissionnum=?,name=?,fatname=?" +
                ",motname=?,gender=?,dob=?,age=?,addressper=?,addresscor=?," +
                "parentphnum=?,studentphnum=?,email=?,annualincome=?,caste=?" +
                ",category=?,previousinst=? Where admissionnum='" + txtadno.getText() + "'";
        //updating  into table student personnel
        PreparedStatement pst1 = connection.prepareStatement(query1);
        pst1.setString(1, txtadno.getText());
        pst1.setString(2, txtname.getText());
        pst1.setString(3, txtfathername.getText());
        pst1.setString(4, txtmothername.getText());
        if (radiomale.isSelected()) gender = "Male";
        if (radiofemale.isSelected()) gender = "Female";
        pst1.setString(5, gender);
        pst1.setString(6, txtdob.getText());
        pst1.setString(7, txtage.getText());
        pst1.setString(8, txtaddcorresponding.getText());
        System.out.print(txtmothername.getText());
        pst1.setString(9, txtaddpermanent.getText());
        pst1.setString(10, txtstudentph.getText());
        pst1.setString(11, txtparentph.getText());
        pst1.setString(12, txtemail.getText());
        pst1.setString(13, txtincome.getText());
        pst1.setString(14, txtcaste.getText());
        pst1.setString(15, txtcategory.getText());
        pst1.setString(16, txtinstitution.getText());
        pst1.executeUpdate();
        pst1.close();
        connection.close();
        //end of updating data into student personnel table

        connection = handler.getConnection();
        // begin of updating data onto studentacademics table
        query2 = "update studentacademics set Rollno=?,admissionnum=?,course=?,combination=?,semester=?,extracurricular=? Where admissionnum='" + txtadno.getText() + "'";
        PreparedStatement pst2 = connection.prepareStatement(query2);
        pst2.setString(1, txtrollno.getText());
        pst2.setString(2, txtadno.getText());
        pst2.setString(3, choicecrs.getValue());
        pst2.setString(4, choicecomb.getValue());
        pst2.setString(5, choicesem.getValue());
        pst2.setString(6, txtcarri.getText());
        pst2.execute();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Student Updation Successful");
        alert.showAndWait();
        pst2.close();
        connection.close();
//         end of inserting data onto studentacademics table

//        loadbtnclk();
    }

    //update student related photos
    public void photoupdateclicked() throws IOException, SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Do you want to update Student Photo");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            connection = handler.getConnection();
            String query = "update studentpersonal set photo=? where admissionnum='" + txtadno.getText() + "'";
            browsebtnclicked3();
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setBytes(1, readFile(file3));
            pst.execute();
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Updation Sucssesfull");
            alert.showAndWait();
            pst.close();
            connection.close();
        }
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Do you want to update SSLC Markscard");
        Optional<ButtonType> action2 = alert.showAndWait();
        if (action2.get() == ButtonType.OK) {
            connection = handler.getConnection();
            String query = "update studentpersonal set sslcmarks=? where admissionnum='" + txtadno.getText() + "'";
            browsebtnclicked1();
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setBytes(1, readFile(file1));
            pst.execute();
            alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setHeaderText("Updation Sucssesfull");
            alert2.showAndWait();
            pst.close();
            connection.close();
        }
        Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Do you want to update PUC Markscard");
        Optional<ButtonType> action3 = alert.showAndWait();
        if (action3.get() == ButtonType.OK) {
            connection = handler.getConnection();
            String query = "update studentpersonal set pucmarks=? where admissionnum='" + txtadno.getText() + "'";
            browsebtnclicked2();
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setBytes(1, readFile(file2));
            pst.execute();
            alert3 = new Alert(Alert.AlertType.INFORMATION);
            alert3.setHeaderText("Updation Sucssesfull");
            alert3.showAndWait();
            pst.close();
            connection.close();
        }
    }

    //delete student
    public void deletestudent() throws SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure you want to delete: " + txtname.getText());
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            connection = handler.getConnection();
            String query = "delete from attendance where Rollno=?";
            PreparedStatement pst1 = connection.prepareStatement(query);
            pst1.setString(1, txtrollno.getText());
            pst1.execute();
            pst1.close();
            connection.close();

            connection = handler.getConnection();
            String query1 = "delete from studentacademics where admissionnum=?";
            PreparedStatement pst = connection.prepareStatement(query1);
            pst.setString(1, txtadno.getText());
            pst.execute();
            pst.close();
            connection.close();

            connection = handler.getConnection();
            String query2 = "delete from Studentpersonal where admissionnum=?";
            PreparedStatement pst2 = connection.prepareStatement(query2);
            pst2.setString(1, txtadno.getText());
            pst2.execute();
            pst2.close();
            connection.close();
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setContentText(txtname.getText() + "Deleted Sucsessfully ");
            clearfieldclicked();
        }
    }

    //browse sslc markscard
    public String browsebtnclicked1() {
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png")
        );
        file1 = fileChooser.showOpenDialog(null).toString();
        return file1;

    }

    //browse puc markscard
    public String browsebtnclicked2() {
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png")
        );
        file2 = fileChooser.showOpenDialog(null).toString();
        return file2;
    }

    //browse Student Photo
    public String browsebtnclicked3() {
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png")
        );
        file3 = fileChooser.showOpenDialog(null).toString();
        return file3;

    }

    //loading data from database onto table view
    public void loadbtnclk() throws SQLException {
        admissionnumber.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("admissionnumber"));
        registernumber.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("registernumber"));
        name.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("name"));
        dateofbirth.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("dateofbirth"));
        phonenumber.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("phonenumber"));
        email.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("email"));
        course.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("course"));
        semester.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("semester"));
        data = FXCollections.observableArrayList();
        connection = handler.getConnection();
        String query = "select studentpersonal.admissionnum,studentacademics.Rollno,studentpersonal.name,studentpersonal.dob,studentpersonal.studentphnum,studentpersonal.email,studentacademics.course,studentacademics.semester FROM studentpersonal,studentacademics Where studentpersonal.admissionnum=studentacademics.admissionnum";
        ResultSet rs;
        PreparedStatement pst = connection.prepareStatement(query);
        rs = pst.executeQuery();
        while (rs.next()) {
            data.add(new StudentTable(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8)
            ));
        }
        tableView.setItems(data);
        rs.close();
        pst.close();
        connection.close();
    }

    //accessing data from database based on admission number of the student and appending them onto the text fields
    public void tableclicked() throws SQLException {

        try {
            connection = handler.getConnection();
            StudentTable studentTable = (StudentTable) tableView.getSelectionModel().getSelectedItem();
            String query = "Select studentpersonal.*,studentacademics.* From studentpersonal,studentacademics Where studentpersonal.admissionnum=studentacademics.admissionnum and studentpersonal.admissionnum=?";
            PreparedStatement pst3 = connection.prepareStatement(query);
            TablePosition pos = tableView.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();

            // Item here is the studentTable view type:
            StudentTable item = tableView.getItems().get(row);

            TableColumn col = pos.getTableColumn();

            // this gives the value in the selected cell:
            String data = (String) col.getCellObservableValue(item).getValue();
            pst3.setString(1, data);
            ResultSet rs;
            rs = pst3.executeQuery();

            while (rs.next()) {
                txtadno.setText(rs.getString(1));
                txtrollno.setText(rs.getString(20));
                txtname.setText(rs.getString(2));
                txtfathername.setText(rs.getString(3));
                txtmothername.setText(rs.getString(4));
                String gender = rs.getString(5);
                if (gender.equalsIgnoreCase("male")) ;
                {
                    radiomale.setSelected(true);
                }
                if (gender.equalsIgnoreCase("female")) {
                    radiofemale.setSelected(true);
                }
                txtdob.setText(rs.getString(6));
                txtage.setText(rs.getString(7));

                txtaddpermanent.setText(rs.getString(8));
                txtaddcorresponding.setText(rs.getString(9));
                txtstudentph.setText(rs.getString(10));
                txtparentph.setText(rs.getString(11));
                txtemail.setText(rs.getString(12));
                txtincome.setText(rs.getString(13));
                txtcaste.setText(rs.getString(14));
                txtcategory.setText(rs.getString(15));

                File file = new File("G:\\projects\\Student Management System\\src\\Temp\\newfile.png");
                fos = new FileOutputStream(file);
                InputStream input = rs.getBinaryStream(16);
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    fos.write(buffer);
                }
                fos.close();

                file = new File("G:\\projects\\Student Management System\\src\\Temp\\newfile2.png");
                fos = new FileOutputStream(file);
                input = rs.getBinaryStream(17);
                buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    fos.write(buffer);
                }
                fos.close();


                file = new File("G:\\projects\\Student Management System\\src\\Temp\\newfile3.png");
                fos = new FileOutputStream(file);
                input = rs.getBinaryStream(18);
                buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    fos.write(buffer);
                }
                fos.close();
                newimage.setImage(new Image("file:G:\\projects\\Student Management System\\src\\Temp\\newfile3.png"));


                txtinstitution.setText(rs.getString(19));
                choicecrs.setValue(rs.getString(22));
                choicecomb.setValue(rs.getString(23));
                choicesem.setValue(rs.getString(24));
                txtcarri.setText(rs.getString(25));
            }
            rs.close();
            pst3.closeOnCompletion();

        } catch (SQLException r) {
            System.err.print(r);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        connection.close();

    }

    //to open consel inorder to open sslc and puc marks card
    public void viewbtnclicked() throws Exception {
        Stage stage = new Stage();
        URL url = new File("src/fxml/viewphoto.fxml").toURI().toURL();
        Parent xyz = FXMLLoader.load(url);
        stage.setTitle("Marks card");
        stage.setScene(new Scene(xyz, 600, 700));
        stage.getIcons().add(new Image("icons/Student.png"));
        stage.showAndWait();
    }

    public void addSubjectClicked() throws IOException {
        Stage stage = new Stage();
        URL url = new File("src/fxml/subjects.fxml").toURI().toURL();
        Parent xyz = FXMLLoader.load(url);
        stage.setTitle("Add Subjects");
        stage.setScene(new Scene(xyz, 800, 700));
        stage.getIcons().add(new Image("icons/Student.png"));
        stage.showAndWait();

    }


    //to load SSlc and puc marks card
    public void load1clicked() {
        imageView.setImage(new Image("file:src/Temp/newfile.png"));
    }

    public void load2clicked() {
        imageView.setImage(new Image("file:src/Temp/newfile2.png"));
    }

    public void load3clicked() {
        imageView.setImage(new Image("file:src/Temp/newfile3.png"));
    }

    //convert the image to bytes inorder to store image into database
    private byte[] readFile(String file) {
        ByteArrayOutputStream bos = null;
        try {
            File f = new File(file);
            FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            bos = new ByteArrayOutputStream();
            for (int len; (len = fis.read(buffer)) != -1; ) {
                bos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e2) {
            System.err.println(e2.getMessage());
        }
        return bos != null ? bos.toByteArray() : null;
    }

    //to clear fields
    public void clearfieldclicked() {
        txtadno.setText("");
        txtrollno.setText("");
        txtname.setText("");
        txtfathername.setText("");
        txtmothername.setText("");
        txtage.setText("");
        txtdob.setText("");
        txtaddpermanent.setText("");
        txtaddcorresponding.setText("");
        txtstudentph.setText("");
        txtparentph.setText("");
        txtemail.setText("");
        txtincome.setText("");
        txtcaste.setText("");
        txtcategory.setText("");
        txtinstitution.setText("");
        txtcarri.setText("");
//        choicecomb.setValue("");
//        choicecrs.getItems().replaceAll();
//        choicesem.setValue("");
        txtrollno.setText("");
        newimage.setImage(image1);

//        if (choicecrs.getValue().equalsIgnoreCase("bca")) {
//            choicecomb.setValue("-");
//
//        }
//        if (choicecrs.getValue().equalsIgnoreCase("bcom")) {
//            choicecomb.setValue("-");
//
//        }
//        if (choicecrs.getValue().equalsIgnoreCase("bsc")) {
//            choicecomb.getItems().add("PCM");
//            choicecomb.getItems().add("CBZ");
//        }
//        if (choicecrs.getValue().equalsIgnoreCase("ba")) {
//            choicecomb.setValue("-");
//
//        }
    }

    //to logout from application
    public void logoutclicked() throws Exception {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Are you sure you want to logout");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            btninsert.getScene().getWindow().hide();
            Stage primaryStage = new Stage();
            URL url = new File("src/fxml/Login.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            primaryStage.setTitle("Student Management System");
            primaryStage.setScene(new Scene(root, 400, 400));
            primaryStage.getIcons().add(new Image("icons/Student.png"));
            primaryStage.show();
        }


    }

    //to exit from application
    public void exitbuttonclicked() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Are you sure you want to exit");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            Platform.exit();
        }
    }


    public void atdloadclicked() throws Exception {
        String query = "select studentpersonal.name,studentacademics.Rollno,studentacademics.course,studentacademics.combination,studentacademics.semester from studentpersonal,studentacademics where studentacademics.course=? and studentacademics.combination=? and studentacademics.semester=? and studentpersonal.admissionnum=studentacademics.admissionnum";
        try {
            data2 = FXCollections.observableArrayList();
            connection = handler.getConnection();
            PreparedStatement pst4 = connection.prepareStatement(query);
            pst4.setString(1, choicecrs1.getValue());
            pst4.setString(2, choicecomb1.getValue());
            pst4.setString(3, choicesem1.getValue());
            ResultSet resultSet;
            resultSet = pst4.executeQuery();
            while (resultSet.next()) {
                data2.add(new AttendanceTable(
                        resultSet.getString(2),
                        resultSet.getString(1),
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true));
            }
            resultSet.close();
            pst4.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        Rollno.setCellValueFactory(new PropertyValueFactory<AttendanceTable, String>("Rollno"));
        name1.setCellValueFactory(new PropertyValueFactory<AttendanceTable, String>("name1"));
        Subject1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<AttendanceTable, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<AttendanceTable, Boolean> param) {
                AttendanceTable Subject1 = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(Subject1.isSubject1());
                booleanProp.addListener(new ChangeListener<Boolean>() {

                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                                        Boolean newValue) {
                        Subject1.setSubject1(newValue);
                    }
                });
                return booleanProp;
            }
        });
        Subject1.setCellFactory(tc -> new CheckBoxTableCell<>());

        Subject2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<AttendanceTable, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<AttendanceTable, Boolean> param) {
                AttendanceTable Subject2 = param.getValue();

                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(Subject2.isSubject2());
                booleanProp.addListener(new ChangeListener<Boolean>() {

                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                                        Boolean newValue) {
                        Subject2.setSubject2(newValue);
                    }
                });
                return booleanProp;
            }

        });
        Subject2.setCellFactory(tc -> new CheckBoxTableCell<>());

        Subject3.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<AttendanceTable, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<AttendanceTable, Boolean> param) {
                AttendanceTable Subject3 = param.getValue();

                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(Subject3.isSubject3());
                booleanProp.addListener(new ChangeListener<Boolean>() {

                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                                        Boolean newValue) {
                        Subject3.setSubject3(newValue);
                    }
                });
                return booleanProp;
            }

        });
        Subject3.setCellFactory(tc -> new CheckBoxTableCell<>());

        Subject4.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<AttendanceTable, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<AttendanceTable, Boolean> param) {
                AttendanceTable Subject4 = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(Subject4.isSubject4());
                booleanProp.addListener(new ChangeListener<Boolean>() {

                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                                        Boolean newValue) {
                        Subject4.setSubject4(newValue);
                    }
                });
                return booleanProp;
            }
        });
        Subject4.setCellFactory(tc -> new CheckBoxTableCell<>());

        Subject5.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<AttendanceTable, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<AttendanceTable, Boolean> param) {
                AttendanceTable Subject5 = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(Subject5.isSubject5());
                booleanProp.addListener(new ChangeListener<Boolean>() {

                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                                        Boolean newValue) {
                        Subject5.setSubject5(newValue);
                    }
                });
                return booleanProp;
            }

        });
        Subject5.setCellFactory(tc -> new CheckBoxTableCell<>());

        Subject6.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<AttendanceTable, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<AttendanceTable, Boolean> param) {
                AttendanceTable Subject6 = param.getValue();

                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(Subject6.isSubject6());
                booleanProp.addListener(new ChangeListener<Boolean>() {

                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                                        Boolean newValue) {
                        Subject6.setSubject6(newValue);
                    }
                });
                return booleanProp;
            }

        });
        Subject6.setCellFactory(tc -> new CheckBoxTableCell<>());

        Subject7.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<AttendanceTable, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<AttendanceTable, Boolean> param) {
                AttendanceTable Subject7 = param.getValue();

                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(Subject7.isSubject7());
                booleanProp.addListener(new ChangeListener<Boolean>() {

                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                                        Boolean newValue) {
                        Subject7.setSubject7(newValue);
                    }
                });
                return booleanProp;
            }
        });
        Subject7.setCellFactory(tc -> new CheckBoxTableCell<>());

        Subject8.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<AttendanceTable, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<AttendanceTable, Boolean> param) {
                AttendanceTable Subject8 = param.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(Subject8.isSubject8());
                booleanProp.addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                                        Boolean newValue) {
                        Subject8.setSubject8(newValue);
//                        System.out.print(newValue);
                    }
                });
                return booleanProp;
            }
        });
        Subject8.setCellFactory(tc -> new CheckBoxTableCell<>());


        tableView1.setItems(data2);
        tableView1.setEditable(true);
        connection=handler.getConnection();
        String q="select * from subjects where Course=? and Combination=? and Semester=?";
        PreparedStatement preparedStatement=connection.prepareStatement(q);
        preparedStatement.setString(1,choicecrs1.getValue());
        preparedStatement.setString(2,choicecomb1.getValue());
        preparedStatement.setString(3,choicesem1.getValue());
        ResultSet rs=preparedStatement.executeQuery();
        while(rs.next()){
            Subject1.setText(rs.getString(4));
            Subject2.setText(rs.getString(5));
            Subject3.setText(rs.getString(6));
            Subject4.setText(rs.getString(7));
            Subject5.setText(rs.getString(8));
            Subject6.setText(rs.getString(9));
            Subject7.setText(rs.getString(10));
            Subject8.setText(rs.getString(11));
        }
        rs.close();
        preparedStatement.close();
        connection.close();

    }

    public void updateattendance() throws SQLException {
        for (AttendanceTable bean : data2) {
            String query1 = "Select * From attendance where Rollno='" + bean.getRollno() + "'";
            connection = handler.getConnection();
            PreparedStatement pst1 = connection.prepareStatement(query1);
            ResultSet cs = pst1.executeQuery();
            while (cs.next()) {
                roll = cs.getString(1);
                sub1held = cs.getInt(2);
                sub2held = cs.getInt(3);
                sub3held = cs.getInt(4);
                sub4held = cs.getInt(5);
                sub5held = cs.getInt(6);
                sub6held = cs.getInt(7);
                sub7held = cs.getInt(8);
                sub8held = cs.getInt(9);
                sub1attended = cs.getInt(10);
                sub2attended = cs.getInt(11);
                sub3attended = cs.getInt(12);
                sub4attended = cs.getInt(13);
                sub5attended = cs.getInt(14);
                sub6attended = cs.getInt(15);
                sub7attended = cs.getInt(16);
                sub8attended = cs.getInt(17);
            }
            cs.close();
            pst1.close();
            connection.close();

            connection = handler.getConnection();
            String query6 = "Update attendance set s1classheld=?,s2classheld=?,s3classheld=?,s4classheld=?,s5classheld=?,s6classheld=?,s7classheld=?,s8classheld=?,s1classattendend=?,s2classattendend=?,s3classattendend=?,s4classattendend=?,s5classattendend=?,s6classattendend=?,s7classattendend=?,s8classattendend=? where Rollno='" + bean.getRollno() + "'";
            PreparedStatement pst = connection.prepareStatement(query6);
            if (bean.isSubject1()) {
                pst.setInt(1, sub1held + 1);
                pst.setInt(9, sub1attended + 1);
            } else {
                pst.setInt(1, sub1held + 1);
                pst.setInt(9, sub1attended);
            }

            if (bean.isSubject2()) {
                pst.setInt(2, sub2held + 1);
                pst.setInt(10, sub2attended + 1);
            } else {
                pst.setInt(2, sub2held + 1);
                pst.setInt(10, sub2attended);
            }

            if (bean.isSubject3()) {
                pst.setInt(3, sub3held + 1);
                pst.setInt(11, sub3attended + 1);
            } else {
                pst.setInt(3, sub3held + 1);
                pst.setInt(11, sub3attended);
            }

            if (bean.isSubject4()) {
                pst.setInt(4, sub4held + 1);
                pst.setInt(12, sub4attended + 1);
            } else {
                pst.setInt(4, sub4held + 1);
                pst.setInt(12, sub4attended);
            }

            if (bean.isSubject5()) {
                pst.setInt(5, sub5held + 1);
                pst.setInt(13, sub5attended + 1);
            } else {
                pst.setInt(5, sub5held + 1);
                pst.setInt(13, sub5attended);
            }

            if (bean.isSubject6()) {
                pst.setInt(6, sub6held + 1);
                pst.setInt(14, sub6attended + 1);
            } else {
                pst.setInt(6, sub6held + 1);
                pst.setInt(14, sub6attended);
            }

            if (bean.isSubject7()) {
                pst.setInt(7, sub7held + 1);
                pst.setInt(15, sub7attended + 1);
            } else {
                pst.setInt(7, sub7held + 1);
                pst.setInt(15, sub7attended);
            }

            if (bean.isSubject8()) {
                pst.setInt(8, sub8held + 1);
                pst.setInt(16, sub8attended + 1);
            } else {
                pst.setInt(8, sub8held + 1);
                pst.setInt(16, sub8attended);
            }
            pst.execute();
            pst.close();
            connection.close();
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Updation Succsessful");
        alert.showAndWait();
    }

    public void atdcaculateclicked() throws IOException, SQLException {
        Stage primaryStage = new Stage();
        URL url = new File("src/fxml/Attedance.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("Attendance Details");
        primaryStage.setScene(new Scene(root, 1300, 600));
        primaryStage.show();
    }

    public void atdloadclicked2() throws SQLException {
        data3 = FXCollections.observableArrayList();
        connection = handler.getConnection();
        String Query = "select studentpersonal.name, studentacademics.Rollno,studentacademics.course,studentacademics.combination,studentacademics.semester, attendance.s1classheld,attendance.s2classheld,attendance.s3classheld,attendance.s4classheld,attendance.s5classheld,attendance.s6classheld,attendance.s7classheld,attendance.s8classheld,attendance.s1classattendend,attendance.s2classattendend,attendance.s3classattendend,attendance.s4classattendend,attendance.s5classattendend,attendance.s6classattendend,attendance.s7classattendend,attendance.s8classattendend from studentpersonal,attendance,studentacademics where studentacademics.course=? and studentacademics.combination=? and studentacademics.semester=? and attendance.Rollno=studentacademics.Rollno and studentpersonal.admissionnum=studentacademics.admissionnum";
        PreparedStatement preparedStatement = connection.prepareStatement(Query);
        preparedStatement.setString(1, choicecrs2.getValue());
        preparedStatement.setString(2, choicecomb2.getValue());
        preparedStatement.setString(3, choicesem2.getValue());

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            float sub1ch = Integer.parseInt(rs.getString(6)), sub1ca = Integer.parseInt(rs.getString(14));
            float sub2ch = Integer.parseInt(rs.getString(7)), sub2ca = Integer.parseInt(rs.getString(15));
            float sub3ch = Integer.parseInt(rs.getString(8)), sub3ca = Integer.parseInt(rs.getString(16));
            float sub4ch = Integer.parseInt(rs.getString(9)), sub4ca = Integer.parseInt(rs.getString(17));
            float sub5ch = Integer.parseInt(rs.getString(10)), sub5ca = Integer.parseInt(rs.getString(18));
            float sub6ch = Integer.parseInt(rs.getString(11)), sub6ca = Integer.parseInt(rs.getString(19));
            float sub7ch = Integer.parseInt(rs.getString(12)), sub7ca = Integer.parseInt(rs.getString(20));
            float sub8ch = Integer.parseInt(rs.getString(13)), sub8ca = Integer.parseInt(rs.getString(21));

            System.out.println(((float) (sub1ca / sub1ch * 100)));
            data3.add(new AttendanceTablecal(rs.getString(1),
                    rs.getString(2),
                    ((float) (sub1ca / sub1ch * 100)),
                    ((float) (sub2ca / sub2ch * 100)),
                    ((float) (sub3ca / sub3ch * 100)),
                    ((float) (sub4ca / sub4ch * 100)),
                    ((float) (sub5ca / sub5ch * 100)),
                    ((float) (sub6ca / sub6ch * 100)),
                    ((float) (sub7ca / sub7ch * 100)),
                    ((float) (sub8ca / sub8ch * 100))
            ));
        }
        rollno.setCellValueFactory(new PropertyValueFactory<AttendanceTablecal, String>("rollno"));
        name2.setCellValueFactory(new PropertyValueFactory<AttendanceTablecal, String>("name2"));
        subject1.setCellValueFactory(new PropertyValueFactory<AttendanceTablecal, Float>("subject1"));
        subject2.setCellValueFactory(new PropertyValueFactory<AttendanceTablecal, Float>("subject2"));
        subject3.setCellValueFactory(new PropertyValueFactory<AttendanceTablecal, Float>("subject3"));
        subject4.setCellValueFactory(new PropertyValueFactory<AttendanceTablecal, Float>("subject4"));
        subject5.setCellValueFactory(new PropertyValueFactory<AttendanceTablecal, Float>("subject5"));
        subject6.setCellValueFactory(new PropertyValueFactory<AttendanceTablecal, Float>("subject6"));
        subject7.setCellValueFactory(new PropertyValueFactory<AttendanceTablecal, Float>("subject7"));
        subject8.setCellValueFactory(new PropertyValueFactory<AttendanceTablecal, Float>("subject8"));

//        }
        tableView2.setItems(data3);
        tableView2.setEditable(true);
        rs.close();
        preparedStatement.close();
        connection.close();

    }


    //Exam Moudule starts from Here

    public void examInsertClicked() throws SQLException {
        String query = "insert into studentexam values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        connection = handler.getConnection();
        int a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t;
        float percentage;
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, txtregno.getText());
        pst.setString(2, txtrollno2.getText());
        pst.setString(3, txtsemappeared.getText());
        pst.setString(4, txtmonth.getText());
        pst.setInt(5, a = Integer.parseInt(semsub1.getText()));
        pst.setInt(6, b = Integer.parseInt(semsub2.getText()));
        pst.setInt(7, c = Integer.parseInt(semsub3.getText()));
        pst.setInt(8, d = Integer.parseInt(semsub4.getText()));
        pst.setInt(9, e = Integer.parseInt(semsub5.getText()));
        pst.setInt(10, f = Integer.parseInt(semsub6.getText()));
        pst.setInt(11, g = Integer.parseInt(semsub7.getText()));
        pst.setInt(12, h = Integer.parseInt(semsub8.getText()));
        pst.setInt(13, i = Integer.parseInt(Isub1.getText()));
        pst.setInt(14, j = Integer.parseInt(Isub2.getText()));
        pst.setInt(15, k = Integer.parseInt(Isub3.getText()));
        pst.setInt(16, l = Integer.parseInt(Isub4.getText()));
        pst.setInt(17, m = Integer.parseInt(Isub5.getText()));
        pst.setInt(18, n = Integer.parseInt(Isub6.getText()));
        pst.setInt(19, o = Integer.parseInt(Isub7.getText()));
        pst.setInt(20, p = Integer.parseInt(Isub8.getText()));
        pst.setInt(21, q = Integer.parseInt(sempract1.getText()));
        pst.setInt(22, r = Integer.parseInt(sempract2.getText()));
        pst.setInt(23, s = Integer.parseInt(sempract3.getText()));
        pst.setInt(24, t = Integer.parseInt(sempract4.getText()));
        int total = a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p + q + r + s + t;
        pst.setInt(25, total);
        percentage = (float) total / (float) 1200 * (float) 100;
        pst.setFloat(26, percentage);
        String grade = "";
        if (percentage >= 85) grade = "Distinction";
        if (percentage >= 65 && percentage < 85) grade = "First Class";
        if (percentage >= 50 && percentage < 65) grade = "Second Class";
        if (percentage >= 40 && percentage < 50) grade = "Pass";
        if (percentage < 40) grade = "Fail";
        pst.setString(27, grade);
        pst.execute();
        pst.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Student Added sucssfully");
        alert.showAndWait();
        connection.close();
    }

    public void examUpdateClicked() throws SQLException {
        String query = "update studentexam set regno=?,Rollno=?,semappeard=?,monthyear=?," +
                "MarkM1Th=?,MarkM2Th=?,MarkM3Th=?,MarkM4Th=?,MarkM5Th=?,MarkM6Th=?,MarkM7Th=?,MarkM8Th=?," +
                "MarkM1IA=?,MarkM2IA=?,MarkM3IA=?,MarkM4IA=?,MarkM5IA=?,MarkM6IA=?,MarkM7IA=?,MarkM8IA=?," +
                "MarkPractical1=?,MarkPractical2=?,MarkPractical3=?,MarkPractical4=?," +
                "total=?,percentage=?,Grade=? Where regno='" + txtregno.getText() + "'";
        connection = handler.getConnection();
        int a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t;
        float percentage;
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, txtregno.getText());
        pst.setString(2, txtrollno2.getText());
        pst.setString(3, txtsemappeared.getText());
        pst.setString(4, txtmonth.getText());
        pst.setInt(5, a = Integer.parseInt(semsub1.getText()));
        pst.setInt(6, b = Integer.parseInt(semsub2.getText()));
        pst.setInt(7, c = Integer.parseInt(semsub3.getText()));
        pst.setInt(8, d = Integer.parseInt(semsub4.getText()));
        pst.setInt(9, e = Integer.parseInt(semsub5.getText()));
        pst.setInt(10, f = Integer.parseInt(semsub6.getText()));
        pst.setInt(11, g = Integer.parseInt(semsub7.getText()));
        pst.setInt(12, h = Integer.parseInt(semsub8.getText()));
        pst.setInt(13, i = Integer.parseInt(Isub1.getText()));
        pst.setInt(14, j = Integer.parseInt(Isub2.getText()));
        pst.setInt(15, k = Integer.parseInt(Isub3.getText()));
        pst.setInt(16, l = Integer.parseInt(Isub4.getText()));
        pst.setInt(17, m = Integer.parseInt(Isub5.getText()));
        pst.setInt(18, n = Integer.parseInt(Isub6.getText()));
        pst.setInt(19, o = Integer.parseInt(Isub7.getText()));
        pst.setInt(20, p = Integer.parseInt(Isub8.getText()));
        pst.setInt(21, q = Integer.parseInt(sempract1.getText()));
        pst.setInt(22, r = Integer.parseInt(sempract2.getText()));
        pst.setInt(23, s = Integer.parseInt(sempract3.getText()));
        pst.setInt(24, t = Integer.parseInt(sempract4.getText()));
        int total = a + b + c + d + e + f + g + h + i + j + k + l + m + n + o + p + q + r + s + t;
        pst.setInt(25, total);
        percentage = (float) total / (float) 1200 * (float) 100;
        pst.setFloat(26, percentage);
        String grade = "";
        if (percentage >= 85) grade = "Distinction";
        if (percentage >= 65 && percentage < 85) grade = "First Class";
        if (percentage >= 50 && percentage < 65) grade = "Second Class";
        if (percentage >= 40 && percentage < 50) grade = "Pass";
        if (percentage < 40) grade = "Fail";
        pst.setString(27, grade);
        pst.execute();
        pst.close();
        connection.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Student Updated Sucsessfully");
        alert.showAndWait();

    }

    public void examDeleteClicked() throws SQLException {
        String query = "delete from studentexam where regno='" + txtregno.getText() + "'";
        connection = handler.getConnection();
        PreparedStatement pst = connection.prepareStatement(query);
        pst.execute();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Deleted Sucsessfully");
        alert.showAndWait();
        pst.close();
        connection.close();
    }

    public void examLoadClicked() throws SQLException {


        connection = handler.getConnection();
        String query = "select studentpersonal.name,studentacademics.Rollno,studentexam.regno,studentexam.semappeard,studentexam.monthyear,studentexam.total,studentexam.percentage,studentexam.Grade from studentacademics,studentpersonal,studentexam Where studentpersonal.admissionnum=studentacademics.admissionnum and studentacademics.Rollno=studentexam.Rollno and studentacademics.course=? and studentacademics.combination=? and studentacademics.semester=?";
        name3.setCellValueFactory(new PropertyValueFactory<ExamTable, String>("name3"));
        regno.setCellValueFactory(new PropertyValueFactory<ExamTable, String>("regno"));
        semappeared.setCellValueFactory(new PropertyValueFactory<ExamTable, String>("semappeared"));
        year.setCellValueFactory(new PropertyValueFactory<ExamTable, String>("year"));
        total.setCellValueFactory(new PropertyValueFactory<ExamTable, Integer>("total"));
        percentage.setCellValueFactory(new PropertyValueFactory<ExamTable, Float>("percentage"));
        grade.setCellValueFactory(new PropertyValueFactory<ExamTable, String>("grade"));
        data4 = FXCollections.observableArrayList();
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, choicecrs3.getValue());
        pst.setString(2, choicecomb3.getValue());
        pst.setString(3, choicesem3.getValue());
        ResultSet resultSet = pst.executeQuery();
        while (resultSet.next()) {
            data4.add(new ExamTable(
                    resultSet.getString(1),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getInt(6),
                    resultSet.getFloat(7),
                    resultSet.getString(8)
            ));
        }
        tableview4.setItems(data4);
        resultSet.close();
        pst.close();
        connection.close();

    }

    public void examTableClicked() throws SQLException {
        connection = handler.getConnection();
        ExamTable table = (ExamTable) tableview4.getSelectionModel().getSelectedItem();
        String query = "select * from studentexam where regno=?";
        PreparedStatement pst = connection.prepareStatement(query);
        TablePosition pos = tableview4.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        // Item here is the table view type:
        ExamTable item = tableview4.getItems().get(row);
        TableColumn col = pos.getTableColumn();
        // this gives the value in the selected cell:
        String data = (String) col.getCellObservableValue(item).getValue();
        pst.setString(1, data);
        ResultSet rs;
        rs = pst.executeQuery();
        while (rs.next()) {
            txtregno.setText(rs.getString(1));
            txtrollno2.setText(rs.getString(2));
            txtsemappeared.setText(rs.getString(3));
            txtmonth.setText(rs.getString(4));
            semsub1.setText(rs.getString(5));
            semsub2.setText(rs.getString(6));
            semsub3.setText(rs.getString(7));
            semsub4.setText(rs.getString(8));
            semsub5.setText(rs.getString(9));
            semsub6.setText(rs.getString(10));
            semsub7.setText(rs.getString(11));
            semsub8.setText(rs.getString(12));
            Isub1.setText(rs.getString(13));
            Isub2.setText(rs.getString(14));
            Isub3.setText(rs.getString(15));
            Isub4.setText(rs.getString(16));
            Isub5.setText(rs.getString(17));
            Isub6.setText(rs.getString(18));
            Isub7.setText(rs.getString(19));
            Isub8.setText(rs.getString(20));
            sempract1.setText(rs.getString(21));
            sempract2.setText(rs.getString(22));
            sempract3.setText(rs.getString(23));
            sempract4.setText(rs.getString(24));
        }
        rs.close();
        pst.close();
        connection.close();
    }

    public void reportLoadClicked() throws SQLException {
        String query = "select studentpersonal.name,studentacademics.Rollno,studentexam.regno,studentpersonal.studentphnum," +
                "studentpersonal.email,studentacademics.course,studentacademics.combination,studentacademics.semester from " +
                "studentacademics,studentpersonal,studentexam Where studentpersonal.admissionnum=studentacademics.admissionnum " +
                "and studentacademics.Rollno=studentexam.Rollno and course=? and combination=? and semester=?";
        name5.setCellValueFactory(new PropertyValueFactory<ReportTable, String>("name5"));
        rollno5.setCellValueFactory(new PropertyValueFactory<ReportTable, String>("rollno5"));
        regno5.setCellValueFactory(new PropertyValueFactory<ReportTable, String>("regno5"));
        phone5.setCellValueFactory(new PropertyValueFactory<ReportTable, String>("phone5"));
        email5.setCellValueFactory(new PropertyValueFactory<ReportTable, String>("email5"));
        course5.setCellValueFactory(new PropertyValueFactory<ReportTable, String>("course5"));
        comb5.setCellValueFactory(new PropertyValueFactory<ReportTable, String>("comb5"));
        sem5.setCellValueFactory(new PropertyValueFactory<ReportTable, String>("sem5"));
        data5 = FXCollections.observableArrayList();
        connection = handler.getConnection();
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, choicecrs32.getValue());
        pst.setString(2, choicecomb32.getValue());
        pst.setString(3, choicesem32.getValue());
        ResultSet resultSet = pst.executeQuery();
        while (resultSet.next()) {
            data5.add(new ReportTable(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8)
            ));
        }
        tableview5.setItems(data5);
        resultSet.close();
        pst.close();
        connection.close();

    }


    public void reportGenerateClicked() throws IOException {
        if (radattedance.isSelected()) {
//            Stage stage = new Stage();
//            URL url = new File("src/fxml/Report.fxml").toURI().toURL();
//            Parent xyz = FXMLLoader.load(url);
//            stage.setTitle(" Attedance Report");
//            stage.setScene(new Scene(xyz, 800, 700));
//            stage.getIcons().add(new Image("icons/Student.png"));
//            stage.showAndWait();



        }
        if (radaexam.isSelected()) {
//            Stage stage = new Stage();
//            URL url = new File("src/fxml/Report.fxml").toURI().toURL();
//            Parent xyz = FXMLLoader.load(url);
//            stage.setTitle("Exam Report");
//            stage.setScene(new Scene(xyz, 800, 700));
//            stage.getIcons().add(new Image("icons/Student.png"));
//            stage.showAndWait();

        }

    }

    public void reportSearchClicked() {
        FilteredList<ReportTable> filteredata = new FilteredList<>(data5, e -> true);
        txtsearch1.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredata.setPredicate((Predicate<? super ReportTable>) ReportTable -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowercasefilter = newValue.toLowerCase();
                if (ReportTable.getRollno5().contains(newValue)) {
                    return true;

                } else if (ReportTable.getName5().toLowerCase().contains(newValue)) {
                    return true;
                } else if (ReportTable.getSem5().toLowerCase().contains(newValue)) {
                    return true;
                } else if (ReportTable.getCourse5().toLowerCase().contains(newValue)) {
                    return true;

                } else if (ReportTable.getComb5().toLowerCase().contains(newValue)) {
                    return true;
                } else if (ReportTable.getRegno5().contains(newValue)) {
                    return true;
                }

                return false;

            });
            SortedList<ReportTable> sortedList = new SortedList<ReportTable>(filteredata);
            sortedList.comparatorProperty().bind(tableview5.comparatorProperty());
            tableview5.setItems(sortedList);
        }));

    }

    public void smsLoadClicked() throws SQLException {
        if (radioattendance.isSelected()) {
            data6 = FXCollections.observableArrayList();
            connection = handler.getConnection();
            String Query = "select studentpersonal.name, studentacademics.Rollno,studentacademics.course,studentacademics.combination,studentacademics.semester, attendance.s1classheld,attendance.s2classheld,attendance.s3classheld,attendance.s4classheld,attendance.s5classheld,attendance.s6classheld,attendance.s7classheld,attendance.s8classheld,attendance.s1classattendend,attendance.s2classattendend,attendance.s3classattendend,attendance.s4classattendend,attendance.s5classattendend,attendance.s6classattendend,attendance.s7classattendend,attendance.s8classattendend from studentpersonal,attendance,studentacademics where studentacademics.course=? and studentacademics.combination=? and studentacademics.semester=? and attendance.Rollno=studentacademics.Rollno and studentpersonal.admissionnum=studentacademics.admissionnum";
            PreparedStatement preparedStatement = connection.prepareStatement(Query);
            preparedStatement.setString(1, choicecrs31.getValue().toString());
            preparedStatement.setString(2, choicecomb31.getValue().toString());
            preparedStatement.setString(3, (String) choicesem31.getValue().toString());

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                float sub1ch = Integer.parseInt(rs.getString(6)), sub1ca = Integer.parseInt(rs.getString(14));
                float sub2ch = Integer.parseInt(rs.getString(7)), sub2ca = Integer.parseInt(rs.getString(15));
                float sub3ch = Integer.parseInt(rs.getString(8)), sub3ca = Integer.parseInt(rs.getString(16));
                float sub4ch = Integer.parseInt(rs.getString(9)), sub4ca = Integer.parseInt(rs.getString(17));
                float sub5ch = Integer.parseInt(rs.getString(10)), sub5ca = Integer.parseInt(rs.getString(18));
                float sub6ch = Integer.parseInt(rs.getString(11)), sub6ca = Integer.parseInt(rs.getString(19));
                float sub7ch = Integer.parseInt(rs.getString(12)), sub7ca = Integer.parseInt(rs.getString(20));
                float sub8ch = Integer.parseInt(rs.getString(13)), sub8ca = Integer.parseInt(rs.getString(21));
                data6.add(new Attendancesms(
                        rs.getString(1),
                        rs.getString(2),
                        ((float) (sub1ca / sub1ch * 100)),
                        ((float) (sub2ca / sub2ch * 100)),
                        ((float) (sub3ca / sub3ch * 100)),
                        ((float) (sub4ca / sub4ch * 100)),
                        ((float) (sub5ca / sub5ch * 100)),
                        ((float) (sub6ca / sub6ch * 100)),
                        ((float) (sub7ca / sub7ch * 100)),
                        ((float) (sub8ca / sub8ch * 100)),
                        true
                ));
            }
            rollno8.setCellValueFactory(new PropertyValueFactory<Attendancesms, String>("rollno8"));
            name4.setCellValueFactory(new PropertyValueFactory<Attendancesms, String>("name4"));
            subj1.setCellValueFactory(new PropertyValueFactory<Attendancesms, Float>("subj1"));
            subj2.setCellValueFactory(new PropertyValueFactory<Attendancesms, Float>("subj2"));
            subj3.setCellValueFactory(new PropertyValueFactory<Attendancesms, Float>("subj3"));
            subj4.setCellValueFactory(new PropertyValueFactory<Attendancesms, Float>("subj4"));
            subj5.setCellValueFactory(new PropertyValueFactory<Attendancesms, Float>("subj5"));
            subj6.setCellValueFactory(new PropertyValueFactory<Attendancesms, Float>("subj6"));
            subj7.setCellValueFactory(new PropertyValueFactory<Attendancesms, Float>("subj7"));
            subj8.setCellValueFactory(new PropertyValueFactory<Attendancesms, Float>("subj8"));
            select.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Attendancesms, Boolean>, ObservableValue<Boolean>>() {
                @Override
                public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Attendancesms, Boolean> param) {
                    Attendancesms select = param.getValue();
                    SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(select.isSelect());
                    booleanProp.addListener(new ChangeListener<Boolean>() {
                        @Override
                        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                                            Boolean newValue) {
                            select.setSelect(newValue);
                        }
                    });
                    return booleanProp;
                }
            });
            select.setCellFactory(tc -> new CheckBoxTableCell<>());
            tableview7.setItems(data6);
            tableview7.setEditable(true);
            rs.close();
            preparedStatement.close();
            connection.close();

        }
        if (radioexam.isSelected()) {
            data6 = FXCollections.observableArrayList();
            connection = handler.getConnection();
            String query = "select studentpersonal.name,studentexam.Rollno,studentexam.MarkM1IA,studentexam.MarkM2IA,studentexam.MarkM3IA," +
                    "studentexam.MarkM4IA,studentexam.MarkM5IA,studentexam.MarkM6IA,studentexam.MarkM7IA,studentexam.MarkM8IA,studentexam.MarkM1Th" +
                    ",studentexam.MarkM2Th,studentexam.MarkM3Th,studentexam.MarkM4Th,studentexam.MarkM5Th,studentexam.MarkM6Th,studentexam.MarkM7Th," +
                    "studentexam.MarkM8Th,studentacademics.course,studentacademics.combination,studentacademics.semester from studentpersonal," +
                    "studentexam,studentacademics where studentpersonal.admissionnum=studentacademics.admissionnum and " +
                    "studentacademics.Rollno=studentexam.Rollno and studentacademics.course=? and studentacademics.combination=?" +
                    " and studentacademics.semester=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, choicecrs31.getValue().toString());
            preparedStatement.setString(2, choicecomb31.getValue().toString());
            preparedStatement.setString(3, choicesem31.getValue().toString());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                float sub1 = (float) 0.0, sub2 = (float) 0.0, sub3 = (float) 0.0, sub4 = (float) 0.0, sub5 = (float) 0.0, sub6 = (float) 0.0, sub7 = (float) 0.0, sub8 = (float) 0.0;
                sub1 = Float.parseFloat(rs.getString(3));
                sub1 = sub1 + Float.parseFloat(rs.getString(11));

                sub2 = Float.parseFloat(rs.getString(4));
                sub2 = sub2 + Float.parseFloat(rs.getString(12));

                sub3 = Float.parseFloat(rs.getString(5));
                sub3 = sub3 + Float.parseFloat(rs.getString(13));

                sub4 = Float.parseFloat(rs.getString(6));
                sub4 = sub4 + Float.parseFloat(rs.getString(14));

                sub5 = Float.parseFloat(rs.getString(7));
                sub5 = sub5 + Float.parseFloat(rs.getString(15));

                sub6 = Float.parseFloat(rs.getString(8));
                sub6 = sub6 + Float.parseFloat(rs.getString(16));

                sub7 = Float.parseFloat(rs.getString(9));
                sub7 = sub7 + Float.parseFloat(rs.getString(17));

                sub8 = Float.parseFloat(rs.getString(10));
                sub8 = sub8 + Float.parseFloat(rs.getString(18));
                data6.add(new Attendancesms(rs.getString(1),
                        rs.getString(2),
                        sub1,
                        sub2,
                        sub3,
                        sub4,
                        sub5,
                        sub6,
                        sub7,
                        sub8,
                        true
                ));
            }
            rollno8.setCellValueFactory(new PropertyValueFactory<Attendancesms, String>("rollno8"));
            name4.setCellValueFactory(new PropertyValueFactory<Attendancesms, String>("name4"));
            subj1.setCellValueFactory(new PropertyValueFactory<Attendancesms, Float>("subj1"));
            subj2.setCellValueFactory(new PropertyValueFactory<Attendancesms, Float>("subj2"));
            subj3.setCellValueFactory(new PropertyValueFactory<Attendancesms, Float>("subj3"));
            subj4.setCellValueFactory(new PropertyValueFactory<Attendancesms, Float>("subj4"));
            subj5.setCellValueFactory(new PropertyValueFactory<Attendancesms, Float>("subj5"));
            subj7.setCellValueFactory(new PropertyValueFactory<Attendancesms, Float>("subj6"));
            subj7.setCellValueFactory(new PropertyValueFactory<Attendancesms, Float>("subj7"));
            subj8.setCellValueFactory(new PropertyValueFactory<Attendancesms, Float>("subj8"));
            select.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Attendancesms, Boolean>, ObservableValue<Boolean>>() {
                @Override
                public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Attendancesms, Boolean> param) {
                    Attendancesms select = param.getValue();
                    SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(select.isSelect());
                    booleanProp.addListener(new ChangeListener<Boolean>() {
                        @Override
                        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
                                            Boolean newValue) {
                            select.setSelect(newValue);
                        }
                    });
                    return booleanProp;
                }
            });
            select.setCellFactory(tc -> new CheckBoxTableCell<>());
            tableview7.setItems(data6);
            tableview7.setEditable(true);
            rs.close();
            preparedStatement.close();
            connection.close();
        }

    }

    public void smsSendClicked() throws SQLException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        int sucsess = 0, fail = 0;
        String phone = "", messeage = "";
        float sub1, sub2, sub3, sub6, sub7, sub8;
        if (radioattendance.isSelected()) {
            for (Attendancesms bean : data6) {
                if (bean.isSelect()) {

                    String query = "select studentpersonal.parentphnum, studentacademics.Rollno ,studentpersonal.fatname from studentpersonal,studentacademics where studentacademics.admissionnum=studentpersonal.admissionnum and  Rollno='" + bean.getName4() + "'";
                    connection = handler.getConnection();
                    PreparedStatement pst = connection.prepareStatement(query);
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        phone = rs.getString(1);
                        messeage = "Mr." + rs.getString(3) + " your Son/Daughter have shortage of Attedance.";
                        sms = new sendSMS("TXTLCL", phone, messeage);
                        String status = sms.sendSms();
                        System.out.print(status);
                        if (status.contains("failure")) {
                            fail++;
                        } else {
                            sucsess++;
                        }
                    }

                    rs.close();
                    pst.close();
                    connection.close();
                }
            }
            alert.setHeaderText("Status:Sent succsessful: " + sucsess + " Sending Failed: " + fail);
            alert.showAndWait();
        }
        if (radioexam.isSelected()) {
            phone = "";
            messeage = "";
            for (Attendancesms bean : data6) {
                if (bean.isSelect()) {

                    String query = "select studentacademics.Rollno,studentexam.percentage,studentexam.total,studentexam.Grade," +
                            "studentpersonal.fatname,studentacademics.course,studentacademics.semester,studentpersonal.parentphnum from studentexam,studentpersonal," +
                            "studentacademics where studentexam.Rollno=studentacademics.Rollno and studentpersonal.admissionnum=studentacademics.admissionnum" +
                            " and studentacademics.Rollno='" + bean.getName4() + "'";
                    connection = handler.getConnection();
                    PreparedStatement pst = connection.prepareStatement(query);
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        phone = rs.getString(8);
                        messeage = "MR." + rs.getString(5) + " Your son/daughter has secured " + rs.getString(2).substring(0, 5) + " and " + rs.getString(4) + " in " + rs.getString(6) + " " + rs.getString(7) + " sem. ";

                        sms = new sendSMS("TXTLCL", phone, messeage);
                        String status = sms.sendSms();
                        System.out.print(status);
                        if (status.contains("failure")) {
                            fail++;
                        } else {
                            sucsess++;
                        }
                    }

                    rs.close();
                    pst.close();
                    connection.close();
                }
            }
            alert.setHeaderText("Status:Sent succsessful: " + sucsess + " Sending Failed: " + fail);
            alert.showAndWait();
        }
    }

    public void sendBtnclicked() throws SQLException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String status = "";
        if (radioparent.isSelected()) {
            int sucsess = 0, fail = 0;
            String phone = "", messesage = "", sender = "";
            String query = "Select parentphnum from studentpersonal";
            connection = handler.getConnection();
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                phone = rs.getString(1);
                messesage = txtfmessage.getText();
                sms = new sendSMS(sender, phone, messesage);
                status = sms.sendSms();
                System.out.print(status);
                if (status.contains("failure")) {
                    fail++;
                } else {
                    sucsess++;
                }
            }
            alert.setHeaderText("Status:Sent succsessful: " + sucsess + " Sending Failed: " + fail);
            alert.showAndWait();
            rs.close();
            pst.close();
            connection.close();

        }
        if (radiostudent.isSelected()) {
            int sucsess = 0, fail = 0;
            String phone = "", messesage = "", sender = "";
            String query = "Select studentphnum from studentpersonal";
            connection = handler.getConnection();
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                phone = rs.getString(1);
                messesage = txtfmessage.getText();
                sms = new sendSMS(sender, phone, messesage);
                status = sms.sendSms();
                System.out.print(status);
                if (status.contains("failure")) {
                    fail++;
                } else {
                    sucsess++;
                }
            }
            alert.setHeaderText("Status:Sent succsessful: " + sucsess + " Sending Failed: " + fail);
            alert.showAndWait();
            rs.close();
            pst.close();
            connection.close();

        }

    }

}