/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.brainnomad.games;

import junit.framework.TestCase;

/**
 *
 * @author Andreas Wassmer (aw@andreas-wassmer.ch)
 */
public class SubmarineTest extends TestCase {
    private Submarine submarine;
    
    public SubmarineTest (String testName)
    {
        super(testName);
    }
    
    @Override
    protected void setUp () throws Exception
    {
        super.setUp();
        submarine = new Submarine(0,0);
    }
    
    @Override
    protected void tearDown () throws Exception
    {
        super.tearDown();
    }

    public void testGetPosition ()
    {
        System.out.println("getPosition");
        int[] expResult = {0,0};
        int[] result = submarine.getPosition();
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
    }

    public void testCheckCollision ()
    {
        System.out.println("checkCollision");
        Destroyer destroyer = new Destroyer(0,0);
        boolean expResult = true;
        boolean result = submarine.checkCollision(destroyer);
        assertEquals(expResult, result);
    }

    public void testCheckNoCollision ()
    {
        System.out.println("checkCollision");
        Destroyer destroyer = new Destroyer(10,10);
        boolean expResult = false;
        boolean result = submarine.checkCollision(destroyer);
        assertEquals(expResult, result);
    }   
}
