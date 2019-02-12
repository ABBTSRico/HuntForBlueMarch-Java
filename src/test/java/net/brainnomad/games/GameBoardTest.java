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
public class GameBoardTest extends TestCase {
    
    private GameBoard board;
    
    public GameBoardTest (String testName)
    {
        super(testName);
    }
    
    @Override
    protected void setUp () throws Exception
    {
        super.setUp();
        board = new GameBoard();
    }
    
    @Override
    protected void tearDown () throws Exception
    {
        super.tearDown();
    }

    public void testGetBoardWith ()
    {
        System.out.println("getBoardWith");
        int expResult = 20;
        int result = board.getBoardWith();
        assertEquals(expResult, result);
    }

    public void testGetBoardHeight ()
    {
        System.out.println("getBoardHeight");
        int expResult = 20;
        int result = board.getBoardHeight();
        assertEquals(expResult, result);
    }    
}
