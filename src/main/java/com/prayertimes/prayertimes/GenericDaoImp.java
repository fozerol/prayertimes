/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prayertimes.prayertimes;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;



/**
 *
 * @author fatih
 */
//@Stateless
//@Named("baseDao")
@Component
public  class GenericDaoImp<T> {// implements GenericDao<T>{
    
/*    @PersistenceContext(unitName = "pu")
    protected EntityManager em;*/

    @PersistenceContext
    private EntityManager em;

    
    protected Class<T> type;
    public void setType(Class type) {
        this.type = type;
    }

    public GenericDaoImp() {
    }
    
   @PostConstruct
   public void init(){
       
     
   }
    public void setEm(EntityManager em) {
        this.em = em;
    }

    //@Override
    public long countAll(){
        long count = (long) em.createNamedQuery(type.getSimpleName()+".countAll").getSingleResult();
        return count;
    }
    

    //@Override
    @Transactional
    public void delete(T t) {
        
            
        t = em.merge(t);
        em.remove(t);
        }
       
    
    //@Override
    public T find(Object id) {
        return this.em.find(type, id);
                //find(type, id);
    }
    public List<T> findAll()
    {
        
        List<T> result = em.createNamedQuery(type.getSimpleName()+".findAll").getResultList();
        return result;
    }
    
    
    //@Override
    public T update(T t) {
        this.em.merge(t);
        return t;
    }

    //@Override
    public T findById(int id) {
        List<T> result = em.createNamedQuery(type.getSimpleName()+".findById").setParameter("id", id).getResultList();
        if (result.size() == 0){
            return null;
        }
        else{
        return result.iterator().next();
        }
    }
    
    public List<T> findByName(String name) {
        //List<T> result = em.createNamedQuery(type.getSimpleName()+".findbyname").setParameter("id", name).getResultList();
        List<T> result = em.createNamedQuery(type.getSimpleName()+".findbyname").getResultList();
        if (result.size() == 0){
            return null;
        }
        else{
        return result;
        }
    }
    
}
