package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterBusinessSuccessTest {

    @Test
    @DisplayName("Register should be success")
    public void case07() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Foo");
        speaker.setLastName("Bar");
        speaker.setEmail("foo.bar@gmail.com");

        SpeakerRepository speakerRepository = speakerInput -> 1;

        Integer actualResult = registerBusiness.register(speakerRepository, speaker);
        assertEquals(1, actualResult);
    }

}
