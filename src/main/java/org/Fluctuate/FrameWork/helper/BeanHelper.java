package org.Fluctuate.FrameWork.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.Fluctuate.FrameWork.util.ReflectionUtil;

/**
 * Bean 助手类
 */
public final class BeanHelper {
    // Like 符号表 将所有类及其实例对象建立K-V表
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet) {
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, obj);
        }
    }

    /**
     * 获取 Bean 映射
     */
    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    /**
     * 获取 Bean 实例
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> aClass) {
        if (!BEAN_MAP.containsKey(aClass)) {
            throw new RuntimeException("can not get bean by class: " + aClass);
        }
        return (T) BEAN_MAP.get(aClass);
    }

    /**
     * 设置 Bean 实例
     */
    public static void setBean(Class<?> aClass, Object obj) {
        BEAN_MAP.put(aClass, obj);
    }

}
