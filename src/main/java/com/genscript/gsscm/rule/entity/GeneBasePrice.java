package com.genscript.gsscm.rule.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhangyong
 */
@Entity
@Table(name = "gene_base_price", catalog = "drools")
public class GeneBasePrice implements Serializable {

    private static final long serialVersionUID = 222487341827238476L;

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "catalog_no")
    private String catalogNo;

    @Column(name = "sub_type")
    private String subType;

    @Column(name = "cloning_ready_flag")
    private String cloningReadyFlag;

    @Column(name = "seq_length_from")
    private Integer seqLengthFrom;

    @Column(name = "seq_length_to")
    private Integer seqLengthTo;

    @Column(name = "listing_bp_price")
    private BigDecimal listingBpPrice;

    @Column(name = "listing_vip_bp_price")
    private BigDecimal listingVipBpPrice;

    @Column(name = "fixed_listing_price")
    private BigDecimal fixedListingPrice;

    @Column(name = "vip_fixed_listing_price")
    private BigDecimal vipFixedListingPrice;

    @Column(name = "min_listing_price")
    private BigDecimal minListingPrice;

    @Column(name = "min_vip_listing_price")
    private BigDecimal minVipListingPrice;

    @Column(name = "transfer_bp_price_p")
    private BigDecimal transferBpPriceP;

    @Column(name = "fixed_transfer_price_p")
    private BigDecimal fixedTransferPriceP;

    @Column(name = "min_transfer_price_p")
    private BigDecimal minTransferPriceP;

    @Column(name = "transfer_bp_price_s")
    private BigDecimal transferBpPriceS;

    @Column(name = "fixed_transfer_price_s")
    private BigDecimal fixedTransferPriceS;

    @Column(name = "min_transfer_price_s")
    private BigDecimal minTransferPriceS;

    @Column(name = "minimum_bp_price")
    private BigDecimal minimumBpPrice;

    @Column(name = "fixed_minimum_price")
    private BigDecimal fixedMinimumPrice;

    @Column(name = "min_minimum_price")
    private BigDecimal minMinimumPrice;

    @Column(name = "comments")
    private String comments;

    @Column(name = "loc_code")
    private String locCode;

    @Column(name = "version")
    private String version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatalogNo() {
        return catalogNo;
    }

    public void setCatalogNo(String catalogNo) {
        this.catalogNo = catalogNo;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getCloningReadyFlag() {
        return cloningReadyFlag;
    }

    public void setCloningReadyFlag(String cloningReadyFlag) {
        this.cloningReadyFlag = cloningReadyFlag;
    }

    public Integer getSeqLengthFrom() {
        return seqLengthFrom;
    }

    public void setSeqLengthFrom(Integer seqLengthFrom) {
        this.seqLengthFrom = seqLengthFrom;
    }

    public Integer getSeqLengthTo() {
        return seqLengthTo;
    }

    public void setSeqLengthTo(Integer seqLengthTo) {
        this.seqLengthTo = seqLengthTo;
    }

    public BigDecimal getListingBpPrice() {
        return listingBpPrice;
    }

    public void setListingBpPrice(BigDecimal listingBpPrice) {
        this.listingBpPrice = listingBpPrice;
    }

    public BigDecimal getFixedListingPrice() {
        return fixedListingPrice;
    }

    public void setFixedListingPrice(BigDecimal fixedListingPrice) {
        this.fixedListingPrice = fixedListingPrice;
    }

    public BigDecimal getMinListingPrice() {
        return minListingPrice;
    }

    public void setMinListingPrice(BigDecimal minListingPrice) {
        this.minListingPrice = minListingPrice;
    }

    public BigDecimal getTransferBpPriceP() {
        return transferBpPriceP;
    }

    public void setTransferBpPriceP(BigDecimal transferBpPriceP) {
        this.transferBpPriceP = transferBpPriceP;
    }

    public BigDecimal getFixedTransferPriceP() {
        return fixedTransferPriceP;
    }

    public void setFixedTransferPriceP(BigDecimal fixedTransferPriceP) {
        this.fixedTransferPriceP = fixedTransferPriceP;
    }

    public BigDecimal getMinTransferPriceP() {
        return minTransferPriceP;
    }

    public void setMinTransferPriceP(BigDecimal minTransferPriceP) {
        this.minTransferPriceP = minTransferPriceP;
    }

    public BigDecimal getTransferBpPriceS() {
        return transferBpPriceS;
    }

    public void setTransferBpPriceS(BigDecimal transferBpPriceS) {
        this.transferBpPriceS = transferBpPriceS;
    }

    public BigDecimal getFixedTransferPriceS() {
        return fixedTransferPriceS;
    }

    public void setFixedTransferPriceS(BigDecimal fixedTransferPriceS) {
        this.fixedTransferPriceS = fixedTransferPriceS;
    }

    public BigDecimal getMinTransferPriceS() {
        return minTransferPriceS;
    }

    public void setMinTransferPriceS(BigDecimal minTransferPriceS) {
        this.minTransferPriceS = minTransferPriceS;
    }

    public BigDecimal getMinimumBpPrice() {
        return minimumBpPrice;
    }

    public void setMinimumBpPrice(BigDecimal minimumBpPrice) {
        this.minimumBpPrice = minimumBpPrice;
    }

    public BigDecimal getFixedMinimumPrice() {
        return fixedMinimumPrice;
    }

    public void setFixedMinimumPrice(BigDecimal fixedMinimumPrice) {
        this.fixedMinimumPrice = fixedMinimumPrice;
    }

    public BigDecimal getMinMinimumPrice() {
        return minMinimumPrice;
    }

    public void setMinMinimumPrice(BigDecimal minMinimumPrice) {
        this.minMinimumPrice = minMinimumPrice;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public BigDecimal getListingVipBpPrice() {
        return listingVipBpPrice;
    }

    public void setListingVipBpPrice(BigDecimal listingVipBpPrice) {
        this.listingVipBpPrice = listingVipBpPrice;
    }

    public BigDecimal getMinVipListingPrice() {
        return minVipListingPrice;
    }

    public void setMinVipListingPrice(BigDecimal minVipListingPrice) {
        this.minVipListingPrice = minVipListingPrice;
    }

    public BigDecimal getVipFixedListingPrice() {
        return vipFixedListingPrice;
    }

    public void setVipFixedListingPrice(BigDecimal vipFixedListingPrice) {
        this.vipFixedListingPrice = vipFixedListingPrice;
    }

    public String getLocCode() {
        return locCode;
    }

    public void setLocCode(String locCode) {
        this.locCode = locCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
