package unimarkscalculator.mainClasses;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Lukasz Bol
 */
public class AssignmentTest 
{
    private static Assignment testAssignment;
    private static double delta;
    
    public AssignmentTest(){}
    
    @BeforeClass
    public static void setUpClass(){}
    
    @AfterClass
    public static void tearDownClass(){}
    
    @Before
    public void setUp()
    {
        testAssignment = new Assignment("AI - NetLogo", "coursework", 85, 50);
        delta = 0;
    }
    
    @After
    public void tearDown(){}
    
    @Test
    public void testGetTitle()
    {
        String title = "AI - NetLogo";
        assertEquals(testAssignment.getTitle(), title);
    }
    
    @Test
    public void testGetType()
    {
        String type = "coursework";
        assertEquals(testAssignment.getType(), type);
    }
    
    @Test
    public void testGetResult()
    {
        double result = 85;
        assertEquals(result, testAssignment.getResult(), delta);
    }
    
    @Test
    public void testGetWeight()
    {
        double weight = 50;
        assertEquals(weight, testAssignment.getWeightPercent(), delta);
    }
    
    @Test
    public void testSetTitle()
    {
        String newTitle = "AI - NetLogo 2";
        testAssignment.setTitle(newTitle);
        assertEquals(testAssignment.getTitle(), newTitle);
    }
    
    @Test
    public void testSetType()
    {
        String newType = "exam";
        testAssignment.setType(newType);
        assertEquals(testAssignment.getType(), newType);
    }
    
    @Test
    public void testSetResult()
    {
        double newResult = 90;
        testAssignment.setResult(newResult);
        assertTrue(testAssignment.getResult() == newResult);
    }
    
    @Test
    public void testSetWeight()
    {
        double newWeight = 100;
        testAssignment.setWeightPercentage(newWeight);
        assertTrue(testAssignment.getWeightPercent() == newWeight);
    }
    
    @Test
    public void testToString()
    {
        String assignmentInfo = testAssignment.toString();
        assertTrue(assignmentInfo != null);
    }
}