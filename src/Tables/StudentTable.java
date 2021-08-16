package Tables;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by chidgana on 07-03-18.
 */
public class StudentTable {
    private final SimpleStringProperty admissionnumber;
    private final SimpleStringProperty registernumber;
    private final SimpleStringProperty name;
    private final SimpleStringProperty dateofbirth;
    private final SimpleStringProperty phonenumber;
    private final SimpleStringProperty email;
    private final SimpleStringProperty course;
    private final SimpleStringProperty semester;

    //constructor
    public StudentTable(String admissionnumber, String registernumber, String name, String dateofbirth, String phonenumber, String email, String course, String semester) {
        this.admissionnumber = new SimpleStringProperty(admissionnumber);
        this.registernumber = new SimpleStringProperty(registernumber);
        this.name = new SimpleStringProperty(name);
        this.dateofbirth = new SimpleStringProperty(dateofbirth);
        this.phonenumber = new SimpleStringProperty(phonenumber);
        this.email = new SimpleStringProperty(email);
        this.course = new SimpleStringProperty(course);
        this.semester = new SimpleStringProperty(semester);
    }

    //get methods


    public String getAdmissionnumber() {
        return admissionnumber.get();
    }

    //set methods
    public void setAdmissionnumber(String admissionnumber) {
        this.admissionnumber.set(admissionnumber);
    }

    public String getRegisternumber() {
        return registernumber.get();
    }

    public void setRegisternumber(String registernumber) {
        this.registernumber.set(registernumber);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDateofbirth() {
        return dateofbirth.get();
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth.set(dateofbirth);
    }

    public String getPhonenumber() {
        return phonenumber.get();
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber.set(phonenumber);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getCourse() {
        return course.get();
    }

    public void setCourse(String course) {
        this.course.set(course);
    }

    public String getSemester() {
        return semester.get();
    }

    public void setSemester(String semester) {
        this.semester.set(semester);
    }
}
