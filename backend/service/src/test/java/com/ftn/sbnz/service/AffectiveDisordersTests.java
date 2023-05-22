package com.ftn.sbnz.service;

import com.ftn.sbnz.model.*;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.time.LocalDate;

public class AffectiveDisordersTests {

    @Test
    public void DepressionEpisodeTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                                      GenderType.MALE,"mika@gmail.com","testpass", "0645533665");

        kieSession.insert(patient);

        Symptom symptom1 = new Symptom("affect", 5, SymptomGroup.DEPRESSIVE_EPISODE);
        Symptom symptom2 = new Symptom("anhedonia", 5, SymptomGroup.DEPRESSIVE_EPISODE);
        Symptom symptom3 = new Symptom("pessimism", 4, SymptomGroup.DEPRESSIVE_EPISODE);
        Symptom symptom4 = new Symptom("concentration", 3, SymptomGroup.DEPRESSIVE_EPISODE);
        Symptom symptom5 = new Symptom("hopelessness", 5, SymptomGroup.DEPRESSIVE_EPISODE);
        Symptom symptom6 = new Symptom("worthlessness", 4, SymptomGroup.DEPRESSIVE_EPISODE);
        Symptom symptom7 = new Symptom("suicidal ideation", 3, SymptomGroup.DEPRESSIVE_EPISODE);
        Symptom symptom8 = new Symptom("disturbed sleep", 5, SymptomGroup.DEPRESSIVE_EPISODE);
        Symptom symptom9 = new Symptom("low energy level", 3, SymptomGroup.DEPRESSIVE_EPISODE);
        Symptom symptom10 = new Symptom("disturbed appetite", 4, SymptomGroup.DEPRESSIVE_EPISODE);
        Symptom symptom11 = new Symptom("negligence", 5, SymptomGroup.DEPRESSIVE_EPISODE);
        Symptom symptom12 = new Symptom("duration", 5, SymptomGroup.DEPRESSIVE_EPISODE);

        kieSession.insert(symptom1);
        kieSession.insert(symptom2);
        kieSession.insert(symptom3);
        kieSession.insert(symptom4);
        kieSession.insert(symptom5);
        kieSession.insert(symptom6);
        kieSession.insert(symptom7);
        kieSession.insert(symptom8);
        kieSession.insert(symptom9);
        kieSession.insert(symptom10);
        kieSession.insert(symptom11);
        kieSession.insert(symptom12);

        long ruleFireCount = kieSession.fireAllRules();
        System.out.println(ruleFireCount);
    }

    @Test
    public void DepressionWithAnxiousAgitationTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                GenderType.MALE,"mika@gmail.com","testpass", "0645533665");
        DepressionEvent depressionEvent = new DepressionEvent(0, 51);

        kieSession.insert(patient);
        kieSession.insert(depressionEvent);

        Symptom symptom1 = new Symptom("tension", 5, SymptomGroup.DE_WITH_ANXIETY);
        Symptom symptom2 = new Symptom("unrest", 4, SymptomGroup.DE_WITH_ANXIETY);
        Symptom symptom3 = new Symptom("concern", 3, SymptomGroup.DE_WITH_ANXIETY);
        Symptom symptom4 = new Symptom("assuming the worst", 5, SymptomGroup.DE_WITH_ANXIETY);
        Symptom symptom5 = new Symptom("fear of losing control", 4, SymptomGroup.DE_WITH_ANXIETY);
        Symptom symptom6 = new Symptom("concentration", 5, SymptomGroup.DEPRESSIVE_EPISODE);

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
    public void DepressionWithMelancholicFeaturesTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                GenderType.MALE,"mika@gmail.com","testpass", "0645533665");
        DepressionEvent depressionEvent = new DepressionEvent(0, 51);

        kieSession.insert(patient);
        kieSession.insert(depressionEvent);

        Symptom symptom1 = new Symptom("loss of interest", 4, SymptomGroup.DE_WITH_MELANCHOLY);
        Symptom symptom2 = new Symptom("loss of emotional reactivity to positive dearer", 5, SymptomGroup.DE_WITH_MELANCHOLY);
        Symptom symptom3 = new Symptom("emptiness", 4, SymptomGroup.DE_WITH_MELANCHOLY);
        Symptom symptom4 = new Symptom("disturbed sleep", 5, SymptomGroup.DEPRESSIVE_EPISODE);
        Symptom symptom5 = new Symptom("disturbed appetite", 4, SymptomGroup.DEPRESSIVE_EPISODE);
        Symptom symptom6 = new Symptom("loss of libido", 3, SymptomGroup.DE_WITH_MELANCHOLY);

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
    public void DepressionWithAtypicalFeaturesTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                GenderType.MALE,"mika@gmail.com","testpass", "0645533665");
        DepressionEvent depressionEvent = new DepressionEvent(0, 51);

        kieSession.insert(patient);
        kieSession.insert(depressionEvent);

        Symptom symptom1 = new Symptom("mood reactivity", 5, SymptomGroup.DE_WITH_ATYPICAL_FEATURES);
        Symptom symptom2 = new Symptom("appetite increase", 4, SymptomGroup.DE_WITH_ATYPICAL_FEATURES);
        Symptom symptom3 = new Symptom("sensitivity to interpersonal rejection", 4, SymptomGroup.DE_WITH_ATYPICAL_FEATURES);

        kieSession.insert(symptom1);
        kieSession.insert(symptom2);
        kieSession.insert(symptom3);

        long ruleFireCount = kieSession.fireAllRules();
        System.out.println(ruleFireCount);
    }

    @Test
    public void DepressionWithPsychoticFeatures() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                GenderType.MALE,"mika@gmail.com","testpass", "0645533665");
        DepressionEvent depressionEvent = new DepressionEvent(0, 51);

        kieSession.insert(patient);
        kieSession.insert(depressionEvent);

        Symptom symptom1 = new Symptom("guilt", 4, SymptomGroup.DE_WITH_PSYCHOTIC_FEATURES);
        Symptom symptom2 = new Symptom("sinfulness", 3, SymptomGroup.DE_WITH_PSYCHOTIC_FEATURES);
        Symptom symptom3 = new Symptom("perdition", 3, SymptomGroup.DE_WITH_PSYCHOTIC_FEATURES);
        Symptom symptom4 = new Symptom("hypochondriacal", 5, SymptomGroup.DE_WITH_PSYCHOTIC_FEATURES);
        Symptom symptom5 = new Symptom("nihilistic", 5, SymptomGroup.DE_WITH_PSYCHOTIC_FEATURES);

        kieSession.insert(symptom1);
        kieSession.insert(symptom2);
        kieSession.insert(symptom3);
        kieSession.insert(symptom4);
        kieSession.insert(symptom5);

        long ruleFireCount = kieSession.fireAllRules();
        System.out.println(ruleFireCount);
    }

    @Test
    public void DepressionWithParipartumOnsetTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");

        Patient patient = new Patient(0,"Mikasa","Mikic", LocalDate.of(2000, 2, 15),
                GenderType.FEMALE,"mika@gmail.com","testpass", "0645533665");
        DepressionEvent depressionEvent = new DepressionEvent(0, 51);

        kieSession.insert(patient);
        kieSession.insert(depressionEvent);

        Symptom symptom1 = new Symptom("in pregnancy", 5, SymptomGroup.DE_WITH_PERIPARTUM_ONSET);
        Symptom symptom2 = new Symptom("after pregnancy", 1, SymptomGroup.DE_WITH_PERIPARTUM_ONSET);

        kieSession.insert(symptom1);
        kieSession.insert(symptom2);

        long ruleFireCount = kieSession.fireAllRules();
        System.out.println(ruleFireCount);
    }
}
