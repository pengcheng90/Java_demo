package com.demo.domain;


import annotation.Des;

public class D<T> {
    @Des("字段v1")
    private String v1;
    @Des("字段v2")
    private Integer v2;

    private T dr;

    public String getV1() {
        return v1;
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    public Integer getV2() {
        return v2;
    }

    public void setV2(Integer v2) {
        this.v2 = v2;
    }

    public T getDr() {
        return dr;
    }

    public void setDr(T dr) {
        this.dr = dr;
    }

    @Override
    public String toString() {
        return "D{" +
                "v1='" + v1 + '\'' +
                ", v2=" + v2 +
                ", dr=" + dr +
                '}';
    }
}
