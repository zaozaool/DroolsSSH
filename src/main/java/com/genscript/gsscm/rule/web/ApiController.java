package com.genscript.gsscm.rule.web;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import net.sf.json.JSONObject;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.genscript.gsscm.rule.fact.BaseFact;
import com.genscript.gsscm.rule.fact.price.PriceFact;
import com.genscript.gsscm.rule.service.PriceService;
import com.genscript.gsscm.util.DroolsUtil;
import com.genscript.gsscm.util.Struts2Util;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.ValidationAwareSupport;

@Results({ @Result(name = "index", location = "api-index.jsp") })
public class ApiController extends ValidationAwareSupport implements ModelDriven<Object>, Validateable {

    private String data;

    @Autowired
    private PriceService priceService;

    // GET /api
    public String index() {
        return "index";
    }

    // POST /api
    public void create() throws IllegalAccessException, InvocationTargetException {
        BaseFact fact = DroolsUtil.parseFact(data);

        Validator validator = new Validator();
        List<ConstraintViolation> violations = validator.validate(fact);
        for (ConstraintViolation v : violations) {
            System.out.println(v.getCheckName());
        }

        Calendar cal = Calendar.getInstance();
        TimeZone timeZone = cal.getTimeZone();
        System.out.println(timeZone.getID());
        System.out.println(timeZone.getDisplayName());
        TimeZone japan = TimeZone.getTimeZone("Japan");
        TimeZone usEastern = TimeZone.getTimeZone("US/Eastern");

        if (fact instanceof PriceFact) {
            PriceFact priceFact = (PriceFact) fact;
            JSONObject json = priceService.calculatePrice(priceFact);
            Struts2Util.renderJson(json);
        }
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
