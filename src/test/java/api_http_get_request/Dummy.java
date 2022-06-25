package api_http_get_request;

import pojos.Person;

import java.util.ArrayList;
import java.util.List;

public class Dummy {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("Fuat");
        names.add("Mohamed");
        names.add("Ibrahim");

        List<String> lastnames = new ArrayList<>();
        lastnames.add("Koca");
        lastnames.add("Frotan");
        lastnames.add("Kalin");

        System.out.println(returnPeople(names,lastnames));
    }



    public static List<Person> returnPeople(List<String>names, List<String >lastnames){

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            Person person = new Person();

            person.setName(names.get(i));
            person.setLastname(lastnames.get(i));
            people.add(person);


        }
            return people;
    }



}
