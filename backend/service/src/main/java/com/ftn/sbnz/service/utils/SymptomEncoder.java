package com.ftn.sbnz.service.utils;

import com.ftn.sbnz.model.SymptomGroup;

import java.util.HashMap;
import java.util.Map;

public class SymptomEncoder {

    private final Map<String, SymptomGroup> symptomGroupMap = new HashMap<>();

    public SymptomEncoder() {
        symptomGroupMap.put("low affect", SymptomGroup.DEPRESSIVE_EPISODE);
        symptomGroupMap.put("anhedonia", SymptomGroup.DEPRESSIVE_EPISODE);
        symptomGroupMap.put("tension", SymptomGroup.DE_WITH_ANXIETY);
        symptomGroupMap.put("unrest", SymptomGroup.DE_WITH_ANXIETY);
        symptomGroupMap.put("concern", SymptomGroup.DE_WITH_ANXIETY);
        symptomGroupMap.put("fear of losing control", SymptomGroup.DE_WITH_ANXIETY);
        symptomGroupMap.put("emptiness", SymptomGroup.DE_WITH_MELANCHOLY);
        symptomGroupMap.put("guilt", SymptomGroup.DE_WITH_PSYCHOTIC_FEATURES);
        symptomGroupMap.put("sinfulness", SymptomGroup.DE_WITH_PSYCHOTIC_FEATURES);
        symptomGroupMap.put("perdition", SymptomGroup.DE_WITH_PSYCHOTIC_FEATURES);
        symptomGroupMap.put("euphoria", SymptomGroup.MANIC_EPISODE);
        symptomGroupMap.put("irritability", SymptomGroup.MANIC_EPISODE);
        symptomGroupMap.put("expansiveness", SymptomGroup.MANIC_EPISODE);
        symptomGroupMap.put("pessimism", SymptomGroup.DEPRESSIVE_EPISODE);
        symptomGroupMap.put("low concentration", SymptomGroup.DEPRESSIVE_EPISODE);
        symptomGroupMap.put("hopelessness", SymptomGroup.DEPRESSIVE_EPISODE);
        symptomGroupMap.put("worthlessness", SymptomGroup.DEPRESSIVE_EPISODE);
        symptomGroupMap.put("suicidal ideation", SymptomGroup.DEPRESSIVE_EPISODE);
        symptomGroupMap.put("nihilistic", SymptomGroup.DE_WITH_PSYCHOTIC_FEATURES);
        symptomGroupMap.put("talkative", SymptomGroup.MANIC_EPISODE);
        symptomGroupMap.put("grandiose ideas", SymptomGroup.MANIC_EPISODE);
        symptomGroupMap.put("hyperoptimism", SymptomGroup.MANIC_EPISODE);
        symptomGroupMap.put("distractibility", SymptomGroup.MANIC_EPISODE);
        symptomGroupMap.put("disturbed sleep", SymptomGroup.DEPRESSIVE_EPISODE);
        symptomGroupMap.put("no sleep", SymptomGroup.MANIC_EPISODE);
        symptomGroupMap.put("low energy level", SymptomGroup.DEPRESSIVE_EPISODE);
        symptomGroupMap.put("increased energy", SymptomGroup.MANIC_EPISODE);
        symptomGroupMap.put("disturbed appetite", SymptomGroup.DEPRESSIVE_EPISODE);
        symptomGroupMap.put("appetite increase", SymptomGroup.DE_WITH_ATYPICAL_FEATURES);
        symptomGroupMap.put("loss of libido", SymptomGroup.DE_WITH_MELANCHOLY);
        symptomGroupMap.put("hypochondriacal", SymptomGroup.DE_WITH_PSYCHOTIC_FEATURES);
        symptomGroupMap.put("in pregnancy", SymptomGroup.DE_WITH_PERIPARTUM_ONSET);
        symptomGroupMap.put("after pregnancy", SymptomGroup.DE_WITH_PERIPARTUM_ONSET);
        symptomGroupMap.put("negligence", SymptomGroup.DEPRESSIVE_EPISODE);
        symptomGroupMap.put("loss of interest", SymptomGroup.DE_WITH_MELANCHOLY);
        symptomGroupMap.put("loss of emotional reactivity to positive dearer", SymptomGroup.DE_WITH_MELANCHOLY);
        symptomGroupMap.put("duration", SymptomGroup.DEPRESSIVE_EPISODE);
        symptomGroupMap.put("mood reactivity", SymptomGroup.DE_WITH_ATYPICAL_FEATURES);
        symptomGroupMap.put("sensitivity to interpersonal rejection", SymptomGroup.DE_WITH_ATYPICAL_FEATURES);
        symptomGroupMap.put("excessive activity", SymptomGroup.MANIC_EPISODE);
        symptomGroupMap.put("impulsiveness", SymptomGroup.MANIC_EPISODE);
        symptomGroupMap.put("aggressiveness", SymptomGroup.MANIC_EPISODE);
        symptomGroupMap.put("disinhibition", SymptomGroup.MANIC_EPISODE);
    }

    public SymptomGroup getSymptomGroup(String symptomName) {
        return symptomGroupMap.get(symptomName);
    }
}
