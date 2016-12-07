package agricultural.nxt.agriculturalsupervision.entity;

/**
 * Created by huqiang on 2016/12/7 16:25.
 */

public class SeachResult {
    private int id;
    private String name;
    private String species;
    private String unit;

    public SeachResult(int id, String name, String species, String unit) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.unit = unit;
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
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "SeachResult{" +
                "unit='" + unit + '\'' +
                ", species='" + species + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
