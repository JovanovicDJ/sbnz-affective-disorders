package com.ftn.sbnz.service;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.text.ParseException;

public class AffectiveDisordersTests {
    @Test
    public void test() throws ParseException {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");

        kieSession.insert("Affective Disorders");

        long ruleFireCount = kieSession.fireAllRules();
        System.out.println(ruleFireCount);
    }
}
