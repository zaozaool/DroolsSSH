/**
 * <p>Project: RMS</p>
 * <p>File: FactUtil.java</p>
 * <p>Copyright: Copyright (c) 2016.All rights reserved.</p>
 * <p>Company:www.genscript.com</p>
 * Date:2016-4-26
 * @author:Administrator
 */
package com.genscript.gsscm.util;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.genscript.gsscm.rule.fact.BaseFact;
import com.genscript.gsscm.rule.fact.point.PointFact;
import com.genscript.gsscm.rule.fact.price.GenePriceFact;
import com.genscript.gsscm.rule.fact.price.PriceFact;
import com.genscript.gsscm.rule.service.VersionService;

@Component
public class FactUtil {

    private static VersionService versionService;

    public static BaseFact parseFact(String data) {
        if (data == null) {
            BaseFact fact = new BaseFact();
            fact.setStatus("Error");
            fact.setMessage("Parse json error");
            return fact;
        }
        JSONObject json = JSONObject.fromObject(data);
        if (json == null) {
            BaseFact fact = new BaseFact();
            fact.setStatus("Error");
            fact.setMessage("Parse json error");
            return fact;
        }
        if (json.get("catalogNo") != null && StringUtils.isNotBlank(json.getString("catalogNo"))) {
            return parsePriceFact(json);
        } else {
            return parsePointFact(json);
        }
    }

    private static PriceFact parsePriceFact(JSONObject json) {
        if ("SC1010".equals(json.get("catalogNo"))) {
            GenePriceFact fact = (GenePriceFact) JSONObject.toBean(json, GenePriceFact.class);
            if (StringUtils.isBlank(fact.getVersion())) {
                versionService.getVersion(fact);
            }
            return fact;
        }
        PriceFact fact = new PriceFact();
        fact.setStatus("Error");
        fact.setMessage("Parse json error");
        return fact;
    }

    private static PointFact parsePointFact(JSONObject json) {
        PointFact fact = new PointFact();
        fact.setStatus("Error");
        fact.setMessage("Parse json error");
        return fact;
    }

    @Autowired
    public void setVersionService(VersionService versionService) {
        FactUtil.versionService = versionService;
    }

}
