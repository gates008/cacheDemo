package cache.com;
/**
* @author ����
* @version ����ʱ�䣺2019��1��14�� ����10:02:43
* ��˵��
*/
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.henu.util.CacheMgr;
/**
 * ���Զ�ȡ����ӻ������ݵ�
 * @author Administrator
 */
public class Cservlet extends HttpServlet{
    
    public void service(HttpServletRequest request,HttpServletResponse response){
        try {
            System.out.println("����servlet��............");
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");   //3.������Ӧ����

            PrintWriter out = response.getWriter();
            
            
            CacheMgr cm=CacheMgr.getInstance();
            
            int numm=cm.getSize();//��ȡ�������
            Object ob=cm.getValue("kk");
            System.out.println("numm===========//======"+numm);
            out.println("�������Ϊ��"+numm);
            out.println("������ֵ��value===="+ob);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }

}