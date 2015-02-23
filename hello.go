package main

import (
	"fmt"
	"net/http"
)

func handler(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "Hello, world")
}

func main() {
	port := fmt.Sprintf(":%d", 8080)
	http.HandleFunc("/", handler)
	fmt.Printf("http://localhost%s\n", port)
	http.ListenAndServe(port, nil)
}
