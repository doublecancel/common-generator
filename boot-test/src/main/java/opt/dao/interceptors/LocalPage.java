package opt.dao.interceptors;

import opt.dao.Page;

/**
 * Created by Administrator on 2017/10/24.
 */
public class LocalPage {
    private static ThreadLocal<Page> LOCAL = new ThreadLocal<>();

    public static synchronized void set(Page page){
        LOCAL.set(page);
    }

    public static synchronized Page get(){
        Page p = LOCAL.get();
        return p;
    }

    public static Page getAndRemove() {
        Page p = null;
        try {
            p = LOCAL.get();
        } finally {
            LOCAL.remove();
        }
        return p;
    }
}
