#!/bin/sh

. $TESTDIR/common.sh 

OUTFILE=`mktemp -u /tmp/udptarget.XXXX` || exit 1
INFILE=`mktemp -u /tmp/test-file.XXXX` || exit 1

echo "[0 1 222]{30 5 [20 2 444]}" > $INFILE

udptarget -p $PORT >$OUTFILE  2>&1  &
TPID=$!

if ! waitsock
  then echo "udptarget failed to start"
  cleanup ; exit 1
fi

trap '{ echo "udpmt failed. Do some cleanup and exit" ; kill $TPID exit 1; }' SIGSEGV 
udpmt -f $INFILE -p $PORT localhost || { echo "udpmt failed. Do some cleanup and exit" ; kill $TPID ; exit 1; }

sleep 1

#udptarget normally exited by itself
! kill $TPID 2>/dev/null; rt=$?
if [ $rt -eq 1 ]
  then echo "udptarget should have terminated"
  exit 1 
fi

test `cat  $OUTFILE | grep "received" | awk '{printf("%d", $1)}'` -eq "11"
rt=$?
cleanup

if (( $rt != 0 )) ; 
    then echo "udptarget should have received 11 packets. What went wrong?"
    exit 1;
fi
