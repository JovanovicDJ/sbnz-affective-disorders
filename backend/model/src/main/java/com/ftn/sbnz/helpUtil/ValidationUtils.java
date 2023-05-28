package com.ftn.sbnz.helpUtil;

import com.ftn.sbnz.model.BipolarDisorder;
import com.ftn.sbnz.model.DepressiveEpisode;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ValidationUtils {

    public static boolean validateCyclothymia(List<BipolarDisorder> bdsList) {

        System.out.println("ovde1");
        Collections.sort(bdsList, Comparator.comparing(BipolarDisorder::getExecutionTime));
        System.out.println("ovde2");
        for (int i = 0; i < bdsList.size() - 1; i++) {
            BipolarDisorder current = bdsList.get(i);
            BipolarDisorder next = bdsList.get(i + 1);
            LocalDate currentExecutionDate = current.getExecutionTime();
            LocalDate nextExecutionDate = next.getExecutionTime();
            long monthsBetween = ChronoUnit.MONTHS.between(currentExecutionDate, nextExecutionDate);
            if (monthsBetween > 2) {
                return false; // Ako je razmak između dva susedna poremećaja veći od 2 meseca, ciklotimija nije prisutna
            }
        }
        return true; // Ciklotimija je prisutna
    }

    public static int calculateIntensitySum(List<BipolarDisorder> bdsList) {

        int intensitySum = 0;
        for (BipolarDisorder bds : bdsList) {
            intensitySum += bds.getIntensitySum();
        }

        return intensitySum;
    }
    public static int calculateIntensitySumDysthymia(List<DepressiveEpisode> bdsList) {

        int intensitySum = 0;
        for (DepressiveEpisode bds : bdsList) {
            intensitySum += bds.getIntensitySum();
        }

        return intensitySum;
    }

    public static boolean validateDysthymia(List<DepressiveEpisode> bdsList) {

        Collections.sort(bdsList, Comparator.comparing(DepressiveEpisode::getExecutionTime));
        for (int i = 0; i < bdsList.size() - 1; i++) {
            DepressiveEpisode current = bdsList.get(i);
            DepressiveEpisode next = bdsList.get(i + 1);
            Date currentExecutionDate = current.getExecutionTime();
            Date nextExecutionDate = next.getExecutionTime();
            long monthsBetween = ChronoUnit.MONTHS.between((Temporal) currentExecutionDate, (Temporal) nextExecutionDate);
            if (monthsBetween > 2) {
                return false; // Ako je razmak između dva susedna poremećaja veći od 2 meseca, ciklotimija nije prisutna
            }
        }
        return true; // Ciklotimija je prisutna
    }
}
