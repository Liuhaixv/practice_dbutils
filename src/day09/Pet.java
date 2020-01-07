package day09;

public class Pet {
    String name, color;
    long id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "±àºÅ:" + id + "\t" + "Ãû×Ö:" + name + "\t" + "ÑÕÉ«:" + color;
    }
}
