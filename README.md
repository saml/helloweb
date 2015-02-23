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

==== Servlet (7916)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     7.03ms   27.18ms 224.31ms   95.43%
    Req/Sec     7.22k     4.34k   29.74k    64.12%
  650611 requests in 10.00s, 73.84MB read
Requests/sec:  65077.23
Transfer/sec:      7.39MB
node hello.js
Server running at http://localhost:8080/
Server running at http://localhost:8080/
Server running at http://localhost:8080/
Server running at http://localhost:8080/
Server running at http://localhost:8080/
Server running at http://localhost:8080/
==== Node.js (8064)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.37ms  566.44us  23.94ms   97.10%
    Req/Sec     7.86k     1.45k   12.56k    63.28%
  742844 requests in 10.00s, 91.39MB read
Requests/sec:  74296.65
Transfer/sec:      9.14MB
./hello
Check http://localhost:8080
==== Nim (8097)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     2.75ms  808.57us   3.76ms   45.65%
    Req/Sec     3.86k   293.49     4.44k    65.37%
  363431 requests in 10.00s, 17.33MB read
Requests/sec:  36349.64
Transfer/sec:      1.73MB
./test.bash: line 13:  8097 Terminated              "$@"
./hello_go
http://localhost:8080
==== Go (8113)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     2.56ms    1.42ms   8.00ms   60.42%
    Req/Sec     4.13k   429.14     5.89k    67.31%
  391872 requests in 10.00s, 48.21MB read
Requests/sec:  39195.32
Transfer/sec:      4.82MB


```
