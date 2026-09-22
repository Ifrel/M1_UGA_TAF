#!/bin/sh
. $TESTDIR/common.sh 

#Start sender in passive mode (waits for a connection)
tcpmt -P -t -p $PORT &
PID1=$!

if ! waitsock
  then echo "tcpmt -P -t failed to start"
  exit 1
fi

#Start sender in active mode
tcpmt -p $PORT -t localhost  &
PID2=$!

sleep 2

! kill $PID1  2>/dev/null; rt=$?
! kill $PID2  2>/dev/null; rt=$(($?+$rt))

if [ $rt -ge 1 ]
  then echo "Succesfully killed active sources"
else
  echo "Bidirecional traffic not working it seems..."
  exit 1
fi
