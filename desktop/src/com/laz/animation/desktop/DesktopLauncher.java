package com.laz.animation.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.laz.animation.AnimationScratch;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Animation Scratch";
        config.width = 1280;
        config.height = 720;
        new LwjglApplication(new AnimationScratch(), config);
    }
}
