package com.meerkat.easymon.util;


import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * author : yjs
 * createTime : 2019/3/12
 * description :
 * version : 1.0
 */
@Slf4j
public class JsonUtil {

    /**
     * 将一个JSON对象的值解析存入Map
     * key存储规则：{对象名}.{数组下标}.{字段名}
     * 例如：
     * {"A":"1","B":[{"aa":"11"},{"aa":"22"}],"C":{"a":3}}
     * 解析成(key->value):
     *  A->1
     *  B.0.aa->11
     *  B.1.aa->22
     *  C.a->3
     }
     * @param objJson
     */
    public static Map parseJson(Object objJson) {
        HashMap<String, String> map = new HashMap<>();
        JsonUtil.analysisJson(objJson, null, map);
        return map;
    }

    private static void analysisJson(Object objJson, String path, Map map) {
        //如果obj为json数组
        if (objJson instanceof JSONArray) {
            JSONArray objArray = (JSONArray) objJson;
            for (int i = 0; i < objArray.size(); i++) {
                analysisJson(objArray.get(i), StringUtils.isNotBlank(path) ? path + "." + Integer.toString(i) : Integer.toString(i), map);
            }
        }
        //如果为json对象
        else if (objJson instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) objJson;
            Iterator it = jsonObject.keys();
            while (it.hasNext()) {
                String key = it.next().toString();
                Object object = jsonObject.get(key);
                //如果得到的是数组
                if (object instanceof JSONArray) {
                    JSONArray objArray = (JSONArray) object;
                    analysisJson(objArray, StringUtils.isNotBlank(path) ? path + "." + key : key, map);
                }
                //如果key中是一个json对象
                else if (object instanceof JSONObject) {
                    analysisJson(object, StringUtils.isNotBlank(path) ? path + "." + key : key, map);
                }
                //如果key中是其他
                else {
                    map.put(StringUtils.isNotBlank(path) ? path + "." + key : key, object.toString());
                }
            }
        }
    }
}
