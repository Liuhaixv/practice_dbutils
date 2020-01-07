package day09;

public class Master {
    String name;
    long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Master{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
