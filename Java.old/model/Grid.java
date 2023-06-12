package com.mygdx.game.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.config.Config;

public class Grid extends Actor {

    protected Vector2 size;
    protected Vector2 position;
    protected Cel[][] cels;

    public Grid(){
        this.size = Config.Grid.SIZE;
        this.position = Config.Grid.POSITION;

        this.cels = new Cel[(int) this.size.x][(int) this.size.y];

        Vector2 CelPosition = new Vector2(Config.Grid.POSITION);

        for (int i = 0; i < this.size.x; i++){
            for (int j = 0; j < this.size.y; j++){
                this.cels[i][j] = new Cel(CelPosition);
                CelPosition.x += Config.Cel.SIZE.x + Config.Cel.MARGIN;
            }
            CelPosition.x = Config.Grid.POSITION.x;
            CelPosition.y += Config.Cel.SIZE.y + Config.Cel.MARGIN;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (Cel[] row: this.cels) {
            for (Cel cel: row) {
                cel.draw(batch, parentAlpha);
            }
        }
    }

    @Override
    public void act(float delta) {
        for (Cel[] row: this.cels) {
            for (Cel cel: row) {
                cel.act(delta);
            }
        }
    }

    public void dispose(){
        for (Cel[] row: this.cels) {
            for (Cel cel: row) {
                cel.dispose();
            }
        }
    }

}
