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

    public Roster(Roster roster)
    {
        students_ = new ArrayList<>();
        for(Student student : roster.getStudents())
        {
            students_.add( new Student(student));
        }
    }

    public Roster(List<Student> students)
    {
        students_ = students;
    }

    public int getSize(){ return students_.size();}

    public void addStudent(Student newStudent)
    {
        students_.add(newStudent);
    }

    public boolean removeStudent(int studentId)
    {
        boolean ret=false;
        for(Student student : students_)
        {
            if(student.getId() == studentId)
            {
                students_.remove(student);
                ret = true;
                break;
            }
        }
        return ret;
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

    @Override
    public boolean equals(Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }

        if( this.getClass() != rhs.getClass())
        {
            return false;
        }

        Roster temp = (Roster) rhs;
        return(this.students_.equals(((Roster) rhs).students_));

    }

    public void accept(RosterVisitor visitor)
    {
        visitor.visit(this);
    }

    private List<Student> getStudents()
    {
        return students_;
    }

}