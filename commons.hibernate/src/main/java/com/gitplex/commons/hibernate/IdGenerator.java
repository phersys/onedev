package com.gitplex.commons.hibernate;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import com.gitplex.commons.loader.AppLoader;

public class IdGenerator implements IdentifierGenerator, Configurable {

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		return AppLoader.getInstance(IdManager.class).nextId(object.getClass());
	}

	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
	}

}