package com.cy.shootplane;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class WorldView {
	WorldModel model;
	ShapeRenderer debugRenderer = new ShapeRenderer();

	/**
	 * @param model
	 */
	public WorldView(WorldModel model) {
		super();
		this.model = model;
	}

	void render() {
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		debugrender();
		Gdx.gl.glDisable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_ONE, GL20.GL_ZERO );
	}

	public void debugrender() {
		int[][] gridmist = model.gridMist;
		Component[][] gridplane = model.gridPlane;
		debugRenderer.begin(ShapeType.Filled);
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				if (gridmist[x][y] == 0) {
					// 迷雾中，不可视
					debugRenderer.setColor(GLOBALVAL.COLORMIST);
				} else if (gridmist[x][y] == 1) {
					// 可视
					switch (gridplane[x][y]) {
					case body:
						debugRenderer.setColor(GLOBALVAL.COLORBODY);
						break;
					case wing:
						debugRenderer.setColor(GLOBALVAL.COLORWING);
						break;
					case head:
						debugRenderer.setColor(GLOBALVAL.COLORHEAD);
						break;
					case nothing:
						debugRenderer.setColor(GLOBALVAL.COLORNOTHING);
						break;
					default:
						break;
					}
				}
				int pointx = (int) GLOBALVAL.TablePos.x;
				int pointy = (int) GLOBALVAL.TablePos.y;
				debugRenderer.rect(pointx + x * GLOBALVAL.WIDTH, pointy + y
						* GLOBALVAL.WIDTH, GLOBALVAL.WIDTH, GLOBALVAL.WIDTH);
			}
		}
		debugRenderer.end();
	}
}
