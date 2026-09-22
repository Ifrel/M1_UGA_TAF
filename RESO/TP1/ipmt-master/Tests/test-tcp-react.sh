#!/bin/sh
. $TESTDIR/common.sh 

OUTFILE=`mktemp -u /tmp/tcpmt.XXXX` || exit 1
INFILE=`mktemp -u /tmp/test-file.XXXX` || exit 1

echo "[0 1 222]{30 5 [20 2 444]}" > $INFILE

tcpmt -p $PORT -R    &
TPID=$!

if ! waitsock
  then echo "tcpmt -R failed to start"
  cleanup
  exit 1
fi

tcpmt -f $INFILE -p $PORT -q localhost > $OUTFILE || { echo "tcpmt failed. Do some cleanup and exit" ; kill $TPID ; exit 1; }
#check if the target exited as it should after transfer is complete    
sleep 1

kill $TPID 


test `grep "blocks" $OUTFILE | awk '{printf("%d%d", $1, $4)}'` = "122224442444244424442444"
rt=$?
cleanup

if (( $rt != 0 )) ; 
  then exit 1;
fi
