package laba1.task2;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		
		Shape[] shapes = new Shape[10];
		Random random = new Random();
		double[] trianglePoints = new double[6];
		double[] quadranglePoints = new double[8];
		
		for (int i = 0; i < shapes.length; i++) {
			if(random.nextBoolean()) {
				for (int j = 0; j < trianglePoints.length; j++) {
					trianglePoints[j] = random.nextInt(100) - 50;
				}
				shapes[i] = new Triangle(trianglePoints);
			} else {
				for (int j = 0; j < quadranglePoints.length; j++) {
					quadranglePoints[j] = random.nextInt(100) - 50;
				}
				shapes[i] = new Quadrangle(quadranglePoints);
			}
		}
		
		for(Shape shape : shapes) {
			if(shape != null)
			shape.print();
		}
		for (int i = 0; i < shapes.length; i++) {
			if(shapes[i].getClass().equals(Triangle.class)) {
			System.out.println("shapes[" + i + "] -> Triangle");
			} else if(shapes[i].getClass().equals(Quadrangle.class)) {
				System.out.println("shapes[" + i + "] -> Quadrangle");
			}
		}

	}

}
