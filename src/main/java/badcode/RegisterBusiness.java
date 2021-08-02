package badcode;

import java.util.Arrays;

public class RegisterBusiness {

    String[] domains = {"gmail.com", "live.com"};

    public Integer register(SpeakerRepository repository, Speaker speaker) {
        Integer speakerId;

        if (!isFieldExist(speaker.getFirstName())) throw new ArgumentNullException("First name is required.");
        if (!isFieldExist(speaker.getLastName())) throw new ArgumentNullException("Last name is required.");
        if (!isFieldExist(speaker.getEmail())) throw new ArgumentNullException("Email is required.");

        String emailDomain = getEmailDomain(speaker.getEmail()); // Avoid ArrayIndexOutOfBound
        if (Arrays.stream(domains).filter(it -> it.equals(emailDomain)).count() == 1) {
            int exp = speaker.getExp();
            speaker.setRegistrationFee(getFee(exp));
            try {
                speakerId = repository.saveSpeaker(speaker);
            } catch (Exception exception) {
                throw new SaveSpeakerException("Can't save a speaker.");
            }
        } else {
            throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");
        }

        return speakerId;
    }

    private boolean isFieldExist(String field) {
        return field != null && !field.trim().equals("");
    }

    int getFee(int exp) {
        int fee = 0;
        if (exp <= 1) {
            fee = 500;
        } else if (exp <= 3) {
            fee = 250;
        } else if (exp <= 5) {
            fee = 100;
        } else if (exp <= 9) {
            fee = 50;
        }
        return fee;
    }

    public String getEmailDomain(String email) {
        String[] inputs = email.trim().split("@");
        if (inputs.length == 2) return inputs[1];
        throw new DomainEmailInvalidException();
    }

}
