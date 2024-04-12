package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidade.Corrente;

public class BDCorrente extends BDConta {

	public boolean salvar(Corrente cc) {

		try {

			Connection conn = abrirConn("bdaula08_contasbancarias");

			//

			if (conn != null) {

				String sql = "insert into contas_corrente (agencia, nrConta, titular, saldo, limite) values (?,?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, cc.getAgencia());
				ps.setString(2, cc.getNrConta());
				ps.setString(3, cc.getTitular());
				ps.setDouble(4, cc.getSaldo());
				ps.setDouble(5, cc.getLimite());

				int aux = ps.executeUpdate();
				conn.close();

				cc.setMsg("Foram cadastradas " + aux + " contas corrente.");
				return true;

			} else {

				cc.setMsg("Erro ao cadastrar.");
				return false;

			}

		} catch (Exception e) {
			cc.setMsg("Erro de exceção ao salvar no BD: " + e.getMessage());
			// e.printStackTrace();
		}

		return false;
	}

	public ArrayList<Corrente> localizar(String titular) {

		try {

			//

			Connection conn = abrirConn("bdaula08_contasbancarias");

			//

			if (conn == null) {
				return null;
			} else {
				ArrayList<Corrente> listaCC = new ArrayList<Corrente>();

				String sql = "SELECT id, agencia, nrConta, titular, saldo, limite FROM contas_corrente WHERE titular = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, titular);

				ResultSet resultado = ps.executeQuery();

				//

				while (resultado.next()) {

					long id = resultado.getLong(1);
					String agencia = resultado.getString(2);
					String nrConta = resultado.getString(3);
					String titular2 = resultado.getString(4);
					double saldo = resultado.getDouble(5);
					double limite = resultado.getDouble(6);

					Corrente cc = new Corrente(id, agencia, nrConta, titular2, saldo, limite);

					listaCC.add(cc);

				}

				return listaCC;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int localizar2(String nrConta) {

		int count = 0;

		try {

			//

			Connection conn = abrirConn("bdaula08_contasbancarias");

			//

			if (conn == null) {
				return -1;
			} else {
				String sql = "SELECT COUNT(*) from contas_corrente WHERE nrConta = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, nrConta);

				ResultSet resultado = ps.executeQuery();

				//

				if (resultado.next()) {
					count = resultado.getInt(1);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;

	}

	public int localizar3(String titular) {

		int count = 0;

		try {

			//

			Connection conn = abrirConn("bdaula08_contasbancarias");

			//

			if (conn == null) {
				return -1;
			} else {

				String sql = "SELECT COUNT(*) from contas_corrente WHERE titular = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, titular);

				ResultSet resultado = ps.executeQuery();

				//

				if (resultado.next()) {
					count = resultado.getInt(1);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;

	}

	public boolean editarAgencia(String agencia, String nrConta) {

		try {

			//

			Connection conn = abrirConn("bdaula08_contasbancarias");

			//

			if (conn == null) {
				return false;
			} else {
				String sql = "update contas_corrente set agencia = ? where nrConta = ? ";
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, agencia);
				ps.setString(2, nrConta);

				//

				ps.executeUpdate();
				conn.close();

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public boolean editarNrConta(String nvNrConta, String nrConta) {

		try {

			//

			Connection conn = abrirConn("bdaula08_contasbancarias");

			//

			if (conn == null) {
				return false;
			} else {

				String sql = "update contas_corrente set nrConta = ? where nrConta = ? ";
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, nvNrConta);
				ps.setString(2, nrConta);

				//

				ps.executeUpdate();
				conn.close();

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public boolean editarTitular(String titular, String nrConta) {

		try {

			//

			Connection conn = abrirConn("bdaula08_contasbancarias");

			//

			if (conn == null) {
				return false;
			} else {

				String sql = "update contas_corrente set titular = ? where nrConta = ? ";
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, titular);
				ps.setString(2, nrConta);

				//

				ps.executeUpdate();
				conn.close();

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public boolean editarSaldo(double saldo, String nrConta) {

		try {

			//

			Connection conn = abrirConn("bdaula08_contasbancarias");

			//

			if (conn == null) {
				return false;
			} else {

				String sql = "update contas_corrente set saldo = ? where nrConta = ? ";
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setDouble(1, saldo);
				ps.setString(2, nrConta);

				//

				ps.executeUpdate();
				conn.close();

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public boolean editarLimite(double limite, String nrConta) {

		try {

			//

			Connection conn = abrirConn("bdaula08_contasbancarias");

			//

			if (conn == null) {
				return false;
			} else {

				String sql = "update contas_corrente set limite = ? where nrConta = ? ";
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setDouble(1, limite);
				ps.setString(2, nrConta);

				//

				ps.executeUpdate();
				conn.close();

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public boolean excluir(String nrConta) {

		try {

			//

			Connection conn = abrirConn("bdaula08_contasbancarias");

			//

			if (conn == null) {
				return false;
			} else {

				String sql = "delete from contas_corrente where nrConta = ? ";
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, nrConta);

				//

				ps.executeUpdate();
				conn.close();

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public ArrayList<Corrente> listarContas() {

		try {

			//

			Connection conn = abrirConn("bdaula08_contasbancarias");

			//

			if (conn == null) {
				return null;
			} else {

				ArrayList<Corrente> listaCC = new ArrayList<Corrente>();

				String sql = "SELECT id, agencia, nrConta, titular, saldo, limite FROM contas_corrente ORDER BY id";
				PreparedStatement ps = conn.prepareStatement(sql);

				ResultSet resultado = ps.executeQuery();

				//

				while (resultado.next()) {

					long id = resultado.getLong(1);
					String agencia = resultado.getString(2);
					String nrConta = resultado.getString(3);
					String titular = resultado.getString(4);
					double saldo = resultado.getDouble(5);
					double limite = resultado.getDouble(6);

					Corrente cc = new Corrente(id, agencia, nrConta, titular, saldo, limite);

					listaCC.add(cc);

				}

				return listaCC;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public double saldo(String nrConta) {

		double saldo = 0;

		try {

			//

			Connection conn = abrirConn("bdaula08_contasbancarias");

			//

			if (conn == null) {
				return -1;
			} else {

				String sql = "SELECT saldo from contas_corrente WHERE nrConta = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, nrConta);

				ResultSet resultado = ps.executeQuery();

				//

				while (resultado.next()) {
					saldo = resultado.getDouble(1);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return saldo;

	}
}
