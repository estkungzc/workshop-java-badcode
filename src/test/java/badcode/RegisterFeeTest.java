package badcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RegisterFeeTest {

    @ParameterizedTest(name = "{index}: Experience {0} years, it should get fee = {1}")
    @CsvSource({
            "-1, 500",
            "1, 500",
            "3, 250",
            "5, 100",
            "9, 50",
            "10, 0"
    })
    @DisplayName("Get Free")
    public void getFee(int experienceYear, int expectedFee) {
        RegisterBusiness registerBusiness = new RegisterBusiness();

        assertEquals(expectedFee, registerBusiness.getFee(experienceYear));
    }

}