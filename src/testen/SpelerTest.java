package testen;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Speler;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SpelerTest {
	
	private static int huidigeJaar = LocalDate.now().getYear();
	
	private static Stream<Arguments> teJong() {
		 return Stream.of(
		   Arguments.of(huidigeJaar - 5),
		   Arguments.of(huidigeJaar - 4),
		   Arguments.of(huidigeJaar),
		   Arguments.of(huidigeJaar + 1));
		}
	private static Stream<Arguments> oudGenoeg() {
		 return Stream.of(
		   Arguments.of(huidigeJaar - 7),
		   Arguments.of(huidigeJaar - 10),
		   Arguments.of(huidigeJaar - 20),
		   Arguments.of(huidigeJaar - 28));
		}
	private static Stream<Arguments> teJongConstructor() {
		 return Stream.of(
		   Arguments.of("naam",huidigeJaar - 5),
		   Arguments.of("a1_)", huidigeJaar - 20),
		   Arguments.of("qqf$", huidigeJaar - 18));

		}
	
	
    @ParameterizedTest
    @CsvSource({
            "naam, 2000",
            "a1_2 3, 1990",
            "a, 2002"
    })
    void constructor_ValidInput(String naam, int geboortejaar) {
        Speler speler = new Speler(naam, geboortejaar);

        assertEquals(naam, speler.getGebruikersnaam());
        assertEquals(geboortejaar, speler.getGeboortejaar());
    }
    
    @ParameterizedTest
    @MethodSource("teJongConstructor")
    void constructor_InValidInput(String naam, int geboortejaar) {
        assertThrows(IllegalArgumentException.class, () -> new Speler(naam, geboortejaar));
    }
    

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "1a", "a_b-c", "a_*", "_a", "a$b"})
    void setGebruikersnaam_InvalidInput_ThrowsException(String naam) {
        Speler speler = new Speler("naam", SpelerTest.huidigeJaar - 10);

        assertThrows(IllegalArgumentException.class, () -> speler.setGebruikersnaam(naam));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"a", "a1", "a_1", "a b"})
    void setGebruikersnaam_ValidInput(String naam) {
    	Speler speler = new Speler("naam", SpelerTest.huidigeJaar - 10);
    	
    	speler.setGebruikersnaam(naam);
    	
    	assertEquals(naam, speler.getGebruikersnaam());
    }

    @ParameterizedTest
    @MethodSource("teJong")
    void setGeboortejaar_InvalidInput_ThrowsException(int geboortejaar) {
        Speler speler = new Speler("naam", SpelerTest.huidigeJaar - 10);

        assertThrows(IllegalArgumentException.class, () -> speler.setGeboortejaar(geboortejaar));
    }


    @ParameterizedTest
    @MethodSource("oudGenoeg")
    void setGeboortejaar_ValidInput(int geboortejaar) {
        Speler speler = new Speler("naam", SpelerTest.huidigeJaar - 10);

        speler.setGeboortejaar(geboortejaar);

        assertEquals(geboortejaar, speler.getGeboortejaar());
    }
}
