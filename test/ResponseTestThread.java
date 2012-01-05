package test;

import java.util.*;
import java.io.*;
import java.net.*;

import okuyama.imdst.client.*;



public class ResponseTestThread extends Thread {

    public volatile int threadNo = 0;
    public volatile String prefix = "";

    public volatile long execCounter = 0;
    public volatile boolean rndFlg = false;

    public volatile long endCounter = 0;

    private volatile boolean endFlg = false;


    private static final String tmpKey = "DataSaveKey123456789ABC_";
    private static final String tmpValue = "DataSaveValue_0987654321DEFGHIJKLMN0123456789_";

    private OkuyamaClientFactory factory = null;
    private static Object sync = new Object();


    public ResponseTestThread(int threadNo, String prefix, boolean rndFlg, long endCounter) {
        this.threadNo = threadNo;
        this.prefix = prefix;
        this.rndFlg = rndFlg;
        this.endCounter = endCounter;
    }


    public void run() {
        OkuyamaClient okuyamaClient = null;

        while(!ResponseTest.startFlg){}
        try {
            String[] infos = ResponseTest.args[1].split(",");
            this.factory = OkuyamaClientFactory.getFactory(ResponseTest.args[1].split(","), 5);
            okuyamaClient = this.factory.getClient();

            if (ResponseTest.args[0].equals("1")) {



                /*okuyamaClient.setConnectionInfos(infos);
                okuyamaClient.autoConnect();*/


                String key = tmpKey + threadNo + "_" + prefix + "_";
                String value= tmpValue + threadNo + "_" + prefix + "_";



                if (rndFlg) {

                    // Random
                    Random rnd = new Random();
                    int rndVal = new Long(this.endCounter).intValue();
                    while(true &&  ResponseTest.startFlg){

                        int appendInt = rnd.nextInt(rndVal);
                        if(!okuyamaClient.setValue(key + appendInt, value + appendInt)) {
                            System.out.println("Error");
                        }

                        this.execCounter++;
                    }
                } else {

                    // Loop
                    while(true &&  ResponseTest.startFlg){

                        if(!okuyamaClient.setValue(key + this.execCounter, value + this.execCounter)) {
                            System.out.println("Error");
                        }

                        this.execCounter++;
                        if (this.endCounter <= this.execCounter) break;
                    }
                }
            } else if (ResponseTest.args[0].equals("2")) {



                String key = tmpKey + threadNo + "_" + prefix + "_";
                String[] ret = null;

                if (rndFlg) {

                    // Random
                    Random rnd = new Random();
                    int rndVal = new Long(this.endCounter).intValue();

                    while(true &&  ResponseTest.startFlg){

                        ret = okuyamaClient.getValue(key + rnd.nextInt(rndVal));

                        if(ret[0].length() == 5) {
                            System.out.println("Not Found");
                        }/* else {
                            System.out.println(ret[1]);
                        }*/
                        this.execCounter++;
                    }
                } else {

                    // Loop
                    while(true &&  ResponseTest.startFlg){

                        ret = okuyamaClient.getValue(key + this.execCounter);

                        if(ret[0].length() == 5) {
                            System.out.println("Not Found");
                        }/* else {
                            System.out.println(ret[1]);
                        }*/

                        this.execCounter++;
                        if (this.endCounter <= this.execCounter) break;
                    }
                }
            }
            okuyamaClient.close();
            this.factory.shutdown();
            this.endFlg = true;
        } catch (Exception e) {
            e.printStackTrace();
            endFlg = true;
        } finally {
            try {
                okuyamaClient.close();
            } catch (Exception e2) {
            }
        }
    }


    public long getExecCounter() {
        return this.execCounter;
    }

    public boolean getEndFlg() {
        return this.endFlg;
    }
}
