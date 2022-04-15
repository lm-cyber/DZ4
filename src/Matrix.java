public class Matrix {
    private byte[][] matrix = {
            {0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
            {0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1},
            {0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
            {1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0},
            {0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1},
            {0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1},
            {0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1},
            {0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0}
    };

    public int[] count() {
        int[] count = new int[13];
        for (int i = 0; i < 13; i++) {
            count[i] = 0;
        }
        for (int i = 1; i < 12; i++) {
            for (int j = 11; j >= 2 + i; j--) {
                if (matrix[i][j] == 1) {
                    count[12] += 1;
                    for (int g = j - 1; g >= i + 1; g--) {
                        for (int o = i - 1; o >= 0; o--) {
                            count[i] += matrix[o][g];
                        }
                    }
                }
            }
        }

        return count;
    }

    public int kol() {
        int count = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 2 + i; j <= 11; j++) {
                if (matrix[i][j] == 1 && !(i == 0 && j == 11)) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public MatrixOfIntersection matrixOfIntersection() {
        MatrixOfIntersection matrixOfIntersection = new MatrixOfIntersection();
        int count = kol();
        matrixOfIntersection.kol =count;
        matrixOfIntersection.matrix = new byte[count][count];
        matrixOfIntersection.names = new String[count];
        int p = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 2 + i; j <= 11; j++) {
                if (matrix[i][j] == 1 && !(i == 0 && j == 11)) {
                    matrixOfIntersection.names[p] = new String(Integer.toString(i + 1) + "-" + Integer.toString(j + 1));
                    p++;
                }
            }
        }
        for (int i = 0 ; i<count;i++){
            matrixOfIntersection.matrix[i][i]=1;
        }
        for (int i = 1; i < 12; i++) {
            for (int j = 2 + i; j < 12; j++) {
                if(matrix[i][j]==1)
                {
                    for (int index =0;index<i;index++) {
                        for (int jndex =i+2;jndex<j;jndex++) {
                            if(matrix[index][jndex]==1) {
                                int k = matrixOfIntersection.find(new String(Integer.toString(i + 1) + "-" + Integer.toString(j + 1)));
                                int g = matrixOfIntersection.find(new String(Integer.toString(index + 1) + "-" + Integer.toString(jndex + 1)));
                                matrixOfIntersection.matrix[k][g] = 1;
                                matrixOfIntersection.matrix[g][k] = 1;
                            }

                        }
                    }
                }
            }
        }
        return matrixOfIntersection;
    }
}
