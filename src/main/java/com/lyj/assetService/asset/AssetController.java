package com.lyj.assetService.asset;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON 형태로 데이터를 주고받는 컨트롤러
@RequestMapping("/api/asset") // 이 컨트롤러의 기본 주소 설정
@RequiredArgsConstructor
public class AssetController {
}
