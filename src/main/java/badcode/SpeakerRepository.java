package badcode;

public interface SpeakerRepository {
    Integer saveSpeaker(Speaker speaker) throws SaveSpeakerException;
}
