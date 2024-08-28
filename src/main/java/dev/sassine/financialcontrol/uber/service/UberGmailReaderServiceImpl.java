package dev.sassine.financialcontrol.uber.service;
import dev.sassine.financialcontrol.config.mail.EmailConnectionManager;
import dev.sassine.financialcontrol.mail.service.EmailReaderService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.search.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Service("uberGmailReaderService")
public class UberGmailReaderServiceImpl implements EmailReaderService {

    private final EmailConnectionManager emailConnectionManager;

    private BigDecimal totalGasto = BigDecimal.ZERO;

    @Autowired
    public UberGmailReaderServiceImpl(EmailConnectionManager emailConnectionManager) {
        this.emailConnectionManager = emailConnectionManager;
    }

    @Override
    public void readEmails(String subjectFilter, Instant start, Instant end) throws Exception {
        try (Store store = emailConnectionManager.createStore()) {
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            SearchTerm searchTerm = createSearchTerm(subjectFilter, start, end);
            Message[] messages = emailFolder.search(searchTerm);

            System.out.println("find Messages: " + messages.length);
            Stream.of(messages).forEach(this::processEmail);

            System.out.println("Total gasto: R$ " + getTotalGasto());

            emailFolder.close(false);
        }
    }

    @Override
    public BigDecimal getTotalGasto() {
        return totalGasto;
    }

    private SearchTerm createSearchTerm(String subjectFilter, Instant start, Instant end) {
        SearchTerm startDateTerm = new ReceivedDateTerm(ComparisonTerm.GE, Date.from(start));
        SearchTerm endDateTerm = new ReceivedDateTerm(ComparisonTerm.LE, Date.from(end));
        SearchTerm subjectTerm = new SubjectTerm(subjectFilter);
        SearchTerm dateTerm = new AndTerm(startDateTerm, endDateTerm);
        return new AndTerm(dateTerm, subjectTerm);
    }

    private void processEmail(Message message) {
        try {
            String content = (String) message.getContent();
            Document doc = Jsoup.parse(content);
            extractValue(doc)
                    .flatMap(this::extractValue)
                    .ifPresent(value -> totalGasto = totalGasto.add(value));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Optional<String> extractValue(Document doc) {
        return doc.select("div:contains(Total)")
                .stream()
                .findFirst()
                .map(Element::text);
    }

    private Optional<BigDecimal> extractValue(String text) {
        return Optional.ofNullable(text)
                .flatMap(this::parseValue);
    }

    private Optional<BigDecimal> parseValue(String text) {
        Pattern pattern = Pattern.compile("Total\\s*R\\$\\s*([\\d,.]+)");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            try {
                return Optional.of(new BigDecimal(matcher.group(1).replace(".", "").replace(",", ".")));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }
}
