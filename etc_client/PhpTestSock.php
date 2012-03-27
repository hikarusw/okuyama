<?php

  // PHP�e�X�g�X�N���v�g
  // PHP�ł̃f�[�^�o�^
  // ������
  // 1.���s���[�h:"1" or "1.1" ro "2" or "2.1" or "2.3" or "3" or "4" or "8"
  // (1=�o�^(�����C���N�������g), 1.1=�o�^(�l�w��), 2=�f�[�^�擾(�����C���N�������g), 2.1=�擾(�l�w��), 2.3=�擾(JavaScript���s), 3=Tag�Œl��Key��Value��o�^(�����C���N�������g), 4=Tag�Œl��Key���擾(Tag�l�w��), 8=Key�l���w��ō폜))
  // 2.�}�X�^�[�m�[�hIP:127.0.0.1
  // 3.�}�X�^�[�m�[�hPort:8888
  // 4.���s��:0�`n(���s���[�h1.1�y��2.1�y��2.3�y��3�y��8���͓o�^�A�擾�A�폜������Key or Tag�l)
  // 5.�o�^�f�[�^:(���s���[�h1.1�y��2.3���̂ݗL�� 1.1���͓o�^������Value�l�A2.3���͎��s������JavaScript)
  require_once("OkuyamaClient.class.php");
  if ($argc > 3) {

    // �N���C�A���g�쐬
    $client = new OkuyamaClient();

    // �ڑ�(MasterServer�Œ�)
    if(!$client->connect($argv[2], $argv[3])) {
      print_r("Sever Connection refused !!");
      exit;
    }

/*
    // AutoConnect���[�h�Őڑ�
    $serverInfos = array();
    $serverInfos[0] = "localhost:8888";
    $serverInfos[1] = "localhost:8889";
    // ����MasterServer�̏���ݒ�
    $client->setConnectionInfos($serverInfos);

    // �����ڑ�
    if(!$client->autoConnect()) {
      // �S�Ă̌��̃T�[�o�ɂȂ���Ȃ�
      print_r("Sever Connection refused !!");
      exit;
    }
*/


    // ����
    try {
      if ($argv[1] === "size-true") {

        // �T�C�Y�`�F�b�N����Ăɍs��
        $keyVal = "";
        $dataVal = "";
        $tag = "";
        $tagStr = "";

        for ($i = 0; $i < 320; $i++) {
          $keyVal = $keyVal . "1";
        }

        for ($i = 0; $i < 12288; $i++) {
          $dataVal = $dataVal . "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        }

        for ($i = 0; $i < 320; $i++) {
          $tagStr = $tagStr . "t";
        }
        $tag[] = $tagStr;

        // �S�Đ�������͂�
        $client->setNewValue($keyVal, $dataVal, $tag);
        var_dump("setNewValue - OK");
        $client->setValue($keyVal, $dataVal, $tag);
        var_dump("setValue - OK");
        //$client->setValueAndCreateIndex($keyVal, $dataVal, $tag);
        $verCheck = $client->getValueVersionCheck($keyVal);
        var_dump("getValueVersionCheck - OK");
        $client->setValueVersionCheck($keyVal, $dataVal, NULL, $verCheck[2]);
        var_dump("setValueVersionCheck - OK");
        $client->setValue($keyVal, "0", $tag);
        $client->incrValue($keyVal, 1);
        var_dump("incrValue - OK");
        $client->decrValue($keyVal, 1);
        var_dump("decrValue - OK");


      } else if ($argv[1] === "size-false") {

        // �T�C�Y�`�F�b�N����Ăɍs��
        $keyVal = "";
        $dataVal = "";
        $tag = array();
        $tagStr = "";

        for ($i = 0; $i < 320; $i++) {
          $keyVal = $keyVal . "1";
        }

        for ($i = 0; $i < 12288; $i++) {
          $dataVal = $dataVal . "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        }

        for ($i = 0; $i < 320; $i++) {
          $tagStr = $tagStr . "t";
        }
        $tag[] = $tagStr;

        // �S�Ď��s
        try {
          $client->setNewValue($keyVal . "1", $dataVal, $tag);
          var_dump("setNewValue - NG - 1");
        } catch(Exception $e2) {
          var_dump("setNewValue - OK - 1");
          
        }
        try {
          $client->setValue($keyVal . "1", $dataVal, $tag);
          var_dump("setValue - NG - 1");
        } catch(Exception $e2) {
          var_dump("setValue - OK - 1");
          
        }
        try {
          $client->setValueAndCreateIndex($keyVal . "1", $dataVal, $tag);
          var_dump("setValueAndCreateIndex - NG - 1");
        } catch(Exception $e2) {
          var_dump("setValueAndCreateIndex - OK - 1");
          
        }
        try {
          $verCheck = $client->getValueVersionCheck($keyVal . "1");

        } catch(Exception $e2) {
          
        }
        try {
          $client->setValueVersionCheck($keyVal . "1", $dataVal, $verCheck[2]);
          var_dump("setValueVersionCheck - NG - 1");
        } catch(Exception $e2) {
          var_dump("setValueVersionCheck - OK - 1");
          
        }
        try {
          $client->setValue($keyVal . "1", "0", $tag);
        } catch(Exception $e2) {
          
        }
        try {
          $client->incrValue($keyVal . "1", 1);
          var_dump("incrValue - NG - 1");
        } catch(Exception $e2) {
          var_dump("incrValue - OK - 1");
          
        }
        try {
          $client->decrValue($keyVal . "1", 1);
          var_dump("decrValue - NG - 1");
        } catch(Exception $e2) {
          var_dump("decrValue - OK - 1");
          
        }


        try {
          $client->setNewValue($keyVal, $dataVal . "1", $tag);
          var_dump("setNewValue - NG - 2");
        } catch(Exception $e2) {
          var_dump("setNewValue - OK - 2");
          
        }
        try {
          $client->setValue($keyVal, $dataVal . "1", $tag);
          var_dump("setValue - NG - 2");
        } catch(Exception $e2) {
          var_dump("setValue - OK - 2");
          
        }
        try {
          $client->setValueAndCreateIndex($keyVal, $dataVal . "1", $tag);
          var_dump("setValueAndCreateIndex - NG - 2");
        } catch(Exception $e2) {
          var_dump("setValueAndCreateIndex - OK - 2");
          
        }
        try {
          $verCheck = $client->getValueVersionCheck($keyVal);
        } catch(Exception $e2) {
          
        }
        try {
          $client->setValueVersionCheck($keyVal, $dataVal . "1", $verCheck[2]);
          var_dump("setValueVersionCheck - NG - 2");
        } catch(Exception $e2) {
          var_dump("setValueVersionCheck - OK - 2");
          
        }


        $tagStr = $tagStr . "t";
        $tag = array();
        $tag[] = $tagStr;

        try {
          $client->setNewValue($keyVal, $dataVal, $tag);
          var_dump("setNewValue - NG - 3");
        } catch(Exception $e2) {
          var_dump("setNewValue - OK - 3");
          
        }
        try {
          $client->setValue($keyVal, $dataVal, $tag);
          var_dump("setValue - NG - 3");
        } catch(Exception $e2) {
          var_dump("setValue - OK - 3");
          
        }
        try {
          $client->setValueAndCreateIndex($keyVal, $dataVal, $tag);
          var_dump("setValueAndCreateIndex - NG - 3");
        } catch(Exception $e2) {
          var_dump("setValueAndCreateIndex - OK - 3");
          
        }

      } else if ($argv[1] === "1") {
  
        // �f�[�^�������̉񐔕��o�^
        for ($i = 0; $i < $argv[4]; $i++) {
          
          if(!$client->setValue("datasavekey_" . $i, "savedatavaluestr_" . $i)) {
            print_r("Registration failure");
          }
        }
      } else if ($argv[1] === "1.1") {
  
        // �f�[�^�������̉񐔕��o�^
        if(!$client->setValue($argv[4], $argv[5])) {
          print_r("Regist Error");
        }
      } else if ($argv[1] === "1.2") {
  
        // �f�[�^��L�������t���œo�^
        if(!$client->setValue($argv[4], $argv[5], null, $argv[6])) {
  
          print_r("Regist Error");
        } else {
  
          sleep(intval($argv[6]));
          sleep(1);
          $ret = $client->getValue($argv[4]);
          if ($ret[0] === "true") {
            print_r("ExpireData Get Error");
            print_r($ret[1]);
            print_r("\r\n");
          } else if ($ret[0] === "false") {
            print_r("ExpireData Get OK");
            print_r("\r\n");
          }
        }
      } else if ($argv[1] === "42") {
  
        // �f�[�^�������̉񐔕��o�^
        for ($i = 0; $i < $argv[4]; $i++) {
          
          if(!$client->setValueAndCreateIndex("datasavekey_" . $i, "savedatavaluestr_" . $i)) {
            print_r("Registration failure");
          }
        }
      } else if ($argv[1] === "42.1") {
  
        // �f�[�^�������̉񐔕��o�^
        for ($i = 0; $i < $argv[4]; $i++) {
          
          if(!$client->setValueAndCreateIndex("datasavekey_" . $argv[5] . "_" . $i, "savedatavaluestr_" . $argv[5] . "_" . $i, null, $argv[5])) {
            print_r("Registration failure");
          }
        }
      } else if ($argv[1] === "43") {
  
  
        // �f�[�^������Word�Ŏ擾(����Word1�AAND,OR�APrefix�w��)
        $searchWordList = array();
        $searchWordList[0] = $argv[4];
  
        var_dump($client->searchValue($searchWordList, $argv[5], $argv[6]));
      } else if ($argv[1] === "43.1") {
  
  
        // �f�[�^������Word�Ŏ擾(����Word2�AAND,OR�APrefix�w��)
        $searchWordList = array();
        $searchWordList[0] = $argv[4];
        $searchWordList[1] = $argv[5];
        var_dump($client->searchValue($searchWordList, $argv[6], $argv[7]));
      } else if ($argv[1] === "43.2") {
  
  
        // �f�[�^������Word�Ŏ擾(����Word2�AAND,OR�w��)
        $searchWordList = array();
        $searchWordList[0] = $argv[4];
        $searchWordList[1] = $argv[5];
        var_dump($client->searchValue($searchWordList, $argv[6]));
      } else if ($argv[1] === "44") {
  
  
        // �f�[�^������Index���폜
        var_dump($client->removeSearchIndex("datasavekey_716"));
  
        $searchWordList = array();
        $searchWordList[0] = $argv[4];
  
        // �폜�ς݂Ȃ̂ł����ł͌��ʂ͖��������ƂȂ�
        var_dump($client->searchValue($searchWordList, $argv[5], $argv[6]));
  
      } else if ($argv[1] === "2") {
  
        // �f�[�^�������̉񐔕��擾
        for ($i = 0; $i < $argv[4]; $i++) {
          $ret = $client->getValue("datasavekey_" . $i);
          if ($ret[0] === "true") {
            print_r($ret[1]);
            print_r("\r\n");
          } else {
            print_r("There is no data");
            print_r("\r\n");
          }
        }
      } else if ($argv[1] === "2.1") {
        // �w���Key�l�Ńf�[�^���擾
  
        $ret = $client->getValue($argv[4]);
        if ($ret[0] === "true") {
          print_r($ret[1]);
          print_r("\r\n");
        } else if ($ret[0] === "false") {
          print_r("There is no data");
          print_r("\r\n");
        }
      } else if ($argv[1] === "2.3") {
        // �w���Key�l�Ńf�[�^���擾
  
        $ret = $client->getValueScript($argv[4], $argv[5]);
        if ($ret[0] === "true") {
          print_r($ret[1]);
          print_r("\r\n");
        } else if ($ret[0] === "false") {
          print_r("There is no data");
          print_r("\r\n");
        }
      } else if ($argv[1] === "2.4") {
        // �w���Key�l�Ńf�[�^���擾
  
        $ret = $client->getValueScriptForUpdate($argv[4], $argv[5]);
        if ($ret[0] === "true") {
          print_r($ret[1]);
          print_r("\r\n");
        } else if ($ret[0] === "false") {
          print_r("There is no data");
          print_r("\r\n");
        }
      } else if ($argv[1] === "2.5") {
        // �w���Key�l�Ńf�[�^���擾
        // �L�������������I�ɍX�V����
        // �f�[�^��L�������t���œo�^
        if(!$client->setValue($argv[4], $argv[5], null, $argv[6])) {
  
          print_r("Regist Error");
        } else {
  
          sleep(intval($argv[6]) - 1);
          $ret = $client->getValueAndUpdateExpireTime($argv[4]);
          sleep(1);
          $ret = $client->getValue($argv[4]);
          if ($ret[0] === "false") {
            print_r("ExpireTimeUpdateGet Error");
            print_r($ret[1]);
            print_r("\r\n");
          } else if ($ret[0] === "true") {
            print_r("ExpireTimeUpdateGet OK");
            print_r("\r\n");
          }
        }
  
      } else if ($argv[1] === "2.6") {
          $client->setValue("key_multi_1", "val_multi_1");
          $client->setValue("key_multi_2", "val_multi_2");
          $client->setValue("key_multi_3", "val_multi_3");
          $client->setValue("key_multi_4", "val_multi_4");
          $client->setValue("key_multi_5", "val_multi_5");
  
          $getMKeyList1 = array();
          $getMKeyList1[] = "key_multi_1X";
          $getMKeyList1[] = "key_multi_5XY";

          var_dump($client->getMultiValue($getMKeyList1));
  
          $getMKeyList2 = array();
          $getMKeyList2[] = "key_multi_4";
          $getMKeyList2[] = "key_multi_3";
          var_dump($client->getMultiValue($getMKeyList2));
  
  
          $getMKeyList3 = array();
          $getMKeyList3[] = "key_multi_3";
          $getMKeyList3[] = "key_multi_aaa";
          $getMKeyList3[] = "key_multi_bbb";
          $getMKeyList3[] = "key_multi_ccc";
          var_dump($client->getMultiValue($getMKeyList3));
  
          $getMKeyList4 = array();
          $getMKeyList4[] = "key_multi_xxx";
          $getMKeyList4[] = "key_multi_aaa";
          $getMKeyList4[] = "key_multi_bbb";
          $getMKeyList4[] = "key_multi_ccc";
          var_dump($client->getMultiValue($getMKeyList4));
  
  
          $getMKeyList5 = array();
          $getMKeyList5[] = "key_multi_3";
          $getMKeyList5[] = "key_multi_aaa";
          $getMKeyList5[] = "key_multi_bbb";
          $getMKeyList5[] = "key_multi_ccc";
          $getMKeyList5[] = "key_multi_1";
          var_dump($client->getMultiValue($getMKeyList5));
  
  
          $getMKeyList6 = array();
          $getMKeyList6[] = "key_multi_1";
          $getMKeyList6[] = "";
          $getMKeyList6[] = "";
          $getMKeyList6[] = "";
          $getMKeyList6[] = "key_multi_";
          var_dump($client->getMultiValue($getMKeyList6));
      } else if ($argv[1] === "2.7") {
        // �w���Key�l��Object���擾
        // �L�������������I�ɍX�V����
        // �f�[�^��L�������t���œo�^
        $setObj4ExTime = array();
        $setObj4ExTime[] = "aaxx";
        $setObj4ExTime[] = "bbyy";
        $setObj4ExTime[] = array();
  
        if(!$client->setObjectValue($argv[4], $setObj4ExTime, null, $argv[5])) {
  
          print_r("Regist Error");
        } else {
  
          sleep(intval($argv[5]) - 1);
          $ret = $client->getObjectValueAndUpdateExpireTime($argv[4]);
          sleep(1);
          $ret = $client->getObjectValue($argv[4]);
          if ($ret[0] === "false") {
            print_r("ExpireTimeUpdateGet Error");
            print_r("\r\n");
            print_r($ret[1]);
            print_r("\r\n");
          } else if ($ret[0] === "true") {
            print_r("ExpireTimeUpdateGet OK");
            print_r("\r\n");
            var_dump($ret[1]);
            print_r("\r\n");
          }
        }
  
      } else if ($argv[1] === "3") {
  
        // �f�[�^�������̉񐔕��o�^(Tag��o�^)
        $counter = 0;
        for ($i = 0; $i < $argv[4]; $i++) {
          $tags = array();
          if ($counter === 0) {
            $tags[0] = "tag1";
            $counter++;
          } else if($counter === 1) {
            $tags[0] = "tag1";
            $tags[1] = "tag2";
            $counter++;
          } else if($counter === 2) {
            $tags[0] = "tag1";
            $tags[1] = "tag2";
            $tags[2] = "tag3";
            $counter++;
          } else if($counter === 3) {
            $tags[0] = "tag4";
            $counter++;
          } else if($counter === 4) {
            $tags[0] = "tag4";
            $tags[1] = "tag2";
            $counter = 0;
          }
          if(!$client->setValue("datasavekey_" . $i, "savedatavaluestr_" . $i, $tags)) {
            print_r("Registration failure");
          }
        }
      } else if ($argv[1] === "4") {
  
        // �f�[�^�������̉񐔕��擾(Tag�Ŏ擾)
        $counter = 0;
        if ($argv[5] === "true") {
          var_dump($client->getTagKeys($argv[4], true));
        } else if($argv[5] === "false") {
          var_dump($client->getTagKeys($argv[4], false));
        } else {
          var_dump($client->getTagKeys($argv[4]));
        }
  
      } else if ($argv[1] === "4.1"){
        // Tag���w�肵��Key-Value���擾
        $counter = 0;
        var_dump($client->getTagValues($argv[4]));
        var_dump($client->getTagValues($argv[4], "UTF-8"));
      } else if ($argv[1] === "4.2") {
  
        // Tag�𕡐��w�肵��AND��������OR�����Ń��X�g���擾
        $counter = 0;

        $tagList = array();
        $tagList[] = "tag1";
        $tagList[] = "tag2";
        $tagList[] = "tag3";
        $tagList[] = "tag4";
        var_dump($client->getMultiTagKeys($tagList, false));
        var_dump($client->getMultiTagKeys($tagList, true));
      } else if ($argv[1] === "4.3") {
  
        // Tag�𕡐��w�肵��AND��������OR�����Ń��X�g���擾
        $counter = 0;

        $tagList = array();
        $tagList[] = "tag1";
        $tagList[] = "tag2";
        $tagList[] = "tag4";
        var_dump($client->getMultiTagKeys($tagList, true));
        var_dump($client->getMultiTagKeys($tagList, false));
      } else if ($argv[1] === "4.4") {
  
        // Tag�𕡐��w�肵��AND��������OR�����Ń��X�g���擾
        $counter = 0;

        $tagList = array();
        $tagList[] = "tag1";
        $tagList[] = "tag2";
        $tagList[] = "tag3";
        var_dump($client->getMultiTagValues($tagList, true));
        var_dump($client->getMultiTagValues($tagList, false));
      } else if ($argv[1] === "7") {
  
        // �f�[�^�������̉񐔕��擾
        for ($i = 0; $i < $argv[4]; $i++) {
          $ret = $client->removeValue("datasavekey_" . $i);
          if ($ret[0] === "true") {
            // �폜����
            print_r($ret[1]);
            print_r("\r\n");
          } else if ($ret[0] === "false") {
            // Key�l�Ńf�[�^�Ȃ�
            print_r("There is no data");
            print_r("\r\n");
          } else if ($ret[0] === "error") {
            // �폜�����ŃG���[
            print_r($ret[1]);
            print_r("\r\n");
          }
        }
      } else if ($argv[1] === "8") {
  
        // ������Key�l�̃f�[�^���폜
        $ret = $client->removeValue($argv[4]);
        if ($ret[0] === "true") {
          // �폜����
          print_r($ret[1]);
          print_r("\r\n");
        } else if ($ret[0] === "false") {
          // Key�l�Ńf�[�^�Ȃ�
          print_r("There is no data");
          print_r("\r\n");
        } else if ($ret[0] === "error") {
          // �폜�����ŃG���[
          print_r($ret[1]);
          print_r("\r\n");
        }
      } else if ($argv[1] === "9") {
        if(!$client->startTransaction()) {
  
          print_r("Transaction Start Error !!");
          exit;
        }
        // ������Key�l�̃f�[�^���폜
  
        $ret = $client->lockData($argv[4], $argv[5], $argv[6]);
        if ($ret[0] === "true") {
          // Lock����
          print_r("Lock����");
          print_r("\r\n");
        } else if ($ret[0] === "false") {
          // Key�l�Ńf�[�^�Ȃ�
          print_r("Lock���s");
          print_r("\r\n");
          } else if ($ret[0] === "error") {
          // �폜�����ŃG���[
          print_r("Lock Error");
          print_r("\r\n");
        }
  
        // ���g�Ń��b�N���Ă���̂ōX�V�\
        if(!$client->setValue($argv[4], "LockDataPhp")) {
          print_r("Registration failure");
        }
  
        $ret = $client->getValue($argv[4]);
        if ($ret[0] === "true") {
          print_r($ret[1]);
          print_r("\r\n");
        } else {
          print_r("There is no data");
          print_r("\r\n");
        }
  
        // ���g�Ń��b�N���Ă���̂ō폜�\
        $ret = $client->removeValue($argv[4]);
        if ($ret[0] === "true") {
          // �폜����
          print_r("�폜 [" . $ret[1] . "]");
          print_r("\r\n");
        } else if ($ret[0] === "false") {
          // Key�l�Ńf�[�^�Ȃ�
          print_r("There is no data");
          print_r("\r\n");
        } else if ($ret[0] === "error") {
          // �폜�����ŃG���[
          print_r($ret[1]);
          print_r("\r\n");
        }
  
        $ret = $client->releaseLockData($argv[4]);
        var_dump($ret);
  
      } else if ($argv[1] === "10") {
        // �f�[�^�������̐V�K�o�^
        var_dump($client->setNewValue($argv[4], $argv[5]));
  
      } else if ($argv[1] === "10.1") {
        // �f�[�^�������̐V�K�o�^-�L����������
        var_dump($client->setNewValue($argv[4], $argv[5], null, $argv[6]));
        sleep($argv[6]);
        sleep(1);
        $ret = $client->getValue($argv[4]);
        if ($ret[0] === "true") {
          print_r("ExpireNewData Get Error");
          print_r($ret[1]);
          print_r("\r\n");
        } else if ($ret[0] === "false") {
          print_r("ExpireNewData Get OK");
          print_r("\r\n");
        }
      } else if ($argv[1] === "11") {
        // gets
        var_dump($client->getValueVersionCheck($argv[4]));
  
      } else if ($argv[1] === "12") {
        // cas
        var_dump($client->setValueVersionCheck($argv[4], $argv[5], null, $argv[6]));
  
      } else if ($argv[1] === "13") {
        // cas tag�t
        var_dump($client->setValueVersionCheck($argv[4], $argv[5], $argv[6], $argv[7]));
  
      } else if ($argv[1] === "20") {
  
        // incr
        var_dump($client->incrValue($argv[4], $argv[5]));
      } else if ($argv[1] === "21") {
  
        // decr
        var_dump($client->decrValue($argv[4], $argv[5]));
      } else if ($argv[1] === "22") {
  
        // Tag�폜
        var_dump($client->removeTagFromKey($argv[4], $argv[5]));
      } else if ($argv[1] === "23") {
        // Object�o�^
        $setObj = array();
        $setObj[0] = "";
        $setObj[1] = "aaa";
        $setObj[2] = "bbb";
        $setObj[3] = array();
  
        var_dump($client->setObjectValue($argv[4], $setObj));
      } else if ($argv[1] === "23.1") {
        // ObjectNew�o�^
        $setObj = array();
        $setObj[0] = "";
        $setObj[1] = "xxx";
        $setObj[2] = "yyy";
        $setObj[3] = array();
          var_dump($client->setNewObjectValue($argv[4], $setObj));
      } else if ($argv[1] === "24") {
        // Object�擾
        var_dump($client->getObjectValue($argv[4]));
      } else if ($argv[1] === "24.1") {
        // Object�擾
        var_dump($client->getObjectValue($argv[4]));
      }
  
  
  
  
      $client->close();
    } catch (Exception $e) {
      var_dump($e);
    }
  } else {
    print_r("Args Error!!");
  }
?>