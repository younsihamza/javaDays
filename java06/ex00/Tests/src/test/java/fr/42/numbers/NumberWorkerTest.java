import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import numbers.*;

public class NumberWorkerTest {
    @ParameterizedTest
    @ValueSource(ints = {3,11,31})
    void isPrimeForPrimes(int number){
        NumberWorker numberWorker = new NumberWorker();
        assertTrue(numberWorker.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {50,14,20})
    void isPrimeForNotPrimes(int number){
        NumberWorker numberWorker = new NumberWorker();
        assertFalse(numberWorker.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1 ,0 ,1})
    void isPrimeForIncorrectNumbers(int number) {
        NumberWorker numberWorker = new NumberWorker();
        assertThrows( RuntimeException.class, ()->{numberWorker.isPrime(number);});
    }
    @ParameterizedTest
    @CsvFileSource(files="src/test/resources/data.csv" )
    void CheckDigitsSum(int number , int result) {
        NumberWorker numberWorker = new NumberWorker();
        assertEquals(result ,numberWorker.digitsSum(number));
    }

}
