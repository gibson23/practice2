package laba1.task2;


/**
 * The abstract class {@code Shape} is the superclass of 
 * classes representing different shapes.
 * @author  Vasiliy
 */
public abstract class Shape {
    /**
     * Prints out coordinates of the current {@code Shape}.
     */
	public abstract void print();
    /**
     * Scales the {@code Shape} in according to the specified ratio.
     * @param ratio the scale to be applied to this {@code Shape}.
     */
	public abstract void scale(double ratio);
	/**
     * Shifts the {@code Shape} in according to the specified vector.
     * @param xShift the X-Axis coordinate of the vector.
     * @param yShift the Y-Axis coordinate of the vector.
     */
	public abstract void shift(double xShift, double yShift);

}
