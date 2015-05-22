package com.cy.shootplane;

import com.badlogic.gdx.math.Vector2;
enum Direction{up,down,left,right};
public class Plane {
	Vector2 pos;
	Direction direction;
	Vector2[] planepoint=new Vector2[11];
	/**
	 * @param pos 机头的位置
	 * @param direction 机头的方向
	 */
	public Plane(Vector2 pos, Direction direction) {
		super();
		this.pos = pos;
		this.direction = direction;
		switch (direction) {
		case up:
			planepoint[0]=pos;
			planepoint[1]=new Vector2(pos.x,pos.y+1);
			planepoint[2]=new Vector2(pos.x,pos.y+2);
			planepoint[3]=new Vector2(pos.x,pos.y+3);
			planepoint[4]=new Vector2(pos.x,pos.y+4);
			planepoint[5]=new Vector2(planepoint[1].x+2,planepoint[1].y);
			planepoint[6]=new Vector2(planepoint[1].x+1,planepoint[1].y);
			planepoint[7]=new Vector2(planepoint[1].x-1,planepoint[1].y);
			planepoint[8]=new Vector2(planepoint[1].x-2,planepoint[1].y);
			planepoint[9]=new Vector2(planepoint[4].x+1,planepoint[4].y);
			planepoint[10]=new Vector2(planepoint[4].x-1,planepoint[4].y);
			break;
		case down:
			planepoint[0]=pos;
			planepoint[1]=new Vector2(pos.x,pos.y-1);
			planepoint[2]=new Vector2(pos.x,pos.y-2);
			planepoint[3]=new Vector2(pos.x,pos.y-3);
			planepoint[4]=new Vector2(pos.x,pos.y-4);
			planepoint[5]=new Vector2(planepoint[1].x-2,planepoint[1].y);
			planepoint[6]=new Vector2(planepoint[1].x-1,planepoint[1].y);
			planepoint[7]=new Vector2(planepoint[1].x+1,planepoint[1].y);
			planepoint[8]=new Vector2(planepoint[1].x+2,planepoint[1].y);
			planepoint[9]=new Vector2(planepoint[4].x-1,planepoint[4].y);
			planepoint[10]=new Vector2(planepoint[4].x+1,planepoint[4].y);
			break;
		case left:
			planepoint[0]=pos;
			planepoint[1]=new Vector2(pos.x-1,pos.y);
			planepoint[2]=new Vector2(pos.x-2,pos.y);
			planepoint[3]=new Vector2(pos.x-3,pos.y);
			planepoint[4]=new Vector2(pos.x-4,pos.y);
			planepoint[5]=new Vector2(planepoint[1].x,planepoint[1].y+2);
			planepoint[6]=new Vector2(planepoint[1].x,planepoint[1].y+1);
			planepoint[7]=new Vector2(planepoint[1].x,planepoint[1].y-1);
			planepoint[8]=new Vector2(planepoint[1].x,planepoint[1].y-2);
			planepoint[9]=new Vector2(planepoint[4].x,planepoint[4].y+1);
			planepoint[10]=new Vector2(planepoint[4].x,planepoint[4].y-1);
			break;
		case right:
			planepoint[0]=pos;
			planepoint[1]=new Vector2(pos.x+1,pos.y);
			planepoint[2]=new Vector2(pos.x+2,pos.y);
			planepoint[3]=new Vector2(pos.x+3,pos.y);
			planepoint[4]=new Vector2(pos.x+4,pos.y);
			planepoint[5]=new Vector2(planepoint[1].x,planepoint[1].y-2);
			planepoint[6]=new Vector2(planepoint[1].x,planepoint[1].y-1);
			planepoint[7]=new Vector2(planepoint[1].x,planepoint[1].y+1);
			planepoint[8]=new Vector2(planepoint[1].x,planepoint[1].y+2);
			planepoint[9]=new Vector2(planepoint[4].x,planepoint[4].y-1);
			planepoint[10]=new Vector2(planepoint[4].x,planepoint[4].y+1);
			break;
		default:
			break;
		}
	}
	
}
