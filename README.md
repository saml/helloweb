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
==== Rust (15593)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    34.88us   51.54us   7.63ms   99.62%
    Req/Sec   201.57k    14.61k  210.55k    88.94%
  1827734 requests in 10.00s, 183.02MB read
  Socket errors: connect 0, read 0, write 0, timeout 428
Requests/sec: 182716.78
Transfer/sec:     18.30MB
==== end ====
./test.bash: line 14: 15593 Terminated              "$@"
/home/sam/opt/jdk1.7.0_04/bin/java -jar target/scala-2.11/hello-assembly-0.0.0.jar
Apr 01, 2015 11:43:58 AM org.xnio.Xnio <clinit>
INFO: XNIO version 3.3.0.Final
Apr 01, 2015 11:43:58 AM org.xnio.nio.NioXnio <clinit>
INFO: XNIO NIO Implementation Version 3.3.0.Final
==== Java (15935)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency   322.05us    1.02ms  32.90ms   97.08%
    Req/Sec    36.24k    11.63k  165.89k    77.22%
  3177030 requests in 10.00s, 336.31MB read
Requests/sec: 317780.32
Transfer/sec:     33.64MB
==== end ====
node hello.js
Server running at http://localhost:8080/
Server running at http://localhost:8080/
Server running at http://localhost:8080/
Server running at http://localhost:8080/
Server running at http://localhost:8080/
Server running at http://localhost:8080/
==== Node.js (16055)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.55ms  805.96us  20.99ms   96.20%
    Req/Sec     6.93k     0.95k   10.67k    72.84%
  647899 requests in 9.99s, 79.71MB read
Requests/sec:  64853.81
Transfer/sec:      7.98MB
==== end ====
./test.bash: line 14: 16055 Terminated              "$@"
./hello
Check http://localhost:8080
==== Nim (16212)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     2.37ms    1.51ms   6.51ms   83.49%
    Req/Sec     4.40k   534.50     6.36k    64.49%
  421056 requests in 10.00s, 20.08MB read
Requests/sec:  42111.23
Transfer/sec:      2.01MB
==== end ====
./test.bash: line 14: 16212 Terminated              "$@"
./hello_go
http://localhost:8080
==== Go (16239)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.31ms    5.53ms  92.23ms   96.33%
    Req/Sec    15.54k     7.60k   78.56k    67.55%
  1462242 requests in 10.00s, 179.89MB read
Requests/sec: 146284.92
Transfer/sec:     18.00MB
==== end ====

```
