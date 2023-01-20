package es.jose.mode.dao;

import java.util.List;

import es.jose.exception.MiException;
import es.jose.mode.dao.vo.AsistenteVO;

public interface AsistentesDaoCustom {
	
	List<AsistenteVO> getAsistente(Integer id) throws MiException;

}
