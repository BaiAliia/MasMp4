package constraints;

import constraints.Exceptions.ModelValExc;
import constraints.Obj.ObjectPlus4;

import java.util.HashMap;
import java.util.Map;

public class Group extends ObjectPlus4 {
    private int id;
    private  String name;

    public static final String ConsistOf = "Consist of";
    public static final String managedby= "managed by";

    private Map<Integer, Student> studentsMap = new HashMap<>();

    public Group(int id, String name) {
        super();
        this.id = id;
      setName(name);
    }

    public Student getStudentById(Integer id) {
        if (id != null) {
            return studentsMap.get(id);
        } else {
            throw new RuntimeException("id is null");
        }
    }

    public void addStudent(Student st) {
        if (st.getProject() != null) {
            throw new IllegalArgumentException("student is already added");
        }
        if (st == null) {
            throw new RuntimeException("invalid input student cant be null");
        } else {
            if (!studentsMap.containsKey(st.getSnumber())) {
                studentsMap.put(st.getSnumber(), st);
                if (st.getGroup() != this)
                    st.setGroup(this);
            } else {
                throw new RuntimeException("student already in this group");
            }
        }
    }

    public void removeStudentById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("id is NULL");
        } else {
            studentsMap.remove(id);
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name==null||name.isBlank()){
            throw new ModelValExc("Students name cant be null");
        }
        name = name;
    }
}
