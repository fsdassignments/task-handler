package com.sbu.taskhandler.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.sbu.taskhandler.model.Task;

public class CustomTaskRepositoryImpl implements CustomTaskRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Task> findTasks(String taskName, String parentTaskName, Integer priorityFrom, Integer priorityTo,
			Date startDate, Date endDate) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Task> cq = cb.createQuery(Task.class);
	 
	    Root<Task> task = cq.from(Task.class);
	    List<Predicate> predicates = new ArrayList<>();
	     
	    if (null != taskName) {
	        predicates.add(cb.like(task.get("task"), "%" + taskName + "%"));
	    }
	    if (null != parentTaskName) {
	        predicates.add(cb.like(task.get("parentTask").get("parentTask"), "%" + parentTaskName + "%"));
	    }
	    if (null != priorityFrom) {
	    	if (null != priorityTo) {
	    		predicates.add(cb.between(task.get("priority"), priorityFrom, priorityTo));
	    	}
	    	predicates.add(cb.between(task.get("priority"), priorityFrom, 30));
	    }
	    if (null != priorityTo) {
	    	predicates.add(cb.between(task.get("priority"), 0, priorityTo));
	    }
	    if (null != startDate) {
	    	predicates.add(cb.greaterThanOrEqualTo(task.get("startDate"), startDate));
	    } 
	    if (null != endDate) {
	    	predicates.add(cb.lessThanOrEqualTo(task.get("endDate"), endDate));
	    }
	    cq.where(predicates.toArray(new Predicate[0]));
	 
	    return em.createQuery(cq).getResultList();
	}

}
