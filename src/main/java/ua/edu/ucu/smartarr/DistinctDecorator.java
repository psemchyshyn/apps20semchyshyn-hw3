package ua.edu.ucu.smartarr;

import java.util.HashSet;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    private HashSet set;

    public DistinctDecorator(SmartArray sa) {
        super(sa);
        set = new HashSet();
    }

    private int numOfUniqueEl() {
        int num = 0;
        Object[] oldArr = smartArray.toArray();
        for (int i = 0; i < oldArr.length; i++) {
            if (set.add(oldArr[i])) {
                num++;
            }
        }
        set.clear();
        return num;
    }

    @Override
    public Object[] toArray() {
        Object[] oldArr = smartArray.toArray();
        Object[] newArr = new Object[numOfUniqueEl()];
        int cnt = 0;
        for (int i = 0; i < oldArr.length; i++) {
            if (set.add(oldArr[i])) {
                newArr[cnt++] = oldArr[i];
            }
        }
        set.clear();
        return newArr;
    }

    @Override
    public String operationDescription() {
        return "Distinct elements decorator";
    }

    @Override
    public int size() {
        return numOfUniqueEl();
    }
}
