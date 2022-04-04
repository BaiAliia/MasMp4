package constraints;

import constraints.Exceptions.ModelValExc;

public class Purchase {
    private int idp;
    private String CustomerName;
    private Employee emp;

    public Purchase(int idp, String customerName) {
        this.idp = idp;
      setCustomerName(customerName);
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
       if(customerName==null||customerName.isBlank()){
           throw  new ModelValExc("Customers name cant be null or empty");
       }
       this.CustomerName=customerName;
    }
}
