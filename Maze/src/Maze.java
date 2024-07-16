import java.util.Random;

public class Maze extends MyFrame {
	public void run() {
		int[][] maze = new int[15][15];
		int x = 0, y = 0;
		for (x = 0; x < 15; x++) {
			for (y = 0; y < 15; y++) {
				if (x == 0 || y == 0 || x == 14 || y == 14) {
					maze[x][y] = 1;
					drawString("■", 40 + (x * 19), 70 + (y * 19), 20);
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
		drawString("■", 59, 70, 20);
		setColor(0, 0, 255);
		

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
						break;
					}
				}
			}
		}
		for (x = 0; x < 15; x++) {
			for (y = 0; y < 15; y++) {
				if (maze[x][y] == 1) {
					maze[x][y] = 1;
					drawString("■", 40 + (x * 19), 70 + (y * 19), 20);
				}
			}
		}
		
	}
}
