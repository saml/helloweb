#!/bin/bash

wrk="${WRK:-wrk}"
node="${NODE:-node}"
nim="${NIM:-nim}"
sbt="${SBT:-sbt}"

run() {
  local msg="$1"
  shift 1
  echo "$@"
  "$@" &
  pid="$!"
  sleep 3 #give time for backgrounded server to initialize
  echo "==== $msg ($pid)"
  "$wrk" -c 100 -d 10 -t 10 "http://localhost:8080/"
  kill "$pid"
  sleep 3
}

echo "Using $wrk"
echo "      $node"
echo "      $nim"
echo "      $sbt"

# build
#"$nim" -d:release c hello

#run "Servlet" "$sbt" "container:start"
#run "Node.js" "$node"  hello.js
#run "Nim" ./hello


