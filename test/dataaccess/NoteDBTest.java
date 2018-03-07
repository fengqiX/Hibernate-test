/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 715583
 */
public class NoteDBTest {
    
    public NoteDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getAllNotes method, of class NoteDB.
     */
    @Test
    public void testGetAllNotes() {
        System.out.println("getAllNotes");
        NoteDB instance = new NoteDB();
        List result = instance.getAllNotes();
        
        System.out.println("dataaccess.NoteDBTest.testGetAllNotes()"+result.toString());
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
