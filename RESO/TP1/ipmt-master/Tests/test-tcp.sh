#!/bin/sh

. $TESTDIR/common.sh 

tcptarget -p $PORT -b 8192 &
TPID=$!

if ! waitsock
  then echo "tcptarget failed to start"
  exit 1
fi

tcpmt -d 2 -p $PORT  -b 8192 -y localhost || { echo "tcpmt failed. Do some cleanup and exit" ; kill $TPID ; exit 1; }
#check if the target exited as it should after transfer is complete    
sleep 1
! kill $TPID 2>/dev/null; rt=$?
if [ $rt -eq 1 ]
  then echo No connection was established with the target
  exit 1 
else echo tcptarget terminated normally
fi


