package laba1.task2;

/**
 * Implementation of the {@code Shape} class which allows
 * to create triangles.
 * @author  Vasiliy
 */
public class Triangle extends Shape {
	
	private double ax;
	private double ay;
	private double bx;
	private double by;
	private double cx;
	private double cy;
	
	/**
	 * Constructs the triangle using array
	 * with specified coordinates.
	 * 
	 * @param coordinates the array containing coordinates
	 * of the points of the triangle in the following 
	 * order: Ax, Ay, Bx, By, Cx, Cy, Dx, Dy.
	 * @throws IllegalArgumentException if there are less or 
	 * more than six doubles.
	 */
	public Triangle(double... coordinates) {
		if(coordinates.length != 6)
			throw new IllegalArgumentException("there "
					+ "must be six doubles.");
		ax = coordinates[0];
		ay = coordinates[1];
		bx = coordinates[2];
		by = coordinates[3];
		cx = coordinates[4];
		cy = coordinates[5];
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

	@Override
	public void print() {
		System.out.println("A(" + ax + ", " + ay + "), " + 
					"B(" + bx + ", " + by + "), " + 
					"C(" + cx + ", " + cy + ").");

	}

	/**
	 * @throws IllegalArgumentException if specified
	 * ratio is negative.
	 */
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
