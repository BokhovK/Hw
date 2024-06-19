import java.util.*;

class Scratch {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        List<String> words = new ArrayList<>(List.of("test", "te", "test", "tes", "te", "te", "t"));
        task1(nums);
        task2(nums);
        task3(words);
        task4(words);
    }

    private static void task1(List<Integer> list) {
        System.out.println("Task 1");
        for (Integer number : list) {
            if (number % 2 != 0) {
                System.out.print(number+ " ");
            }
        }
        System.out.println();
    }

    private static void task2(List<Integer> list) {
        System.out.println("Task 2");
        Set<Integer> set = new TreeSet<>(list);
        for (Integer number : set) {
            if (number % 2 == 0) {
                System.out.print(number+ " ");
            }
        }
        System.out.println();
    }

    private static void task3(List<String> list) {
        System.out.println("Task 3");
        Set<String> set = new HashSet<>(list);
        for (String words : set) {

            System.out.print(words+" ");
        }
        System.out.println();
    }
    private static void task4(List<String> list) {
        System.out.println("Task 4");
        Set<String> set = new HashSet<>(list);
        for (String words : set) {

            System.out.print(words + "->" + Collections.frequency(list, words));
        }
    }
}