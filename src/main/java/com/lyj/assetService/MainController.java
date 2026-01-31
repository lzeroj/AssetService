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
    public ResponseEntity<String> login(@RequestBody Map<String,String> user) {
        String id = user.get("id");
        String pw = user.get("pw");

        if("test".equals(id) && "123".equals(pw)) {
            return ResponseEntity.ok("OK"); // 로그인 성공
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Fail");
    }
}
