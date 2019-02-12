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
public class DestroyerTest extends TestCase {
    
    private Destroyer vessel;
    
    public DestroyerTest (String testName)
    {
        super(testName);
    }
    
    @Override
    protected void setUp () throws Exception
    {
        super.setUp();
        vessel = new Destroyer(0,0);
    }
    
    @Override
    protected void tearDown () throws Exception
    {
        super.tearDown();
    }

    public void testGetSonarRange ()
    {
        System.out.println("getSonarRange");
        int expResult = 8;
        int result = vessel.getSonarRange();
        assertEquals(expResult, result);
    }

    public void testGetPosition ()
    {
        System.out.println("getPosition");
        int[] expResult = {0,0};
        int[] result = vessel.getPosition();
        assertEquals(expResult[0], result[0]);
        assertEquals(expResult[1], result[1]);
    }

    public void testReadSonar ()
    {
        System.out.println("readSonar");
        Submarine submarine = new Submarine(0,0);
        boolean expResult = true;
        boolean result = vessel.readSonar(submarine);
        assertEquals(expResult, result);
    }

    public void testDropBomb ()
    {
        System.out.println("dropBomb");
        Submarine submarine = new Submarine(0,0);
        boolean expResult = true;
        boolean result = vessel.dropBomb(submarine);
        assertEquals(expResult, result);
    }

    public void testMoveVessel ()
    {
        System.out.println("moveVessel");
        int newX = 2;
        int newY = 2;
        Destroyer instance = new Destroyer(0,0);
        instance.moveVessel(newX, newY);
        int[] newPos = instance.getPosition();
        assertEquals(newPos[0], newX);
        assertEquals(newPos[1], newY);
    }

    public void testDistance ()
    {
        System.out.println("distance");
        Submarine submarine = new Submarine(0,0);
        int expResult = 0;
        int result = vessel.distance(submarine);
        assertEquals(expResult, result);
    }
    
}
