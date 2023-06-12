package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.config.Config;

public class Cel extends Actor {

    protected Vector2 size;
    protected Vector2 position;
    protected Texture texture;

    public Cel(Vector2 position){
        this.size = Config.Cel.SIZE;
        this.position = position;
        this.texture = Config.Cel.TEXTURE;

        super.setVisible(true);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        batch.draw(texture, getX(), getY(), getWidth(), getHeight());

    }

    @Override
    public void act(float delta) {
        super.act(delta);

        //Interactions

    }

    public void dispose(){
        this.texture.dispose();
    }
}
