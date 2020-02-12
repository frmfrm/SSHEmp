package com.dao;
import com.po.*;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



/**
 * A data access object (DAO) providing persistence and search support for Dep
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.po.Dep
 * @author MyEclipse Persistence Tools
 */
public class DepDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(DepDAO.class);
	// property constants
	public static final String DEPNAME = "depname";

	protected void initDao() {
		// do nothing
	}

	public void save(Dep transientInstance) {
		log.debug("saving Dep instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Dep persistentInstance) {
		log.debug("deleting Dep instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Dep findById(java.lang.Integer id) {
		log.debug("getting Dep instance with id: " + id);
		try {
			Dep instance = (Dep) getHibernateTemplate().get("com.po.Dep", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Dep instance) {
		log.debug("finding Dep instance by example");
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
		log.debug("finding Dep instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Dep as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDepname(Object depname) {
		return findByProperty(DEPNAME, depname);
	}

	public List findAll() {
		log.debug("finding all Dep instances");
		try {
			String queryString = "from Dep";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Dep merge(Dep detachedInstance) {
		log.debug("merging Dep instance");
		try {
			Dep result = (Dep) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Dep instance) {
		log.debug("attaching dirty Dep instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Dep instance) {
		log.debug("attaching clean Dep instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DepDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DepDAO) ctx.getBean("DepDAO");
	}
}