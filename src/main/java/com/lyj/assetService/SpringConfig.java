package com.lyj.assetService;

import com.lyj.assetService.repository.MemberRepository;
import com.lyj.assetService.repository.MemoryMemberRepository;
import com.lyj.assetService.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
