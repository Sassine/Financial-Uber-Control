package dev.sassine.financialcontrol.mail.service;

import java.math.BigDecimal;
import java.time.Instant;

public interface EmailReaderService {
    void readEmails(String subjectFilter, Instant start, Instant end) throws Exception;
    BigDecimal getTotalGasto();
}

