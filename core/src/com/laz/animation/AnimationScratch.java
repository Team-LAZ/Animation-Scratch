package com.laz.animation;

import com.badlogic.gdx.Game;

public class AnimationScratch extends Game {
	
	@Override
	public void create () {
        this.setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
        super.render();
	}
}
