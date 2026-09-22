#!/bin/sh

. $TESTDIR/common.sh 

OUTFILE=`mktemp -u /tmp/tcpmt.XXXX` || exit 1
INFILE=`mktemp -u /tmp/test-file.XXXX` || exit 1

echo "[0 1 222]{30 5 [20 2 444]}" > $INFILE

tcptarget -p $PORT -P > $OUTFILE   &
TPID=$!

if ! waitsock
  then echo "tcptarget failed to start"
  cleanup ; exit 1
fi

tcpmt -f $INFILE -p $PORT localhost || { echo "tcpmt failed. Do some cleanup and exit" ; kill $TPID ; exit 1; }
#check if the target exited as it should after transfer is complete    
sleep 1

kill $TPID 
test `cat  $OUTFILE | grep "received" | awk '{printf("%d", $1)}'` -eq "222888888888888888"
rt=$?
cleanup

if (( $rt != 0 )) ; 
    then exit 1;
fi
