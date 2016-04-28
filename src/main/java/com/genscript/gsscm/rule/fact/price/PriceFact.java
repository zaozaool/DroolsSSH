package com.genscript.gsscm.rule.fact.price;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.genscript.gsscm.common.annotation.Rule;
import com.genscript.gsscm.common.constant.Action;
import com.genscript.gsscm.common.constant.Site;
import com.genscript.gsscm.rule.fact.BaseFact;

/**
 * 用于price计算的fact
 */
public class PriceFact extends BaseFact {

    @Rule(action = { Action.PRICE }, site = { Site.US_ORDER, Site.JP_ORDER, Site.CN_ORDER })
    private String catalogNo;

    @Rule(action = { Action.PRICE }, site = { Site.US_ORDER, Site.JP_ORDER, Site.CN_ORDER })
    private String baseCurrency;

    @Rule(action = { Action.PRICE }, site = { Site.US_ORDER, Site.JP_ORDER, Site.CN_ORDER })
    private Double basePrice;

    @Rule(action = { Action.PRICE }, site = { Site.US_ORDER, Site.JP_ORDER, Site.CN_ORDER })
    private String tpCurrency;

    @Rule(action = { Action.PRICE }, site = { Site.US_ORDER, Site.JP_ORDER, Site.CN_ORDER })
    private Double transferPriceS;

    @Rule(action = { Action.PRICE }, site = { Site.US_ORDER, Site.JP_ORDER, Site.CN_ORDER })
    private Double transferPriceP;

    // 1为难度
    @Rule(action = { Action.PRICE }, site = { Site.US_ORDER, Site.JP_ORDER, Site.CN_ORDER })
    private Integer difficultFlag;

    // Y为vip，针对日本订单系统
    @Rule(action = { Action.PRICE }, site = { Site.JP_ORDER })
    private String vipFlag;

    public Integer getDifficultFlag() {
        return difficultFlag;
    }

    public void setDifficultFlag(Integer difficultFlag) {
        this.difficultFlag = difficultFlag;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public Double getTransferPriceS() {
        return transferPriceS;
    }

    public void setTransferPriceS(Double transferPriceS) {
        this.transferPriceS = transferPriceS;
    }

    public Double getTransferPriceP() {
        return transferPriceP;
    }

    public void setTransferPriceP(Double transferPriceP) {
        this.transferPriceP = transferPriceP;
    }

    public String getCatalogNo() {
        return catalogNo;
    }

    public void setCatalogNo(String catalogNo) {
        this.catalogNo = catalogNo;
    }

    public String getTpCurrency() {
        return tpCurrency;
    }

    public void setTpCurrency(String tpCurrency) {
        this.tpCurrency = tpCurrency;
    }

    public String getVipFlag() {
        return vipFlag;
    }

    public void setVipFlag(String vipFlag) {
        this.vipFlag = vipFlag;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
