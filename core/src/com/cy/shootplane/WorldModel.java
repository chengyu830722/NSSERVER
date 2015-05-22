package com.cy.shootplane;

import java.util.ArrayList;
import java.util.Random;
import com.badlogic.gdx.math.Vector2;

enum Component {
	head, body, wing,nothing
};

public class WorldModel {
	//飞机层
	public Component[][] gridPlane = new Component[10][10];
	//迷雾层 0,invisible；1,visible
	public int[][] gridMist = new int[10][10];
	public ArrayList<Plane> planeList = new ArrayList<Plane>();
	Random random = new Random(System.currentTimeMillis());

	/**
	 * 
	 */
	public WorldModel() {
		super();
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				gridPlane[x][y]=Component.nothing;
				gridMist[x][y]=0;
			}
		}
	}

	// 设置飞机到grid中
	void SetPlane(Plane plane) {
		// 机头
		Vector2 head = plane.pos;
		gridPlane[(int) head.x][(int) head.y] = Component.head;
		// 机身
		int[] arraybody = { 1, 2, 3, 4 };
		for (int i : arraybody) {
			gridPlane[(int) plane.planepoint[i].x][(int) plane.planepoint[i].y] = Component.body;
		}
		// 机翼
		int[] arraywing = { 5, 6, 7, 8, 9, 10 };
		for (int i : arraywing) {
			gridPlane[(int) plane.planepoint[i].x][(int) plane.planepoint[i].y] = Component.wing;
		}
	}

	// 检查2架飞机是否相撞
	boolean is2PlaneCrash(Plane a, Plane b) {
		Vector2[] pointlist1 = a.planepoint;
		Vector2[] pointlist2 = b.planepoint;
		for (Vector2 v1 : pointlist1) {
			for (Vector2 v2 : pointlist2) {
				if ((v1.x == v2.x) && (v1.y == v2.y)) {
					return true;
				}
			}
		}
		return false;
	}

	// 检查飞机是否飞出边界
	boolean isPlaneOutBound(Plane a) {
		for (Vector2 point : a.planepoint) {
			if ((point.x < 0) || (point.x > 9) || (point.y < 0)
					|| (point.y > 9))
				return true;
		}
		return false;
	}

	// 随机产生一架飞机
	void RandomBiuldPlane() {
		while (true) {
			Vector2 randPos = new Vector2(random.nextInt(10),
					random.nextInt(10));
			Direction randDirectiondirection = Direction.values()[random
					.nextInt(4)];
			Plane plane = new Plane(randPos, randDirectiondirection);
			if (isPlaneOutBound(plane)) {
				continue;
			}
			boolean isCrash = false;
			for (Plane otherplain : planeList) {
				if (is2PlaneCrash(plane, otherplain)) {
					isCrash = true;
				}
			}
			if (isCrash) {
				continue;
			}
			//产生一架不碰撞不越界的飞机
			SetPlane(plane);
			planeList.add(plane);
			break;
		}
	}
	void shoot(Vector2 pos)
	{
		gridMist[(int) pos.x][(int) pos.y]=1;
		//击中飞机
		for (Plane plane : planeList) {
			if ((plane.planepoint[0].x==pos.x)&&(plane.planepoint[0].y==pos.y)) {
				for (Vector2 temp : plane.planepoint) {
					gridMist[(int) temp.x][(int) temp.y]=1;
				}
			}
		}
	}
}
