var http = require('http');
var cluster = require('cluster');
var cpus = require('os').cpus().length;
if (cluster.isMaster) {
  for (var i = 0; i < cpus; i++) {
    cluster.fork();
  }
  cluster.on('exit', function(worker, code, signal) {
  });
} else {
  http.createServer(function (req, res) {
    res.writeHead(200);
    res.end('Hello World');
  }).listen(8080, '127.0.0.1');
  console.log('Server running at http://localhost:8080/');
}
