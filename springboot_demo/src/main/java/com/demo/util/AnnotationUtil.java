//package com.demo.util;
//
//import com.demo.annotation.DataType;
//import com.demo.annotation.Des;
//import com.demo.annotation.ResponseType;
//import com.demo.bean.MethodBean;
//import com.demo.bean.ParameterBean;
//import com.demo.bean.UrlBean;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.lang.reflect.Parameter;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class AnnotationUtil {
//
//    //    解析所有controller.java
//    public static void validAnnotation(List<Class<?>> clsList) {
//
//        if (clsList != null && clsList.size() > 0) {
//            for (Class<?> cls : clsList) {
//                UrlBean urlBean = new UrlBean();
//                RestController annotation = cls.getAnnotation(RestController.class);
//                if (annotation != null) {
//                    //设置classUrl
//                    urlBean.setClassUrl(annotation.value());
//                }
//                urlBean.setMethodBeans(getMethodUrl(cls));
////                System.out.println("解析结果：" + urlBean);
//
//                try {
//                    System.out.println("解析结果：" + new ObjectMapper().writeValueAsString(urlBean));
//                } catch (JsonProcessingException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    /**
//     * 获取类下所有方法Url
//     *
//     * @param cls
//     * @return
//     */
//    private static Set<MethodBean> getMethodUrl(Class cls) {
//        Set<MethodBean> urlSet = new HashSet<>();
//        //获取类中的所有的方法
//        Method[] methods = cls.getDeclaredMethods();
//        if (methods != null && methods.length > 0) {
//            for (Method method : methods) {
//                MethodBean methodBean = getMethodBean(method);
////                urlSet.add(getRequestBean(,method));
//                urlSet.add(methodBean);
//            }
//        }
//        return urlSet;
//    }
//
//    /**
//     * 获取Method对应的Bean
//     *
//     * @param method
//     * @return
//     */
//    private static MethodBean getMethodBean(Method method) {
//        MethodBean methodBean = new MethodBean();
//        RequestMapping peopleAnnotion = method.getAnnotation(RequestMapping.class);
//
//        if (peopleAnnotion != null) {
//            //可以做权限验证
////                    String[] value = peopleAnnotion.value();
//            //添加方法中url到set中
//            methodBean.setUrl(peopleAnnotion.value()[0]);
//        }
//        methodBean.setRequestSet(getRequestBeans(method));
//        //@TODO 解析ResponseBean
//        methodBean.setResponseSet(getResponseBeans(method));
//        return methodBean;
//    }
//
//    /**
//     * 解析responseBean
//     *
//     * @param method
//     * @return
//     */
//    private static Set<ParameterBean> getResponseBeans(Method method) {
//        ResponseType annotation = method.getAnnotation(ResponseType.class);
//        Class<?> returnType = method.getReturnType();
//        String resultName = null;
//        if (annotation != null) {
//            resultName = annotation.name();
//        }
//        Field[] fields = returnType.getDeclaredFields();
//        Set<ParameterBean> parameterBeanSet = new HashSet<>();
//        for (Field field : fields) {
//            //获取bean中泛型的class
//            if (resultName != null && resultName.equals(field.getName())) {
//                ResponseType annoResponse = method.getAnnotation(ResponseType.class);
//                Class type = annoResponse.type();
//                getClassParamBeans(type, parameterBeanSet);
//            } else {
//                ParameterBean parameterBean = new ParameterBean();
//                parameterBean.setName(field.getName());
//                parameterBean.setType(field.getType().getSimpleName());
//                Des annnoDes = field.getAnnotation(Des.class);
//                if (annnoDes != null) {
//                    parameterBean.setDesc(annnoDes.value());
//                }
//                parameterBeanSet.add(parameterBean);
//            }
//        }
//        return parameterBeanSet;
//    }
//
//
//    /**
//     * 解析请求体字段
//     *
//     * @param method
//     * @return
//     */
//    private static Set<ParameterBean> getRequestBeans(Method method) {
//        Parameter[] parameters = method.getParameters();
//        Set<ParameterBean> requestParameterSet = new HashSet<>();
//        DataType annotationDataType = method.getAnnotation(DataType.class);
//        String dataName = "";
//        Class dataType = null;
//        if (annotationDataType != null) {
//            dataName = annotationDataType.name();
//            dataType = annotationDataType.type();
//        }
//        //获取所有参数
//        for (Parameter p : parameters) {
//            RequestBody annotation1 = p.getAnnotation(RequestBody.class);
//
//            if (annotation1 != null) {
//                //获取class
//                Class<?> type = p.getType();
//                Field[] fields = type.getDeclaredFields();
//                for (Field f : fields) {
//                    ParameterBean parameterBean;
//                    //获取bean中泛型的class
//                    if (dataName != null && dataName.equals(f.getName())) {
//
//
//                        ///////////////////////////////////
////                        try {
////                            Object o = type.newInstance();
////                            Field declaredField = type.getDeclaredField(dataName);
////                            declaredField.setAccessible(true);
////                            declaredField.set(o, dataType.newInstance());
////                            System.out.println("json:" + new ObjectMapper().writeValueAsString(o));
////
////                        } catch (InstantiationException e) {
////                            e.printStackTrace();
////                        } catch (IllegalAccessException e) {
////                            e.printStackTrace();
////                        } catch (NoSuchFieldException e) {
////                            e.printStackTrace();
////                        } catch (JsonProcessingException e) {
////                            e.printStackTrace();
////                        }
//                        ///////////////////////////////////
//
//
//
//                        getClassParamBeans(dataType, requestParameterSet);
//                    } else {
//                        Des annotationDes = f.getAnnotation(Des.class);
//                        parameterBean = new ParameterBean();
//                        parameterBean.setName(f.getName());
//                        parameterBean.setType(f.getType().getSimpleName());
//                        if (annotationDes != null) {
//                            parameterBean.setDesc(annotationDes.value());
//                        }
//                        requestParameterSet.add(parameterBean);
//                    }
//                }
//            }
//        }
//        return requestParameterSet;
//    }
//
//    /**
//     * 获取Class的属性对应的Bean
//     *
//     * @param dataType
//     * @param requestParameterSet
//     * @return
//     */
//    private static Set<ParameterBean> getClassParamBeans(Class dataType, Set<ParameterBean> requestParameterSet) {
//        Field[] dataFields = dataType.getDeclaredFields();
//        for (Field field : dataFields) {
//            ParameterBean parameterBean = new ParameterBean();
//            parameterBean.setName(field.getName());
//            parameterBean.setType(field.getType().getSimpleName());
//            Des annnoDes = field.getAnnotation(Des.class);
//            if (annnoDes != null) {
//                parameterBean.setDesc(annnoDes.value());
//            }
//            requestParameterSet.add(parameterBean);
//        }
//        return requestParameterSet;
//    }
//
//}
