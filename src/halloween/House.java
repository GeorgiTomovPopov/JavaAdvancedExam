package halloween;

import java.util.ArrayList;
import java.util.List;

public class House {

    private int capacity;
    private List<Kid> data;


    //•	            Method addKid(Kid kid) – adds an entity to the data if there is an empty space for the kid.
    //•	            Method removeKid(String name) – removes the kid by given name, if such exists, and returns boolean.
    //•	            Method getKid(String street) – returns the kid of a given street or null if no such kid exists.
    //•	            Getter getAllKids() – returns the number of kids.
    //•	getStatistics() – returns a String in the following format:
    //" Children who visited a house for candy:
    //		 {name} from {street} street
    //          {name} from {street} street
    //          (…)"


    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Children who visited a house for candy:");
        for (Kid kid :
                data) {
            stringBuilder.append(String.format("\n%s from %s street", kid.getName(), kid.getStreet()));
        }


        return stringBuilder.toString();
    }

    public int getAllKids() {
        return data.size();
    }


    public Kid getKid(String street) {
        for (Kid kid :
                data) {
            if (kid.getStreet().equals(street)) {
                return kid;
            }
        }

        return null;
    }

    public boolean removeKid(String name) {
        for (Kid kid :
                data) {
            if (kid.getName().equals(name)) {
                data.remove(kid);
                return true;
            }
        }
        return false;
    }

    public void addKid(Kid kid) {
        if (capacity > data.size()) {
            data.add(kid);
        }
    }

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }




}
