package cache.com;
/**
* @author 作者
* @version 创建时间：2019年1月14日 上午10:02:43
* 类说明
*/
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.henu.util.CacheMgr;
/**
 * 测试读取、添加缓存数据等
 * @author Administrator
 */
public class Cservlet extends HttpServlet{
    
    public void service(HttpServletRequest request,HttpServletResponse response){
        try {
            System.out.println("进入servlet类............");
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");   //3.设置响应类型

            PrintWriter out = response.getWriter();
            
            
            CacheMgr cm=CacheMgr.getInstance();
            
            int numm=cm.getSize();//获取缓存个数
            Object ob=cm.getValue("kk");
            System.out.println("numm===========//======"+numm);
            out.println("缓存个数为："+numm);
            out.println("缓存数值：value===="+ob);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }

}