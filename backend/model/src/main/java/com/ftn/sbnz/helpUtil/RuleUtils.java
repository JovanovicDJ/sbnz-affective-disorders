package com.ftn.sbnz.helpUtil;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class RuleUtils {
    public static boolean checkExecutionTimesAfterSixtyDays(Date executionTime1, Date executionTime2) {
        Instant now = Instant.now();
        Instant sixtyDaysAgo = now.minus(60, ChronoUnit.DAYS);
        return executionTime1.toInstant().isAfter(sixtyDaysAgo) && executionTime2.toInstant().isAfter(sixtyDaysAgo);
    }
}
