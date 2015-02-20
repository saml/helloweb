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

==== Servlet (5949)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     5.88ms   24.63ms 216.73ms   96.25%
    Req/Sec     7.23k     4.27k   51.11k    63.11%
  657782 requests in 10.00s, 74.65MB read
Requests/sec:  65795.64
Transfer/sec:      7.47MB
node hello.js
Server running at http://localhost:8080/
==== Node.js (6091)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     6.99ms  237.68us  11.74ms   96.24%
    Req/Sec     1.48k   264.57     2.00k    58.06%
  142353 requests in 10.00s, 17.51MB read
Requests/sec:  14233.86
Transfer/sec:      1.75MB
./hello
Check http://localhost:8080
==== Nim (6110)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     2.73ms  804.13us   4.75ms   45.37%
    Req/Sec     3.88k   295.56     4.50k    65.13%
  364822 requests in 10.00s, 17.40MB read
Requests/sec:  36487.68
Transfer/sec:      1.74MB
```
