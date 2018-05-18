package bean;

import java.util.Set;

public class UrlBean {
    //controller的url
    String classUrl;
    //controller对应method的url
    Set<MethodBean> methodBeans;

    public String getClassUrl() {
        return classUrl;
    }

    public void setClassUrl(String classUrl) {
        this.classUrl = classUrl;
    }

    public Set<MethodBean> getMethodBeans() {
        return methodBeans;
    }

    public void setMethodBeans(Set<MethodBean> methodBeans) {
        this.methodBeans = methodBeans;
    }

    @Override
    public String toString() {
        return "UrlBean{" +
                "classUrl='" + classUrl + '\'' +
                ", methodBeans=" + methodBeans +
                '}';
    }
}
