package com.laz.animation;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen extends Stage implements Screen {

    Game game;
    DPad dpad;
    Character character;

    OrthographicCamera camera;

    public GameScreen(Game game) {
        this.game = game;
        dpad = new DPad();
        character = new Character();

        camera = new OrthographicCamera();

        this.addActor(dpad.imgOutline);
        for (int i = 0; i < 4; i++) {
            this.addActor(dpad.ibtnDpad[i]);
        }
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        character.render(this);

        //checks if left or right is pressed
        //use isPressed as it constantly checks instead of only once (for moving)
        if (dpad.ibtnDpad[1].isPressed()) {
            character.bRight = true;
        } else {
            character.bRight = false;
        }

        if (dpad.ibtnDpad[3].isPressed()) {
            character.bLeft = true;
        } else {
            character.bLeft = false;
        }

        this.act(Gdx.graphics.getDeltaTime());
        this.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
}
