====== ���UKey-Value�X�g�A �uokuyama�v=====================================================
Java�Ŏ������ꂽ�A�i�����^���UKey-Value�X�g�A�uokuyama�v��
�_�E�����[�h�������肪�Ƃ��������܂��B

���N�����@��http://thinkit.co.jp/story/2011/02/17/2010�������������A
  �{�e�L�X�g�́u���@�\�����ƃT���v���̎��s���@�v���������������B
  blog:http://d.hatena.ne.jp/okuyamaoo/


  �Eokuyama�Ɋւ��鎷�M�L��
    [Think IT] "���UKVS�uokuyama�v�̑S�e"
    ��1�� NOSQL�́u�m�鎞��v����u�g������v�� http://thinkit.co.jp/story/2011/02/03/1990
    ��2�� NOSQL�̐V��A���UKVS�uokuyama�v�̋@�\ http://thinkit.co.jp/story/2011/02/10/2002
    ��3�� ���UKVS�uokuyama�v�̃C���X�g�[�� http://thinkit.co.jp/story/2011/02/17/2010
    ��4�� ���UKVS�uokuyama�v�̊��p�m�E�n�E http://thinkit.co.jp/story/2011/02/24/2026

    [Think IT] "���UKVS�uokuyama�v���HTIPS"
    ��1�� okuyama�𓱓�����܂łɒm���Ă��������T�[�o���\�[�X�Ƃ�4�̊֌W http://thinkit.co.jp/story/2011/10/12/2303
    ��2�� okuyama���^�p���邽�߂ɒm���Ă���������{�I�ȑ��� http://thinkit.co.jp/story/2011/10/26/2316
    ��3�� okuyama�ł̃A�v���J���ŉ������Ă��������@�\ 



�E���C����
========================================================================================================
[New - �V�@�\�ǉ��A�s��Ή�]
[[�����[�X Ver 0.9.1 - (2011/12/19)]]

�EPHP�ł�OkuyamaClient�̕s��Ή�
  �EKey�AValue�ATag�̓o�^�O�T�C�Y�`�F�b�N����̏C��
    �o�^�\��Key����сATag�̃o�C�g����320byte�ɌŒ�
    PhpTestSock.php�Ƀe�X�g�R�[�h��ǉ�
    �e�X�g����size-true��size-false�ƂȂ�
  �EOkuyamaClient.class.php�̑O��o�[�W������71�s�ڂ̍\�����s�v�Ȃ��ߍ폜
  �EOkuyamaClient.class.php�̑O��o�[�W������113�s��unset�ςݕϐ��ւ̎Q�Ƃ̍\�����C��
    isset�֐��ɒu������


�EJava�p��OkuyamaClient���v�[�����O����R�l�N�V�����v�[����ǉ�
  �{�@�\�𗘗p����Ɛڑ������A�ڑ��ς�OkuyamaClient�̃v�[���A�N���[�Y�����̊Ǘ����s�����Ƃ��o����
  �ڑ��ς݂̃R�l�N�V�����𑦗��p�\�Ȃ��߁A�ڑ������̃R�X�g�팸�A�ڑ������̋��ʉ����s�����Ƃ��\
  �Y���N���X�͈ȉ�
  �Eokuyama.imdst.client.OkuyamaClientFactory
  (���p���@)
   -------------------------------------------------------------------------------------------------------
   // MasterNode�̐ڑ������쐬���āAOkuyamaClientFactory.getFactory�ɓn�����ƂŃR�l�N�V�����v�[�����擾
   // �����Ŏ擾�����C���X�^���X�̓V���O���g���ƂȂ�S�ẴX���b�h�ŗB��ƂȂ�
   // �X���b�h���ɐV����Factory�𗘗p�������ꍇ��getNewFactory���\�b�h�𗘗p����
   String[] masterNodes = {"192.168.1.1:8888","192.168.1.2:8888"};
   OkuyamaClientFactory factory = OkuyamaClientFactory.getFactory(masterNodes, 20);

   // �v�[������Client���擾
   OkuyamaClient okuyamaClient = factory.getClient();

   // �ȍ~�͒ʏ��OkuyamaClient�̗��p���@�Ɠ��l
   String[] getResult = okuyamaClient.getValue("Key-XXXX");
   if (getResult[0].equals("true")) {
       System.out.println(getResult[1]);
   }

   // close()���Ăяo�����ƂŃR�l�N�V�����v�[���ɕԋp�����
   okuyamaClient.close();

   // �A�v���P�[�V�������̂��̂��I������ۂ͈ȉ���Factory���I�������đS�ẴR�l�N�V������j������
   // �I������ēxgetFactory���Ăяo���ΐV����factory���Đ��������
   factory.shutdown();
   -------------------------------------------------------------------------------------------------------


�EUtilClient��adddatanode��ǉ�
  DataNode��ǉ�����ۂɏ]����Web�̊Ǘ���ʂ��炵���ǉ��ł��Ȃ��������A
  UtilClient����ǉ�����@�\��ǉ�
  ���{�@�\�ɂ��okuyama�̃T�[�o���̕ύX�͕K�v����܂���B
  �g����)
  $ java -classpath ./:./lib/javamail-1.4.1.jar:./okuyama-0.9.1.jar okuyama.imdst.client.UtilClient adddatanode masternode:8888 datanode02:5555 slavedatanode:02:6555 thirddatanode:7555
  ��������
  1)adddatanode : �ǉ�����
  2)masternode:8888 : �ǉ����˗�����MasterNode�̃A�h���X��Port�ԍ�
  3)datanode02:5555 : �ǉ����˗�����DataNode�̃A�h���X��Port�ԍ�(MasterNode.properties��KeyMapNodesInfo�̐ݒ�ɊY��)
  4)slavedatanode:6555 : �ǉ����˗�����DataNode�̃A�h���X��Port�ԍ�(MasterNode.properties��SubKeyMapNodesInfo�̐ݒ�ɊY���B�ݒ���s���Ă��Ȃ��ꍇ�͏ȗ�)
  5)thirddatanode:7555 : �ǉ����˗�����DataNode�̃A�h���X��Port�ԍ�(MasterNode.properties��ThirdKeyMapNodesInfo�̐ݒ�ɊY���B�ݒ���s���Ă��Ȃ��ꍇ�͏ȗ�)


�EDataNode�̊��S�f�B�X�N���[�h�̐��\������
  �t�@�C���ւ̏����o���Ƀ������ł̃o�b�t�@�����O�̈��݂�������ւ̏����o���������������_�Ń��[�U������
  �����Ƃ��邱�Ƃŉ������x����B���ۂ̏����o�������͕ʃX���b�h�ŏ����s����B


�EMasterNode��Isolation�@�\(�p�[�e�B�V�����@�\)���p����getTagKeysResult�AgetMultiTagKeysResult�Ŕ�������
  �s��ɑΉ�


�E�N���p�����[�^���ȉ��̒ʂ�ǉ�
  DataNode�p�̋N���p�����[�^
   -vidf �L�q�Ftrue/false
         �����F�L�������؂�̃f�[�^�̃N���[�j���O���s�����ǂ����̐ݒ� true=�s�� false=�s��Ȃ� 
               �L�������t���̃f�[�^��o�^���Ȃ��ꍇ��false�ɂ��邱�ƂŃN���[�j���O�f�[�^�̃`�F�b�N��
               �������镉�ׂ����炷���Ƃ��o����
               true=���[�j���O���s���Afalse=���[�j���O���s��Ȃ�
               �f�t�B���g��Value���������̏ꍇ��true�AValue���f�B�X�N�̏ꍇ��false
               ��true���w�肷��ƃt�@�C�����X�g���[�W�Ɏg���Ă���ꍇ�����s�����
         �ݒ��F -vidf false

   -svic �L�q�F����(��/�P��)
         �����F�L�������؂�̃f�[�^�̃N���[�j���O���s�����ԊԊu�B�Z���Ԋu���w�肷��ƁA�N���[�j���O�f�[�^�̃`�F�b�N��
               �p�ɂɔ������邽�ߕ��ׂ�������B�傫������l���w�肷��ƗL�������؂�̃f�[�^�����܂ł��A�N�Z�X
               �s�̏�Ԃŕێ�����邽�߃X�g���[�W�̈�𖳑ʂɂ��Ă��܂��܂��B               
               �f�t�B���g��30��
         �ݒ��F -svic 60

   -csf �L�q�Ftrue/false
        �����F�ۑ��f�[�^�̍��v�T�C�Y���v�Z���邩�ǂ����̎w��
              �ۑ��e�ʂ��v�Z����K�v���Ȃ��ꍇ��false�ɂ��邱�Ƃœo�^�E�폜���̕��ׂ��y���ł���B
              �ۑ��e�ʂƂ�MasterNode��KeyNodeWatchHelper.log�Ȃǂŏo�͂���Ă���A"Save Data Size"���ڂȂǂɓ�����܂��B
              true=�v�Z����Afalse=�v�Z���Ȃ�
              �f�t�B���g��true
        �ݒ��F -csf false

   -rdvp �L�q�Ftrue/false
         �����FKey�AValue���Ƀf�B�X�N�𗘗p�����ۂ�Value�̍X�V���ɍX�V�O�̃f�[�^�t�@�C�����Value�̏ꏊ���ė��p����
               �ĕۑ����邩�̐ݒ�B
               �ė��p����ꍇ�͓o�^�ς�Value�̍ĕۑ����s���ƍX�V�O�̃f�B�X�N��̏ꏊ�𗘗p���邽�߁A�X�V�ɂ��f�B�X�N�g�p�ʂ�
               �����͂���܂���B�������f�B�X�N�ւ̃A�N�Z�X�͊�����Value�̈ʒu�փf�B�X�N���V�[�N���Ă���ۑ����s�����߃f�B�X�N�ւ�
               ���ׂ������Ȃ�܂��B
               �ė��p���Ȃ��ꍇ�͊�����Value�ł����Ă���ɍŐV��Value���f�B�X�N�̍Ō���ɏ����������߁A�f�B�X�N�ւ̃A�N�Z�X��
               �V�[�P���V����(�����)�ȃA�N�Z�X�ɂȂ�f�B�X�N���ׂ͏��Ȃ��Ȃ�܂��B������������Value�ւ̍X�V�ł����Ă�
               �f�B�X�N�g�p�ʂ��������܂��B
               �f�t�B���g��true
        �ݒ��F -rdvp false

   -dwmqs �L�q�F����(�o�b�t�@�����O����/�P��)
         �����FDataNode�̊��S�f�B�X�N���[�h���Ƀ������̃o�b�t�@�����O��Ԃ̒~�ςł��錏���B�ő�l��20���B
         �ő傱���Őݒ肵����������Key��+10byte���̃������e�ʂ𗘗p���邽�߁A�傫�Ȓl�ɂ���ꍇ�͒��ӂ�
         �K�v�ƂȂ�BDefault�̒l��7000�B
        �ݒ��F -dwmqs 15000


�EDataNode.properties��DataSaveTransactionFileEveryCommit=false���̕s���Ή�


========================================================================================================
[New - �V�@�\�ǉ��A�s��Ή�]
[[�����[�X Ver 0.9.0 - (2011/10/21)]]
��Hadoop�Ή�
  !!! [����] �{�@�\�̓x�[�^�@�\�ł��� !!!
  Hadoop�̎���Format�C���^�[�t�F�[�X�𗘗p����MapReduce����okuyama�ɓo�^����Ă���f�[�^�����o����
  ���p�ł���悤�ɂ��܂����B
  �ڂ�����hadoop�f�B���N�g���z����ReadMe.txt���Q�Ƃ��Ă��������B


��OkuyamaClient�ւ�getMultiTagKeys���\�b�h�̒ǉ�
  ������Tag���w�肵�āA�Y������Key�̂ݎ擾�\�ȃ��\�b�h��ǉ����܂����B
  Key�̂ݎ擾�ł���̂ŁA�N���C�A���g���̃��������p�ʂ̍팸���\�ł��B
  �܂�getMultiTagValues�ɔ�ׂč����ɉ�����Ԃ��܂��B
  [OkuyamaClient�ł̃��\�b�h]
  public String[] getMultiTagKeys(String[] tagList) throws OkuyamaClientException;
  public String[] getMultiTagKeys(String[] tagList, boolean margeType) throws OkuyamaClientException;
  public String[] getMultiTagKeys(String[] tagList, boolean margeType, boolean noExistsData) throws OkuyamaClientException;


��OkuyamaClient�ւ�getTagKeysResult���\�b�h�̒ǉ�
  �{���\�b�h�̋�����getTagKeys�Ɠ��l��Tag���w�肷�邱�ƂŁA�R�t���S�Ă�Key���擾����B�������AgetTagKeys��
  ��x��String�^�̔z��ŕR�t���S�Ă�Key�l��Ԃ��Ă���̂ɑ΂��āA�{���\�b�h��okuyama.imdst.client.OkuyamaResultSet��
  �ԋp���Ă���BOkuyamaResultSet��java.sql.ResultSet�̂悤�ɏ����f�[�^�����o����悤�ɂȂ��Ă���A
  �]����getTagKeys�ł͈����Ȃ��悤�ȑ�ʂ�Key�l����������ꍇ�ɗ��p����B
  �ȉ��̎������Tag�ɕR�t���S�Ă�Key��Value���o�͂��Ă����ł��B
  ��) "Tag1"�ɕR�t���S�Ă�Key��Value���o��
  ----------------------------------------------------------------------
	OkuyamaResultSet resultSet = client.getTagKeysResult("Tag1"); // OkuyamaResultSet�C���^�[�t�F�[�X�Ō��ʂ��󂯎��

	while(resultSet.next()) {  // �J�[�\�����ړ����Ȃ���l�̗L�����m�F true��Ԃ��ė����ꍇ�͏I�[�ł͂Ȃ��Afalse�͏I�[
		System.out.println("Key=" + (Object)resultSet.getKey());     // getKey���\�b�h�ɂČ��݂̃J�[�\���ʒu��Key�l���擾
		System.out.println("Value=" + (Object)resultSet.getValue()); // getValue���\�b�h�ɂČ��݂̃J�[�\���ʒu��Value�l���擾
	}
	resultSet.close();
  ----------------------------------------------------------------------
  �Ȃ��AgetTagKeysResult�͎擾����Key��Value�ɑ΂��ăt�B���^�����O��ݒ肷�邱�Ƃ��\�ł���B
  �t�B���^�����O��
   1.���l�ł�Key��Value�ɑ΂��Ă͈͎̔w��
   2.���K�\���ł�Key��Value�ɑ΂��Ă̈�v�w��
   3.���[�U���s�N���X�ɂ��Ǝ��t�B���^�����O(�t�B���^�����O�N���X�́Aokuyama.imdst.client.UserDataFilter�C���^�[�t�F�[�X����������)
  ���\�ł���B
  [OkuyamaClient�ł̃��\�b�h]
  public OkuyamaResultSet getTagKeysResult(String tagStr) throws OkuyamaClientException;
  public OkuyamaResultSet getTagKeysResult(String tagStr, String encoding) throws OkuyamaClientException;
  public OkuyamaResultSet getTagKeysResult(String tagStr, String matchPattern, int cehckType) throws OkuyamaClientException;
  public OkuyamaResultSet getTagKeysResult(String tagStr, String matchPattern, int cehckType, String encoding) throws OkuyamaClientException;
  public OkuyamaResultSet getTagKeysResult(String tagStr, double[] targetRange, int cehckType) throws OkuyamaClientException;
  public OkuyamaResultSet getTagKeysResult(String tagStr, double[] targetRange, int cehckType, String encoding) throws OkuyamaClientException;
  public OkuyamaResultSet getTagKeysResult(String tagStr, UserDataFilter filter) throws OkuyamaClientException;
  public OkuyamaResultSet getTagKeysResult(String tagStr, UserDataFilter filter, String encoding) throws OkuyamaClientException;
  ��!!����!! 1.PHP�̃N���C�A���g�͖��Ή�
             2.�{���\�b�h�𗘗p���邽�߂ɂ́Aokuyama��MasterNode�ADataNode���ɁAVersion-0.9.0�ȏ�ł���K�v������
             3.OkuyamaResultSet�̏ڂ������p���@�́AJavaDoc��okuyama.imdst.client.OkuyamaResultSet�̕������Q�Ƃ��Ă�������


��OkuyamaClient�ւ�getMultiTagKeysResult���\�b�h�̒ǉ�
  �{���\�b�h�̋�����getMultiTagKeys�Ɠ��l�ɕ���Tag���w�肷�邱�ƂŁA�R�t���S�Ă�Key���擾���邱�Ƃ��\�ł��邪�A
  getTagKeysResult�Ɠ��l�ɁAokuyama.imdst.client.OkuyamaResultSet����f�[�^�����o�����Ƃ��\�ł��邽�߁A��ʂ�
  �f�[�^�擾�ɗ��p����BgetTagKeysResult�ƈႢ�A�l�̃t�B���^�����O�����邱�Ƃ͏o���Ȃ��B
  [OkuyamaClient�ł̃��\�b�h]
  public OkuyamaResultSet getMultiTagKeysResult(String[] tagList) throws OkuyamaClientException;
  public OkuyamaResultSet getMultiTagKeysResult(String[] tagList, boolean margeType) throws OkuyamaClientException;
  ��!!����!! 1.PHP�̃N���C�A���g�͖��Ή�
             2.�{���\�b�h�𗘗p���邽�߂ɂ́Aokuyama��MasterNode�ADataNode���ɁAVersion-0.9.0�ȏ�ł���K�v������
             3.OkuyamaResultSet�̏ڂ������p���@�́AJavaDoc��okuyama.imdst.client.OkuyamaResultSet�̕������Q�Ƃ��Ă�������


��PHP�ł�OkuyamaClient.class.php�Ŗ������������ȉ��̃��\�b�h�������B������Java�łƓ��l�ł���
  1.getMultiValue
  2.removeSearchIndex
  3.getValueAndUpdateExpireTime
  4.setValue��setNewValue�ւ̗L������(ExpireTime)�Ή�
  5.setObjectValue
  6.getObjectValue
  7.getObjectValueAndUpdateExpireTime
  8.getOkuyamaVersion

  ���ȉ��̃��\�b�h�͖�����
    getTagValues
    getMultiTagValues
    getMultiTagKeys
    getTagKeysResult
    getMultiTagKeysResult


��OkuyamaQueueClient�̎���
  !!! [����] �{�@�\�̓x�[�^�@�\�ł��� !!!
  okuyama���L���[�Ƃ��ė��p�ł����p��Java�N���C�A���g��ǉ�
  �N���C�A���g���Fokuyama.imdst.client.OkuyamaQueueClient
  �L���[�Ƃ��ė��p����ꍇ��okuyama�̃T�[�o���͓��ɐݒ�͕K�v�Ȃ��A�ʏ�Ɠ����悤�ɋN�����邾���ŗǂ��B
  OkuyamaQueueClient�̗��p�菇��
   1.MasterNode�֐ڑ�
   2.createQueueSpace���\�b�h�ŔC�ӂ̖��O��Queue�̈���쐬(���ɍ쐬�ς݂�Queue�̈�𗘗p����ꍇ�͍쐬�s�v)
   3.put���\�b�h�ɂăf�[�^��o�^�A��������take���\�b�h�ɂĎ��o��
   4.���p�I����close���Ăяo��
  �ƂȂ�B�ڂ�����JavaDoc��okuyama.imdst.client.OkuyamaQueueClient�̕������Q�Ƃ��Ă��������B


��OkuyamaClient�ւ�getObjectValueAndUpdateExpireTime���\�b�h�̒ǉ�
  getValueAndUpdateExpireTime��Object�łɂȂ�B�擾�Ɠ����ɗL���������ݒ肳��Ă���ꍇ�͐ݒ肵���L������
  �b�������L�����������������BWeb�ł�session�I�u�W�F�N�g�Ȃǂ́A�A�N�Z�X����x�ɗL�����������΂�����
  �l�ɗ��p����ƕ֗��ł���B
  [OkuyamaClient�ł̃��\�b�h]
  public Object[] getObjectValueAndUpdateExpireTime(String keyStr) throws OkuyamaClientException;
  ��PHP�ł̃N���C�A���g���Ή��ς݁B


���������̏������\����ƕs��̏C��


========================================================================================================
[New - �V�@�\�ǉ��A�s��Ή�]
[[�����[�X Ver 0.8.9 - (2011/08/31)]]

��OkuyamaClient��setObjectValue��getObjectValue���\�b�h��ǉ�
  Java�ŃN���X��Serializable��implements���Ă���N���X�̃I�u�W�F�N�g�����̂܂ܓo�^�A
  �擾�o���郁�\�b�h��ǉ�
  ���\�b�h�͈ȉ�
   �ESet���\�b�h
     boolean setObjectValue(String keyStr, Object objValue)
     boolean setObjectValue(String keyStr, String[] tagStrs, Object objValue)
     boolean setObjectValue(String keyStr, Object objValue, Integer expireTime)
     boolean setObjectValue(String keyStr, String[] tagStrs, Object objValue, Integer expireTime) 
    �ԋp�l��boolean��true�̏ꍇ�͓o�^�����Afalse�̏ꍇ�͓o�^���s

   �EGet���\�b�h
     Object[] getObjectValue(String keyStr)
    �ԋp�l��Object�z��̗v�f��
    Object[0] = �v�f1 �f�[�^�L��(String�^) : "true"=�f�[�^�L or "false"=�f�[�^��
    Object[1] = �v�f2 �擾�f�[�^(Object�^) : �f�[�^�L����"false"�̏ꍇ�̂݃G���[���b�Z�[�W������(String�^�Œ�))����ȊO�́A�o�^����Object


���g�����U�N�V�������O(WAL���O)�̃f�B�X�N�ւ�fsync�̕p�x�𒲐��\��
  �g�����U�N�V�������O�̃f�B�X�N�ւ�fsync�͏]��OS�C�����������A�p�x�𒲐��\�ɕύX
  ImdstDefine.transactionLogFsyncType�̒l��ύX���邩�ADataNode�̋N��������"tlft"�t�����W����
  �w�肷�邱�ƂŕύX�\�B�W���̐����͈ȉ�
   0=OS�C��
   1=fsync�p�x��
   2=fsync�p�x��
   3=fsync�p�x��
   4=�g�����U�N�V�������O�������ݖ���fsync(�f�[�^�ւ̕ύX����)

   DataNode�N����)
    java -cp ./classes;./lib/log4j-1.2.14.jar;./lib/javamail-1.4.1.jar;./lib/commons-codec-1.4.jar -Xmx128m -Xms128m okuyama.base.JavaMain /Main.properties /DataNode.properties -tlft 4

��memcached�ł����Ƃ����flush_all�ɑΉ�
  UtilClient�ɂ��f�[�^�̑S�폜���s�����Ƃ��ł������A�����memcached�N���C�A���g��flush_all�֕R�t��
  memcahced�N���C�A���g���ڑ����Ă���MasterNode�̒S������Isolation�̃f�[�^��S�폜�ł���B
  Isolation�������Ă��Ȃ�MasterNode�̏ꍇ�͎��s����


��Data�t�@�C���ւ̃A�N�Z�X���������B
  �����f�[�^��Update�ɑ΂�������������{


���������̏������\����ƕs��̏C��
  �E�����R�[�h�������ɂ�鏈�����x����
  �Ememcached���[�h��MasterNode���N�������ꍇ��delete���\�b�h�œ���̃N���C�A���g��key�ȊO�Ƀp�����[�^��
    �]�����Ă��邽�߁A���̍ۃG���[�ɂȂ��Ă������ߏC��
  �E�m�[�h���I�ǉ�����MainMasterNode�ȊO��MasterNode�Ŕ�������f�[�^���擾�o���Ȃ��s��ɑΉ�
  �E�S���������ɁAIsolation���p����MasterNode�ɑ΂��āA2�����Ȃǂ̒Z��������Ō���Index���쐬�����ꍇ��
    �����ΏۂɂȂ�Ȃ��s��ɑΉ�



========================================================================================================
[New - �V�@�\�ǉ��A�s��Ή�]
[[�����[�X Ver 0.8.8 - (2011/07/3)]]

���X�g���[�W�@�\��SerializeMap��ǉ�
  �f�[�^�i�[���Ƀ�������Ԃ�L�����p����SerializeMap�Ƃ����@�\��ǉ��B
  �f�[�^���i�[����Map�ɓo�^����Key��Value��(�f)�V���A���C�U�O�����玩�R�Ɏw��ł���悤�ɋ@�\�ǉ�
  �ڂ����͈ȉ���Blog���Q��
  http://d.hatena.ne.jp/okuyamaoo/20110616
  http://d.hatena.ne.jp/okuyamaoo/20110623

  �ݒ��DataNode.properties�Ɉȉ��̍��ڂ��ǉ����ꂽ
  "DataSaveMapType"
  "SerializerClassName"

  "DataSaveMapType"��SerializeMap�̗��p���w��
  "SerializerClassName"��(�f)�V���A���C�U�̃N���X���w��
  SerializerClassName�Ŏw�肷��N���X��okuyama.imdst.util.serializemap.ISerializer���C���v�������c����
  �ݒ�Ȃ��́AConcurrentHashMap�𗘗p����BDefault��ConcurrentHashMap

  �ݒ���@)
  DataSaveMapType=serialize
  SerializerClassName=okuyama.imdst.util.serializemap.ObjectStreamSerializer
  ObjectStreamSerializer�͌��ݎ����ς݂�(�f)�V���A���C�U�N���X�B�����[�X���ɓ����B
  ����L��SerializeMap������ŗ��p

  DataSaveMapType=
  SerializerClassName=
  ����L�Œʏ��ConcurrentHashMap������ŗ��p



��okuyama�N���C�A���g������L��������ݒ�\��
  OkuyamaClient��setValue�y�сAsetNewValue��expireTime��n�����ƂŗL������(�P�ʂ͕b)��ݒ�\
  ������Ԃ́AInteger�̌��E�l
  ��)
  okuyamaClient.setValue("Key_XXX", "Value_YYY", new Integer(300));
  ��L�̏ꍇ�L��������300�b


���f�[�^�擾�Ɠ����ɂ��̃f�[�^�ɐݒ肳��Ă���L��������o�^���ɐݒ肵���������������郁�\�b�h��
  okuyama�N���C�A���g�ɒǉ��B
  ���\�b�h����getValueAndUpdateExpireTime
  ���L���������ݒ肳���Ă��Ȃ��f�[�^�͉����N����Ȃ�
  ��)
  okuyamaClient.setValue("Key_XXX", "Value_YYY", new Integer(300));
  String[] getResult = okuyamaClient.getValueAndUpdateExpireTime("Key_XXX");
  ����L��setValue���ɐݒ肳�ꂽ300�b�Ƃ����L���������AgetValueAndUpdateExpireTime�Ăяo�����ɍēx300�b��
    �����I�ɉ��������B


������Tag���w�肵�ĕR�t��Key��Value���擾����@�\��ǉ�
  okuyama�N���C�A���g�ł́AgetMultiTagValues

  �擾���@�𕡐���Tag���S�ĂɕR�t���Ă���AND�ƁA�ǂꂩ�ɂ����R�t��OR���w��ł���B
  �ԋp�����`����Map�ƂȂ�AKey��Value�̃Z�b�g�ɂȂ�B
  ���̂��߁A������Tag�ɕR�t���Ă���Key�͑��˂���B
  ��)
   String[] getTags = {"Tag1","Tag2","Tag3"};
   Map retAndMap = okuyamaClient.getMultiTagValues(getTags, true) //<=AND�w��
   Map retOrMap = okuyamaClient.getMultiTagValues(getTags, false) //<=OR�w��


���f�[�^�ꊇ�폜�@�\��ǉ�
  Isolation�P�ʂ������͑S�Ẵf�[�^���ꊇ�ō폜����@�\��okuyama.imdst.client.UtilClient�ɒǉ�
  ���p���@�͈ȉ�
  ���p���@)
  java -classpath ./:./classes okuyama.imdst.client.UtilClient truncatedata 192.168.1.1 8888 all
  ��1���� = 'truncatedata' <=�Œ�
  ��2���� = '192.168.1.1'  <=MainMasterNode��IP�A�h���X
  ��3���� = '8888'         <=MainMasterNode�̋N���|�[�g�ԍ�
  ��4���� = 'all'          <=�S�Ă̍폜���w�肷��'all'�������͍폜����IsolationPrefix��


�����݂�MasterNode���w�肵�Ă���MasterNode�����݂ǂ̂悤�Ȑݒ���ŉғ����Ă��邩���擾����@�\��UtilClient�ɒǉ�
   ���p���@)
   java -classpath ./:./classes okuyama.imdst.client.UtilClient masterconfig 192.168.1.1 8888
   ��1���� = 'masterconfig' <=�Œ�
   ��2���� = '192.168.1.1'  <=MainMasterNode��IP�A�h���X
   ��3���� = '8888'         <=MainMasterNode�̋N���|�[�g�ԍ�
   ���o�͗�)
   998,true,MainMasterNode=[true]- MyInfo=[127.0.0.1:8888]- MainMasterNodeInfo=[127.0.0.1:8888]- AllMasterNodeInfo=[127.0.0.1:8888 127.0.0.1:8889 127.0.0.1:11211]- 
   CheckMasterNodeTargetInfo=[]- Algorithm [0]:mod [1]:consistenthash=[1]- AllDataNodeInfo=[{third=[localhost:7553  localhost:7554]  sub=[localhost:6553  localhost:6554]  
   main=[localhost:5553  localhost:5554]}]


���������̏������\����ƕs��̏C��
   1.Key-Value�̗����������͂ǂ��炩���������ɓW�J����ꍇ�Ƀf�[�^��o�^��������ƃ��������g�������錻�ۂ����P�B
   2.MasterNode�̕s���ȌĂяo���ԍ�(�v���g�R���̐擪)��n�����ꍇ�ɉ������Ȃ��Ȃ��Ă��܂���������
   
========================================================================================================
[New - �����[�X�t�@�C���s��]
[[�����[�X Ver 0.8.7.2 - (2011/05/12)]]
�������[�X���ɋ��keymapfile�f�B���N�g���𓯍����Y�ꂽ���߁A�ǉ�
  ant�Ŏ��s�����ꍇ�ȂǂɃG���[�ɂȂ邽�߁B

��install�f�B���N�g������bin�f�B���N�g���ɔz�u����Ă���N���X�N���v�g��okuyama���̋L�q������Ă��邽�߂ɏC��
  �C�����e�̓N���X�p�X��ʂ��Ă���okuyama��jar�t�@�C�����Aokuyama-0.8.6.jar�ɂȂ��Ă������߁A�����
  okuyama-0.8.7.jar�ɕύX

========================================================================================================
[New - �V�@�\�ǉ��A�s��Ή�]
[[�����[�X Ver 0.8.7 - (2011/04/20)]]
  ���������ւ̃f�[�^�ۑ����Ɉ��k���s��
	���̐ݒ��DataNode.properties��"dataMemory=true"�̏ꍇ�̂ݗL��
	true=���k�Afalse=�񈳏k
	���k���s����CPU�����𗘗p���邽�߈��k���ʂ��]�߂Ȃ��f�[�^��ۑ�����ꍇ��false���L��
	�ݒ肵�Ȃ��ꍇ�̃f�t�H���g��true
	SaveDataCompressType�͈��k�w��@1 or 9�̂ǂ��炩���w��
	1=�����Œሳ�k
	9=�ᑬ�ō����k
	�ݒ肵�Ȃ��ꍇ�̃f�t�H���g��1

    DataNode.properties�ł̐ݒ�́A�ȉ��̍���
	SaveDataCompress=true
	SaveDataCompressType=1


  ���f�[�^�g�����U�N�V�������O�t�@�C���x���������݋@�\
	���̐ݒ��DataNode.properties��"memoryMode=false"�̏ꍇ�̂ݗL��
	!!false�ɐݒ肵���ꍇ�͏�ɏ������܂�Ȃ����߁A�s�ӂ̏�Q���Ƀf�[�^�����X�g����\�����オ��!!
    �ݒ�l��"true"�x�����Ȃ�(��ɏ�������)
    �ݒ�l��"false"�x������
	�ݒ肵�Ȃ��ꍇ�̃f�t�H���g��true
	���̐ݒ�͖{�ݒ�t�@�C����Œ�`����Ă���DataNode�S�Ăɔ��f�����

    DataNode.properties�ł̐ݒ�́A�ȉ��̍���
	DataSaveTransactionFileEveryCommit=true


  �����L�f�[�^�t�@�C���ւ̕ύX�������݂̃^�C�~���O�ݒ� ###
	 ���̐ݒ��"dataMemory=false"�̏ꍇ�̂ݗL��
	 true�ɂ����ꍇ�͋��L�f�[�^�t�@�C���ւ̕ύX(�f�B�X�N��������)�𑦎��f�B�X�N�ɔ��f����̂ł͂Ȃ��ʃX���b�h�Ő����s��
	 �������݂��s����܂Ń�������ɕێ������̂Ń������������B���̍ő发�����݃v�[����(�f�[�^��)��ݒ肷��̂��A
	 ShareDataFileMaxDelayCount(���l���w�肷��)�ł��邱���Őݒ肵�����l�̍ő�12888�{�̃o�C�g�����������������
	 �ő�x���ێ�����999999(���̐������~�ς���O�Ƀ�����������Ȃ��Ȃ�ꍇ������)
	 �ݒ肵�Ȃ��ꍇ�̃f�t�H���g��false

    DataNode.properties�ł̐ݒ�́A�ȉ��̍���
	ShareDataFileWriteDelayFlg=true
	ShareDataFileMaxDelayCount=


  ��ServerController�ɃR�}���h�̎�ޒǉ�
     �T�[�o�R���g���[���R�}���h��ǉ�

     �ǉ������@�\�͈ȉ�
     "-help" : �S�R�}���h�ꗗ�o��
     "netdebug" : debug�o�͂����݂̃R���\�[���ɏo�͂���B���s���M�Œ�~
     "fullgc" : gc�w��


  �����z�������̌�����
    ���z��������1�u���b�N������̃T�C�Y�𕡐��̎�ނɂ��āA�ۑ������T�C�Y�ɍ��킹�Ďg��������悤�ɕύX


  ��Value���������ɕۑ�����ꍇ�ɐݒ肵���T�C�Y�ȏ��Value�����z��������Ԃɕۑ�����@�\��ǉ�
    �傫��Value�l���������ɕێ��������Ȃ��ꍇ�ɗL��
    DataNode.properties�̈ȉ��̐ݒ�l(SaveDataMemoryStoreLimitSize)
    �f�t�H���g��"0"����(�T�C�Y�����Ȃ��Ƀ������ɕێ�����)

    DataNode.properties�ł̐ݒ�́A�ȉ��̍���
    SaveDataMemoryStoreLimitSize=0

    ���ݒ肷��T�C�Y�̓o�C�g�l
    ��)�ȉ��̏ꍇ��128KB�ȏ�
    SaveDataMemoryStoreLimitSize=131072


  ���f�[�^�o�b�N�A�b�v�@�\��ǉ�
    okuyama.imdst.client.UtilClient���쐬���A���s���_�ł�DataNode�̃f�[�^���o�b�N�A�b�v�ł���悤�ɋ@�\�ǉ�
    ���̋@�\�ō쐬�����t�@�C����DataNode.properties��KeyManagerJob1.Option=��2�ڂ̈����̃t�@�C���Ƃ���
    DataNode���N������ƃf�[�^�����������
    �g����)
    java -classpath ./:./classes okuyama.imdst.client.UtilClient bkup 127.0.0.1 5554 > bkupFor5554.dump


  ��Key�l�ɕR�t��Tag���폜���郁�\�b�h��ǉ�
    Key�l��Tag�l�̗������w�肷�邱�Ƃ�Key�l����Tag�̕R�t�����폜����

    OkuyamaClient�ł�removeTagFromKey(Key, Tag)���\�b�h


  ���]�u�C���f�b�N�X�쐬�@�\�ƑS�������@�\��ǉ�(����Index�̑S�폜���܂�)
    !!! �{�@�\�̓x�[�^�@�\�ł��� !!!
    �]�u�C���f�b�N�X��N-gram�����Ƃ��AOkuyamaClient��setValueAndCreateIndex�ŃC���f�b�N�X�쐬
    (���j�O�����A�o�C�O�����A�q�X�g�O���������B��������Index�̒������w��)
    �S��������OkuyamaClient��searchValue�𗘗p����B��x�ɕ����̌���Word��n����AND������OR�������w��ł���B
    �o�^���ɍ쐬����Index��Prefix��t�����邱�Ƃ��o����B
    ����ɂ��A����Index��o�^����f�[�^�P�ʂŕʂ̂��̂Ƃ��Ĉ������Ƃ��o����B
    ��������Prefix���w�肷�邱�ƂŁA���l��Prefix���w�肵��Index���쐬�����f�[�^�̂ݎ擾�\�ƂȂ�
    ��Index�쐬�A�����������Ƃ������R�[�h��UTF-8�̂ݑΉ�

    OkuyamaClient�ł͈ȉ��̃��\�b�h�ő��삷��
    �EIndex�쐬�@�����̈����Ⴂ�̃��\�b�h�����݂���̂ŁAOkuyamaClient��JavaDoc���Q�Ƃ��Ă��������B(ant javadoc �ō쐬�\)
      setValueAndCreateIndex 

    �EIndex�������\�b�h�@�����̈����Ⴂ�̃��\�b�h�����݂���̂ŁAOkuyamaClient��JavaDoc���Q�Ƃ��Ă��������B(ant javadoc �ō쐬�\)
      searchValue

    �E�쐬����Index�̂ݍ폜
      removeSearchIndex�@�����̈����Ⴂ�̃��\�b�h�����݂���̂ŁAOkuyamaClient��JavaDoc���Q�Ƃ��Ă��������B(ant javadoc �ō쐬�\)


  ���������̏������\����ƕs��̏C��


========================================================================================================
[New - �V�@�\�ǉ��A�s��Ή�]
[[�����[�X Ver 0.8.6 - (2011/02/11)]]
  ������Value�ꊇ�擾�@�\��ǉ�(memcached��get�ɕ�����Key�l����ׂ�̂Ɠ���)
     �����̎擾������Key��z��œn�����Ƃł܂Ƃ߂�Value���擾�\�B�ԋp�����l��Key��Value��Map�ŕԂ����
	 ���l��Key�𕡐��w�肵���ꍇ�͑��˂ĕԂ����B
	 OkuyamaClient�ł�<Map>getMultiValue(String[])���\�b�h�ɂȂ�B
     memcached�v���g�R���ł�get�̌��key�l����ׂ�
	 !!����!!:PHP�N���C�A���g�͖��Ή��B


  ��Tag���w�肷��Ƃ���ɕR�t��Value�𓯎��ɕԋp����@�\��ǉ�
     Tag���w�肷�邱�Ƃŏ]����Key�̔z����擾�\���������AKey��Value��Map���擾����@�\��ǉ��B
	 Tag���w�肷��ӊO�́A<Map>getMultiValue(String[])�Ɠ��l�̋����ƂȂ�B
	 OkuyamaClient�ł́A<Map>getTagValues(String tag)���\�b�h�ɂȂ�B
	 !!����!!:PHP�N���C�A���g�͖��Ή��B


  ��Tag��o�^�A�X�V����ۂ̏������\������


  ���l�̉��Z�@�\��ǉ��B���Z�ł����ނ̓C���N�������g�A�f�N�������g�ł�(memcached��incr�Adecr�Aappend����)
  	  =>�C���N�������g����
        =>OkuyamaClient�ł�incrValue(String key, long val)
		=>memcached�v���g�R���ł�incr
		
  	  =>�f�N�������g����
        =>OkuyamaClient�ł�decrValue(String key, long val)
		=>memcached�v���g�R���ł�decr

    !!����!!:PHP�N���C�A���g�͖��Ή��B

  ��ServerController�ɃR�}���h�̎�ޒǉ�
    1.1. �T�[�o�R���g���[���R�}���h��ǉ�
         �ǉ������@�\�͈ȉ�
         "cname" : okuyama��DNS�@�\��ݒ肷�� => DataNode�̐ݒ��̖��O�Ǝ��ۂ̖��O��Mapping��ς��邱�Ƃ��o����
                          >datanode001=datanodeserver01
                          ��L�̂悤�Ɏw�肷��ƁAokuyama��"datanode001"�Ƃ������O��DataNode�ݒ��"datanodeserver01"�Ɠǂݕς��ăA�N�Z�X����
                          ���֌W��ύX�������ꍇ�͍ēx���s����Ώ㏑�������

         "rname" : okuyama��DNSMapping���폜����
		                  rname���s��A���݂̐ݒ薼�����
                          >datanode001 

         "jobs" : ���ԕʂ̑��A�N�Z�X����Ԃ�
                       >jobs
					   
         "allsize" : ���ׂĂ�Isolation�ʂ̕ۑ��f�[�^�T�C�Y��Ԃ�
                          �P�ʂ̓o�C�g�ɂȂ�
						  >allsize
 
         "size" : Isolation�����w�肷�邱�ƂŌʂ̃T�C�Y��Ԃ�
                      >size
					  >IsolationPrefix
					 
  �����v���P�[�V�����o�^���m�F�@�\�ǉ�
    DataNode�̃��v���P�[�V�������ݒ肵�Ă���ꍇ�ɁA���v���P�[�V�����̃f�[�^��]����A�f�[�^�m�[�h�œo�^���������������Ă��邩���m�F
	�����ɃN���C���Ƃɂ͐����Ƃ��ĕԂ��B
    ���v���P�[�V������̏������ݑ��x�Ɉˑ����Ȃ��̂ŁA�������ݏ���������������锽�ʁA�m�[�h�_�E�����Ƀf�[�^��������������\���������B
	MasterNode.properties�̈ȉ��̍��ڂ�ύX����
	--------------------------------
	#�������݊����m�F�����Ȃ�
	KeyMapDelayWrite=true
	
	#�������݊����m�F������
	KeyMapDelayWrite=false
�@--------------------------------

  ���������̏������\����ƕs��̏C��
  

========================================================================================================
[New - �V�@�\�ǉ��A�s��Ή�]
[[�����[�X Ver 0.8.5 - (2011/01/18)]]
  ��MasterNode�P�ʂł�Isolation�@�\��ǉ�
    Isolation�@�\�Ƃ�okuyama�̃}���`�e�i���g������������@�\�ł���B
    ���܂ł�okuyama�͕ۑ�����Key�͂��ׂĂ�DataNode���Ń��j�[�N�Ȓl�ł�����(���v���P�[�V�����͏���)
    ���̂��߁ADataNode�𕡐��̃A�v���P�[�V������A�����̃��[�U�����p����ꍇ�́AKey�l�Ƀv���t�B�b�N�X��
    �t������ȂǍH�v���K�v�ł������B
    �{�@�\�́ADataNode�����L���āA�Ɨ������f�[�^��Ԃ��쐬����@�\�ƂȂ�B
    �Ɨ��P�ʂ́AMasterNode�̐ݒ�Ŏw�肷��B
    MasterNode.properties��"IsolationMode"��"IsolationPrefix"�𗘗p����B
    �ȉ��̐ݒ��MasterNode.properties�ɐݒ肵�A�N������Ɠ��l�̐ݒ������
    �N������MasterNode�͒l�����L�ł��邪�A�ݒ�����Ă��Ȃ�MasterNode����͎擾�o���Ȃ��Ȃ�B
    ------------ MasterNode.properties --------------------
    IsolationMode=true
    IsolationPrefix=XC45G
    -------------------------------------------------------

	IsolationMode=false���w�肷��ƁA���L�I�ȗ̈�ɃA�N�Z�X���邱�ƂɂȂ�B�������A�ʂ�MasterNode��
    �w�肵�Ă���Isolation��Ԃɂ̓A�N�Z�X�ł��Ȃ��B


  ���L�������؂�f�[�^�����폜
    memcached�N���C�A���g�ɂ����expire Time���w�肳��A�L���������؂ꂽ�f�[�^�������I�ɍ폜����@�\��ǉ�
    ���s�����O�������"ImdstDefine.java"��"vacuumInvalidDataFlg"�ϐ���"true"��(�f�t�H���g"true")
    Key�AValue�������������̏ꍇ�̂ݎ��s�����B
    ��DataNode.properties�̐ݒ肪�ȉ��̏ꍇ�݂̂ł���
    -------------- DataNode.properties --------------
    KeyManagerJob1.memoryMode=true
    KeyManagerJob1.dataMemory=true
    KeyManagerJob1.keyMemory=true

                     or                      

    -------------- DataNode.properties --------------
    KeyManagerJob1.memoryMode=false
    KeyManagerJob1.dataMemory=true
    KeyManagerJob1.keyMemory=true

                     or                      

    -------------- DataNode.properties --------------
    KeyManagerJob1.memoryMode=false
    KeyManagerJob1.dataMemory=true
    KeyManagerJob1.keyMemory=true

    ���L�������؂ꎩ���p�[�W��30����1����s����A���`�F�b�N���ɗL��������5���؂�Ă���f�[�^�������폜�Ώ�


  ���ۑ��f�[�^�T�C�Y(DataNode���ۑ����Ă���T�C�Y)���擾����@�\��ǉ�
    DataNode���ۑ����Ă���l�̍��v�o�C�g�T�C�Y���擾�ł���@�\��ǉ�
    1.1. DataNode�ɐڑ�
         "60,all"�Ƒ��M:����DataNode���ۗL����S�l�̍��v�T�C�Y���擾�ł���
         "60,"#" + Isolation��5����Prefix"�Ƒ��M:Isolation�P�ʂŎ擾�ł���
     �������I�Ɏ������Ă��邽�߁ADataNode�ɒ��ڐڑ�����K�v������


  ���f�o�b�O�I�v�V������ǉ��B�ʐM���O��W���o�͂ɏo�͂���悤�ɋ@�\�ǉ�
    DataNdoe�AMasterNode���ɂ��ׂĂ̒ʐM���e��W���o�͂Ƀ_���v����@�\��ǉ�
    1.1. �N�����@ 
	     DataNode�AMasterNode�Ƃ��ɋN�����̑�3������"-debug"��t�����ċN������ƁA�W���o�͂ɒʐM���e���o�͂����
         ��)DataNode
         java -cp ./classes;./lib/log4j-1.2.14.jar;./lib/javamail-1.4.1.jar;./lib/commons-codec-1.4.jar -Xmx128m -Xms128m okuyama.base.JavaMain /Main.properties /DataNode.properties -debug
         ��)MasterNode
         java -cp ./classes;./lib/log4j-1.2.14.jar;./lib/javamail-1.4.1.jar;./lib/commons-codec-1.4.jar -Xmx256m -Xms128m okuyama.base.JavaMain /Main.properties /MasterNode.properties  -debug

     �����\�͗�����̂Œ���


  ��ServerController�ɃR�}���h�̎�ޒǉ�
    1.1. �T�[�o�R���g���[���R�}���h��ǉ�
         �]����MasterNode.properties����сAMasterNode.properties��"ServerControllerHelper.Init="��
         ��`����Ă���|�[�g�ɐڑ�����Ƒ�Shutdown���������A�ύX����ނ�ǉ�

         �ǉ������@�\�͈ȉ�
         "shutdown" : �T�[�o��~
         "debug" : �f�o�b�O�I�v�V����true�ɓ��I�ɕύX
         "nodebug" : �f�o�b�O�I�v�V����false�ɓ��I�ɕύX


  ���f�[�^�S�폜�@�\��ǉ�
    1.1. �f�[�^�폜�@�\�Ƃ��āAIsolation�P�ʂ���сA�S�̂���x�ɏ����@�\��ǉ�
         DataNode�̒ʏ�|�[�g(�Y�t�̐ݒ�t�@�C���ł�5553��5554)�ɐڑ�
        �E"61,#all"�Ƒ��M:DataNode�̂��ׂĂ�������
        �E"61,"#"+IoslationPrefix������"�Ƒ��M:DataNode����Isolation�P�ʂŏ�����

     ����x�������f�[�^�͕����ł��Ȃ��̂Œ��ӂ��K�v
     �������I�Ɏ������Ă��邽�߁ADataNode�ɒ��ڐڑ�����K�v������

  ��Tag�f�[�^�Ɋ֌W����s��C��


========================================================================================================
[New - �V�@�\�ǉ��A�s��Ή�]
[[�����[�X Ver 0.8.4 - (2010/12/16)]]
  ���f�[�^�L��������ݒ�ł���@�\��ǉ� 
    memcached�ł����Ƃ����expireTime��ݒ�\�� 
    ���݂��̐ݒ��memcached�N���C�A���g����̂ݐݒ�\�ł���B
    �܂�okuyama�̃N���C�A���g����o�^�����l�̗L�������͖������ƂȂ�
   ����ɂ��memcached�N���C�A���g�̓o�^���̂��ׂĂ�Option�J�����̒l���g�p�\�ƂȂ����B

  ���r���I�X�V�@�\��ǉ�
    memcached�ł����Ƃ����gets�Acas����ɑΉ� 
    okuyama��p�N���C�A���g�ł͂��ꂼ��ȉ��̃��\�b�h�ɂȂ�܂�

    >gets => getValueVersionCheck
    >cas  => setValueVersionCheck

  �����������g�p���ăf�[�^��ێ�����X�g���[�W���[�h�̂��� 
    Key���������y�сAValue���������̂ǂ��炩�̃��[�h�ŉғ������ۂ� 
    ���炩���ߐݒ肵���������g�p�ʂ𒴂����ꍇ�ɁA�����I�Ƀf�B�X�N�ɃX�g�A����悤�ɉ��C 
      =>OutOfMemory�����̗\�h�ɂ��A�����肵�ĉғ�����悤�ɕύX�B
    DataNode.properties�̈ȉ��̍��ڂŋ��e�������g�p�ʂ̏�����w��

      >KeyManagerJob1.memoryLimitSize=85                             <-�g�p����̃p�[�Z���g
      >KeyManagerJob1.virtualStoreDirs=./keymapfile/virtualdata1/    <-�X�g�A����t�@�C���f�B���N�g���w��


  ��Value���f�B�X�N�ɕێ����郂�[�h���̃f�B�X�N�g�p���������� 
    =>�]����Value���f�B�X�N�ɕێ�����ꍇ�͌Œ蒷�Ƃ��ĕۑ����Ă������߁A 
      Value��Max�T�C�Y�ȓ��̒l���Œ蒷�Ńf�[�^�t�@�C���ɕۑ�����Ă������A 
      ���̂���Value��Max�T�C�Y��傫���ݒ肵���ꍇ�́A�������ȃf�[�^�ł����Ă� 
      �f�C�X�N�𖳑ʂɏ���Ă����B 
      ���̕������œK�����AMax�T�C�Y�Ƃ͕ʂɗǂ��g�p����T�C�Y��ݒ�ł���悤�ɕύX 
      ������̒l���œK�Ȓl�ɂ��Ă����ƁA�f�B�X�N�g�p���̌������ƃ��X�|���X�̌��オ�_����B

      >okuyama.imdst.util.ImdstDefine��dataFileWriteMaxSize�ϐ��̒l(�P�ʂ̓o�C�g)��ύX���čăR���p�C��

  �����S�f�B�X�N���[�h���Ƀf�B�X�N�ւ̏������ݏ�����񓯊��ɕύX 
    =>�񓯊��������݂ɂ��f�[�^�o�^�A�폜���\������ 
    =>�������݊����܂ł̓������̈���g�p���邱�ƂŐ��������m�� 

  ���T�[�o�Ԃ̃f�[�^���������̃o�O���C�� 
    =>�f�[�^�����Ώۂ̃f�[�^���������ꍇ(���S�����ȏ�Ȃ�)�ɁAOutOfMemory����������o�O���C�� 

  ���l�b�g���[�N�z���ɒ�~�ł���悤�ɕύX 
    =>�]���͋N���v���Z�X��kill�R�}���h���Œ�~���邵���Ȃ��������A���炩���ߐݒ肵���|�[�g�ɃA�N�Z�X���邱�Ƃ� 
      ��~����悤�ɋ@�\�ǉ� 
      MasterNode.properties�ADataNode.properties�̈ȉ��̕����Ń|�[�g���w�肷��

      >ServerControllerHelper.Init=15553

  ��Linux���p�̃C���X�g�[���p�p�b�P�[�W���� 
    =>�ȒP�ɋN���ł���X�N���v�g�𓯍� 
    =>�����[�X����install�f�B���N�g���z���ɂ���AReadMe.txt���Q��

  ������̃o�O�C���Ə����̌�����

========================================================================================================
========================================================================================================
[New - �V�X�g���[�W���[�h��ǉ��Apackage�\���ύX�ATag����Key���擾����ۂɑ��݂��Ȃ�key���Ԃ��Ȃ�Option������ǉ��ATag�o�^���̃��b�N�A���S���Y�����������A�s��Ή�]
[[�����[�X Ver 0.8.3 - (2010/11/5)]]
  ���X�g���[�W���[�h�Ɋ��S�f�B�X�N���[�h��ǉ�
    ���̃��[�h���g�p���邱�ƂŁA���Ȃ��������̃T�[�o�ł��f�B�X�N�̏���܂Ńf�[�^���Ǘ����邱�Ƃ��ł���B
    DataNode.properties�ɐV���Ƀp�����[�^���ǉ����ꂽ

    DataNode.properties�t�@�C����
    ---------------------------------------
    KeyManagerJob1.dataMemory=false
    KeyManagerJob1.keyMemory=false
    KeyManagerJob1.keyStoreDirs=./keymapfile/THdata1/,./keymapfile/THdata2/
    ----------------------------------------

    ����L�̏�ԂŊ��S�f�B�X�N���[�h�ɂȂ�
      keyStoreDirs�͕ۑ�����f�B���N�g���ɂȂ�B�ꏊ�w��̓J���}��؂�Œ�`����B
      �w��f�B���N�g�������ꂼ��ʁX�̃f�B�X�N�ɂ���ƃ��X�|���X�����シ��B


  ���p�b�P�[�W�\���͑啝�ɕύX
    �O��܂Ŏg�p���Ă����p�b�P�[�W���͊���URL���ʂ̕����擾�ς݂ł����̂ŁA�ύX�B
    �]���̃p�b�P�[�W�\������
    okuyama.imdst
    okuyama.base
    �ɕύX
    �\���󂠂�܂��񂪁A���̕ύX�ɂ��ImdstKeyValueClient��import���̕ύX���K�v�ɂȂ�܂��B
    �ȉ��ƂȂ�܂�
      import okuyama.imdst.client.ImdstKeyValueClient


  ��Tag����Key���擾����ۂɂ��łɍ폜���ꂽKey�l��Ԃ��Ȃ�Option������ǉ�
    ImdstKeyValueClient��getTagKeys���\�b�h�̑�2������false���w�肷��
    
    �g�p��)
      imdstKeyValueClient.getTagKeys("Tag", false);

    ��PHP�N���C�A���g�����l�ł��B


  ��Tag�o�^���̃��b�N�A���S���Y����������
    Tag�o�^���̃��b�N�A���S���Y���������������Ƃɂ�蕡���N���C�A���g����̓���Tag�o�^�̃��X�|���X������

  ���s��Ή�
    �������̃o�O���C��

========================================================================================================
[New -�����[�X�s��Aant�^�X�N�쐬]
[[�����[�X Ver 0.8.2 - (2010/09/22)]]
  ��Version-0.8.1�ɂ�lib�t�H���_��memcached.jar��z�u�����Ƀ����[�X���Ă��܂��܂����B
    ������lib�t�H���_��memcached.jar��z�u�B
    ����ɂ��e���́Atest�t�H���_�̃e�X�g�v���O�����ł��B


  ��ant�^�X�N���쐬
    ant�^�X�N�ɂāAcompile�Ajar�t�@�C���쐬�A�T�[�o�N���A�e�X�g�R�}���h���s�������s�ł���悤�ɍ쐬
    ������ant�R�}���h�ւ̈����Ƃ��ꂼ��̎��s���e�ƂȂ�B
    ����                      | ���e
   ------------------------------------------------------------------------------------------------
    compile                   | �R���p�C�������s
    jar                       | okuyama��jar�t�@�C�����쐬
                              |
    datanode                  | DataNodeServer�N��
    slavedatanode             | SlaveDataNodeServer�N��
    thirddatanode             | ThirdDataNodeServer�N��
    masternode                | MasterNodeServer�N��
    masternodelock            | MasterNodeServer�����b�N�g�p�\�ȏ�ԂŋN��
    slavemasternode           | SlaveMasterNodeServer�N��
    memcachedmasternode       | Memcached�v���g�R��MasterNodeServer�N��
    transactionnode           | ���U���b�N�Ǘ�NodeServer�N��
    webmgr                    | Web�Ǘ��R���\�[���pWeb�T�[�o�N��(�|�[�g10088��)
                              |
    serverrun                 | datanode�Aslavedatanode�Athirddatanode�Amasternode���s(�{���s���s����okuyama�̉ғ��e�X�g�͉\�ł�)
    serverrun-slave           | datanode�Aslavedatanode�Athirddatanode�Amasternode�Aslavemasternode���s(MasterNode���璷���\���ŋN�����܂�)
    serverrun-memcached       | datanode�Aslavedatanode�Athirddatanode�Amasternode�Amemcachedmasternode���s(MasterNode��Memcached�v���g�R���p��MasterNode�ŏ璷���\���ɂ��܂�)
    serverrun-transaction     | datanode�Aslavedatanode�Athirddatanode�Amasternodelock�Atransactionnode���s(�g�����U�N�V�����Ǘ��m�[�h���N�������U���b�N���g�p�\�ȏ�Ԃɂ��܂�)
    serverrun-webmgr          | datanode�Aslavedatanode�Athirddatanode�Amasternode�Awebmgr���s(Web�Ǘ���ʂ����킹�ċN�����܂�)
                              |
    testset                   | set�R�}���h��1000����s����
    set                       | �C�ӂ�Key��Value��o�^(ant set -Dkey=key123 -Dvalue=value123)
    testget                   | get�R�}���h��1000����s����(testset�œo�^���ꂽ�f�[�^���擾����)
    get                       | �C�ӂ�Key��Value���擾(ant get -Dkey=key123)
    testsettag                | Tag���Z�b�g����R�}���h��500����s����
    testgettag                | Tag����Key��Value��Get����R�}���h��testsettag�œo�^����Tag�̎�ޑS�ĂɎ��s����(tag1�Atag2�Atag3�Atag4��4���)
    testremove                | remove�R�}���h��testset�œo�^����Key�̂���500���Ɏ��s����
    testadd                   | add�R�}���h���e�X�g����(Key1=Value1�Ƃ����g�ݍ��킹�œo�^����)
    testlock                  | ���b�N�@�\���g�p���ăf�[�^�̃��b�N�A���b�N���̓o�^�A�폜�A���b�N�J�������s����(serverrun-transaction��ʃR���\�[���Ŏ��s���Ă���ꍇ�̂ݗ��p�\)

    ����1(2�̃R���\�[����build.xml�Ɠ����ꏊ�ŊJ��)
      �R���\�[��1:ant serverrun
      �R���\�[��2:ant testset
                  ant testget
      ����L�ŃR���\�[��1��okuyama�̃T�[�o�\�����N�����A�R���\�[��2��set�R�}���h���s���A������get�R�}���h�����s���Ă���B
        ���ۂɂ́A�R���\�[��1��okuyama���N�������܂Ŋ��ɂ�邪20�b����30�b�قǂ�����܂��B
        ���̂��߁A30�b�قǌo�ߌ�A�R���\�[��2�ł̃e�X�g���s���Ă��������B

    ����2(2�̃R���\�[����build.xml�Ɠ����ꏊ�ŊJ��)
      �R���\�[��1:ant serverrun-transaction
      �R���\�[��2:ant testlock
      ����L�ŃR���\�[��1��okuyama�̃��b�N�g�p�\��ԂŃT�[�o�\�����N�����A�R���\�[��2��Lock�@�\�̃e�X�g�����s���Ă���
        ���ۂɂ́A�R���\�[��1��okuyama���N�������܂Ŋ��ɂ�邪20�b����30�b�قǂ�����܂��B
        ���̂��߁A30�b�قǌo�ߌ�A�R���\�[��2�ł̃e�X�g���s���Ă��������B

    ����3(2�̃R���\�[����build.xml�Ɠ����ꏊ�ŊJ��)
      �R���\�[��1:ant serverrun-webmgr
      �R���\�[��2:ant testset
                  ant set -Dkey=key123 -Dvalue=value123
                  ant testget
                  ant get -Dkey=key123
                  ant testsettag
                  ant testgettag
                  ant testremove
      ����L�ŃR���\�[��1��okuyama�̃T�[�o�\����Web�Ǘ��R���\�[�����N�����A�R���\�[��2��set�R�}���h���s���A�C�ӂ�Key=key123,Value=value123��o�^�A
        ������get�R�}���h�����s�A������C�ӂ�Key=key123��Value���擾�A������Tag���g����Key��Value��set�A������Tag��Key��Value���擾�A������f�[�^���폜���Ă���B
        ���ۂɂ́A�R���\�[��1��okuyama���N�������܂Ŋ��ɂ�邪20�b����30�b�قǂ�����܂��B
        ���̂��߁A30�b�قǌo�ߌ�A�R���\�[��2�ł̃e�X�g���s���Ă��������B
        ��A�̓��쒆���T�[�o�̈ȉ���URL�ɃA�N�Z�X�����Web��ʂŏ󋵂��m�F�ł���
        http://���s�T�[�oIP:10088/okuyamamgr


  ��SlaveDataNode.properties�ł�DataNode�N���|�[�g�ԍ���6553��6554�ɕύX

  ��������test�f�B���N�g���z���̃t�@�C����Java�t�@�C���̕����R�[�h���ꕔShift-Jis����������UTF-8�ɕύX(���f�B���N�g����class�t�@�C�����C����R���p�C���ς�)

  �����񃊃��[�X�ȍ~�A�����̑唼��bat�t�@�C����Ash�t�@�C����executecommand�f�B���N�g���Ɉړ����܂��B


========================================================================================================
========================================================================================================
[New - �@�\���P]
[[�����[�X Ver 0.8.1 - (2010/09/21)]]
  ���g�����U�N�V�������O�t�@�C�������T�C�Y�Ŏ����I�Ƀ��[�e�[�V��������悤�ɕύX
    DataNode.properties��"memoryMode=false"�Ƃ��Ă���ꍇ�ɍ쐬�����A�g�����U�N�V�������O�t�@�C��
    (�f�[�^���엚���t�@�C��)���]���͉i���ɒǋL����邽�߁A�������剻�����ɂȂ邽�߃T�C�Y��1.8GB��
    �B�������_�Ŏ����I�ɐV�����t�@�C�����쐬�����t�@�C���̓t�@�C�����̖����ɐ�����t�������l�[������悤��
    �ύX�B�ċN�����͖����̐���������������(��{�I�ɂ�0����)�����荞��ōŌ�ɐ����̕t���Ȃ��t�@�C����
    �ǂݍ��ނ悤�ɕύX�B



  ��JavaScript�Ńf�[�^�X�V���s����悤�ɕύX
    �]��JavaScript��Value�ւ̒l������A�ԋp���̉��H�ɂ����g���Ȃ��������A�V����JavaScript�Ńf�[�^�m�[�h�Ɏ��ۂ�
    �ۑ�����Ă���l���X�V�o����悤�ɋ@�\�g���B
    �l���X�V����ɂ́AJavaScript�{�����̕ϐ��l"execRet"�̒l��2�ɂ���B
    �������邱�ƂōŏI�I��JavaScript�{�����̕ϐ��l"retValue"�̒l�����ۂɃf�[�^�m�[�h�ɍĕۑ������B
    �܂��A�V����"dataKey"�Ƃ���JavaScript�ϐ����ǉ�����A����ɂ�Key�l���i�[�����JavaScript������Q�Əo����悤��
    �Ȃ����B
    !!����!!:�l���X�V����ꍇ��ImdstKeyValueClient��getValueScriptForUpdate���\�b�h���g�p���邱�ƁB

    JavaScript ��) �ȉ���Key�l��"key1"�̏ꍇ�͕�����u������Value�l���X�V��A�N���C�A���g��Value��ԋp���A"key1"�ł͂Ȃ��ꍇ�͍X�V�����ɕԋp���Ă���B
                  "var dataValue; var dataKey; var retValue = dataValue.replace('value', 'dummy'); if(dataKey == 'key1') {var execRet = '2'} else {var execRet = '1'}";

    ���ȉ��̃e�X�g�R�[�h�Ŏ�����
    java -cp ./;./classes;./lib\mail.jar TestSock 1.1 127.0.0.1 8888 key1 value1
    java -cp ./;./classes;./lib\mail.jar TestSock 2.4 127.0.0.1 8888 key1 "var dataValue; var dataKey; var retValue = dataValue.replace('value', 'dummy'); if(dataKey == 'key1') {var execRet = '2'} else {var execRet = '1'}"
    java -cp ./;./classes;./lib\mail.jar TestSock 2.1 127.0.0.1 8888 key1
    ���N���C�A���g�ɕԋp�����Value�l�ōX�V����Ă���

    java -cp ./;./classes;./lib\mail.jar TestSock 1.1 127.0.0.1 8888 key2 value2
    java -cp ./;./classes;./lib\mail.jar TestSock 2.4 127.0.0.1 8888 key2 "var dataValue; var dataKey; var retValue = dataValue.replace('value', 'dummy'); if(dataKey == 'key1') {var execRet = '2'} else {var execRet = '1'}"
    java -cp ./;./classes;./lib\mail.jar TestSock 2.1 127.0.0.1 8888 key2
    ���N���C�A���g�ɕԋp�����Value�l�ōX�V����Ă��Ȃ�



  �����S�t�@�C�����[�h���Ƀf�[�^�̈��ʂ��������ɃL���b�V������悤�ɋ@�\�ǉ�
    ���S�t�@�C�����[�h(Key���������AValue�̓f�[�^�t�@�C��)���Ƀf�[�^�t�@�C�����������ɏ��Ȃ��T�C�Y�ɂȂ����ۂɔ�������
    ���X�|���X�ቺ��}�����邽�߂ɁA����(JVM�Ɋ��蓖�ĂĂ��郁������10%�ɑ���)���������ɃL���b�V������@�\��ǉ��B
    ���̃L���b�V���@�\��LRU�A���S���Y�����̗p���Ă���A���p�p�x�̍����f�[�^�قǃL���b�V�������悤�ɂȂ�A���p�p�x��
    �Ⴂ�f�[�^�͎����I�Ƀp�[�W�����B
    �����݂��̃L���b�V����Off�ɂ��邱�Ƃ͏o���Ȃ��B



  ���f�[�^�m�[�h�̃��������p���@�����������A�]��������ʂ̃f�[�^���������ێ��ł���悤�ɏC��
    �]����Key��Value�̃�������ł̈�������ύX�A�œK�������������p���������サ���B
    ����ɂ��]������1.3�`1.4�{���x�̃f�[�^��������悤�Ɍ���B



  ���f�[�^�m�[�h���ł�Key�l�T�������ɍH�v���s���A�擾����������
    ����̃p�^�[���ł�Key�l�T�����̌���������B
    Key�l�̐擪��A�������v���t�B�b�N�X�I�ɕύX���ăf�[�^��ۑ�����悤�ȏꍇ�ɐ��\���オ���҂ł���B


========================================================================================================
========================================================================================================
[New - �@�\���P]
[[�����[�X Ver 0.8.0 - (2010/09/07)]]
  ���U�蕪�����[�h��ConsistentHash��ǉ�
    �f�[�^���U�A���S���Y�����]����Mod�݂̂��������A�V����ConsistentHash��ǉ��B
    �m�[�h�ǉ����̎����f�[�^�ڍs������
    ConsistentHash�A���S���Y������execOkuyamaManager.bat���N����http://localhost:10088/okuyamamgr�ɃA�N�Z�X���A
    "Add Main DataNode"�ɒǉ��������m�[�h��IP:PORT���L�q��UPDATE�{�^������������Ǝ����I�Ƀf�[�^�ڍs���s����
    ��Sub�f�[�^�m�[�h�AThird�f�[�^�m�[�h���^�p���Ă���ꍇ�͈�x��"Add Sub DataNode"�A"Add Third DataNode"��
      IP:PORT���L�q����UPDATE�{�^�����������Ȃ��ƍX�V�Ɏ��s����
      �܂�AMainDataNode�������₷�Ƃ��͏o���Ȃ��B
    ��MasterNode�̐ݒ�͑S�m�[�hMod��������ConsistentHash�̂ǂ��炩�ɓ��ꂳ��Ă���K�v������B
      �]����Mod�A���S���Y���ŕۑ������f�[�^��ConsistentHash�Ɉڍs�͏o���Ȃ��B
    ��Mod�A���S���Y�����͏]���ʂ�̊e�m�[�h�e�L�X�gBox�̍Ō�ɒǉ��������m�[�h��"IP:PORT"���L�q��UPDATE�{�^������������

    MasterNode.properties�̈ȉ��̐ݒ荀�ڂŐ���\
    ��DistributionAlgorithm
        �ݒ�l) "mod"=Mod�A���S���Y��
                "consistenthash"=ConsistentHash�A���S���Y��
        �L�q��)
             DistributionAlgorithm=mod


  ��DataNode�̃��v���P�[�V�������2�m�[�h�ɕύX
    �]����KeyMapNodesInfo�ɑ΂���SubKeyMapNodesInfo�����v���P�[�V������ƂȂ�2�m�[�h�Ńf�[�^�����v���P�[�V����
    ���Ă������A�V����ThirdKeyMapNodesInfo��݂����B
    ThirdKeyMapNodesInfo���L�q����ƁA���v���P�[�V�������s���3�m�[�h��1�g��DataNode�Ƃ��ċ@�\����B
    3�m�[�h�S�Ă���~���Ȃ���Ήғ��\�ł���B
    ��3�ڂ̃m�[�h�ɑ΂���get�n�̃A�N�Z�X��Main�ASub�ǂ��炩�̃m�[�h����~���Ȃ�����͍s��Ȃ��B
      get�n�̃A�N�Z�X�͐������ғ����Ă���2�m�[�h�Ɍ��肳���B

    MasterNode.properties�̈ȉ��̐ݒ荀�ڂŐ���\
    ��ThirdKeyMapNodesInfo
        �ݒ�l) "IP:PORT"

        �L�q��)
             ThirdKeyMapNodesInfo=localhost:7553,localhost:7554


  ���f�[�^�擾���̈�ѐ����[�h��ǉ�
    �f�[�^�擾���Ƀ��v���P�[�V������̏�Ԃɍ��킹�Ď擾�f�[�^�̈�ѐ����ӎ������擾���\�B
    ���[�h��3��ނƂȂ�B
    �E���ѐ�:�����_���Ƀ��C���A���v���P�[�V������̂ǂ�������擾����(����Client�ڑ����g�p���Ă���Ԃ�1�m�[�h�ɌŒ肳���)
    �E����ѐ�:�K���Ō�ɕۑ�����郌�v���P�[�V�����m�[�h����擾����
    �E����ѐ�:���C���A���v���P�[�V�����̒l�����؂��A�V�����f�[�^��Ԃ�(�Б����폜����Ă����ꍇ�̓f�[�^�L�肪�Ԃ�)

    MasterNode.properties�̈ȉ��̐ݒ荀�ڂŐ���\
    ��3�ڂ̃m�[�h�ɑ΂���get�n�̃A�N�Z�X��Main�ASub�ǂ��炩�̃m�[�h����~���Ȃ�����͍s��Ȃ��B
      get�n�̃A�N�Z�X�͐������ғ����Ă���2�m�[�h�Ɍ��肳���B
    ��DataConsistencyMode
        �ݒ�l) "0"
                "1"
                "2"
 
        �L�q��)
             DataConsistencyMode=1


  �����[�h�o�����X���̐U�镪���̊�����ݒ�\��
    ���[�h�o�����X�ݒ肪true�̏ꍇ�ɏ]���͌��݂Ƀ��C���ƃ��v���P�[�V�����m�[�h�ɃA�N�Z�X����悤��
    �U�蕪���Ă������A�U�蕪���銄����ݒ�ł���悤�ɕύX

    MasterNode.properties�̈ȉ��̐ݒ荀�ڂŐ���\
    ��3�ڂ̃m�[�h�ɑ΂���get�n�̃A�N�Z�X��Main�ASub�ǂ��炩�̃m�[�h����~���Ȃ�����͍s��Ȃ��B
      get�n�̃A�N�Z�X�͐������ғ����Ă���2�m�[�h�Ɍ��肳���B
    ��BalanceRatio
        �ݒ�l) "7:3"=�U�蕪���銄��(���C���m�[�h:���v���P�[�V�����m�[�h)
                ����L�̏ꍇ��7��3�̊���

        �L�q��)
             BalanceRatio=7:3


  ���ʐM������啝������
    �N���C�A���g<->MasterNode�AMasterNode<->DataNode�Ԃ̒ʐM���������C
    Xeon3430(2.4GHz)�~1�A������4GB���x�̃}�V��(CentOS5.4 64bit)��10�b���x�ɊԂɏ���
    10000�N���C�A���g�܂Őڑ����ڑ������R�l�N�V����set,get�������J�n���铯���ڑ��e�X�g�Ŋm�F�B
    (C10K���ɑΉ�)
    ���N���C�A���g�͖�����̏ꍇ��60�b�Ŏ����I�ɐؒf�����
    ����ɔ����ȉ��̐ݒ荀�ڂŒʐM�����̃p�����[�^��ύX���`���[�j���O�\

    MasterNode.properties�̈ȉ��̐ݒ荀�ڂŐ���\
    ��MasterNodeMaxConnectParallelExecution
        �ݒ�l) ���l=�����ڑ����ɐڑ�����ɍs��Socket���b�v�����̕���

        �L�q��)
             MasterNodeMaxConnectParallelExecution=10


    ��MasterNodeMaxConnectParallelQueue
        �ݒ�l) ���l=MasterNodeMaxConnectParallelExecution�Őݒ肵�����񏈗��ւ̈������ݒ肳���L���[��
 
        �L�q��)
             MasterNodeMaxConnectParallelQueue=5


    ��MasterNodeMaxAcceptParallelExecution
        �ݒ�l) ���l=�N���C�A���g����f�[�^�]�����n���Ă��Ȃ������m�F����B����

        �L�q��)
             MasterNodeMaxAcceptParallelExecution=15

    ��MasterNodeMaxAcceptParallelQueue
        �ݒ�l) ���l=MasterNodeMaxAcceptParallelExecution�Őݒ肵�����񏈗��ւ̈�����ݒ肷��L���[��

        �L�q��)
             MasterNodeMaxAcceptParallelQueue=5


    ��MasterNodeMaxWorkerParallelExecution
        �ݒ�l) ���l=�f�[�^�]���J�n��Ԃ�Socket�o�^�ɑ΂��ď���������񏈗����B

        �L�q��)
             MasterNodeMaxWorkerParallelExecution=15


    ��MasterNodeMaxWorkerParallelQueue
        �ݒ�l) ���l=MasterNodeMaxWorkerParallelExecution�Őݒ肵�����񏈗��ւ̈�����ݒ肷��L���[��

        �L�q��)
             MasterNodeMaxWorkerParallelQueue=5


    DataNode.properties�̈ȉ��̐ݒ荀�ڂŐ���\
    ��KeyNodeMaxConnectParallelExecution
        MasterNodeMaxConnectParallelExecution�Ɠ��l

    ��KeyNodeMaxConnectParallelQueue=5
        MasterNodeMaxConnectParallelQueue�Ɠ��l

    ��KeyNodeMaxAcceptParallelExecution=20
        MasterNodeMaxAcceptParallelExecution�Ɠ��l

    ��KeyNodeMaxAcceptParallelQueue=5
        MasterNodeMaxAcceptParallelQueue�Ɠ��l

    ��KeyNodeMaxWorkerParallelExecution=15
        MasterNodeMaxWorkerParallelExecution�Ɠ��l

    ��KeyNodeMaxWorkerParallelQueue=5
        MasterNodeMaxWorkerParallelQueue�Ɠ��l


  ���e�X�g�P�[�X��ǉ�
    �����[�X��������execTest.bat�����s�����get�Aset�̃��\�b�h�e�X�g�ƁADataNode�ċN���̃e�X�g�����s�����
    ���̃c�[����Windows��Cygwin���C���X�g�[������ACygwin��bin��PATH���ʂ��Ă���z��ł���B
    ����Ȋ��ł����܂���B
    �����[�X������classes\Test.properties�Ȃ��̃p�X��K���Ȓl�ɏ��������Ă��������B

========================================================================================================
========================================================================================================
[New - �@�\���P]
[[�����[�X Ver 0.7.0 - (2010/06/27)]]
  ��MasterNode�𕡐��N�����璷�������ꍇ�̎����G�X�J���[�V�����@�\��ǉ�
    �]������MasterNode�𕡐��ŏ璷���͏o�������A���̏ꍇMasterNode���Ƀ��C���ƂȂ�m�[�h�����݂��A
    �c��̃}�X�^�[�m�[�h�̓X���[�u�Ƃ��������������B
    ���C���̃m�[�h���_�E�������ꍇ�́A�X���[�u�m�[�h�ɃA�N�Z�X����΃f�[�^�̎擾�A�o�^�A�폜���S�Ă�
    �N���C�A���g����͎��s�ł������ADataNode�̊Ď��A�f�[�^�m�[�h�_�E����̋N�����̃f�[�^���J�o�[��
    �X���[�uMasterNode�����ł͎��s����Ȃ������B
    ���̏ꍇ�́A�X���[�uMasterNode�̓���1�C���X�^���X��MasterNode.properties���̐ݒ�l
    "MainMasterNodeMode"��"true"�ɕς���K�v���������B
    ����̉��C�Ń��C��MasterNode���_�E�������ꍇ�̓X���[�uMasterNode�����玩���I��1�C���X�^���X��
    ���C��MasterNode�ɏ��i����悤�ɉ��C�B
    ���̉��C�ɂ��MasterNode.properties�ɐݒ荀�ڂ��ǉ�����A�]���̐ݒ荀�ڂ��g�p�\�ł͂��邪�A��������Ȃ��Ȃ����B

    ���ǉ����ꂽ���ڂ͈ȉ�
      �ESystemConfigMode
        ����) �ݒ�����擾����ꏊ(file or node)
              �ݒ����{�t�@�C�����N������Q�Ƃ������邩�A�N����͖{�t�@�C������x�����Q�Ƃ��A
              �Ȍ�́ADataNode�ɓo�^����Ă���ݒ�����Q�Ƃ��邩�����肷��
              "file"�̏ꍇ�͖{�t�@�C�����Q�Ƃ���
              "node"�̏ꍇ��DataNode���Q�Ƃ���
              �ݒ�����Ȃ��ꍇ��"node"�ƂȂ�
        �L�q��)
             SystemConfigMode=node


      �EMyNodeInfo=127.0.0.1:8888
        ����) ���g�̏��
              ���g��IP�ƋN���|�[�g�ԍ���":"��؂�ŋL�q
              ���g�p�𐄏�
              �����̐ݒ肪�Ȃ��ꍇ�̓��C��MasterNode�̎������i�@�\���@�\���Ȃ�
        �L�q��)
             MyNodeInfo=127.0.0.1:8888


      �EMainMasterNodeInfo
        ����) ���C���}�X�^�[�m�[�h�̏��
              �N�����Ƀ��C��MasterNode�Ƃ��ĔF������m�[�h��IP�ƃ|�[�g�ԍ�
              ���g�����C��MasterNode�̏ꍇ�͎��g�̏����L�q
              ���g�p�𐄏�
        �L�q��)
             MainMasterNodeInfo=127.0.0.1:8888


      �EAllMasterNodeInfo
        ����) �S�Ẵ}�X�^�[�m�[�h�̏��
              �S�Ẵ}�X�^�[�m�[�h�̏��"IP:PORT�ԍ�"�t�H�[�}�b�g��","��؂�ŋL�q 
              ���g�̏���MyNodeInfo�ݒ�̓��e�Ɠ����ł��邱��
              �����ł̋L�q���Ń��C��MasterNode�Ƃ��ċ@�\����
              ���g�p�𐄏�
              �����̐ݒ肪�Ȃ��ꍇ�̓��C��MasterNode�̎������i�@�\���@�\���Ȃ�
        �L�q��)
             AllMasterNodeInfo=127.0.0.1:8888,127.0.0.1:8889,127.0.0.1:11211

    ���g�p����������Ȃ��Ȃ�������
      �EMainMasterNodeMode
      �ESlaveMasterNodes


  ��MasterNode���g�p����ݒ����MasterNode.properties����Q�Ƃ��邾���łȂ��A
    DataNode�ɐݒ�����i�[�������炩�Q�Ƃ���悤�ɉ��C
    �]���ݒ����MasterNode.properties����˂ɎQ�Ƃ��Ă������A�ݒ����DataNode�Ɋi�[����
    �悤�ɉ��C���A�SMasterNode���������L�����ɉ��C
    �������A�N������DataNode�̏�񂪕�����Ȃ����߁AMasterNode.properties����Q�Ƃ���
    �]���ʂ�AMasterNode.properties�݂̂ŉ^�p���邱�Ƃ��\
    ���̐ݒ��ύX����ɂ�MasterNode.properties�̈ȉ��̐ݒ荀�ڂŕύX�o����B
    ���ǉ����ꂽ����
      �ESystemConfigMode
        ����) �ݒ�����擾����ꏊ(file or node)
              �ݒ����{�t�@�C�����N������Q�Ƃ������邩�A�N����͖{�t�@�C������x�����Q�Ƃ��A
              �Ȍ�́ADataNode�ɓo�^����Ă���ݒ�����Q�Ƃ��邩�����肷��
              "file"�̏ꍇ�͖{�t�@�C�����Q�Ƃ���
              "node"�̏ꍇ��DataNode���Q�Ƃ���
              �ݒ�����Ȃ��ꍇ��"node"�ƂȂ�
        �L�q��)
             SystemConfigMode=node



  ��okuyama�Ǘ�Web�R���\�[���A�v���P�[�V������ǉ�
    �ғ�����okuyama�̏󋵊m�F�Ɛݒ�̕ύX���o����ł���Web�A�v�����쐬�B
    �����[�X����execOkuyamaManager.bat�����s����ƊǗ�Web�A�v�����N������B

    URL : http://�N���}�V����IP:10088/okuyamamgr
    �ŃA�N�Z�X�ł���B

    ��execOkuyamaManager.bat���ŋN���|�[�g�ԍ�(10088��)��Web�A�v���������Q�Ƃ���MasterNode��IP:PORT��","��؂�œn���Ă��܂��B
      MasterNode�̏���MasterNode.properties�̐ݒ���"AllMasterNodeInfo"�̓��e�Ɠ��l�ɂ��Ă��������B


========================================================================================================
========================================================================================================
[New - �@�\���P]
[[�����[�X Ver 0.6.6 - (2010/06/08)]]
  ���f�[�^�m�[�h���J�o�[���̎擾�A�o�^�A�폜�̏����̑҂����Ԃ��y��
    �f�[�^�m�[�h�A�X���[�u�f�[�^�m�[�h�̍\���ŉғ����Ă���ꍇ�A�Е��̃m�[�h���_�E�����A
    �N�����Ă���ƁA�Б��̃m�[�h�̃f�[�^���畜�����郊�J�o�[�������s����B�]�����̏������̓N���C�A���g����
    ���Y�m�[�h�̃f�[�^�ɃA�N�Z�X����ƃL���[�C���O����Ă������߁A�҂��ɏ�ԂɂȂ��Ă����B
    ���̕������������A���J�o�[�������̑҂��ƂȂ�^�C�~���O��啝�Ɍy�������B
    ���̂��Ƃɂ��okuyama�̑��g�p���Ԃɑ΂���A�X���[�v�b�g�����コ�ꂽ�B
    �����ɁA�]��������̃m�[�h�̃f�[�^��okuyama�������Ŏg�p���Ă���f�[�^Map���V���A���C�Y����
    �����o���Ă������A���̕������g�����U�N�V�������O�Ɠ��������O�ɏ����o���悤�ɕύX�����B
    ���̂��ƂŃ��J�o�[�����̑����v���Ԃ�ጸ���ꂽ�B
    �����̉��P�̓f�[�^�m�[�h�A�X���[�u�f�[�^�m�[�h�������g�p���ĉғ����Ă���ꍇ�ɗL���ł���B

========================================================================================================
========================================================================================================
[New - �@�\���P]
[[�����[�X Ver 0.6.5 - (2010/05/30)]]
  ��Vacuum�������̎擾�A�o�^�A�폜�̏������p���ł���p�ɉ��C
    �]��Vacuum���͎擾�A�o�^�A�폜�����͏������u���b�N�����悤�ɂȂ��Ă���(�����͑҂���ԂɂȂ�)��
    ���̃u���b�N���Ԃ�啝�ɍ팸����悤�ɉ��C�B
    �]���Ȃ�Vacuum���n�܂�ƏI�n�u���b�N����Ă������A�������p���o����悤��(�҂����������Ȃ�)�Ȃ�
    okuyama�̑��g�p���Ԃɑ΂���A�X���[�v�b�g�����コ���B
    ��Vacuum��DataNode.properties��"KeyManagerJob1.dataMemory=true"�̗p��value���t�@�C���ɕۑ����Ă���
      �ꍇ�̂ݗL���ƂȂ�B

  ���eproperties�t�@�C���ɃR�����g��ǉ�
    MasterNode.properties�ADataNode.properties�ATransactionNode.properties�ɃR�����g��啝�ɒǋL
    �����܂ŃR�����g�����Ȃ��Đ\���󂠂�܂���ł����B

  ��ReadMe.txt�AReadMe-UTF.txt��[���@�\�����ƃT���v���̎��s���@]�A[�T���v���̎��s���@]������ǋL
    TransactionNode�̎g�p���@�AMemcached�݊��ł̋N�����@�A�N���C�A���g�̎g�p�\���\�b�h�������C��
    ���ULock�AsetNewValue(memcache��add����)�̎g�p�T���v����ǋL

========================================================================================================
========================================================================================================
[New - �@�\���P]
[[�����[�X Ver 0.6.4 - (2010/05/21)]]
  ���f�[�^�̕ۑ�����Key�l���ۑ�����悤�ɕύX
    �]����Key�l���琶������Hash�l��ۑ����Ă���������Ȃ��Ⴂ�\���ł͂��邪�Փ˂��N�����\��������ׁA
    ��ʂ̃f�[�^�ۑ��Ɍ����Ȃ��̂ŁAKey�l��������Ƃ��ĕۑ�����悤�ɕύX�B
    ������Key�l�ɂ������̐�����t���B(2048byte)
    �����̕ύX�ɂ���ϐ\���󂠂�܂��񂪁A�]���o�[�W�����ł̃f�[�^�͎g�p�ł��Ȃ��Ȃ�܂��B

  �����������������������A��������������B
    

========================================================================================================
========================================================================================================
[New - �@�\�ǉ�]
[[�����[�X Ver 0.6.3 - (2010/05/19)]]
  ���f�[�^�m�[�h��memcache�̃m�[�h�Ƃ��ė��p�\��
    �}�X�^�[�m�[�h���N�������ɒ��ڃf�[�^�m�[�h��memcache�̃m�[�h�Ƃ��ė��p�\�B
    �ȉ��̂悤�ɐݒ��ύX��execDataNode.bat�����s�����memcache�N���C�A���g�ŃA�N�Z�X�ł���B

    �ݒ�t�@�C��DataNode.properties��25�s��
    ----------------------------------
    KeyManagerHelper.Init=
              ����L�����L���e�ɕύX
    KeyManagerHelper.Init=memcache
    ----------------------------------
    �Ƃ��ċN�������memcache�v���g�R���ŉ�b���\�ƂȂ�B
    �Ή����\�b�h�̓}�X�^�[�m�[�h��memcache���[�h�Ƃ��ċN�������ꍇ�Ɠ��l�ƂȂ�B
    (�Eset, �Eget, �Eadd, �Edelete)(flag�ɑΉ�)

    �t�@�C���ւ̃f�[�^�i�������\
    �ݒ�t�@�C��DataNode.properties��30�s�ځA31�s��
    ----------------------------------
    KeyManagerJob1.memoryMode=false       
    KeyManagerJob1.dataMemory=true
    ----------------------------------
    ��L�̐ݒ�Ńg�����U�N�V�������O�͎c���A�o�^���ꂽ�f�[�^�̓������ɕێ�����
    ������true�ɂ���Ɗ��S���������[�h(�ł������ɉғ�)(�P�̂�memcache�Ƃقړ����x�̏������x���o��)
    ������false�ɂ���Ɗ��S�t�@�C�����[�h(�ł���ʂ̃f�[�^(Value�̃T�C�Y)��ێ��\)

    �f�t�H���g�ł�2560�o�C�g��value�T�C�Y�̍ő�l�ƂȂ�̂ŁAsrc\org\imdst\util\ImdstDefine.java��150�s�ڂ�
    �ύX��compile.bat�����s���R���p�C������Ƌ��e�ł���f�[�^�T�C�Y���ύX�ł���B


  ��Key�l����Hash�l�����߂郍�W�b�N��ύX
    okuyama�ł͓o�^���ꂽKey�l�̓n�b�V���l�����߂Ă��̒l�����ۂ̓o�^�Ɏg�p���Ă��邪�A
    ���̒l�̐������W�b�N���������A���n�b�V���l�����U����悤�ɕύX
    ���̕ύX�ɂ��A���܂œo�^�����f�[�^�͑S�Ĕj������K�v������܂��B
    ���̕ύX���󂯓�����Ȃ��ꍇ��src\org\imdst\helper\MasterManagerHelper.java��2660�s�ځA2661�s�ڂ�
    �ȉ��̂悤�ɕύX���Acompile.bat�����s���ăR���p�C�������s�B
    --------------------------------------------------------------------
    private int hashCodeCnv(String str) {
        return new HashCodeBuilder(17,37).append(str).toHashCode();
        //return str.hashCode();
    }
               ���������ύX(�R�����g�A�E�g�����ւ�)
    private int hashCodeCnv(String str) {
        //return new HashCodeBuilder(17,37).append(str).toHashCode();
        return str.hashCode();
    }
    --------------------------------------------------------------------


  ���f�[�^�o�^���\�b�hsetValue���̏������x��20%����
    �f�[�^�m�[�h�A�X���[�u�f�[�^�m�[�h�N������setValue�����s�����ۂ̏������x��
    20%����B�f�[�^�m�[�h�ւ̓o�^���N�G�X�g���M���ɃX���[�u�f�[�^�m�[�h�ւ̑��M����������悤�ɏC���B


  ���o�OFix
    

========================================================================================================
========================================================================================================
[New - �@�\�ǉ�]
[[�����[�X Ver 0.6.2 - (2010/05/09)]]
  ��Memcahe�v���g�R�����[�h���̈ȉ��̏�����Ή�
    1.memcache�̃��\�b�h�ł���add�ɑΉ�
      ���o�^�f�[�^�̏ꍇ�̂ݓo�^�\��memcache��add�R�}���h�ɑΉ�

    2.memcache�̃��\�b�h�ł���delete�ɑΉ�
      memcache�R�}���h�ł���f�[�^�폜�p�R�}���hdelete�ɑΉ�

    3.memcache��flag�o�^�ɑΉ�
      memcache�R�}���h��set�Aadd���Ɏw�肷��flag�ɑΉ�
      get���ɓo�^flag��ԋp

  ���f�[�^�m�[�h�Ԃ̃f�[�^���J�o�[���̃f�[�^�]���������ꕔ�ύX
    �]���̓m�[�h�_�E������̃��J�o�[���Ƀ��v���P�[�V�����m�[�h�����1�ʐM�őS�Ă̓o�^�f�[�^�擾���Ă��������A
    ����ł͑傫�ȃf�[�^���o�^����Ă���ꍇ�ɁA���M���A��M���Ń������ɂ̂肫�炸�Ƀ��J�o�[�Ɏ��s����ꍇ��
    ���������߁A�g�p�\�ȃ������̎c�ʂ��m�F���Ȃ���A�f�[�^�𕪊����ē]�������J�o���[����悤�ɕύX
    ���f�[�^�̕ۑ��������������ł͂Ȃ��t�@�C���ɂ��Ă���ꍇ�́A���ɂ��̖��͔�������\�����������B

  ��PHP�p�N���C�A���g(OkuyamaClient.class.php)��getByteValue���\�b�h��ǉ�
    Java�p�N���C�A���g�œo�^�����o�C�g�f�[�^(setByteValue�œo�^�����f�[�^)���擾����ۂɎg�p

  ���o�OFix

========================================================================================================
========================================================================================================
[New - �@�\�ǉ�]
[[�����[�X Ver 0.6.1 - (2010/04/21)]]
  ���f�[�^�����݂��Ȃ��ꍇ�̂ݕۑ��ł��郁�\�b�h��ǉ�
    +���o�^�̃L�[�l�ł���ꍇ�̂ݓo�^�\�ƂȂ�A���ɓo�^�ς݂̏ꍇ�͓o�^�ł��Ȃ��B

     *���o�^�̏ꍇ�̂ݓo�^�\�ȃ��\�b�h�͈ȉ��ł���B
      �E�N���C�A���g�̃��\�b�h��:setNewValue
      �E����1:Key�l
      �E����2:Value�l
      �E�߂�l:String[] �v�f1(�f�[�^�L��):"true" or "false",�v�f2(���s���̓��b�Z�[�W):"���b�Z�[�W"

      �E�N���C�A���g�̃��\�b�h��:setNewValue
      �E����1:String Key�l
      �E����2:String[] tag�l�z��
      �E����3:String Value�l
      �E�߂�l:String[] �v�f1(�f�[�^�L��):"true" or "false",�v�f2(���s���̓��b�Z�[�W):"���b�Z�[�W"

  ���N���C�A���g����ڑ����ɕۑ��o����ő�f�[�^�T�C�Y��MasterNode����擾����悤�ɕύX

  ���o�OFix

========================================================================================================
========================================================================================================
[New - �@�\�ǉ�]
[[�����[�X Ver 0.6.0 - (2010/04/08)]]
  �����U���b�N�@�\��ǉ�
    +�C�ӂ̃f�[�^�����b�N����@�\��ǉ��B
    +���U���b�N�@�\�̓}�X�^�[�m�[�h�p�ݒ�t�@�C���ł���AMasterNode.properties��9�s�ڂ�"TransactionMode=true"��
     ���b�N�@�\���g�p�\�ƂȂ�B
     �܂��A72�s�ڂ�"TransactionManagerInfo=127.0.0.1:6655"��TransactionManager�m�[�h���w�肷��K�v������
     �����āATransactionManager�m�[�h���N�����Ă���K�v�����邽�߁A������execTransactionNode.bat�ŋN������B
     ���U���b�N�@�\���g�p����ꍇ�́A�S�Ẵ}�X�^�[�m�[�h��"TransactionMode=true"�ŋN�����Ă���K�v������B
     �����̐ݒ�t�@�C���͑S�ĕ��U���b�N�@�\�ŋN������ݒ�ƂȂ�B
     ��execMasterNodeMemcached.bat�͕��U���b�N�@�\����Amemcache�v���g�R�����[�h�ŋN������B
     �܂��A�]���̕��U���b�N�@�\�Ȃ��ŋN������ꍇ�́A"TransactionMode=false"�Ƃ���execMasterNode.bat�����s����B

    +�d�g�݂Ƃ��ẮAClient���烍�b�N�擾�˗����s�����ꍇ�ATransactionManager�m�[�h�Ɏw�肵��Key�l��
     ���b�N�������グ��B���̍ہA���łɕ�Client���瓯���Key�l�Ń��b�N���擾����Ă���ꍇ�́A
     �w�肵�����Ԃ̊ԁA���b�N�����������̂�҂��A�擾�����݂�B
     ���b�N���ꂽ�l�ɑ΂��āAset,remove�n�̃A�N�Z�X���s�����ꍇ�́ATransactionManager�m�[�h�ɑ΂��ĊY����
     Key�l���A���N�G�X�g�𔭍s����Client�ȊO���烍�b�N����Ă��邩��₢���킹�āA�ʃN���C�A���g�����b�N
     ���Ă���ꍇ�́A���b�N�����������̂�҂�������B
     ���N���C�A���g�����b�N���Ă���������́A���b�N���Ȃ��ꍇ�́A���̂܂܏����𑱍s����B
     ���b�N�̃����[�X�����������ł���B
     �Ȃ��A���U���b�N�@�\��L���ɂ����ꍇ�́A�������Ɣ��1��ʐM�������������邽�߁A�������x�͗�����B
     �܂��ATransactionManager�m�[�h��SPOF�ƂȂ邪�A�@�\���Ă��Ȃ��ꍇ�͖������ĉғ����邪�A
     �������x�͋ɒ[�ɗ򉻂���B
     ����ASPOF�ƂȂ�Ȃ��悤�ɉ��P�\��ł���B

    +�ȉ��͐����ƂȂ�
     *���b�N�����{�����f�[�^�̋����͈ȉ��ƂȂ�B
      �E���b�N�\��Key�l(�f�[�^)�͌��ݓo�^�ς݂ł����Ă��A�o�^����Ă��Ȃ��Ă��\�ł���B
      �E1�N���C�A���g���瓯���ɕ����̃f�[�^�����b�N�\�ł���
      �E���b�N�����f�[�^�̓��b�N�����{�����N���C�A���g����̂݃��b�N�����\�ł���B
      �E���b�N���̃f�[�^�̓��b�N�����{�����N���C�A���g����̂ݓo�^�\�ł���B
      �E���b�N���̃f�[�^�̓��b�N�����{�����N���C�A���g����̂ݕύX�\�ł���B
      �E���b�N���̃f�[�^�̓��b�N�����{�����N���C�A���g����̂ݍ폜�\�ł���B
      �E���b�N���̃f�[�^�͑S�N���C�A���g����Q�Ɖ\�ł���B
 
     *���b�N�@�\�g�p�J�n���\�b�h�͈ȉ��ł���B
      �E�N���C�A���g�̃��\�b�h��:startTransaction
      �E�����Ȃ�
      �E�߂�l:boolean true:�X�^�[�g���� false:�X�^�[�g���s
        �����b�N�@�\�L���TransactionManager�m�[�h���N�����Ă��Ȃ��ꍇ�́A�X�^�[�g�Ɏ��s����B
          
     *���b�N���\�b�h�ւ̈����Ɩ߂�l�͈ȉ��ł���B
      �E�N���C�A���g�̃��\�b�h��:lockData
      �E����1:���b�N�Ώ�Key�l
        ����2:���b�N�p������
              (���b�N�������s��Ȃ��ꍇ�ł��A�����ł̐ݒ莞�Ԃ��o�߂���Ǝ����I�ɉ��������B
               �P�ʂ͕b�B
               0��ݒ肷��ƃ��b�N�����{�����N���C�A���g����������܂ŉi�v�Ƀ��b�N�����B
               ��0�w��͐������Ȃ�)
        ����3:���b�N�擾�҂�����
              (���ɕʃN���C�A���g�����b�N���̃f�[�^�փ��b�N�����{�����ꍇ�ɁA�ݒ莞�Ԃ̊ԃ��b�N�擾�����g���C����B
               �P�ʂ͕b�B
               0��ݒ肷���1�񃍃b�N�����݂�)
 
      �E�߂�l:String�z��
               String�z��[0]:Lock���� "true"=Lock���� or "false"=Lock���s
 
     *���b�N�J���ւ̈����Ɩ߂�l�͈ȉ��ł���B
      �E�N���C�A���g�̃��\�b�h��:releaseLockData
      �E����1:���b�N�Ώ�Key�l
 
      �E�߂�l:String�z��
               String�z��[0]:�J������ "true"=�J������ or "false"=�J�����s

     *���b�N�@�\�g�p�I�����\�b�h�͈ȉ��ł���B
      �E�N���C�A���g�̃��\�b�h��:endTransaction
      �E�����Ȃ�
      �E�߂�l�Ȃ�

    +Java�ŁAPHP�ł̃N���C�A���g����́A���b�N�A�����[�X�������\
     Memchache�N���C�A���g�̓��b�N�A�����[�X�@�\�͗��p�ł��Ȃ����ALock���̃f�[�^��set�����s�����ꍇ��"�҂����"�ɓ���B

   ����ImdstKeyValueClient���g�p����������)��������������������������������������������������������������������
   ��                                                                                                        ��
   �� // �N���C�A���g�C���X�^���X�쐬                                                                        ��
   �� ImdstKeyValueClient client = new ImdstKeyValueClient();                                                ��
   �� // �ڑ�                                                                                                ��
   �� imdstKeyValueClient.connect("127.0.0.1", 8888);                                                        ��
   �� // Transaction���J�n���ăf�[�^��Lock��A�f�[�^���X�V�A�擾���ALock������                               ��
   ��                                                                                                        ��
   �� // ������Lock�Ώۂ�Key�l, Lock�ێ�����(�b)(0�͖�����), Lock�����Ɏ擾����Ă���ꍇ��                  ��
   �� // �擾���g���C�������鎞��(�b)(0��1��擾�����݂�)                                                    ��
   �� ImdstKeyValueClient imdstKeyValueClient = new ImdstKeyValueClient();                                   ��
   �� imdstKeyValueClient.connect(args[1], port);                                                            ��
   �� String[] ret = null;                                                                                   ��
   ��                                                                                                        ��
   �� // Lock����                                                                                            ��
   �� if(!imdstKeyValueClient.startTransaction()) throw new Exception("Transaction Start Error!!");          ��
   ��                                                                                                        ��
   �� long start = new Date().getTime();                                                                     ��
   ��                                                                                                        ��
   �� // Lock���s                                                                                            ��
   �� // "DataKey"�Ƃ���Key�l��10�b�Ԉێ����郍�b�N���쐬�B�������Ƀ��b�N����Ă���ꍇ�́A5�b�ԃ��b�N�擾�� ��
   �� // �J��Ԃ�                                                                                            ��
   �� ret = imdstKeyValueClient.lockData("DataKey", 10, 5);                                                  ��
   �� if (ret[0].equals("true")) {                                                                           ��
   ��     System.out.println("Lock����");                                                                    ��
   �� } else if (ret[0].equals("false")) {                                                                   ��
   ��     System.out.println("Lock���s");                                                                    ��
   �� }                                                                                                      ��
   ��                                                                                                        ��
   ��                                                                                                        ��
   �� // �ȉ��̃R�����g�A�E�g���͂����āA�R���p�C�����A                                                      ��
   �� // �ʂ̃N���C�A���g����X�V�����s����ƁA�X�V�ł��Ȃ��̂��킩��                                        ��
   �� //Thread.sleep(5000);                                                                                  ��
   ��                                                                                                        ��
   �� // ���g�Ń��b�N���Ă���̂ōX�V�\                                                                    ��
   �� if (!imdstKeyValueClient.setValue(args[3], "LockDataValue")) {                                         ��
   ��   System.out.println("�o�^���s");                                                                      ��
   �� }                                                                                                      ��
   ��                                                                                                        ��
   �� // �擾                                                                                                ��
   �� ret = imdstKeyValueClient.getValue(args[3]);                                                           ��
   �� if (ret[0].equals("true")) {                                                                           ��
   ��     // �f�[�^�L��                                                                                      ��
   ��     System.out.println("Lock���ɓo�^�����f�[�^[" + ret[1] + "]");                                      ��
   �� } else if (ret[0].equals("false")) {                                                                   ��
   ��     System.out.println("�f�[�^�Ȃ�");                                                                  ��
   �� } else if (ret[0].equals("error")) {                                                                   ��
   ��     System.out.println(ret[1]);                                                                        ��
   �� }                                                                                                      ��
   ��                                                                                                        ��
   �� // ���g�Ń��b�N���Ă���̂ō폜�\                                                                    ��
   �� ret = imdstKeyValueClient.removeValue(args[3]);                                                        ��
   ��                                                                                                        ��
   �� if (ret[0].equals("true")) {                                                                           ��
   ��     // �f�[�^�L��                                                                                      ��
   ��     System.out.println("Lock���ɍ폜�����f�[�^[" + ret[1] + "]");                                      ��
   �� } else if (ret[0].equals("false")) {                                                                   ��
   ��     System.out.println("�f�[�^�Ȃ�");                                                                  ��
   �� } else if (ret[0].equals("error")) {                                                                   ��
   ��     System.out.println(ret[1]);                                                                        ��
   �� }                                                                                                      ��
   ��                                                                                                        ��
   �� // Lock�J��                                                                                            ��
   �� ret = imdstKeyValueClient.releaseLockData(args[3]);                                                    ��
   �� if (ret[0].equals("true")) {                                                                           ��
   ��     System.out.println("Lock�J������");                                                                ��
   �� } else if (ret[0].equals("false")) {                                                                   ��
   ��     System.out.println("Lock�J�����s");                                                                ��
   �� }                                                                                                      ��
   ��                                                                                                        ��
   �� long end = new Date().getTime();                                                                       ��
   �� System.out.println((end - start) + "milli second");                                                    ��
   ��                                                                                                        ��
   �� // �g�����U�N�V�����J��                                                                                ��
   �� imdstKeyValueClient.endTransaction();                                                                  ��
   �� // �ڑ��ؒf                                                                                            ��
   �� imdstKeyValueClient.close();                                                                           ��
   ������������������������������������������������������������������������������������������������������������

  ���������̃o�O���C��

  ������́A���U�g�����U�N�V��������������悤�Ɏ�����i�߂�B
========================================================================================================
========================================================================================================
[New - �@�\�ǉ�]
[[�����[�X Ver 0.5.2 - (2010/03/28)]]
  ��Memcache�v���g�R���Ɉꕔ�Ή�
    KVS�̕W���v���g�R���ɂȂ����Amemcache�̃v���g�R���ɑΉ����郂�[�h��ǉ�
    MasterNode.properties��14�s��"MasterManagerJob.Option="��"MasterManagerJob.Option=memcache"�Ƃ����
    memcache�v���g�R���ŃA�N�Z�X�\�ł���B
    MasterNode2.properties��memcache�p�̐ݒ�t�@�C���ɂȂ��Ă���B
    execMasterNodeMemcached.bat�����s�����memcache�v���g�R���ŗ����オ��B
    �Ή����\�b�h��set��get�ł���B�܂�set,get��flag��0�̂ݑΉ����Ă���B
    ����Ή��͈͂𑝂₷�\��B

  ���f�[�^�ۑ��`�����t�@�C��(DataNode.properties30�s�ځA33�s�ڂ�false�Ƃ����ꍇ)�ɂ����ꍇ�ɁA
    �ǋL�^�ŋL�����Ă��邽�߁A�t�@�C�����i���ɔ�剻���邽�߁Avacuum�@�\��ǉ��B
    �����I�Ɏ��s�����B

  ��documet�f�B���N�g����ǉ�
    ���\�]�������{���������ƁA�\���}��z�u

========================================================================================================
========================================================================================================
[New - �@�\�ǉ�]
[[�����[�X Ver 0.5.1 - (2010/03/17)]]
  ��PHP�p�̃N���C�A���g���쐬
    PHP��MasterServer�փA�N�Z�X�o����悤�ɃN���C�A���g���쐬�B
    Java�̃R�[�h���Ă��Ȃ����܂����B
    �o�C�g�f�[�^��o�^(setByteValue)�A�擾(getByteValue)���郁�\�b�h�̂ݖ������B
    �����[�X��etc_client\OkuyamaClient.class.php�ɂȂ�܂��B
    �T���v�����s�R�[�hetc_client\PhpTestSock.php�ƁA���s�pbat�t�@�C��etc_client\PhpAutoTest.bat�𓯍����܂����B

  ��ReadMe.txt�AReadMe-UTF.txt���ŐV�̏�ԂɍX�V

  ��ReadMe.txt�AReadMe-UTF.txt��"[[�����[�X Ver 0.5.0 - (2010/03/17)]]"�̋L�q�~�X�����
    �����ӏ��͈ȉ�
    -------------------------------------------------------------------------------------------------------------------------------------------
    ��TestSock�T���v����Script���s���[�h�̃o�[�W������ǉ�(���� "2.3" Script���s)
    �E�擾�A���s�T���v���N�����@
    java -cp ./;./classes;./lib/javamail-1.4.1.jar TestSock 2.3 127.0.0.1:8888 20000 "var dataValue; var retValue = dataValue.replace('data', 'dummy'); var execRet = '1';"
                                                                        ^^^
                                                               �������� 127.0.0.1 8888
    -------------------------------------------------------------------------------------------------------------------------------------------

========================================================================================================
========================================================================================================
[New - �@�\�ǉ�]
[[�����[�X Ver 0.5.0 - (2010/03/17)]]
  ���f�[�^�擾����JavaScript�����s�\�ȃC���^�[�t�F�[�X��ǉ�
    ImdstKeyValueClient��getValueScript���\�b�h�Ŏ��s�\�B
    �f�[�^�擾����JavaScript�ŋL�q�����X�N���v�g��Key�l�Ɠ����ɓn���AKey�l��Value�l���擾�o�����ꍇ�A
    ���̒l�ɃX�N���v�g�����s�����̌��ʂ��擾�ł���B
    �X�N���v�g���ŁA�ԋp�L���̌���y�сA�ԋp�l(Value)��ݒ肷�邱�Ƃ��o����B
    �X�N���v�g�̓f�[�^�m�[�h�Ŏ��s����邽�߁A���܂Ŏ擾�����f�[�^�ɑ΂��ĉ������̏����ŉ��Hor�l�̑Ó���
    ���؂Ȃǂ��s���Ă����ꍇ�́A�X�N���v�g�ŏ������s���A�擾�}�V���̃��\�[�X�̐ߖ��A�擾�}�V����
    �X�y�b�N���z����悤�ȑ�K�͂ȃf�[�^���f�[�^�m�[�h�̃p���[���g�p���ď����\�ł���B

    �y�X�N���v�g�L�q����z
     �X�N���v�g�̐���͈ȉ��̖��O�̕ϐ���錾����K�v������B
    �E "dataValue" = key�l�Ŏ擾�o����value�l���ݒ肳���B�X�N���v�g���ł͂��̕ϐ���value�l�ƂȂ�B
    �E "execRet" = ���s����(retValue�ϐ�)���N���C�A���g�ɕԂ����Ƃ��w��
                   (1��������ƕԋp����� 0��������ƕԋp����Ȃ�)
    �E "retValue" = ���s���ʂ��i�[����B�N���C�A���g�ɕԂ����l

   ����ImdstKeyValueClient���g�p����������)��������������������������������������������������������������������
   ��                                                                                                        ��
   �� StringBuffer scriptBuf = new StringBuffer();                                                           ��
   �� // �X�N���v�g���쐬                                                                                    ��
   �� scriptBuf.append("var dataValue;");                                                                    ��
   �� scriptBuf.append("var execRet;");                                                                      ��
   �� scriptBuf.append("var retValue;");                                                                     ��
   �� // �擾����Value�l��"data"�Ƃ�������������ꍇ��"dummy"�ɒu������                                      ��
   �� scriptBuf.append("retValue = dataValue.replace('data', 'dummy');");                                    ��
   �� // �ԋp�w��                                                                                            ��
   �� scriptBuf.append("execRet = '1';");                                                                     ��
   ��                                                                                                        ��
   �� // �N���C�A���g�C���X�^���X�쐬                                                                        ��
   �� ImdstKeyValueClient client = new ImdstKeyValueClient();                                                ��
   �� // �ڑ�                                                                                                ��
   �� imdstKeyValueClient.connect("127.0.0.1", 8888);                                                        ��
   �� // Value�擾�y�сA�X�N���v�g���s���˗�                                                                 ��
   �� String[] retValue = imdstKeyValueClient.getValueScript("key1", scriptBuf.toString());                  ��
   ��                                                                                                        ��
   �� // ���ʂ�\��                                                                                          ��
   �� // ���s���ʂ����݂���ꍇ��"true"�����݂��Ȃ��ꍇ��"false"���A�G���[�̏ꍇ��"error"���ԋp�����        ��
   �� System.out.println(retValue[0]);                                                                       ��
   �� // retValue[0]��"true"�̏ꍇ�̓X�N���v�g����̕ԋp�l���ԋp�����B"error"�̏ꍇ�̓G���[���b�Z�[�W���ԋp��
   �� System.out.println(retValue[1]);                                                                       ��
   ������������������������������������������������������������������������������������������������������������

  ��TestSock�T���v����Script���s���[�h�̃o�[�W������ǉ�(���� "2.3" Script���s)
    �E�擾�A���s�T���v���N�����@
    java -cp ./;./classes;./lib/javamail-1.4.1.jar TestSock 2.3 127.0.0.1 8888 20000 "var dataValue; var retValue = dataValue.replace('data', 'dummy'); var execRet = '1';"

  ���N���C�A���g�Ƀ}�X�^�[�m�[�h�̎����o�������V���O���[�h�y�сA�_�E�����̍Đڑ��@�\��ǉ�
    ImdstKeyValueClient��setConnectionInfos���\�b�h�ɐڑ��ΏۂƂȂ�}�X�^�[�m�[�h�̐ڑ��������z���
    �Z�b�g(�t�H�[�}�b�g"IP:PORT�ԍ�"��String�z��)���AautoConnect���\�b�h�Őڑ�����ƁA�m�[�h�ւ̐ڑ���
    �o���Ȃ��ꍇ�A�ڑ��㏈���r���Őؒf���ꂽ�ꍇ�Ȃǂ��A�����I�ɍĐڑ����ғ��������邱�Ƃ��o����B


  ��TestSock�T���v���Ɏ����ڑ����[�h�̃o�[�W������ǉ�(���� "1.2"�����ڑ��œo�^  "2.2"�����ڑ��Ŏ擾)
    �E�o�^�T���v���N�����@
    java -cp ./;./classes;./lib/javamail-1.4.1.jar TestSock 1.2 "127.0.0.1:8888,127.0.0.1:8889" 20000
    �E�擾�T���v���N�����@
    java -cp ./;./classes;./lib/javamail-1.4.1.jar TestSock 2.2 "127.0.0.1:8888,127.0.0.1:8889" 20000

    ��execMasterNode.bat��execMasterNode2.bat�𓯎��Ɏ��s������Ԃŏ�L�����s���āA�Б�����~���ẮA
      �Ď��s���J��Ԃ��Ă��A�������ғ��������邱�Ƃ��m�F�ł��܂��B

========================================================================================================
========================================================================================================
[New - �@�\�ǉ�]
[[�����[�X Ver 0.4.0 - (2010/03/15)]]
 ���f�[�^�m�[�h�̓��I�ǉ����T�|�[�g
   �}�X�^�[�m�[�h�A�f�[�^�m�[�h�N������MasterNode.properties��KeyMapNodesRule�AKeyMapNodesInfo�A
   SubKeyMapNodesInfo�ɐV���ȃm�[�h�̋L�q��ǋL���ۑ�����ƁA�����I�Ƀt�@�C�����ēǂݍ��݂���A
   �f�[�^�A�X���[�u���m�[�h���ǉ������B
   �ݒ�t�@�C���͍ĕۑ������Ƃقڃ��A���^�C���ɔ��f����邽�߁A�ۑ��O�ɊY���m�[�h���N�����Ă����K�v������B
    �����ݒ�                                                ���m�[�h�ǉ�
   ���� MasterNode.properties����������������������������  ���� MasterNode.properties����������������������������������������������������������
   ��KeyMapNodesRule=2                                 ��  ��KeyMapNodesRule=4,2                                                             ��
   ��                                                  ��  ��                                                                                ��
   ��KeyMapNodesInfo=localhost:5553,localhost:5554     ��=>��KeyMapNodesInfo=localhost:5553,localhost:5554,localhost:6553,localhost:6554     ��
   ��                                                  ���ۄ�                                                                                ��
   ��SubKeyMapNodesInfo=localhost:5556,localhost:5557  ������SubKeyMapNodesInfo=localhost:5556,localhost:5557,localhost:6556,localhost:6557  ��                        ��
   ��                                                  ��  ��                                                                                ��
   ������������������������������������������������������  ������������������������������������������������������������������������������������

 ���f�[�^�m�[�h�ǉ���ɐV�����m�[�h�փf�[�^�̈ڍs���s���@�\��ǉ�
   �f�[�^�m�[�h�ǉ���ɉߋ��f�[�^�m�[�h�䐔�^�p���̃f�[�^�ɃA�N�Z�X�����^�C�~���O�Œǉ���m�[�h��
   ���C���f�[�^�m�[�h�A�X���[�u�f�[�^�m�[�h�փf�[�^�������I�ɕۑ�����悤�ɂ��A�Ȍ�ߋ��̃f�[�^�ۑ��m�[�h��
   �A�N�Z�X���s��Ȃ��悤�ɋ@�\��ǉ��B
   ���m�[�h�ǉ����s���Ǝ����I�Ƀf�[�^�A�N�Z�X���ɍs����B

 ���f�[�^�m�[�h�ւ̃A�N�Z�X�����C���f�[�^�m�[�h�A�X���[�u�f�[�^�m�[�h�ԂŃo�����V���O�o���郂�[�h��ǉ�
   MasterNode.properties��LoadBalanceMode�̐ݒ��true�ɂ���ƃo�����V���O���s���B
   ���C���ƁA�X���[�u�Ő��\���傫���قȂ�ꍇ�̓o�����V���O���s��Ȃ��ق����ǂ��ꍇ������B
   �U�蕪���͒P���ȃ��E���h���r�������ł���B

 ���}�X�^�[�m�[�h�𕡐���ғ������A���ו��U�A�璷���o����@�\��ǉ�
   ���܂ł́A�}�X�^�[�m�[�h��1��\�����������ASPOF�ƂȂ��Ă����ׁA������N���o����悤�ɋ@�\�ǉ��B
   �}�X�^�[�m�[�h��1�`n��ł̍\�����\�����A1��͕K���}�X�^�[�m�[�h���ł̃��C���ɂȂ�Ȃ���΂Ȃ�Ȃ��B
   ���R�́A�f�[�^�m�[�h�̐����Ď��ƕ������̃��J�o���[�����ׂ̈ł���B
   ���J�o���[�������́A�S�Ẵ}�X�^�[�m�[�h���������ĉғ����邽�߁A�s�����͔������Ȃ��\���ƂȂ��Ă���B
   MasterNode.properties��MainMasterNodeMode�����C���̏ꍇ��true�Ƃ��A�X���[�u�̏ꍇ��false�Ƃ���B
   �܂��A�X���[�u�̃}�X�^�[�m�[�h�̃l�b�g���[�N��̖��O�Ɖғ��|�[�g�ԍ���SlaveMasterNodes�ɃJ���}��؂�ŗ񋓂���B
   ���璷�����Ȃ��ꍇ��MainMasterNodeMode=true�Ƃ��邾���ł悢�B

  �����[�X��\(src or classes)\MasterNode.properties(���C���p) �����[�X��\(src or classes)\MasterNode2.properties(�X���[�u�p)
 ���� MasterNode.properties����������������������������      ���� MasterNode2.properties ��������������������������
 ��MainMasterNodeMode=true                           ��      ��MainMasterNodeMode=false                          ��
 ��                                                  ��      ��                                                  ��
 ��SlaveMasterNodes=127.0.0.1:8889                   ��      ��SlaveMasterNodes=                                 ��
 ��                                                  ��      ��                                                  ��
 ������������������������������������������������������      ������������������������������������������������������

   ���C���̃}�X�^�[�m�[�h�ŁA�f�[�^�m�[�h�̊Ď��A�������s�����A���C���̃}�X�^�[�m�[�h���ғ��o���Ȃ���Ԃ�
   �Ȃ����ꍇ�́A�X���[�u�̃}�X�^�[�m�[�h�̐ݒ�t�@�C�����ȉ��̂悤�ɏ��������čĕۑ�����ƁA
   �X���[�u�̃}�X�^�[�m�[�h�����C���̃}�X�^�[�m�[�h�ɕύX����ĉғ����n�߂�B
 ���� MasterNode2.properties   ����������������������������
 ��MainMasterNodeMode=true                               ��
 ��                                                      ��
 ��SlaveMasterNodes=(�ʂ̃}�X�^�[�m�[�h������ꍇ�͋L�q) ��
 ��                                                      ��
 ����������������������������������������������������������
   ��SlaveMasterNodes�ɗ񋓂����m�[�h���ғ����Ă��Ȃ��Ă��A���C���m�[�h�������ғ�����B
   �������I�ɃX���[�u�����C���ɏ��i����悤�Ɍ�قǎ����\��B
   ��ImdstKeyValueClient�ɕ����̃}�X�^�[�m�[�h��ݒ�ł���悤�ɂ��A
     �o�����V���O��A�ڑ��ł��Ȃ��ꍇ�̎����ʃm�[�h�Đڑ��@�\�Ȃǂ���قǎ����\��B

 ���N��bat�t�@�C���ǉ�
   execMasterNode2.bat <=�X���[�u�}�X�^�[�m�[�h�N���R�}���h
   execMasterNode.bat�݂̂ł̉ғ��͏]���Ɠ����悤�ɉ\
========================================================================================================
========================================================================================================
[New - �@�\���P]
[[�����[�X Ver 0.3.3 - (2010/03/12)]]
 ���f�[�^�m�[�h���m�̃f�[�^���J�o�����ɏ]���͋N�����̃m�[�h�̃f�[�^���ċN�����Ă����m�[�h��
   �������Ń��J�o�����Ă��������A�f�[�^�̓o�^�A�폜�Ɏ��{�����̗v�f��ǉ����A���J�o�����Ɏ��{������
   �m�F���A�V�����m�[�h�̃f�[�^��K������悤�ɉ��P�B

========================================================================================================
========================================================================================================
[New - �s��C��&�T���v���R�[�h�ǉ�]
[[�����[�X Ver 0.3.2 - (2010/03/10)]]
 ����萔��Key-Value�𓯂�Tag�ɕR�t���ĕۑ�����Ɛ��������o���Ȃ��s����C��

 ��TestSock�ɃL�[�l���w�肵�č폜���郂�[�h��ǉ�(����"8")
   java -cp ./;./classes;./lib/javamail-1.4.1.jar TestSock 8 127.0.0.1 8888 KeyName1
   ��L��127.0.0.1�̃|�[�g8888�ԂŋN�����Ă���}�X�^�[�m�[�h�ɐڑ����A"keyName1"�Ƃ���Key�l�ŕۑ������
  ����f�[�^���폜����B
========================================================================================================
========================================================================================================
[New - �폜���\�b�h������&�f�[�^�ۑ�����������ƃt�@�C����I���ł���悤�ɋ@�\�ǉ�]
[[�����[�X Ver 0.3.0 - (2010/03/4)]]
 ���폜���\�b�h��ǉ�
   ImdstKeyValueClient��removeValue���\�b�h�ɂČĂяo���\
   ���^�[���l��getValue�Ɠ��l�Ō��ʕ�����("true" or "false")�ƍ폜�ł����ꍇ�͑Ώۂ̒l���i�[���ꂽ�z��
   TestSock��"7"�Ԏw��ŌĂяo���\
   ---------------------------------------------------------------------------------------------------
   java -cp ./;./classes;./lib/javamail-1.4.1.jar TestSock 1 127.0.0.1 8888 100         <= 100���o�^
   java -cp ./;./classes;./lib/javamail-1.4.1.jar TestSock 7 127.0.0.1 8888 50         <= 50���폜

 ���f�[�^�ۑ��`�����������ƃt�@�C����I���\
   ���܂ł̃o�[�W�����ł͉ғ����̓f�[�^�͏��Key��Value�̊֌W�Ń�������ɕێ�����Ă����B
   �o�^���̃g�����U�N�V�����L�^�t�@�C���ƁA����I�ȃ��������̃t�@�C�������o���ŉi������ۂ��Ă������A
   �t�@�C�������o�����[�h�ł�Key�̂݃�������ɕێ����f�[�^�̓t�@�C���Ƀ��X�g�A���邱�Ƃ������B
   ����ɂ�胁��������ł̏������Ȃ����邱�Ƃ��\�ł���A�e�X�g�ł�JVM�I�v�V������-Xmx256m�Ƃ���
   DataNode��400�����ȏ�̃f�[�^���i�[�o�����B
   (��Key�l�̒�����DataNode�i�[���͉e�����Ȃ����A�Q�l��"datasavekey_1"�`"datasavekey_4000000"�Ƃ���Key�l)
   �������A���܂Ő����݂��Ă��Ȃ������i�[�f�[�^���ɐ��񂪏o�����B
   ���݊i�[�ł���Value�̃T�C�Y�́A512byte�ł���B
   ����ȏ�̃f�[�^�����i�[����ꍇ�́AImdstKeyValueClient��setByteValue���\�b�h���g�p���邱�ƂƂȂ�B
   ��512�̎w���ύX����ꍇ�͈�x�S�Ẵf�[�^�t�@�C��(�T���v���ł�.\keymapfile�f�B���N�g���̃t�@�C��)��
     �S�č폜���Ă���AImdstDefine��saveDataMaxSize��ύX���邱�ƂőΉ��\�B
   ���f�[�^�t�@�C���ۑ����@�͒ǋL�^�ƂȂ�̂ŁA����o�L���[�����\�b�h�������\��B
   ���������ƃt�@�C���̐؂�ւ���DataNode.properties��
     "KeyManagerJob1.dataMemory=false" <=�t�@�C��
     "KeyManagerJob1.dataMemory=true"  <=������
     �Ő؂�ւ��\

========================================================================================================
========================================================================================================
[New - MasterNode�����������œK��&���\�]���̃e�L�X�g��Y�t]
[[�����[�X Ver 0.2.2 - (2010/02/24)]]
 ��MasterNode�̃��W�b�N���œK���B
   �œK���c�ӏ��͂܂��c���Ă���B

 ���œK���O�ƌ�ŁA�ȒP�ɐ��\�𑪒�B���茋�ʂ��e�L�X�g�Ƃ��ēY�t
========================================================================================================
========================================================================================================
[New - �s��C��]
[[�����[�X Ver 0.2.1 - (2010/02/11)]]
 ���������J�o�[���̋������C���B
   ��~�m�[�h�N�����̃^�C�~���O�ɂ���Đ������f�[�^�����J�o���[����Ȃ��s����C���B

 ��src\MasterNode.properties�ɃR�����g��ǉ��B
========================================================================================================
========================================================================================================
[New - �@�\�ǉ�]
[[�����[�X Ver 0.2.0 - (2010/02/08)]]
 ���������v���P�[�V�����y�сA�������J�o���[�@�\��ǉ�
   �f�[�^�m�[�h�N���b�V�������V�X�e���̋@�\��~��h�~�B

 [�ǉ��@�\�ڍ�]
  1. 1�̃f�[�^�𕡐��̃f�[�^�m�[�h�ɓo�^����悤�@�\��ǉ�(�������v���P�[�V����)
     ���U�o�^���s�����ƂŁA�����I�Ƀf�[�^�̕������s���A�����S���̍������UKVS�ւƐi�����܂����B

  2. �������J�o���[�@�\
     1.�̋@�\���g�p���Ă���ꍇ�A���C���f�[�^�m�[�h���N���b�V�������ꍇ���A���C���f�[�^�m�[�h���A��A
     �X���[�u�m�[�h(���v���P�[�V�����m�[�h)���玩���I�Ƀf�[�^�𕜌����܂��B
     ���X���[�u�m�[�h���N���b�V�������ꍇ���A���A�㎩���I�Ƀ��C���f�[�^�m�[�h���畜������܂��B

  3. ��L2�̋@�\���g�p���Ă���ꍇ�̓m�[�h��~�����V�X�e���̒�~�Ȃ��Ɏg�p�\
     �f�[�^�m�[�h�N���b�V�������X���[�u�m�[�h(���v���P�[�V�����m�[�h)�ւ̎����ڍs���s���邽�߁A
     �g�p�V�X�e���̒�~������܂���B

  ����L�̎g�p���@�́Asrc\MasterNode.properties���Q�Ƃ��Ă��������B
  ��execMasterNode.bat�̓}�X�^�[�m�[�h���N�����܂��B
  ��execDataNode.bat�̓��C���f�[�^�m�[�h���N�����܂��B
  ��execSlaveDataNode.bat�̓X���[�u�f�[�^�m�[�h���N�����܂��B
========================================================================================================


�X�y�b�N
 ��������:Java(jdk1.6�ɂĊJ��)
 �\�[�X�G���R�[�f�B���O:UTF-8
 ���쌟��OS:WinsowsXp SP3�ACentOS 5.3(final)
 �K�v���C�u����:log4j-1.2.14.jar�Ajavamail-1.4.1.jar(JavaMail Ver1.4.1)
 Version:0.6.5(2010/05/30)


���@�\�����ƃT���v���̎��s���@
[�@�\����]
1.Key-Value�X�g�A
  Key-Value�X�g�A���������܂��B
  Key�͕�����AValue�͕�����ƁAbyte�f�[�^�̗�����o�^�\�ł��B

2.Tag�@�\
  Key�̑���Tag��o�^�ł��܂��B
  Tag�͕�����ƂȂ�܂��B
  �X�g�A�ł�Key�̓��j�[�N�Ȓl�Ƃ��Ĉ����܂����ATag�͕����̃f�[�^�ɕR�t����
  ���Ƃ��o���܂��B
  �����f�[�^�ɂ��炩���ߔC�ӂ�Tag��t���邱�ƂŁATag�w��ɂ��
  ��x�Ɋ֘A�f�[�^���擾�\�ƂȂ�܂��B
  �����݂�Tag�w��Ŋ֘A����f�[�^��Key�z�񂪎擾�ł��܂��B


4.�I���������ł���A�i�������ꂽ�f�[�^
  �f�[�^�̓o�^���N���C�A���g�����߂��A��������Ƃ��̃f�[�^��2��̃f�[�^�m�[�h�ɓo�^����܂�
  �o�^�̂��ꂩ���́AKey�l�̓�����(��1)�ƃt�@�C��(��2)�ɁAValue�l�̓t�@�C��(��3)�ɂ̂ݓo�^����܂��B
  Value�l��������(��1,4)�ɂ̂ݓo�^���邱�Ƃ��\�ł��B
  ��L2�ȊO�Ƀg�����U�N�V�������O�������Ƀt�@�C���ɓo�^���Ă��܂��B
  �f�[�^�m�[�h���_�E�����Ă��������ۑ����ꂽKey�l���t�@�C����񂩂畜�����邩�A
  Key�l�̃t�@�C���ւ̔��f�͒���I�ł��邽�߁A���̊Ԃŕۑ��O�Ƀ_�E�������������͔j�����Ă���ꍇ�́A
  �g�����U�N�V�������O���畜������܂��B

  ��1.�o�^�f�[�^�͊e�f�[�^�m�[�h���1��ConcurrentHashMap�Ɋi�[����܂��B
      �f�[�^�̓o�^�A���o���͑S�Ă�������s���܂��B
  ��2.�t�@�C���V�X�e���ɕۑ������f�[�^�́A����I�ɕۑ������ConcurrentHashMap��
      �V���A���C�Y�������f�[�^�ƁA�f�[�^�o�^���̃��O���ƂȂ�܂��B
      �V���A���C�Y�f�[�^�̓o�^�̓f�[�^�o�^�A�擾�����Ƃ͔񓯊��ɂĎ��s����܂��B
  ��3.Value�l�͌Œ蒷��LF���s��1�t�@�C���ɏ������܂�܂��B
      �L�^�����͒ǋL�^�ƂȂ�܂��B
      Key�l�͂���Value�l�̍ŐV�̈ʒu�������Ă��܂��B
  ��4.DataNode.properties��"KeyManagerJob1.dataMemory"�̒l�ŕύX�\
      true�Ń������ێ��Afalse�Ńt�@�C���ۑ�
      �ǂ���̏ꍇ���g�����U�N�V�������O�͕ۑ������̂ŁA�s���̃_�E���ɂ��f�[�^�̕����ɂ͉e���͂���܂���B
      ��KeyManagerJob1.memoryMode=true�̏ꍇ�͕�������܂���


5.���U�^
  �uokuyama�v�̓}�X�^�m�[�h�A�f�[�^�m�[�h�A�g�����U�N�V�����m�[�h�A�N���C�A���g��4�ō\������܂��B
  ���ꂼ��̖�ڂ͈ȉ��ł��B
  �}�X�^�m�[�h:�E�ݒ肳�ꂽ�A���S���Y��(��1)�ɏ]���āA�N���C�A���g����̃f�[�^����˗���K�؂�
                 �f�[�^�m�[�h�Ɉ˗����܂��B
               �E1�̃f�[�^��2��̃f�[�^�m�[�h�Ƀ��v���P�[�V�������܂�
                 �擾���ɊY���f�[�^�m�[�h���_�E�����Ă�ꍇ���A���v���P�[�V������̃f�[�^�m�[�h����擾���܂��B
                 �܂��A�f�[�^�m�[�h��2��Ƃ��ғ����Ă���ꍇ�́A�����𕪎U�����ו��U���s���܂��B
                 �f�[�^�o�^����1��̃f�[�^�m�[�h���_�E�����Ă���ꍇ���������̃m�[�h�ɕۑ��������𑱍s���܂��B
               �E������ł̏璷�����\�ł���B
                 ������ŉғ�����ꍇ�́AMasterNode���ł�Main�m�[�h�����肷��K�v������B
               �E��~�Ȃ��ł̓��I�ȃf�[�^�m�[�h�̒ǉ����������܂��B
                 �f�[�^�m�[�h��ǉ������ꍇ���A����܂łɓo�^�����f�[�^�ւ̃A�N�Z�X�͓����悤�ɉ\�ł��B
               �E���DataNode�̐������Ď����A�_�E������̕������Ƀf�[�^���ғ��m�[�h���玩�����J�o�[�����܂��B
                 ���J�o�[���̓f�[�^�̕s�������������Ȃ��悤�ɓ��������������܂��B
                 ��1.�Ǘ�����f�[�^�m�[�h�̐��Ɉˑ�����ȒP�ȃA���S���Y���ł��B
               �E�ݒ�t�@�C����src\MasterNode.properties


  �f�[�^�m�[�h:�E������ł̍\�����\
               �E�L�[�ƃf�[�^�̑g�ݍ��킹�Ńf�[�^��ۑ����܂��B
                 �f�[�^�̓o�^�A���o�A�폜�C���^�[�t�F�[�X�������܂��B
               �E���g�ł͑��m�[�h�ւ̃f�[�^�̐U�蕪���Ȃǂ͍s�Ȃ��܂���B
               �E�ݒ�t�@�C����src\DataNode.properties

  �g�����U�N�V�����m�[�h:�E���ULock(TransactionMode)���g�p����ꍇ��Lock��ێ��A�Ǘ����܂��B
                           TransactionMode���g�p���Ă��āA���̃m�[�h���_�E������Ƌɒ[�ɃX���[�v�b�g���_�E�����܂��B
                           ������C�\��B
                         �E�ݒ�t�@�C����src\TransactionNode.properties

  �N���C�A���g:�E�}�X�^�m�[�h�ւ̒ʐM���s�����ۂ̃v���O�����C���^�[�t�F�[�X�ł��B
               �E�}�X�^�[�m�[�h�̏��𕡐��Z�b�g���邱�ƂŎ������U��A�}�X�^�[�m�[�h�_�E������
                 �ʃm�[�h�ւ̎����Đڑ��������Ȃ��܂��B
               �EJava��PHP���ꂼ��̃N���C���v���O����������܂��B
                 �g�p���@�͈ȉ��̍��������̓����[�X���̃T���v���v���O����TestSock.java�������́A
                 etc_clietn\PhpTestSock.php���Q�Ƃ��Ă��������B
                 �N���C�A���g�̃\�[�X�t�@�C����
                 Java��src\org\imdst\client\ImdstKeyValueClient.java
                 PHP��etc_client\OkuyamaClient.class.php

               �C���^�[�t�F�[�X�Ƃ��ẮA
               1.setValue(Key�l, Value�l)                 :[Key(������)��Value(������)�̑g�ݍ��킹�ł̃f�[�^�o�^]
               2.setValue(Key�l, Tag�l�z�� Value�l)       :[Key(������)��Tag(������(�z��))��Value(������)�̑g�ݍ��킹�ł̃f�[�^�o�^]
               3.getValue(Key�l)                          :[Key(������)�ł�Value(������)�擾]
               4.getTagKeys(Tag�l)                        :[Tag(������)�ł�Key�l�Q(Key�l�̔z��)�擾]
               5.setByteValue(Key�l, byte�l)              :[Key(������)��byte�z��̑g�ݍ��킹�ł̃f�[�^�o�^](PHP�͖�����)
               6.setByteValue(Key�l, Tag�l�z�� byte�l)    :[Key(������)��Tag(������(�z��))��byte�z��̑g�ݍ��킹�ł̃f�[�^�o�^](PHP�͖�����)
               7.getByteValue(Key�l)                      :[Key(������)��Value�l��Byte�z��Ŏ擾����.setByteValue�œo�^�����l�̂ݎ擾�ł���]
               8.removeValue(Key�l)                       :[Key(������)�Ńf�[�^���폜]
               9.getValueScript(Key�l,JavaScript�R�[�h)   :[Key(������)��JavaScript�R�[�h��n���A�擾���ꂽvalue�l��JavaScript�����s���l��Ԃ�]
              10.startTransaction()                       :[Transaction���[�h���̂݁BTransaction���J�n����(���ULock���g�p�\�ɂȂ�)]
              11.lockData(Key�l,Lock����,Lock�擾�҂�����):[Transaction���[�h���̂݁BKey�l��Lock���s���BLock���ԂŎw�肵�����Ԉێ������(0�͖�����)�A�ʂ̃N���C�A���g��Lock���Ă���ꍇ��Lock�擾�҂����Ԃ̊ԃ��g���C����]
              12.releaseLockData(Key�l)                   :[Transaction���[�h���̂݁B���g�̎擾����Lock���J������]
              13.setNewValue(Key�l, Value�l)              :[���o�^��Key�l�̏ꍇ�̂ݓo�^�ł���]
              14.setNewValue(Key�l, Tag�l�z�� Value�l)    :[���o�^��Key�l�̏ꍇ�̂ݓo�^�ł���]

  ���ꂼ��̃m�[�h�Ԃ̒ʐM��TCP/IP�ł̒ʐM�ƂȂ�܂��B
  �܂��A�N���C�A���g�ƃ}�X�^�m�[�h�Ԃ̒ʐM�͎����I��Base64�ɂăG���R�[�f�B���O������������g�p���Ă��܂��B


[�C���X�g�[�����@]
[�N�����@]
 ��Windows��

   �O�����:1.�\��
              1��̃}�V����ŉғ�����悤�ȃT���v���ݒ�t�@�C������������Ă��܂��B
              ���ꂼ��̃m�[�h�䐔
              �}�X�^�m�[�h:1��
              �f�[�^�m�[�h:2��(2�C���X�^���X�~3(�}�X�^�[�A�X���[�u�A�T�[�h))

            2.�e�m�[�h�̎g�p�|�[�g�͈ȉ��ƂȂ�܂��B
              �}�X�^�m�[�h:8888
              �p�r:�N���C�A���g����̗v���҂���
              �ύX����ꍇ:src�f�B���N�g���z����MasterNode.properties��7�s�ڂ�ύX
                           7�s��=MasterManagerJob.Init=8888<=���̔ԍ�

              �f�[�^�m�[�h:5553�A5554�@5556�A5557
              �p�r:�}�X�^�m�[�h����̗v���҂���
              �ύX����ꍇ:���C���f�[�^�m�[�h
                           src�f�B���N�g���z����DataNode.properties��7�s�ځA13�s�ڂ�ύX
                           7�s��=KeyManagerJob1.Init=5553<=���̔ԍ�
                           13�s��=KeyManagerJob2.Init=5554<=���̔ԍ�
                           �X���[�u�f�[�^�m�[�h
                           src�f�B���N�g���z����SlaveDataNode.properties��7�s�ځA13�s�ڂ�ύX
                           7�s��=KeyManagerJob1.Init=5556<=���̔ԍ�
                           13�s��=KeyManagerJob2.Init=5557<=���̔ԍ�

 1.�R���p�C��
   �ȈՓI�ȃR���p�C���p�o�b�`�t�@�C����p�ӂ��Ă��܂��B
   �{�t�@�C���Ɠ���f�B���N�g���ɂ���Acompile.bat�����s���Ă��������B
   �O��:javac.exe��PATH���ʂ��Ă���

 2.MasterNode�N��
   �ȈՓI��MasterNode�N���p�o�b�`�t�@�C����p�ӂ��Ă��܂��B
   �{�t�@�C���Ɠ���f�B���N�g���ɂ���AexecMasterNode.bat�����s���Ă��������B
   �ݒ�t�@�C����classes\MasterNode.properties���Q�Ƃ��Ă��܂��B
   ��~���@��Ctrl+C���v�����v�g�Ŏ��s
   ��ServerStop�t�@�C�������݂���ƃT�[�o�͋N�����܂���B
   ��execMasterNode2.bat�̓X���[�uMasterNode���N�����܂��B
   ��execMasterNodeMemcached.bat�̓X���[�uMasterNode��memcache�݊��v���g�R���ŋN�����܂��B
   �O��:1.java.exe��PATH���ʂ��Ă���
        2.�����������128MB�Ƃ��Ă��܂�

 3.DataNode�N��
   �ȈՓI��DataNode�N���p�o�b�`�t�@�C����p�ӂ��Ă��܂��B
   �{�t�@�C���Ɠ���f�B���N�g���ɂ���AexecDataNode.bat�����s���Ă��������B
   2�̃f�[�^�m�[�h�������ɋN�����܂��B
   �ݒ�t�@�C����classes\DataNode.properties���Q�Ƃ��Ă��܂��B
   ��~���@��Ctrl+C���v�����v�g�Ŏ��s
   ��ServerStop�t�@�C�������݂���ƃT�[�o�͋N�����܂���B
   �O��:1.java.exe��PATH���ʂ��Ă���
        2.�����������256MB�Ƃ��Ă��܂�

 3.SlaveDataNode�N��
   �ȈՓI�ȃX���[�u�pSlaveDataNode�N���p�o�b�`�t�@�C����p�ӂ��Ă��܂��B
   �{�t�@�C���Ɠ���f�B���N�g���ɂ���AexecSlaveDataNode.bat�����s���Ă��������B
   2�̃f�[�^�m�[�h�������ɋN�����܂��B
   �ݒ�t�@�C����classes\SlaveDataNode.properties���Q�Ƃ��Ă��܂��B
   ��~���@��Ctrl+C���v�����v�g�Ŏ��s
   ��ServerStop�t�@�C�������݂���ƃT�[�o��DataNode�͋N�����܂���B
   �O��:1.java.exe��PATH���ʂ��Ă���
        2.�����������256MB�Ƃ��Ă��܂�


 3.ThirdDataNode�N��
   �ȈՓI�ȃX���[�u�pThirdDataNode�N���p�o�b�`�t�@�C����p�ӂ��Ă��܂��B
   �{�t�@�C���Ɠ���f�B���N�g���ɂ���AexecThirdDataNode.bat�����s���Ă��������B
   2�̃f�[�^�m�[�h�������ɋN�����܂��B
   �ݒ�t�@�C����classes\SlaveDataNode.properties���Q�Ƃ��Ă��܂��B
   ��~���@��Ctrl+C���v�����v�g�Ŏ��s
   ��ServerStop�t�@�C�������݂���ƃT�[�o��DataNode�͋N�����܂���B
   �O��:1.java.exe��PATH���ʂ��Ă���
        2.�����������256MB�Ƃ��Ă��܂�


 4.TransactionNode�N��
   �ȈՓI�ȕ��ULock�pTransactionNode�N���p�o�b�`�t�@�C����p�ӂ��Ă��܂��B
   �{�t�@�C���Ɠ���f�B���N�g���ɂ���AexecTransactionNode.bat�����s���Ă��������B
   �ݒ�t�@�C����classes\TransactionNode.properties���Q�Ƃ��Ă��܂��B
   ��~���@��Ctrl+C���v�����v�g�Ŏ��s
   ��ServerStop�t�@�C�������݂���ƃT�[�o�͋N�����܂���B
   �O��:1.java.exe��PATH���ʂ��Ă���
        2.�����������256MB�Ƃ��Ă��܂�

 ��execMasterNode2.bat�����s����ƁA�X���[�uMasterNode���N�����܂��B
   �|�[�g�ԍ���8889���g�p���܂��B
   execMasterNodeMemcached.bat�̓|�[�g11211�Ńv���g�R����memcache�ɂȂ�܂��B
   �ݒ�t�@�C����classes\MasterNode2.properties���Q�Ƃ��Ă��܂��B

   �E�N���T���v���ł̍\���}
                ����������������      ����������������
                �� �}�X�^�[   ��      �� �X���[�u   ��
                �� �m�[�h     ��      �� �}�X�^�[   ��
                �� Port:8888  ��      �� �m�[�h     ��
                ��            ��      �� Port:8889  ��
                ����������������      ����������������
                        ������������������������
            ������������������������
            ��                    ��
      ������������������ ������������������
      ������������������ ������������������
      �����f�[�^    ���� �����f�[�^    ����
      �����m�[�h    ���� �����m�[�h    ����
      ����Port:5553 ���� ����Port:5554 ����
      ������������������ ������������������
      ������������������ ������������������
      �����X���[�u  ���� �����X���[�u  ����
      �����f�[�^    ���� �����f�[�^    ����
      �����m�[�h    ���� �����m�[�h    ����
      ����Port:5556 ���� ����Port:5557 ����
      ������������������ ������������������
      ������������������ ������������������

 4.�T���v���̎��s���@
   �ȈՓI�Ȑڑ��A�o�^�A�擾�A�폜�T���v����p�ӂ��Ă��܂��B
   �{�t�@�C���Ɠ���f�B���N�g���ɂ���ATestSock.class�����s���Ă�������(jdk1.6�ɂăR���p�C���ς�)�B
   �����Ȃ��Ŏ��s����Ǝg�p���@���o�͂���܂��B
   ��)
     # �ȉ��̗�͎����I�ɃC���N�������g����Key�l��Value�������1000��o�^���Ă���
     java -cp ./;./classes;./lib/javamail-1.4.1.jar TestSock 1 127.0.0.1 8888 1000

     # �ȉ��̗�̓L�[�l��key_a�Ńo�����[�lvalue_b��o�^
     java -cp ./;./classes;./lib/javamail-1.4.1.jar TestSock 1.1 127.0.0.1 key_a value_b

     # �ȉ��̗�͎����I�ɃC���N�������g����Key�l��Value�������1000��擾���Ă���
     java -cp ./;./classes;./lib/javamail-1.4.1.jar TestSock 2 127.0.0.1 8888 1000

     # �ȉ��̗�̓L�[�l��key_a��value���擾
     java -cp ./;./classes;./lib/javamail-1.4.1.jar TestSock 2.1 127.0.0.1 8888 key_a

     # �ȉ��̗�̓}�X�^�[�m�[�hIP127.0.0.1,�|�[�g8888��IP127.0.0.1,�|�[�g8889�ɐڑ����o�����V���O����
     # �����I�ɃC���N�������g����Key�l��Value�������1000��擾���Ă���
     # execMasterNode2.bat���N�����Ă���ƁA����execMasterNode.bat�̃v���Z�X���I�����Ă��������ғ���������
     java -cp ./;./classes;./lib/javamail-1.4.1.jar TestSock 2.2 "127.0.0.1:8888,127.0.0.1:8889" 100

     # �ȉ��̗�̓L�[�l��key_a�Ŏ擾����Value�l��JavaScript�����s�����ʂ��擾
     java -cp ./;./classes;./lib/javamail-1.4.1.jar TestSock 2.3 127.0.0.1 8888 key_a "var dataValue; var retValue = dataValue.replace('b', 'scritpChangeRet'); var execRet = '1';"

     # �ȉ��̗�͎����I�ɃC���N�������g����Key�l�ƓK����4�p�^�[����Tag�l��Value�������100��o�^���Ă���
     java -cp ./;./classes;./lib/javamail-1.4.1.jar TestSock 3 127.0.0.1 8888 100

     # �ȉ��̗��Tag�l�utag1�v�ɕR�t��Key�l��Value�l��1��擾���Ă���
     java -cp ./;./classes;./lib/javamail-1.4.1.jar TestSock 4 127.0.0.1 8888 1 tag1

     # �ȉ��̗��Key�l�uwordfile�v�ŁuC:\temp\SampleWord.doc�v�t�@�C����1��o�^���Ă���
     java -cp ./;./classes;./lib/javamail-1.4.1.jar TestSock 5 127.0.0.1 8888 1 C:\temp\SampleWord.doc wordfile

     # �ȉ��̗��Key�l�uwordfile�v�̃o�C�g�f�[�^���擾���uC:\SampleWord.doc�v�t�@�C���Ƃ���1��쐬���Ă���
     java -cp ./;./classes;./lib/javamail-1.4.1.jar TestSock 6 127.0.0.1 8888 1 C:\SampleWord.doc wordfile

     # �ȉ��̗��Key�l�ukey_a�v�̃f�[�^���폜���āAValue���擾���Ă���
     java -cp ./;./classes;./lib/javamail-1.4.1.jar TestSock 8 127.0.0.1 8888 key_a

     # �ȉ��̗��Transaction���J�n���ăf�[�^��Lock��A�f�[�^���X�V�A�擾���ALock������
     java -cp ./;./classes;./lib/javamail-1.4.1.jar TestSock 10 127.0.0.1 8888 key_a 5 10

     # �ȉ��̗��1�x�����f�[�^��o�^����ꍇ�Ɏg�p����Ăяo��
     # "key_abc"�Ƃ���Key��1�x�����o�^���Ȃ��悤�ɂ������ꍇ
     # 2�x���s�����2��ڂ̓G���[�ƂȂ�B(memcache��add�ɑ�������)
     java -cp ./;./classes;./lib/javamail-1.4.1.jar TestSock 11 127.0.0.1 8888 key_abc value_abc

     PHP�Ɋւ��ẮAetc_client\PhpAutoTest.bat���Q�Ƃ��Ă��������B

[����]
 ����̓o�OFix�ƕ��U�g�����U�N�V����(���b�N�@�\)���������Ă����܂��B

