package com.icbc.pojo.dto;

import com.icbc.pojo.In;
import com.icbc.util.StringUtil;
import lombok.Setter;
import lombok.SneakyThrows;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

/**
 * <p></p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Setter
public abstract class Common {
    private String transNo;

    public String getTransNo() {
        if (StringUtil.isEmpty(this.transNo)){
            return UUID.randomUUID().toString().substring(0,35);
        }
        return transNo;
    }

    public In createIn() {
        return In.builder().build();
    }
    /**
     * 检查非空.
     *
     * @param object 需要检查非空的对象.
     */
    @SneakyThrows
    public void validObj(Object object) {

        // 获取所有属性.
        Field[] declaredFields = object.getClass().getDeclaredFields();

        // 遍历所有属性.
        for (Field field : declaredFields) {

            // 进行必填项判断.
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                // get 方法拼串头
                String prefix = "get";
                String name = field.getName();
                Class<?> type = field.getType();
                // 判断布尔类型.
                if (type.isAssignableFrom(Boolean.class)) {
                    prefix = "is";
                }

                Object fo = field.get(object);
                Object[] arr = null;
                // 如果是集合，循环调用 validObj
                if (fo instanceof Collection) {
                    arr = ((Collection) fo).toArray();
                }

                // 如果是数组，循环调用 validObj
                if (field.getType().isArray()) {
                    arr = (Object[]) fo;
                }
                // 递归 引用本方法 深度检测.
                if (null != arr) {
                    for (Object o : arr) {
                        validObj(o);
                    }
                }

                Method method = object.getClass()
                        .getMethod(prefix + name.substring(0, 1).toUpperCase() + name.substring(1));

                //调用getter方法获取属性值
                Object invoke = method.invoke(object);
                if (invoke == null) {
                    NotNull notNull = field.getAnnotation(NotNull.class);
                    throw new RuntimeException(notNull.message() + " 不能为空");
                }

                // 如果是 list 则应该判断 list 长度.
                if (invoke.getClass().isAssignableFrom(ArrayList.class) && ((ArrayList<Object>) invoke).isEmpty()) {
                    NotNull notNull = field.getAnnotation(NotNull.class);
                    throw new RuntimeException(notNull.message() + " 不能为空");
                }
            }

        }
    }
}
