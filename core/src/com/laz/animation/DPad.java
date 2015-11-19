package com.laz.animation;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class DPad extends Actor {

    Image imgOutline;

    Sprite sprDpad[] = new Sprite[4];
    Skin skDpad;
    Drawable drwDpad[] = new Drawable[4];
    ImageButtonStyle ibsDpad[] = new ImageButtonStyle[4];
    ImageButton ibtnDpad[] = new ImageButton[4];

    public DPad() {
        //border around the dpad
        imgOutline = new Image(new Texture("dpad_outline.png"));
        imgOutline.setPosition(15, 15);

        //arrays for directions of dpad
        for (int i = 0; i < 4; i++) {
            sprDpad[i] = new Sprite(new Texture("dpad_arrow" + i + ".png"));

            //no need for an array of skins
            skDpad = new Skin();
            skDpad.add("dpad" + i, sprDpad[i]);

            drwDpad[i] = skDpad.getDrawable("dpad" + i);

            ibsDpad[i] = new ImageButtonStyle();
            ibsDpad[i].imageUp = drwDpad[i];

            ibtnDpad[i] = new ImageButton(ibsDpad[i]);
        }
        //0 = up, 1 = right, 2 = down, 3 = left
        ibtnDpad[0].setPosition(55, 100);
        ibtnDpad[1].setPosition(105, 50);
        ibtnDpad[2].setPosition(55, 0);
        ibtnDpad[3].setPosition(0, 50);
    }
}
