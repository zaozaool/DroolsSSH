package com.genscript.gsscm.rule.fact.price;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.genscript.gsscm.common.annotation.Rule;
import com.genscript.gsscm.common.constant.Action;
import com.genscript.gsscm.common.constant.Site;

/**
 * gene价格计算fact
 */
public class GenePriceFact extends PriceFact {

    @Rule(action = { Action.PRICE }, site = { Site.US_ORDER, Site.JP_ORDER, Site.CN_ORDER }, ruleName = { "usorder-price-SC1010", "jporder-price-SC1010", "cnorder-price-SC1010", "usorder-price-SC1575", "jporder-price-SC1575" })
    private Double baseBpPrice;

    @Rule(action = { Action.PRICE }, site = { Site.US_ORDER, Site.JP_ORDER, Site.CN_ORDER }, ruleName = { "usorder-price-SC1010", "jporder-price-SC1010", "cnorder-price-SC1010", "usorder-price-SC1575", "jporder-price-SC1575" })
    private Integer seqLength;

    // @Rule(action = { Action.PRICE }, site = { Site.US_ORDER, Site.JP_ORDER,
    // Site.CN_ORDER }, ruleName = { "usorder-price-SC1010",
    // "jporder-price-SC1010", "cnorder-price-SC1010", "usorder-price-SC1575",
    // "jporder-price-SC1575" })
    // private String sequence;

    // 1为clone ready
    @Rule(action = { Action.PRICE }, site = { Site.US_ORDER, Site.JP_ORDER, Site.CN_ORDER }, ruleName = { "usorder-price-SC1010", "jporder-price-SC1010", "cnorder-price-SC1010", "usorder-price-SC1575", "jporder-price-SC1575" })
    private Integer cloneReady;

    // 针对日本订单系统可以有gene价格记忆功能
    @Rule(action = { Action.PRICE }, site = { Site.JP_ORDER }, ruleName = { "jporder-price-SC1010", "jporder-price-SC1575" })
    private Double custGeneMemoBpPrice;

    // 针对日本订单系统可以有gene价格记忆功能
    @Rule(action = { Action.PRICE }, site = { Site.JP_ORDER }, ruleName = { "jporder-price-SC1010", "jporder-price-SC1575" })
    private Double custGeneMemoMinPrice;

    // 针对日本订单系统可以有gene价格记忆功能
    @Rule(action = { Action.PRICE }, site = { Site.JP_ORDER }, ruleName = { "jporder-price-SC1010", "jporder-price-SC1575" })
    private Double custGeneMemoFixedPrice;

    public Double getBaseBpPrice() {
        return baseBpPrice;
    }

    public void setBaseBpPrice(Double baseBpPrice) {
        this.baseBpPrice = baseBpPrice;
    }

    public Integer getSeqLength() {
        return seqLength;
    }

    public void setSeqLength(Integer seqLength) {
        this.seqLength = seqLength;
    }

    public Integer getCloneReady() {
        return cloneReady;
    }

    public void setCloneReady(Integer cloneReady) {
        this.cloneReady = cloneReady;
    }

    public Double getCustGeneMemoBpPrice() {
        return custGeneMemoBpPrice;
    }

    public void setCustGeneMemoBpPrice(Double custGeneMemoBpPrice) {
        this.custGeneMemoBpPrice = custGeneMemoBpPrice;
    }

    public Double getCustGeneMemoMinPrice() {
        return custGeneMemoMinPrice;
    }

    public void setCustGeneMemoMinPrice(Double custGeneMemoMinPrice) {
        this.custGeneMemoMinPrice = custGeneMemoMinPrice;
    }

    public Double getCustGeneMemoFixedPrice() {
        return custGeneMemoFixedPrice;
    }

    public void setCustGeneMemoFixedPrice(Double custGeneMemoFixedPrice) {
        this.custGeneMemoFixedPrice = custGeneMemoFixedPrice;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
