package com.cy.shootplane;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;

public class WorldControl extends InputAdapter {
	WorldView view;

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		screenY=800-screenY;
		int width = GLOBALVAL.WIDTH;
		Vector2 TablePos = GLOBALVAL.TablePos;
		if ((screenX > TablePos.x) && (screenX < TablePos.x + width * 10)
				&& (screenY > TablePos.y)
				&& (screenY < TablePos.y + width * 10)) {
			int x=(int) ((screenX-TablePos.x)/width);
			int y=(int) ((screenY-TablePos.y)/width);
			view.model.shoot(new Vector2(x,y));
		}
		return true;
	}

	/**
	 * @param view
	 */
	public WorldControl(WorldView view) {
		super();
		this.view = view;
	}

}
