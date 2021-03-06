public class Matrix

{

    /*!
    ** Create a copy of a 2D array.
    **
    ** @param A matrix.
    **
    ** @return A cloned 2D array.
    */

    public static int[][] copyMatrix(int matrix[][])

    {

        int[][] myInt = new int[matrix.length][];

        for (int i = 0; i < matrix.length; i++)

        {

            int[] aMatrix = matrix[i];

            int aLength = aMatrix.length;

            myInt[i] = new int[aLength];

            System.arraycopy(aMatrix, 0, myInt[i], 0, aLength);

        }

        return myInt;

    }



    /*!
    ** Print the given matrix.
    ** Ex:
    **   [50,60,55,67,70]
    **   [62,65,70,70,81]
    **   [72,66,77,80,69]
    **
    ** @param A matrix.
    */


    public static void printMatrix(int matrix[][])

    {
        //Remember TabFunction ^_^
        for (int[] aMatrix : matrix) {
            System.out.print("[");
            Boolean first = true;
            for (int anAMatrix : aMatrix) {
                if (first)
                    first = false;
                else
                    System.out.print(",");
                System.out.print(anAMatrix);
            }
            System.out.print("]");
            System.out.println();
        }
        System.out.println();
    }



    /*!
    ** Check if two matrix are equal.
    **
    ** @param matrix1 The first matrix.
    ** @param matrix2 The second matrix.
    **
    ** @return If matrix are equal.
    */

    public static Boolean matrixEqual(int matrix1[][], int matrix2[][])

    {
        if (matrix1.length != matrix2.length)
            return false;

        for (int i = 0; i < matrix1.length && i < matrix2.length; i++) {

            if (matrix1[i].length != matrix2[i].length)
                return false;

            for (int k = 0; k < matrix1[i].length; k++) {
                if (matrix1[i][k] != matrix2[i][k])
                    return false;
            }
        }
        return true;
    }



    /*!
    ** Add two matrix.
    **
    ** @param matrix1 The first matrix.
    ** @param matrix2 The second matrix.
    **
    ** @return A new matrix which is the addition of two given ones.
    */

    public static int[][] addMatrix(int matrix1[][], int matrix2[][])

    {
        int res[][] = copyMatrix(matrix1);

        if (matrix1.length != matrix2.length)
            return res;

        for (int i = 0; i < res.length; i++) {

            if (matrix1[i].length != matrix2[i].length)
                return res;

            for (int j = 0; j < res[i].length; j++)
                res[i][j] = matrix1[i][j] + matrix2[i][j];
        }


        return res;
    }



    /*!
    ** Mutliply two matrix.
    **
    ** @param matrix1 The first matrix.
    ** @param matrix2 The second matrix.
    **
    ** @return A new matrix which is the multiplication of two given ones.
    */

    public static int[][] multMatrix(int matrix1[][], int matrix2[][])

    {

        if (matrix1.length == 0 || matrix2.length == 0)
            return matrix1;

        int aRows = matrix1.length,
                aCols = matrix1[0].length,
                bRows = matrix2.length,
                bCols = matrix2[0].length;

        if (aCols != bRows)
            return matrix1;

        int res[][] = new int[aRows][bCols];
        //1st Level : line of the first array
        for (int i = 0; i < aRows; i++) {
            //2nd Level : handle the vector column of the second array
            for (int j = 0; j < bCols; j++) {
                //3td Level : Column of the first array
                for (int k = 0; k < aCols; k++) {
                    res[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return res;

    }



    /*!
    ** Test suite for Matrix.
    */

    public static void main(String[] args)

    {

        int matrix1[][] =

                {

                        {50, 60, 55, 67, 70},

                        {62, 65, 70, 70, 81},

                        {72, 66, 77, 80, 69}

                };

        int matrix2[][] =

                {

                        {5, 6, 55, 76, 7},

                        {26, 56, 7, 708, 1},

                        {276, 6, 778, 6, 9}

                };

        int matrix3[][] =

                {

                        {1, 2, 0},

                        {4, 3, -1}

                };

        int matrix4[][] =

                {

                        {5, 1},

                        {2, 3},

                        {3, 4}

                };

        int added[][] =

                {

                        {55, 66, 110, 143, 77},

                        {88, 121, 77, 778, 82},

                        {348, 72, 855, 86, 78},

                };

        int multiplied34[][] =

                {

                        {9, 7},

                        {23, 9},

                };

        int multiplied43[][] =

                {

                        {9, 13, -1},

                        {14, 13, -3},

                        {19, 18, -4},

                };

        int empty[][] =

                {

                };


        printMatrix(matrix1);

        printMatrix(matrix2);

        printMatrix(matrix3);

        printMatrix(matrix4);

        printMatrix(added);

        printMatrix(multiplied34);

        printMatrix(multiplied43);


        System.out.println("Matrix equal 1vs1: " + (matrixEqual(matrix1, matrix1) ? "Ok" : "Fail"));

        System.out.println("Matrix equal 1vs2: " + (!matrixEqual(matrix1, matrix2) ? "Ok" : "Fail"));

        System.out.println("Matrix equal 2vs1: " + (!matrixEqual(matrix2, matrix1) ? "Ok" : "Fail"));

        System.out.println("Matrix equal 3vs4: " + (!matrixEqual(matrix3, matrix4) ? "Ok" : "Fail"));


        System.out.println("Add 1+3 (invalid): " + (matrixEqual(addMatrix(matrix1, matrix3), matrix1) ? "Ok" : "Fail"));

        System.out.println("Add 1+4 (invalid): " + (matrixEqual(addMatrix(matrix1, matrix4), matrix1) ? "Ok" : "Fail"));

        System.out.println("Add 3+1 (invalid): " + (matrixEqual(addMatrix(matrix3, matrix1), matrix3) ? "Ok" : "Fail"));

        System.out.println("Add 4+1 (invalid): " + (matrixEqual(addMatrix(matrix4, matrix1), matrix4) ? "Ok" : "Fail"));

        System.out.println("Add 1+2: " + (matrixEqual(addMatrix(matrix1, matrix2), added) ? "Ok" : "Fail"));

        System.out.println("Add 2+1: " + (matrixEqual(addMatrix(matrix2, matrix1), added) ? "Ok" : "Fail"));


        System.out.println("Mult empty (invalid): " + (matrixEqual(multMatrix(empty, empty), empty) ? "Ok" : "Fail"));

        System.out.println("Mult 1*2 (invalid): " + (matrixEqual(multMatrix(matrix1, matrix2), matrix1) ? "Ok" : "Fail"));

        System.out.println("Mult 1*3 (invalid): " + (matrixEqual(multMatrix(matrix1, matrix3), matrix1) ? "Ok" : "Fail"));

        System.out.println("Mult 4*3: " + (matrixEqual(multMatrix(matrix4, matrix3), multiplied43) ? "Ok" : "Fail"));

        System.out.println("Mult 3*4: " + (matrixEqual(multMatrix(matrix3, matrix4), multiplied34) ? "Ok" : "Fail"));


        // Expected output:

        //

        // [50,60,55,67,70]

        // [62,65,70,70,81]

        // [72,66,77,80,69]

        //

        // [5,6,55,76,7]

        // [26,56,7,708,1]

        // [276,6,778,6,9]

        //

        // [1,2,0]

        // [4,3,-1]

        //

        // [5,1]

        // [2,3]

        // [3,4]

        //

        // [55,66,110,143,77]

        // [88,121,77,778,82]

        // [348,72,855,86,78]

        //

        // [1,2,0]

        // [4,3,-1]

        //

        // [9,13,-1]

        // [14,13,-3]

        // [19,18,-4]

        //


    }

}
