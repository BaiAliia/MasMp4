package constraints.Obj;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;

public class ObjectPlus implements Serializable {
    protected static Hashtable extents = new Hashtable();

    public ObjectPlus() {
        Vector extent = null;
        Class theClass = this.getClass();

        if(extents.containsKey(theClass)) {
            extent = (Vector) extents.get(theClass);
        }
        else {
            extent = new Vector();
            extents.put(theClass, extent);
        }

        extent.add(this);
    }

    public static void writeExtents(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extents);
    }

    public static void readExtents(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extents = (Hashtable) stream.readObject();
    }

    public static void showExtent(Class cl) throws Exception {
        Vector extent = null;

        if(extents.containsKey(cl)) {
            extent = (Vector) extents.get(cl);
        }
        else {
            throw new Exception("The class unknown " + cl);
        }

        System.out.println("Extent of the class: " + cl.getSimpleName());

        for(Object obj : extent) {
            System.out.println(obj);
        }
    }
}
