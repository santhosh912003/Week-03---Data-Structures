public class Student_Record {
    public static void main(String[] args) {
        Operations ops = new Operations();
        ops.add(new Student(1, "Alice", 20, 'A'));
        ops.add(new Student(2, "Bob", 21, 'B'));
        ops.addAtBeginning(new Student(3, "Charlie", 19, 'C'));
        ops.addAtPosition(new Student(4, "David", 22, 'B'), 2);
        ops.display();
        ops.search(2);
        ops.updateGrade(1, 'S');
        ops.delete(3);
        System.out.println("\nAfter updates:");
        ops.display();
    }
}

class Student {
    int r_no;
    String name;
    int age;
    char grade;

    Student(int r_no, String name, int age, char grade) {
        this.r_no = r_no;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}

class Node {
    Student data;
    Node next;

    Node(Student data) {
        this.data = data;
        this.next = null;
    }
}

class Operations {
    Node head = null;

    public void add(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    public void addAtBeginning(Student student) {
        Node newNode = new Node(student);
        newNode.next = head;
        head = newNode;
    }

    public void addAtPosition(Student student, int pos) {
        if (pos <= 1 || head == null) {
            addAtBeginning(student);
            return;
        }
        Node temp = head;
        int count = 1;
        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }
        Node newNode = new Node(student);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void delete(int r_no) {
        if (head == null) return;
        if (head.data.r_no == r_no) {
            head = head.next;
            return;
        }
        Node curr = head;
        while (curr.next != null && curr.next.data.r_no != r_no)
            curr = curr.next;
        if (curr.next != null)
            curr.next = curr.next.next;
    }

    public void search(int r_no) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.r_no == r_no) {
                System.out.println("Found: " + temp.data.name);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Not Found: " + r_no);
    }

    public void updateGrade(int r_no, char newGrade) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.r_no == r_no) {
                temp.data.grade = newGrade;
                return;
            }
            temp = temp.next;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            Student s = temp.data;
            System.out.println("Roll: " + s.r_no + ", Name: " + s.name + ", Age: " + s.age + ", Grade: " + s.grade);
            temp = temp.next;
        }
    }
}


