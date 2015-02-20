var http = require('http');
http.createServer(function (req, res) {
  res.writeHead(200);
  res.end('Hello World');
}).listen(8080, '127.0.0.1');
console.log('Server running at http://localhost:8080/');
