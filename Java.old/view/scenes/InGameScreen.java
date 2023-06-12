package com.mygdx.game.view.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mygdx.game.config.Config;
import com.mygdx.game.model.Grid;
import com.mygdx.game.view.MainGame;

public class InGameScreen extends BaseScreen {

    protected final Stage stage;
    protected final Vector3 cameraPosition;
    protected Grid grid;

    public InGameScreen(MainGame game) {

        super(game);

        //New Scene2D
        this.stage = new Stage(new FillViewport(Config.Window.SIZE.x, Config.Window.SIZE.y));
        this.cameraPosition = new Vector3(this.stage.getCamera().position);

    }

    @Override
    public void show() {

        //Creating Actors
        this.grid = new Grid();

        //Adding Actors
        this.stage.addActor(this.grid);

        //Camera Settings
        this.stage.getCamera().position.set(this.cameraPosition);
        this.stage.getCamera().update();

        //Play Music

    }

    @Override
    public void hide() {

        this.stage.clear();
        this.grid.dispose();

    }

    @Override
    public void render(float delta) {
        // Cleaning Screen
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Updating Stage and Actors
        this.stage.act();
        this.grid.act(delta);

        //Game Actions

        // Render Stage
        stage.draw();
    }

    @Override
    public void dispose() {
        this.stage.dispose();
    }

}
