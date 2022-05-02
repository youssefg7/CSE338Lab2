import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class WatchTest {
    static Watch test;

    @Nested
    public class EdgeCoverage {
        //suite = "aacbabababababad"
        @BeforeAll
        public static void initialise() {
            System.out.println("Initializing Edge Coverage Testing...");
            System.out.println("Test suite used is 'aacbabababababad'");
            System.out.println("Initially: ");
            test = new Watch();
            test.displayTime();
            test.displayDate();
        }

        @Test
        public void EC1() {
            test.setInput('a');
            assertEquals(test.getState(), "NORMAL");
            assertEquals(test.getSubState(), "date");
            assertEquals(test.getTime(), "0 : 0");
            assertEquals(test.getDate(), "2000 - 1 - 1");
        }

        @Test
        public void EC2() {
            test.setInput('a');
            assertEquals(test.getState(), "NORMAL");
            assertEquals(test.getSubState(), "time");
            assertEquals(test.getTime(), "0 : 0");
            assertEquals(test.getDate(), "2000 - 1 - 1");
        }

        @Test
        public void EC3() {
            test.setInput('c');
            assertEquals(test.getState(), "UPDATE");
            assertEquals(test.getSubState(), "min");
            assertEquals(test.getTime(), "0 : 0");
            assertEquals(test.getDate(), "2000 - 1 - 1");
        }

        @Test
        public void EC4() {
            test.setInput('b');
            assertEquals(test.getState(), "UPDATE");
            assertEquals(test.getSubState(), "min");
            assertEquals(test.getTime(), "0 : 1");
            assertEquals(test.getDate(), "2000 - 1 - 1");
        }

        @Test
        public void EC5() {
            test.setInput('a');
            assertEquals(test.getState(), "UPDATE");
            assertEquals(test.getSubState(), "hour");
            assertEquals(test.getTime(), "0 : 1");
            assertEquals(test.getDate(), "2000 - 1 - 1");
        }

        @Test
        public void EC6() {
            test.setInput('b');
            assertEquals(test.getState(), "UPDATE");
            assertEquals(test.getSubState(), "hour");
            assertEquals(test.getTime(), "1 : 1");
            assertEquals(test.getDate(), "2000 - 1 - 1");
        }

        @Test
        public void EC7() {
            test.setInput('a');
            assertEquals(test.getState(), "UPDATE");
            assertEquals(test.getSubState(), "day");
            assertEquals(test.getTime(), "1 : 1");
            assertEquals(test.getDate(), "2000 - 1 - 1");
        }

        @Test
        public void EC8() {
            test.setInput('b');
            assertEquals(test.getState(), "UPDATE");
            assertEquals(test.getSubState(), "day");
            assertEquals(test.getTime(), "1 : 1");
            assertEquals(test.getDate(), "2000 - 1 - 2");
        }

        @Test
        public void EC9() {
            test.setInput('a');
            assertEquals(test.getState(), "UPDATE");
            assertEquals(test.getSubState(), "month");
            assertEquals(test.getTime(), "1 : 1");
            assertEquals(test.getDate(), "2000 - 1 - 2");
        }

        @Test
        public void EC10() {
            test.setInput('b');
            assertEquals(test.getState(), "UPDATE");
            assertEquals(test.getSubState(), "month");
            assertEquals(test.getTime(), "1 : 1");
            assertEquals(test.getDate(), "2000 - 2 - 2");
        }

        @Test
        public void EC11() {
            test.setInput('a');
            assertEquals(test.getState(), "UPDATE");
            assertEquals(test.getSubState(), "year");
            assertEquals(test.getTime(), "1 : 1");
            assertEquals(test.getDate(), "2000 - 2 - 2");
        }

        @Test
        public void EC12() {
            test.setInput('b');
            assertEquals(test.getState(), "UPDATE");
            assertEquals(test.getSubState(), "year");
            assertEquals(test.getTime(), "1 : 1");
            assertEquals(test.getDate(), "2001 - 2 - 2");
        }

        @Test
        public void EC13() {
            test.setInput('a');
            assertEquals(test.getState(), "NORMAL");
            assertEquals(test.getSubState(), "time");
            assertEquals(test.getTime(), "1 : 1");
            assertEquals(test.getDate(), "2001 - 2 - 2");
        }

        @Test
        public void EC14() {
            test.setInput('b');
            assertEquals(test.getState(), "ALARM");
            assertEquals(test.getSubState(), "alarm");
            assertEquals(test.getTime(), "1 : 1");
            assertEquals(test.getDate(), "2001 - 2 - 2");
        }

        @Test
        public void EC15() {
            test.setInput('a');
            assertEquals(test.getState(), "ALARM");
            assertEquals(test.getSubState(), "chime");
            assertEquals(test.getTime(), "1 : 1");
            assertEquals(test.getDate(), "2001 - 2 - 2");
        }

        @Test
        public void EC16() {
            test.setInput('d');
            assertEquals(test.getState(), "NORMAL");
            assertEquals(test.getSubState(), "time");
            assertEquals(test.getTime(), "1 : 1");
            assertEquals(test.getDate(), "2001 - 2 - 2");
        }

        @AfterAll
        public static void finalise() {
            System.out.println("Edge Coverage Testing DONE");
            test = null;
        }
    }

    @Nested
    public class ADUP {
        //suite = "cbbabbabbabbabb"
        @BeforeAll
        public static void initialise() {
            System.out.println("Initialising ADUP testing...");
            System.out.println("Test suite used is 'cbbabbabbabbabb' covering " +
                    "all definitions and each of their uses for variables m, h, D, M, Y");
            test = new Watch();
        }

        @Test
        @DisplayName("Using Initial Def of m & m redefined")
        public void ADUP1() {
            test.setInput('c');
            test.setInput('b');
            assertEquals(test.getTime(), "0 : 1");
            assertEquals(test.getDate(), "2000 - 1 - 1");
        }

        @Test
        @DisplayName("Using Second Def of m & m redefined")
        public void ADUP2() {
            test.setInput('b');
            assertEquals(test.getTime(), "0 : 2");
            assertEquals(test.getDate(), "2000 - 1 - 1");
        }
        @Test
        @DisplayName("Using Initial Def of h & h redefined")
        public void ADUP3() {
            test.setInput('a');
            test.setInput('b');
            assertEquals(test.getTime(), "1 : 2");
            assertEquals(test.getDate(), "2000 - 1 - 1");
        }

        @Test
        @DisplayName("Using Second Def of h & h redefined")
        public void ADUP4() {
            test.setInput('b');
            assertEquals(test.getTime(), "2 : 2");
            assertEquals(test.getDate(), "2000 - 1 - 1");
        }

        @Test
        @DisplayName("Using Initial Def of D & D redefined")
        public void ADUP5() {
            test.setInput('a');
            test.setInput('b');
            assertEquals(test.getTime(), "2 : 2");
            assertEquals(test.getDate(), "2000 - 1 - 2");
        }

        @Test
        @DisplayName("Using Second Def of D & D redefined")
        public void ADUP6() {
            test.setInput('b');
            assertEquals(test.getTime(), "2 : 2");
            assertEquals(test.getDate(), "2000 - 1 - 3");
        }

        @Test
        @DisplayName("Using Initial Def of M & M redefined")
        public void ADUP7() {
            test.setInput('a');
            test.setInput('b');
            assertEquals(test.getTime(), "2 : 2");
            assertEquals(test.getDate(), "2000 - 2 - 3");
        }

        @Test
        @DisplayName("Using Second Def of M & M redefined")
        public void ADUP8() {
            test.setInput('b');
            assertEquals(test.getTime(), "2 : 2");
            assertEquals(test.getDate(), "2000 - 3 - 3");
        }

        @Test
        @DisplayName("Using Initial Def of Y & Y redefined")
        public void ADUP9() {
            test.setInput('a');
            test.setInput('b');
            assertEquals(test.getTime(), "2 : 2");
            assertEquals(test.getDate(), "2001 - 3 - 3");
        }
        @Test
        @DisplayName("Using Second Def of Y & Y redefined")
        public void ADUP10() {
            test.setInput('b');
            assertEquals(test.getTime(), "2 : 2");
            assertEquals(test.getDate(), "2002 - 3 - 3");
        }
    }
}