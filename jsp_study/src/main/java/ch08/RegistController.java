package ch08;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistController
 */
@WebServlet("/RegistController")
public class RegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RegistService registSer;

    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		registSer = new RegistService();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"); //action 파라미터의 값을 얻어옴.
		String view = "";
		
		if(action == null) {						 
			getServletContext().getRequestDispatcher("/RegistController?action=list").forward(request, response);
		} else {
			switch (action) {
			case "list": view = list(request, response);
				break;
			case "info" : view = info(request, response);
				break;
			case "confirm" : view = grade(request, response);
				break;
			}
			
			getServletContext().getRequestDispatcher("/ch08/" + view).forward(request, response);
			
		}
		
	}
	//등록인원 전체의 정보
	private String list(HttpServletRequest request, HttpServletResponse response) {
		List<Regist> rList = registSer.findAll();
		request.setAttribute("regist", rList);
		return "registList.jsp";
	}
	//등록인원 1명의 정보
	private String info(HttpServletRequest request, HttpServletResponse response) {
		Regist regi = registSer.find(request.getParameter("id"));
		request.setAttribute("r", regi);
		return "registInfo.jsp";
	}
	//등급확인 정보
	private String grade(HttpServletRequest request, HttpServletResponse response) {
		List<Regist> rList = registSer.findAll();
		request.setAttribute("gg", rList);
		return "registGradeList.jsp";
	}
	

    public RegistController() {
        super();
        // TODO Auto-generated constructor stub
    }


}
