package com.cy.shootplane;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter  {
	SpriteBatch batch;
	Texture img;
	WorldView view;
	WorldModel model;
	WorldControl control;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		model=new WorldModel();
		view=new WorldView(model);
		control=new WorldControl(view);
		model.RandomBiuldPlane();
		model.RandomBiuldPlane();
		model.RandomBiuldPlane();
		Gdx.input.setInputProcessor(control);
		OrthographicCamera camera = new OrthographicCamera();
		camera.setToOrtho(false, 480, 800);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 10,10);
//		batch.end();
		view.render();
	}
	
}
