#!/bin/bash

wrk="${WRK:-wrk}"
node="${NODE:-node}"
nim="${NIM:-nim}"
sbt="${SBT:-sbt}"
java="${JAVA:-java}"
go="${GO:-go}"
cargo="${CARGO:-cargo}"

duration="${1:-10}"
should_build="${2:-yes}"

run() {
  local msg="$1"
  shift 1
  echo "$@"
  "$@" &
  pid="$!"
  sleep 3 #give time for backgrounded server to initialize
  echo "==== $msg ($pid)"
  "$wrk" -c 100 -d $duration -t 10 "http://localhost:8080/"
  kill "$pid"
  echo "==== end ===="
  sleep 3
}

echo "Using $wrk"
echo "      $node"
echo "      $nim"
echo "      $sbt"

if [[ "$should_build" = "yes" ]]
then
  # build
  "$nim" -d:release c hello
  "$sbt" assembly
  "$go" build -o hello_go hello.go
  "$cargo" build --release
fi

run "Rust" "./target/release/hello"
run "Java" "$java" -jar "target/scala-2.11/hello-assembly-0.0.0.jar"
run "Node.js" "$node"  hello.js
run "Nim" ./hello
run "Go" ./hello_go


