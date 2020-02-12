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
 * A data access object (DAO) providing persistence and search support for
 * Welfare entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.po.Welfare
 * @author MyEclipse Persistence Tools
 */
public class WelfareDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(WelfareDAO.class);
	// property constants
	public static final String WNAME = "wname";

	protected void initDao() {
		// do nothing
	}

	public void save(Welfare transientInstance) {
		log.debug("saving Welfare instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Welfare persistentInstance) {
		log.debug("deleting Welfare instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Welfare findById(java.lang.Integer id) {
		log.debug("getting Welfare instance with id: " + id);
		try {
			Welfare instance = (Welfare) getHibernateTemplate().get(
					"com.po.Welfare", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Welfare instance) {
		log.debug("finding Welfare instance by example");
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
		log.debug("finding Welfare instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Welfare as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByWname(Object wname) {
		return findByProperty(WNAME, wname);
	}

	public List findAll() {
		log.debug("finding all Welfare instances");
		try {
			String queryString = "from Welfare";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Welfare merge(Welfare detachedInstance) {
		log.debug("merging Welfare instance");
		try {
			Welfare result = (Welfare) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Welfare instance) {
		log.debug("attaching dirty Welfare instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Welfare instance) {
		log.debug("attaching clean Welfare instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static WelfareDAO getFromApplicationContext(ApplicationContext ctx) {
		return (WelfareDAO) ctx.getBean("WelfareDAO");
	}
}