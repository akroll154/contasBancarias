package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import entidade.Conta;

public class SvModoAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("acao");

		if ("criarBanco".equals(nome)) {

			Conta c = new Conta();

			if (c.criarBDeTabelas()) {
				request.getRequestDispatcher("sucesso.html").forward(request, response);
			} else {
				request.getRequestDispatcher("erro.html").forward(request, response);
			}

		} else if ("deletarBanco".equals(nome)) {

			Conta c = new Conta();

			if (c.deletarBD()) {
				request.getRequestDispatcher("sucesso.html").forward(request, response);
			} else {
				request.getRequestDispatcher("erro.html").forward(request, response);
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
