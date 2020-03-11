package application;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class Session {

	private static Session session;

	private Session() {
		
	}

	public static Session getInstance() {
		
		if (session == null)
			session = new Session();
		
		return session;
	}

	private ExternalContext getExternalContext() {
		
		if (FacesContext.getCurrentInstance() == null)
			throw new RuntimeException("O FaceContext e exclusivo para aplicacao WEB.");
		
		return FacesContext.getCurrentInstance().getExternalContext();
	}

	// Metodo para obter a informacao da Sessao
	public Object getAttribute(String key) {
		return getExternalContext().getSessionMap().get(key);
	}

	// Metodo para colocar uma informacao na Sessao
	public void setAttribute(String key, Object value) {
		getExternalContext().getSessionMap().put(key, value);
	}

	// Metodo para invalidar uma Sessao (Encerrar a Sessao)
	public void invalidateSession() {
		getExternalContext().invalidateSession();
	}

}