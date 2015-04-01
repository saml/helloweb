extern crate mio;

use std::net::{TcpListener, TcpStream, Shutdown};
use std::io::Write;
 
const RESPONSE: &'static str = concat!(
    "HTTP/1.1 200 OK\r\n",
    "Content-Type: text/plain; charset=UTF-8\r\n",
    "Content-Length: 11\r\n",
    "\r\n", 
    "Hello world");

const SERVER: mio::Token = mio::Token(0);

fn handle_client(mut stream: mio::NonBlock<TcpStream>) {
    match stream.write(RESPONSE.as_bytes()) {
        Ok(_) => {}
        Err(e) => {
            println!("Error: {}", e);
        }
    }
    stream.shutdown(Shutdown::Both);
    drop(stream);
}


struct HelloWorldHandler(mio::NonBlock<TcpListener>);

impl mio::Handler for HelloWorldHandler {
    type Timeout = ();
    type Message = ();
    fn readable(&mut self, event_loop: &mut mio::EventLoop<HelloWorldHandler>, token: mio::Token, _: mio::ReadHint) {
        match token {
            SERVER => {
                let HelloWorldHandler(ref mut server) = *self;
                match server.accept().unwrap() {
                    Some(stream) => {
                        handle_client(stream);
                    }
                    None => {}
                }
            }
            mio::Token(_) => {}
        }
    }
}
 
fn main() {
    let addr = "0.0.0.0:8080".parse().unwrap();
    let listener = mio::tcp::listen(&addr).unwrap();
    println!("Listening http://{}", addr);

    let mut event_loop = mio::EventLoop::new().unwrap();
    event_loop.register(&listener, SERVER).unwrap();
    event_loop.run(&mut HelloWorldHandler(listener)).unwrap();

}
