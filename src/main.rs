extern crate hyper;

use std::io::Write;

use hyper::Server;
use hyper::server::Request;
use hyper::server::Response;
use hyper::net::Fresh;

fn hello(_: Request, mut res: Response<Fresh>) {
    let mut res = res.start().unwrap();
    res.write_all(b"Hello World").unwrap();
    res.end().unwrap();
}

fn main() {
    let addr = "0.0.0.0:8080";
    println!("Listening http://{}", addr);
    Server::http(hello).listen(addr).unwrap();
}
