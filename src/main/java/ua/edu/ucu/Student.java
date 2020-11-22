package ua.edu.ucu;


import javax.swing.plaf.synth.SynthListUI;
import java.util.Objects;

class Student {

    private double GPA;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double GPA, int year) {
        this.GPA = GPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return GPA;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getGPA(), getYear());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Student sd = (Student) obj;
        return getName().equals(sd.getName()) && getSurname().equals(sd.getSurname())
                && getGPA() == sd.getGPA() && getYear() == sd.getYear();
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname=" + surname + ", " + "GPA=" + GPA + ", year=" + year + '}';
    }

}
