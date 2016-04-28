package com.genscript.gsscm.rule.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhangyong
 */
@Entity
@Table(name = "lastest_version", catalog = "drools")
public class LastestVersion implements Serializable {

    private static final long serialVersionUID = 224787341827238476L;

    @Id
    @Column(name = "version_id")
    private Integer versionId;

    @Column(name = "site")
    private String site;

    @Column(name = "action_type")
    private String actionType;

    @Column(name = "rule_name")
    private String ruleName;

    @Column(name = "version")
    private String version;

    @Column(name = "comments")
    private String comments;

    @Column(name = "creation_date", insertable = true, updatable = false)
    private Date creationDate;

    @Column(name = "created_by", insertable = true, updatable = false)
    private Integer createdBy;

    @Column(name = "modify_date")
    private Date modifyDate;

    @Column(name = "modified_by")
    private Integer modifiedBy;

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

}
