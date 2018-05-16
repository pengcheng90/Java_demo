package com.demo.util;

import com.demo.annotation.DataType;
import com.demo.annotation.Des;
import com.demo.bean.MethodBean;
import com.demo.bean.ParameterBean;
import com.demo.bean.UrlBean;
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

    //    解析所有controller.java
    public static void validAnnotation(List<Class<?>> clsList) {

        if (clsList != null && clsList.size() > 0) {
            for (Class<?> cls : clsList) {
                UrlBean urlBean = new UrlBean();
                RestController annotation = cls.getAnnotation(RestController.class);
                if (annotation != null) {
//    设置class的url
                    urlBean.setClassUrl(annotation.value());
                }
                urlBean.setMethodBeans(getMethodBeans(cls));
                System.out.println("urlBean:" + urlBean);
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
//       获取类对应的所有方法
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            MethodBean methodBean = new MethodBean();
            PostMapping annoPostMapping = method.getAnnotation(PostMapping.class);
            if (annoPostMapping != null) {
                methodBean.setUrl(annoPostMapping.value()[0]);
//                设置请求体
                methodBean.setRequestSet(getMethodRequestBeans(method, methodBean));
                methodBean.setType("POST");
                methodBeanSet.add(methodBean);
            } else {
                GetMapping annoGetMapping = method.getAnnotation(GetMapping.class);
                if (annoGetMapping != null) {
                    methodBean.setUrl(annoGetMapping.value()[0]);
                    //                设置请求体
                    methodBean.setRequestSet(getMethodRequestBeans(method, methodBean));
                    methodBean.setType("GET");
                    methodBeanSet.add(methodBean);
                }
            }
        }
        return methodBeanSet;
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

                Class[] dataTypeClass = annoDataType.type();
                String[] name = annoDataType.name();

                for (Field field : fields) {
                    if (name != null && name.length > 0) {
                        for (int i = 0; i < name.length; i++) {
                            if (annoDataType != null && field.getName().equals(name[i])) {
//                        获取注解的Class类型
//                        获取泛型上所有属性对应的bean
                                getClassFields(dataTypeClass[i], parameterBeanSet);
                            } else {
                                //当前属性为非泛型类型
                                parameterBeanSet.add(getFieldBean(field));
                            }
                        }
                    }
                }

                //生成请求json模板
                try {
                    Object o = type.newInstance();
                    Class type1 = dataTypeClass[0];

                    if (name != null && name.length > 0) {
                        for (int i = 0; i < name.length; i++) {
                            Field declaredField = type.getDeclaredField(name[i]);
                            declaredField.setAccessible(true);
                            Object o1 = type1.newInstance();
                            declaredField.set(o, o1);
                            if (i + 1 < name.length) {
                                o = o1;
                                type1 = dataTypeClass[i + 1];
                                type = type1;
                            }
                        }
                    }
                    System.out.println(new ObjectMapper().writeValueAsString(o));
                    methodBean.setRequestJson(new ObjectMapper().writeValueAsString(o));
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
        }
        return parameterBeanSet;
    }

    private static void getClassFields(Class clazz, Set<ParameterBean> parameterBeanSet) {
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
