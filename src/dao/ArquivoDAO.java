package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.*;

public class ArquivoDAO extends DAO<Arquivo>{

	public ArquivoDAO(Connection conn) {
		super(conn);
	}
	
	public ArquivoDAO() {
		
		// Cria uma nova conexao
		super(null);
	}

	@Override
	public void create(Arquivo arquivo) throws SQLException {
		
		Connection conn = getConnection();
		
//		PreparedStatement stat = conn.prepareStatement(
//				"INSERT INTO " +
//			    "public.arquivo " +
//			    " (nome, numero_serie, localfisico_nf, descr_aquisicao, prazo_garantia, status, descr_bem, localfisico_bem) " +
//				"VALUES " +
//			    " (?, ?, ?, ?, ?, ?, ?, ?) ");
		
	}

	@Override
	public void update(Arquivo arquivo) throws SQLException {
		
	}

	@Override
	public void delete(int id) throws SQLException {
		
	}

	@Override
	public List<Arquivo> findAll() {
		
		return null;
	}

}
