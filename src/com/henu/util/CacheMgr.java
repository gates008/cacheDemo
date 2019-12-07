package com.henu.util;
/**
* @author ����
* @version ����ʱ�䣺2019��1��14�� ����9:56:26
* ��˵��
*/
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * ���������
 * 
 * @author Administrator
 * 
 */
public class CacheMgr {

    private static Map cacheMap = new HashMap();
    private static Map cacheConfMap = new HashMap();
    private final static ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private static CacheMgr cm = null;

    // ���췽��
    private CacheMgr() {
    }

    public synchronized static CacheMgr getInstance() {
        if (cm == null) {
            cm = new CacheMgr();
            Thread t = new ClearCache();
            t.start();
        }
        System.out.println("ȡֵ2 �� "+cm.getSize() +"  " +cm.getValue("kk"));
        return cm;
    }

    /**
     * ���ӻ���
     * 
     * @param key
     * @param value
     * @param ccm
     *            �������
     * @return
     */
    public synchronized boolean addCache(Object key, Object value, CacheConfModel ccm) {
        System.out.println("��ʼ���ӻ��棭������������������������");
        boolean flag = false;
        try {
            cacheMap.put(key, value);
            cacheConfMap.put(key, ccm);
            System.out.println("���ӻ��������������������������������");
            System.out.println("now addcache==" + cacheMap.size());
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    /**
     * ��ȡ����ʵ��
     */
    public synchronized Object getValue(String key) {
        Object ob = cacheMap.get(key);
        if (ob != null) {
            return ob;
        } else {
            return null;
        }
    }

    /**
     * ��ȡ�������ݵ�����
     * 
     * @return
     */
    public synchronized int getSize() {
        return cacheMap.size();
    }

    /**
     * ɾ������
     * 
     * @param key
     * @return
     */
    public synchronized boolean removeCache(Object key) {
        boolean flag = false;
        try {
            cacheMap.remove(key);
            cacheConfMap.remove(key);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    /**
     * ���������� �̳�Thread�߳���
     */
    private static class ClearCache extends Thread {
        public void run() {
            while (true) {
                Set tempSet = new HashSet();
                Set set = cacheConfMap.keySet();
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    Object key = it.next();
                    CacheConfModel ccm = (CacheConfModel) cacheConfMap.get(key);
                    // �Ƚ��Ƿ���Ҫ���
                    if (!ccm.isForever()) {
                        if ((new Date().getTime() - ccm.getBeginTime()) >= ccm
                                .getDurableTime() * 60 * 1000) {
                            // ����������ȼ�¼����
                            tempSet.add(key);
                        }
                    }
                }
                // �������
                Iterator tempIt = tempSet.iterator();
                while (tempIt.hasNext()) {
                    Object key = tempIt.next();
                    cacheMap.remove(key);
                    cacheConfMap.remove(key);

                }
                System.out.println("now thread================>"
                        + cacheMap.size());
                // ��Ϣ
                try {
                    Thread.sleep(60 * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}