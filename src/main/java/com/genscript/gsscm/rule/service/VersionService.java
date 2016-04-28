package com.genscript.gsscm.rule.service;

public interface VersionService {

    /**
     * 最对不同的规则得到最新的版本号
     */
    public String getLastestVersion(String versionName);

}
