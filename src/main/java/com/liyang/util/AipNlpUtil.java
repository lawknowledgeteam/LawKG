package com.liyang.util;

import com.liyang.config.AipNlpConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @Author: Pan
 * @Date: 2019/7/24 19:53
 * @Description:
 **/
public class AipNlpUtil {

    AipNlpConfig aipNlpConfig = new AipNlpConfig();

    public HashMap<String,String> get(String text) throws JSONException {
        JSONObject result = aipNlpConfig.getResult(text);
        JSONArray jsonArray  = result.getJSONArray("items");
        HashMap<String,String> hashMap = new HashMap<>();
/*        for (int i=0;i<jsonArray.length();i++) {
            JSONObject job = jsonArray.getJSONObject(i);
            String value = job.getString("ne");
            String value1 = job.getString("pos");
            if ("m".equals(value1)) {
                continue;
            }
            if (value.equals(SearchKind.ORG.getKind())||
                    value1.equals(SearchKind.ORG.getKind())){
                hashMap.put(SearchKind.ORG.getName(),job.getString("item"));
            }else if (value.equals(SearchKind.nz.getKind())||
                    value1.equals(SearchKind.nz.getKind())){
                hashMap.put(SearchKind.nz.getName(),job.getString("item"));
            }else if ( value.equals(SearchKind.m.getKind())||
                    value1.equals(SearchKind.m.getKind()) ){
                hashMap.put(SearchKind.m.getName(),job.getString("item"));
            }
        }*/

        return hashMap;
    }
}
