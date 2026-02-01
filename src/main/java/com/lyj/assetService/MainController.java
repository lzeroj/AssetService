package com.lyj.assetService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MainController {

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String,String> user) {
        String id = user.get("username");
        String pw = user.get("password");

        System.out.println("test : " + id + " " + pw);

        if ("admin".equals(id) && "1234".equals(pw)) {
            // 로그인 성공
            return ResponseEntity.ok(Map.of("token", "dummy-jwt-token"));
        } else {
            // 로그인 실패
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "로그인 실패"));
        }
    }
}
