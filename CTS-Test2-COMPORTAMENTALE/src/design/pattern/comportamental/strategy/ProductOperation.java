package design.pattern.comportamental.strategy;

import java.util.List;

public class ProductOperation implements Operation{
    @Override
    public Double compute(List<Integer> values) {
        double product = 1;
        for(Integer i: values){
            product *= i;
        }
        return product;
    }
}
