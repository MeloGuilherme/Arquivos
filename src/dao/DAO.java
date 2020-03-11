package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO<T> {

	// CRUD
	public abstract void create(T entity) throws SQLException;

	public abstract void update(T entity) throws SQLException;

	public abstract void delete(int id) throws SQLException; 

	public abstract List<T> findAll();

	private Connection conn = null;
	
	// Construtor da Classe, passando uma conexao
	public DAO(Connection conn) {
		this.conn = conn;
	}
	
	// Cria uma nova conexao
	public Connection getConnection() {
		
		if (isClosedConnection()) {
			
			try {
				
				// Registrando o driver do PostgreSQL
				Class.forName("org.postgresql.Driver");
				
				// Estabelecendo uma conexao com o Banco de Dados
				conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/arquivos", "setec", "setec123");
				
				// False -> Para trabalhar com Commit/Rollback
				conn.setAutoCommit(false);
				
				System.out.println("Conexao realizada com sucesso.");
			} 
			
			catch (SQLException e) {
				
				System.out.println("Falha ao conectar ao BD.");
				conn = null;
				e.printStackTrace();
				
			} 
			
			catch (ClassNotFoundException e) {
				
				System.out.println("Falha ao resgistrar o driver do BD");
				conn = null;
				e.printStackTrace();
			}
		}

		return conn;
	}
	
	// Verifica se a conexao esta fechada
	private boolean isClosedConnection() {
		
		try {
			if (conn == null || conn.isClosed())
				return true;
		} 
		catch (SQLException e) {
			return true;
		}
		
		return false;
	}
	
	// Para finalizar a conexao
	public void closeConnection() {
		
		try {
			getConnection().close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Realiza o Rollback na transacao quando necessario
	public void rollbackConnection() {
		
		try {
			getConnection().rollback();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}