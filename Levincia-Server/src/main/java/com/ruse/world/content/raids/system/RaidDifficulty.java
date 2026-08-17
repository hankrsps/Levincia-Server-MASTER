package com.ruse.world.content.raids.system;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum
RaidDifficulty {

    EASY("Easy",
            new RaidRequirement(10_000)
    ),
    INTERMEDIATE("Medium",
            new RaidRequirement(20_000, 100)
    ),
    ADVANCED("Hard",
            new RaidRequirement(30_000, 250)
    ),
    EASY1("Easy",
                 new RaidRequirement(500)
    ),
    INTERMEDIATE1("Medium",
                         new RaidRequirement(2500, 100)
    ),
    ADVANCED1("Hard",
                     new RaidRequirement(5000, 250)
    );

    @Getter
    private String name;

    @Getter
    private RaidRequirement godsRequirement;





}