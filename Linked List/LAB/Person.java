package LAB;

import java.util.Objects;

public class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    public static void main(String[] args) {
        LinkedList<Person> list = new LinkedList<>();

        list.addFirst(new Person("Alice", "123 Maple St"));
        list.addLast(new Person("Bob", "456 Oak St"));
        list.addNode(new Person("Charlie", "789 Pine St"), 2);

        list.removeNode(new Person("Alice", "123 Maple St")); 
        int nodeIndex = list.findNode(new Person("Bob", "456 Oak St"));

        if (nodeIndex != -1) {
            System.out.println("Value found at Node " + nodeIndex);
        } else {
            System.out.println("Value not found");
        }
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(name, person.name) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', address='" + address + "'}";
    }
}