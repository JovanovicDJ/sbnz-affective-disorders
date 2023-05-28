package com.ftn.sbnz.service;

import com.ftn.sbnz.model.*;
import org.drools.core.ClockType;
import org.drools.template.DataProvider;
import org.drools.template.DataProviderCompiler;
import org.drools.template.ObjectDataCompiler;
import org.drools.template.objects.ArrayDataProvider;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.conf.ClockTypeOption;
import org.kie.api.time.SessionPseudoClock;
import org.kie.internal.utils.KieHelper;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AffectiveDisordersTests {

    @Test
    public void DepressionEpisodeTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                                      GenderType.MALE,"mika@gmail.com","testpass", "0645533665");

        kieSession.insert(patient);

        Symptom symptom1 = new Symptom("affect", 5, SymptomGroup.DEPRESSIVE_EPISODE, 0);
        Symptom symptom2 = new Symptom("anhedonia", 5, SymptomGroup.DEPRESSIVE_EPISODE, 0);
        Symptom symptom3 = new Symptom("pessimism", 4, SymptomGroup.DEPRESSIVE_EPISODE, 0);
        Symptom symptom4 = new Symptom("concentration", 3, SymptomGroup.DEPRESSIVE_EPISODE, 0);
        Symptom symptom5 = new Symptom("hopelessness", 5, SymptomGroup.DEPRESSIVE_EPISODE, 0);
        Symptom symptom6 = new Symptom("worthlessness", 4, SymptomGroup.DEPRESSIVE_EPISODE, 0);
        Symptom symptom7 = new Symptom("suicidal ideation", 3, SymptomGroup.DEPRESSIVE_EPISODE, 0);
        Symptom symptom8 = new Symptom("disturbed sleep", 5, SymptomGroup.DEPRESSIVE_EPISODE, 0);
        Symptom symptom9 = new Symptom("low energy level", 3, SymptomGroup.DEPRESSIVE_EPISODE, 0);
        Symptom symptom10 = new Symptom("disturbed appetite", 4, SymptomGroup.DEPRESSIVE_EPISODE, 0);
        Symptom symptom11 = new Symptom("negligence", 5, SymptomGroup.DEPRESSIVE_EPISODE, 0);
        Symptom symptom12 = new Symptom("duration", 5, SymptomGroup.DEPRESSIVE_EPISODE, 0);

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

        kieSession.setGlobal("maxRuleExecuted", false);

        long ruleFireCount = kieSession.fireAllRules();
        System.out.println(ruleFireCount);
        kieSession.setGlobal("maxRuleExecuted", true);
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

        Symptom symptom1 = new Symptom("tension", 5, SymptomGroup.DE_WITH_ANXIETY, 0);
        Symptom symptom2 = new Symptom("unrest", 4, SymptomGroup.DE_WITH_ANXIETY, 0);
        Symptom symptom3 = new Symptom("concern", 3, SymptomGroup.DE_WITH_ANXIETY, 0);
        Symptom symptom4 = new Symptom("assuming the worst", 5, SymptomGroup.DE_WITH_ANXIETY, 0);
        Symptom symptom5 = new Symptom("fear of losing control", 4, SymptomGroup.DE_WITH_ANXIETY, 0);
        Symptom symptom6 = new Symptom("concentration", 5, SymptomGroup.DEPRESSIVE_EPISODE, 0);

        kieSession.insert(symptom1);
        kieSession.insert(symptom2);
        kieSession.insert(symptom3);
        kieSession.insert(symptom4);
        kieSession.insert(symptom5);
        kieSession.insert(symptom6);

        kieSession.setGlobal("maxRuleExecuted", false);

        long ruleFireCount = kieSession.fireAllRules();
        System.out.println(ruleFireCount);
        kieSession.setGlobal("maxRuleExecuted", true);
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

        Symptom symptom1 = new Symptom("loss of interest", 4, SymptomGroup.DE_WITH_MELANCHOLY, 0);
        Symptom symptom2 = new Symptom("loss of emotional reactivity to positive dearer", 5, SymptomGroup.DE_WITH_MELANCHOLY, 0);
        Symptom symptom3 = new Symptom("emptiness", 4, SymptomGroup.DE_WITH_MELANCHOLY, 0);
        Symptom symptom4 = new Symptom("disturbed sleep", 5, SymptomGroup.DEPRESSIVE_EPISODE, 0);
        Symptom symptom5 = new Symptom("disturbed appetite", 4, SymptomGroup.DEPRESSIVE_EPISODE, 0);
        Symptom symptom6 = new Symptom("loss of libido", 3, SymptomGroup.DE_WITH_MELANCHOLY, 0);

        kieSession.insert(symptom1);
        kieSession.insert(symptom2);
        kieSession.insert(symptom3);
        kieSession.insert(symptom4);
        kieSession.insert(symptom5);
        kieSession.insert(symptom6);

        kieSession.setGlobal("maxRuleExecuted", false);

        long ruleFireCount = kieSession.fireAllRules();
        System.out.println(ruleFireCount);
        kieSession.setGlobal("maxRuleExecuted", true);
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

        Symptom symptom1 = new Symptom("mood reactivity", 5, SymptomGroup.DE_WITH_ATYPICAL_FEATURES, 0);
        Symptom symptom2 = new Symptom("appetite increase", 4, SymptomGroup.DE_WITH_ATYPICAL_FEATURES, 0);
        Symptom symptom3 = new Symptom("sensitivity to interpersonal rejection", 4, SymptomGroup.DE_WITH_ATYPICAL_FEATURES, 0);

        kieSession.insert(symptom1);
        kieSession.insert(symptom2);
        kieSession.insert(symptom3);

        kieSession.setGlobal("maxRuleExecuted", false);

        long ruleFireCount = kieSession.fireAllRules();
        System.out.println(ruleFireCount);
        kieSession.setGlobal("maxRuleExecuted", true);
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

        Symptom symptom1 = new Symptom("guilt", 4, SymptomGroup.DE_WITH_PSYCHOTIC_FEATURES, 0);
        Symptom symptom2 = new Symptom("sinfulness", 3, SymptomGroup.DE_WITH_PSYCHOTIC_FEATURES, 0);
        Symptom symptom3 = new Symptom("perdition", 3, SymptomGroup.DE_WITH_PSYCHOTIC_FEATURES, 0);
        Symptom symptom4 = new Symptom("hypochondriacal", 5, SymptomGroup.DE_WITH_PSYCHOTIC_FEATURES, 0);
        Symptom symptom5 = new Symptom("nihilistic", 5, SymptomGroup.DE_WITH_PSYCHOTIC_FEATURES, 0);

        kieSession.insert(symptom1);
        kieSession.insert(symptom2);
        kieSession.insert(symptom3);
        kieSession.insert(symptom4);
        kieSession.insert(symptom5);

        kieSession.setGlobal("maxRuleExecuted", false);

        long ruleFireCount = kieSession.fireAllRules();
        System.out.println(ruleFireCount);
        kieSession.setGlobal("maxRuleExecuted", true);
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

        Symptom symptom1 = new Symptom("in pregnancy", 5, SymptomGroup.DE_WITH_PERIPARTUM_ONSET, 0);
        Symptom symptom2 = new Symptom("after pregnancy", 1, SymptomGroup.DE_WITH_PERIPARTUM_ONSET, 0);

        kieSession.insert(symptom1);
        kieSession.insert(symptom2);

        kieSession.setGlobal("maxRuleExecuted", false);

        long ruleFireCount = kieSession.fireAllRules();
        System.out.println(ruleFireCount);
        kieSession.setGlobal("maxRuleExecuted", true);
    }


    @Test
    public void ChooseHighestIntensityTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");

        Patient patient = new Patient(0,"Mikasa","Mikic", LocalDate.of(2000, 2, 15),
                GenderType.FEMALE,"mika@gmail.com","testpass", "0645533665");
        kieSession.insert(new DepressiveEpisode(DepressionType.WITH_ANXIETY, 0, 78, false));
        kieSession.insert(new DepressiveEpisode(DepressionType.WITH_MELANCHOLY, 0, 85, false));
        kieSession.insert(new DepressiveEpisode(DepressionType.WITH_PSYCHOTIC_FEATURES, 0, 65, false));
        kieSession.insert(patient);;

        kieSession.setGlobal("maxRuleExecuted", false);

        long ruleFireCount = kieSession.fireAllRules();
        System.out.println(ruleFireCount);
        kieSession.setGlobal("maxRuleExecuted", true);
    }

    @Test
    public void PseudoClockTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSessionConfiguration config = KieServices.Factory.get().newKieSessionConfiguration();
        //config.setOption(ClockTypeOption.get("pseudo"));
        config.setOption(ClockTypeOption.get(ClockType.PSEUDO_CLOCK.getId()));
        //KieSession kieSession = kc.newKieSession(config);
        KieSession kieSession = kc.newKieSession("affectivedisorders", config);
        SessionPseudoClock clock = kieSession.getSessionClock();
        long startTime = System.currentTimeMillis();
        clock.advanceTime(startTime, TimeUnit.MILLISECONDS);

        kieSession.insert(new DepressiveEpisode(DepressionType.WITH_ANXIETY, 0, 78, false));
        System.out.println(new Date(clock.getCurrentTime()));
        clock.advanceTime(40, TimeUnit.DAYS);
        kieSession.insert(new ManicEpisode(ManiaType.MANIA, 0, 35, true));
        System.out.println(new Date(clock.getCurrentTime()));

        Patient patient = new Patient(0,"Mikasa","Mikic", LocalDate.of(2000, 2, 15),
                GenderType.FEMALE,"mika@gmail.com","testpass", "0645533665");

        kieSession.insert(patient);

        kieSession.setGlobal("maxRuleExecuted", false);

        long ruleFireCount = kieSession.fireAllRules();
        System.out.println(ruleFireCount);
        kieSession.setGlobal("maxRuleExecuted", true);
    }

    @Test
    public void TemplateTest() {
        InputStream template = AffectiveDisordersTests.class.getResourceAsStream("/template/template.drt");

        DataProvider dataProvider = new ArrayDataProvider(new String[][]{
            new String[]{"3", "4", "42", "52", "70"}
        });

        DataProviderCompiler converter = new DataProviderCompiler();
        String drl = converter.compile(dataProvider, template);

        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drl, ResourceType.DRL);
        KieSession kieSession = kieHelper.build().newKieSession();
        kieSession.insert(new Symptom("euphoria", 5, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("irritability", 3, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("expansiveness", 4, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("talkative", 5, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("grandiose ideas", 1, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("hyperoptimism", 5, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("distractibility", 1, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("no sleep", 2, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("increased energy", 4, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("excessive activity", 5, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("impulsiveness", 1, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("aggressiveness", 1, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("disinhibition", 1, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("duration", 5, SymptomGroup.MANIC_EPISODE, 0));

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                GenderType.MALE,"mika@gmail.com","testpass", "0645533665");

        kieSession.insert(patient);
        long ruleFireCount = kieSession.fireAllRules();
        System.out.println(ruleFireCount);
    }
}
