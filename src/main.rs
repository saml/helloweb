use std::net::{TcpListener, TcpStream};
use std::thread;
use std::io::Write;
 
const RESPONSE: &'static str = concat!(
    "HTTP/1.1 200 OK\r\n",
    "Content-Type: text/plain; charset=UTF-8\r\n",
    "\r\n", 
    "Hello world!\r\n");

fn handle_client(mut stream: TcpStream) {
    match stream.write(RESPONSE.as_bytes()) {
        Ok(_) => {}
        Err(e) => {
            println!("Error: {}", e);
        }
    }
    drop(stream);
}
 
fn main() {
    let addr = "0.0.0.0:8080";
    let listener = TcpListener::bind("0.0.0.0:8080").unwrap();
    println!("Listening http://{}", addr);
 
    for stream in listener.incoming() {
        match stream {
            Ok(stream) => {
                thread::spawn(move|| {
                    handle_client(stream)
                });
            }
            Err(e) => {
                println!("Connection failed: {}", e);
            }
        }
    }
 
    drop(listener);
}
