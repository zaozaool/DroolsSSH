/**
 * <p>Project: RMS</p>
 * <p>File: PriceController.java</p>
 * <p>Copyright: Copyright (c) 2016.All rights reserved.</p>
 * <p>Company:www.genscript.com</p>
 * Date:2016-4-26
 * @author:Administrator
 */
package com.genscript.gsscm.rule.web;

import java.lang.reflect.InvocationTargetException;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.genscript.gsscm.rule.fact.BaseFact;
import com.genscript.gsscm.rule.service.SessionInfoService;
import com.genscript.gsscm.rule.service.VersionService;
import com.genscript.gsscm.util.FactUtil;
import com.genscript.gsscm.util.Struts2Util;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.ValidationAwareSupport;

@Results({ @Result(name = "index", location = "price-index.jsp") })
public class PriceApi extends ValidationAwareSupport implements ModelDriven<Object>, Validateable {

    private String data;

    @Autowired
    private VersionService versionService;

    @Autowired
    private SessionInfoService sessionInfoService;

    // GET /price
    public String index() {
        return "index";
    }

    // POST /price
    public void create() throws IllegalAccessException, InvocationTargetException {
        BaseFact fact = FactUtil.parseFact(data);
        versionService.getVersion(fact);
        sessionInfoService.list();
        Struts2Util.renderJson(JSONObject.fromObject(fact).toString());
    }

    public void validate() {
    }

    public Object getModel() {
        return null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
