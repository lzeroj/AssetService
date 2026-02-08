package com.lyj.assetService.user.dto;

import com.lyj.assetService.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDto {
    private String email;
    private String password;
    private String name;

    // DTO를 엔티티로 변환하는 편의 메서드
    public User toEntity() {
        return User.builder()
                .email(this.email)
                .password(this.password)
                .name(this.name)
                .build();
    }
}
