package com.kran.functional;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class LambdaTrials {

    public static void main(String[] args) {
        BinaryOperator<Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(2, 3)); 

        BinaryOperation<Integer> operation = (a, b) -> a + b;
        assert 14 == operation.apply(4, 10);  

        Stream.of("a", "b", "c").parallel().forEachOrdered(System.out::print);

          
    }
}