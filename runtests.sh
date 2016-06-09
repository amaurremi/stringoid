#!/bin/bash

apkdir=dynamic-data/apps
jar=target/scala-2.10/stringoid-assembly-0.1.jar
mainclass=com.ibm.stringoid.Main

#sbt assembly

for apk in $(ls -S -r $apkdir/*.apk); do
  java -Xmx9000M -cp $jar $mainclass -a append --lib false --ir-source interproc -u false $apk
done
