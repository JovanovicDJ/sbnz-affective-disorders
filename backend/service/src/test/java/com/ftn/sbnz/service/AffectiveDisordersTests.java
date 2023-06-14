package com.ftn.sbnz.service;

import com.ftn.sbnz.model.*;
import org.drools.core.ClockType;
import org.drools.template.DataProvider;
import org.drools.template.DataProviderCompiler;
import org.drools.template.objects.ArrayDataProvider;
import org.junit.jupiter.api.Assertions;
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
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AffectiveDisordersTests {
    @Test
    public void DepressionEventTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");

        Patient patient = new Patient(0, "Mika", "Mikic", LocalDate.of(2000, 2, 15),
                Gender.MALE, "mika@gmail.com", "0645533665", 1L);
        kieSession.insert(patient);
        kieSession.insert(new Symptom("low affect", 5, SymptomGroup.DEPRESSIVE_EPISODE, 0));
        kieSession.insert(new Symptom("anhedonia", 5, SymptomGroup.DEPRESSIVE_EPISODE, 0));
        kieSession.insert(new Symptom("pessimism", 4, SymptomGroup.DEPRESSIVE_EPISODE, 0));
        kieSession.insert(new Symptom("low concentration", 3, SymptomGroup.DEPRESSIVE_EPISODE, 0));
        kieSession.insert(new Symptom("hopelessness", 5, SymptomGroup.DEPRESSIVE_EPISODE, 0));
        kieSession.insert(new Symptom("worthlessness", 4, SymptomGroup.DEPRESSIVE_EPISODE, 0));
        kieSession.insert(new Symptom("suicidal ideation", 3, SymptomGroup.DEPRESSIVE_EPISODE, 0));
        kieSession.insert(new Symptom("disturbed sleep", 5, SymptomGroup.DEPRESSIVE_EPISODE, 0));
        kieSession.insert(new Symptom("low energy level", 3, SymptomGroup.DEPRESSIVE_EPISODE, 0));
        kieSession.insert(new Symptom("disturbed appetite", 4, SymptomGroup.DEPRESSIVE_EPISODE, 0));
        kieSession.insert(new Symptom("negligence", 5, SymptomGroup.DEPRESSIVE_EPISODE, 0));
        kieSession.insert(new Symptom("duration", 5, SymptomGroup.DEPRESSIVE_EPISODE, 0));
        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        DepressionEvent depressionEvent = null;
        for (Object object : objects) {
            if (object instanceof DepressionEvent) {
                depressionEvent = (DepressionEvent) object;
            }
        }
        Assertions.assertNotNull(depressionEvent);
        Assertions.assertEquals(51, depressionEvent.getIntensity());
    }

    @Test
    public void DepressionWithAnxiousAgitationTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                Gender.MALE,"mika@gmail.com", "0645533665",1L);
        DepressionEvent depressionEvent = new DepressionEvent(patient, 51);
        kieSession.insert(patient);
        kieSession.insert(depressionEvent);
        kieSession.insert(new Symptom("tension", 5, SymptomGroup.DE_WITH_ANXIETY, 0));
        kieSession.insert(new Symptom("unrest", 4, SymptomGroup.DE_WITH_ANXIETY, 0));
        kieSession.insert(new Symptom("concern", 3, SymptomGroup.DE_WITH_ANXIETY, 0));
        kieSession.insert(new Symptom("assuming the worst", 5, SymptomGroup.DE_WITH_ANXIETY, 0));
        kieSession.insert(new Symptom("fear of losing control", 4, SymptomGroup.DE_WITH_ANXIETY, 0));
        kieSession.insert(new Symptom("low concentration", 5, SymptomGroup.DEPRESSIVE_EPISODE, 0));
        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        DepressiveEpisode depressionEpisode = null;
        for (Object object : objects) {
            if (object instanceof DepressiveEpisode) {
                depressionEpisode = (DepressiveEpisode) object;
            }
        }
        Assertions.assertNotNull(depressionEpisode);
        Assertions.assertEquals(72, depressionEpisode.getIntensitySum());
        Assertions.assertEquals(DepressionType.WITH_ANXIETY, depressionEpisode.getDepressionType());
    }

    @Test
    public void DepressionWithMelancholicFeaturesTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                Gender.MALE,"mika@gmail.com", "0645533665",1L);
        DepressionEvent depressionEvent = new DepressionEvent(patient, 51);
        kieSession.insert(patient);
        kieSession.insert(depressionEvent);
        kieSession.insert(new Symptom("loss of interest", 4, SymptomGroup.DE_WITH_MELANCHOLY, 0));
        kieSession.insert(new Symptom("loss of emotional reactivity to positive dearer", 5, SymptomGroup.DE_WITH_MELANCHOLY, 0));
        kieSession.insert(new Symptom("emptiness", 4, SymptomGroup.DE_WITH_MELANCHOLY, 0));
        kieSession.insert(new Symptom("disturbed sleep", 5, SymptomGroup.DEPRESSIVE_EPISODE, 0));
        kieSession.insert(new Symptom("disturbed appetite", 4, SymptomGroup.DEPRESSIVE_EPISODE, 0));
        kieSession.insert(new Symptom("loss of libido", 3, SymptomGroup.DE_WITH_MELANCHOLY, 0));
        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        DepressiveEpisode depressionEpisode = null;
        for (Object object : objects) {
            if (object instanceof DepressiveEpisode) {
                depressionEpisode = (DepressiveEpisode) object;
            }
        }
        Assertions.assertNotNull(depressionEpisode);
        Assertions.assertEquals(67, depressionEpisode.getIntensitySum());
        Assertions.assertEquals(DepressionType.WITH_MELANCHOLY, depressionEpisode.getDepressionType());
    }

    @Test
    public void DepressionWithAtypicalFeaturesTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                Gender.MALE,"mika@gmail.com", "0645533665",1L);
        DepressionEvent depressionEvent = new DepressionEvent(patient, 51);
        kieSession.insert(patient);
        kieSession.insert(depressionEvent);
        kieSession.insert(new Symptom("mood reactivity", 5, SymptomGroup.DE_WITH_ATYPICAL_FEATURES, 0));
        kieSession.insert(new Symptom("appetite increase", 4, SymptomGroup.DE_WITH_ATYPICAL_FEATURES, 0));
        kieSession.insert(new Symptom("sensitivity to interpersonal rejection", 4, SymptomGroup.DE_WITH_ATYPICAL_FEATURES, 0));
        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        DepressiveEpisode depressionEpisode = null;
        for (Object object : objects) {
            if (object instanceof DepressiveEpisode) {
                depressionEpisode = (DepressiveEpisode) object;
            }
        }
        Assertions.assertNotNull(depressionEpisode);
        Assertions.assertEquals(64, depressionEpisode.getIntensitySum());
        Assertions.assertEquals(DepressionType.WITH_ATYPICAL_FEATURES, depressionEpisode.getDepressionType());
    }

    @Test
    public void DepressionWithPsychoticFeatures() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                Gender.MALE,"mika@gmail.com", "0645533665",1L);
        DepressionEvent depressionEvent = new DepressionEvent(patient, 51);
        kieSession.insert(patient);
        kieSession.insert(depressionEvent);
        kieSession.insert(new Symptom("guilt", 4, SymptomGroup.DE_WITH_PSYCHOTIC_FEATURES, 0));
        kieSession.insert(new Symptom("sinfulness", 3, SymptomGroup.DE_WITH_PSYCHOTIC_FEATURES, 0));
        kieSession.insert(new Symptom("perdition", 3, SymptomGroup.DE_WITH_PSYCHOTIC_FEATURES, 0));
        kieSession.insert(new Symptom("hypochondriacal", 5, SymptomGroup.DE_WITH_PSYCHOTIC_FEATURES, 0));
        kieSession.insert(new Symptom("nihilistic", 5, SymptomGroup.DE_WITH_PSYCHOTIC_FEATURES, 0));
        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        DepressiveEpisode depressionEpisode = null;
        for (Object object : objects) {
            if (object instanceof DepressiveEpisode) {
                depressionEpisode = (DepressiveEpisode) object;
            }
        }
        Assertions.assertNotNull(depressionEpisode);
        Assertions.assertEquals(71, depressionEpisode.getIntensitySum());
        Assertions.assertEquals(DepressionType.WITH_PSYCHOTIC_FEATURES, depressionEpisode.getDepressionType());
    }

    @Test
    public void DepressionWithParipartumOnsetInPregnancyTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");

        Patient patient = new Patient(0,"Mikasa","Mikic", LocalDate.of(2000, 2, 15),
                Gender.FEMALE,"mika@gmail.com", "0645533665",1L);
        DepressionEvent depressionEvent = new DepressionEvent(patient, 51);
        kieSession.insert(patient);
        kieSession.insert(depressionEvent);
        kieSession.insert(new Symptom("in pregnancy", 5, SymptomGroup.DE_WITH_PERIPARTUM_ONSET, 0));
        kieSession.insert(new Symptom("after pregnancy", 1, SymptomGroup.DE_WITH_PERIPARTUM_ONSET, 0));
        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        DepressiveEpisode depressionEpisode = null;
        for (Object object : objects) {
            if (object instanceof DepressiveEpisode) {
                depressionEpisode = (DepressiveEpisode) object;
            }
        }
        Assertions.assertNotNull(depressionEpisode);
        Assertions.assertEquals(56, depressionEpisode.getIntensitySum());
        Assertions.assertEquals(DepressionType.WITH_PERIPARTUM_ONSET, depressionEpisode.getDepressionType());
    }

    @Test
    public void DepressionWithParipartumOnsetAfterPregnancyTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");

        Patient patient = new Patient(0,"Mikasa","Mikic", LocalDate.of(2000, 2, 15),
                Gender.FEMALE,"mika@gmail.com", "0645533665",1L);
        DepressionEvent depressionEvent = new DepressionEvent(patient, 51);
        kieSession.insert(patient);
        kieSession.insert(depressionEvent);
        kieSession.insert(new Symptom("in pregnancy", 1, SymptomGroup.DE_WITH_PERIPARTUM_ONSET, 0));
        kieSession.insert(new Symptom("after pregnancy", 5, SymptomGroup.DE_WITH_PERIPARTUM_ONSET, 0));
        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        DepressiveEpisode depressionEpisode = null;
        for (Object object : objects) {
            if (object instanceof DepressiveEpisode) {
                depressionEpisode = (DepressiveEpisode) object;
            }
        }
        Assertions.assertNotNull(depressionEpisode);
        Assertions.assertEquals(56, depressionEpisode.getIntensitySum());
        Assertions.assertEquals(DepressionType.WITH_PERIPARTUM_ONSET, depressionEpisode.getDepressionType());
    }

    @Test
    public void HighestIntensityDepressiveEpisodeTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");

        Patient patient = new Patient(0,"Mikasa","Mikic", LocalDate.of(2000, 2, 15),
                Gender.FEMALE,"mika@gmail.com", "0645533665",1L);
        kieSession.insert(new DepressiveEpisode(DepressionType.WITH_ANXIETY, patient, 78, false));
        kieSession.insert(new DepressiveEpisode(DepressionType.WITH_MELANCHOLY, patient, 85, false));
        kieSession.insert(new DepressiveEpisode(DepressionType.WITH_PSYCHOTIC_FEATURES, patient, 65, false));
        kieSession.insert(patient);
        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        DepressiveEpisode depressionEpisode = null;
        for (Object object : objects) {
            if (object instanceof DepressiveEpisode) {
                depressionEpisode = (DepressiveEpisode) object;
            }
        }
        Assertions.assertNotNull(depressionEpisode);
        Assertions.assertEquals(85, depressionEpisode.getIntensitySum());
        Assertions.assertEquals(DepressionType.WITH_MELANCHOLY, depressionEpisode.getDepressionType());
    }

    @Test
    public void BipolarDisorderWithAnxiousAgitationTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSessionConfiguration config = KieServices.Factory.get().newKieSessionConfiguration();
        config.setOption(ClockTypeOption.get(ClockType.PSEUDO_CLOCK.getId()));
        KieSession kieSession = kc.newKieSession("affectivedisorders", config);
        SessionPseudoClock clock = kieSession.getSessionClock();
        long startTime = System.currentTimeMillis();
        clock.advanceTime(startTime, TimeUnit.MILLISECONDS);

        Patient patient = new Patient(0,"Mikasa","Mikic", LocalDate.of(2000, 2, 15),
                Gender.FEMALE,"mika@gmail.com", "0645533665",1L);
        kieSession.insert(patient);
        DepressiveEpisode de = new DepressiveEpisode(DepressionType.WITH_ANXIETY, patient, 78, false);
        kieSession.insert(de);
        clock.advanceTime(59, TimeUnit.DAYS);
        ManicEpisode me = new ManicEpisode(ManiaType.MANIA, patient, 58, true);
        kieSession.insert(me);

        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        BipolarDisorder bipolarDisorder = null;
        for (Object object : objects) {
            if (object instanceof BipolarDisorder) {
                bipolarDisorder = (BipolarDisorder) object;
            }
        }
        Assertions.assertNotNull(bipolarDisorder);
        Assertions.assertEquals(136, bipolarDisorder.getIntensitySum());
        Assertions.assertEquals(BipolarDisorderType.WITH_ANXIETY, bipolarDisorder.getBipolarDisorderType());
    }

    @Test
    public void BipolarDisorderWithAnxiousAgitationMoreThanSixtyDaysTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSessionConfiguration config = KieServices.Factory.get().newKieSessionConfiguration();
        config.setOption(ClockTypeOption.get(ClockType.PSEUDO_CLOCK.getId()));
        KieSession kieSession = kc.newKieSession("affectivedisorders", config);
        SessionPseudoClock clock = kieSession.getSessionClock();
        long startTime = System.currentTimeMillis();
        clock.advanceTime(startTime, TimeUnit.MILLISECONDS);

        Patient patient = new Patient(0,"Mikasa","Mikic", LocalDate.of(2000, 2, 15),
                Gender.FEMALE,"mika@gmail.com", "0645533665",1L);
        kieSession.insert(patient);
        DepressiveEpisode de = new DepressiveEpisode(DepressionType.WITH_ANXIETY, patient, 78, false);
        kieSession.insert(de);
        clock.advanceTime(61, TimeUnit.DAYS);
        ManicEpisode me = new ManicEpisode(ManiaType.MANIA, patient, 58, true);
        kieSession.insert(me);

        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        BipolarDisorder bipolarDisorder = null;
        for (Object object : objects) {
            if (object instanceof BipolarDisorder) {
                bipolarDisorder = (BipolarDisorder) object;
            }
        }
        Assertions.assertNull(bipolarDisorder);
    }

    @Test
    public void BipolarDisorderWithAnxiousAgitationNoPseudoClockTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                Gender.MALE,"mika@gmail.com", "0645533665",1L);
        kieSession.insert(patient);
        DepressiveEpisode de = new DepressiveEpisode(DepressionType.WITH_ANXIETY, patient, 78, false);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -59);
        de.setExecutionTime(calendar.getTime());
        kieSession.insert(de);
        ManicEpisode me = new ManicEpisode(ManiaType.MANIA, patient, 58, true);
        kieSession.insert(me);
        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        BipolarDisorder bipolarDisorder = null;
        for (Object object : objects) {
            if (object instanceof BipolarDisorder) {
                bipolarDisorder = (BipolarDisorder) object;
            }
        }
        Assertions.assertNotNull(bipolarDisorder);
        Assertions.assertEquals(136, bipolarDisorder.getIntensitySum());
        Assertions.assertEquals(BipolarDisorderType.WITH_ANXIETY, bipolarDisorder.getBipolarDisorderType());
    }

    @Test
    public void BipolarDisorderWithAnxiousAgitationNoPseudoClockMoreThenSixtyDaysTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                Gender.MALE,"mika@gmail.com", "0645533665",1L);
        kieSession.insert(patient);
        DepressiveEpisode de = new DepressiveEpisode(DepressionType.WITH_ANXIETY, patient, 78, false);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -60);
        de.setExecutionTime(calendar.getTime());
        kieSession.insert(de);
        System.out.println(de.getExecutionTime());
        ManicEpisode me = new ManicEpisode(ManiaType.MANIA, patient, 58, true);
        kieSession.insert(me);
        System.out.println(me.getExecutionTime());
        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        BipolarDisorder bipolarDisorder = null;
        for (Object object : objects) {
            if (object instanceof BipolarDisorder) {
                bipolarDisorder = (BipolarDisorder) object;
            }
        }
        Assertions.assertNull(bipolarDisorder);
    }

    @Test
    public void BipolarDisorderWithMelancholicFeaturesTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSessionConfiguration config = KieServices.Factory.get().newKieSessionConfiguration();
        config.setOption(ClockTypeOption.get(ClockType.PSEUDO_CLOCK.getId()));
        KieSession kieSession = kc.newKieSession("affectivedisorders", config);
        SessionPseudoClock clock = kieSession.getSessionClock();
        long startTime = System.currentTimeMillis();
        clock.advanceTime(startTime, TimeUnit.MILLISECONDS);

        Patient patient = new Patient(0,"Mikasa","Mikic", LocalDate.of(2000, 2, 15),
                Gender.FEMALE,"mika@gmail.com", "0645533665",1L);
        kieSession.insert(patient);
        DepressiveEpisode de = new DepressiveEpisode(DepressionType.WITH_MELANCHOLY, patient, 78, false);
        kieSession.insert(de);
        clock.advanceTime(59, TimeUnit.DAYS);
        ManicEpisode me = new ManicEpisode(ManiaType.MANIA, patient, 58, true);
        kieSession.insert(me);

        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        BipolarDisorder bipolarDisorder = null;
        for (Object object : objects) {
            if (object instanceof BipolarDisorder) {
                bipolarDisorder = (BipolarDisorder) object;
            }
        }
        Assertions.assertNotNull(bipolarDisorder);
        Assertions.assertEquals(136, bipolarDisorder.getIntensitySum());
        Assertions.assertEquals(BipolarDisorderType.WITH_MELANCHOLY, bipolarDisorder.getBipolarDisorderType());
    }

    @Test
    public void BipolarDisorderWithAtypicalFeaturesTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSessionConfiguration config = KieServices.Factory.get().newKieSessionConfiguration();
        config.setOption(ClockTypeOption.get(ClockType.PSEUDO_CLOCK.getId()));
        KieSession kieSession = kc.newKieSession("affectivedisorders", config);
        SessionPseudoClock clock = kieSession.getSessionClock();
        long startTime = System.currentTimeMillis();
        clock.advanceTime(startTime, TimeUnit.MILLISECONDS);

        Patient patient = new Patient(0,"Mikasa","Mikic", LocalDate.of(2000, 2, 15),
                Gender.FEMALE,"mika@gmail.com", "0645533665",1L);
        kieSession.insert(patient);
        DepressiveEpisode de = new DepressiveEpisode(DepressionType.WITH_ATYPICAL_FEATURES, patient, 78, false);
        kieSession.insert(de);
        clock.advanceTime(59, TimeUnit.DAYS);
        ManicEpisode me = new ManicEpisode(ManiaType.MANIA, patient, 58, true);
        kieSession.insert(me);

        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        BipolarDisorder bipolarDisorder = null;
        for (Object object : objects) {
            if (object instanceof BipolarDisorder) {
                bipolarDisorder = (BipolarDisorder) object;
            }
        }
        Assertions.assertNotNull(bipolarDisorder);
        Assertions.assertEquals(136, bipolarDisorder.getIntensitySum());
        Assertions.assertEquals(BipolarDisorderType.WITH_ATYPICAL_FEATURES, bipolarDisorder.getBipolarDisorderType());
    }

    @Test
    public void BipolarDisorderWithPsychoticFeaturesTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSessionConfiguration config = KieServices.Factory.get().newKieSessionConfiguration();
        config.setOption(ClockTypeOption.get(ClockType.PSEUDO_CLOCK.getId()));
        KieSession kieSession = kc.newKieSession("affectivedisorders", config);
        SessionPseudoClock clock = kieSession.getSessionClock();
        long startTime = System.currentTimeMillis();
        clock.advanceTime(startTime, TimeUnit.MILLISECONDS);

        Patient patient = new Patient(0,"Mikasa","Mikic", LocalDate.of(2000, 2, 15),
                Gender.FEMALE,"mika@gmail.com", "0645533665",1L);
        kieSession.insert(patient);
        DepressiveEpisode de = new DepressiveEpisode(DepressionType.WITH_PSYCHOTIC_FEATURES, patient, 78, false);
        kieSession.insert(de);
        clock.advanceTime(59, TimeUnit.DAYS);
        ManicEpisode me = new ManicEpisode(ManiaType.MANIA, patient, 58, true);
        kieSession.insert(me);

        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        BipolarDisorder bipolarDisorder = null;
        for (Object object : objects) {
            if (object instanceof BipolarDisorder) {
                bipolarDisorder = (BipolarDisorder) object;
            }
        }
        Assertions.assertNotNull(bipolarDisorder);
        Assertions.assertEquals(136, bipolarDisorder.getIntensitySum());
        Assertions.assertEquals(BipolarDisorderType.WITH_PSYCHOTIC_FEATURES, bipolarDisorder.getBipolarDisorderType());
    }

    @Test
    public void BipolarDisorderWithPeripartumFeaturesTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSessionConfiguration config = KieServices.Factory.get().newKieSessionConfiguration();
        config.setOption(ClockTypeOption.get(ClockType.PSEUDO_CLOCK.getId()));
        KieSession kieSession = kc.newKieSession("affectivedisorders", config);
        SessionPseudoClock clock = kieSession.getSessionClock();
        long startTime = System.currentTimeMillis();
        clock.advanceTime(startTime, TimeUnit.MILLISECONDS);

        Patient patient = new Patient(0,"Mikasa","Mikic", LocalDate.of(2000, 2, 15),
                Gender.FEMALE,"mika@gmail.com", "0645533665",1L);
        kieSession.insert(patient);
        DepressiveEpisode de = new DepressiveEpisode(DepressionType.WITH_PERIPARTUM_ONSET, patient, 65, false);
        kieSession.insert(de);
        clock.advanceTime(59, TimeUnit.DAYS);
        ManicEpisode me = new ManicEpisode(ManiaType.MANIA, patient, 58, true);
        kieSession.insert(me);

        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        BipolarDisorder bipolarDisorder = null;
        for (Object object : objects) {
            if (object instanceof BipolarDisorder) {
                bipolarDisorder = (BipolarDisorder) object;
            }
        }
        Assertions.assertNotNull(bipolarDisorder);
        Assertions.assertEquals(123, bipolarDisorder.getIntensitySum());
        Assertions.assertEquals(BipolarDisorderType.WITH_PERIPARTUM_ONSET, bipolarDisorder.getBipolarDisorderType());
    }

    @Test
    public void BipolarDisorderWithPeripartumFeaturesNotFemaleTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSessionConfiguration config = KieServices.Factory.get().newKieSessionConfiguration();
        config.setOption(ClockTypeOption.get(ClockType.PSEUDO_CLOCK.getId()));
        KieSession kieSession = kc.newKieSession("affectivedisorders", config);
        SessionPseudoClock clock = kieSession.getSessionClock();
        long startTime = System.currentTimeMillis();
        clock.advanceTime(startTime, TimeUnit.MILLISECONDS);

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                Gender.MALE,"mika@gmail.com", "0645533665",1L);
        kieSession.insert(patient);
        DepressiveEpisode de = new DepressiveEpisode(DepressionType.WITH_PERIPARTUM_ONSET, patient, 65, true);
        kieSession.insert(de);
        clock.advanceTime(59, TimeUnit.DAYS);
        ManicEpisode me = new ManicEpisode(ManiaType.MANIA, patient, 58, true);
        kieSession.insert(me);

        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        BipolarDisorder bipolarDisorder = null;
        for (Object object : objects) {
            if (object instanceof BipolarDisorder) {
                bipolarDisorder = (BipolarDisorder) object;
            }
        }
        Assertions.assertNull(bipolarDisorder);
    }

    @Test
    public void BipolarDisorderWithQuickChangeManiasTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                Gender.MALE,"mika@gmail.com", "0645533665",1L);
        kieSession.insert(patient);
        DepressiveEpisode de1 = new DepressiveEpisode(DepressionType.WITH_ANXIETY, patient, 78, true);
        calendar.add(Calendar.DAY_OF_YEAR, -270);
        de1.setExecutionTime(calendar.getTime());
        System.out.println(de1.getExecutionTime());
        kieSession.insert(de1);

        DepressiveEpisode de2 = new DepressiveEpisode(DepressionType.WITH_MELANCHOLY, patient, 71, true);
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -200);
        de2.setExecutionTime(calendar.getTime());
        System.out.println(de2.getExecutionTime());
        kieSession.insert(de2);

        ManicEpisode me1 = new ManicEpisode(ManiaType.MANIA, patient, 58, true);
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -100);
        me1.setExecutionTime(calendar.getTime());
        System.out.println(me1.getExecutionTime());
        kieSession.insert(me1);

        ManicEpisode me2 = new ManicEpisode(ManiaType.MANIA, patient, 58, true);
        calendar.setTime(new Date());
        me2.setExecutionTime(calendar.getTime());
        System.out.println(me2.getExecutionTime());
        kieSession.insert(me2);

        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        BipolarDisorder bipolarDisorder = null;
        for (Object object : objects) {
            if (object instanceof BipolarDisorder) {
                bipolarDisorder = (BipolarDisorder) object;
            }
        }
        Assertions.assertNotNull(bipolarDisorder);
        Assertions.assertEquals(265, bipolarDisorder.getIntensitySum());
        Assertions.assertEquals(BipolarDisorderType.WITH_QUICK_CHANGE, bipolarDisorder.getBipolarDisorderType());
    }

    @Test
    public void BipolarDisorderWithQuickChangeManiaHypomaniaTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                Gender.MALE,"mika@gmail.com", "0645533665",1L);
        kieSession.insert(patient);
        DepressiveEpisode de1 = new DepressiveEpisode(DepressionType.WITH_ANXIETY, patient, 78, true);
        calendar.add(Calendar.DAY_OF_YEAR, -270);
        de1.setExecutionTime(calendar.getTime());
        System.out.println(de1.getExecutionTime());
        kieSession.insert(de1);

        DepressiveEpisode de2 = new DepressiveEpisode(DepressionType.WITH_MELANCHOLY, patient, 71, true);
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -200);
        de2.setExecutionTime(calendar.getTime());
        System.out.println(de2.getExecutionTime());
        kieSession.insert(de2);

        ManicEpisode me1 = new ManicEpisode(ManiaType.MANIA, patient, 58, true);
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -100);
        me1.setExecutionTime(calendar.getTime());
        System.out.println(me1.getExecutionTime());
        kieSession.insert(me1);

        ManicEpisode me2 = new ManicEpisode(ManiaType.HYPOMANIA, patient, 58, true);
        calendar.setTime(new Date());
        me2.setExecutionTime(calendar.getTime());
        System.out.println(me2.getExecutionTime());
        kieSession.insert(me2);

        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        BipolarDisorder bipolarDisorder = null;
        for (Object object : objects) {
            if (object instanceof BipolarDisorder) {
                bipolarDisorder = (BipolarDisorder) object;
            }
        }
        Assertions.assertNotNull(bipolarDisorder);
        Assertions.assertEquals(265, bipolarDisorder.getIntensitySum());
        Assertions.assertEquals(BipolarDisorderType.WITH_QUICK_CHANGE, bipolarDisorder.getBipolarDisorderType());
    }

    @Test
    public void BipolarDisorderWithQuickChangeHypomaniasTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                Gender.MALE,"mika@gmail.com", "0645533665",1L);
        kieSession.insert(patient);
        DepressiveEpisode de1 = new DepressiveEpisode(DepressionType.WITH_ANXIETY, patient, 78, true);
        calendar.add(Calendar.DAY_OF_YEAR, -270);
        de1.setExecutionTime(calendar.getTime());
        System.out.println(de1.getExecutionTime());
        kieSession.insert(de1);

        DepressiveEpisode de2 = new DepressiveEpisode(DepressionType.WITH_MELANCHOLY, patient, 71, true);
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -200);
        de2.setExecutionTime(calendar.getTime());
        System.out.println(de2.getExecutionTime());
        kieSession.insert(de2);

        ManicEpisode me1 = new ManicEpisode(ManiaType.HYPOMANIA, patient, 48, true);
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -100);
        me1.setExecutionTime(calendar.getTime());
        System.out.println(me1.getExecutionTime());
        kieSession.insert(me1);

        ManicEpisode me2 = new ManicEpisode(ManiaType.HYPOMANIA, patient, 48, true);
        calendar.setTime(new Date());
        me2.setExecutionTime(calendar.getTime());
        System.out.println(me2.getExecutionTime());
        kieSession.insert(me2);

        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        BipolarDisorder bipolarDisorder = null;
        for (Object object : objects) {
            if (object instanceof BipolarDisorder) {
                bipolarDisorder = (BipolarDisorder) object;
            }
        }
        Assertions.assertNotNull(bipolarDisorder);
        Assertions.assertEquals(245, bipolarDisorder.getIntensitySum());
        Assertions.assertEquals(BipolarDisorderType.WITH_QUICK_CHANGE, bipolarDisorder.getBipolarDisorderType());
    }

    @Test
    public void CyclothymiaOlderPersonTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                Gender.MALE,"mika@gmail.com", "0645533665",1L);
        kieSession.insert(patient);

        BipolarDisorder bd1 = new BipolarDisorder(BipolarDisorderType.WITH_ANXIETY, patient, 78, true);
        calendar.add(Calendar.DAY_OF_YEAR, -200);
        bd1.setExecutionTime(calendar.getTime());
        System.out.println(bd1.getExecutionTime());
        kieSession.insert(bd1);

        BipolarDisorder bd2 = new BipolarDisorder(BipolarDisorderType.WITH_ANXIETY, patient, 78, true);
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -150);
        bd2.setExecutionTime(calendar.getTime());
        System.out.println(bd2.getExecutionTime());
        kieSession.insert(bd2);

        BipolarDisorder bd3 = new BipolarDisorder(BipolarDisorderType.WITH_ANXIETY, patient, 78, true);
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -100);
        bd3.setExecutionTime(calendar.getTime());
        System.out.println(bd3.getExecutionTime());
        kieSession.insert(bd3);

        BipolarDisorder bd4 = new BipolarDisorder(BipolarDisorderType.WITH_ANXIETY, patient, 78, true);
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -50);
        bd4.setExecutionTime(calendar.getTime());
        System.out.println(bd4.getExecutionTime());
        kieSession.insert(bd4);

        BipolarDisorder bd5 = new BipolarDisorder(BipolarDisorderType.WITH_ANXIETY, patient, 78, true);
        calendar.setTime(new Date());
        bd5.setExecutionTime(calendar.getTime());
        System.out.println(bd5.getExecutionTime());
        kieSession.insert(bd5);

        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        Cyclothymia cyclothymia = null;
        for (Object object : objects) {
            if (object instanceof Cyclothymia) {
                cyclothymia = (Cyclothymia) object;
            }
        }
        Assertions.assertNotNull(cyclothymia);
        Assertions.assertEquals(390, cyclothymia.getIntensitySum());
    }

    @Test
    public void CyclothymiaYoungerPersonTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2009, 2, 15),
                Gender.MALE,"mika@gmail.com", "0645533665",1L);
        kieSession.insert(patient);

        BipolarDisorder bd1 = new BipolarDisorder(BipolarDisorderType.WITH_ANXIETY, patient, 78, true);
        calendar.add(Calendar.DAY_OF_YEAR, -200);
        bd1.setExecutionTime(calendar.getTime());
        System.out.println(bd1.getExecutionTime());
        kieSession.insert(bd1);

        BipolarDisorder bd2 = new BipolarDisorder(BipolarDisorderType.WITH_ANXIETY, patient, 78, true);
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -150);
        bd2.setExecutionTime(calendar.getTime());
        System.out.println(bd2.getExecutionTime());
        kieSession.insert(bd2);

        BipolarDisorder bd3 = new BipolarDisorder(BipolarDisorderType.WITH_ANXIETY, patient, 78, true);
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -100);
        bd3.setExecutionTime(calendar.getTime());
        System.out.println(bd3.getExecutionTime());
        kieSession.insert(bd3);

        BipolarDisorder bd4 = new BipolarDisorder(BipolarDisorderType.WITH_ANXIETY, patient, 78, true);
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -50);
        bd4.setExecutionTime(calendar.getTime());
        System.out.println(bd4.getExecutionTime());
        kieSession.insert(bd4);

        BipolarDisorder bd5 = new BipolarDisorder(BipolarDisorderType.WITH_ANXIETY, patient, 78, true);
        calendar.setTime(new Date());
        bd5.setExecutionTime(calendar.getTime());
        System.out.println(bd5.getExecutionTime());
        kieSession.insert(bd5);

        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        Cyclothymia cyclothymia = null;
        for (Object object : objects) {
            if (object instanceof Cyclothymia) {
                cyclothymia = (Cyclothymia) object;
            }
        }
        Assertions.assertNotNull(cyclothymia);
        Assertions.assertEquals(390, cyclothymia.getIntensitySum());
    }

    @Test
    public void DysthymiaOlderPersonTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                Gender.MALE,"mika@gmail.com", "0645533665",1L);
        kieSession.insert(patient);

        DepressiveEpisode de1 = new DepressiveEpisode(DepressionType.WITH_ANXIETY, patient, 70, true);
        calendar.add(Calendar.DAY_OF_YEAR, -200);
        de1.setExecutionTime(calendar.getTime());
        kieSession.insert(de1);

        DepressiveEpisode de2 = new DepressiveEpisode(DepressionType.WITH_MELANCHOLY, patient, 70, true);
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -150);
        de2.setExecutionTime(calendar.getTime());
        kieSession.insert(de2);

        DepressiveEpisode de3 = new DepressiveEpisode(DepressionType.WITH_PSYCHOTIC_FEATURES, patient, 70, true);
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -100);
        de3.setExecutionTime(calendar.getTime());
        kieSession.insert(de3);

        DepressiveEpisode de4 = new DepressiveEpisode(DepressionType.WITH_ANXIETY, patient, 70, true);
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -50);
        de4.setExecutionTime(calendar.getTime());
        kieSession.insert(de4);

        DepressiveEpisode de5 = new DepressiveEpisode(DepressionType.WITH_ANXIETY, patient, 70, true);
        calendar.setTime(new Date());
        de5.setExecutionTime(calendar.getTime());
        kieSession.insert(de5);

        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        Dysthymia dysthymia = null;
        for (Object object : objects) {
            if (object instanceof Dysthymia) {
                dysthymia = (Dysthymia) object;
            }
        }
        Assertions.assertNotNull(dysthymia);
        Assertions.assertEquals(350, dysthymia.getIntensitySum());
    }

    @Test
    public void RecurrentDepressiveDisorderTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                Gender.MALE,"mika@gmail.com", "0645533665",1L);
        kieSession.insert(patient);

        DepressiveEpisode de1 = new DepressiveEpisode(DepressionType.WITH_ANXIETY, patient, 70, true);
        calendar.add(Calendar.DAY_OF_YEAR, -60);
        de1.setExecutionTime(calendar.getTime());
        kieSession.insert(de1);

        DepressiveEpisode de2 = new DepressiveEpisode(DepressionType.WITH_MELANCHOLY, patient, 70, true);
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -30);
        de2.setExecutionTime(calendar.getTime());
        kieSession.insert(de2);

        DepressiveEpisode de3 = new DepressiveEpisode(DepressionType.WITH_PSYCHOTIC_FEATURES, patient, 70, true);
        calendar.setTime(new Date());
        de3.setExecutionTime(calendar.getTime());
        kieSession.insert(de3);

        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        RecurrentDepressiveDisorder rdd = null;
        for (Object object : objects) {
            if (object instanceof RecurrentDepressiveDisorder) {
                rdd = (RecurrentDepressiveDisorder) object;
            }
        }
        Assertions.assertNotNull(rdd);
        Assertions.assertEquals(210, rdd.getIntensitySum());
    }

    @Test
    public void ChangeRecurrentDepressiveDisorderDiagnosisTest() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                Gender.MALE,"mika@gmail.com", "0645533665",1L);
        kieSession.insert(patient);

        RecurrentDepressiveDisorder rdd = new RecurrentDepressiveDisorder(patient, 200, true);
        calendar.add(Calendar.DAY_OF_YEAR, -60);
        rdd.setExecutionTime(calendar.getTime());
        kieSession.insert(rdd);

        ManicEpisode me = new ManicEpisode(ManiaType.MANIA, patient, 55, true);
        calendar.setTime(new Date());
        me.setExecutionTime(calendar.getTime());
        kieSession.insert(me);

        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        BipolarDisorder bd = null;
        for (Object object : objects) {
            if (object instanceof BipolarDisorder) {
                bd = (BipolarDisorder) object;
            }
        }
        Assertions.assertNotNull(bd);
        Assertions.assertEquals(255, bd.getIntensitySum());
        Assertions.assertEquals(BipolarDisorderType.WITH_MELANCHOLY, bd.getBipolarDisorderType());
    }

    @Test
    public void HypomaniaTest() {
        InputStream template = AffectiveDisordersTests.class.getResourceAsStream("/template/template.drt");

        DataProvider dataProvider = new ArrayDataProvider(new String[][]{
                new String[]{"3", "4", "45", "55", "65"}
        });

        DataProviderCompiler converter = new DataProviderCompiler();
        String drl = converter.compile(dataProvider, template);

        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drl, ResourceType.DRL);
        KieSession kieSession = kieHelper.build().newKieSession();
        kieSession.insert(new Symptom("euphoria", 5, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("irritability", 4, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("expansiveness", 4, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("talkative", 5, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("grandiose ideas", 3, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("hyperoptimism", 5, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("distractibility", 3, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("no sleep", 3, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("increased energy", 4, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("excessive activity", 5, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("impulsiveness", 4, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("aggressiveness", 2, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("disinhibition", 3, SymptomGroup.MANIC_EPISODE, 0));
        kieSession.insert(new Symptom("duration", 5, SymptomGroup.DEPRESSIVE_EPISODE, 0));

        Patient patient = new Patient(0,"Mika","Mikic", LocalDate.of(2000, 2, 15),
                Gender.MALE,"mika@gmail.com", "0645533665",1L);

        kieSession.insert(patient);
        kieSession.fireAllRules();
        Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        ManicEpisode me = null;
        for (Object object : objects) {
            if (object instanceof ManicEpisode) {
                me = (ManicEpisode) object;
            }
        }
        Assertions.assertNotNull(me);
        Assertions.assertEquals(50, me.getIntensitySum());
        Assertions.assertEquals(ManiaType.HYPOMANIA, me.getManiaType());
    }
}
