package com.ftn.sbnz.service;

import com.ftn.sbnz.model.Gender;
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
    public void LifestyleFactorTest(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("psychopathydisorder");

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                Gender.MALE,"mika@gmail.com", "0645533665",1L);

        kieSession.insert(patient);

        Symptom symptom1 = new Symptom("need for stimulation", 5, SymptomGroup.LIFESTYLE_FACTOR, 0);
        Symptom symptom2 = new Symptom("parasitic lifesytle", 5, SymptomGroup.LIFESTYLE_FACTOR, 0);
        Symptom symptom3 = new Symptom("no long-term goals", 4, SymptomGroup.LIFESTYLE_FACTOR, 0);
        Symptom symptom4 = new Symptom("no ambition", 3, SymptomGroup.LIFESTYLE_FACTOR, 0);
        Symptom symptom5 = new Symptom("impulsiveness", 3, SymptomGroup.LIFESTYLE_FACTOR, 0);
        Symptom symptom6 = new Symptom("irresponsibility", 3, SymptomGroup.LIFESTYLE_FACTOR, 0);


        kieSession.insert(symptom1);
        kieSession.insert(symptom2);
        kieSession.insert(symptom3);
        kieSession.insert(symptom4);
        kieSession.insert(symptom5);
        kieSession.insert(symptom6);


        long ruleFireCount = kieSession.fireAllRules();
        System.out.println(ruleFireCount);
    }

    @Test
    public void AffectiveFactorTest(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("psychopathydisorder");

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                Gender.MALE,"mika@gmail.com", "0645533665",1L);

        kieSession.insert(patient);

        Symptom symptom1 = new Symptom("limited affect", 5, SymptomGroup.ANTISOCIAL_FACTOR, 0);
        Symptom symptom2 = new Symptom("no empathy", 5, SymptomGroup.ANTISOCIAL_FACTOR, 0);
        Symptom symptom3 = new Symptom("no responsibility", 4, SymptomGroup.ANTISOCIAL_FACTOR, 0);
        Symptom symptom4 = new Symptom("no remorse", 3, SymptomGroup.ANTISOCIAL_FACTOR, 0);
        Symptom symptom5 = new Symptom("no guilt", 3, SymptomGroup.ANTISOCIAL_FACTOR, 0);

        kieSession.insert(symptom1);
        kieSession.insert(symptom2);
        kieSession.insert(symptom3);
        kieSession.insert(symptom4);
        kieSession.insert(symptom5);


        long ruleFireCount = kieSession.fireAllRules();
        System.out.println(ruleFireCount);
    }

    @Test
    public void InterpersonalFactorTest(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("psychopathydisorder");

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                Gender.MALE,"mika@gmail.com", "0645533665",1L);

        kieSession.insert(patient);

        Symptom symptom1 = new Symptom("grandiosity", 5, SymptomGroup.ANTISOCIAL_FACTOR, 0);
        Symptom symptom2 = new Symptom("pathological lying", 5, SymptomGroup.ANTISOCIAL_FACTOR, 0);
        Symptom symptom3 = new Symptom("manipulativeness", 4, SymptomGroup.ANTISOCIAL_FACTOR, 0);
        Symptom symptom4 = new Symptom("artificial charm", 3, SymptomGroup.ANTISOCIAL_FACTOR, 0);

        kieSession.insert(symptom1);
        kieSession.insert(symptom2);
        kieSession.insert(symptom3);
        kieSession.insert(symptom4);


        long ruleFireCount = kieSession.fireAllRules();
        System.out.println(ruleFireCount);
    }

    @Test
    public void AntisocialFactorTest(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("psychopathydisorder");

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                Gender.MALE,"mika@gmail.com", "0645533665",1L);

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
