package entidade;

import persistencia.BDConta;

public class Conta {

	protected long id;
	protected String agencia;
	protected String nrConta;
	protected String titular;
	protected double saldo;
	protected String msg;

	//

	public Conta() {
		super();
	}

	public Conta(String agencia, String nrConta, String titular, double saldo) {
		super();
		this.agencia = agencia;
		this.nrConta = nrConta;
		this.titular = titular;
		this.saldo = saldo;
	}

	public Conta(long id, String agencia, String nrConta, String titular, double saldo) {
		super();
		this.id = id;
		this.agencia = agencia;
		this.nrConta = nrConta;
		this.titular = titular;
		this.saldo = saldo;
	}

	//

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNrConta() {
		return nrConta;
	}

	public void setNrConta(String nrConta) {
		this.nrConta = nrConta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean criarBDeTabelas() {

		try {

			BDConta bdc = new BDConta();

			if (bdc.criarBDeTabelas()) {
				msg = "Operação bem sucedida.";
				return true;
			} else {
				msg = "Erro ao criar o banco de dados.";
				return false;
			}

		} catch (Exception e) {
			// e.printStackTrace();
			msg = "Algo deu errado. " + e.getMessage();
		}

		return false;
	}

	public boolean deletarBD() {

		try {

			BDConta bdc = new BDConta();

			if (bdc.deletarBD()) {
				msg = "Operação bem sucedida.";
				return true;
			} else {
				msg = "Erro ao deletar o banco de dados.";
				return false;
			}

		} catch (Exception e) {
			// e.printStackTrace();
			msg = "Algo deu errado. " + e.getMessage();
		}

		return false;
	}

}
