package com.hs.school.util;

import com.google.common.base.Joiner;
import com.google.common.hash.Hashing;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: duyashuo
 * @Date: 2019-08-10 14:46
 */
public class SignUtil {

    public static String appSecret = "270171738df3df7f11e302cc4c26e396";

    public static String openAppID = "488289151494";

    public static String objectid = "EOunUVxV6iYdone";

    public static String objType = "2";

    /**
     * 1代表学生 2代表老师
     */
    public static String usertype = "2";

    /**
     * 组织架构URL openAppID=488289151494&objectid=EOunUVxV6iYdone&objType=2&usertype=2
     */
    public static String depListUrl = "https://open.campus.qq.com/api/open/getDepartmentInfoList?";

    /**
     * 获取用户信息 老师 openAppID=488289151494&objectid=EOunUVxV6iYdone&objType=2&departid=POjM2bbiLNEdone&level=3&usertype=2
     */
    public static String searchUserUrl = "https://open.campus.qq.com/api/common/searchUser?";

    /**
     * 添加公共的请求参数并构造出请求的URL中的全部参数
     */
    public static String buildParams(TreeMap<String, Object> privateParams) {

        TreeMap<String, Object> paramsMap = new TreeMap<>();
        paramsMap.putAll(privateParams);

        long timestamp = System.currentTimeMillis();
        paramsMap.put("timestamp", timestamp);
        paramsMap.put("openAppID", openAppID);
        paramsMap.put("objectid", objectid);
        paramsMap.put("objType", objType);

        String url = mapToUrl(paramsMap);
        url += "&key=" + appSecret;

        String sign = getSign(url);
        paramsMap.put("sign", sign);

        return mapToUrl(paramsMap);
    }

    /**
     * map转换成url请求的参数
     */
    private static String mapToUrl(Map<String, Object> map) {
        String result = "";
        if (map != null && map.size() > 0) {
            result = Joiner.on("&").withKeyValueSeparator("=").join(map);
        }
        return result;
    }

    /**
     * 获取sign
     */
    private static String getSign(String params) {
        return Hashing.md5().hashBytes(params.getBytes()).toString().toUpperCase();
    }

}
