package ch09;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentControl")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDAO dao;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		dao = new StudentDAO();
	}

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//request : 뷰에서 넘어온 데이터와 정보가 들어있습니다.
		String action = request.getParameter("action");
		String view = "";
	
		view = insert(request, response); //request와 response 객체를 매개변수로 넘겨준다.
		//getServletContext() : 웹어플리케이션(웹프로젝트)하나당 하나의 ServletContext가 생성이 됩니다(톰캣에서 자동으로), 웹 어플리케이션의 자원을 관리하며 웹어플리케이션이 종료될 때 같이 소멸합니다.
			// ㄴ ServletContext를 얻어옵니다.
		//getRequestDispatcher(이동할 페이지) : 이동할 페이지의 경로를 지정하는 역할을 합니다.
		//forward: 페이지를 이동시키지만, 내부에서 이동이 되기 때문에 주소가 변하지 않습니다.
		getServletContext().getRequestDispatcher("/ch09/" + view).forward(request, response);
	}
	
	
	//역할: request 데이터를 받아옴 -> DAO에 있는 insert()를 실행. -> DB에 insert가 된다. ==> 최종 return "페이지명 studentInfo.jsp";
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		Student s = new Student();
		try {
			BeanUtils.populate(s, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		dao.insert(s); //컨트롤러는 DAO한테 있는 메소드를 사용한다.
		return "studentInfo.jsp";
/*
		s.setUsername(request.getParameter("username"));
		s.setUniv(request.getParameter("univ"));
		s.setBirth(request.getParameter("birth"));
		s.setEmail(request.getParameter("email"));
		
		이 긴 과정을 대신 해줄 아이가 있음.    ====> jar파일 中 beanutils.jar
*/	
		//BeanUtils.populate(객체의 이름, 파라미터들);
		
	}
		
	

}
