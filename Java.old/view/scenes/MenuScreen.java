package com.mygdx.game.view.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mygdx.game.config.Config;
import com.mygdx.game.view.MainGame;

public class MenuScreen extends BaseScreen {

    private final Stage stage;
    private final Skin skin;

    public MenuScreen(MainGame game) {
        super(game);

        //Skins and Camera
        this.stage = new Stage(new FillViewport(Config.Window.SIZE.x, Config.Window.SIZE.y));
        this.skin = new Skin(Gdx.files.internal("Skin/uiskin.json"));

        //Widgets
        TextButton playButton = new TextButton("Jugar", this.skin);
        TextButton exitButton = new TextButton("Salir", this.skin);
        TextButton optionButton = new TextButton("Opciones", this.skin);
        Label title = new Label("Crypto Minesweeper", this.skin);

        //Styles
        title.setSize(200, 50);
        title.setPosition(Config.Window.SIZE.x / 2 - title.getWidth() / 2, Config.Window.SIZE.y / 2 + title.getHeight() * 5);
        title.setAlignment(1);

        playButton.setSize(200, 50);
        playButton.setPosition(Config.Window.SIZE.x / 2 - playButton.getWidth() / 2, Config.Window.SIZE.y / 2);

        exitButton.setSize(200, 50);
        exitButton.setPosition(Config.Window.SIZE.x / 2 - exitButton.getWidth() / 2, Config.Window.SIZE.y / 2 - exitButton.getHeight() * 4);

        optionButton.setSize(200, 50);
        optionButton.setPosition(Config.Window.SIZE.x / 2 - optionButton.getWidth() / 2, Config.Window.SIZE.y / 2 - optionButton.getHeight() * 2);

        this.stage.addActor(title);
        this.stage.addActor(playButton);
        this.stage.addActor(exitButton);
        this.stage.addActor(optionButton);

        //ACTIONS
        playButton.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                MenuScreen.super.game.setScreen(MenuScreen.super.game.getInGameScreen());

            }
        });

        optionButton.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //NOTHING YET
            }
        });

        exitButton.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                MenuScreen.super.game.dispose();
                Gdx.app.exit();
            }
        });

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this.stage);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.stage.act();
        this.stage.draw();

    }

    @Override
    public void dispose() {

        this.skin.dispose();
        this.stage.dispose();

    }
}
