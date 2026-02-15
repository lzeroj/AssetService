package com.lyj.assetService.user;

import com.lyj.assetService.user.dto.UserRequestDto;
import com.lyj.assetService.user.dto.UserResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    void 회원가입(){

        User user = User.builder().email("test@naver.com")
                .password("abcd")
                .name("테스트")
                .build();

        userRepository.save(user);

        // when
        Optional<User> result = userRepository.findByEmail("test@naver.com");

        // then
        assertThat(result).isPresent();
        assertThat(result.get().getEmail()).isEqualTo("test@naver.com");

    }

    @Test
    void 로그인_성공() {
        UserRequestDto loginRequest = UserRequestDto.builder()
                .email("test@naver.com")
                .password("abcd")
                .build();

        UserResponseDto response = userService.login(loginRequest);

        assertThat(response).isNotNull();
        assertThat(response.getEmail()).isEqualTo("test@naver.com");
        assertThat(response.getName()).isEqualTo("테스트");
    }

    @Test
    void 로그인_실패_없는_이메일() {
        UserRequestDto loginRequest = UserRequestDto.builder()
                .email("noemail@naver.com")
                .password("abcd")
                .build();

        assertThatThrownBy(() -> userService.login(loginRequest))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("없는 이메일");
    }

    @Test
    void 로그인_실패_비밀번호_틀림() {
        UserRequestDto loginRequest = UserRequestDto.builder()
                .email("test@naver.com")
                .password("wrongpassword")
                .build();

        assertThatThrownBy(() -> userService.login(loginRequest))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("비밀번호");
    }

    @Test
    void 자산등록() {

    }

    @Test
    void 자산목록조회(){

    }
}
