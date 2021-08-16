package Tables;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by chidgana on 28-03-18.
 */
public class ExamTable {


    private final SimpleStringProperty name3;
    private final SimpleStringProperty regno;
    private final SimpleStringProperty semappeared;
    private final SimpleStringProperty Year;
    private final Integer Total;
    private final Float Percentage;
    private final SimpleStringProperty Grade;

    public ExamTable(String name3, String regno, String semappeared, String year, Integer total, Float percentage, String grade) {
        this.name3 = new SimpleStringProperty(name3);
        this.regno = new SimpleStringProperty(regno);
        this.semappeared = new SimpleStringProperty(semappeared);
        this.Year = new SimpleStringProperty(year);
        this.Total = new Integer(total);
        this.Percentage = new Float(percentage);
        this.Grade = new SimpleStringProperty(grade);
    }

    public String getName3() {
        return name3.get();
    }


    public void setName3(String name3) {
        this.name3.set(name3);
    }

    public String getRegno() {
        return regno.get();
    }

    public void setRegno(String regno) {
        this.regno.set(regno);
    }

    public SimpleStringProperty regnoProperty() {
        return regno;
    }

    public String getSemappeared() {
        return semappeared.get();
    }

    public void setSemappeared(String semappeared) {
        this.semappeared.set(semappeared);
    }

    public SimpleStringProperty semappearedProperty() {
        return semappeared;
    }

    public String getYear() {
        return Year.get();
    }

    public void setYear(String year) {
        this.Year.set(year);
    }

    public SimpleStringProperty yearProperty() {
        return Year;
    }

    public Integer getTotal() {
        return Total;
    }

    public Float getPercentage() {
        return Percentage;
    }

    public String getGrade() {
        return Grade.get();
    }

    public void setGrade(String grade) {
        this.Grade.set(grade);
    }

    public SimpleStringProperty gradeProperty() {
        return Grade;
    }
}
