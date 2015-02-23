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

==== Servlet (9737)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     4.69ms   18.26ms 198.87ms   95.91%
    Req/Sec     7.72k     4.17k   46.22k    67.57%
  697550 requests in 10.00s, 79.16MB read
Requests/sec:  69777.78
Transfer/sec:      7.92MB
node hello.js
Server running at http://localhost:8080/
Server running at http://localhost:8080/
Server running at http://localhost:8080/
Server running at http://localhost:8080/
Server running at http://localhost:8080/
Server running at http://localhost:8080/
==== Node.js (9879)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.36ms  763.54us  27.11ms   97.55%
    Req/Sec     7.84k     1.55k   15.56k    83.16%
  737573 requests in 10.00s, 90.74MB read
Requests/sec:  73776.52
Transfer/sec:      9.08MB
./hello
Check http://localhost:8080
==== Nim (9909)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     2.70ms  800.15us   4.84ms   45.50%
    Req/Sec     3.91k   280.81     4.60k    67.03%
  368439 requests in 10.00s, 17.57MB read
Requests/sec:  36850.89
Transfer/sec:      1.76MB
./test.bash: line 13:  9909 Terminated              "$@"
./hello_go
http://localhost:8080
==== Go (9924)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.40ms    5.73ms  74.24ms   95.70%
    Req/Sec    15.67k     7.68k   85.00k    66.75%
  1477890 requests in 9.99s, 181.82MB read
Requests/sec: 147866.78
Transfer/sec:     18.19MB


```
