package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{
    private MyPredicate predicate;

    public FilterDecorator(SmartArray sa, MyPredicate pr) {
        super(sa);
        predicate = pr;

    }

    private int numOfElementsInFiltered() {
        int num = 0;
        Object[] arr = smartArray.toArray();
        for (int i = 0; i < smartArray.size(); i++) {
            if (predicate.test(arr[i])) {
                num++;
            }
        }
        return num;
    }

    @Override
    public Object[] toArray() {
        Object[] oldArr = smartArray.toArray();
        Object[] newArr = new Object[numOfElementsInFiltered()];
        int cnt = 0;
        for (int i = 0; i < smartArray.size(); i++) {
            if (predicate.test(oldArr[i])) {
                newArr[cnt++] = oldArr[i];
            }
        }
        return newArr;
    }

    @Override
    public String operationDescription() {
        return "Filtering decorator of the Smart Array";
    }

    @Override
    public int size() {
        return numOfElementsInFiltered();
    }
}
