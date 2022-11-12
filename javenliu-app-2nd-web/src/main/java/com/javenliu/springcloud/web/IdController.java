package com.javenliu.springcloud.web;

import com.javenliu.springcloud.common.id.IdUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/id")
public class IdController {

    @RequestMapping("/get")
    @ResponseBody
    public Map get() {
        Map<String, Object> map = new HashMap();
        map.put("id", IdUtils.getObjectId());
        return map;
    }
}
