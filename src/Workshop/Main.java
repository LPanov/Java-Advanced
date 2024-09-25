package Workshop;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addFirst(1);
        doublyLinkedList.addFirst(2);
        doublyLinkedList.addLast(3);
        System.out.println(doublyLinkedList.removeFirst());
        System.out.println(doublyLinkedList.removeLast());
        System.out.println(doublyLinkedList.get(0));
        doublyLinkedList.forEach(System.out::println);
    }
}
