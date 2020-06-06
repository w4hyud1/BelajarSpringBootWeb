package com.masthacode.dao;

import com.masthacode.model.Complain;
import com.masthacode.services.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.text.DateFormat;
import java.util.List;

@Service
public class ComplainDao implements ComplainService {

    private EntityManagerFactory emf;

    @Autowired
    public void setEmf (EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public List<Complain> listComplain(){
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Complain",Complain.class).getResultList();
    }

    @Override
    public Complain saveOrUpdate(Complain complain){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Complain saved = em.merge(complain);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public Complain getIdComplain(Integer id){
        EntityManager em = emf.createEntityManager();
        return em.find(Complain.class, id);
    }

}
