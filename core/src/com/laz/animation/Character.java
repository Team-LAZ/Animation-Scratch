package com.laz.animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

//http://stackoverflow.com/questions/13780742/libgdx-difference-between-sprite-and-actor
//http://stackoverflow.com/questions/21495258/how-can-i-change-the-texture-in-a-scene2d-image-using-libgdx
//https://github.com/dinnatruong/BombermanMovement/blob/master/core/src/com/mygdx/game/Character.java
//http://stackoverflow.com/questions/22121467/remove-actors-from-stage

public class Character extends Actor {

    Image imgKnight;
    TextureAtlas taKnight;
    TextureRegion trCurrentFrame, trLeft[], trRight[];
    Animation aniLeft, aniRight;

    float fStateTime, x, y;
    boolean bLeft, bRight, bStop;

    public Character() {
        imgKnight = new Image();

        taKnight = new TextureAtlas("knightpacked.pack");

        trCurrentFrame = new TextureRegion();
        trLeft = new TextureRegion[3];
        trRight = new TextureRegion[3];
        for (int i = 0; i < 3; i++) {
            trLeft[i] = taKnight.findRegion("knightleft" + (i + 1));
            trRight[i] = taKnight.findRegion("knightright" + (i + 1));
        }

        aniLeft = new Animation(0.15f, trLeft);
        aniRight = new Animation(0.15f, trRight);

        fStateTime = 0f;
        y = Gdx.graphics.getHeight() / 2;
        bRight = true;
    }

    public void render(Stage stage) {
        fStateTime += Gdx.graphics.getDeltaTime();

        x = imgKnight.getX();
        imgKnight.remove();

        if (bRight) {
            if (bStop) {
                trCurrentFrame = trRight[0];
            } else {
                trCurrentFrame = aniRight.getKeyFrame(fStateTime, true);
            }
            x += 5;
        } else if (bLeft) {
            if (bStop) {
                trCurrentFrame = trLeft[0];
            } else {
                trCurrentFrame = aniLeft.getKeyFrame(fStateTime, true);
            }
            x -= 5;
        }

        imgKnight = new Image(trCurrentFrame);
        stage.addActor(imgKnight);
        imgKnight.setPosition(x, y);
    }
}
