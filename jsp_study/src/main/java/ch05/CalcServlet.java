package ch05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getParameter("name");
		int n1 = Integer.parseInt(request.getParameter("n1")); 
		int n2 = Integer.parseInt(request.getParameter("n2"));
		System.out.println("입력받은 n1의 값: " + n1);
		System.out.println("입력받은 n2의 값: " + n2);
		
		String op = request.getParameter("option"); //연산자는 문자열로 받아도 상관이 없다.
		System.out.println("입력받은 연산자 option의 값: " + op);
//request에는 클라이언트가 요청한(보낸) 내용들이 담겨있음.  
//request에는 클라이언트가 submit을 한 내용들이 담겨있음.
//request.getParameter로 가져온 n1은 String값이므로, 연산을 위해서 Int값으로 바꿔야한다. 따라서 Integer.parseInt(   )로 감싸주면 된다.
//그리고 int로 변한 값을 변수로 받아준다.
		
		
		long result = 0; //연산의 결과를 담을 변수.
		
		switch (op) {
		case "+": result = n1 + n2; break;
		case "-": result = n1 - n2; break;
		case "*": result = n1 * n2; break;
		case "/": result = n1 / n2; break;
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append("<!doctype html><html><head><title>Hello World Servlet</title></head><body>")
		.append("계산결과는: "+ result + " 입니다" + "</body></html>");
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	} 
		//post방식으로 보냈으니 doPost가 실행되지만, doPost는 doGet을 실행하므로 doGet 쪽을 수정해주면 값이 원하는대로 출력.
}
