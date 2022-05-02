import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EOMMTest {

    EOMM test;

    @BeforeEach
    public void beforeEach(){
        System.out.println("Initializing");
        test = new EOMM();

    }
    @Test
    public void evenOddTwoExpectedEven() {
        assertEquals(test.evenOdd(2),"even");
    }
    @Test
    public void evenOddThreeExpectedOdd() {
        assertEquals(test.evenOdd(3),"odd");
    }
    @Test
    public void evenOddNegativeFiveExpectedOdd() {
        assertEquals(test.evenOdd(-5),"odd");
    }

    @Test
    public void minMaxRepeatedElementsExpectedThatElements() {
        int[] arr = {0,0,0,0,0};
        int[] expected = {0,0};
        Assertions.assertArrayEquals(test.minMax(arr), expected);
    }
    @Test
    public void minMaxPositiveElementsExpectedTrue() {
        int[] arr = {22,4,1,111,69};
        int[] expected = {1,111};
        Assertions.assertArrayEquals(test.minMax(arr), expected);
    }
    @Test
    public void minMaxNegativeElementsExpectedTrue() {
        int[] arr = {-22,-4,-1,-111,-69};
        int[] expected = {-111,-1};
        Assertions.assertArrayEquals(test.minMax(arr), expected);
    }
    @Test
    public void minMaxDifferentElementsExpectedTrue() {
        int[] arr = {-22,4,-1,-111,69};
        int[] expected = {-111,69};
        Assertions.assertArrayEquals(test.minMax(arr), expected);
    }

    @AfterEach
    public void afterEach(){
        test = null;
        System.out.println("Test done");
    }
}