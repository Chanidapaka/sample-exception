package sit.int204.sampleexception.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.rest.webmvc.support.RepositoryConstraintViolationExceptionMessage;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyErrorResponse {
    private final int status;
    private final String message;
    private final String instance;
    private Instant timestamp = Instant.now();
    private String stackTrace;
    private List<ValidationError> errors;

    @Getter
    @Setter
    @RequiredArgsConstructor
    private static class ValidationError {
        private final String field;
        private final String message;
    }

    public void addValidationError(String field, String message) {
        if (errors == null) {
            errors = new ArrayList<>();
        }
        errors.add(new ValidationError(field, message));
    }
}