package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RegisterBusinessTest {

    @Test
    @DisplayName("First name is null, it should be occur exception")
    public void case01() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Exception exception = assertThrows(ArgumentNullException.class, () ->
                registerBusiness.register(null, new Speaker())
        );
        assertEquals("First name is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Have First name but Last name is null, it should be occur exception")
    public void case02() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Foo");

        Exception exception = assertThrows(ArgumentNullException.class, () ->
                registerBusiness.register(null, speaker)
        );
        assertEquals("Last name is required.", exception.getMessage());
    }
}