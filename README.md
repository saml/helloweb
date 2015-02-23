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

==== Java (29069)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency   303.78us    1.03ms  24.22ms   97.52%
    Req/Sec    38.31k    12.32k  205.67k    80.76%
  3354281 requests in 10.00s, 358.28MB read
Requests/sec: 335498.02
Transfer/sec:     35.84MB
node hello.js
Server running at http://localhost:8080/
Server running at http://localhost:8080/
Server running at http://localhost:8080/
Server running at http://localhost:8080/
Server running at http://localhost:8080/
Server running at http://localhost:8080/
==== Node.js (29113)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.34ms  675.53us  14.29ms   78.32%
    Req/Sec     8.49k     3.09k   23.89k    60.85%
  798207 requests in 10.00s, 98.20MB read
Requests/sec:  79856.80
Transfer/sec:      9.82MB
./hello
Check http://localhost:8080
==== Nim (29142)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     2.73ms  806.02us   3.72ms   45.16%
    Req/Sec     3.88k   301.04     4.50k    65.50%
  364799 requests in 10.00s, 17.39MB read
Requests/sec:  36482.06
Transfer/sec:      1.74MB
./test.bash: line 13: 29142 Terminated              "$@"
./hello_go
http://localhost:8080
==== Go (29163)
Running 10s test @ http://localhost:8080/
  10 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.38ms    6.24ms  80.28ms   96.57%
    Req/Sec    15.59k     7.34k   90.89k    68.24%
  1472227 requests in 10.00s, 181.12MB read
Requests/sec: 147271.05
Transfer/sec:     18.12MB


```
