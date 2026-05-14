package del.alstrudat;

public class Program {

    class Node {
        String key;
        String value;
        Node next;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node[] table;
    private static final int TABLE_SIZE = 10;

    public Program() {
        table = new Node[TABLE_SIZE];
    }

    private int hashFunction(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += (int) key.charAt(i);
        }
        return sum % TABLE_SIZE;
    }

    public void insert(String key, String value) {
        int index = hashFunction(key);
        Node current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
    }

    public String search(String key) {
        int index = hashFunction(key);
        Node current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return "FOUND: " + key + " = " + current.value;
            }
            current = current.next;
        }

        return "NOT FOUND: " + key;
    }

    public void delete(String key) {
        int index = hashFunction(key);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void display() {
        boolean hasItem = false;

        for (int i = 0; i < TABLE_SIZE; i++) {
            Node current = table[i];
            while (current != null) {
                System.out.println(current.key + "=" + current.value);
                hasItem = true;
                current = current.next;
            }
        }

        if (!hasItem) {
            System.out.println("EMPTY");
        }
    }

    public int count() {
        int total = 0;
        for (int i = 0; i < TABLE_SIZE; i++) {
            Node current = table[i];
            while (current != null) {
                total++;
                current = current.next;
            }
        }
        return total;
    }
}