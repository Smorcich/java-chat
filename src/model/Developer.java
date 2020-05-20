package model;
public class Developer {
    private int id;
    private String name;

    /**
     * Default Constructor
     */
    public Developer() {
    }

    /**
     * Plain constructor
     */
    public Developer(int id, String name) {
        this.id = id;
        this.name = name;
    }


    /**
     * Getters and Setters
     */
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

    /**
     * toString method (optional)
     */
    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
