package cache.com;
/**
* @author 作者
* @version 创建时间：2019年1月14日 上午10:02:04
* 类说明
*/
import java.util.Date;

import javax.servlet.http.HttpServlet;

import com.henu.util.CacheConfModel;
import com.henu.util.CacheMgr;
/**
 * 项目启动时默认加载缓存数据类
 * @author Administrator
 */
public class LoadCache extends HttpServlet{
    

    public void init(){
        addData();
    }
    
    /**
     * 项目启动时加载缓存
     */
    public void addData(){
        System.out.println("进入加载缓存addData()………………。");
        CacheMgr cm=CacheMgr.getInstance();
        CacheConfModel cModel=new CacheConfModel();
        Date d=new Date();
        cModel.setBeginTime(d.getTime());
        cModel.setDurableTime(60);
        cModel.setForever(true);
        cm.addCache("kk", "123", cModel);//在缓存加值
    }
    
}