//////////////////////////////////////////////////////////////////////////////////////////////
okuyama Daemon 実行
//////////////////////////////////////////////////////////////////////////////////////////////


okuyama の Daemon 化
======================================================================================

`Apache Commons daemon`_ (jsvc) を利用して okuyama を Daemon として実行します。
**Linux での okuyama 実行を想定しています。**

Daemon として okuyama を実行するためには、
上記の Apache Commons daemon から必要なソースを入手し、ビルドを行ってください。

commons-daemon-1.0.10 で動作を確認しています。


.. _Apache Commons daemon: http://commons.apache.org/daemon/



Apache Commons daemon のビルド方法
======================================================================================

#. commons-daemon-1.0.XX-src.zip もしくは commons-daemon-1.0.XX-src.tar.gz をダウンロードします。

#. 展開したディレクトリの下記へ移動します。::

      $ cd commons-daemon-1.0.10-src/src/native/unix

#. ビルドを行います。::

      $ ./configure
      $ make

#. 作成された jsvc を PATH の通った場所へコピーします。



Daemon 化用起動スクリプトの利用方法
======================================================================================

マスターノード用のものとデータノード用のものを同梱しています。

設定
----------------------------------------------------------

環境に応じて下記項目を修正してください。

:OKUYAMA_USER: okuyama 実行ユーザを指定します。(ex. okuyama)
:OKUYAMA_HOME: okuyam を展開したディレクトリを指定します。(ex. /home/okuyama/okuyama)
:JAVA_HOME: Java のディレクトリを指定します。(ex. /usr/java/default)
:OKUYAMA_INSTANCE_NAME: 複数ノードを立ち上げた際に PID ファイルの識別などで用います。一意な名前を指定してください。(ex. m1)
:OKUYAMA_CONF: okuyama のマスター/データノードいづれかの設定ファイルを指定します。(ex. $OKUYAMA_HOME/conf/MasterNode.properties)
:OKUYAMA_STDOUT: okuyama の標準出力先を指定します。(ex. $OKUYAMA_HOME/logs/masternode-$OKUYAMA_INSTANCE_NAME.out)
:OKUYAMA_STDERR: okuyama のエラー出力先を指定します。(ex. $OKUYAMA_HOME/logs/masternode-$OKUYAMA_INSTANCE_NAME.err)
:OKUYAMA_OPTS: okuyama の起動オプションがあれば""の中に記述します。(ex. "-s 2048 -svic 60")


複数ノード起動時の利用方法
----------------------------------------------------------

複数のノードを各々 Daemon 化して起動する場合は、
起動スクリプトをコピーし、::

   OKUYAMA_INSTANCE_NAME

の項目を一意となるように設定して、
1つの起動スクリプトから1つのノードを起動してください。


1つのマスターノードと2つのデータノードを起動する例
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

#. okuyama をマスター1、データ2で起動する基本的な設定を済ませます。
#. okuyama-data をコピーし okuyama-data1 と okuyama-data2 とします。
#. okuyama-data1を下記の通り修正します。::

      OKUYAMA_INSTANCE_NAME=d1

#. okuyama-data2を下記の通り修正します。::

      OKUYAMA_INSTANCE_NAME=d2

#. okuyama を起動します。::

      # ./okuyama-data1 start
      # ./okuyama-data2 start
      # ./okuyama-master start

#. okuyama の状態を確認します。::

      # ./okuyama-data1 status
      # ./okuyama-data2 status
      # ./okuyama-master status
