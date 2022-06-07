package com.kran.functional;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public final class Calculator<T extends Number> {

    public final Map<String, BinaryOperator<T>> operatorMap = new HashMap<>();

    public void registerOperation(final String operator, final BinaryOperator<T> binaryOperator) {
        operatorMap.put(operator, binaryOperator);
    }

    public T calculate(T a, String operator, T b){
        return operatorMap.get(operator).apply(a, b);
    }
}