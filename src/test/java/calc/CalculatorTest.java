package calc;

import org.junit.Test;
import static org.junit.Assert.*;


public class CalculatorTest {
    
    Calculator calc = new Calculator();
    
    public CalculatorTest() {
    }

    @Test
    public void testAdd() {
        
        assertTrue("Expected 2",calc.add(1, 1) == 2);
        
    }
    
    @Test
    public void testSub() {
        
        assertTrue("Expected 2", calc.sub(4, 2) == 2);
        
    }
    
    @Test
    public void testMul() {
        
        assertTrue("Expected 4", calc.mul(2, 2) == 4);
        
    }
    
    @Test
    public void testDiv() {
        
        assertTrue("Expected 2", calc.div(4, 2) == 2);
        
    }
    
//    @Test
//    public void testDivByZero() {
//        
//        assertTrue("null exception", calc.div(4, 0) == 0);
//        
//    }
    
    
    
}
