/**
 * <p>Project: RMS</p>
 * <p>File: GenePriceFact.java</p>
 * <p>Copyright: Copyright (c) 2016.All rights reserved.</p>
 * <p>Company:www.genscript.com</p>
 * Date:2016-4-26
 * @author:Administrator
 */
package com.genscript.gsscm.rule.fact.price;

/**
 * gene价格计算fact
 */
public class GenePriceFact extends PriceFact {

    private Double baseBpPrice;

    private Double bpPrice;

    private Integer seqLength;

    public Double getBaseBpPrice() {
        return baseBpPrice;
    }

    public void setBaseBpPrice(Double baseBpPrice) {
        this.baseBpPrice = baseBpPrice;
    }

    public Double getBpPrice() {
        return bpPrice;
    }

    public void setBpPrice(Double bpPrice) {
        this.bpPrice = bpPrice;
    }

    public Integer getSeqLength() {
        return seqLength;
    }

    public void setSeqLength(Integer seqLength) {
        this.seqLength = seqLength;
    }

}
