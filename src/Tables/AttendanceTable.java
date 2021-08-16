package Tables;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by chidgana on 21-03-18.
 * for attenedannce tab tableview
 */
public class AttendanceTable {
    private SimpleStringProperty Rollno;
    private SimpleStringProperty name1;
    private BooleanProperty Subject1;
    private BooleanProperty Subject2;
    private BooleanProperty Subject3;
    private BooleanProperty Subject4;
    private BooleanProperty Subject5;
    private BooleanProperty Subject6;
    private BooleanProperty Subject7;
    private BooleanProperty Subject8;

    private SimpleStringProperty rollnum;
    private SimpleStringProperty name;
    private Integer sub1;
    private Integer sub2;
    private Integer sub3;
    private Integer sub4;
    private Integer sub5;
    private Integer sub6;
    private Integer sub7;
    private Integer sub8;

    //    constructor
    public AttendanceTable(String Rollno, String name1, Boolean Subject1, Boolean Subject2, Boolean Subject3, Boolean Subject4, Boolean Subject5, Boolean Subject6, Boolean Subject7, Boolean Subject8) {
        this.Rollno = new SimpleStringProperty(Rollno);
        this.name1 = new SimpleStringProperty(name1);
        this.Subject1 = new SimpleBooleanProperty(Subject1);
        this.Subject2 = new SimpleBooleanProperty(Subject2);
        this.Subject3 = new SimpleBooleanProperty(Subject3);
        this.Subject4 = new SimpleBooleanProperty(Subject4);
        this.Subject5 = new SimpleBooleanProperty(Subject5);
        this.Subject6 = new SimpleBooleanProperty(Subject6);
        this.Subject7 = new SimpleBooleanProperty(Subject7);
        this.Subject8 = new SimpleBooleanProperty(Subject8);
//        this.(rollnum,name,sub1,sub2,sub3,sub4,sub5,sub6,sub8);
    }

    public AttendanceTable(String rollno, String name, Integer sub1, Integer sub2, Integer sub3, Integer sub4, Integer sub5, Integer sub6, Integer sub7, Integer sub8) {
//        this(rollnum,name,sub1,sub2,sub3,sub4,sub5,sub6,sub8);
        this.rollnum = new SimpleStringProperty(rollno);
        this.name = new SimpleStringProperty(name);
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.sub4 = sub4;
        this.sub5 = sub5;
        this.sub6 = sub6;
        this.sub7 = sub7;
        this.sub8 = sub8;

    }

//    public AttendanceTable(String rollno,String name) {
//        this.Rollno=new SimpleStringProperty(rollno);
//        this.name1=new SimpleStringProperty(name);
//
//    }


    //Getters


    public String getRollno() {
        return Rollno.get();
    }

    public void setRollno(String rollno) {
        this.Rollno.set(rollno);
    }

    public String getName1() {
        return name1.get();
    }
//setters

    public void setName1(String name1) {
        this.name1.set(name1);
    }

    public Boolean getSubject1() {
        return Subject1.get();
    }

    public boolean isSubject1() {
        return Subject1.get();
    }

    public void setSubject1(boolean subject1) {
        this.Subject1.set(subject1);
    }

    public boolean isSubject2() {
        return Subject2.get();
    }

    public void setSubject2(boolean subject2) {
        this.Subject2.set(subject2);
    }

    public boolean isSubject3() {
        return Subject3.get();
    }

    public void setSubject3(boolean subject3) {
        this.Subject3.set(subject3);
    }

    public boolean isSubject4() {
        return Subject4.get();
    }

    public void setSubject4(boolean subject4) {
        this.Subject4.set(subject4);
    }

    public boolean isSubject5() {
        return Subject5.get();
    }

    public void setSubject5(boolean subject5) {
        this.Subject5.set(subject5);
    }

    public boolean isSubject6() {
        return Subject6.get();
    }

    public void setSubject6(boolean subject6) {
        this.Subject6.set(subject6);
    }

    public boolean isSubject7() {
        return Subject7.get();
    }

    public void setSubject7(boolean subject7) {
        this.Subject7.set(subject7);
    }

    public boolean isSubject8() {
        return Subject8.get();
    }

    public void setSubject8(boolean subject8) {
        this.Subject8.set(subject8);
    }

    public String getRollnum() {
        return rollnum.get();
    }

    public void setRollnum(String rollnum) {
        this.rollnum.set(rollnum);
    }

    public SimpleStringProperty rollnumProperty() {
        return rollnum;
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public SimpleStringProperty name1Property() {
        return name1;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public Integer getSub1() {
        return sub1;
    }

    public void setSub1(Integer sub1) {
        this.sub1 = sub1;
    }

    public Integer getSub2() {
        return sub2;
    }

    public void setSub2(Integer sub2) {
        this.sub2 = sub2;
    }

    public Integer getSub3() {
        return sub3;
    }

    public void setSub3(Integer sub3) {
        this.sub3 = sub3;
    }

    public Integer getSub4() {
        return sub4;
    }

    public void setSub4(Integer sub4) {
        this.sub4 = sub4;
    }

    public Integer getSub5() {
        return sub5;
    }

    public void setSub5(Integer sub5) {
        this.sub5 = sub5;
    }

    public Integer getSub6() {
        return sub6;
    }

    public void setSub6(Integer sub6) {
        this.sub6 = sub6;
    }

    public Integer getSub7() {
        return sub7;
    }

    public void setSub7(Integer sub7) {
        this.sub7 = sub7;
    }

    public Integer getSub8() {
        return sub8;
    }

    public void setSub8(Integer sub8) {
        this.sub8 = sub8;
    }
}
