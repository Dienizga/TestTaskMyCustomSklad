package com.example.customwarehousetask.api.converter;

public interface Converter <S,T> {
    T convert(S source);
}
