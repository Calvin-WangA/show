package com.wch.utils;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.wch.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 该类实现bean的相关操作
 * Created Date 2017/4/9
 *
 * @copyright SL131
 */
public class BeanMapper {

    private static final Logger logger = (Logger) LogManager.getLogger(BeanMapper.class);

    private static SimpleDateFormat format = new SimpleDateFormat(Constants.DATETIME_FORMAT);

    /**
     * 将map转化为对应的对象
     *
     * @param params
     * @return
     */
    public static Object mapToObject(Map<String, Object> params, Class objClass) {

        Object obj = null;


        Iterator<String> iter = params.keySet().iterator();
        Field[] fields = objClass.getDeclaredFields();

        String fieldName = null;
        Field field = null;
        Object value = null;
        int len = fields.length;
        try {
            obj = objClass.newInstance();
            for (int i = 0; i < len; i++) {
                field = fields[i];
                fieldName = field.getName();
                value = params.get(fieldName);
                if (null != value) {
                    field.setAccessible(true);
                    //直接就是相同类型就不用转了
                    if ( !(value instanceof String)) {
                        field.set(obj, value);
                    }
                    else {//根据属性类型转值类型
                        logger.debug("fieldName:" + fieldName + " walk here!");
                        setPropertyValue(obj, field, (String) value);
                    }

                }
            }
        } catch (IllegalAccessException e) {
            logger.error("不合法的访问异常", e);
        } catch (ParseException e) {
            logger.error("解析异常", e);
        } catch (InstantiationException e) {
            logger.error("实例化异常", e);
        }

        return obj;
    }

    /***
     * 根据属性类型进行对应属性的转换
     * @param field 属性
     * @param value 属性值
     * @return
     */
    public static void setPropertyValue(Object obj, Field field, String value) throws IllegalAccessException, ParseException {

        Class objClass = field.getType();
        if (objClass == Short.class) {
            field.setShort(obj, Short.parseShort(value));
        } else if (objClass == Integer.class) {
            field.setInt(obj, Integer.parseInt(value));
        } else if (objClass == Long.class) {
            field.setLong(obj, Long.parseLong(value));
        } else if (objClass == Float.class) {
            field.setFloat(obj, Float.parseFloat(value));
        } else if (objClass == Double.class) {
            field.setDouble(obj, Double.parseDouble(value));
        } else if (objClass == Char.class) {
            field.setChar(obj, value.charAt(0));
        } else if (objClass == String.class) {
            field.set(obj, value);
        } else if (objClass == Date.class) {
            field.set(obj, format.parse(value));
        }

        return;
    }

    /**
     * 将传入字符串的指定位置的字符转换为大写
     *
     * @param value 需要转换的字符串
     * @return 转换好的字符串
     */
    public String convertCharToUpperCase(int index, String value) {

        char firstChar = value.charAt(index);

        value = (firstChar + "").toUpperCase() + value.substring(index + 1);

        return value;
    }

    /**
     * 将相应的对象转换为map集合
     *
     * @param obj 对象
     * @return
     */
    public static Map<String, Object> objectToMap(Object obj) {
        Map<String, Object> params = new HashMap<String, Object>();

        Field[] fields = obj.getClass().getDeclaredFields();
        String fieldName = null;
        Object value = null;
        Field field = null;
        try {
            for (int i = 0; i < fields.length; i++) {
                field = fields[i];
                field.setAccessible(true);
                fieldName = field.getName();
                value = field.get(obj);
                params.put(fieldName, value);
            }
        } catch (IllegalAccessException e) {
            logger.error("不合法的访问", e);
        }

        return params;
    }
}
