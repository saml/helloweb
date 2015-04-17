# Hello world web server

Write simple web server that responds with `Hello, world`.

```sh
> GET / HTTP/1.1
> Host: localhost:8080

< HTTP/1.1 200 OK
< Content-Length: 12
< Hello, world
```

# Example run

```
$ WRK=~/code/wrk/wrk JAVA=~/opt/jdk1.7.0_04/bin/java  ./test.bash
...
==== Rust (29385)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    42.40us   62.49us  12.70ms   99.42%
    Req/Sec    84.51k    20.38k  136.67k    56.62%
  1563238 requests in 10.00s, 156.54MB read
  Socket errors: connect 0, read 0, write 0, timeout 408
Requests/sec: 156269.72
Transfer/sec:     15.65MB
==== end ====
./test.bash: line 15: 29385 Terminated              "$@"
/home/sam/opt/jdk1.7.0_04/bin/java -jar target/scala-2.11/hello-assembly-0.0.0.jar
Apr 17, 2015 5:54:25 PM org.xnio.Xnio <clinit>
INFO: XNIO version 3.3.0.Final
Apr 17, 2015 5:54:25 PM org.xnio.nio.NioXnio <clinit>
INFO: XNIO NIO Implementation Version 3.3.0.Final
==== Java (29527)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency   340.58us    1.30ms  24.58ms   97.45%
    Req/Sec    36.32k    11.51k  131.89k    79.00%
  3233740 requests in 10.00s, 342.32MB read
Requests/sec: 323447.91
Transfer/sec:     34.24MB
==== end ====
node hello.js
Server running at http://localhost:8080/
Server running at http://localhost:8080/
Server running at http://localhost:8080/
Server running at http://localhost:8080/
Server running at http://localhost:8080/
Server running at http://localhost:8080/
==== Node.js (29623)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.56ms  815.68us  25.08ms   97.61%
    Req/Sec     6.93k   768.11     9.33k    81.76%
  644839 requests in 9.99s, 79.33MB read
Requests/sec:  64524.24
Transfer/sec:      7.94MB
==== end ====
./test.bash: line 15: 29623 Terminated              "$@"
./hello
Check http://localhost:8080
==== Nim (29746)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     2.29ms    1.51ms   7.12ms   83.31%
    Req/Sec     4.55k   504.39     6.36k    74.90%
  434679 requests in 10.00s, 20.73MB read
Requests/sec:  43473.29
Transfer/sec:      2.07MB
==== end ====
./test.bash: line 15: 29746 Terminated              "$@"
./hello_go
http://localhost:8080
==== Go (29829)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.09ms    3.95ms  76.43ms   96.42%
    Req/Sec    15.30k     7.26k   64.00k    69.10%
  1440956 requests in 10.00s, 177.27MB read
Requests/sec: 144140.17
Transfer/sec:     17.73MB
==== end ====
./hello_vala
Listening http://localhost:8080
==== Vala (29920)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.54s     2.60s    7.80s    85.91%
    Req/Sec     1.71k     1.81k    9.22k    87.61%
  157988 requests in 10.00s, 11.45MB read
  Socket errors: connect 0, read 126833, write 31140, timeout 264
Requests/sec:  15797.43
Transfer/sec:      1.14MB
==== end ====

```
