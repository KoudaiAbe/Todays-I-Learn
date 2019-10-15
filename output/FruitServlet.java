package ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FruitServlet
 */
@WebServlet("/FruitServlet")
public class FruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {

		//フルーツインスタンスを作成
		Fruit f = new Fruit("いちご",700);

		//アプリケーションスコープ
		ServletContext application = this.getServletContext();
		application.setAttribute("fruit", f);

		//フォワード
		RequestDispatcher dispathcher =
				request.getRequestDispatcher("/WEB-INF/ex/fruit.jsp");
		dispathcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
	}
}
