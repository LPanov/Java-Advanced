package StacksAndQueues;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class StacksAndQueuesExercise {
    Scanner sc = new Scanner(System.in);

    public void reverseNumberWithStack() {
        List<Integer> nums = Arrays
                .stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Deque<Integer> numbers = new ArrayDeque<>(nums);
        while (!numbers.isEmpty()) {
            System.out.print(numbers.removeLast() + " ");
        }
    }

    public void basicStackOperations() {
        String[] commands = sc.nextLine().split("\\s+");
        int pushes = Integer.parseInt(commands[0]);
        int pops = Integer.parseInt(commands[1]);
        int contain = Integer.parseInt(commands[2]);

        List<Integer> nums = Arrays
                .stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Deque<Integer> elements = new ArrayDeque<>();
        if (nums.size() <= pushes) {
            for (int i = 0; i < pushes; i++) {
                elements.push(nums.get(i));
            }
        } else {
            for (int i = 0; i < nums.size(); i++) {
                elements.push(nums.get(i));
            }
        }

        if (pops <= elements.size()) {
            for (int i = 0; i < pops; i++) {
                elements.pop();
            }
        }

        if (elements.contains(contain)) {
            System.out.println("true");
        } else {
            if (elements.isEmpty()) System.out.println(0);
            else {
                final int[] smallest = {elements.getFirst()};
                elements.forEach(e -> {
                    if (e < smallest[0]) smallest[0] = e;
                });
                System.out.println(smallest[0]);
            }
        }
    }

    public void maximumElement() {
        int n = Integer.parseInt(sc.nextLine());
        Deque<Integer> nums = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().split("\\s+");
            if (t[0].equals("1")) {
                int numToAdd = Integer.parseInt(t[1]);
                nums.push(numToAdd);
            }
            else if (t[0].equals("2")) {
                nums.pop();
            }
            else if (t[0].equals("3")) {
                nums.stream().max(Integer::compareTo).ifPresent(System.out::println);
            }
        }
    }

    public void basicQueueOperations() {
        String[] commands = sc.nextLine().split("\\s+");
        int pushes = Integer.parseInt(commands[0]);
        int pops = Integer.parseInt(commands[1]);
        int contain = Integer.parseInt(commands[2]);

        List<Integer> nums = Arrays
                .stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Deque<Integer> elements = new ArrayDeque<>();
        if (nums.size() <= pushes) {
            for (int i = 0; i < pushes; i++) {
                elements.add(nums.get(i));
            }
        } else {
            for (int i = 0; i < nums.size(); i++) {
                elements.add(nums.get(i));
            }
        }

        if (pops <= elements.size()) {
            for (int i = 0; i < pops; i++) {
                elements.poll();
            }
        }

        if (elements.contains(contain)) {
            System.out.println("true");
        } else {
            if (elements.isEmpty()) System.out.println(0);
            else {
                elements.stream().min(Integer::compareTo).ifPresent(System.out::println);
            }
        }
    }
    public void balancedParentheses() {
        Deque<Character> parentheses = new ArrayDeque<>();
        boolean areBalanced = false;
        String s = sc.nextLine();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                parentheses.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (parentheses.isEmpty()) {
                    areBalanced = false;
                    break;
                }

                char lastOpen = parentheses.pop();

                if (lastOpen == '(' && ch == ')') {
                    areBalanced = true;
                }
                else if (lastOpen == '[' && ch == ']') {
                    areBalanced = true;
                }
                else if (lastOpen == '{' && ch == '}') {
                    areBalanced = true;
                } else {
                    areBalanced = false;
                    break;
                }
            }
        }

        if (areBalanced) System.out.println("YES");
        else System.out.println("NO");
        //parentheses.forEach(System.out::print);
    }
    private long[] term = new long[1000];
    private long fibonacci(int n) {
        if (n <= 1)
            return 1;

        if (term[n] != 0)
            return term[n];

        else {
            term[n] = fibonacci(n - 1) + fibonacci(n - 2);
            return term[n];
        }
    }
    public void recursiveFibonacci() {
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(fibonacci(n));
    }

    public void simpleTextEditor() {
        Deque<String> editor = new ArrayDeque<>();
        int n = Integer.parseInt(sc.nextLine());
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().split("\\s+");
            int command = Integer.parseInt(t[0]);

            if (command == 1) {
                if (editor.isEmpty()) {
                    editor.addLast(t[1]);
                } else {
                    String add = editor.getLast() + t[1];
                    editor.addLast(add);
                }
            } else if (command == 2) {
                int count = Integer.parseInt(t[1]);
                String erase = editor.getLast().substring(0,editor.getLast().length()-count);
                editor.addLast(erase);
            } else if (command == 3) {
                int pos = Integer.parseInt(t[1]) - 1;
                System.out.println(editor.getLast().charAt(pos));
            } else if (command == 4) {
                if (!editor.isEmpty()) {
                    editor.removeLast();
                }
            }

            //editor.forEach(System.out::println);
        }
    }

    private boolean letterOrDigit(char c)
    {
        // boolean check
        if (Character.isLetterOrDigit(c))
            return true;
        else
            return false;
    }

    private int getPrecedence(char ch)
    {

        if (ch == '+' || ch == '-')
            return 1;
        else if (ch == '*' || ch == '/')
            return 2;
        else if (ch == '^')
            return 3;
        else
            return -1;
    }

    // Operator has Left --> Right associativity
    private boolean hasLeftAssociativity(char ch) {
        if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
            return true;
        } else {
            return false;
        }
    }

    public void infixToPostfix() {
        String[] expression = sc.nextLine().split("\\s+");
        Stack<String> stack = new Stack<>();

        String output = new String("");

        for (int i = 0; i < expression.length; ++i) {
            String c = expression[i];

            if (letterOrDigit(c.charAt(0)))
                output += c + " ";

            else if (c.equals("("))
                stack.push(c);
            else if (c.equals(")")){
                while (!stack.isEmpty()
                        && !stack.peek().equals("(")) {
                    output += stack.pop() + " ";
                }
                stack.pop();
            }

            else {
                while (
                        !stack.isEmpty()
                                && getPrecedence(c.charAt(0))
                                <= getPrecedence(stack.peek().charAt(0))
                                && hasLeftAssociativity(c.charAt(0))) {

                    output += stack.pop() + " ";
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            output += stack.pop() + " ";
        }
        System.out.println(output);
    }

    private boolean hasBigger(List<Integer> check) {
        for (int i = 0; i < check.size(); i++) {
            if (i > 0 && check.get(i) > check.get(i - 1)) return true;
        }
        return  false;
    }
    private Deque<Integer> getPosition (List<Integer> plants) {
        Deque<Integer> positions = new ArrayDeque<>();
        for (int i = 0; i < plants.size(); i++) {
            if (i > 0 && plants.get(i) > plants.get(i - 1)) {
                positions.push(i);
            }
        }
        return positions;
    }
    public void poisonousPlants() {
        int n = Integer.parseInt(sc.nextLine());
        List<Integer> plants = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int days = 0;

        while (hasBigger(plants)) {
            Deque<Integer> plantsToDie = getPosition(plants);

            while(!plantsToDie.isEmpty()) {
                int plantToDie = plantsToDie.removeFirst();
                plants.remove(plantToDie);
            }
            days++;
        }

        System.out.println(days);

    }



    public static void main(String[] args) {
        StacksAndQueuesExercise sqe = new StacksAndQueuesExercise();
        sqe.poisonousPlants();
    }
}
