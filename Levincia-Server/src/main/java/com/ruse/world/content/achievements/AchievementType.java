package com.ruse.world.content.achievements;

import org.apache.commons.lang3.text.WordUtils;

/*
 * Project Levincia
 * Author @Levincia (AlwaysDreaming.ai@gmail.com)
 * Created on - 6/14/2022
 */

public enum AchievementType {
    EASY,
    MEDIUM,
    HARD,
    EXPERT,
    ;

    @Override
    public String toString() {
        return WordUtils.capitalize(this.name().toLowerCase().replaceAll("_", " "));
    }
}
