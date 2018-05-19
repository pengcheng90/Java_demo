package util;


import annotation.DataType;
import annotation.Des;
import annotation.ResponseType;
import bean.MethodBean;
import bean.ParameterBean;
import bean.UrlBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnnotationUtil1 {

    //解析所有controller.java
    public static void validAnnotation(List<Class<?>> clsList) {

        if (clsList != null && clsList.size() > 0) {
            for (Class<?> cls : clsList) {
                UrlBean urlBean = new UrlBean();
                RestController annotation = cls.getAnnotation(RestController.class);
                if (annotation != null) {
                    //设置class的url
                    urlBean.setClassUrl(annotation.value());
                }
                urlBean.setMethodBeans(getMethodBeans(cls));
                try {
                    System.out.println("urlBean:" + new ObjectMapper().writeValueAsString(urlBean));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取类对应所有方法bean
     *
     * @param cls
     * @return
     */
    private static Set<MethodBean> getMethodBeans(Class<?> cls) {
        Set<MethodBean> methodBeanSet = new HashSet<>();
        //获取类对应的所有方法
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            MethodBean methodBean = new MethodBean();
            PostMapping annoPostMapping = method.getAnnotation(PostMapping.class);
            if (annoPostMapping != null) {
                methodBean.setUrl(annoPostMapping.value()[0]);
                //设置请求体
                methodBean.setRequestSet(getMethodRequestBeans(method, methodBean));
//                @TODO 设置responseBean
                methodBean.setResponseSet(getMethodReponseBeans(method, methodBean));
                methodBean.setType("POST");
                methodBeanSet.add(methodBean);
            } else {
                GetMapping annoGetMapping = method.getAnnotation(GetMapping.class);
                if (annoGetMapping != null) {
                    methodBean.setUrl(annoGetMapping.value()[0]);
                    //设置请求体
                    methodBean.setRequestSet(getMethodRequestBeans(method, methodBean));
                    methodBean.setResponseSet(getMethodReponseBeans(method, methodBean));
                    methodBean.setType("GET");
                    methodBeanSet.add(methodBean);
                }
            }
        }
        return methodBeanSet;
    }

    /**
     * 获取ResponseBeans
     *
     * @param method
     * @param methodBean
     * @return
     */
    private static Set<ParameterBean> getMethodReponseBeans(Method method, MethodBean methodBean) {
        Set<ParameterBean> parameterBeanSet = new HashSet<>();
        Class<?> returnType = method.getReturnType();
        ResponseType annoResponseType = method.getAnnotation(ResponseType.class);
        String annoNames[] = null;
        Class[] annoClazzs = null;
        if (annoResponseType != null) {
            annoNames = annoResponseType.name();
            annoClazzs = annoResponseType.type();
        }
        getParameBeans(parameterBeanSet, returnType, annoNames, annoClazzs);
//        @TODO 生成json
        getObjectJson(methodBean, returnType, annoClazzs, annoNames, 1);
        return parameterBeanSet;
    }

    /**
     * 获取请求或者响应字段对应的bean
     *
     * @param parameterBeanSet
     * @param returnType
     * @param annoNames
     * @param annoClazzs
     */
    private static void getParameBeans(Set<ParameterBean> parameterBeanSet, Class<?> returnType, String[] annoNames, Class[] annoClazzs) {
        if (annoNames != null && annoNames.length > 0) {
            for (Field field : returnType.getDeclaredFields()) {
                for (int i = 0; i < annoNames.length; i++) {
                    if (annoClazzs != null && field.getName().equals(annoNames[i])) {
//                        获取注解的Class类型
//                        获取泛型上所有属性对应的bean
                        getClassFields(annoClazzs[i], parameterBeanSet);
                    } else {
                        //当前属性为非泛型类型
                        parameterBeanSet.add(getFieldBean(field));
                    }
                }
            }
        } else {
            getClassFields(returnType, parameterBeanSet);
        }
    }

    /**
     * 获取方法对应的请求体
     *
     * @return
     */
    private static Set<ParameterBean> getMethodRequestBeans(Method method, MethodBean methodBean) {
        Set<ParameterBean> parameterBeanSet = new HashSet<>();
//        获取方法上DataType（请求体泛型注解）
        DataType annoDataType = method.getAnnotation(DataType.class);

//        获取方法所有的参数
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            RequestBody annoRequestBody = parameter.getAnnotation(RequestBody.class);
            if (annoRequestBody != null) {//如果标记了RequestBody注解
                Class<?> type = parameter.getType();
//                获取参数的所有属性
                Field[] fields = type.getDeclaredFields();

                Class[] dataTypeClass = null;
                String[] name = null;
                if (annoDataType != null) {
                    dataTypeClass = annoDataType.type();
                    name = annoDataType.name();
                }
                getParameBeans(parameterBeanSet, type, name, dataTypeClass);
                getObjectJson(methodBean, type, dataTypeClass, name, 0);
            }
        }
        return parameterBeanSet;
    }

    /**
     * 根据object（解析出泛型）生成json
     *
     * @param methodBean
     * @param type
     * @param dataTypeClass
     * @param name
     * @param type
     */
    private static void getObjectJson(MethodBean methodBean, Class<?> type, Class[] dataTypeClass, String[] name, int t) {
        //生成请求json模板
        try {
            if (dataTypeClass == null || name == null || dataTypeClass.length < 1 || name.length < 1)
                return;
            Object object = type.newInstance();
            Object obj = null;
            for (int i = name.length - 1; i >= 0; i--) {
                if (obj == null) {
                    obj = dataTypeClass[i].newInstance();
                } else {
                    Object o = dataTypeClass[i].newInstance();
                    Field declaredField = o.getClass().getDeclaredField(name[i + 1]);
                    declaredField.setAccessible(true);
                    declaredField.set(o, obj);
                    obj = o;
                }
            }
            Field declaredField = object.getClass().getDeclaredField(name[0]);
            declaredField.setAccessible(true);
            declaredField.set(object, obj);

            String s = new ObjectMapper().writeValueAsString(object);
            if (t == 0)
                methodBean.setRequestJson(s);
            if (t == 1)
                methodBean.setResponseJson(s);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Class的所有属性对应的beans
     *
     * @param clazz
     * @param parameterBeanSet
     */
    private static void getClassFields(Class clazz, Set<ParameterBean> parameterBeanSet) {
        ParameterBean parameterBean = new ParameterBean();
        /**
         * 判断类型是否为String，或者Integer等类型
         */
        if (clazz.getName().equals(String.class.getName())) {
            parameterBean.setType(String.class.getSimpleName());
            parameterBeanSet.add(parameterBean);
            return;
        } else if (clazz.getName().equals(Integer.class.getName())) {
            parameterBean.setType(String.class.getSimpleName());
            parameterBeanSet.add(parameterBean);
            return;
        } else if (clazz.getName().equals(int.class.getName())) {
            parameterBean.setType(String.class.getSimpleName());
            parameterBeanSet.add(parameterBean);
            return;
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            parameterBeanSet.add(getFieldBean(field));
        }
    }


    /**
     * 获取Field对应的bean
     *
     * @param field
     * @return
     */
    private static ParameterBean getFieldBean(Field field) {
        ParameterBean parameterBean = new ParameterBean();
        parameterBean.setName(field.getName());
        parameterBean.setType(field.getType().getSimpleName());
        Des annoDes = field.getAnnotation(Des.class);
        if (annoDes != null) {
            parameterBean.setDesc(annoDes.value());
        }
        return parameterBean;
    }

}
