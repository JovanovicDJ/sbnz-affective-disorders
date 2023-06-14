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
import java.util.Collection;
import java.util.List;

@Service
public class PsychopathyService {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PsychopathyRepository psychopathyRepository;

    @Autowired
    private SocialDevianceRepository socialDevianceRepository;

    @Autowired
    private InterpersonalAffectiveFactorRepository interpersonalAffectiveFactorRepository;

    @Autowired
    private AntisocialFactorRepository antisocialFactorRepository;

    @Autowired
    private AffectiveFactorRepository affectiveFactorRepository;

    @Autowired
    private InterpersonalFactorRepository interpersonalFactorRepository;

    @Autowired
    private LifestyleFactorRepository lifestyleFactorRepository;

    public String findPsychopathyDisorder(List<Symptom> symptoms) {


        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.newKieClasspathContainer();
        KieSession kieSession = kc.newKieSession("psychopathydisorder");
        Patient patient = patientService.findById((long) symptoms.get(0).getPatientId());
        kieSession.insert(patient);
        for (Symptom s : symptoms) {
            kieSession.insert(s);
        }
        System.out.println("-----------");
        kieSession.fireAllRules();
        Collection<Object> allObjects = (Collection<Object>) kieSession.getObjects();
        kieSession.dispose();
        return findDissorder(allObjects);
    }

    private String findDissorder(Collection<Object> allObjects){
        Psychopathy psychopathy = null;
        SocialDeviance socialDeviance = null;
        InterpersonalAffectiveFactor interpersonalAffectiveFactor = null;
        AntisocialFactor antisocialFactor = null;
        AffectiveFactor affectiveFactor = null;
        InterpersonalFactor interpersonalFactor = null;
        LifestyleFactor lifestyleFactor = null;

        for (Object object : allObjects) {
            if (object instanceof Psychopathy) {
                Psychopathy pOBJ = (Psychopathy) object;
                psychopathy = pOBJ;
            }
            else if (object instanceof SocialDeviance) {
                SocialDeviance scOBJ = (SocialDeviance) object;
                socialDeviance = scOBJ;
            }
            else if (object instanceof InterpersonalAffectiveFactor) {
                InterpersonalAffectiveFactor iafOBJ = (InterpersonalAffectiveFactor) object;
                interpersonalAffectiveFactor = iafOBJ;
            }
            else if (object instanceof AntisocialFactor) {
                AntisocialFactor afOBJ = (AntisocialFactor) object;
                antisocialFactor = afOBJ;
            }
            else if (object instanceof AffectiveFactor) {
                AffectiveFactor affObj = (AffectiveFactor) object;
                affectiveFactor = affObj;
            }
            else if (object instanceof InterpersonalFactor) {
                InterpersonalFactor ipfOBJ = (InterpersonalFactor) object;
                interpersonalFactor = ipfOBJ;
            }
            else if (object instanceof LifestyleFactor) {
                LifestyleFactor lsfOBJ = (LifestyleFactor) object;
                lifestyleFactor = lsfOBJ;
            }
        }
        if(psychopathy != null){
            psychopathyRepository.save(psychopathy);
            return "Pacijent ima dijagnozu psihopate!";
        }
        else if( socialDeviance != null){
            socialDevianceRepository.save(socialDeviance);
            return "Pacijent ima dijagnozu socijalne devijacije!";
        }
        else if (interpersonalAffectiveFactor != null ){
            interpersonalAffectiveFactorRepository.save(interpersonalAffectiveFactor);
            return "Pacijent ima dijagnozu jako losih medjuljudskih afekata";
        }
        else if (antisocialFactor != null){
            antisocialFactorRepository.save(antisocialFactor);
            return "Pacijent ima dijagnozu antisocijalne osobe!";
        }
        else if( affectiveFactor != null){
            affectiveFactorRepository.save(affectiveFactor);
            return "Pacijent ima dijagnozu afektivnog poremecaja!";
        }
        else if( interpersonalFactor != null){
            interpersonalFactorRepository.save(interpersonalFactor);
            return "Pacijent ima dijagnozu losih medjuljudskih odnosa!";
        }
        else if(lifestyleFactor != null ){
            lifestyleFactorRepository.save(lifestyleFactor);
            return "Pacijent ima los nacin zivota!!";
        }


        return "Pacijent nema dijagnozu";
    }
}
