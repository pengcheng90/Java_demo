package bean;

import java.util.HashSet;
import java.util.Set;

public class MethodBean {
    //    请求类型（get，post）
    String type;
    //url
    String url;
    //    请求json模板
    String requestJson;
    String responseJson;
    //request请求参数
    Set<ParameterBean> requestSet = new HashSet<>();
    //reponse字段
    Set<ParameterBean> responseSet = new HashSet<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestJson() {
        return requestJson;
    }

    public void setRequestJson(String requestJson) {
        this.requestJson = requestJson;
    }

    public String getResponseJson() {
        return responseJson;
    }

    public void setResponseJson(String responseJson) {
        this.responseJson = responseJson;
    }

    public Set<ParameterBean> getRequestSet() {
        return requestSet;
    }

    public void setRequestSet(Set<ParameterBean> requestSet) {
        this.requestSet = requestSet;
    }

    public Set<ParameterBean> getResponseSet() {
        return responseSet;
    }

    public void setResponseSet(Set<ParameterBean> responseSet) {
        this.responseSet = responseSet;
    }

    @Override
    public String toString() {
        return "MethodBean{" +
                "type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", requestJson='" + requestJson + '\'' +
                ", responseJson='" + responseJson + '\'' +
                ", requestSet=" + requestSet +
                ", responseSet=" + responseSet +
                '}';
    }
}
