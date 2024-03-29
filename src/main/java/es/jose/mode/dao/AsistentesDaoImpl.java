package es.jose.mode.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import es.jose.exception.MiException;
import es.jose.mode.dao.vo.AsistenteVO;

/**
 * @author raszagar
 */
@Repository
@Transactional
public class AsistentesDaoImpl implements AsistentesDaoCustom {

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<AsistenteVO> getAsistente(Integer id) throws MiException {
		try {
			Query query = em.createQuery("select a from AsistenteVO a WHERE a.id  = :id");
			query.setParameter("id", id);
			
			return query.getResultList();
		} catch (Exception e) {
			throw new MiException("Error al obtener asistente", e);
		}
	}

}
