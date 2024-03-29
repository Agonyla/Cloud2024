package com.agony.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * @author Agony
 * @create 2024/3/20 14:42
 */
@Getter
public enum UserType {

    Diamond(20, "diamond"),
    Gold(10, "gold"),
    Silver(5, "silver");

    private final int score;
    private final String level;

    UserType(int score, String level) {
        this.score = score;
        this.level = level;
    }

    public static UserType getUserType(String level) {
        return Arrays.stream(UserType.values()).filter(userType -> userType.getLevel().equals(level)).findFirst().orElse(null);
    }
}
