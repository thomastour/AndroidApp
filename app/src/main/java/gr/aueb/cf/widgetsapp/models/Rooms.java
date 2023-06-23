package gr.aueb.cf.widgetsapp.models;

import java.io.Serializable;

public class Rooms implements Serializable {

    private String heading;


    public Rooms(String heading) {
        this.heading = heading;

    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }


}
