package uk.gov.gds.locate.api.frontend.validation;

import org.junit.Test;
import uk.gov.gds.locate.api.frontend.model.CreateUserRequest;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static uk.gov.gds.locate.api.frontend.validation.ValidationCreateUserRequest.*;

public class ValidationCreateUserRequestTest {

    private static final String TOO_LONG = "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789123456";

    @Test
    public void shouldReturnNoErrorsIfValid() {
        CreateUserRequest request = new CreateUserRequest("app name", "name", "email@something.gov.uk", "org", "1234567890");
        List<String> errors = validateRequest(request);
        assertThat(errors.size()).isEqualTo(0);
    }

    @Test
    public void shouldReturnAnErrorIfNoName() {
        CreateUserRequest request = new CreateUserRequest("app name", "", "email@something.gov.uk", "org", "1234567890");
        List<String> errors = validateRequest(request);
        assertThat(errors.size()).isEqualTo(1);
        assertThat(errors.get(0)).isEqualTo("Name must be present and shorter than 255 letters");
    }

    @Test
    public void shouldReturnAnErrorIfNoAppName() {
        CreateUserRequest request = new CreateUserRequest("", "name", "email@something.gov.uk", "org", "1234567890");
        List<String> errors = validateRequest(request);
        assertThat(errors.size()).isEqualTo(1);
        assertThat(errors.get(0)).isEqualTo("Application name must be present and shorter than 255 letters");
    }

    @Test
    public void shouldReturnAnErrorIfAppNameTooLong() {
        CreateUserRequest request = new CreateUserRequest(TOO_LONG, "name", "email@something.gov.uk", "org", "1234567890");
        List<String> errors = validateRequest(request);
        assertThat(errors.size()).isEqualTo(1);
        assertThat(errors.get(0)).isEqualTo("Application name must be present and shorter than 255 letters");
    }

    @Test
    public void shouldReturnAnErrorIfNameTooLong() {
        CreateUserRequest request = new CreateUserRequest("app name", TOO_LONG, "email@something.gov.uk", "org", "1234567890");
        List<String> errors = validateRequest(request);
        assertThat(errors.size()).isEqualTo(1);
        assertThat(errors.get(0)).isEqualTo("Name must be present and shorter than 255 letters");
    }

    @Test
    public void shouldReturnAnErrorIfNotValidGvtEmail() {
        CreateUserRequest request = new CreateUserRequest("app name", "name", "email@something.co.uk", "org", "1234567890");
        List<String> errors = validateRequest(request);
        assertThat(errors.size()).isEqualTo(1);
        assertThat(errors.get(0)).isEqualTo("Email must be a valid government address");
    }

    @Test
    public void shouldReturnAnErrorIfTooLongValidGvtEmail() {
        CreateUserRequest request = new CreateUserRequest("app name", "name", TOO_LONG + "@something.gov.uk", "org", "1234567890");
        List<String> errors = validateRequest(request);
        assertThat(errors.size()).isEqualTo(1);
        assertThat(errors.get(0)).isEqualTo("Email must be a valid government address");
    }

    @Test
    public void shouldReturnAnErrorIfNotValidEmail() {
        CreateUserRequest request = new CreateUserRequest("app name", "name", "@.gov.uk", "org", "1234567890");
        List<String> errors = validateRequest(request);
        assertThat(errors.size()).isEqualTo(1);
        assertThat(errors.get(0)).isEqualTo("Email must be a valid government address");
    }

    @Test
    public void shouldReturnAnErrorIfNoOrganisation() {
        CreateUserRequest request = new CreateUserRequest("app name", "me", "email@something.gov.uk", "", "1234567890");
        List<String> errors = validateRequest(request);
        assertThat(errors.size()).isEqualTo(1);
        assertThat(errors.get(0)).isEqualTo("Organisation must be present and shorter than 255 letters");
    }

    @Test
    public void shouldReturnAnErrorIfTooLongOrganisation() {
        CreateUserRequest request = new CreateUserRequest("app name", "me", "email@something.gov.uk", TOO_LONG, "1234567890");
        List<String> errors = validateRequest(request);
        assertThat(errors.size()).isEqualTo(1);
        assertThat(errors.get(0)).isEqualTo("Organisation must be present and shorter than 255 letters");
    }

    @Test
    public void shouldReturnAnErrorIfNoPSMA() {
        CreateUserRequest request = new CreateUserRequest("app name", "me", "email@something.gov.uk", "org", "");
        List<String> errors = validateRequest(request);
        assertThat(errors.size()).isEqualTo(1);
        assertThat(errors.get(0)).isEqualTo("PSMA license number must be valid");
    }

}
