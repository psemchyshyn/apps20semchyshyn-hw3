package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator cmp;
    public SortDecorator(SmartArray sa, MyComparator cmp) {
        super(sa);
        this.cmp = cmp;
    }

    @Override
    public Object[] toArray() {
        Object[] newArr = smartArray.toArray();
        Arrays.sort(newArr, cmp);
        return newArr;
    }

    @Override
    public String operationDescription() {
        return "Sorting decorator";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
