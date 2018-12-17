package antanina.app.portalti2016.entity;

import java.io.Serializable;

public class Mahasiswa implements Serializable {
    private int id;

    private String name;
    private String nim;

    public String getName() {
        return name;
    }

    public String getNim() {
        return nim;
    }
    public int getId() {
        return id;
    }
}
