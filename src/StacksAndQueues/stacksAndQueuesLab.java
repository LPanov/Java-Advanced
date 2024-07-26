package StacksAndQueues;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class stacksAndQueuesLab {
    Scanner sc = new Scanner(System.in);

    public void browserHistory() {
        Deque<String> link = new ArrayDeque<>();
        String regex = "https//.+\\..+/";


        while (true) {
            String s = sc.nextLine();
            if (s.equals("Home")) break;

            if (s.equals("back")) {
                if (link.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    link.pop();
                    System.out.println(link.getFirst());
                }
            } else {
                if (s.matches(regex) && !link.contains(s)) {
                    link.addLast(s);
                    System.out.println(link.peekLast());
                } else if (!link.contains(s) && !s.matches(regex)) {
                    link.addFirst(s);
                    System.out.println(link.getFirst());
                } else if (link.contains(s)) {
                    link.push(s);
                    System.out.println(s);
                }
            }
        }
    }
    public void simpleCalculator() {
        Deque<Integer> calc = new ArrayDeque<>();
        String regex = "(?<symbol>\\+|-)* *(?<nums>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        String s = sc.nextLine();
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            if (matcher.group("symbol") == null || matcher.group("symbol").equals("+")){
                calc.add(Integer.parseInt(matcher.group("nums")));
            } else if (matcher.group("symbol").equals("-")) {
                String num = matcher.group("symbol") + matcher.group("nums");
                calc.add(Integer.parseInt(num));
            }
        }

        System.out.println(calc.stream().mapToInt(d -> d).sum());
    }

    public void decimalToBinaryConverter() {
        int dec = Integer.parseInt(sc.nextLine());
        Deque<Integer> binary = new ArrayDeque<>();

        if (dec == 0) binary.add(0);

        while (dec != 0) {
            binary.push(dec % 2);
            dec /= 2;
        }
        while (!binary.isEmpty()) {
            System.out.print(binary.pollFirst());
        }
        //binary.stream().forEach(System.out::print);
    }

    public void matchngBracket() {
        String s = sc.nextLine();
        Deque<Integer> sub = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                sub.push(i);
            } else if (ch == ')') {
                int startIndex = sub.pop();
                String contents = s.substring(startIndex, i + 1);
                System.out.println(contents);
            }
        }
    }

    public  void printerQueue() {
        Deque<String> files = new ArrayDeque<>();
        Deque<String> canceled = new ArrayDeque<>();

        while (true) {
            String s = sc.nextLine();
            if (s.equals("print")) break;

            if (s.equals("cancel")) {
                if (files.isEmpty()) {
                    canceled.offer("Printer is on standby");
                } else {
                    String cancel = "Canceled " + files.pollFirst();
                    canceled.offer(cancel);
                }
            } else {
                files.offer(s);
            }
        }

        canceled.stream().forEach(System.out::println);
        files.stream().forEach(System.out::println);
    }

    public void hotPotato() {
        List<String> kids = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList());
        int n = Integer.parseInt(sc.nextLine());
        Deque<String> removed = new ArrayDeque<>(kids);
        int i = 1;

        while (removed.size() > 1) {
            String person = removed.pollFirst();

            if (i == n) {
                System.out.println("Removed " + person);
                i = 0;
            } else {
                removed.offer(person);
            }
            i++;
        }

        System.out.println("Last is " + removed.pollFirst());
    }
    private boolean isPrime(int n) {
        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    public void mathPotato() {
        List<String> kids = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList());
        int n = Integer.parseInt(sc.nextLine());
        Queue<String> removed = new PriorityQueue<>(kids);

        int i = 1;
        while (removed.size() > 1) {
            if (isPrime(i)) {
                System.out.println("Prime " + removed.peek());
            } else {
                System.out.println("Removed " + removed.poll());
            }
            i++;
        }

        System.out.println("Last is " + removed.poll());
    }

    public void browserHistoryUpgrade() {
        Deque<String> link = new ArrayDeque<>();
        Deque<String> forw = new ArrayDeque<>();

        while (true) {
            String s = sc.nextLine();
            if (s.equals("Home")) break;

            if (s.equals("back")) {
                if (link.size() > 1) {
                    String toRemove = link.pop();
                    forw.push(toRemove);
                    System.out.println(link.peek());
                } else {
                    System.out.println("no previous URLs");
                }

                continue;
            }

            if (s.equals("forward")) {
                if (!forw.isEmpty()) {
                    String something = forw.pop();
                    System.out.println(something);
                    link.push(something);

                } else {
                    System.out.println("no next URLs");
                }
                continue;
            }

            System.out.println(s);
            link.push(s);
            forw.clear();
        }
    }
    public static void main(String[] args) {
        stacksAndQueuesLab sq = new stacksAndQueuesLab();
        sq.browserHistoryUpgrade();
    }
}
