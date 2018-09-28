package br.desafio.thiago.rest.controller;

import org.hibernate.Criteria;
import org.hibernate.Session;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.desafio.thiago.rest.util.HibernateUtil;

public class GenericoDao<Entidade> {

	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericoDao() {

		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];

	}

	public void inserir(Entidade entidade) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();

			session.save(entidade);

			transaction.commit();

		} catch (RuntimeException re) {

			if (transaction != null) {

				transaction.rollback();
			}

			throw re;

		}
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			Criteria consulta = session.createCriteria(classe);

			List<Entidade> listagem = consulta.list();

			return listagem;

		} catch (RuntimeException re) {

			throw re;

		}

	}
	
	@SuppressWarnings("unchecked")
	public Entidade buscar(Long id) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			Criteria consulta = session.createCriteria(classe);

			consulta.add(Restrictions.idEq(id));
			
			Entidade resultado = (Entidade) consulta.uniqueResult();

			return resultado;

		} catch (RuntimeException re) {

			throw re;

		}

	}
	
	public void editar(Entidade entidade) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();

			session.update(entidade);

			transaction.commit();

		} catch (RuntimeException re) {

			if (transaction != null) {

				transaction.rollback();
			}

			throw re;

		}
	}

}
