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
 * Servlet implementation class ProductController
 */
@WebServlet("/pcontrol")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProductService proService;
    
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		proService = new ProductService(); //서블릿이 초기화 될 때 ProductService 객체를 생성해줌.
	}
    
    
    //service(): 클라이언트에서 request가 오면 service()가 실행된다.
	@Override //서블릿에서 실행되는 service()메소드
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"); //action 파라미터의 값을 얻어옴.
		System.out.println(action +"***1");
		String view = "";
		
		if(action == null) {						 
			getServletContext().getRequestDispatcher("/pcontrol?action=list").forward(request, response);
			System.out.println(action +"-------2");
		} else {
			switch (action) {
			case "list": view = list(request, response);
				break;
			case "info" : view = info(request, response);
				break;
			}
			
			getServletContext().getRequestDispatcher("/ch08/" + view).forward(request, response);
		}
	}
	//info메소드에서는 상품한가지 정보를 가져올 것.
	private String info(HttpServletRequest request, HttpServletResponse response) {
		Product prod = proService.find(request.getParameter("id"));
		request.setAttribute("p", prod);
		return "productInfo.jsp"; //    /ch08/productInfo.jsp.forward
	}
	
	//list메소드는 모든 상품의 데이터를 가져올 것.
	private String list(HttpServletRequest request, HttpServletResponse response) {
		List<Product> plist = proService.findAll();
		request.setAttribute("products1", plist);
		return "productList.jsp";//		/ch08/productList.jsp
	}
	
}
