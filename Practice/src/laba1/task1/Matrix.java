package laba1.task1;

import java.util.Arrays;
import java.util.Random;

public class Matrix {
	
	private double[][] array;

	public Matrix() {
	}

	public Matrix(double[][] d) {
		this.array = d;
	}

	public double[][] getArray() {
		return array;
	}

	public void setArray(double[][] array) {
		this.array = array;
	}

	public Matrix add(Matrix m) {

		double[][] addingArray = m.getArray();
		if ((addingArray.length != this.array.length) ||
				(addingArray[0].length) != this.array[0].length) {
			throw new IllegalArgumentException("matrices must be" + 
		" the same dimension");
		}
		double[][] d3 = new double[addingArray.length][addingArray[0].length];
		for (int i = 0; i < addingArray.length; i++) {
			for (int j = 0; j < addingArray[0].length; j++) {
				d3[i][j] = this.array[i][j] + addingArray[i][j];
			}
		}

		return new Matrix(d3);
	}

	public Matrix multiply(Matrix m) {
		double[][] multiplier = m.getArray();
		if(this.array[0].length != multiplier.length) {
			throw new IllegalArgumentException("inner dimensions must agree");
		}

        int m1ColLength = this.array[0].length; // m1 columns length
        int mRRowLength = this.array[0].length;    // m result rows length
        int mRColLength = multiplier[0].length; // m result columns length
        double[][] mResult = new double[mRRowLength][mRColLength];
        for(int i = 0; i < mRRowLength; i++) {         // rows from m1
            for(int j = 0; j < mRColLength; j++) {     // columns from m2
                for(int k = 0; k < m1ColLength; k++) { // columns from m1
                    mResult[i][j] += this.array[i][k] * multiplier[k][j];
                }
            }
        }
        return new Matrix(mResult);
    }

	public Matrix transpose() {
		double[][] temp = 
				new double[this.array[0].length][this.array.length];
        for (int i = 0; i < this.array.length; i++)
            for (int j = 0; j < this.array[0].length; j++)
                temp[j][i] = this.array[i][j];
        return new Matrix(temp);
	}

	public void print() {
		this.toString();
	}

	@Override
	public String toString() {
        String result = "";
        for(int i = 0; i < this.array.length; i++) {
            for(int j = 0; j < this.array[i].length; j++) {
                result += this.array[i][j] + "   ";
            }
            result += "\n";
        }
        return result;
	}

	public static void main(String[] args) {
		double[][] d1 = new double[5][3];
		double[][] d2 = new double[3][5];
		Random r = new Random(5);
		double[][] d3 = new double[4][4];
		double[][] d4 = new double[4][4];
		double[][] d5 = {{5.5, 7.7},{2.2, 3.3}};

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				d3[i][j] = r.nextDouble() * 10;
				d4[i][j] = r.nextDouble() * 10;
				
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				d1[i][j] = r.nextDouble() * 10;
				
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				d2[i][j] = r.nextDouble() * 10;
				
			}
		}
		Matrix m1 = new Matrix(d1);
		Matrix m2 = new Matrix(d2);		
		Matrix m3 = new Matrix(d3);
		Matrix m4 = new Matrix(d4);
		Matrix m5 = new Matrix(d5);

		System.out.println("m1: " + "\n" + m1);
		System.out.println("m2: " + "\n" + m2);
		Matrix multiplicationResult = m1.multiply(m2);
		System.out.println("m1 * m2: " + "\n" + multiplicationResult);
		Matrix addingResult = m3.add(m4);
		System.out.println("m3: " + "\n" + m3);
		System.out.println("m4: " + "\n" + m4);
		System.out.println("m3 + m4: " + "\n" + addingResult);
		
		System.out.println("m5: " + "\n" + m5);
		Matrix mTransposed = m5.transpose();
		System.out.println("transposed m5: " + "\n" + mTransposed);
		
		System.out.println("******************");
		double[][] test1 = new double[2][1];
		double[][] test2 = new double[2][1];
		double[][] test3 = new double[1][2];
		System.out.println(Arrays.deepToString(test1));
		
		test1[0][0] = 3.3;
		test1[1][0] = 1.3;
		test2[0][0] = 5.3;
		test2[1][0] = 2.3;
		test3[0][0] = 6.3;
		test3[0][1] = 6.4;
		
		Matrix mTest1 = new Matrix(test1);
		Matrix mTest2 = new Matrix(test2);
		Matrix mTest3 = new Matrix(test3);
		System.out.println(mTest1.add(mTest2));
		System.out.println(mTest1.multiply(mTest3));
		System.out.println(mTest1.transpose());
		Matrix mTest4 = new Matrix(null);
		System.out.println(mTest1.add(mTest4));
	}

}
