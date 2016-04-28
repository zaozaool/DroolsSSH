package com.genscript.gsscm.rule.service;

import net.sf.json.JSONObject;

import com.genscript.gsscm.rule.entity.GeneBasePrice;
import com.genscript.gsscm.rule.fact.price.PriceFact;

public interface PriceService {

    public JSONObject calculatePrice(PriceFact fact);

    public GeneBasePrice getGeneBasePrice(String catalogNo, Integer seqLength, String cloningReadyFlag, String site, String version);

}
