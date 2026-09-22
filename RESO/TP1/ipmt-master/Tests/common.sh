set -e 

PORT=13001

testsock () { # look for our socket, excludes TIME_WAIT
  netstat -na | grep -v "TIME_WAIT" | grep -q ".$PORT" 
}

waitsock () {
  nb=0
  while ! testsock && [[ $nb -le 4 ]]
    do printf \.
    nb=$(expr $nb + 1)
    sleep 1
  done
  if ! testsock 
    then exit 1
  fi
}

cleanup(){
  rm $OUTFILE $INFILE
}


# Checks if a socket is in the way before we proceed to the tests
if testsock 
  then echo "a socket is in the way !"
  echo "maybe you need to kill a running target ?"
  exit 1
fi

