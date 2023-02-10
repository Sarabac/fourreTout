const http = require('http');

const hostname = '127.0.0.1';
const port = {{SERVER_PORT}};

const server = http.createServer((req, res) => {
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');
  res.end('Hello World');
});

const timeout = Math.floor(Math.random() * 60_000);

server.listen(port, hostname, () => {
  console.log(`${new Date().toUTCString()} : Server running at http://${hostname}:${port}/ during ${timeout} ms`);
});


setTimeout(() => {
  console.log(`${new Date().toUTCString()} : Server closing...`);
  server.close();
  console.log(`${new Date().toUTCString()} : Server closed`);
}, timeout);

