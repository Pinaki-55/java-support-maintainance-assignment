import java.util.List;
import java.util.logging.Logger;

public class DocumentValidator {

    private static final Logger logger =
            Logger.getLogger(DocumentValidator.class.getName());

    public ValidationResult validate(Document doc) {

        try {

            if (doc == null) {
                throw new IllegalArgumentException("Document is null");
            }

            String content = doc.extractContent();

            if (content == null || content.isEmpty()) {
                throw new IllegalArgumentException("Empty content");
            }

            return runValidationRules(content);

        } catch (IllegalArgumentException e) {

            logger.warning("Validation failed: " + e.getMessage());

            return new ValidationResult();

        } catch (Exception e) {

            logger.severe("Unexpected validation error");

            return new ValidationResult();
        }
    }

    public void validateBatch(List<Document> docs) {

        for (Document doc : docs) {

            try {

                ValidationResult r = validate(doc);

                if (r != null && r.isValid()) {
                    saveResult(r);
                }

            } catch (Exception e) {

                logger.severe("Batch validation failed");
            }
        }
    }
}
