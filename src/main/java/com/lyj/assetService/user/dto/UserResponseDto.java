package com.lyj.assetService.user.dto;

import com.lyj.assetService.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String email;
    private String name;

    // 엔티티를 받아서 DTO로 변환 (박스 포장)
    public UserResponseDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
    }
}
