package com.genscript.gsscm.rule.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.genscript.gsscm.rule.dao.LastestVersionDao;
import com.genscript.gsscm.rule.entity.LastestVersion;
import com.genscript.gsscm.rule.service.VersionService;

@Service
@Transactional
public class VersionServiceImpl implements VersionService {

    @Autowired
    private LastestVersionDao lastestVersionDao;

    /**
     * 最对不同的规则得到最新的版本号
     */
    public String getLastestVersion(String ruleName) {
        LastestVersion v = lastestVersionDao.findUniqueBy("ruleName", ruleName);
        if (v != null) {
            return v.getVersion();
        }
        return null;
    }

}
