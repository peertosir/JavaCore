package com.peertosir.javacore.chapter15;

interface SomeFunct<T> {
    boolean func(T v1, T v2);
}

class HighTemp {
    private int temp;

    public HighTemp(int temp) {
        this.temp = temp;
    }

    boolean sameTemp(HighTemp ht2) {
        return ht2.temp == this.temp;
    }

    boolean lessThanTemp(HighTemp ht2) {
        return temp < ht2.temp;
    }
}



public class InstanceMethodsWithObjectRefDemo {
    static <T> int counter(T[] vals, SomeFunct<T> f, T v) {
        int count = 0;
        for (int i = 0; i < vals.length; i++) {
            if (f.func(vals[i], v)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int count;
        HighTemp[] weekDayHighs = {
                new HighTemp(89), new HighTemp(82),
                new HighTemp(90), new HighTemp(89),
                new HighTemp(89), new HighTemp(91),
                new HighTemp(84), new HighTemp(83),
        };

        count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(89));
        System.out.println("Days when max temp was 89: " + count);

        HighTemp[] weekDayLows = {
                new HighTemp(32), new HighTemp(12),
                new HighTemp(24), new HighTemp(19),
                new HighTemp(18), new HighTemp(12),
                new HighTemp(-1), new HighTemp(13),
        };

        count = counter(weekDayLows, HighTemp::lessThanTemp, new HighTemp(12));
        System.out.println(count);

    }
}
