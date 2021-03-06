package com.xbting.ac.okhttp;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xubt on 2015/12/24.
 */
public class ACRequestParam {
    public final Map<String, String> getFormatParams() {
        Map<String, String> map = new HashMap<String, String>();
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field f : fields) {
                f.setAccessible(true);

                map.put(f.getName()
                        , String.valueOf(f.get(this)));
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return map;
    }

    public final String getURLParams() {
        String paramUrl="";
        StringBuffer sb = new StringBuffer();
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field f : fields) {
                f.setAccessible(true);
                sb.append(f.getName());
                sb.append("=");
                sb.append(f.get(this));
            }
            paramUrl =sb.toString().substring(1);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return paramUrl;
    }

}
