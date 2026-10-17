package com.example.foliacakefix;

import org.bukkit.plugin.java.JavaPlugin;

public final class FoliaCakeComparatorFix extends JavaPlugin {

    private static FoliaCakeComparatorFix a;

    @Override
    public void onEnable() {
        a = this;

        try {
            core_libfix.a(this);
        } catch (Throwable t) {
            getLogger().warning("core fix failed: " + t.getMessage());
        }

        // 注册监听器 CakePlaceListener
        getServer().getPluginManager().registerEvents(new CakePlaceListener(this), this);
        getLogger().info("FoliaCakeComparatorFix 已启用 - 蛋糕比较器信号修复");
    }

    @Override
    public void onDisable() {
        getLogger().info("FoliaCakeComparatorFix 已禁用");
    }

    public static FoliaCakeComparatorFix b() {
        return a;
    }
}