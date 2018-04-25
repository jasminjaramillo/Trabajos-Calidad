

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		
		List<User> usuarios = new ArrayList();
		boolean encontrado = false;
		
		for(int i=1; i<=9;i++) {
			User usuario = new User();
			usuario.setUserName(Integer.toString(i));
			usuario.setUserPwd(Integer.toString(i));
			usuarios.add(usuario);
		}
		
		for(int i=0; i<usuarios.size(); i++) {
			User usuario1 = usuarios.get(i);
			
			if(userName.equals(usuario1.getUserName()) && userPwd.equals(usuario1.getUserPwd())) {
				encontrado = true;
				response.sendRedirect("home.jsp");
			}
		}

		if(!encontrado) {
			response.sendRedirect("loginError.jsp");
		}
	}

}
