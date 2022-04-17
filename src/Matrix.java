import javax.management.Query;
import java.util.*;

public class Matrix {
    public static byte[][] newMatrix;
    public static byte[][] matrix = {
            {0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1},
            {0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
            {1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0},
            {1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0},
            {0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0},
            {0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1},
            {0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1},
            {1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1},
            {0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
            {1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0}
    };

    public static void changeMatrix() {
        newMatrix = new byte[12][];
        for (int i = 0; i < 12; i++) {
            newMatrix[i] = new byte[12];
        }
        List<Integer> change = findGamiltonCikl();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                newMatrix[i][j] = matrix[change.get(i)][change.get(j)];
            }
        }

    }


    public static List<Integer> push(List<Integer> list, Integer swap) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(swap);
        for (int i = 0; i < list.size() - 1; i++) {
            list1.add(list.get(i));
        }
        return list1;
    }


    public static List<Integer> findGamiltonCikl() {
        Integer swap;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add(i, i);
        }
        for (int i = 0; i < 12 * 11; i++) {
            if (matrix[list.get(0)][list.get(1)] != 1) {
                i = 2;

                while (matrix[list.get(0)][list.get(i)] != 1) {
                    i++;
                }
                swap = list.get(1);
                list.set(1, list.get(i));
                list.set(i, swap);
            }
            swap = list.get(list.size() - 1);
            list = push(list, swap);

        }
        return list;
    }

    public int kol() {
        int count = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 2 + i; j <= 11; j++) {
                if (newMatrix[i][j] == 1 && !(i == 0 && j == 11)) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public MatrixOfIntersection matrixOfIntersection() {
        MatrixOfIntersection matrixOfIntersection = new MatrixOfIntersection();
        int count = kol();
        matrixOfIntersection.kol = count;
        matrixOfIntersection.matrix = new byte[count][count];
        matrixOfIntersection.names = new String[count];
        int p = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 2 + i; j <= 11; j++) {
                if (newMatrix[i][j] == 1 && !(i == 0 && j == 11)) {
                    matrixOfIntersection.names[p] = new String(Integer.toString(i + 1) + "-" + Integer.toString(j + 1));
                    p++;
                }
            }
        }
        for (int i = 0; i < count; i++) {
            matrixOfIntersection.matrix[i][i] = 1;
        }
        for (int i = 1; i < 12; i++) {
            for (int j = 2 + i; j < 12; j++) {
                if (newMatrix[i][j] == 1) {
                    for (int index = 0; index < i; index++) {
                        for (int jndex = i + 1; jndex < j; jndex++) {
                            if (newMatrix[index][jndex] == 1) {
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
}
