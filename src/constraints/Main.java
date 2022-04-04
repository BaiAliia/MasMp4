package constraints;


public class Main {
    //Subset - Student Group
    //Bag-
    //Custom -
    //ordered- employee purchase
    //Student =unique
    //attribute-product
    //Xor student Group Project
    public static void main(String ags[]) {

        // Unique
        Student s1 = new Student(19239, "Aliia");
        //s1.setSnumber(19237);
        Student s2 = new Student(19237, "Jasmin");
        Student s3 = new Student(1500, "Adik");

        System.out.println(s3.getClass().getName());
        for (Integer a : Student.getSnumbers()) {
            System.out.println(a);
        }
        System.out.println(Student.getExtent().size());
        Student.removeSt(s3);
        System.out.println(Student.getExtent().size());

        for (Integer a : Student.getSnumbers()) {
            System.out.println(a);
        }
        System.out.println("__________");

        //Subset student group
        Group g1 = new Group(12, "c12");
        Project p1 = new Project(2, "Gameghskb");



        try {
            s1.addLink(Student.belongsto, Group.ConsistOf, g1);

            if (s1.isLink(Student.belongsto, g1)) {
               s1.addLink(Student.manages, Group.managedby, g1);
            } else {
                System.out.println("No super link for the role: " + Student.belongsto);

            }

            s1.showLinks(System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("__________");

        //Xor
        Group g2 = new Group(14, "c14");
        Project p2 = new Project(4, "hfjc");

        Student st= new Student(15,"Mifelos", g2);
 //       st.setProject(p2);


        //for an attribute

        Product pro1 = new Product("Kurut", 100);
        Product pro2 = new Product("Shoro", 200);

        pro1.setPrice(115);

        System.out.println("__________");
        //Ordered Empoyee purchase
        Employee emp=new Employee("Adil",235,5000);
        Purchase pu1=new Purchase(842,"Alika");
        Purchase pu2=new Purchase(294,"Alina");
        emp.addPurchase(pu1);
        emp.addPurchase(pu2);



    }

}