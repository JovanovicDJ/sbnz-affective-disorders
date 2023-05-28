package com.ftn.sbnz.service;

import com.ftn.sbnz.model.GenderType;
import com.ftn.sbnz.model.Patient;
import com.ftn.sbnz.model.Symptom;
import com.ftn.sbnz.model.SymptomGroup;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.time.LocalDate;

public class PsychopathyDisorderTest {

    @Test
    public void LifstyleFactorTest(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("psychopathydisorder");

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                GenderType.MALE,"mika@gmail.com","testpass", "0645533665");

        kieSession.insert(patient);

        Symptom symptom1 = new Symptom("weak control", 5, SymptomGroup.ANTISOCIAL_FACTOR, 0);
        Symptom symptom2 = new Symptom("early behavior problems", 5, SymptomGroup.ANTISOCIAL_FACTOR, 0);
        Symptom symptom3 = new Symptom("juvenile delinquency", 4, SymptomGroup.ANTISOCIAL_FACTOR, 0);
        Symptom symptom4 = new Symptom("criminal diversity", 3, SymptomGroup.ANTISOCIAL_FACTOR, 0);

        kieSession.insert(symptom1);
        kieSession.insert(symptom2);
        kieSession.insert(symptom3);
        kieSession.insert(symptom4);


        long ruleFireCount = kieSession.fireAllRules();
        System.out.println(ruleFireCount);
    }
}
