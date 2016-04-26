package com.genscript.gsscm.rule.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class BaseDao<T, PK extends Serializable> {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    private Class<T> entityClass;

    @Autowired
    protected SessionFactory sessionFactory;

    public BaseDao() {
        this.entityClass = null;
        Class<?> c = getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            this.entityClass = (Class<T>) parameterizedType[0];
        }
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Save new or modified objects.
     */
    public void save(final T entity) {
        Assert.notNull(entity, "entity can not be empty");
        getSession().saveOrUpdate(entity);
        logger.debug("save entity: {}", entity);
    }

    /**
     * Delete Object.
     */
    public void delete(final T entity) {
        Assert.notNull(entity, "entity can not be empty");
        getSession().delete(entity);
        logger.debug("delete entity: {}", entity);
    }

    /**
     * Delete an object by id.
     */
    public void delete(final PK id) {
        Assert.notNull(id, "id can not be empty");
        delete(get(id));
        logger.debug("delete entity {},id is {}", entityClass.getSimpleName(), id);
    }

    /**
     * Get object by id.
     */
    public T get(final PK id) {
        Assert.notNull(id, "id can not be empty");
        return (T) getSession().load(entityClass, id);
    }

    /**
     * Get object by id.
     */
    public T getById(final PK id) {
        Assert.notNull(id, "id can not be empty");
        return (T) getSession().get(entityClass, id);
    }

    /**
     * Get all the objects.
     */
    public List<T> getAll() {
        return find();
    }

    /**
     * Find the list of objects according to attributes.
     */
    public List<T> findBy(final String propertyName, final Object value) {
        Assert.hasText(propertyName, "propertyName can not be empty");
        Criterion criterion = Restrictions.eq(propertyName, value);
        return find(criterion);
    }

    /**
     * Find by property the sole object of.
     */
    public T findUniqueBy(final String propertyName, final Object value) {
        Assert.hasText(propertyName, "propertyName can not be empty");
        Criterion criterion = Restrictions.eq(propertyName, value);
        return (T) createCriteria(criterion).uniqueResult();
    }

    /**
     * Find the object by list of id.
     */
    public List<T> findByIds(List<PK> ids) {
        return find(Restrictions.in(getIdName(), ids));
    }

    /**
     * HQL query object according to a list.
     * 
     * @param values Variable number of parameters, according to the order of
     *            binding.
     */
    public <X> List<X> find(final String hql, final Object... values) {
        return createQuery(hql, values).list();
    }

    /**
     * HQL query object according to a list.
     * 
     * @param values Named parameters, by name binding.
     */
    public <X> List<X> find(final String hql, final Map<String, Object> values) {
        return createQuery(hql, values).list();
    }

    /**
     * According to the sole object of HQL queries.
     * 
     * @param values Variable number of parameters, according to the order of
     *            binding.
     */
    public <X> X findUnique(final String hql, final Object... values) {
        return (X) createQuery(hql, values).uniqueResult();
    }

    /**
     * According to the sole object of HQL queries.
     * 
     * @param values Named parameters, by name binding.
     */
    public <X> X findUnique(final String hql, final Map<String, Object> values) {
        return (X) createQuery(hql, values).uniqueResult();
    }

    /**
     * The implementation of HQL bulk modify / delete operation.
     */
    public int batchExecute(final String hql, final Object... values) {
        return createQuery(hql, values).executeUpdate();
    }

    /**
     * The implementation of HQL bulk modify / delete operation.
     * 
     * @return Update Records.
     */
    public int batchExecute(final String hql, final Map<String, Object> values) {
        return createQuery(hql, values).executeUpdate();
    }

    /**
     * HQL and the parameter list based on the query create a Query object.
     */
    public Query createQuery(final String queryString, final Object... values) {
        Assert.hasText(queryString, "queryString can not be empty");
        Query query = getSession().createQuery(queryString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return query;
    }

    /**
     * HQL and the parameter list based on the query create a Query object.
     * 
     * @param values Named parameters, by name binding.
     */
    public Query createQuery(final String queryString, final Map<String, Object> values) {
        Assert.hasText(queryString, "queryString can not be empty");
        Query query = getSession().createQuery(queryString);
        if (values != null) {
            query.setProperties(values);
        }
        return query;
    }

    /**
     * Criteria query object according to a list.
     * 
     * @param criterions Variable number of Criterion.
     */
    public List<T> find(final Criterion... criterions) {
        return createCriteria(criterions).list();
    }

    /**
     * The only objects by Criteria Search.
     * 
     * @param criterions Variable number of Criterion.
     */
    public T findUnique(final Criterion... criterions) {
        return (T) createCriteria(criterions).uniqueResult();
    }

    /**
     * Criteria to create the conditions under Criterion.
     * 
     * @param criterions Variable number of Criterion.
     */
    public Criteria createCriteria(final Criterion... criterions) {
        Criteria criteria = getSession().createCriteria(entityClass);
        for (Criterion c : criterions) {
            criteria.add(c);
        }
        return criteria;
    }

    /**
     * To obtain the object's primary key name of.
     */
    public String getIdName() {
        ClassMetadata meta = sessionFactory.getClassMetadata(entityClass);
        return meta.getIdentifierPropertyName();
    }

}
