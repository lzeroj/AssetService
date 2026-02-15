package com.lyj.assetService.asset;

public enum AssetType {
    TANGIBLE("유형자산"),
    INTANGIBLE("무형자산");

    private final String displayName;

    AssetType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
