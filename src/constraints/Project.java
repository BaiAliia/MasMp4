package constraints;

import constraints.Exceptions.ModelValExc;
import constraints.Obj.ObjectPlus4;

import java.util.HashMap;
import java.util.Map;

public class Project extends ObjectPlus4 {
    private int id;
    private String name;


    private Map<Integer, Student> studentsMap = new HashMap<>();

    public Project(int id, String name) {
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
        if (st.getGroup() != null) {
            throw new IllegalArgumentException("student is already added");
        }
        if (st == null) {
            throw new RuntimeException("invalid input student cant be null");
        } else {
            if (!studentsMap.containsKey(st.getSnumber())) {
                studentsMap.put(st.getSnumber(), st);
                if (st.getProject() != this)
                    st.setProject(this);
            } else {
                throw new RuntimeException("student already in this group");
            }
        }
    }

    public void removeTorturerById(Integer id) {
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
        if (name == null || name.isBlank()) {
            throw new ModelValExc("projects name cant be null");
        }
        name = name;
    }
}
