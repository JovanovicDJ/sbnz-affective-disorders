package com.ftn.sbnz.service;

import com.ftn.sbnz.model.*;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.time.LocalDate;

public class CepTest {

//    @Test
//    public void CyclothomyaTest(){
//
//        KieServices ks = KieServices.Factory.get();
//        KieContainer kc = ks.newKieClasspathContainer();
//        KieSession kieSession = kc.newKieSession("affectivedisorders");
//
//        Patient patient = new Patient(0,"Mikasa","Mikic", LocalDate.of(2000, 2, 15),
//                Gender.FEMALE,"mika@gmail.com", "0645533665",1L);
//        kieSession.insert(patient);;
//
//        for(int i = 0 ; i < 24 ; i++)
//        {
//            kieSession.insert(new BipolarDisorder(BipolarDisorderType.WITH_ANXIETY,patient,LocalDate.now().minusMonths(i),20,true));
//        }
//        kieSession.setGlobal("maxRuleExecuted", false);
//
//        long ruleFireCount = kieSession.fireAllRules();
//        System.out.println(ruleFireCount);
//        kieSession.setGlobal("maxRuleExecuted", true);
//    }
}
