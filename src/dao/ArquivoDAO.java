package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		
		PreparedStatement stat = conn.prepareStatement(
				"INSERT INTO " +
			    "public.arquivo " +
			    " (nome, path) " +
				"VALUES " +
			    " (?, ?) ");
		
		stat.setString(1, arquivo.getNome());
		stat.setString(2, arquivo.getPath());
		
		stat.execute();
		
	}

	@Override
	public void update(Arquivo arquivo) throws SQLException {
		
		Connection conn = getConnection();
		
		PreparedStatement stat = conn.prepareStatement(
				"UPDATE public.arquivo SET " +
			    " nome = ?, " +
			    " path = ? " +
				"WHERE " +
			    " id = ? ");
		
		stat.setString(1, arquivo.getNome());
		stat.setString(2, arquivo.getPath());
		stat.setInt(3, arquivo.getId());

		stat.execute();
		
	}

	@Override
	public void delete(int id) throws SQLException {

		Connection conn = getConnection();

		PreparedStatement stat = conn.prepareStatement(
				"DELETE FROM public.arquivo WHERE id = ?");
		
		stat.setInt(1, id);
		
		stat.execute();
	}

	@Override
	public List<Arquivo> findAll() {
		
		Connection conn = getConnection();
		
		if (conn == null) 
			return null;
		
		try {
			PreparedStatement stat = conn.prepareStatement(
					"SELECT " +
					"  id, " +
					"  nome, " +
					"  path " +
					"FROM " +
					"  public.arquivo ");
			
			ResultSet rs = stat.executeQuery();

			List<Arquivo> listaArquivo = new ArrayList<Arquivo>();
			
			while (rs.next()) {
				
				Arquivo arquivo = new Arquivo();
				arquivo.setId(rs.getInt("id"));
				arquivo.setNome(rs.getString("nome"));
				arquivo.setPath(rs.getString("path"));

				listaArquivo.add(arquivo);
			}
			
			if (listaArquivo.isEmpty())
				return null;
			
			return listaArquivo;
		
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Arquivo findArquivoById(Integer id) {
		
		Connection conn = getConnection();
		
		if (conn == null) 
			return null;

		try {
			PreparedStatement stat = conn.prepareStatement(
					"SELECT " +
					"  id, " +
					"  nome, " +
					"  path " +
					"FROM " +
					"  public.arquivo " +
					"WHERE id = ? ");

			stat.setInt(1, id);

			ResultSet rs = stat.executeQuery();

			Arquivo arquivo = null;

			if(rs.next()) {
				
				arquivo = new Arquivo();
				arquivo.setId(rs.getInt("id"));
				arquivo.setNome(rs.getString("nome"));
				arquivo.setPath(rs.getString("path"));
			}

			return arquivo;

		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
