#!/bin/sh
. $TESTDIR/common.sh 

tcpmt -P -d 2 -p $PORT &
TPID=$!

if ! waitsock
  then echo "tcpmt -P failed to start"
  exit 1
fi

echo "Connecting target to source. This should not take long..."
tcptarget -p $PORT -A localhost || { echo "tcptarget failed. Do some cleanup and exit" ; kill $TPID ; exit 1; }

#check if the source exited as it should after transfer is complete    
sleep 1
! kill $TPID  2>/dev/null; rt=$?
if [ $rt -eq 1 ]
  then echo "No connection was established with the source"
  exit 1 
else echo "tcpmt terminated normally"
fi
