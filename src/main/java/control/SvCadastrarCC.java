package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import entidade.Corrente;

/**
 * Servlet implementation class SvCadastrarCC
 */
public class SvCadastrarCC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SvCadastrarCC() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String agencia = request.getParameter("agencia");
		String nrConta = request.getParameter("nrConta");
		String titular = request.getParameter("titular");
		double saldo = Double.parseDouble(request.getParameter("saldo"));
		double limite = Double.parseDouble(request.getParameter("limite"));

		Corrente c = new Corrente(agencia, nrConta, titular, saldo, limite);

		if (c.salvar()) {
			request.getRequestDispatcher("sucesso.html").forward(request, response);
		} else {
			request.getRequestDispatcher("erro.html").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
