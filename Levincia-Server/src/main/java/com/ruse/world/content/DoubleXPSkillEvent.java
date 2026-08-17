package com.ruse.world.content;

import java.util.Random;

import com.ruse.engine.task.Task;
import com.ruse.engine.task.TaskManager;
import com.ruse.model.Skill;
import com.ruse.util.StringUtils;
import com.ruse.world.World;

public class DoubleXPSkillEvent {

	public static Skill currentSkill = pickRandomSkill();

	public static void pickNext() {
		TaskManager.submit(new Task(36000) { // 6h
			@Override
			protected void execute() {
				currentSkill = pickRandomSkill();
				World.sendMessage(
						"@blu@<img=5>[DOUBLE XP]<img=5>@red@ " + StringUtils.capitalizeFirst(currentSkill.toString())
								+ " Has been picked as double xp skill for the next 6 hours.");
			}
		});
	}

	private static Skill pickRandomSkill() {

		return Skill.values()[new Random().nextInt(Skill.values().length)];
	}

}
