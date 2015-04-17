
const string RESPONSE = 
	"HTTP/1.1 200 Ok\r\n" +
	"Content-Type: text/plain\r\n" +
	"Content-Length: 11\r\n" +
	"\r\n" +
	"Hello world";
	
bool on_incoming_connection(SocketConnection conn) {
    process_request.begin(conn);
    return true;
}


async void process_request(SocketConnection conn) {
    try {
        var dos = new DataOutputStream (conn.output_stream);
        dos.put_string(RESPONSE);        
    } catch (Error e) {
        stderr.printf ("%s\n", e.message);
    }
}

void main () {
	const uint16 port = 8080;
    try {
        var service = new SocketService();
        service.add_inet_port(port, null);
        service.incoming.connect(on_incoming_connection);
        service.start();
        stdout.printf("Listening http://localhost:%d\n", port);
        new MainLoop().run();
    } catch (Error e) {
        stderr.printf("%s\n", e.message);
    }
}
