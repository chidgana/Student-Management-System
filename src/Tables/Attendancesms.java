package Tables;

/**
 * Created by chidgana on 04-04-18.
 */

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class Attendancesms {
    private final SimpleStringProperty rollno8;
    private final SimpleStringProperty name4;
    private Float subj1;
    private Float subj2;
    private Float subj3;
    private Float subj4;
    private Float subj5;
    private Float subj6;
    private Float subj7;
    private Float subj8;
    private BooleanProperty select;

    public Attendancesms(String rollno, String name2, Float subject1, Float subject2, Float subject3, Float subject4, Float subject5, Float subject6, Float subject7, Float subject8, Boolean select) {
        this.rollno8 = new SimpleStringProperty(rollno);
        this.name4 = new SimpleStringProperty(name2);
        this.subj1 = new Float(subject1);
        this.subj2 = new Float(subject2);
        this.subj3 = new Float(subject3);
        this.subj4 = new Float(subject4);
        this.subj5 = new Float(subject5);
        this.subj6 = new Float(subject6);
        this.subj7 = new Float(subject7);
        this.subj8 = new Float(subject8);
        this.select = new SimpleBooleanProperty(select);
    }

    public String getRollno8() {
        return rollno8.get();
    }

    public void setRollno8(String rollno8) {
        this.rollno8.set(rollno8);
    }

    public String getName4() {
        return name4.get();
    }

    public void setName4(String name) {
        this.name4.set(name);
    }

    public Float getSubj1() {
        return subj1;
    }

    public void setSubj1(Float subj1) {
        this.subj1 = subj1;
    }

    public Float getSubj2() {
        return subj2;
    }

    public void setSubj2(Float subj2) {
        this.subj2 = subj2;
    }

    public Float getSubj3() {
        return subj3;
    }

    public void setSubj3(Float subj3) {
        this.subj3 = subj3;
    }

    public Float getSubj4() {
        return subj4;
    }

    public void setSubj4(Float subj4) {
        this.subj4 = subj4;
    }

    public Float getSubj5() {
        return subj5;
    }

    public void setSubj5(Float subj5) {
        this.subj5 = subj5;
    }

    public Float getSubj6() {
        return subj6;
    }

    public void setSubj6(Float subj6) {
        this.subj6 = subj6;
    }

    public Float getSubj8() {
        return subj8;
    }

    public void setSubj8(Float subj8) {
        this.subj8 = subj8;
    }

    public Float getSubj7() {
        return subj7;
    }

    public void setSubj7(Float subj7) {
        this.subj7 = subj7;
    }

    public boolean isSelect() {
        return select.get();
    }

    public void setSelect(boolean select) {
        this.select.set(select);
    }
}
