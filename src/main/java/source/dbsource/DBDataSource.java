package source.dbsource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import services.utils.ServiceContext;

import javax.persistence.EntityManager;
import java.util.List;

/**
 *
 */
public class DBDataSource {
    private static DBDataSource dataSources = new DBDataSource();

    /**
     *
     * @return
     */
    public static DBDataSource getInstance(){
        if(dataSources == null){
            dataSources = new DBDataSource();
        }
        return dataSources;
    }

    /**
     *
     * @param object
     * @param serviceContext
     * @return
     */
    public Object insert(Object object, ServiceContext serviceContext){
        EntityManager em = serviceContext.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            return object;
        }
    }

    /**
     *
     * @param type
     * @param id
     * @param serviceContext
     */
    public void delete(Class type, int id, ServiceContext serviceContext){
        Object object = select(type, id, serviceContext);
        if(object != null){
            delete(object, serviceContext);
        }
    }

    /**
     *
     * @param object
     * @param serviceContext
     */
    public void delete(Object object, ServiceContext serviceContext){
        EntityManager em = serviceContext.getEntityManager();
        try{
            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
        }
    }

    /**
     *
     * @param type
     * @param id
     * @param serviceContext
     * @return
     */
    public Object select(Class type, int id, ServiceContext serviceContext){
        EntityManager em = serviceContext.getEntityManager();
        Object object = null;
        try{
            em.getTransaction().begin();
            object = em.find(type, id);
            em.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            return object;
        }
    }

    /**
     *
     * @param type
     * @param fieldName
     * @param fieldValue
     * @param serviceContext
     * @return
     */
    public Object selectUniqueBy(Class type, String fieldName, Object fieldValue, ServiceContext serviceContext){
        Session session = serviceContext.getEntityManager().unwrap(Session.class);
        Criteria criteria = session.createCriteria(type);
        Object object = criteria.add(Restrictions.eq(fieldName, fieldValue)).uniqueResult();
        return object;
    }

    /**
     *
     * @param type
     * @param fieldName
     * @param fieldValue
     * @param serviceContext
     * @return
     */
    public List<Object> selectAllBy(Class type, String fieldName, Object fieldValue, ServiceContext serviceContext){
        Session session = serviceContext.getEntityManager().unwrap(Session.class);
        Criteria criteria = session.createCriteria(type);
        List<Object> object = criteria.add(Restrictions.eq(fieldName, fieldValue)).list();
        return object;
    }

    /**
     *
     * @param object
     * @param serviceContext
     */
    public void update(Object object, ServiceContext serviceContext){
        EntityManager em = serviceContext.getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
        }
    }
}