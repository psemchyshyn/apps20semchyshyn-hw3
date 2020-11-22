package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        MyPredicate predicate = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getYear() == 2 && ((Student) t).getGPA() >= 4;
            }
        };

       MyComparator cmp = new MyComparator() {
           @Override
           public int compare(Object o1, Object o2) {
               String first = ((Student) o1).getSurname() ;
               String second = ((Student) o2).getSurname();

               if (first.length() > second.length()) {
                   return 1;
               } else if (second.length() > first.length()) {
                   return -1;
               } else {
                   for (int i = 0; i < second.length(); i++) {
                       if (first.charAt(i) > second.charAt(i)) {
                           return 1;
                       } else if (second.charAt(i) > first.charAt(i)) {
                           return -1;
                       }
                   }
               }
               return 0;
           }
       };

       MyFunction function = new MyFunction() {
           @Override
           public Object apply(Object t) {
               return ((Student) t).getSurname() + " " + ((Student) t).getName();
           }
       };

       SmartArray studentSmartArray = new BaseArray(students);
       studentSmartArray = new MapDecorator(new SortDecorator(new FilterDecorator(
               new DistinctDecorator(studentSmartArray), predicate), cmp), function);
        Object[] result = studentSmartArray.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
