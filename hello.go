package main

import (
	"fmt"
	"net/http"
	"runtime"
)

func handler(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte("Hello, world"))
}

func main() {
	runtime.GOMAXPROCS(runtime.NumCPU())
	port := fmt.Sprintf(":%d", 8080)
	http.HandleFunc("/", handler)
	fmt.Printf("http://localhost%s\n", port)
	http.ListenAndServe(port, nil)
}
