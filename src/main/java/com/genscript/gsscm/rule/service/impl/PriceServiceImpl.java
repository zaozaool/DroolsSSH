package com.genscript.gsscm.rule.service.impl;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.genscript.gsscm.common.constant.Site;
import com.genscript.gsscm.rule.dao.GeneBasePriceDao;
import com.genscript.gsscm.rule.entity.GeneBasePrice;
import com.genscript.gsscm.rule.fact.price.PriceFact;
import com.genscript.gsscm.rule.service.PriceService;
import com.genscript.gsscm.util.DroolsUtil;

@Service
@Transactional
public class PriceServiceImpl implements PriceService {

    @KSession("itemKsession")
    private KieSession itemKieSession;

    @Autowired
    private GeneBasePriceDao geneBasePriceDao;

    private static Logger logger = Logger.getLogger(PriceServiceImpl.class);

    public JSONObject calculatePrice(PriceFact fact) {
        logger.info(fact);
        itemKieSession.insert(fact);
        itemKieSession.fireAllRules();
        logger.info(fact);

        return DroolsUtil.getReturnJson(fact);
    }

    public GeneBasePrice getGeneBasePrice(String catalogNo, Integer seqLength, String cloningReadyFlag, String site, String version) {
        String locCode = "";
        if (Site.US_ORDER.value().equals(site)) {
            locCode = "US";
        } else if (Site.JP_ORDER.value().equals(site)) {
            locCode = "JP";
        } else if (Site.CN_ORDER.value().equals(site)) {
            locCode = "CN";
        }
        if (StringUtils.isBlank(locCode)) {
            return null;
        }
        return geneBasePriceDao.searchByVersion(catalogNo, seqLength, cloningReadyFlag, locCode, version);
    }
}
