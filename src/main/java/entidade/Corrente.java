package entidade;

import java.util.ArrayList;

import persistencia.BDCorrente;

public class Corrente extends Conta {

	protected double limite;

	public Corrente() {
		super();
	}

	public Corrente(double limite) {
		super();
		this.limite = limite;
	}

	public Corrente(String agencia, String nrConta, String titular, double saldo, double limite) {
		super(agencia, nrConta, titular, saldo);
		this.limite = limite;
	}

	public Corrente(long id, String agencia, String nrConta, String titular, double saldo, double limite) {
		super(id, agencia, nrConta, titular, saldo);
		this.limite = limite;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	//

	public boolean salvar() {

		try {

			BDCorrente bdc = new BDCorrente();

			if (agencia.isEmpty()) {
				return false;
			} else if (nrConta.isEmpty()) {
				return false;
			} else if (titular.isEmpty()) {
				return false;
			} else if (saldo < 0) {
				return false;
			} else if (limite < 0) {
				return false;
			} else {

				if (bdc.salvar(this)) {
					return true;
				} else {
					return false;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public ArrayList<Corrente> localizar(String titular) {

		BDCorrente bdc = new BDCorrente();
		return bdc.localizar(titular);

	}

	public boolean localizar2(String nrConta) {

		try {

			BDCorrente bdc = new BDCorrente();

			if (bdc.localizar2(nrConta) == 0) {
				return false;
			} else {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public int localizar3(String titular2) {

		try {

			BDCorrente bdc = new BDCorrente();

			if (titular2.isEmpty()) {
				return 0;
			} else {
				return bdc.localizar3(titular2);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public boolean editarAgencia(String agencia, String nrConta) {

		try {

			BDCorrente bdc = new BDCorrente();

			if (agencia.isEmpty() || nrConta.isEmpty()) {
				return false;
			} else {

				if (bdc.editarAgencia(agencia, nrConta)) {
					return true;
				} else {
					return false;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean editarNrConta(String nvNrConta, String nrConta) {

		try {

			BDCorrente bdc = new BDCorrente();

			if (nvNrConta.isEmpty() || nrConta.isEmpty()) {
				return false;
			} else {

				if (bdc.editarNrConta(nvNrConta, nrConta)) {
					return true;
				} else {
					return false;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean editarTitular(String titular, String nrConta) {

		try {

			BDCorrente bdc = new BDCorrente();

			if (titular.isEmpty() || nrConta.isEmpty()) {
				return false;
			} else {

				if (bdc.editarTitular(titular, nrConta)) {
					return true;
				} else {
					return false;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean editarSaldo(double saldo, String nrConta) {

		try {

			BDCorrente bdc = new BDCorrente();

			if (nrConta.isEmpty()) {
				return false;
			} else {

				if (bdc.editarSaldo(saldo, nrConta)) {
					return true;
				} else {
					return false;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean editarLimite(double limite, String nrConta) {

		try {

			BDCorrente bdc = new BDCorrente();

			if (nrConta.isEmpty()) {
				return false;
			} else {

				if (bdc.editarLimite(limite, nrConta)) {
					return true;
				} else {
					return false;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean excluir(String nrConta) {

		try {

			BDCorrente bdc = new BDCorrente();

			if (nrConta.isEmpty()) {
				return false;
			} else {

				if (bdc.excluir(nrConta)) {
					return true;
				} else {
					return false;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public ArrayList<Corrente> listarContas() {

		BDCorrente bdc = new BDCorrente();
		return bdc.listarContas();

	}

	public boolean depositar(String nrConta, double valor) {

		try {

			BDCorrente bdc = new BDCorrente();

			if (nrConta.isEmpty()) {
				return false;
			} else if (valor < 0) {
				return false;
			} else {

				double saldo = bdc.saldo(nrConta);

				double novoSaldo = (saldo + valor);

				if (bdc.editarSaldo(novoSaldo, nrConta)) {
					return true;
				} else {
					return false;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	public boolean sacar(String nrConta, double valor) {

		try {

			BDCorrente bdc = new BDCorrente();

			if (nrConta.isEmpty()) {
				return false;
			} else if (valor < 0) {
				return false;
			} else {

				double saldo = bdc.saldo(nrConta);

				double novoSaldo = (saldo - valor);

				if (valor > saldo) {
					return false;
				} else {
					bdc.editarSaldo(novoSaldo, nrConta);
				}

			}
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}
}
