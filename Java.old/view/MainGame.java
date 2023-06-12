package com.mygdx.game.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.config.Config;
import com.mygdx.game.view.scenes.BaseScreen;
import com.mygdx.game.view.scenes.InGameScreen;
import com.mygdx.game.view.scenes.LoadingScreen;
import com.mygdx.game.view.scenes.MenuScreen;

public class MainGame extends Game {

	private static AssetManager assets;
	private BaseScreen menuScreen;
	private BaseScreen loadingScreen;
	private BaseScreen inGameScreen;

	@Override
	public void create() {

		//WINDOW CONFIG
		Gdx.graphics.setTitle(Config.Window.TITLE);
		Gdx.graphics.setWindowedMode((int) Config.Window.SIZE.x, (int) Config.Window.SIZE.y);
		Gdx.graphics.setResizable(Config.Window.RESIZABLE);


		// Cargador de recursos
		assets = new AssetManager();
		assets.load("Image/cel.png", Texture.class);
		assets.finishLoading();

		//Carga de Escenas
		this.loadingScreen = new LoadingScreen(this);
		this.menuScreen = new MenuScreen(this);
		this.inGameScreen = new InGameScreen(this);

		//Iniciar Escena "menuScreen"
		this.setScreen(menuScreen);

	}

	public static AssetManager getAssets() {
		return assets;
	}

	public BaseScreen getMenuScreen() {
		return menuScreen;
	}

	public BaseScreen getLoadingScreen() {
		return loadingScreen;
	}

	public BaseScreen getInGameScreen() {
		return inGameScreen;
	}
}

