package design.pattern.comportamental.strategy;

import java.util.List;

public class SumOperation implements Operation{
    @Override
    public Double compute(List<Integer> values) {
        double sum = 0;
        for(Integer i: values){
            sum += i;
        }
        return sum;
    }
}
