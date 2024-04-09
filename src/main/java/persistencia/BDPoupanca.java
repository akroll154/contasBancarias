package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidade.Poupanca;

public class BDPoupanca extends BDConta {

	public boolean salvar(Poupanca cp) {

		try {

			Connection conn = abrirConn("bdaula08_contasbancarias");

			//

			if (conn == null) {
				return false;
			} else {
				String sql = "insert into contas_poupanca (agencia, nrConta, titular, saldo, rendimento) values (?,?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, cp.getAgencia());
				ps.setString(2, cp.getNrConta());
				ps.setString(3, cp.getTitular());
				ps.setDouble(4, cp.getSaldo());
				ps.setDouble(5, cp.getRendimento());

				ps.execute();
				conn.close();

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public ArrayList<Poupanca> localizar(String titular) {

		try {

			//

			Connection conn = abrirConn("bdaula08_contasbancarias");

			//

			if (conn == null) {
				return null;
			} else {
				ArrayList<Poupanca> listaCP = new ArrayList<Poupanca>();

				String sql = "SELECT id, agencia, nrConta, titular, saldo, rendimento FROM contas_poupanca WHERE titular = ?";
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
					double rendimento = resultado.getDouble(6);

					Poupanca cp = new Poupanca(id, agencia, nrConta, titular2, saldo, rendimento);

					listaCP.add(cp);

				}

				return listaCP;
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
				String sql = "SELECT COUNT(*) from contas_poupanca WHERE nrConta = ?";
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

				String sql = "SELECT COUNT(*) from contas_poupanca WHERE titular = ?";
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
				String sql = "update contas_poupanca set agencia = ? where nrConta = ? ";
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
				String sql = "update contas_poupanca set nrConta = ? where nrConta = ? ";
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
				String sql = "update contas_poupanca set titular = ? where nrConta = ? ";
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
				String sql = "update contas_poupanca set saldo = ? where nrConta = ? ";
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

	public boolean editarRendimento(double rendimento, String nrConta) {

		try {

			//

			Connection conn = abrirConn("bdaula08_contasbancarias");

			//

			if (conn == null) {
				return false;
			} else {
				String sql = "update contas_poupanca set rendimento = ? where nrConta = ? ";
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setDouble(1, rendimento);
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
				String sql = "delete from contas_poupanca where nrConta = ? ";
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

	public ArrayList<Poupanca> listarContas() {

		try {

			//

			Connection conn = abrirConn("bdaula08_contasbancarias");

			//

			if (conn == null) {
				return null;
			} else {
				ArrayList<Poupanca> listaCP = new ArrayList<Poupanca>();

				String sql = "SELECT id, agencia, nrConta, titular, saldo, rendimento FROM contas_poupanca ORDER BY id";
				PreparedStatement ps = conn.prepareStatement(sql);

				ResultSet resultado = ps.executeQuery();

				//

				while (resultado.next()) {

					long id = resultado.getLong(1);
					String agencia = resultado.getString(2);
					String nrConta = resultado.getString(3);
					String titular = resultado.getString(4);
					double saldo = resultado.getDouble(5);
					double rendimento = resultado.getDouble(6);

					Poupanca cp = new Poupanca(id, agencia, nrConta, titular, saldo, rendimento);

					listaCP.add(cp);

				}

				return listaCP;
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
				String sql = "SELECT saldo from contas_poupanca WHERE nrConta = ?";
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
