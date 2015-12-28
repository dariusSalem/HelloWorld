import sun.reflect.generics.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Darius on 12/24/2015.
 */
public class Roster
{

    private List<Student> students_;

    public Roster()
    {
        students_ = new ArrayList<>();
    }

    public void addStudent(Student newStudent)
    {
        students_.add(newStudent);
    }

    public void removeStudent(int studentId)
    {
        for(Student student : students_)
        {
            if(student.getId() == studentId)
            {
                students_.remove(student);
            }
        }
    }

    public Student getStudent(int studentId)
    {
        Student ret= null;
        for(Student student : students_)
        {
            if(student.getId() == studentId)
            {
                return student;
            }
        }
        return ret;
    }

    @Override
    public String toString()
    {
        String ret = "Roster: \n";
        for(Student student : students_)
        {
            ret += "\t" + student.toString();
        }
        return ret;
    }

    public void save(String fileName, SaveRosterStrategy saver)
    {
        saver.save(fileName, this);
    }

    public void accept(RosterVisitor visitor)
    {
        visitor.visit(this);
    }

}