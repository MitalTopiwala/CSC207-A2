package ca.utoronto.utm.paint;

public class Point  {
	int x, y;

	Point(double d, double e) {
		this.x = (int) d;
		this.y = (int) e;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
