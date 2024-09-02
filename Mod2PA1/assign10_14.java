package Mod2PA1;

public class assign10_14 {
    public static void main(String[] args) {
        MyDate dateObj1 = new MyDate();
        MyDate dateObj2 = new MyDate(34355555133101L);
        MyDate dateObj3 = new MyDate(561555550000L);

        System.out.println("Date 1: " + dateObj1.getYear() + "/" + (dateObj1.getMonth()) + "/" + dateObj1.getDay());
        System.out.println("Date 2: " + dateObj2.getYear() + "/" + (dateObj2.getMonth()) + "/" + dateObj2.getDay());
        System.out
                .println("Example Date: " + dateObj3.getYear() + "/" + (dateObj3.getMonth()) + "/" + dateObj3.getDay());

    }
}
