package com.genscript.rule.price;

import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @KSession("ksession")
    private KieSession kieSession;

    public String testDrools(String content) {

        Applicant applicant = new Applicant("Mr John Smith", 20);
        kieSession.insert(applicant);
        kieSession.fireAllRules();

        boolean a = applicant.isValid();

        return "This is Drools:" + a;
    }
}
