package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import entidade.Poupanca;

public class SvCadastrarCP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SvCadastrarCP() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String agencia = request.getParameter("agencia");
		String nrConta = request.getParameter("nrConta");
		String titular = request.getParameter("titular");
		double saldo = Double.parseDouble(request.getParameter("saldo"));
		double rendimento = Double.parseDouble(request.getParameter("rendimento"));

		Poupanca p = new Poupanca(agencia, nrConta, titular, saldo, rendimento);

		if (p.salvar()) {
			request.getRequestDispatcher("sucesso.html").forward(request, response);
		} else {
			request.getRequestDispatcher("erro.html").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
