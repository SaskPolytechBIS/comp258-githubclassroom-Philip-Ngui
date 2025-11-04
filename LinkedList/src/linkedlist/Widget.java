package linkedlist;

public class Widget implements Comparable<Widget> {

    private int id;
    private String name;
    private int amount;

    public Widget(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Widget otherWidget) {
            return this.id == otherWidget.id;
        }
        return false;
    }

    @Override
    public int compareTo(Widget other) {
        return Integer.compare(this.amount, other.amount);
    }

    @Override
    public String toString() {
        return "Widget#" + id + ": " + name + " (" + amount + ")";
    }

}
