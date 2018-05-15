package com.demo.util;

import com.demo.annotation.DataType;
import com.demo.annotation.Des;
import com.demo.domain.D;
import com.demo.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnnotationUtil {

    //    解析所有controller.java
    public static void validAnnotation(List<Class<?>> clsList) throws JsonProcessingException, IllegalAccessException, InstantiationException {

        if (clsList != null && clsList.size() > 0) {
            Set<String> urls = new HashSet();
            String sUrl = new String();

            for (Class<?> cls : clsList) {
                RestController annotation = cls.getAnnotation(RestController.class);
                if (annotation != null) {
                    sUrl = annotation.value();
//                    System.out.println("类上注解：" + annotation.value());
                }
                //获取类中的所有的方法
                Method[] methods = cls.getDeclaredMethods();
                if (methods != null && methods.length > 0) {

                    Set<FiledDes> filedDesSet = null;
                    for (Method method : methods) {
                        filedDesSet = new HashSet<>();
                        String dataName = "";
                        Class dataType = null;
                        RequestMapping peopleAnnotion = method.getAnnotation(RequestMapping.class);
                        DataType annotationDataType = method.getAnnotation(DataType.class);
                        if (annotationDataType != null) {
                            dataName = annotationDataType.name();
                            dataType = annotationDataType.type();
                        }
                        if (peopleAnnotion != null) {
                            //可以做权限验证
                            String[] value = peopleAnnotion.value();
                            urls.add(sUrl + value[0]);
                            for (String s : value) {
//                                System.out.println("method上注解：" + s);
                            }
                        }
                        //获取所有参数
                        Parameter[] parameters = method.getParameters();
                        for (Parameter p : parameters) {
                            RequestBody annotation1 = p.getAnnotation(RequestBody.class);
                            if (annotation1 != null) {
                                //获取class
                                Class<?> type = p.getType();
                                Field[] fields = type.getDeclaredFields();
                                for (Field f : fields) {
                                    FiledDes filedDes;

                                    //获取bean中泛型的class
                                    if (dataName != null && dataName.equals(f.getName())) {
                                        Field[] dataFields = dataType.getDeclaredFields();
                                        for (Field field : dataFields) {
                                            filedDes = new FiledDes();
                                            filedDes.setName(field.getName());
                                            filedDes.setType(field.getType().getSimpleName());
                                            Des annotationDes = field.getAnnotation(Des.class);
                                            if (annotationDes != null) {
                                                //获取field类型，field.getType().getSimpleName()
                                                filedDes.setDesc(annotationDes.value());
                                            }
                                            filedDesSet.add(filedDes);
                                            System.out.println("filedDes:" + filedDes.toString());
                                        }
                                    } else {
                                        Des annotationDes = f.getAnnotation(Des.class);
                                        filedDes = new FiledDes();
                                        filedDes.setName(f.getName());
                                        filedDes.setType(f.getType().getSimpleName());
                                        if (annotationDes != null) {
                                            filedDes.setDesc(annotationDes.value());
                                        }
                                        filedDesSet.add(filedDes);
                                        System.out.println("filedDes:" + filedDes);
                                    }
                                }
                                //生成json example
                                ObjectMapper objectMapper = new ObjectMapper();
                                Object o = type.newInstance();
                                String result = objectMapper.writeValueAsString(o);
                                if (dataType != null) {
                                    String dataStr = objectMapper.writeValueAsString(dataType.newInstance());
                                    try {
                                        Field field = o.getClass().getDeclaredField(dataName);
                                        field.setAccessible(true);
                                        field.set(o,dataType.newInstance());
                                    } catch (NoSuchFieldException e) {
                                        e.printStackTrace();
                                    }
                                }
                                result.replace( "{", "sssss");
                                System.out.println("parameter:" + result);
                            }
                        }
                    }
                }
            }
            System.out.println("all urls:" + urls);
        }
    }

}
