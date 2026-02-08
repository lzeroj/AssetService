package com.lyj.assetService.user;

import com.lyj.assetService.global.exception.ErrorCode;
import com.lyj.assetService.global.exception.ServiceCommonException;
import com.lyj.assetService.user.dto.UserRequestDto;
import com.lyj.assetService.user.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor // 1. final이 붙은 필드에 대해 생성자를 만들어줌
@Transactional(readOnly = true)
public class UserService {

    // 2. 반드시 final이 붙어있어야 합니다!
    private final UserRepository userRepository;

    @Transactional
    public Long save(UserRequestDto request) {
        // 중복 검증
        userRepository.findByEmail(request.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 가입된 이메일입니다.");
                });

        // 저장
        User user = request.toEntity();
        User savedUser = userRepository.save(user);

        return savedUser.getId();
    }

    @Transactional
    public UserResponseDto login(UserRequestDto request) {
        // 중복 검증
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ServiceCommonException(ErrorCode.USER_NOT_FOUND));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new ServiceCommonException(ErrorCode.INVALID_PASSWORD);
        }

        return new UserResponseDto(user);
    }
}