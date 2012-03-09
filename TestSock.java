import java.util.*;
import java.io.*;
import java.net.*;

import okuyama.imdst.util.*;
import okuyama.imdst.client.OkuyamaClient;
import okuyama.imdst.client.OkuyamaResultSet;
import okuyama.base.lang.BatchException;

public class TestSock {
    public static void main(String[] args) {
        try {

            if (args == null || args.length ==0) {

                System.out.println("{�L�[�l�������ŌJ��Ԃ������ϓ������ēo�^}                        �R�}���h����{args[0]=1, args[1]=�}�X�^�m�[�h�T�[�oIP, args[2]=�}�X�^�m�[�h�T�[�oPort�ԍ�, args[3]=�o�^����}");
                System.out.println("{�L�[�l�������ŌJ��Ԃ������ϓ������ēo�^}                        �R�}���h����{args[0]=1.1, args[1]=�}�X�^�m�[�h�T�[�oIP, args[2]=�}�X�^�m�[�h�T�[�oPort�ԍ�, args[3]=�o�^Key�l, args[4]=�o�^Value�l}");
                System.out.println("{�L�[�l�������ŌJ��Ԃ������ϓ������ēo�^}                        �R�}���h����{args[0]=1.2, args[1]=\"�}�X�^�m�[�h�T�[�oIP:�}�X�^�m�[�h�T�[�oPort�ԍ�,�X���[�u�}�X�^�m�[�h�T�[�oIP:�X���[�u�}�X�^�m�[�h�T�[�oPort�ԍ�\", args[2]=�o�^����}");
                System.out.println("{�L�[�l�������ŌJ��Ԃ������ϓ������Ď擾}                        �R�}���h����{args[0]=2, args[1]=�}�X�^�m�[�h�T�[�oIP, args[2]=�}�X�^�m�[�h�T�[�oPort�ԍ�, args[3]=�擾��}");
                System.out.println("{�L�[�l�������ŌJ��Ԃ������ϓ������Ď擾}                        �R�}���h����{args[0]=2.1, args[1]=�}�X�^�m�[�h�T�[�oIP, args[2]=�}�X�^�m�[�h�T�[�oPort�ԍ�, args[3]=�擾������Key�l}");
                System.out.println("{�L�[�l�������ŌJ��Ԃ������ϓ������Ď擾}                        �R�}���h����{args[0]=2.2, args[1]=\"�}�X�^�m�[�h�T�[�oIP:�}�X�^�m�[�h�T�[�oPort�ԍ�,�X���[�u�}�X�^�m�[�h�T�[�oIP:�X���[�u�}�X�^�m�[�h�T�[�oPort�ԍ�\", args[2]=�擾��}");
                System.out.println("{�L�[�l�������ŌJ��Ԃ������ϓ������Ď擾}                        �R�}���h����{args[0]=2.22, args[1]=\"�}�X�^�m�[�h�T�[�oIP:�}�X�^�m�[�h�T�[�oPort�ԍ�,�X���[�u�}�X�^�m�[�h�T�[�oIP:�X���[�u�}�X�^�m�[�h�T�[�oPort�ԍ�\", args[2]=Key�l}");
                System.out.println("{�L�[�l���w�肵�ăX�N���v�g���s���擾}                            �R�}���h����{args[0]=2.3, args[1]=�}�X�^�m�[�h�T�[�oIP, args[2]=�}�X�^�m�[�h�T�[�oPort�ԍ�, args[3]=�擾Key�l, args[4]=���s�X�N���v�g�R�[�h}");
                System.out.println("{Tag��4�p�^�[���Ŏ����I�ɕϓ������ăL�[�l�͎����ϓ��œo�^}        �R�}���h����{args[0]=3, args[1]=�}�X�^�m�[�h�T�[�oIP, args[2]=�}�X�^�m�[�h�T�[�oPort�ԍ�, args[3]=�o�^����}");
                System.out.println("{�w�肵��Tag�Ŋ֘A����L�[�l���w��񐔎擾}                       �R�}���h����{args[0]=4, args[1]=�}�X�^�m�[�h�T�[�oIP, args[2]=�}�X�^�m�[�h�T�[�oPort�ԍ�, args[3]=�擾��, args[4]=�w��Tag�l (tag1 or tag2 or tag3 or tag4)}, args[5]=Key�l�Ƃ��đ��݂��Ȃ��l�̎擾�L�� true=tag�l�Ƃ��ēo�^���ꂽ�ߋ��������key�l�͕Ԃ� false=Key�l�����݂��Ȃ���ΕԂ��Ȃ�");
                System.out.println("{�w�肵���t�@�C�����o�C�i���f�[�^�Ƃ��Ďw�肵���L�[�l�ŕۑ�����}  �R�}���h����{args[0]=5, args[1]=�}�X�^�m�[�h�T�[�oIP, args[2]=�}�X�^�m�[�h�T�[�oPort�ԍ�, args[3]=�o�^��, args[4]=�t�@�C���p�X, args[5]=�L�[�l}");
                System.out.println("{�w�肵���L�[�l�Ńo�C�i���f�[�^���擾���ăt�@�C��������}          �R�}���h����{args[0]=6, args[1]=�}�X�^�m�[�h�T�[�oIP, args[2]=�}�X�^�m�[�h�T�[�oPort�ԍ�, args[3]=�擾��, args[4]=�쐬�t�@�C���p�X, args[5]=�L�[�l}");
                System.out.println("{�L�[�l�������ŌJ��Ԃ������ϓ������č폜}                        �R�}���h����{args[0]=7, args[1]=�}�X�^�m�[�h�T�[�oIP, args[2]=�}�X�^�m�[�h�T�[�oPort�ԍ�, args[3]=�폜��}");
                System.out.println("{�L�[�l���w�肵�ăf�[�^���폜}                                    �R�}���h����{args[0]=8, args[1]=�}�X�^�m�[�h�T�[�oIP, args[2]=�}�X�^�m�[�h�T�[�oPort�ԍ�, args[3]=�폜������Key�l}");
                System.out.println("{�g�����U�N�V�������J�n����}                                      �R�}���h����{args[0]=9, args[1]=�}�X�^�m�[�h�T�[�oIP, args[2]=�}�X�^�m�[�h�T�[�oPort�ԍ�}");
                System.out.println("{Transaction���J�n���ăf�[�^��Lock��A�f�[�^���X�V�A�擾���ALock������}  �R�}���h����{args[0]=10, args[1]=�}�X�^�m�[�h�T�[�oIP, args[2]=�}�X�^�m�[�h�T�[�oPort�ԍ�. args[3]=Key�l, args[4]=Lock�擾�ێ�����, args[5]=Lock�擾�҂�����}");
                System.out.println("{��x�o�^�����l�̓G���[�ƂȂ�}                                    �R�}���h����{args[0]=11, args[1]=�}�X�^�m�[�h�T�[�oIP, args[2]=�}�X�^�m�[�h�T�[�oPort�ԍ�. args[3]=Key�l, args[4]=Value�l}");
                System.exit(0);
            }


            if (args[0].equals("1")) {

                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^��ۑ�(Tag�Ȃ�)

                // �N���C�A���g�C���X�^���X���쐬
                OkuyamaClient okuyamaClient = new OkuyamaClient();

                // �}�X�^�T�[�o�ɐڑ�
                okuyamaClient.connect(args[1], port);

                Random rnd = new Random();
                StringBuilder strBuf =null; 
                if (args.length > 4) {
                    strBuf = new StringBuilder(120*10);
                    for (int i = 0; i < 3000; i++) {
                        strBuf.append(rnd.nextInt(1999999999));
                    }
                }

                long start = new Date().getTime();
                for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                    // �f�[�^�o�^
                    if (args.length > 5) {
                        if (!okuyamaClient.setValue("datasavekey_" + args[4] + "_" + new Integer(i).toString(), "savedatavaluestr0987654321" + strBuf.toString() + "_" + args[4] + "_" + new Integer(i).toString(), new Integer(args[5]))) {
                            System.out.println("OkuyamaClient - error");
                        } else {
                            System.out.println("Store[" + "datasavekey_" + args[4] + "_" + new Integer(i).toString() + "]");
                        }
                    } else if (args.length > 4) {

                        if (!okuyamaClient.setValue("datasavekey_" + args[4] + "_" + new Integer(i).toString(), "savedatavaluestr0987654321" + strBuf.toString() + "_" + args[4] + "_" + new Integer(i).toString())) {
                            System.out.println("OkuyamaClient - error");
                        } else {
                            //System.out.println("Store[" + "datasavekey_" + args[4] + "_" + new Integer(i).toString() + "]");
                        }
                    } else {

                        if (!okuyamaClient.setValue("datasavekey_" + new Integer(i).toString(), "savedatavaluestr_" + new Integer(i).toString())) {
                            System.out.println("OkuyamaClient - error");
                        }
                    }
                    if ((i % 1000) == 0) System.out.println(i);
                }

                if (args.length > 4) {

                    for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                        Object[] ret = okuyamaClient.getValue("datasavekey_" + args[4] + "_" + new Integer(i).toString());
                        if (ret[0].equals("true")) {
                            // �f�[�^�L��
                            if (!ret[1].equals("savedatavaluestr0987654321" + strBuf.toString() + "_" + args[4] + "_" + new Integer(i).toString())) {
                                System.out.println("Error - Key=[" + "datasavekey_" + args[4] + "_" + new Integer(i).toString() + "] Value=[" + ret[1] + "]");
                            }
                        } else if (ret[0].equals("false")) {
                            System.out.println("�f�[�^�Ȃ�");
                        } else if (ret[0].equals("error")) {
                            System.out.println(ret[1]);
                        }
                    }
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } if (args[0].equals("1.1")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^��ۑ�(Tag�Ȃ�)

                // �N���C�A���g�C���X�^���X���쐬
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                
                // �}�X�^�T�[�o�ɐڑ�
                okuyamaClient.connect(args[1], port);


                long start = new Date().getTime();
                if (args.length > 5) {
                    if (!okuyamaClient.setValue(args[3], args[4], new Integer(args[5]))) {
                    //if (!okuyamaClient.setValue("datasavekey_" + new Integer(i).toString(), "savedatavaluestr_" + new Integer(i).toString())) {
                        System.out.println("OkuyamaClient - error");
                    }
                } else {
                    if (!okuyamaClient.setValue(args[3], args[4])) {
                    //if (!okuyamaClient.setValue("datasavekey_" + new Integer(i).toString(), "savedatavaluestr_" + new Integer(i).toString())) {
                        System.out.println("OkuyamaClient - error");
                    }
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();

            } else if (args[0].equals("1.2")) {
                // AutoConnection���[�h
                // �N���C�A���g�C���X�^���X���쐬
                OkuyamaClient okuyamaClient = new OkuyamaClient();

                // �}�X�^�T�[�o�ɐڑ�
                String[] infos = args[1].split(",");
                okuyamaClient.setConnectionInfos(infos);
                okuyamaClient.autoConnect();

                long start = new Date().getTime();
                for (int i = 0; i < Integer.parseInt(args[2]);i++) {
                    // �f�[�^�o�^
                    if (!okuyamaClient.setValue("datasavekey_" + new Integer(i).toString(), "savedatavaluestr_" + new Integer(i).toString())) {
                        System.out.println("OkuyamaClient - error");
                    }
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } if (args[0].equals("1.3")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^��ۑ�(Tag�Ȃ�)

                // �N���C�A���g�C���X�^���X���쐬
                OkuyamaClient okuyamaClient = new OkuyamaClient();

                // �}�X�^�T�[�o�ɐڑ�
                okuyamaClient.connect(args[1], port);

                StringBuffer bufs = new StringBuffer();

                int idx = 0;

                for (int i = 0; i < Integer.parseInt(args[4]); i++) {
                    if (idx == 0) {
                        bufs.append("a");
                        idx++;
                    } else if (idx == 1) {
                        bufs.append("b");
                        idx++;
                    } else if (idx == 2) {
                        bufs.append("c");
                        idx++;
                    } else if (idx == 3) {
                        bufs.append("d");
                        idx++;
                    } else if (idx == 4) {
                        bufs.append("e");
                        idx = 0;
                    }
                }

                    
                long start = new Date().getTime();

                if (!okuyamaClient.setValue(args[3], bufs.toString())) {
                //if (!okuyamaClient.setValue("datasavekey_" + new Integer(i).toString(), "savedatavaluestr_" + new Integer(i).toString())) {
                    System.out.println("OkuyamaClient - error");
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("2")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^���擾(Key�̂�)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] ret = null;

                long start = new Date().getTime();
                if (args.length > 4) {
                    for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                        ret = okuyamaClient.getValue("datasavekey_" + args[4] + "_" + new Integer(i).toString());
                        if (ret[0].equals("true")) {
                            // �f�[�^�L��
                            System.out.println(ret[1]);
                        } else if (ret[0].equals("false")) {
                            System.out.println("�f�[�^�Ȃ�");
                        } else if (ret[0].equals("error")) {
                            System.out.println(ret[1]);
                        }
                    }
                } else {
                    for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                        ret = okuyamaClient.getValue("datasavekey_" + new Integer(i).toString());
                        if (ret[0].equals("true")) {
                            // �f�[�^�L��
                            System.out.println(ret[1]);
                        } else if (ret[0].equals("false")) {
                            System.out.println("�f�[�^�Ȃ�");
                        } else if (ret[0].equals("error")) {
                            System.out.println(ret[1]);
                        }
                    }
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("2.1")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^���擾(Key�̂�)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] ret = null;

                long start = new Date().getTime();
                if (args.length > 4) {
                    ret = okuyamaClient.getValue(args[3], args[4]);
                } else {
                    ret = okuyamaClient.getValue(args[3]);
                }
                if (ret[0].equals("true")) {
                    // �f�[�^�L��
                    System.out.println("Value=[" + ret[1] + "]");
                } else if (ret[0].equals("false")) {
                    System.out.println("�f�[�^�Ȃ�");
                } else if (ret[0].equals("error")) {
                    System.out.println(ret[1]);
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("2.11")) {

                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^���擾(Key�̂�)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] ret = null;

                long start = new Date().getTime();
                for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                    ret = okuyamaClient.getValue("datasavekey_" + new Integer(i).toString());
                    if (ret[0].equals("true")) {
                        // �f�[�^�L��
                    } else if (ret[0].equals("false")) {
                        System.out.println("datasavekey_" + new Integer(i).toString() + " = �f�[�^�Ȃ�");
                    } else if (ret[0].equals("error")) {
                        System.out.println(ret[1]);
                    }
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("2.2")) {
                // AutoConnection���[�h
                // OkuyamaClient���g�p���ăf�[�^���擾(Key�̂�)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                String[] infos = args[1].split(",");
                okuyamaClient.setConnectionInfos(infos);
                okuyamaClient.autoConnect();

                String[] ret = null;

                long start = new Date().getTime();
                for (int i = 0; i < Integer.parseInt(args[2]);i++) {
                    ret = okuyamaClient.getValue("datasavekey_" + new Integer(i).toString());
                    if (ret[0].equals("true")) {
                        // �f�[�^�L��
                        System.out.println(ret[1]);
                    } else if (ret[0].equals("false")) {
                        System.out.println("�f�[�^�Ȃ�");
                    } else if (ret[0].equals("error")) {
                        System.out.println(ret[1]);
                    }
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("2.22")) {
                // AutoConnection���[�h
                // OkuyamaClient���g�p���ăf�[�^���擾(Key�̂�)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                String[] infos = args[1].split(",");
                okuyamaClient.setConnectionInfos(infos);
                okuyamaClient.autoConnect();

                String[] ret = null;

                long start = new Date().getTime();
                ret = okuyamaClient.getValue(args[2]);
                if (ret[0].equals("true")) {
                    // �f�[�^�L��
                    System.out.println(ret[1]);
                } else if (ret[0].equals("false")) {
                    System.out.println("�f�[�^�Ȃ�");
                } else if (ret[0].equals("error")) {
                    System.out.println(ret[1]);
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();

            } else if (args[0].equals("2.3")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^���擾(Key�̂�)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] ret = null;

                long start = new Date().getTime();
                ret = okuyamaClient.getValueScript(args[3], args[4]);
                if (ret[0].equals("true")) {
                    // �f�[�^�L��
                    System.out.println(ret[1]);
                } else if (ret[0].equals("false")) {
                    System.out.println("�f�[�^�Ȃ�");
                } else if (ret[0].equals("error")) {
                    System.out.println(ret[1]);
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("2.33")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^���擾(Key�̂�)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] ret = null;

                long start = new Date().getTime();
                for (int i = 0; i < Integer.parseInt(args[3]); i++) {
                    ret = okuyamaClient.getValueScript("datasavekey_" + new Integer(i).toString(), "var dataValue; var retValue = ''; var execRet = '0'; if (dataValue.indexOf('99') != -1) {   retValue = dataValue;   execRet = '1';}");
                    //if (ret[0].equals("true")) System.out.println(ret[1]);
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("2.4")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^���擾(Key�̂�)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] ret = null;

                long start = new Date().getTime();
                ret = okuyamaClient.getValueScriptForUpdate(args[3], args[4]);
                if (ret[0].equals("true")) {
                    // �f�[�^�L��
                    System.out.println(ret[1]);
                } else if (ret[0].equals("false")) {
                    System.out.println("�f�[�^�Ȃ�");
                } else if (ret[0].equals("error")) {
                    System.out.println(ret[1]);
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("3")) {

                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^��ۑ�(Tag����)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] tag1 = {"tag1"};
                String[] tag2 = {"tag1","tag2"};
                String[] tag3 = {"tag1","tag2","tag3"};
                String[] tag4 = {"tag4"};
                String[] setTag = null;
                int counter = 0;

                long start = new Date().getTime();

                for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                    if (counter == 0) {
                        setTag = tag1;
                        counter++;
                    } else if (counter == 1) {
                        setTag = tag2;
                        counter++;
                    } else if (counter == 2) {
                        setTag = tag3;
                        counter++;
                    } else if (counter == 3) {
                        setTag = tag4;
                        counter = 0;
                    }

                    if (!okuyamaClient.setValue("tagsampledatakey_" + new Integer(i).toString(), setTag, "tagsamplesavedata_" + new Integer(i).toString())) {
                        System.out.println("OkuyamaClient - error");
                    }
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("3.9")) {

                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^��ۑ�(Tag����)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] tag1 = {"tag11"};
                String[] setTag = null;
                int counter = 0;

                long start = new Date().getTime();
                long end = 0L;
                for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                        setTag = tag1;

                    if (!okuyamaClient.setValue("tagsampledatakey_" + new Integer(i).toString(), setTag, "tagsamplesavedata_" + new Integer(i).toString())) {
                        System.out.println("OkuyamaClient - error");
                    }
                    if ((i % 1000) == 0) {
                        end = new Date().getTime();
                        System.out.println((end - start));
                        start = new Date().getTime();
                    }
                }
                end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("3.1")) {
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^��ۑ�(Tag����)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] setTag = args[4].split(" ");

                int counter = 0;
                String keyStr = null;

                long start = new Date().getTime();
                okuyamaClient.setValue(args[3], setTag, args[5]);
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("3.2")) {
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^��ۑ�(Tag����)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] setTag = args[3].split(" ");

                int counter = 0;
                String keyStr = null;

                long start = new Date().getTime();
                for (int idx = 0; idx < Integer.parseInt(args[4]); idx++)  {
                    okuyamaClient.setValue(new Integer(idx).toString(), setTag, new Integer(idx).toString());
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("4")) {

                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^���擾(Tag�ł̎擾)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);

                String[] keys = null;
                boolean noExistsData = true;
                if (args.length > 5) noExistsData = new Boolean(args[5]).booleanValue();

                long start = new Date().getTime();
                for (int i = 0; i < Integer.parseInt(args[3]); i++) {

                    Object[] ret = okuyamaClient.getTagKeys(args[4], noExistsData);
                    long end = new Date().getTime();
                    System.out.println((end - start));

                    if (ret[0].equals("true")) {
                        // �f�[�^�L��
                        keys = (String[])ret[1];
                        System.out.println("ResultCount=" + keys.length);
                        /*for (int idx = 0; idx < keys.length; idx++) {
                            System.out.println(keys[idx]);
                        }*/
                    } else if (ret[0].equals("false")) {
                        System.out.println("�f�[�^�Ȃ�");
                    } else if (ret[0].equals("error")) {
                        System.out.println(ret[1]);
                    }
                }

                if (keys != null) {
                    for (int ii = 0; ii < keys.length; ii++) {
                        System.out.println("Key=[" + keys[ii] + "]");
                        String[] ret = okuyamaClient.getValue(keys[ii]);
                        System.out.println("Value=[" + ret[1] + "]");
                    }
                }
                okuyamaClient.close();

            } else if (args[0].equals("5")) {
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient�Ńt�@�C�����L�[�l�ŕۑ�����
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] keys = null;
                long start = new Date().getTime();
                // args[4]�̓t�@�C�����Aargs[5]�̓L�[�l
                for (int i = 0; i < Integer.parseInt(args[3]); i++) {
                    // �t�@�C�����o�C�i���œǂݍ���
                    byte[] fileByte = null;
                    File file = new File(args[4]);
                    fileByte = new byte[new Long(file.length()).intValue()];
                    FileInputStream fis = new FileInputStream(file);
                    fis.read(fileByte, 0, fileByte.length);
                    //okuyamaClient.setCompressMode(true);
                    if (!okuyamaClient.setByteValue(args[5], fileByte)) {
                        System.out.println("OkuyamaClient - error");
                    }
                    fis.close();
                }
                long end = new Date().getTime();
                System.out.println((end - start));
                okuyamaClient.close();
            } else if (args[0].equals("5.1")) {
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient�Ńt�@�C���̃o�C�i���f�[�^��Base64�ɃG���R�[�h���ĕ�����Ƃ��ĕۑ�
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] keys = null;
                long start = new Date().getTime();
                // args[3]�̓t�@�C�����Aargs[4]�̓L�[�l

                // �t�@�C�����o�C�i���œǂݍ���
                byte[] fileByte = null;
                File file = new File(args[3]);
                fileByte = new byte[new Long(file.length()).intValue()];
                FileInputStream fis = new FileInputStream(file);
                fis.read(fileByte, 0, fileByte.length);
                //okuyamaClient.setCompressMode(true);
                if (!okuyamaClient.sendByteValue(args[4], fileByte)) {
                    System.out.println("OkuyamaClient - error");
                }
                fis.close();

                long end = new Date().getTime();
                System.out.println((end - start));
                okuyamaClient.close();

            } else if (args[0].equals("6")) {
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^���擾(Key�̂�)(�o�C�i��)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                Object[] ret = null;
                long start = new Date().getTime();
                
                for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                    //okuyamaClient.setCompressMode(true);
                    ret = okuyamaClient.getByteValue(args[5]);
                    if (ret[0].equals("true")) {
                        // �f�[�^�L��
                        byte[] fileByte = null;
                        File file = new File(args[4]);
                        FileOutputStream fos = new FileOutputStream(file);
                        fileByte = (byte[])ret[1];
                        fos.write(fileByte, 0, fileByte.length);
                        fos.close();
                    } else if (ret[0].equals("false")) {
                        System.out.println("�f�[�^�Ȃ�");
                    } else if (ret[0].equals("error")) {
                        System.out.println(ret[1]);
                    }
                }
                long end = new Date().getTime();
                System.out.println((end - start));
                okuyamaClient.close();
            } else if (args[0].equals("6.1")) {
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^���擾(Key�̂�)(�o�C�i��)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                Object[] ret = null;
                long start = new Date().getTime();
                
                for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                    //okuyamaClient.setCompressMode(true);
                    ret = okuyamaClient.getByteValueVer2(args[5]);
                    if (ret[0].equals("true")) {
                        // �f�[�^�L��
                        byte[] fileByte = null;
                        File file = new File(args[4]);
                        FileOutputStream fos = new FileOutputStream(file);
                        fileByte = (byte[])ret[1];
                        fos.write(fileByte, 0, fileByte.length);
                        fos.close();
                    } else if (ret[0].equals("false")) {
                        System.out.println("�f�[�^�Ȃ�");
                    } else if (ret[0].equals("error")) {
                        System.out.println(ret[1]);
                    }
                }
                long end = new Date().getTime();
                System.out.println((end - start));
                okuyamaClient.close();
            } else if (args[0].equals("6.2")) {
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^���擾(Key�̂�)(�o�C�i��)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                Object[] ret = null;
                long start = new Date().getTime();
                
                for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                    //okuyamaClient.setCompressMode(true);
                    ret = okuyamaClient.readByteValue(args[5]);
                    if (ret[0].equals("true")) {
                        // �f�[�^�L��
                        byte[] fileByte = null;
                        File file = new File(args[4]);
                        FileOutputStream fos = new FileOutputStream(file);
                        fileByte = (byte[])ret[1];
                        fos.write(fileByte, 0, fileByte.length);
                        fos.close();
                    } else if (ret[0].equals("false")) {
                        System.out.println("�f�[�^�Ȃ�");
                    } else if (ret[0].equals("error")) {
                        System.out.println(ret[1]);
                    }
                }
                long end = new Date().getTime();
                System.out.println((end - start));
                okuyamaClient.close();
            } else if (args[0].equals("7")) {
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^���폜
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] ret = null;

                long start = new Date().getTime();
                if (args.length > 4) {

                    for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                        ret = okuyamaClient.removeValue("datasavekey_" + args[4] + "_" + new Integer(i).toString());
                        if (ret[0].equals("true")) {
                            // �f�[�^�L��
                            System.out.println(ret[1]);
                        } else if (ret[0].equals("false")) {
                            System.out.println("�f�[�^�Ȃ�");
                        } else if (ret[0].equals("error")) {
                            System.out.println(ret[1]);
                        }
                    }
                } else {

                    for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                        ret = okuyamaClient.removeValue("datasavekey_" + new Integer(i).toString());
                        if (ret[0].equals("true")) {
                            // �f�[�^�L��
                            System.out.println(ret[1]);
                        } else if (ret[0].equals("false")) {
                            System.out.println("�f�[�^�Ȃ�");
                        } else if (ret[0].equals("error")) {
                            System.out.println(ret[1]);
                        }
                    }
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("7.1")) {
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p����Tag�p�̃e�X�gKey�l�f�[�^���폜
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] ret = null;

                long start = new Date().getTime();
                for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                    ret = okuyamaClient.removeValue("tagsampledatakey_" + new Integer(i).toString());
                    if (ret[0].equals("true")) {
                        // �f�[�^�L��
                        System.out.println(ret[1]);
                    } else if (ret[0].equals("false")) {
                        System.out.println("�f�[�^�Ȃ�");
                    } else if (ret[0].equals("error")) {
                        System.out.println(ret[1]);
                    }
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("8")) {
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^���폜
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] ret = null;

                long start = new Date().getTime();

                ret = okuyamaClient.removeValue(args[3]);
                if (ret[0].equals("true")) {
                    // �f�[�^�L��
                    System.out.println(ret[1]);
                } else if (ret[0].equals("false")) {
                    System.out.println("�f�[�^�Ȃ�");
                } else if (ret[0].equals("error")) {
                    System.out.println(ret[1]);
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("9")) {
                int port = Integer.parseInt(args[2]);
                // Transaction���J�n���ăf�[�^��Lock��A�f�[�^���X�V�A�擾���ALock������
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] ret = null;

                long start = new Date().getTime();

                okuyamaClient.startTransaction();
                okuyamaClient.lockData("datasavekey_3", 20, 5);
                okuyamaClient.lockData("datasavekey_2", 5, 5);
                if (!okuyamaClient.setValue("datasavekey_3", "locktestdata")) {
                    
                    System.out.println("OkuyamaClient - Lock Update Error");
                }
                ret = okuyamaClient.getValue("datasavekey_3");
                if (ret[0].equals("true")) {
                    // �f�[�^�L��
                    System.out.println(ret[1]);
                } else if (ret[0].equals("false")) {
                    System.out.println("�f�[�^�Ȃ�");
                } else if (ret[0].equals("error")) {
                    System.out.println(ret[1]);
                }


                //Thread.sleep(10000);
                //okuyamaClient.releaseLockData("datasavekey_3");

                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("10")) {
                int port = Integer.parseInt(args[2]);
                // Transaction���J�n���ăf�[�^��Lock��A�f�[�^���X�V�A�擾���ALock������

                // ������Lock�Ώۂ�Key�l, Lock�ێ�����(�b)(0�͖�����), Lock�����Ɏ擾����Ă���ꍇ�̎擾���g���C�������鎞��(�b)(0��1��擾�����݂�)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] ret = null;

                // Lock����
                if(!okuyamaClient.startTransaction()) {
                    throw new Exception("Transaction�̊J�n�Ɏ��s");
                }

                long start = new Date().getTime();

                // Lock���s
                ret = okuyamaClient.lockData(args[3], Integer.parseInt(args[4]), Integer.parseInt(args[5]));
                if (ret[0].equals("true")) {
                    System.out.println("Lock����");
                } else if (ret[0].equals("false")) {
                    System.out.println("Lock���s");
                } 


                // �ȉ��̃R�����g�A�E�g���͂����āA�R���p�C�����A
                // �ʂ̃N���C�A���g����X�V�����s����ƁA�X�V�ł��Ȃ��̂��A�킩��
                Thread.sleep(5000);

                // ���g�Ń��b�N���Ă���̂ōX�V�\
                if (!okuyamaClient.setValue(args[3], "LockDataValue")) {
                    System.out.println("�o�^���s");
                }

                ret = okuyamaClient.getValue(args[3]);
                if (ret[0].equals("true")) {
                    // �f�[�^�L��
                    System.out.println("Lock���ɓo�^�����f�[�^[" + ret[1] + "]");
                } else if (ret[0].equals("false")) {
                    System.out.println("�f�[�^�Ȃ�");
                } else if (ret[0].equals("error")) {
                    System.out.println(ret[1]);
                }

                // ���g�Ń��b�N���Ă���̂ō폜�\
                ret = okuyamaClient.removeValue(args[3]);

                if (ret[0].equals("true")) {
                    // �f�[�^�L��
                    System.out.println("Lock���ɍ폜�����f�[�^[" + ret[1] + "]");
                } else if (ret[0].equals("false")) {
                    System.out.println("�f�[�^�Ȃ�");
                } else if (ret[0].equals("error")) {
                    System.out.println(ret[1]);
                }

                // Lock�J��
                ret = okuyamaClient.releaseLockData(args[3]);
                if (ret[0].equals("true")) {
                    System.out.println("Lock�J������");
                } else if (ret[0].equals("false")) {
                    System.out.println("Lock�J�����s");
                } 

                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                // �g�����U�N�V�����J��
                okuyamaClient.endTransaction();
                okuyamaClient.close();
            } else if (args[0].equals("11")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^��ۑ���x�o�^�����l�̓G���[

                // �N���C�A���g�C���X�^���X���쐬
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                
                // �}�X�^�T�[�o�ɐڑ�
                okuyamaClient.connect(args[1], port);

                String[] retParam = null;
                long start = new Date().getTime();
                
                if (args.length == 6) {
                    retParam = okuyamaClient.setNewValue(args[3], args[4], new Integer(args[5]));
                
                } else if (args.length == 7) {
                    retParam = okuyamaClient.setNewValue(args[3], args[4], args[5], new Integer(args[6]));
                } else {
                    retParam = okuyamaClient.setNewValue(args[3], args[4]);
                }

                if(retParam[0].equals("false")) {
                
                    System.out.println(retParam[1]);
                } else {

                    System.out.println("��������");
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("12")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^��ۑ���x�o�^�����l�̓G���[
                // Tag�L��

                // �N���C�A���g�C���X�^���X���쐬
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                
                // �}�X�^�T�[�o�ɐڑ�
                okuyamaClient.connect(args[1], port);


                long start = new Date().getTime();
                String[] tags = args[4].split(",");
                String[] retParam = okuyamaClient.setNewValue(args[3], tags, args[5]);
                if(retParam[0].equals("false")) {
                
                    System.out.println(retParam[1]);
                } else {

                    System.out.println("��������");
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("13")) {

                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^���擾(getValueVersionCheck)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] ret = null;

                long start = new Date().getTime();
                if (args.length > 4) {
                    for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                        ret = okuyamaClient.getValueVersionCheck("datasavekey_" + args[4] + "_" + new Integer(i).toString());
                        if (ret[0].equals("true")) {
                            // �f�[�^�L��
                            System.out.println("Value=[" + ret[1] + "]");
                            System.out.println("VersionNo=[" + ret[2] + "]");
                        } else if (ret[0].equals("false")) {
                            System.out.println("�f�[�^�Ȃ�");
                        } else if (ret[0].equals("error")) {
                            System.out.println(ret[1]);
                            System.out.println(ret[2]);
                        }
                    }
                } else {
                    for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                        ret = okuyamaClient.getValueVersionCheck("datasavekey_" + new Integer(i).toString());
                        if (ret[0].equals("true")) {
                            // �f�[�^�L��
                            System.out.println(ret[1]);
                            System.out.println("VersionNo=[" + ret[2] + "]");
                        } else if (ret[0].equals("false")) {
                            System.out.println("�f�[�^�Ȃ�");
                        } else if (ret[0].equals("error")) {
                            System.out.println(ret[1]);
                            System.out.println(ret[2]);
                        }
                    }
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("13.1")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^���擾(Key�̂�)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] ret = null;

                long start = new Date().getTime();
                ret = okuyamaClient.getValueVersionCheck(args[3]);
                if (ret[0].equals("true")) {

                    // �f�[�^�L��
                    System.out.println("Value=[" + ret[1] + "]");
                    System.out.println("VersionNo=[" + ret[2] + "]");
                } else if (ret[0].equals("false")) {
                    System.out.println("�f�[�^�Ȃ�");
                } else if (ret[0].equals("error")) {
                    System.out.println(ret[1]);
                    System.out.println(ret[2]);
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("14")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^��ۑ�
                // �o�[�W�����`�F�b�N�L��

                // �N���C�A���g�C���X�^���X���쐬
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                
                // �}�X�^�T�[�o�ɐڑ�
                okuyamaClient.connect(args[1], port);


                long start = new Date().getTime();
                String[] retParam = okuyamaClient.setValueVersionCheck(args[3], args[4], args[5]);
                if(retParam[0].equals("false")) {
                
                    System.out.println(retParam[1]);
                } else {

                    System.out.println("��������");
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("15")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^��ۑ�
                // �o�[�W�����`�F�b�N�L��
                // Tag�L��

                // �N���C�A���g�C���X�^���X���쐬
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                
                // �}�X�^�T�[�o�ɐڑ�
                okuyamaClient.connect(args[1], port);


                long start = new Date().getTime();
                String[] tags = args[4].split(",");
                String[] retParam = okuyamaClient.setValueVersionCheck(args[3], tags, args[5], args[6]);
                if(retParam[0].equals("false")) {
                
                    System.out.println(retParam[1]);
                } else {

                    System.out.println("��������");
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("22")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^���擾(Key�̂�)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] ret = null;
                String[] multiKeys = null;
                
                if (args.length > 4) {
                    multiKeys = new String[Integer.parseInt(args[3])];
                    for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                        multiKeys[i] = "datasavekey_" + args[4] + "_" + new Integer(i).toString();
                    }
                } else {
                    multiKeys = new String[Integer.parseInt(args[3])];
                    for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                        multiKeys[i] = "datasavekey_" + new Integer(i).toString();
                    }
                }
                
                long start = new Date().getTime();
                Map retMap = okuyamaClient.getMultiValue(multiKeys);
                long end = new Date().getTime();
                if (retMap == null) {
                    System.out.println(retMap);
                } else {

                    if (args.length > 4) {
                        for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                            String val = (String)retMap.get("datasavekey_" + args[4] + "_" + new Integer(i).toString());
                            if(val == null || !val.equals("savedatavaluestr0987654321qazxswedcvfrtgbnhyujm,kiol<MKIUJNBGTRFBVFREDCXSWQAZXSWEDCVFRTGBNHY678745_savedatavaluestr0987654321qazxswedcvfrtgbnhyujm,kiol<MKIUJNBGTRFBVFREDCXSWQAZXSWEDCVFRTGBNHY678745savedatavaluestr0987654321qazxswedcvfrtgbnhyujm,kiol" + args[4] + "_" + new Integer(i).toString())) {
                                System.out.println("Error - Key=[" + "datasavekey_" + args[4] + "_" + new Integer(i).toString() + " Value=[" + val + "]");
                            }
                        }
                    } else {
                        for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                           String val = (String)retMap.get("datasavekey_" + new Integer(i).toString());
                           if(val == null || !val.equals("savedatavaluestr_" + new Integer(i).toString())) {
                               System.out.println("Error - Key=[" + "datasavekey_" + new Integer(i).toString() + " Value=[" + val + "]");
                           }
                        }
                    }
                    System.out.println(retMap);
                    System.out.println("ResultSize = [" + retMap.size() + "]");
                }
                System.out.println((end - start) + "milli second");

                okuyamaClient.close(); 
            } else if (args[0].equals("22.1")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^���擾(Key�̂�)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] ret = null;
                String[] multiKeys = null;
                
                String targetKeysStr = args[3];
                // Key�z��쐬
                multiKeys = targetKeysStr.split(" ");
                
                long start = new Date().getTime();
                Map retMap = okuyamaClient.getMultiValue(multiKeys);
                long end = new Date().getTime();
                if (retMap == null) {
                    System.out.println(retMap);
                } else {
                    System.out.println(retMap);
                    System.out.println("ResultSize = [" + retMap.size() + "]");
                }
                System.out.println((end - start) + "milli second");

                okuyamaClient.close(); 
            } else if (args[0].equals("23")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^���擾(Key�̂�)
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                
                long start = new Date().getTime();
                Map retMap = okuyamaClient.getTagValues(args[3]);
                long end = new Date().getTime();
                if (retMap == null) {
                    System.out.println(retMap);
                } else {
                    System.out.println(retMap);
                    System.out.println("ResultSize = [" + retMap.size() + "]");
                }
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();  
            } else if (args[0].equals("24")) {

                // OkuyamaClient���g�p���ăf�[�^�̉��Z���s��
                int port = Integer.parseInt(args[2]);

                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                
                long start = new Date().getTime();
                Object[] ret = okuyamaClient.incrValue(args[3], 1);
                long end = new Date().getTime();
                if (ret[0].equals("true")) {
                    System.out.println(ret[1]);
                } else {
                    System.out.println(ret[0]);
                    System.out.println(ret[1]);
                }
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();  
            } else if (args[0].equals("24.1")) {

                // OkuyamaClient���g�p���ăf�[�^�̉��Z���s��
                int port = Integer.parseInt(args[2]);

                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                
                long start = new Date().getTime();
                Object[] ret = null;
                for (int i = 0; i < Integer.parseInt(args[3]); i++) {
                    ret = okuyamaClient.incrValue(args[4], 1);
                }
                long end = new Date().getTime();
                if (ret[0].equals("true")) {
                    System.out.println(ret[1]);
                } else {
                    System.out.println(ret[0]);
                    System.out.println(ret[1]);
                }
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();  
            } else if (args[0].equals("24.2")) {

                // OkuyamaClient���g�p���ăf�[�^�̉��Z���s��
                int port = Integer.parseInt(args[2]);

                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                
                long start = new Date().getTime();
                Object[] ret = okuyamaClient.incrValue(args[3], Integer.parseInt(args[4]));
                long end = new Date().getTime();
                if (ret[0].equals("true")) {
                    System.out.println(ret[1]);
                } else {
                    System.out.println(ret[0]);
                    System.out.println(ret[1]);
                }
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();  
            } else if (args[0].equals("25")) {

                // OkuyamaClient���g�p���ăf�[�^�̌��Z���s��
                int port = Integer.parseInt(args[2]);

                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                
                long start = new Date().getTime();
                Object[] ret = okuyamaClient.decrValue(args[3], 1);
                long end = new Date().getTime();
                if (ret[0].equals("true")) {
                    System.out.println(ret[1]);
                } else {
                    System.out.println(ret[0]);
                    System.out.println(ret[1]);
                }
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();  
            } else if (args[0].equals("25.1")) {

                // OkuyamaClient���g�p���ăf�[�^�̉��Z���s��
                int port = Integer.parseInt(args[2]);

                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                
                long start = new Date().getTime();
                Object[] ret = null;
                for (int i = 0; i < Integer.parseInt(args[3]); i++) {
                    ret = okuyamaClient.decrValue(args[4], 1);
                }
                long end = new Date().getTime();
                if (ret[0].equals("true")) {
                    System.out.println(ret[1]);
                } else {
                    System.out.println(ret[0]);
                    System.out.println(ret[1]);
                }
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();  
            } else if (args[0].equals("26")) {

                // OkuyamaClient���g�p����Key��Tag���w�肵��Key����Tag���O��
                int port = Integer.parseInt(args[2]);

                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] tag1 = {"tag1"};
                String[] tag2 = {"tag1","tag2"};
                String[] tag3 = {"tag1","tag2","tag3"};
                String[] tag4 = {"tag4"};
                String[] setTag = null;
                int counter = 0;

                long start = new Date().getTime();

                for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                    if (counter == 0) {
                        setTag = tag1;
                        counter++;
                    } else if (counter == 1) {
                        setTag = tag2;
                        counter++;
                    } else if (counter == 2) {
                        setTag = tag3;
                        counter++;
                    } else if (counter == 3) {
                        setTag = tag4;
                        counter = 0;
                    }

                    for (int ii = 0; ii < setTag.length; ii++) {
                        if (!okuyamaClient.removeTagFromKey("tagsampledatakey_" + new Integer(i).toString(), setTag[ii])) {
                            System.out.println("OkuyamaClient - error Key=[" + "tagsampledatakey_" + new Integer(i) + "] Tag[" + setTag[ii] +"]");
                        }
                    }
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("26.1")) {

                // OkuyamaClient���g�p����Key��Tag���w�肵��Key����Tag���O��
                int port = Integer.parseInt(args[2]);

                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] tag1 = {args[3]};
                String key = args[4];


                long start = new Date().getTime();
                if (!okuyamaClient.removeTagFromKey(key, tag1[0])) {
                    System.out.println("OkuyamaClient - error Key=[" + key + "] Tag[" + args[3] +"]");
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("27")) {

                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^��ۑ�(Tag�Ȃ�)

                // �N���C�A���g�C���X�^���X���쐬
                OkuyamaClient okuyamaClient = new OkuyamaClient();

                // �}�X�^�T�[�o�ɐڑ�
                okuyamaClient.connect(args[1], port);

                Random rnd = new Random();
                StringBuilder strBuf =null; 
                if (args.length > 4) {
                    strBuf = new StringBuilder(6000*10);
                    for (int i = 0; i < 3000; i++) {
                        strBuf.append(rnd.nextInt(1999999999));
                    }
                }

                long start = new Date().getTime();
                for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                    // �f�[�^�o�^
                    
                    //if (!okuyamaClient.setValue("datasavekey_" + args[4] + "_" + new Integer(i).toString(), "savedatavaluestr_" + args[4] + "_" + new Integer(i).toString())) {
                    if (!okuyamaClient.setValueAndCreateIndex("datasavekey_" + args[4] + "_" + new Integer(i).toString(), "savedatavaluestr0987654321qazxswedcvfrtgbnhyujm,kiol<MKIUJNBGTRFBVFREDCXSWQAZXSWEDCVFRTGBNHY678745_savedatavaluestr09876543" + args[4] + "_" + new Integer(i).toString())) {
                    //if (!okuyamaClient.setValue("datasavekey_" + args[4] + "_" + new Integer(i).toString(), "savedatavaluestr0987654321" + strBuf.toString() + "_" + args[4] + "_" + new Integer(i).toString())) {
                        System.out.println("OkuyamaClient - error");
                    } else {
                        //System.out.println("Store[" + "datasavekey_" + args[4] + "_" + new Integer(i).toString() + "]");
                    }
                    //if ((i % 1000) == 0) System.out.println(i);
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } if (args[0].equals("27.1")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^��Index�����Ȃ���ۑ�

                // �N���C�A���g�C���X�^���X���쐬
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                
                // �}�X�^�T�[�o�ɐڑ�
                okuyamaClient.connect(args[1], port);


                long start = new Date().getTime();
                // Key, Value, Prefix
                if (!okuyamaClient.setValueAndCreateIndex(args[3], args[4])) {
                //if (!okuyamaClient.setValue("datasavekey_" + new Integer(i).toString(), "savedatavaluestr_" + new Integer(i).toString())) {
                    System.out.println("OkuyamaClient - error");
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();

            } if (args[0].equals("27.2")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^��Index�����Ȃ���ۑ�

                // �N���C�A���g�C���X�^���X���쐬
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                
                // �}�X�^�T�[�o�ɐڑ�
                okuyamaClient.connect(args[1], port);


                long start = new Date().getTime();
                // Key, Value, Prefix
                if (!okuyamaClient.setValueAndCreateIndex(args[3], args[4], args[5])) {
                //if (!okuyamaClient.setValue("datasavekey_" + new Integer(i).toString(), "savedatavaluestr_" + new Integer(i).toString())) {
                    System.out.println("OkuyamaClient - error");
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } if (args[0].equals("27.3")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^��Index�����Ȃ���ۑ�(Prefix����)

                // �N���C�A���g�C���X�^���X���쐬
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                
                // �}�X�^�T�[�o�ɐڑ�
                okuyamaClient.connect(args[1], port);


                long start = new Date().getTime();
                // Key, Tag, Value, Prefix
                String[] tags = {args[4]};
                if (!okuyamaClient.setValueAndCreateIndex(args[3], tags, args[5], args[6])) {
                //if (!okuyamaClient.setValue("datasavekey_" + new Integer(i).toString(), "savedatavaluestr_" + new Integer(i).toString())) {
                    System.out.println("OkuyamaClient - error");
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("27.4")) {

                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^��ۑ�(Tag�Ȃ�)

                // �N���C�A���g�C���X�^���X���쐬
                OkuyamaClient okuyamaClient = new OkuyamaClient();

                // �}�X�^�T�[�o�ɐڑ�
                okuyamaClient.connect(args[1], port);

                Random rnd = new Random();


                long start = new Date().getTime();

                int idx = 0;

                FileInputStream workKeyFilefis = null;
                InputStreamReader isr = null;

                FileReader fr = null;
                BufferedReader br = null;

                File dataFile = new File(args[3]);
                workKeyFilefis = new FileInputStream(dataFile);
                isr = new InputStreamReader(workKeyFilefis , "UTF-8");
                br = new BufferedReader(isr);

                String line = null;


                while ((line = br.readLine()) != null) {
                    idx++;
                    // �f�[�^�o�^
                    if (!okuyamaClient.setValueAndCreateIndex("key_" + idx, line)) {
                        System.out.println("OkuyamaClient - error");
                    } else {
                        //System.out.println("Store[key_" + idx + "]");
                    }
                    if ((idx % 1000) == 0) System.out.println(idx);
                }

                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();

            } else if (args[0].equals("28")) {

                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p����Value������
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] keys = null;
                String[] searchCharList = args[3].split(":");
                long start = new Date().getTime();

                Object[] ret = okuyamaClient.searchValue(searchCharList, args[4]);
                long end = new Date().getTime();

                if (ret[0].equals("true")) {
                    // �f�[�^�L��
                    System.out.println((end - start) + " mille");
                    keys = (String[])ret[1];
                    System.out.println("Result Count[" + keys.length + "]");
                    for (int idx = 0; idx < keys.length; idx++) {
                        System.out.println(keys[idx]);
                    }
                } else if (ret[0].equals("false")) {
                    System.out.println("�f�[�^�Ȃ�");
                } else if (ret[0].equals("error")) {
                    System.out.println(ret[1]);
                }

/*
                if (keys != null) {
                    for (int ii = 0; ii < keys.length; ii++) {
                        System.out.println("Key=[" + keys[ii] + "]");
                        ret = okuyamaClient.getValue(keys[ii]);
                        System.out.println("Value=[" + ret[1] + "]");
                    }
                }
                */
                end = new Date().getTime();
                System.out.println((end - start));
                okuyamaClient.close();
            } else if (args[0].equals("28.2")) {

                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p����Value������
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] keys = null;
                String[] searchCharList = args[3].split(":");
                long start = new Date().getTime();

                Object[] ret = okuyamaClient.searchValue(searchCharList, args[4], args[5]);
                long end = new Date().getTime();

                if (ret[0].equals("true")) {
                    // �f�[�^�L��
                    System.out.println((end - start) + " mille");
                    keys = (String[])ret[1];
                    System.out.println("Result Count[" + keys.length + "]");
                    for (int idx = 0; idx < keys.length; idx++) {
                        System.out.println(keys[idx]);
                    }
                } else if (ret[0].equals("false")) {
                    System.out.println("�f�[�^�Ȃ�");
                } else if (ret[0].equals("error")) {
                    System.out.println(ret[1]);
                }

/*
                if (keys != null) {
                    for (int ii = 0; ii < keys.length; ii++) {
                        System.out.println("Key=[" + keys[ii] + "]");
                        ret = okuyamaClient.getValue(keys[ii]);
                        System.out.println("Value=[" + ret[1] + "]");
                    }
                }
                */
                end = new Date().getTime();
                System.out.println((end - start));
                okuyamaClient.close();
            } else if (args[0].equals("29")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^���擾���ėL���������X�V
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                String[] ret = null;

                long start = new Date().getTime();
                if (args.length > 4) {
                    for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                        ret = okuyamaClient.getValueAndUpdateExpireTime("datasavekey_" + args[4] + "_" + new Integer(i).toString());
                        if (ret[0].equals("true")) {
                            // �f�[�^�L��
                            System.out.println(ret[1]);
                        } else if (ret[0].equals("false")) {
                            System.out.println("�f�[�^�Ȃ�");
                        } else if (ret[0].equals("error")) {
                            System.out.println(ret[1]);
                        }
                    }
                } else {
                    for (int i = 0; i < Integer.parseInt(args[3]);i++) {
                        ret = okuyamaClient.getValueAndUpdateExpireTime("datasavekey_" + new Integer(i).toString());
                        if (ret[0].equals("true")) {
                            // �f�[�^�L��
                            System.out.println(ret[1]);
                        } else if (ret[0].equals("false")) {
                            System.out.println("�f�[�^�Ȃ�");
                        } else if (ret[0].equals("error")) {
                            System.out.println(ret[1]);
                        }
                    }
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("30")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ĕ���Tag�w���Key��Value��Map���擾
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                
                long start = new Date().getTime();
                Map retMap = okuyamaClient.getMultiTagValues(args[3].split(","), new Boolean(args[4]).booleanValue());
                long end = new Date().getTime();
                if (retMap == null) {
                    System.out.println(retMap);
                } else {
                    //System.out.println(retMap);
                    System.out.println("ResultSize = [" + retMap.size() + "]");
                }
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } if (args[0].equals("31")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^��ۑ�(Tag�Ȃ�)

                // �N���C�A���g�C���X�^���X���쐬
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                
                // �}�X�^�T�[�o�ɐڑ�
                okuyamaClient.connect(args[1], port);


                long start = new Date().getTime();
                for (int idx = 0; idx < Integer.parseInt(args[3]); idx++) {
                    Map objData = new HashMap();
                    objData.put("key" + idx, "value" + idx);
                    objData.put("key_x_" + idx, "value_x_" + idx);
                    if (!okuyamaClient.setObjectValue("ObjectSetKey_" + idx, objData)) {
                        System.out.println("OkuyamaClient - error");
                    }
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } if (args[0].equals("32")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^�擾

                // �N���C�A���g�C���X�^���X���쐬
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                
                // �}�X�^�T�[�o�ɐڑ�
                okuyamaClient.connect(args[1], port);


                long start = new Date().getTime();
                for (int idx = 0; idx < Integer.parseInt(args[3]); idx++) {
                    Object[] retData = okuyamaClient.getObjectValue("ObjectSetKey_" + idx);
                    if (retData[0].equals("true")) {
                        Map objData = (Map)retData[1];
                        System.out.println(objData);
                    } else if (retData[0].equals("false")) {
                        System.out.println("ObjectSetKey_" + idx + " Not Found");
                    } else if (retData[0].equals("error")) {
                        System.out.println("ObjectSetKey_" + idx + " Error Message[" + retData[1] + "]");
                    }
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } if (args[0].equals("32.11")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ăf�[�^�擾

                // �N���C�A���g�C���X�^���X���쐬
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                
                // �}�X�^�T�[�o�ɐڑ�
                okuyamaClient.connect(args[1], port);


                long start = new Date().getTime();
                for (int idx = 0; idx < Integer.parseInt(args[3]); idx++) {
                    Object[] retData = okuyamaClient.getObjectValue("ObjectSetKey_" + idx);
                    if (retData[0].equals("true")) {
                        Map objData = (Map)retData[1];
                    } else if (retData[0].equals("false")) {
                        System.out.println("ObjectSetKey_" + idx + " Not Found");
                    } else if (retData[0].equals("error")) {
                        System.out.println("ObjectSetKey_" + idx + " Error Message[" + retData[1] + "]");
                    }
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("33")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ĕ���Tag�w���Key��Value��Map���擾
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                
                long start = new Date().getTime();
                String[] retKeys = okuyamaClient.getMultiTagKeys(args[3].split(","), new Boolean(args[4]).booleanValue());
                long end = new Date().getTime();
                if (retKeys == null) {
                    System.out.println(retKeys);
                } else {
                    /*for (int idx = 0; idx < retKeys.length; idx++) {
                        System.out.println(retKeys[idx]);
                    }*/
                    System.out.println("ResultSize = [" + retKeys.length + "]");
                }
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("34")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ĕ���Tag�w���Key��Value��Map���擾
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                
                long start = new Date().getTime();
                OkuyamaResultSet okuyamaResultSet = okuyamaClient.getTagKeysResult(args[3]);
                long end = new Date().getTime();
                if (okuyamaResultSet == null) {
                    System.out.println(okuyamaResultSet);
                } else {
                    int counter = 0;
                    while(okuyamaResultSet.next()) {
                        counter++;
                        System.out.println("Key=" + (String)okuyamaResultSet.getKey());
                        System.out.println("Value=" + (String)okuyamaResultSet.getValue());
                    }
                    okuyamaResultSet.close();

                    System.out.println("ResultSize = [" + counter + "]");
                }
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("34.1")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ĕ���Tag�w���Key��Value��Map���擾
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                
                long start = new Date().getTime();
                OkuyamaResultSet okuyamaResultSet = okuyamaClient.getTagKeysResult(args[3]);

                if (okuyamaResultSet == null) {
                    System.out.println(okuyamaResultSet);
                } else {
                    int counter = 0;
                    while(okuyamaResultSet.next()) {
                        counter++;
                        //System.out.println("Key=" + (String)okuyamaResultSet.getKey());
                        //System.out.println("Value=" + (String)okuyamaResultSet.getValue());
                    }
                    okuyamaResultSet.close();

                    System.out.println("ResultSize = [" + counter + "]");
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("34.2")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ĕ���Tag�w���Key��Value��Map���擾
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                
                long start = new Date().getTime();
                double[] rangeSet = {Double.parseDouble(args[4]), Double.parseDouble(args[5])};
                OkuyamaResultSet okuyamaResultSet = okuyamaClient.getTagKeysResult(args[3], rangeSet, Integer.parseInt(args[6]));

                if (okuyamaResultSet == null) {
                    System.out.println(okuyamaResultSet);
                } else {
                    int counter = 0;
                    while(okuyamaResultSet.next()) {
                        counter++;
                        //System.out.println("Key=" + (String)okuyamaResultSet.getKey());
                        //System.out.println("Value=" + (String)okuyamaResultSet.getValue());
                    }
                    okuyamaResultSet.close();

                    System.out.println("ResultSize = [" + counter + "]");
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();

            } else if (args[0].equals("35")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ĕ���Tag�w���Key��Value��Map���擾
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                
                long start = new Date().getTime();
                OkuyamaResultSet okuyamaResultSet = okuyamaClient.getMultiTagKeysResult(args[3].split(","), new Boolean(args[4]).booleanValue());
                long end = new Date().getTime();
                if (okuyamaResultSet == null) {
                    System.out.println(okuyamaResultSet);
                } else {
                    int counter = 0;
                    while(okuyamaResultSet.next()) {
                        counter++;
                        System.out.println("Key=" + (String)okuyamaResultSet.getKey());
                        System.out.println("Value=" + (String)okuyamaResultSet.getValue());
                    }
                    okuyamaResultSet.close();

                    System.out.println("ResultSize = [" + counter + "]");
                }
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("35.1")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p���ĕ���Tag�w���Key��Value��Map���擾
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                
                long start = new Date().getTime();
                OkuyamaResultSet okuyamaResultSet = okuyamaClient.getMultiTagKeysResult(args[3].split(","), new Boolean(args[4]).booleanValue());

                if (okuyamaResultSet == null) {
                    System.out.println(okuyamaResultSet);
                } else {
                    int counter = 0;
                    while(okuyamaResultSet.next()) {
                        counter++;
                        //System.out.println("Key=" + (String)okuyamaResultSet.getKey());
                        //System.out.println("Value=" + (String)okuyamaResultSet.getValue());
                    }
                    okuyamaResultSet.close();

                    System.out.println("ResultSize = [" + counter + "]");
                }
                long end = new Date().getTime();
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();
            } else if (args[0].equals("999")) {
                
                int port = Integer.parseInt(args[2]);
                // OkuyamaClient���g�p����okuyama�̃o�[�W�������擾
                OkuyamaClient okuyamaClient = new OkuyamaClient();
                okuyamaClient.connect(args[1], port);
                
                long start = new Date().getTime();
                String[] ret = okuyamaClient.getOkuyamaVersion();
                long end = new Date().getTime();
                if (ret[0].equals("true")) {
                    System.out.println(ret[1]);
                } else {
                    System.out.println(ret[0]);
                }
                System.out.println((end - start) + "milli second");

                okuyamaClient.close();  
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

