package com.hs.school.controller;

import com.alibaba.fastjson.JSONObject;
import com.hs.school.util.SignUtil;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: duyashuo
 * @Date: 2019-08-09 16:35
 */
@RestController
@RequestMapping(value = "/")
public class HelloController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/deplist", method = {RequestMethod.GET, RequestMethod.POST})
    public String query() {

        TreeMap<String, Object> params = new TreeMap<>();
        params.put("usertype", "2");

        JSONObject rsp = restTemplate
            .getForObject(SignUtil.depListUrl + SignUtil.buildParams(params), JSONObject.class);

        System.out.println(rsp);

        return "ok";
    }

    @RequestMapping(value = "/user", method = {RequestMethod.GET, RequestMethod.POST})
    public String user() {

        TreeMap<String, Object> params = new TreeMap<>();
        params.put("usertype", "2");
        params.put("departid", "yxSWxmas501xmasckdone");
        params.put("level", "2");

        JSONObject rsp = restTemplate
            .getForObject(SignUtil.searchUserUrl + SignUtil.buildParams(params), JSONObject.class);

        System.out.println(rsp);

        return "ok";
    }


}
