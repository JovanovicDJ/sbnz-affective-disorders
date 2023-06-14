package com.ftn.sbnz.helpUtil;

import com.ftn.sbnz.model.BipolarDisorder;
import com.ftn.sbnz.model.DepressiveEpisode;
import com.ftn.sbnz.model.ManicEpisode;
import com.ftn.sbnz.model.RecurrentDepressiveDisorder;

import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ValidationUtils {

    public static boolean validateCyclothymia(List<BipolarDisorder> bdsList) {
        Collections.sort(bdsList, Comparator.comparing(BipolarDisorder::getExecutionTime));
        for (int i = 0; i < bdsList.size() - 1; i++) {
            BipolarDisorder current = bdsList.get(i);
            BipolarDisorder next = bdsList.get(i + 1);
            Date currentExecutionDate = current.getExecutionTime();
            Date nextExecutionDate = next.getExecutionTime();

            long monthsBetween = ChronoUnit.MONTHS.between(
                    currentExecutionDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                    nextExecutionDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
            );

            if (monthsBetween > 2) {
                return false; // If the gap between two consecutive episodes is more than 2 months, cyclothymia is not present
            }
        }
        return true; // Cyclothymia is present
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

            long monthsBetween = ChronoUnit.MONTHS.between(
                    currentExecutionDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                    nextExecutionDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
            );

            if (monthsBetween > 2) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateRecurrentDepressiveDisorder(List<DepressiveEpisode> bdsList) {

        Collections.sort(bdsList, Comparator.comparing(DepressiveEpisode::getExecutionTime));
        for (int i = 0; i < bdsList.size() - 1; i++) {
            DepressiveEpisode current = bdsList.get(i);
            DepressiveEpisode next = bdsList.get(i + 1);
            Date currentExecutionDate = current.getExecutionTime();
            Date nextExecutionDate = next.getExecutionTime();

            long monthsBetween = ChronoUnit.MONTHS.between(
                    currentExecutionDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                    nextExecutionDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
            );

            if (monthsBetween > 3) {
                return false;
            }
        }
        return true;
    }

    public static int calcIntensityRecurrentDisorder(List<DepressiveEpisode> bdsList) {
        int intensitySum = 0;
        for (DepressiveEpisode bds : bdsList) {
            intensitySum += bds.getIntensitySum();
        }
        return intensitySum;
    }

    public static boolean validateDiagnosisChange(RecurrentDepressiveDisorder rdd, ManicEpisode me) {
        Date rddExecutionTime = rdd.getExecutionTime();
        Date meExecutionTime = me.getExecutionTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(rddExecutionTime);
        calendar.add(Calendar.MONTH, 3);
        return meExecutionTime.after(rddExecutionTime) && meExecutionTime.before(calendar.getTime());
    }
}
