package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{
    private MyFunction function;

    public MapDecorator(SmartArray sa, MyFunction fn) {
        super(sa);
        function = fn;

    }
    @Override
    public Object[] toArray() {
        Object[] oldArr = smartArray.toArray();
        Object[] newArr = new Object[smartArray.size()];
        for (int i = 0; i < oldArr.length; i++) {
            newArr[i] = function.apply(oldArr[i]);
        }
        return newArr;
    }

    @Override
    public String operationDescription() {
        return "Mapping decorator";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
