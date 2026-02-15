package com.lyj.assetService.asset;

import com.lyj.assetService.global.entity.BaseTimeEntity;
import com.lyj.assetService.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "asset")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Asset extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long assetNo;

    @Column(nullable = false, length = 100)
    private String assetName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private AssetType assetType;

    @Column(nullable = false)
    private Long amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userNo", nullable = false)
    private User user;

    @Builder
    public Asset(String assetName, AssetType assetType, Long amount, User user) {
        this.assetName = assetName;
        this.assetType = assetType;
        this.amount = amount;
        this.user = user;
    }
}
