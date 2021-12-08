package br.com.southsystem.loja.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/example")
public class ExampleController {
    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Hello World!");
    }
}
