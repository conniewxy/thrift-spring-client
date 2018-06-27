package org.conniewxy.thrift.support;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by wangxiaoyan on 2018/6/27.
 * <p/>
 * 配置文件读取Support
 */
public class PropertiesSupport {
    private static final Properties SERVICE_PROPERTIES = new Properties();

    static {
        InputStream in = null;
        try {
            in = PropertiesSupport.class.getResourceAsStream("/service.properties");
            SERVICE_PROPERTIES.load(new InputStreamReader(in, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取配置的Value值
     *
     * @param key
     * @param defaultValue
     * @return
     */
    private static String getServicePropertiesValue(String key, String defaultValue) {
        return SERVICE_PROPERTIES.getProperty(key, defaultValue);
    }

}
