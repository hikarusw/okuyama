package test;
import java.util.*;
import java.io.*;
import java.net.*;

import okuyama.imdst.client.ImdstKeyValueClient;
import okuyama.base.lang.BatchException;


public class TestSock {

    public static volatile String[] args = null;
    public static volatile boolean startFlg = false;

    public static void main(String[] args) {
        TestSock.args = args;
        TestSock me = new TestSock();
        me.exec(args);
    }

    // 引数は
    // 実行タイプ 1:登録 2:取得
    // IP:Port
    // 同時スレッド数
    public void exec (String[] args) {
        try {
            long total = 0;
            Object  [] list = new Object[Integer.parseInt(args[2])];
            int threadCount = Integer.parseInt(args[2]);
            int socketCount = 0;
            Test m = null;
            int count = 0;

            for (int i= 0; i < threadCount; i++) {
                if (args[0].equals("5")) {
                    // 引数は 5 "IP:Port" スレッド数 接続数
                    m = new Test();
                    socketCount = Integer.parseInt(args[3]);
                    m.setMaxPrefix(socketCount / threadCount);

                } else if (args[0].equals("4")) {
                    m = new Test();
                    m.setMaxPrefix(count);
                    count = count + 20000;
                } else {
                    m = new Test();
                    if (args.length > 3) 
                        m.setMaxPrefix(Integer.parseInt(args[3]));
                }
                m.setThreadNo(i);
                list[i] = m;
                
            }


            for (int i= 0; i < list.length; i++) {

                m = (Test)list[i];
                m.start();
                list[i] = m;
            }

            startFlg = true;

            System.out.println("  ------- Start -------");
            if (args[0].equals("getloop")) {
                for(int i = 1; i < 100000; i++) {
                    Thread.sleep(5000);
                    System.out.println("-- " + (i * 5) + "秒");
                    for (int ii= 0; ii < list.length; ii++) {
                        m = (Test)list[ii];
                        System.out.println(m.getExecCounter());
                    }
                } 

            } else if (args[0].equals("setloop")) {
                for(int i = 1; i < 100000; i++) {
                    Thread.sleep(5000);
                    System.out.println("-- " + (i * 5) + "秒");
                    for (int ii= 0; ii < list.length; ii++) {
                        m = (Test)list[ii];
                        System.out.println(m.getExecCounter());
                    }
                } 
            } else if (args[0].equals("setmore")) {
                for(int i = 1; i < 86400; i++) {
                    Thread.sleep(6000);
                    System.out.println("-- " + (i * 5) + "秒");
                    for (int ii= 0; ii < list.length; ii++) {
                        m = (Test)list[ii];
                        System.out.println(m.getExecCounter());
                    }
                } 
            } else if (args[0].equals("set")) {
                String pre = "  --";
                for(int i = 1; i < 7; i++) {
                    Thread.sleep(9990);
                    System.out.println(pre + " " + (i * 10) + "秒");
                    pre = pre + "--";
                }

            }else if (args[0].equals("get")) {
                String pre = "  --";
                for(int i = 1; i < 7; i++) {
                    Thread.sleep(9990);
                    System.out.println(pre + " " + (i * 10) + "秒");
                    pre = pre + "--";
                }
            } else if (args[0].equals("print")) {
                Thread.sleep(120000);
            } else if (args[0].equals("4")) {
                boolean execFlg = true;
                while(execFlg) {
                    execFlg = false;
                    for (int i= 0; i < list.length; i++) {
                        m = (Test)list[i];
                        System.out.println(m.getExecCounter());
                        if(m.getExecCounter() != 20000) execFlg = true;
                    }
                    Thread.sleep(5000);
                    
                }
                
            } else if (args[0].equals("5")) {
                boolean execFlg = true;
                long start = System.currentTimeMillis();
                while(execFlg) {
                    execFlg = false;
                    for (int i= 0; i < list.length; i++) {
                        m = (Test)list[i];
                        System.out.println(m.getExecCounter());
                        if(!m.getEndFlg()) execFlg = true;
                    }
                    Thread.sleep(5000);
                }
                long end = System.currentTimeMillis();
                System.out.println((end - start) + " Time Millis");
            }
            startFlg = false;

            Thread.sleep(500);
            System.out.println("  -------- End --------");
            System.out.println("");
            Thread.sleep(500);


            for (int i= 0; i < list.length; i++) {

                m = (Test)list[i];
                System.out.println("ThreadNo." + (i+1) + " = " + m.getExecCounter() + "件");
                total = total + m.getExecCounter();
            }


            double one = total / threadCount;
            System.out.println("");
            System.out.println("合計処理件数 = " + total + "件");
            //System.out.println("1 Thread Avg Query Count = " + one);
            //System.out.println("QPS = " + (total / 60));

            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}