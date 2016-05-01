/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.AddressManagement;

import entity.AddressManagement.exceptions.NonexistentEntityException;
import entity.AddressManagement.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author QuestionBoy
 */
public class ProvinceJpaController implements Serializable {

    public ProvinceJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Province province) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(province);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProvince(province.getProvinceid()) != null) {
                throw new PreexistingEntityException("Province " + province + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Province province) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            province = em.merge(province);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = province.getProvinceid();
                if (findProvince(id) == null) {
                    throw new NonexistentEntityException("The province with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Province province;
            try {
                province = em.getReference(Province.class, id);
                province.getProvinceid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The province with id " + id + " no longer exists.", enfe);
            }
            em.remove(province);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Province> findProvinceEntities() {
        return findProvinceEntities(true, -1, -1);
    }

    public List<Province> findProvinceEntities(int maxResults, int firstResult) {
        return findProvinceEntities(false, maxResults, firstResult);
    }

    private List<Province> findProvinceEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Province.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Province findProvince(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Province.class, id);
        } finally {
            em.close();
        }
    }

    public int getProvinceCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Province> rt = cq.from(Province.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
