package com.ftn.sbnz.helpUtil;

import com.ftn.sbnz.model.DepressiveEpisode;
import com.ftn.sbnz.model.ManicEpisode;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RuleUtils {
    public static boolean checkExecutionTimesAfterSixtyDays(Date executionTime1, Date executionTime2) {
        Instant now = Instant.now();
        Instant sixtyDaysAgo = now.minus(60, ChronoUnit.DAYS);
        return executionTime1.toInstant().isAfter(sixtyDaysAgo) && executionTime2.toInstant().isAfter(sixtyDaysAgo);
    }

    public static boolean checkExecutionTimesAfterOneYear(List<DepressiveEpisode> depressions, List<ManicEpisode> manias) {
        int correctDepressions = 0;
        int correctManias = 0;
        for (DepressiveEpisode de : depressions) {
            Instant now = Instant.now();
            Instant oneYearAgo = now.minus(365, ChronoUnit.DAYS);
            if (de.getExecutionTime().toInstant().isAfter(oneYearAgo)) {
                correctDepressions += 1;
            }
        }
        for (ManicEpisode me : manias) {
            Instant now = Instant.now();
            Instant oneYearAgo = now.minus(365, ChronoUnit.DAYS);
            if (me.getExecutionTime().toInstant().isAfter(oneYearAgo)) {
                correctManias += 1;
            }
        }
        return correctDepressions >= 2 && correctManias >= 2;
    }

    public static boolean checkExecutionTimesForManiaHypomania(List<DepressiveEpisode> depressions, ManicEpisode mania, ManicEpisode hypomania) {
        List<ManicEpisode> manias = new ArrayList<>();
        manias.add(mania);
        manias.add(hypomania);
        return checkExecutionTimesAfterOneYear(depressions, manias);
    }
}
