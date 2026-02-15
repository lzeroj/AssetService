package com.lyj.assetService.asset;

import com.lyj.assetService.user.User;
import com.lyj.assetService.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class AssetRepositoryTest {

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void 자산등록(){
        User user = userRepository.findByEmail("test@naver.com").get();

        Asset asset = Asset.builder().assetName("테스트")
                .assetType(AssetType.INTANGIBLE)
                .amount(10000L)
                .user(user)
                .build();

        assetRepository.save(asset);

    }

    @Test
    void 자산수정(){

    }

    @Test
    void 자산삭제(){

    }
}
