rem �L�[�l�������ŃC���N�������g����10�o�^
php PhpTestSock.php 1 127.0.0.1 8888 100
rem �L�[�l��key_a�Ńo�����[�lvalue_b��o�^
php PhpTestSock.php 1.1 127.0.0.1 8888 key_a value_b
rem �L�[�l��key_a�Ńo�����[�lvalue_c��o�^-�L�������e�X�g
php PhpTestSock.php 1.2 127.0.0.1 8888 key_c value_c 3
rem �L�[�l�������ŃC���N�������g����10��value���擾
php PhpTestSock.php 2 127.0.0.1 8888 100
rem �L�[�l��key_a��value���擾
php PhpTestSock.php 2.1 127.0.0.1 8888 key_a
rem �L�[�l��key_a�Ŏ擾����value�ɑ΂���JavaScript�����s
php PhpTestSock.php 2.3 127.0.0.1 8888 key_a "var dataValue; var retValue = dataValue.replace('b', 'dummy'); var execRet = '1';"
rem �L�[�l��key_a�Ŏ擾����value�ɑ΂���JavaScript�����s
php PhpTestSock.php 2.4 127.0.0.1 8888 key_a "var dataValue; var dataKey; var retValue = dataValue.replace('b', 'dummy'); if(dataKey == 'key_a') {var execRet = '2'} else {var execRet = '1'}"
rem �L�[�l��key_a�Ńo�����[�lvalue_d��o�^-�L�������ݒ���s���ėL���������B�O�ɍX�V�ł̎擾
php PhpTestSock.php 2.5 127.0.0.1 8888 key_d value_d 3
rem �L�[�l�𕡐��w�肵��key��value�̏W�����擾
php PhpTestSock.php 2.6 127.0.0.1 8888
rem �L�[�l��key_obj�Ńo�����[�lObject��o�^-�L�������ݒ���s���ėL���������B�O�ɍX�V�ł̎擾
php PhpTestSock.php 2.7 127.0.0.1 8888 key_obj 3
rem Tag�l�������ŕς��āAKey��Value��10��o�^
php PhpTestSock.php 3 127.0.0.1 8888 100
rem Tag�l��tag1���w�肵�āAtag1�ɑ�����Key�l���擾(Key�l���ݎw��L��(true))
php PhpTestSock.php 4 127.0.0.1 8888 tag1 true
rem Tag�l��tag1���w�肵�āAtag1�ɑ�����Key�l���擾(Key�l���ݎw��L��(false))
php PhpTestSock.php 4 127.0.0.1 8888 tag1 false
rem Tag�l��tag1���w�肵�āAtag1�ɑ�����Key�l��Value
php PhpTestSock.php 4.1 127.0.0.1 8888 tag1
php PhpTestSock.php 4.2 127.0.0.1 8888
php PhpTestSock.php 4.3 127.0.0.1 8888
php PhpTestSock.php 4.4 127.0.0.1 8888
rem �L�[�l��key_a��Value���폜
php PhpTestSock.php 8 127.0.0.1 8888 key_a
rem ���U���b�N���g�p����
php PhpTestSock.php 9 127.0.0.1 8888 key_a 10 5
rem �l�̐V�K�o�^�������Ȃ�
php PhpTestSock.php 10 127.0.0.1 8888 newkey newvalue
rem get
php PhpTestSock.php 11 127.0.0.1 8888 newkey
rem �l�̐V�K�o�^�������Ȃ�-�L����������
php PhpTestSock.php 10.1 127.0.0.1 8888 newkeyT newvalueT 3
rem cas
php PhpTestSock.php 12 127.0.0.1 8888 newkey valuecas 0
rem cas Miss
php PhpTestSock.php 12 127.0.0.1 8888 newkey valuecas 1
rem cas Tag
php PhpTestSock.php 13 127.0.0.1 8888 newkey valuecas tag1 2
rem gets
php PhpTestSock.php 11 127.0.0.1 8888 newkey
rem incr
php PhpTestSock.php 20 127.0.0.1 8888 newkey 1
rem incr
php PhpTestSock.php 20 127.0.0.1 8888 newkey 109
rem decr
php PhpTestSock.php 21 127.0.0.1 8888 newkey 1
rem decr
php PhpTestSock.php 21 127.0.0.1 8888 newkey 109
rem removeTagFromkey
php PhpTestSock.php 22 127.0.0.1 8888 datasavekey_46 tag1
rem setObjectValue
php PhpTestSock.php 23 127.0.0.1 8888 objectKey1
rem getObjectValue
php PhpTestSock.php 24 127.0.0.1 8888 objectKey1
rem getObjectValue
php PhpTestSock.php 24 127.0.0.1 8888 objectKey2

rem setValueAndCreateIndex
php PhpTestSock.php 42 127.0.0.1 8888 1000
rem searchValue
php PhpTestSock.php 43 127.0.0.1 8888 "datavaluestr_716" 1 ""
rem setValueAndCreateIndex
php PhpTestSock.php 42.1 127.0.0.1 8888 1000 Prefix1
rem searchValue
php PhpTestSock.php 43.1 127.0.0.1 8888 "7" "716" 2 "Prefix1"
rem removeSearchIndex
php PhpTestSock.php 44 127.0.0.1 8888 "datavaluestr_716" 1 ""
rem MaxSizeTest
php PhpTestSock.php size-true 127.0.0.1 8888
rem MaxSizeOverTest
php PhpTestSock.php size-false 127.0.0.1 8888
rem setNewObjectValue
php PhpTestSock.php 23.1 127.0.0.1 8888 objectKeyNew1
rem getObjectValue
php PhpTestSock.php 24.1 127.0.0.1 8888 objectKeyNew1
