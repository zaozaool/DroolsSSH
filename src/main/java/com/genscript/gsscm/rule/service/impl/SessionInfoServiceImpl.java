/**
 * <p>Project: RMS</p>
 * <p>File: VersionServiceImpl.java</p>
 * <p>Copyright: Copyright (c) 2016.All rights reserved.</p>
 * <p>Company:www.genscript.com</p>
 * Date:2016-4-26
 * @author:Administrator
 */
package com.genscript.gsscm.rule.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.genscript.gsscm.rule.dao.SessionInfoDao;
import com.genscript.gsscm.rule.entity.SessionInfo;
import com.genscript.gsscm.rule.service.SessionInfoService;

@Service
@Transactional
public class SessionInfoServiceImpl implements SessionInfoService {

    @Autowired
    private SessionInfoDao sessionInfoDao;

    public void list() {
        List<SessionInfo> list = sessionInfoDao.getAll();
        for (SessionInfo s : list) {
            System.out.println(s.getId() + " : " + s.getLastModificationDate());
        }
        list.get(0).setLastModificationDate(new Date());
    }

}
