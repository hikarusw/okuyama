#!/bin/sh
java -classpath ./classes:./lib/log4j-1.2.14.jar:./lib/javamail-1.4.1.jar -Xmx256m -Xms128m okuyama.base.JavaMain /Main.properties /TransactionNode.properties
