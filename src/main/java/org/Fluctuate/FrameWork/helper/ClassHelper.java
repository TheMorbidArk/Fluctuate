package org.Fluctuate.FrameWork.helper;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import org.Fluctuate.FrameWork.util.ClassUtil;
import org.Fluctuate.FrameWork.annotation.Controller;
import org.Fluctuate.FrameWork.annotation.Service;

/**
 * 类操作助手类
 */
public final class ClassHelper {

    // 定义类集合（用于存放所加载的类）
    private static final Set<Class<?>> CLASS_SET;
    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取应用包名下的所有类
     */
    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    /**
     * 获取应用包名下所有 Service 类
     */
    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> aClass : CLASS_SET) {
            if (aClass.isAnnotationPresent(Service.class)) {
                classSet.add(aClass);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下所有 Controller 类
     */
    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> aClass : CLASS_SET) {
            if (aClass.isAnnotationPresent(Controller.class)) {
                classSet.add(aClass);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下所有 Bean 类（包括：Service、Controller 等）
     */
    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
        beanClassSet.addAll(getServiceClassSet());
        beanClassSet.addAll(getControllerClassSet());
        return beanClassSet;
    }

    /**
     * 获取应用包名下某父类（或接口）的所有子类（或实现类）
     */
    public static Set<Class<?>> getClassSetBySuper(Class<?> superClass) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> aClass : CLASS_SET) {
            if (superClass.isAssignableFrom(aClass) && !superClass.equals(aClass)) {
                classSet.add(aClass);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下带有某注解的所有类
     */
    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> aClass : CLASS_SET) {
            if (aClass.isAnnotationPresent(annotationClass)) {
                classSet.add(aClass);
            }
        }
        return classSet;
    }

}
