package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterBusinessFailTest {

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
    @DisplayName("Last name is null, it should be occur exception")
    public void case02() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Foo");

        Exception exception = assertThrows(ArgumentNullException.class, () ->
                registerBusiness.register(null, speaker)
        );
        assertEquals("Last name is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Email is null, it should be occur exception")
    public void case03() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Foo");
        speaker.setLastName("Bar");

        Exception exception = assertThrows(ArgumentNullException.class, () ->
                registerBusiness.register(null, speaker)
        );
        assertEquals("Email is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Email is not in domain, it should be occur exception")
    public void case04() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Foo");
        speaker.setLastName("Bar");
        speaker.setEmail("foo.bar@hotmail.com");

        Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class, () ->
                registerBusiness.register(null, speaker)
        );
        assertEquals("Speaker doesn't meet our standard rules.", exception.getMessage());
    }

    @Test
    @DisplayName("Email is invalid, it should be occur exception")
    public void case05() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Foo");
        speaker.setLastName("Bar");
        speaker.setEmail("foo.barzxczxc");

        Exception exception = assertThrows(DomainEmailInvalidException.class, () ->
                registerBusiness.register(null, speaker)
        );
        assertNull(exception.getMessage());
    }

    @Test
    @DisplayName("Repository is null, it should be occur exception")
    public void case06() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Foo");
        speaker.setLastName("Bar");
        speaker.setEmail("foo.bar@gmail.com");

        Exception exception = assertThrows(SaveSpeakerException.class, () ->
                registerBusiness.register(null, speaker)
        );
        assertEquals("Can't save a speaker.", exception.getMessage());
    }

}