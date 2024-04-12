package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import entidade.Corrente;

public class SvCadastrarCC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String agencia = request.getParameter("agencia");
		String nrConta = request.getParameter("nrConta");
		String titular = request.getParameter("titular");
		double saldo = Double.parseDouble(request.getParameter("saldo"));
		double limite = Double.parseDouble(request.getParameter("limite"));

		Corrente c = new Corrente(agencia, nrConta, titular, saldo, limite);

		if (c.salvar()) {
			request.setAttribute("msg", "Conta cadastrada com sucesso.");
		} else {
			request.setAttribute("msg", c.getMsg());
		}

		request.getRequestDispatcher("cadastrarCC.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
