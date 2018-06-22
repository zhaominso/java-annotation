package org.zm.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {
        Calculate calculate = new Calculate(2, 0);
        Class clazz = calculate.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        int testNum = 0;
        int successNum = 0;
        int errNum = 0;
        for (Method method : methods) {
            testNum++;
            if (method.isAnnotationPresent(MyTest.class)) {
                String methodName = method.getName();
                try {
                    Object ret = method.invoke(calculate);
                    System.out.println("Method:" + methodName + ", Test Success, Result:" + ret);
                    successNum++;
                } catch (Exception e) {
                    String err = "Method:" + methodName + ", Test Failed"
                            + "\n    caused by:" + e.getCause().getClass()
                            + "\n              " + e.getCause().getMessage();
                    System.out.println(err);
                    errNum++;
                }
            }
        }
        System.out.println("MyTest Done. All MyTest:" + testNum + "; SuccessNum:" + successNum + "; ErrNum:" + errNum);
    }


    private void test() throws NoSuchFieldException {
        Calculate calculate = new Calculate(2, 0);
        Class clazz = calculate.getClass();
        Field field=clazz.getField("age");
        if (field.isAnnotationPresent(Color.class)){
            Annotation annotation=field.getAnnotation(Color.class);
            String[] colors=((Color) annotation).colors();
            //接下来就是根据或得到的注解值colors做一些你想做的操作
            //比如colors中包含red,你就咋咋咋
            //比如colors中包含black，你就把它赋值给某个变量
        }
    }



}
