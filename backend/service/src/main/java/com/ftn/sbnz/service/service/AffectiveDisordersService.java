package com.ftn.sbnz.service.service;

import com.ftn.sbnz.model.*;
import com.ftn.sbnz.service.repository.*;
import org.drools.template.DataProvider;
import org.drools.template.DataProviderCompiler;
import org.drools.template.objects.ArrayDataProvider;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Service
public class AffectiveDisordersService {

    @Autowired
    private PatientService patientService;

    @Autowired
    private ManicEpisodeRepository manicEpisodeRepository;

    @Autowired
    private CyclothymiaRepository cyclothymiaRepository;

    @Autowired
    private DysthymiaRepository dysthymiaRepository;

    @Autowired
    private BipolarDisorderRepository bipolarDisorderRepository;

    @Autowired
    private RecurrentDepressiveDisorderRepository recDepressiveDisorderRepository;

    @Autowired
    private DepressiveEpisodeRepository depressiveEpisodeRepository;


    public String findAffectiveDisorders(List<Symptom> symptoms) {
        return findManicEpisode(symptoms);
    }

    private String findManicEpisode(List<Symptom> symptoms) {
        InputStream template = AffectiveDisordersService.class.getResourceAsStream("/template/template.drt");
        DataProvider dataProvider = new ArrayDataProvider(new String[][]{
                new String[]{"3", "4", "45", "55", "65"}
        });

        DataProviderCompiler converter = new DataProviderCompiler();
        String drl = converter.compile(dataProvider, template);

        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drl, ResourceType.DRL);
        KieSession kieSession = kieHelper.build().newKieSession();
        Patient patient = patientService.findById((long) symptoms.get(0).getPatientId());
        kieSession.insert(patient);
        for (Symptom s : symptoms) {
            if (s.getSymptomGroup() == SymptomGroup.MANIC_EPISODE) {
                System.out.println(s.getName() + " " + s.getIntensity());
                kieSession.insert(s);
            }
            else if (s.getName().equals("duration")) {
                kieSession.insert(s);
            }
        }
        System.out.println("-----------");
        kieSession.fireAllRules();
        Collection<Object> allObjects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        for (Object object : allObjects) {
            if (object instanceof ManicEpisode) {
                ManicEpisode manicEpisode = (ManicEpisode) object;
                manicEpisodeRepository.save(manicEpisode);
                String higherLevelDisorder = findHigherLevelDisorders(manicEpisode);
                if (higherLevelDisorder.equals("")) {
                    if (manicEpisode.getManiaType() == ManiaType.MANIA) {
                        return "Pacijent se nalazi u maničnoj epizodi!";
                    }
                    else {
                        return "Pacijent se nalazi u hipomaničnoj epizodi!";
                    }
                }
                else {
                    return higherLevelDisorder;
                }
            }
        }
        return findDepressiveEpisode(symptoms);
    }

    private String findDepressiveEpisode(List<Symptom> symptoms) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");

        for (Symptom s : symptoms) {
            if (s.getSymptomGroup().name().startsWith("DE")) {
                kieSession.insert(s);
                System.out.println(s.getName() + " " + s.getIntensity());
            }
        }

        for (ManicEpisode me : manicEpisodeRepository.getManicEpisodesByPatient_Id((long) symptoms.get(0).getPatientId())) {
            kieSession.insert(me);
        }
        for (DepressiveEpisode de : depressiveEpisodeRepository.getDepressiveEpisodesByPatient_Id((long) symptoms.get(0).getPatientId())) {
            kieSession.insert(de);
        }
        for (BipolarDisorder bd : bipolarDisorderRepository.getBipolarDisordersByPatient_Id((long) symptoms.get(0).getPatientId())) {
            kieSession.insert(bd);
        }
        for (RecurrentDepressiveDisorder rdd : recDepressiveDisorderRepository.getRecurrentDepressiveDisordersByPatient_Id((long) symptoms.get(0).getPatientId())) {
            kieSession.insert(rdd);
        }
        for (Cyclothymia c : cyclothymiaRepository.getCyclothymiasByPatient_Id((long) symptoms.get(0).getPatientId())) {
            kieSession.insert(c);
        }
        for (Dysthymia d : dysthymiaRepository.getDysthymiasByPatient_Id((long) symptoms.get(0).getPatientId())) {
            kieSession.insert(d);
        }

        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.insert(patientService.findById((long) symptoms.get(0).getPatientId()));
        kieSession.fireAllRules();
        Collection<Object> allObjects = (Collection<Object>) kieSession.getObjects();
        kieSession.setGlobal("maxRuleExecuted", true);
        kieSession.dispose();
        return getDisorder(allObjects);
    }

    private String findHigherLevelDisorders(ManicEpisode manicEpisode) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("affectivedisorders");

        kieSession.insert(manicEpisode);
        kieSession.insert(manicEpisode.getPatient());

        for (ManicEpisode me : manicEpisodeRepository.getManicEpisodesByPatient_Id(manicEpisode.getPatient().getId())) {
            kieSession.insert(me);
        }
        for (DepressiveEpisode de : depressiveEpisodeRepository.getDepressiveEpisodesByPatient_Id(manicEpisode.getPatient().getId())) {
            kieSession.insert(de);
        }
        for (BipolarDisorder bd : bipolarDisorderRepository.getBipolarDisordersByPatient_Id(manicEpisode.getPatient().getId())) {
            kieSession.insert(bd);
        }
        for (RecurrentDepressiveDisorder rdd : recDepressiveDisorderRepository.getRecurrentDepressiveDisordersByPatient_Id(manicEpisode.getPatient().getId())) {
            kieSession.insert(rdd);
        }
        for (Cyclothymia c : cyclothymiaRepository.getCyclothymiasByPatient_Id(manicEpisode.getPatient().getId())) {
            kieSession.insert(c);
        }
        for (Dysthymia d : dysthymiaRepository.getDysthymiasByPatient_Id(manicEpisode.getPatient().getId())) {
            kieSession.insert(d);
        }

        kieSession.setGlobal("maxRuleExecuted", false);
        kieSession.fireAllRules();
        Collection<Object> allObjects = (Collection<Object>) kieSession.getObjects();
        kieSession.setGlobal("maxRuleExecuted", true);
        kieSession.dispose();
        return getDisorder(allObjects);
    }

    private String getDisorder(Collection<Object> objects) {
        for (Object object : objects) {
            System.out.println("IN FOR!");
            if (object instanceof DepressionEvent) {
                System.out.println("DEPRESSION EVENT");
            }
            else if (object instanceof Cyclothymia) {
                Cyclothymia cyclothymia = (Cyclothymia) object;
                if (!cyclothymia.isAccepted()) {
                    cyclothymia.setAccepted(true);
                    cyclothymiaRepository.save(cyclothymia);
                    return "Pacijent boluje od ciklotimije!";
                }
            }
            else if (object instanceof Dysthymia) {
                Dysthymia dysthymia = (Dysthymia) object;
                if (!dysthymia.isAccepted()) {
                    dysthymia.setAccepted(true);
                    dysthymiaRepository.save(dysthymia);
                    return "Pacijent boluje od distimije!";
                }
            }
            else if (object instanceof BipolarDisorder) {
                BipolarDisorder bipolarDisorder = (BipolarDisorder) object;
                if (!bipolarDisorder.isAccepted()) {
                    bipolarDisorder.setAccepted(true);
                    bipolarDisorderRepository.save(bipolarDisorder);
                    return "Pacijent boluje od bipolarnog poremećaja!";
                }
            }
            else if (object instanceof RecurrentDepressiveDisorder) {
                RecurrentDepressiveDisorder recDepressiveDisorder = (RecurrentDepressiveDisorder) object;
                if (!recDepressiveDisorder.isAccepted()) {
                    recDepressiveDisorder.setAccepted(true);
                    recDepressiveDisorderRepository.save(recDepressiveDisorder);
                    return "Pacijent boluje od rekurentnog depresivnog poremećaja!";
                }
            }
            else if (object instanceof DepressiveEpisode) {
                DepressiveEpisode depressiveEpisode = (DepressiveEpisode) object;
                if (!depressiveEpisode.isAccepted()) {
                    depressiveEpisode.setAccepted(true);
                    depressiveEpisodeRepository.save(depressiveEpisode);
                    return "Pacijent se nalazi u depresivnoj epizodi!";
                }
            }
        }
        return "";
    }

}
