//package com.demo;
//
//import bean.MethodBean;
//import bean.ParameterBean;
//import bean.UrlBean;
//import util.AnnotationUtil;
//import util.ClassUtil;
//import util.JsonFormatUtil;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.util.List;
//import java.util.Set;
//
//public class Api2Doc {
//    public static void main(String[] args) throws Exception {
//        // 获取特定包下所有的类(包括接口和类)
//        List<Class<?>> clsList = ClassUtil.getAllClassByPackageName(com.handarui.apimanager.action.CustomErrorController.class.getPackage());
//        //List<Class<?>> clsList = ClassUtil.getAllClassByPackageName(Package.getPackage("./action"));
//        //输出所有使用了特定注解的类的注解值
//        List<UrlBean> urlBeans = AnnotationUtil.validAnnotation(clsList);
//        for (UrlBean urlBean : urlBeans) {
//            String desc = urlBean.getDesc();
//            if (desc != null) {
//                File file = new File(urlBean.getDesc());
//                boolean newFile = file.createNewFile();
//                String absolutePath = file.getAbsolutePath();
//                Set<MethodBean> methodBeans = urlBean.getMethodBeans();
//                for (MethodBean methodBean : methodBeans) {
//                    String methodDes = methodBean.getDesc();
//                    String url = "~basePath/" + urlBean.getClassUrl() + "/" + methodBean.getUrl();
//                    if (methodDes != null) {
//                        File methodFile = new File(methodDes + ".md");
//                        methodFile.createNewFile();
//                        FileOutputStream fo = new FileOutputStream(methodFile);
//                        fo.write("**简要描述**".getBytes());
//                        fo.write("\n".getBytes());
//                        fo.write("- ".getBytes());
//                        fo.write(methodDes.getBytes());
//                        fo.write("\n\n".getBytes());
//                        fo.write("**版本信息**".getBytes());
//                        //@TODO 版本信息
//                        fo.write("\n\n".getBytes());
//                        fo.write("**请求URL**".getBytes());
//                        fo.write("\n\n".getBytes());
//                        fo.write("- ".getBytes());
//                        fo.write(url.getBytes());
//                        fo.write("\n\n".getBytes());
//                        fo.write("**请求方式**".getBytes());
//                        fo.write("\n".getBytes());
//                        fo.write("- ".getBytes());
//                        fo.write(methodBean.getType().getBytes());
//                        fo.write("\n\n".getBytes());
//                        fo.write("**参数**".getBytes());
//                        fo.write("\n".getBytes());
//                        fo.write("|参数名|类型|说明|".getBytes());
//                        fo.write("\n".getBytes());
//                        fo.write("|:----- |:-----|-----  |".getBytes());
//                        Set<ParameterBean> requestSet = methodBean.getRequestSet();
//                        for (ParameterBean parameterBean : requestSet) {
//                            fo.write("\n".getBytes());
//                            fo.write(("| " + parameterBean.getName() + " | " + parameterBean.getType() + " | " + parameterBean.getDesc() + " | ").getBytes());
//                        }
//                        fo.write("\n\n".getBytes());
//                        fo.write("请求示例\n```JSON\n".getBytes());
//                        String requestJson = methodBean.getRequestJson();
//                        if (requestJson != null) fo.write(JsonFormatUtil.formatJson(requestJson).getBytes());
//                        fo.write("\n```".getBytes());
//
//                        fo.write("\n\n".getBytes());
//                        fo.write("**返回参数**".getBytes());
//
//                        fo.write("\n\n|参数名|类型|说明|\n".getBytes());
//                        fo.write("|:----- |:-----|-----  |\n".getBytes());
//                        Set<ParameterBean> responseSet = methodBean.getResponseSet();
//                        for (ParameterBean parameterBean : requestSet) {
//                            fo.write("\n".getBytes());
//                            fo.write(("| " + parameterBean.getName() + " |" + parameterBean.getType() + " | " + parameterBean.getDesc() + " | ").getBytes());
//                        }
//                        fo.write("\n\n".getBytes());
//                        fo.write("**返回示例**\n\n```JSON\n".getBytes());
//                        String responseJson = methodBean.getResponseJson();
//                        if (responseJson != null) {
//                            fo.write(JsonFormatUtil.formatJson(responseJson).getBytes());
//                        }
//                        fo.write("\n```".getBytes());
//
//                    }
//                }
//            }
//        }
//    }
//}
