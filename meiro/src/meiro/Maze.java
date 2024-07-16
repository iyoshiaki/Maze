package meiro;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class Maze extends MyFrame {
	maze Maze =new maze();
	public void run() {
		addKeyListener(Maze);
		meiro();	
	}
	public void meiro() {
		int[][] maze = new int[15][15];
		int x = 0, y = 0;
		for (x = 0; x < 15; x++) {
			for (y = 0; y < 15; y++) {
				if (x == 0 || y == 0 || x == 14 || y == 14) {
					maze[x][y] = 1;
					setColor(0,0,0);
					drawString("■", 40 + (x * 19), 70 + (y * 19), 20);
					if(x ==1 && y==0) {
						setColor(0,0,255);
						drawString("■", 40 + (x * 19), 70 + (y * 19), 20);
						
					}else if(x==13&&y==14) {
						setColor(255,0,0);
						drawString("■", 40 + (x * 19), 70 + (y * 19), 20);
						
					}
				}
			}
		}
		for (x = 0; x < 15; x++) {
			for (y = 0; y < 15; y++) {
				if (x % 2 == 0 && y % 2 == 0) {
					maze[x][y] = 1;
					drawString("■", 40 + (x * 19), 70 + (y * 19), 20);
				}
			}
		}

		var rnd = new Random();
		for (x = 2; x < 14; x += 2) {
			for (y = 2; y < 14; y += 2) {
				while (true) {
					int direction;
					if (y == 2)
						direction = rnd.nextInt(4);
					else
						direction = rnd.nextInt(3);

					// 棒を倒す方向を決める
					int wallX = x;
					int wallY = y;
					switch (direction) {
					case 0: // 右
						wallX++;
						break;
					case 1: // 下
						wallY++;
						break;
					case 2: // 左
						wallX--;
						break;
					case 3: // 上
						wallY--;
						break;
					}
					// 壁じゃない場合のみ倒して終了
					if (maze[wallX][wallY] != 1) {
						maze[wallX][wallY] = 1;
						if(maze[wallX][wallY] == 1) {
							drawString("■", 40 + (wallX * 19), 70 + (wallY * 19), 20);
							sleep(1);
						}
						break;
					}
				}
			}
		}
	}
	public class maze implements KeyListener{
			
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			
		}
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				clear();
				meiro();
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			
		}
	}
	
}
