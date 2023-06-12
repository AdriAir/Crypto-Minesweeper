package com.mygdx.game.config;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.view.MainGame;

public class Config {

    public static class Window {
        //SIZE IN PIXELS
        public static final Vector2 SIZE = new Vector2(1900f,980f);
        public static final String TITLE = "Crypto Minesweeper Online";
        public static final boolean RESIZABLE = false;
    }
    public static class Grid {

        //SIZE IN CELLS
        public static final Vector2 SIZE = new Vector2(10,10);

        //ABSOLUTE POSITION IN PIXELS
        public static final Vector2 POSITION = new Vector2(0f,0f);


    }

    public static class Cel {

        //SIZE IN PIXELS
        public static final Vector2 SIZE = new Vector2(100f, 100f);

        //MARGIN IN PIXELS
        public static final float MARGIN = 0f;
        public static final Texture TEXTURE = MainGame.getAssets().get("Image/cel.png", Texture.class);
    }

}
