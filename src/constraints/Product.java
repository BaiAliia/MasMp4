package constraints;

import constraints.Exceptions.ModelValExc;

//attribute
public class Product {
    private String Name;
    private double price;



    public final static float minimumPrice = 1;
    public final static float maximumPrice = 1000;
    public final static int maxChangePercentage = 20;

    public Product(String name, double price) {
        Name = name;
        this.price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        if(name==null||name.isBlank()){
throw new ModelValExc("The name of the product cant be null");
        }
        Name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {

        if(this.price * (1d + maxChangePercentage /100d) < price||this.price * (1d - maxChangePercentage /100d) > price) {
throw new ModelValExc("The price cant be changed only by 20%");
        }
        if(price < minimumPrice) {
            throw new ModelValExc("Cant be smaller than 1 ");
        }else if(price >maximumPrice){
            throw new ModelValExc("Cant be bigger than 1000 ");
        }


        this.price = price;
    }
}
