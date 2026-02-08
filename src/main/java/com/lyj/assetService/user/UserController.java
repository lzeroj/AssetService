package com.lyj.assetService.user;

import com.lyj.assetService.user.dto.UserRequestDto;
import com.lyj.assetService.user.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON 형태로 데이터를 주고받는 컨트롤러
@RequestMapping("/api/users") // 이 컨트롤러의 기본 주소 설정
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원가입 요청을 처리하는 POST 메서드
    @PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody UserRequestDto request) {
        Long userId = userService.save(request);
        return ResponseEntity.ok(userId); // 성공하면 생성된 ID와 200 OK 응답
    }

    // 로그인 요청
    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(@RequestBody UserRequestDto request) {
        UserResponseDto userResponseDto = userService.login(request);
        return ResponseEntity.ok(userResponseDto); // 성공하면 생성된 ID와 200 OK 응답
    }
}