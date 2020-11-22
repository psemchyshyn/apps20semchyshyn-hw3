package ua.edu.ucu;

import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.DistinctDecorator;
import ua.edu.ucu.smartarr.SmartArray;

public class Main {
    public static void main(String[] args) {
        Object[] els = new Object[] {1, 4, 5, 2, 9, 2, 2};
        SmartArray array = new BaseArray(els);
        array = new DistinctDecorator(array);
        System.out.println(array.size());
    }
}
