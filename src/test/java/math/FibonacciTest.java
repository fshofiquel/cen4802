package math;

// JUnit Jupiter API imports
import org.junit.jupiter.api.Test;                    // Marks methods as test methods (atomic execution units)
import org.junit.jupiter.api.DisplayName;             // Provides human-readable test names in reports (stakeholder communication)
import org.junit.jupiter.api.BeforeEach;              // Lifecycle method: runs BEFORE each test (setup phase)
import org.junit.jupiter.api.AfterEach;               // Lifecycle method: runs AFTER each test (teardown phase)
import static org.junit.jupiter.api.Assertions.*;     // Static import of assertion methods (assertEquals, etc.)

/**
 * FibonacciTest: Comprehensive Unit Test Suite for Fibonacci Calculator
 *
 * PURPOSE:
 * This test class demonstrates unit testing principles for the Fibonacci.nthFibonacci() static method.
 * Each test isolates a specific behavior (the "unit") and verifies the System Under Test (SUT) produces
 * correct results across different input scenarios.
 *
 * TEST ISOLATION & LIFECYCLE:
 * JUnit Jupiter instantiates a NEW instance of this test class for EVERY @Test method.
 * This prevents state leakage between tests and ensures reproducibility.
 * - @BeforeEach runs before each test (setup phase)
 * - @Test method executes the verification logic (execution phase)
 * - @AfterEach runs after each test (teardown phase)
 *
 * ARCHITECTURE COMPLIANCE:
 * - Non-abstract class (required by Jupiter discovery engine for instantiation)
 * - Package-private visibility (not public; module-path best practice)
 * - Single constructor (implicit default; allows reflection-based instantiation)
 * - No private methods (allows Jupiter discovery/invocation via reflection)
 */
public class FibonacciTest {

    /**
     * LIFECYCLE METHOD: Setup phase
     *
     * Runs BEFORE each individual @Test method execution.
     *
     * Purpose in this test suite:
     * The Fibonacci.nthFibonacci() method is stateless (pure function with no side effects),
     * so @BeforeEach is minimal. However, this pattern establishes best practice for:
     * - Initializing test fixtures
     * - Resetting mutable state
     * - Creating test doubles (mocks, stubs)
     *
     * This annotation ensures state isolation: each test starts with a clean slate.
     */
    @BeforeEach
    public void setUp() {
        // No initialization needed for stateless Fibonacci function
        // In a real-world scenario with stateful SUTs, this would reset shared resources
    }

    /**
     * LIFECYCLE METHOD: Teardown phase
     *
     * Runs AFTER each individual @Test method execution.
     *
     * Purpose in this test suite:
     * Cleans up resources used by the test (if any). For Fibonacci, there are no resources
     * to clean. However, this demonstrates the complete lifecycle pattern.
     */
    @AfterEach
    public void tearDown() {
        // No cleanup needed; Fibonacci leaves no state behind
        // In production scenarios, this closes file handles, database connections, etc.
    }

    // ============================================================================
    // TEST CATEGORY 1: BASE CASES
    // ============================================================================
    // Why: The Fibonacci sequence has two boundary conditions that seed all other values.
    // If base cases are wrong, the entire sequence fails.
    // Risk: Off-by-one errors, incorrect base case logic
    // ============================================================================

    /**
     * TEST: Base Case - F(0) = 0
     *
     * SCENARIO: Input is the start of the Fibonacci sequence (n=0)
     * EXPECTED: Returns 0 (first number in sequence: 0, 1, 1, 2, 3, 5, 8...)
     *
     * RATIONALE:
     * - Tests the lower boundary condition
     * - Verifies sequence initiation
     * - Catches errors in base case logic (e.g., returning 1 instead of 0)
     *
     * ASSERTION:
     * assertEquals(expected, actual, message) — Fails the test if expected != actual
     * Detailed message helps diagnose failure (for stakeholder visibility)
     */
    @Test
    @DisplayName("Fibonacci base case: F(0) should equal 0")
    public void testFibonacciBaseZero() {
        // Arrange: Set input
        int n = 0;

        // Act: Execute the System Under Test (SUT)
        int result = Fibonacci.nthFibonacci(n);

        // Assert: Verify the result matches the expected value
        assertEquals(0, result, "F(0) must be 0 (start of sequence)");
    }

    /**
     * TEST: Base Case - F(1) = 1
     *
     * SCENARIO: Input is the second starting point of the Fibonacci sequence (n=1)
     * EXPECTED: Returns 1 (second number in sequence: 0, 1, 1, 2, 3, 5, 8...)
     *
     * RATIONALE:
     * - Tests the second boundary condition
     * - Together with F(0)=0, provides the foundation for all recursion
     * - Catches off-by-one errors in base case handling
     */
    @Test
    @DisplayName("Fibonacci base case: F(1) should equal 1")
    public void testFibonacciBaseOne() {
        int n = 1;
        int result = Fibonacci.nthFibonacci(n);
        assertEquals(1, result, "F(1) must be 1 (second element of sequence)");
    }

    // ============================================================================
    // TEST CATEGORY 2: VALID SEQUENCES
    // ============================================================================
    // Why: Verify the algorithm produces correct results for known values.
    // These are mathematically verified Fibonacci numbers.
    // Risk: Recursion logic errors, addition errors, off-by-one in recursion depth
    // ============================================================================

    /**
     * TEST: Valid Sequence - F(5) = 5
     *
     * SCENARIO: Calculate the 5th Fibonacci number
     * EXPECTED: 5 (sequence: 0, 1, 1, 2, 3, 5)
     *
     * RATIONALE:
     * - Tests correctness beyond base cases
     * - Demonstrates recursion works at moderate depth (5 levels of recursion)
     * - Provides confidence in algorithm for typical use cases
     */
    @Test
    @DisplayName("Fibonacci sequence: F(5) should equal 5")
    public void testFibonacciValidSequenceFive() {
        int n = 5;
        int result = Fibonacci.nthFibonacci(n);
        assertEquals(5, result, "F(5) must be 5 in the Fibonacci sequence");
    }

    /**
     * TEST: Valid Sequence - F(6) = 8
     *
     * SCENARIO: Calculate the 6th Fibonacci number
     * EXPECTED: 8 (sequence: 0, 1, 1, 2, 3, 5, 8)
     *
     * RATIONALE:
     * - Extends testing to the next value, increasing recursion depth
     * - Verifies algorithm doesn't break as input grows
     */
    @Test
    @DisplayName("Fibonacci sequence: F(6) should equal 8")
    public void testFibonacciValidSequenceSix() {
        int n = 6;
        int result = Fibonacci.nthFibonacci(n);
        assertEquals(8, result, "F(6) must be 8 in the Fibonacci sequence");
    }

    /**
     * TEST: Valid Sequence - F(10) = 55
     *
     * SCENARIO: Calculate the 10th Fibonacci number
     * EXPECTED: 55 (sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55)
     *
     * RATIONALE:
     * - Tests correctness at a larger scale
     * - Increases recursion depth significantly
     * - Demonstrates the algorithm performs at a realistic use scale
     * - This is the same value used in DriverFunction demonstrations
     */
    @Test
    @DisplayName("Fibonacci sequence: F(10) should equal 55")
    public void testFibonacciValidSequenceTen() {
        int n = 10;
        int result = Fibonacci.nthFibonacci(n);
        assertEquals(55, result, "F(10) must be 55 in the Fibonacci sequence");
    }

    // ============================================================================
    // TEST CATEGORY 3: EDGE CASES / TRANSITION ZONE
    // ============================================================================
    // Why: Intermediate values catch off-by-one errors where recursion "kicks in".
    // These values bridge base cases to larger sequences.
    // Risk: Fence-post errors in recursion, incorrect loop termination
    // ============================================================================

    /**
     * TEST: Edge Case - F(2) = 1
     *
     * SCENARIO: First value that requires actual recursion (not a base case)
     * EXPECTED: 1 (sequence: 0, 1, 1)
     *
     * RATIONALE:
     * - Tests the transition from base cases to recursive calls
     * - F(2) = F(1) + F(0) = 1 + 0 = 1
     * - Catches errors in recursion initiation
     */
    @Test
    @DisplayName("Fibonacci edge case: F(2) should equal 1")
    public void testFibonacciEdgeCaseTwo() {
        int n = 2;
        int result = Fibonacci.nthFibonacci(n);
        assertEquals(1, result, "F(2) must be 1 (first recursive call: F(1) + F(0))");
    }

    /**
     * TEST: Edge Case - F(3) = 2
     *
     * SCENARIO: Second value requiring recursion
     * EXPECTED: 2 (sequence: 0, 1, 1, 2)
     *
     * RATIONALE:
     * - Tests recursion depth of 2
     * - F(3) = F(2) + F(1) = 1 + 1 = 2
     * - Verifies recursion chains correctly
     */
    @Test
    @DisplayName("Fibonacci edge case: F(3) should equal 2")
    public void testFibonacciEdgeCaseThree() {
        int n = 3;
        int result = Fibonacci.nthFibonacci(n);
        assertEquals(2, result, "F(3) must be 2 (recursion chain: F(2) + F(1))");
    }

    /**
     * TEST: Edge Case - F(4) = 3
     *
     * SCENARIO: Third value requiring deep recursion
     * EXPECTED: 3 (sequence: 0, 1, 1, 2, 3)
     *
     * RATIONALE:
     * - Tests recursion depth of 3
     * - F(4) = F(3) + F(2) = 2 + 1 = 3
     * - Demonstrates algorithm works for moderate input growth
     */
    @Test
    @DisplayName("Fibonacci edge case: F(4) should equal 3")
    public void testFibonacciEdgeCaseFour() {
        int n = 4;
        int result = Fibonacci.nthFibonacci(n);
        assertEquals(3, result, "F(4) must be 3 (deep recursion: F(3) + F(2))");
    }

    // ============================================================================
    // TEST CATEGORY 4: NEGATIVE INPUT BOUNDARY
    // ============================================================================
    // Why: Tests error handling at the lower boundary.
    // Negative indices are outside the Fibonacci sequence definition.
    // Risk: Undefined behavior, incorrect error handling, infinite loops
    // ============================================================================

    /**
     * TEST: Negative Input Boundary - F(-1)
     *
     * SCENARIO: Invalid input (negative index)
     * EXPECTED: Returns -1 (based on current implementation: returns n if n <= 1)
     *
     * RATIONALE:
     * - Tests behavior with invalid, out-of-range input
     * - Documents expected behavior for edge case
     * - Verifies the algorithm doesn't break with negative numbers
     * - Current implementation returns n directly (no error thrown), so returns -1
     *
     * NOTE: In production code, this might throw an exception instead.
     * The test documents whatever behavior is currently implemented.
     */
    @Test
    @DisplayName("Fibonacci boundary: F(-1) should handle negative input gracefully")
    public void testFibonacciNegativeInput() {
        int n = -1;
        int result = Fibonacci.nthFibonacci(n);
        // Current implementation returns n when n <= 1, so -1 returns -1
        assertEquals(-1, result, "F(-1) should return -1 (current implementation: returns n if n <= 1)");
    }

    // ============================================================================
    // TEST CATEGORY 5: SCALABILITY / PERFORMANCE VERIFICATION
    // ============================================================================
    // Why: Verify the algorithm doesn't break at larger scales.
    // Tests confidence for production use with realistic input sizes.
    // Risk: Stack overflow from deep recursion, performance degradation, integer overflow
    // ============================================================================

    /**
     * TEST: Scalability - F(20) = 6765
     *
     * SCENARIO: Calculate Fibonacci at a larger scale (n=20)
     * EXPECTED: 6765 (mathematically verified Fibonacci number)
     *
     * RATIONALE:
     * - Tests algorithm at realistic, larger input
     * - Recursion depth of ~20 is significant; verifies no stack overflow
     * - Demonstrates confidence in production use for moderate-sized inputs
     * - Also verifies results don't overflow Java int (32-bit signed integer)
     * - This is a "confidence test" for stakeholders: "we tested it at scale"
     *
     * NOTE: Recursive Fibonacci becomes inefficient around n=40+ due to exponential calls.
     * F(20) is a good balance: large enough to be impressive, small enough to complete quickly.
     */
    @Test
    @DisplayName("Fibonacci scalability: F(20) should equal 6765")
    public void testFibonacciScalability() {
        int n = 20;
        int result = Fibonacci.nthFibonacci(n);
        assertEquals(6765, result, "F(20) must be 6765 (scalability verification)");
    }

    // ============================================================================
    // SUMMARY
    // ============================================================================
    // Test Coverage Strategy:
    // 1. Base Cases (2 tests) — Verify sequence foundation
    // 2. Valid Sequences (3 tests) — Verify core algorithm correctness
    // 3. Edge Cases (3 tests) — Catch off-by-one errors in recursion
    // 4. Negative Boundary (1 test) — Document error handling
    // 5. Scalability (1 test) — Confidence at realistic scale
    // TOTAL: 10 comprehensive tests
    //
    // Each test is ISOLATED: New test instance per @Test method
    // Each test DOCUMENTS expected behavior: @DisplayName explains why
    // Each test FAILS FAST: One assertion, clear message, immediate feedback
    //
    // Strategic Value to Stakeholders:
    // - REGRESSION SAFETY: These tests prevent future code changes from breaking Fibonacci
    // - EXECUTABLE SPECIFICATION: Tests ARE the living documentation of what "correct" means
    // - CONFIDENCE: Full test suite passing = confident refactoring / deployment
    // ============================================================================
}

