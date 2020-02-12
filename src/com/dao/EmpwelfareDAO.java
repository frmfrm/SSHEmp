package com.dao;
import com.po.*;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Empwelfare entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.po.Empwelfare
 * @author MyEclipse Persistence Tools
 */
public class EmpwelfareDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(EmpwelfareDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	public void save(Empwelfare transientInstance) {
		log.debug("saving Empwelfare instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Empwelfare persistentInstance) {
		log.debug("deleting Empwelfare instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Empwelfare findById(java.lang.Integer id) {
		log.debug("getting Empwelfare instance with id: " + id);
		try {
			Empwelfare instance = (Empwelfare) getHibernateTemplate().get(
					"com.po.Empwelfare", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Empwelfare instance) {
		log.debug("finding Empwelfare instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Empwelfare instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Empwelfare as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Empwelfare instances");
		try {
			String queryString = "from Empwelfare";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Empwelfare merge(Empwelfare detachedInstance) {
		log.debug("merging Empwelfare instance");
		try {
			Empwelfare result = (Empwelfare) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Empwelfare instance) {
		log.debug("attaching dirty Empwelfare instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Empwelfare instance) {
		log.debug("attaching clean Empwelfare instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EmpwelfareDAO getFromApplicationContext(ApplicationContext ctx) {
		return (EmpwelfareDAO) ctx.getBean("EmpwelfareDAO");
	}
}