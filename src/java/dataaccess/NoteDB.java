/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domainmodel.Note;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author 715583
 */
public class NoteDB {

    public NoteDB() {

    }

    public List getAllNotes() {
        Session session = null;
        Transaction tx = null;
        List<Note> notelist = null;
        try {
            session = NoteUtil.getSessionFactory().openSession();
            notelist = null;
            tx = session.beginTransaction();
            Query query = session.createQuery("from Note");
            notelist = query.list();
            tx.commit();
            System.out.println(notelist.size());
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally {
         session.close(); 
      }
        return notelist;
    }

    public Note getNote(int noteId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int update(Note note) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int delete(Note note) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int insert(Note note) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


