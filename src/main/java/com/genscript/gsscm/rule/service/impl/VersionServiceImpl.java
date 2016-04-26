/**
 * <p>Project: RMS</p>
 * <p>File: VersionServiceImpl.java</p>
 * <p>Copyright: Copyright (c) 2016.All rights reserved.</p>
 * <p>Company:www.genscript.com</p>
 * Date:2016-4-26
 * @author:Administrator
 */
package com.genscript.gsscm.rule.service.impl;

import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.genscript.gsscm.rule.fact.BaseFact;
import com.genscript.gsscm.rule.service.VersionService;

@Service
@Transactional
public class VersionServiceImpl implements VersionService {

    @KSession("ksession")
    private KieSession kieSession;

    public void getVersion(BaseFact fact) {
        kieSession.insert(fact);
        kieSession.fireAllRules();
        // kieSession.dispose();
    }

}
