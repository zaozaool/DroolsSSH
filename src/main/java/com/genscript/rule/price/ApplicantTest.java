package com.genscript.rule.price;
import org.junit.Assert;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

public class ApplicantTest {

    @Test
    public void testCheckAgeValid(){
        KieServices kieService = KieServices.Factory.get();
        KieContainer kieContainer = kieService.getKieClasspathContainer();
        
        StatelessKieSession kSession = kieContainer.newStatelessKieSession();
        
        Applicant applicant = new Applicant( "Mr John Smith", 20 );
        Assert.assertFalse( applicant.isValid() );
        
        kSession.execute(applicant);
        
        Assert.assertTrue( applicant.isValid() );
    }

}