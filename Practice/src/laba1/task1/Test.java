package laba1.task1;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;

public class Test {
	
    public static double[][] transposeMatrix(double[][] m){
        double[][] temp = new double[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                temp[j][i] = m[i][j];
        return temp;
    }
	
	public static String toString(double[][] m) {
        String result = "";
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[i].length; j++) {
                result += String.format("%11.2f", m[i][j]);
            }
            result += "\n";
        }
        return result;
    }
	
	public static double[][] multiplyByMatrix(double[][] m1, double[][] m2) {
        int m1ColLength = m1[0].length; // m1 columns length
        int m2RowLength = m2.length;    // m2 rows length
        if(m1ColLength != m2RowLength) return null; // matrix multiplication is not possible
        int mRRowLength = m1.length;    // m result rows length
        int mRColLength = m2[0].length; // m result columns length
        double[][] mResult = new double[mRRowLength][mRColLength];
        for(int i = 0; i < mRRowLength; i++) {         // rows from m1
            for(int j = 0; j < mRColLength; j++) {     // columns from m2
                for(int k = 0; k < m1ColLength; k++) { // columns from m1
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return mResult;
    }

	public static void main(String[] args) {
		
		 // #1
        double[][] multiplicand = new double[][] {
                {3, -1, 2},
                {2,  3, 1},
                {1,  2, 1}
        };
        double[][] multiplier = new double[][] {
                {2, -1, 1},
                {7, -2, 3},
                {3,  0, 1}
        };
        System.out.println("#1\n" + toString(multiplyByMatrix(multiplicand, multiplier)));
        // #2
        multiplicand = new double[][] {
                {1, 2, 2},
                {-1, 3, 1},
                {2, -2, 1}
        };
        multiplier = new double[][] {
                {2},
                {-1},
                {1}
        };
        System.out.println("#2\n" + toString(multiplyByMatrix(multiplicand, multiplier)));
        // #3
        multiplicand = new double[][] {
                {1, 2, -1},
                {5,  1, 3}
        };
        multiplier = new double[][] {
                {1, 1, 7, 8},
                {5, 2, 1, 1},
                {1, 1, 2, 2}
        };
        System.out.println("#3\n" + toString(multiplyByMatrix(multiplicand, multiplier)));
        System.out.println();
        
        System.out.println(toString(transposeMatrix(multiplier)));
        
//        double dd =BigDecimal.valueOf(3.333432432423).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue();
//        System.out.println(dd);
//		double[][] d1 = new double[5][3];
//		double[][] d2 = new double[5][3];
//		Random r = new Random(5);
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 3; j++) {
//				d1[i][j] = r.nextDouble();
//				d2[i][j] = r.nextDouble();
//			}
//		}
//		System.out.println(Arrays.deepToString(d1));
//		System.out.println(Arrays.deepToString(d2));
//
//		double[][] d3 = new double[5][3];
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 3; j++) {
//				d3[i][j] = d1[i][j] + d2[i][j];
//			}
//		}
//		System.out.println(Arrays.deepToString(d3));
	}
}
