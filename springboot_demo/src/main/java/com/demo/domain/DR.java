package com.demo.domain;


import annotation.Des;

public class DR {
    @Des("字段v3")
    private String v3;
    @Des("字段v4")
    private Integer v4;

    public String getV3() {
        return v3;
    }

    public void setV3(String v3) {
        this.v3 = v3;
    }

    public Integer getV4() {
        return v4;
    }

    public void setV4(Integer v4) {
        this.v4 = v4;
    }

    @Override
    public String toString() {
        return "DR{" +
                "v3='" + v3 + '\'' +
                ", v4=" + v4 +
                '}';
    }
}
