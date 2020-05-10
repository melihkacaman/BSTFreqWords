package main;

public class smalltest {
    public static void main(String[] args) {
        String a="b";
        String b="a";
        int compare = a.compareTo(b);
        if (compare < 0){
            System.out.println(a+" is before "+b);
        }
        else if (compare > 0) {
            System.out.println(b+" is before "+a);
        }
        else {
            System.out.println(b+" is same as "+a);
        }
    }
}
