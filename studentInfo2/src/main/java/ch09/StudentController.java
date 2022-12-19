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
		//view에서 넘어오는 하늘 데이터 깨짐 방지 utf-8
		request.setCharacterEncoding("utf-8");
		//request : 뷰에서 넘어온 데이터와 정보가 들어있습니다.
		String action = request.getParameter("action"); //최초에는 null, 이후에는 list or insert
		String view = "";
	
		if (action == null ) {
			//리퀘스트를 또 한다.(맨 처음에 들어오면 이미 서비스 메소드를 1번 실행을한다. 이 과정에서 action이 null이므로 페이지를 이동시킨다. forward이기때문에 주소가 바뀌지는 않는다.
			//새로 요청을 받았으므로 service()를 또 실행하지만, 이번엔 action이 null이 아니므로 else로 다음으로 넘긴다.
			getServletContext().getRequestDispatcher("/StudentControl?action=list").forward(request, response);
		} else {
			switch(action) {
			case "list" : view = list(request, response); break;
			case "insert" : view = insert(request, response); break; //request와 response 객체를 매개변수로 넘겨준다.
			}
			getServletContext().getRequestDispatcher("/ch09/" + view).forward(request, response);
		}
		
		//view = insert(request, response); //request와 response 객체를 매개변수로 넘겨준다.
		//getServletContext() : 웹어플리케이션(웹프로젝트)하나당 하나의 ServletContext가 생성이 됩니다(톰캣에서 자동으로), 웹 어플리케이션의 자원을 관리하며 웹어플리케이션이 종료될 때 같이 소멸합니다.
			// ㄴ ServletContext를 얻어옵니다.
		//getRequestDispatcher(이동할 페이지) : 이동할 페이지의 경로를 지정하는 역할을 합니다.
		//forward: 페이지를 이동시키지만, 내부에서 이동이 되기 때문에 주소가 변하지 않습니다.
		//getServletContext().getRequestDispatcher("/ch09/" + view).forward(request, response);
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
		
	public String list(HttpServletRequest requset, HttpServletResponse response) { //list에서 하는 일 : 데이터를 전부 가져온다.
		requset.setAttribute("students_key", dao.getAll()); //setAttribute("String key", Object value)   
		//request, response 할 때 값을 넘겨줍니다.     sutdents_key에는 학생정보가 담겨있는 ArrayList가 담깁니다 (dao.getAll()로 ArrayList를 가져오기때문에.)
		return "studentInfo.jsp";
	}

}
