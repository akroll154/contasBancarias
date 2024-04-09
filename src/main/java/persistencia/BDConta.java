package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BDConta {

	public Connection abrirConn() {

		try {
			Class.forName("org.mariadb.jdbc.Driver"); // registrando do driver no projeto
			String url = "jdbc:mariadb://localhost:3306/";
			String user = "root";
			String password = "";

			//

			Connection conn = DriverManager.getConnection(url, user, password);

			return conn;

		} catch (SQLException e) {
			System.err.println("Erro ao acessar o banco de dados.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Connection abrirConn(String bd) {

		try {
			Class.forName("org.mariadb.jdbc.Driver"); // registrando do driver no projeto
			String url = "jdbc:mariadb://localhost:3306/" + bd;
			String user = "root";
			String password = "";

			//

			Connection conn = DriverManager.getConnection(url, user, password);

			return conn;

		} catch (SQLException e) {
			System.err.println("Erro ao acessar o banco de dados.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean criarBDeTabelas() {

		try {

			//

			Connection conn = this.abrirConn();

			if (conn == null) {
				return false;
			} else {
				String sql = "create database if not exists bdaula08_contasbancarias";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.execute();

				//

				conn = abrirConn("bdaula08_contasbancarias");

				sql = "create table if not exists contas_corrente (id bigint primary key auto_increment, agencia varchar(50) not null, nrConta varchar(100) not null unique, titular varchar(100) not null, saldo double not null, limite double not null CHECK (limite >= 0))";
				ps = conn.prepareStatement(sql);
				ps.execute();

				sql = "create table if not exists contas_poupanca (id bigint primary key auto_increment, agencia varchar(50) not null, nrConta varchar(100) not null unique, titular varchar(100) not null, saldo double not null, rendimento double not null CHECK (rendimento >= 0))";
				ps = conn.prepareStatement(sql);
				ps.execute();

				conn.close();

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean deletarBD() {

		try {

			//

			Connection conn = this.abrirConn();

			//

			if (conn == null) {
				return false;
			} else {
				String sql = "drop database if exists bdaula08_contasbancarias";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.execute();
				conn.close();

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

}
