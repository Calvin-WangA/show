package com.wch.utils;

import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.convert.Property;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * 该类实现属性文件获取并可通过这种方式加解密属性文件的信息
 * Created Date 2017/4/9
 *
 * @copyright CalvinWang
 */
public class PropertyUtils  extends PropertyPlaceholderConfigurer{

    private static Map<String, Object> properties ;

    /**
     * 重写该方法实现属性的操作, 在spring文件中配置该类为属性加载的才行
     * @param beanFactoryToProcess
     * @param props
     * @throws BeansException
     */
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {

        super.processProperties(beanFactoryToProcess, props);
        properties = new HashMap<String, Object>();
        String propKey = "";
        for (Iterator<Object> iter = props.keySet().iterator(); iter.hasNext();) {
            propKey = (String) iter.next();
            if (!StringUtils.isEmpty(propKey)) {
                properties.put(propKey, props.getProperty(propKey));
            }
        }
    }

    public static String getProperty(String key) {
        return (String)properties.get(key);
    }

    public static void setProperty(String key, String value) {
        properties.put(key, value) ;
    }
}
