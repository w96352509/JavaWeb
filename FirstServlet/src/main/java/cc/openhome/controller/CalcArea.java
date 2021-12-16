package cc.openhome.controller;


import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.Service.CalcAreaService;

@WebServlet("/CalcArea") // url-pattern
public class CalcArea extends HttpServlet {
    
    // �p�� service
    private CalcAreaService service = new CalcAreaService();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. �����浧�Ѽ�(��@�W��)
        /*
        String string_type = req.getParameter("type");
        String string_r = req.getParameter("r");
        int type = Integer.parseInt(string_type);
        int r = Integer.parseInt(string_r);
        */
        
        // 1. �����h�հѼ�(�h���ƦW��)
        String[] types = req.getParameterValues("type");
        String[] rs    = req.getParameterValues("r");
        
        // 2. �ӷ~�޿�B��
        //double area = service.getAreaResult(type, r);
        //String typeName = service.getNameByType(type);
        List<Map> list = service.getAreaResults(types, rs);
        
        // 3. �إߤ������P jsp ��m
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/CalcArea.jsp");
        // 3.1 �s�W/�]�w request �ݩ�, �ǻ��� jsp �����ϥ�
        //req.setAttribute("r", r);
        //req.setAttribute("result", String.format("%.2f", area));
        //req.setAttribute("typeName", typeName);
        req.setAttribute("list", list);
        // 3.2 �ǰe
        rd.forward(req, resp);
        //resp.getWriter().print(String.format("r: %d area: %.2f", r, area));
    }
    
}
