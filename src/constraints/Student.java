package constraints;

import constraints.Exceptions.ModelValExc;
import constraints.Obj.ObjectPlus4;

import java.util.*;

public class Student extends ObjectPlus4 {
    private static List<Student> extent =new ArrayList<>();
    private static Set<Integer> snumbers=new HashSet<>();

    public static final String manages = "manages";
    public static final String belongsto = "belongs to";

    private Integer snumber;
    private String Name;
    private Group gr1;
    private Project pr1;

    public Student() {
        super();
        Student.extent.add(this);
    }

    public Student(Integer snumber, String name,Group g) {
        this();
       setSnumber(snumber);
       setName(name);
       setGroup(g);
    }
    public Student(Integer snumber, String name,Project p) {
        this();
        setSnumber(snumber);
        setName(name);
        setProject(p);
    }
    public Student(Integer snumber, String name) {
        this();
        setSnumber(snumber);
        setName(name);

    }
    public void setGroup(Group gr1) {
        if (pr1 != null) {
            throw new IllegalArgumentException("The student is part of the university project cant set to the group");
        }
        if (gr1 == null) {
            throw new IllegalArgumentException("grop is null");
        } else {
            this.gr1 = gr1;
            gr1.addStudent(this);
        }
    }
    public Group getGroup(){
        return gr1;
    }
    public void setProject(Project pr1) {
        if (gr1 != null) {
            throw new IllegalArgumentException("student belongs to group cant be added to university project");

        }
        if (pr1 == null) {
            throw new IllegalArgumentException("invalid input is null");
        }
        this.pr1 = pr1;
        pr1.addStudent(this);
    }
    public Project getProject(){
        return pr1;
    }
    public static void removeSt(Student r){
        if(extent.contains(r) && snumbers.contains(r.getSnumber())){
            extent.remove(r);
            snumbers.remove(r.getSnumber());
        }
    }
    public static List<Student> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public static Set<Integer> getSnumbers() {
        return Collections.unmodifiableSet(snumbers);
    }

    public Integer getSnumber() {
        return snumber;
    }

    public void setSnumber(Integer snumber) {
        if(snumber==0|| snumber<0||snumber==null){
            throw new ModelValExc("snumber cant be 0");
        }
        if(snumbers.contains(snumber)){
            throw new ModelValExc("Student number already exist");
        }

            this.snumber = snumber;
            snumbers.add(snumber);

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        if(name==null||name.isBlank()){
            throw new ModelValExc("Students name cant be null");
        }
        Name = name;
    }

    public static boolean ContainsExtent(Integer a){
        for (Student st : extent ) {
            if (st.getSnumber().compareTo(a)==0) {
                return true;
            }
        }
     return false;
    }

    public static Student getstudentById(String id) {
        List<Student> tmp = new ArrayList<>(extent);
        Student foundSt= null;
        for (Student s : tmp) {
            if (s.getSnumber().equals(id))
                foundSt = s;
        }
        return foundSt;
    }
}
