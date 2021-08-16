package Tables;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by chidgana on 26-03-18.
 */
public class AttendanceTablecal {
    private final SimpleStringProperty rollno;
    private final SimpleStringProperty name2;
    private Float subject1;
    private Float subject2;
    private Float subject3;
    private Float subject4;
    private Float subject5;
    private Float subject6;
    private Float subject7;
    private Float subject8;

    public AttendanceTablecal(String rollno, String name2, Float subject1, Float subject2, Float subject3, Float subject4, Float subject5, Float subject6, Float subject7, Float subject8) {
        this.rollno = new SimpleStringProperty(rollno);
        this.name2 = new SimpleStringProperty(name2);
        this.subject1 = new Float(subject1);
        this.subject2 = new Float(subject2);
        this.subject3 = new Float(subject3);
        this.subject4 = new Float(subject4);
        this.subject5 = new Float(subject5);
        this.subject6 = new Float(subject6);
        this.subject7 = new Float(subject7);
        this.subject8 = new Float(subject8);
    }

    public String getRollno() {
        return rollno.get();
    }

    public void setRollno(String rollno) {
        this.rollno.set(rollno);
    }

    public String getName2() {
        return name2.get();
    }

    public void setName2(String name) {
        this.name2.set(name);
    }

    public Float getSubject1() {
        return subject1;
    }

    public void setSubject1(Float subject1) {
        this.subject1 = subject1;
    }

    public Float getSubject2() {
        return subject2;
    }

    public void setSubject2(Float subject2) {
        this.subject2 = subject2;
    }

    public Float getSubject3() {
        return subject3;
    }

    public void setSubject3(Float subject3) {
        this.subject3 = subject3;
    }

    public Float getSubject4() {
        return subject4;
    }

    public void setSubject4(Float subject4) {
        this.subject4 = subject4;
    }

    public Float getSubject5() {
        return subject5;
    }

    public void setSubject5(Float subject5) {
        this.subject5 = subject5;
    }

    public Float getSubject6() {
        return subject6;
    }

    public void setSubject6(Float subject6) {
        this.subject6 = subject6;
    }

    public Float getSubject8() {
        return subject8;
    }

    public void setSubject8(Float subject8) {
        this.subject8 = subject8;
    }

    public Float getSubject7() {
        return subject7;
    }

    public void setSubject7(Float subject7) {
        this.subject7 = subject7;
    }
}
