package laba1.task2;

public class Triangle extends Shape {
	
	private double ax;
	private double ay;
	private double bx;
	private double by;
	private double cx;
	private double cy;
	
	public Triangle(double... d) {
		if(d.length != 6)
			throw new IllegalArgumentException("there "
					+ "must be six doubles.");
		ax = d[0];
		ay = d[1];
		bx = d[2];
		by = d[3];
		cx = d[4];
		cy = d[5];
	}

	public double getAx() {
		return ax;
	}

	public void setAx(double ax) {
		this.ax = ax;
	}

	public double getAy() {
		return ay;
	}

	public void setAy(double ay) {
		this.ay = ay;
	}

	public double getBx() {
		return bx;
	}

	public void setBx(double bx) {
		this.bx = bx;
	}

	public double getBy() {
		return by;
	}

	public void setBy(double by) {
		this.by = by;
	}

	public double getCx() {
		return cx;
	}

	public void setCx(double cx) {
		this.cx = cx;
	}

	public double getCy() {
		return cy;
	}

	public void setCy(double cy) {
		this.cy = cy;
	}

	public Triangle() {

	}

	public Triangle(double ax, double ay, double bx, double by, double cx, double cy) {
		this.ax = ax;
		this.ay = ay;
		this.bx = bx;
		this.by = by;
		this.cx = cx;
		this.cy = cy;
	}

	@Override
	public void print() {
		System.out.println("A(" + ax + ", " + ay + "), " + 
					"B(" + bx + ", " + by + "), " + 
					"C(" + cx + ", " + cy + ").");

	}

	@Override
	public void scale(double ratio) {
		if(ratio < 0) {
			throw new IllegalArgumentException("ratio can not be negative");
		}
		ax *= ratio;
		ay *= ratio;
		bx *= ratio;
		by *= ratio;
		cx *= ratio;
		cy *= ratio;

	}

	@Override
	public void shift(double xShift, double yShift) {
		ax += xShift;
		ay += yShift;
		bx += xShift;
		by += yShift;
		cx += xShift;
		cy += yShift;

	}

}
