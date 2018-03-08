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
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author 715583
 */
public class NoteDB {

    public NoteDB() {

    }

    public List getAllNotes() {
        Session session = NoteUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Note> notelist = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Note");
            //will return the results in a list 
            notelist = query.list();
            tx.commit();
            System.out.println(notelist.size());
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return notelist;
    }

    public Note getNote(int noteId) {
        Session session = NoteUtil.getSessionFactory().openSession();;
        Transaction tx = null;
        Note note = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Note where noteId = :noteId");
            query.setParameter("noteId", noteId);
            //will return a single instance (or a exception if more than one is found or null if none is found) 
            note = (Note) query.uniqueResult();
            tx.commit();
            System.out.println(note.toString());
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return note;
    }

    public int update(Note note) {
        Session session = NoteUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(note);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return 1;
    }

    public int delete(Note note) {
        Session session = NoteUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(note);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return 1;
    }

    public int insert(Note note) {
        Session session = NoteUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer noteId = null;
        try {
            tx = session.beginTransaction();

            noteId = (Integer) session.save(note);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return noteId;
    }

}
