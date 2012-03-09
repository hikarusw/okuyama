package okuyama.imdst.util;

import java.util.concurrent.locks.*;
import java.util.*;
    

/**
 * LinkedHashMapを継承してLRUキャッシュを実現.<br>
 * 主にFileMode時のValueのキャッシュに利用.<br>
 *
 * @author T.Okuyama
 * @license GPL(Lv3)
 */
public class ValueCacheMap extends LinkedHashMap {

    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    private static int upperCacheMemSize = 60;

    private int maxCacheSize = 8192;

    protected Map copyMap = null;

    // コンストラクタ
    public ValueCacheMap() {
        super(1024, 0.75f, true);
    }


    // コンストラクタ
    public ValueCacheMap(int maxCacheCapacity) {
        super(maxCacheCapacity, 0.75f, true);
        maxCacheSize = maxCacheCapacity;
    }



    // コンストラクタ
    public ValueCacheMap(int maxCacheCapacity, Map copyMap) {
        super(maxCacheCapacity, 0.75f, true);
        maxCacheSize = maxCacheCapacity;
        this.copyMap = copyMap;
    }


    /**
     * set<br>
     *
     * @param key
     * @param value
     */
    public Object put(Object key, Object value) {
        w.lock();
        try {
            if (this.copyMap != null) {
                this.copyMap.put(key, "");
            } 
            return super.put(key, value);
            
        } finally {
            w.unlock(); 
        }
    }


    /**
     * containsKey<br>
     *
     * @param key
     * @return boolean
     */
    public boolean containsKey(Object key) {
        r.lock();
        try { 
            return super.containsKey(key);
        } finally { 
            r.unlock(); 
        }
    }


    /**
     * get<br>
     *
     * @param key
     * @return Object
     */
    public Object get(Object key) {
        r.lock();
        try { 
            return super.get(key); 
        } finally { 
            r.unlock(); 
        }
    }


    /**
     * remove<br>
     *
     * @param key
     * @return Object
     */
    public Object remove(Object key) {
        w.lock();
        try {
            if (this.copyMap != null) this.copyMap.remove(key);
            return super.remove(key);
        } finally {
            w.unlock(); 
        }
    }


    /**
     * removeTransfer<br>
     *
     */
    public void removeTransfer() {
        w.lock();
        try {
            int nowJvmUseMem = JavaSystemApi.getUseMemoryPercentCache();
            if (nowJvmUseMem > upperCacheMemSize) {
                super.put(null, null);
                super.remove(null);
            }
        } finally {
            w.unlock(); 
        }
    }


    /**
     * removeTransfer<br>
     *
     */
    public void maintenanceRemoveTransfer() {
        boolean execFlg = true;
        int counter = 0;
        while(execFlg) {

            w.lock();
            
            try {
                if (counter != 1000) {

                    int nowJvmUseMem = JavaSystemApi.getUseMemoryPercentCache();
                    if (nowJvmUseMem > upperCacheMemSize) {

                        super.put(null, null);
                        super.remove(null);
                    } else {

                        execFlg = false;
                    }
                } else {

                    execFlg = false;
                }
                counter++;
            } finally {
                w.unlock(); 
            }
        }
    }


    /**
     * clear<br>
     *
     */
    public void clear() {
        w.lock();
        try { 
            super.clear();
            if (this.copyMap != null) this.copyMap.clear();
        } finally {
            w.unlock(); 
        }
    }


    /**
     * 削除指標実装.<br>
     */
    protected boolean removeEldestEntry(Map.Entry eldest) {
        if (maxCacheSize < super.size()) {
            if (this.copyMap != null) {
                this.copyMap.remove(eldest.getKey());
            }
            return true;
        }
        int nowJvmUseMem = JavaSystemApi.getUseMemoryPercentCache();
        
        return nowJvmUseMem > upperCacheMemSize;
    }
}
