package laba1.task2;

/**
 * Implementation of the {@code Shape} class which allows
 * to create quadrangles.
 * @author  Vasiliy
 */
public class Quadrangle extends Shape {
	
	private double ax;
	private double ay;
	private double bx;
	private double by;
	private double cx;
	private double cy;
	private double dx;
	private double dy;
	/**
	 * Constructor with varargs to simplify the creation
	 * of an instance. Constructs the quadrangle with 
	 * specified coordinates.
	 * 
	 * @param coordinates the coordinates of the points
	 * of the quadrangle in the following order: Ax, Ay, Bx, By,
	 * Cx, Cy, Dx, Dy.
	 * @throws IllegalArgumentException if there are less or 
	 * more than eight doubles.
	 */
	public Quadrangle(double... coordinates) {
		if(coordinates.length != 8)
			throw new IllegalArgumentException("there "
					+ "must be eight doubles.");
		ax = coordinates[0];
		ay = coordinates[1];
		bx = coordinates[2];
		by = coordinates[3];
		cx = coordinates[4];
		cy = coordinates[5];
		dx = coordinates[6];
		dy = coordinates[7];
	}
	/**
	 * Constructs the quadrangle with specified coordinates.
	 * 
	 * @param ax the X-Asis coordinate of the A point of the quadrangle
	 * @param ay the Y-Asis coordinate of the A point of the quadrangle
	 * @param bx the X-Asis coordinate of the B point of the quadrangle
	 * @param by the Y-Asis coordinate of the B point of the quadrangle
	 * @param cx the X-Asis coordinate of the C point of the quadrangle
	 * @param cy the Y-Asis coordinate of the C point of the quadrangle
	 * @param dx the X-Asis coordinate of the D point of the quadrangle
	 * @param dy the Y-Asis coordinate of the D point of the quadrangle
	 */
	public Quadrangle(double ax, double ay, double bx, double by, double cx,
			double cy, double dx, double dy) {
		this.ax = ax;
		this.ay = ay;
		this.bx = bx;
		this.by = by;
		this.cx = cx;
		this.cy = cy;
		this.dx = dx;
		this.dy = dy;
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

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	/**
	 * Default constructor.
	 */
	public Quadrangle() {
	
	}

	@Override
	public void print() {
		System.out.println("A(" + ax + ", " + ay + "), " + 
				"B(" + bx + ", " + by + "), " + 
				"C(" + cx + ", " + cy + ")." + 
				"D(" + dx + ", " + dy + ").");

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
		dx *= ratio;
		dy *= ratio;
		

	}

	@Override
	public void shift(double xShift, double yShift) {
		ax += xShift;
		ay += yShift;
		bx += xShift;
		by += yShift;
		cx += xShift;
		cy += yShift;
		dx += xShift;
		dy += yShift;

	}

}
