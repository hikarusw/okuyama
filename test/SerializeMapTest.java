package test;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

import okuyama.imdst.util.serializemap.*;


public class SerializeMapTest extends Thread {

    private static String serializeClassName = "okuyama.imdst.util.serializemap.ObjectStreamSerializer";

    private static boolean status = true;

    private static Map testMap = new SerializeMap(2000000, 1900000, 1000000, serializeClassName);
    //private static Map testMap = new ConcurrentHashMap(2000000, 1900000, 64);


    public static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    public static Lock r = rwl.readLock();
    public static Lock w = rwl.writeLock();

    private int threadPrefix = 0;


    public SerializeMapTest(int prefix) {
        threadPrefix = prefix;
    }

    public static void main(String[] args) {
        try {
            long totalExecCount = 0L;
            int maxThreads = Integer.parseInt(args[0]);
            w.lock();
            SerializeMap initMap = new SerializeMap(100, 90, 10, serializeClassName);
            initMap.put("a", "b");
            initMap.get("a");
            initMap = null;

            SerializeMapTest[] tList = new SerializeMapTest[maxThreads];
            
            for (int idx = 0; idx < maxThreads; idx++) {
                SerializeMapTest me = new SerializeMapTest(idx);
                me.start();
                tList[idx] = me;
            }
            
            w.unlock();
            // Comment Out 
            /*for (int i = 0; i < 100000; i++) {
                Thread.sleep(3000);
                System.out.println(testMap.size());
            }*/
            Thread.sleep(10000);
            SerializeMapTest.status = false;

            for (int idx = 0; idx < maxThreads; idx++) {
                tList[idx].join();
            }
            System.out.println("TotalExecCount = " + testMap.size());
            System.out.println("QPS = " + (testMap.size() / 10));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run () {
        try {
            r.lock();
            r.unlock();
            String key = "KeyABCDEFG_" + threadPrefix + "_";
            String value = "Value123456789ABCDEFGHIJKLMNOPQRSTUWXYZ_" + threadPrefix + "_";
            Random rnd = new Random();

            for (int idx = 0; SerializeMapTest.status; idx++) {
                //System.out.println(key + idx + "  " + value + idx);
                testMap.put(key + idx, value + idx);
                /*int rndInt = rnd.nextInt(2000000);
                testMap.put(key + rndInt, value + rndInt);*/
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}