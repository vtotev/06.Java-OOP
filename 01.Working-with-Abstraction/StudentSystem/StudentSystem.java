package WorkingWithAbstraction.StudentSystem;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem()
    {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void ParseCommand(String[]args)
    {
        if (args[0].equals("Create"))
        {
            CreateStudent(args);
        }
        else if (args[0].equals("Show"))
        {
            ShowStudent(args[1]);
        }
    }

    private void ShowStudent(String arg) {
        String name = arg;
        if (repo.containsKey(name))
        {
            Student student = repo.get(name);
            String view = String.format("%s is %s years old.",student.getName(),student.getAge());

            if (student.getGrade() >= 5.00)
            {
                view += " Excellent student.";
            }
            else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50)
            {
                view += " Average student.";
            }
            else
            {
                view += " Very nice person.";
            }

            System.out.println(view);
        }
    }

    private void CreateStudent(String[] args) {
        String name = args[1];
        int age = Integer.parseInt(args[2]);
        double grade = Double.parseDouble(args[3]);
        if (!repo.containsKey(name))
        {
            Student student = new Student(name, age, grade);
            repo.put(name,student);
        }
    }
}
