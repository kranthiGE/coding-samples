package com.kran.functional;

@FunctionalInterface
public interface BinaryOperation<T extends Number> {

    T apply(T a, T b);
}