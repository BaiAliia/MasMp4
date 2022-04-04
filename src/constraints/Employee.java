package constraints;

import constraints.Exceptions.ModelValExc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// bag  mp2
//mp4 attribute

public class Employee {
    private String name;
    private int idemp;
    private int Salary ;


    private List<Purchase> purch=new ArrayList<>();


    public Employee(String name,int idemp,int sal){
        setName(name);
        setIdemp(idemp);
        setSalary(sal);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name==null||name.isBlank()){
            throw  new ModelValExc("Emp name cant be null or empty");
        }
        this.name=name;
    }

    public int getIdemp() {
        return idemp;
    }

    public void setIdemp(int idemp) {
        this.idemp = idemp;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public List<Purchase> getPurch() {
        return Collections.unmodifiableList(purch);
    }

  public void addPurchase(Purchase p){
        if(p==null){
            throw new ModelValExc("The purchase cant be null");
        }
        if(purch.contains(p)){
            throw new ModelValExc("The purchase already added");
        }
        purch.add(p);
  }

  public void removePurch(Purchase p){
        if(purch.contains(p)){
            purch.remove(p);
        }
  }

}
