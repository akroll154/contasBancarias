package entidade;

import java.util.ArrayList;

import persistencia.BDPoupanca;

public class Poupanca extends Conta {

	protected double rendimento;

	//

	public Poupanca() {
		super();
	}

	public Poupanca(double rendimento) {
		super();
		this.rendimento = rendimento;
	}

	public Poupanca(String agencia, String nrConta, String titular, double saldo, double rendimento) {
		super(agencia, nrConta, titular, saldo);
		this.rendimento = rendimento;
	}

	public Poupanca(long id, String agencia, String nrConta, String titular, double saldo, double rendimento) {
		super(id, agencia, nrConta, titular, saldo);
		this.rendimento = rendimento;
	}

	//

	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}

	//

	public boolean salvar() {

		try {

			BDPoupanca bdc = new BDPoupanca();

			if (agencia.isEmpty()) {
				msg = "Agência em branco.";
				return false;
			} else if (nrConta.isEmpty()) {
				msg = "Número da conta em branco.";
				return false;
			} else if (titular.isEmpty()) {
				msg = "Titular em branco.";
				return false;
			} else if (saldo < 0) {
				msg = "Saldo negativo.";
				return false;
			} else if (rendimento < 0) {
				msg = "Rendimento negativo.";
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

	public ArrayList<Poupanca> localizar(String titular) {

		BDPoupanca bdc = new BDPoupanca();
		return bdc.localizar(titular);

	}

	public boolean localizar2(String nrConta) {

		try {

			BDPoupanca bdc = new BDPoupanca();

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

			BDPoupanca bdc = new BDPoupanca();

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

			BDPoupanca bdc = new BDPoupanca();

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

			BDPoupanca bdc = new BDPoupanca();

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

			BDPoupanca bdc = new BDPoupanca();

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

			BDPoupanca bdc = new BDPoupanca();

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

	public boolean editarRendimento(double rendimento, String nrConta) {

		try {

			BDPoupanca bdc = new BDPoupanca();

			if (nrConta.isEmpty()) {
				return false;
			} else {

				if (bdc.editarRendimento(rendimento, nrConta)) {
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

			BDPoupanca bdc = new BDPoupanca();

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

	public ArrayList<Poupanca> listarContas() {

		BDPoupanca bdc = new BDPoupanca();
		return bdc.listarContas();

	}

	public boolean depositar(String nrConta, double valor) {

		try {

			BDPoupanca bdc = new BDPoupanca();

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

			BDPoupanca bdc = new BDPoupanca();

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
