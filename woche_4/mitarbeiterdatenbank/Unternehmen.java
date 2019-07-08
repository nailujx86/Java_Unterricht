package woche_4.mitarbeiterdatenbank;

import java.util.ArrayList;
import java.util.Date;

public class Unternehmen {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<Person>();
        Manager manager = new Manager(12, "Hans Peter", "keinestraße 34 62783 Stadt", new Date(1950, 12, 2), 5000, 1000);
        list.add(manager);
        Arbeiter arbeiter = new Arbeiter(23, "abc", "def", new Date("12/03/1980"), 12, 3, 5);
        list.add(arbeiter);
        for(Person person : list) {
            System.out.println(person.berechneGehalt(20, 10, 5));
        }
    }

}