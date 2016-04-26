/**
 * <p>Project: RMS</p>
 * <p>File: PriceFact.java</p>
 * <p>Copyright: Copyright (c) 2016.All rights reserved.</p>
 * <p>Company:www.genscript.com</p>
 * Date:2016-4-26
 * @author:Administrator
 */
package com.genscript.gsscm.rule.fact.price;

import com.genscript.gsscm.rule.fact.BaseFact;

/**
 * 用于price计算的fact
 */
public class PriceFact extends BaseFact {

    private String catalogNo;

    private String baseCurrency;

    private Double BasePrice;

    private Double BaseAmount;

    private String currency;

    private Double price;

    private Double amount;

    private String tpCurrency;

    private Double transferPriceS;

    private Double transferPriceP;

    public Double getBasePrice() {
        return BasePrice;
    }

    public void setBasePrice(Double basePrice) {
        BasePrice = basePrice;
    }

    public Double getBaseAmount() {
        return BaseAmount;
    }

    public void setBaseAmount(Double baseAmount) {
        BaseAmount = baseAmount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public String getTpCurrency() {
        return tpCurrency;
    }

    public void setTpCurrency(String tpCurrency) {
        this.tpCurrency = tpCurrency;
    }

    public String getCatalogNo() {
        return catalogNo;
    }

    public void setCatalogNo(String catalogNo) {
        this.catalogNo = catalogNo;
    }

}
