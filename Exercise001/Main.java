package Seminar003.CW.Seminar.Exercise001;

public class Main {
    public static void main(String[] args) {
        OneWayList<Integer> list = new OneWayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("list = " + list);

        list.reverse();

        for (Integer value: list) {
            System.out.print(value + " ");
        }
    }
}
