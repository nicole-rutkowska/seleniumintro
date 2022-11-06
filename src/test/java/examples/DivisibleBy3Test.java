package examples;

import java.util.ArrayList;
import java.util.List;

public class DivisibleBy3Test {
    public static List<Integer> divideBy3(List<Integer> numbers){
        List<Integer> list = new ArrayList<>();

        for(int i=0; i < numbers.size(); i++){
            if(numbers.get(i) % 3 == 0){
                list.add(numbers.get(i));
            }
        }

        return list;
    }
    public static void main(String[] args){
        List<Integer> checkThis = new ArrayList<>();
        checkThis.add(3);
        checkThis.add(5);
        checkThis.add(9);
        checkThis.add(10);

        List<Integer> result = new ArrayList<>();
        result = divideBy3(checkThis);

        System.out.println(result);
    }
}
