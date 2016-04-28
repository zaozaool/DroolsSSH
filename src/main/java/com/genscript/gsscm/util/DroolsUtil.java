package com.genscript.gsscm.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.genscript.gsscm.common.annotation.Rule;
import com.genscript.gsscm.common.constant.Action;
import com.genscript.gsscm.common.constant.Site;
import com.genscript.gsscm.rule.fact.BaseFact;
import com.genscript.gsscm.rule.fact.point.PointFact;
import com.genscript.gsscm.rule.fact.price.GenePriceFact;
import com.genscript.gsscm.rule.fact.price.PriceFact;
import com.genscript.gsscm.rule.service.PriceService;
import com.genscript.gsscm.rule.service.VersionService;

@Component
public class DroolsUtil {

    private static VersionService versionService;

    private static PriceService priceService;

    private static Logger logger = Logger.getLogger(DroolsUtil.class);

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

        if ("price".equals(json.getString("action"))) {
            return parsePriceFact(json);
        } else if ("point".equals(json.getString("action"))) {
            return parsePointFact(json);
        }
        return null;
    }

    private static PriceFact parsePriceFact(JSONObject json) {
        if ("SC1010".equals(json.get("catalogNo")) || "SC1575".equals(json.get("catalogNo"))) {
            GenePriceFact fact = (GenePriceFact) JSONObject.toBean(json, GenePriceFact.class);
            // 如果版本号为空则查询最新的版本号
            if (StringUtils.isBlank(fact.getVersion())) {
                String ruleName = fact.getSite() + "-" + fact.getAction() + "-" + fact.getCatalogNo();
                fact.setRuleName(ruleName);
                String v = versionService.getLastestVersion(ruleName);
                if (v == null) {
                    fact.setStatus("Error");
                    fact.setMessage("Can't get the lastest version.");
                }
                fact.setVersion(v);
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

    public static void log(Object obj) {
        logger.info(obj);
    }

    @Autowired
    public void setVersionService(VersionService versionService) {
        DroolsUtil.versionService = versionService;
    }

    @Autowired
    public void setPriceService(PriceService priceService) {
        DroolsUtil.priceService = priceService;
    }

    public static VersionService getVersionService() {
        return versionService;
    }

    public static PriceService getPriceService() {
        return priceService;
    }

    /**
     * 
     * 得到返回结果,这里需要根据注解排除各个规则不需要的属性
     */
    public static JSONObject getReturnJson(BaseFact fact) {
        Set<String> excludeFields = new HashSet<String>();
        Class clazz = fact.getClass();
        // 依次迭代本身及其父类型的注解
        while (clazz != null && !clazz.equals(Object.class)) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                Rule rule = field.getAnnotation(Rule.class);
                if (rule == null) {
                    continue;
                }
                List<Site> sites = Arrays.asList(rule.site());
                List<Action> actions = Arrays.asList(rule.action());
                List<String> ruleNames = Arrays.asList(rule.ruleName());
                List<String> versions = Arrays.asList(rule.version());
                List<Site> ignoreSites = Arrays.asList(rule.ignoreSite());
                List<Action> ignoreActions = Arrays.asList(rule.ignoreAction());
                List<String> ignoreRuleNames = Arrays.asList(rule.ignoreRuleName());
                List<String> ignoreVersions = Arrays.asList(rule.ignoreVersion());

                Site site = Site.getSite(fact.getSite());
                Action action = Action.getAction(fact.getAction());
                String ruleName = fact.getRuleName();
                String version = fact.getVersion();
                // 忽略设置
                if (ignoreSites.isEmpty() && ignoreActions.isEmpty() && ignoreRuleNames.isEmpty() && ignoreVersions.isEmpty()) {
                    // 没有忽略设置
                } else {
                    if ((ignoreSites.isEmpty() || ignoreSites.contains(site)) && (ignoreActions.isEmpty() || ignoreActions.contains(action)) && (ignoreRuleNames.isEmpty() || ignoreRuleNames.contains(ruleName)) && (ignoreVersions.isEmpty() || ignoreVersions.contains(version))) {
                        excludeFields.add(field.getName());
                    }
                }

                // 指定设置
                if (!sites.isEmpty() && !sites.contains(site)) {
                    excludeFields.add(field.getName());
                }
                if (!actions.isEmpty() && !actions.contains(action)) {
                    excludeFields.add(field.getName());
                }
                if (!ruleNames.isEmpty() && !ruleNames.contains(ruleName)) {
                    excludeFields.add(field.getName());
                }
                if (!versions.isEmpty() && !versions.contains(version)) {
                    excludeFields.add(field.getName());
                }
            }
            clazz = clazz.getSuperclass();
        }

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(excludeFields.toArray(new String[excludeFields.size()]));
        return JSONObject.fromObject(fact, jsonConfig);
    }

}
