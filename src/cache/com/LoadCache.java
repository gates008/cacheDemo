package cache.com;
/**
* @author ����
* @version ����ʱ�䣺2019��1��14�� ����10:02:04
* ��˵��
*/
import java.util.Date;

import javax.servlet.http.HttpServlet;

import com.henu.util.CacheConfModel;
import com.henu.util.CacheMgr;
/**
 * ��Ŀ����ʱĬ�ϼ��ػ���������
 * @author Administrator
 */
public class LoadCache extends HttpServlet{
    

    public void init(){
        addData();
    }
    
    /**
     * ��Ŀ����ʱ���ػ���
     */
    public void addData(){
        System.out.println("������ػ���addData()��������������");
        CacheMgr cm=CacheMgr.getInstance();
        CacheConfModel cModel=new CacheConfModel();
        Date d=new Date();
        cModel.setBeginTime(d.getTime());
        cModel.setDurableTime(60);
        cModel.setForever(true);
        cm.addCache("kk", "123", cModel);//�ڻ����ֵ
    }
    
}