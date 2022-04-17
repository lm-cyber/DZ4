import java.util.*;

public class Family {
    public static List<Integer> findOneStart(MatrixOfIntersection matrix) {
        List<Integer> oneStart = new ArrayList<>();
        for (int i = 1; i < matrix.kol; i++) {
            if (matrix.matrix[i][0] == 1) {
                oneStart.add(i);

            }
        }
        return oneStart;
    }

    public static List<Integer> findZeroStart(MatrixOfIntersection matrix) {
        List<Integer> zeroStart = new ArrayList<>();
        for (int i = 1; i < matrix.kol; i++) {
            if (matrix.matrix[i][0] == 0) {
                zeroStart.add(i);

            }
        }
        return zeroStart;
    }

    public static boolean chek(byte[] mat) {
        for (byte i : mat) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }
    public static byte[] dez(byte[] mat,byte[] dezmat) {
        for (int i = 0; i< mat.length; i++) {
            if(dezmat[i]==1) {
                mat[i] = 1;
            }
        }
        return mat;
    }

   /* public static  findS(Integer last,List<List<Integer>> lists,MatrixOfIntersection matrix,byte[] mat,List<Integer> zeroStart) {

        for (Integer number:
             ) {
            
        }
    }
    public static List<List<Integer>> find(MatrixOfIntersection matrix) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> oneStart = findOneStart(matrix);
        List<Integer> zeroStart = findZeroStart(matrix);

        for (int i = 0; i < oneStart.size(); i++) {
            for (int j =0;j<oneStart.size();j++) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(oneStart.get(i));
                tmp.add(zeroStart.get(j));
                byte[] mat = dez(matrix.matrix[oneStart.get(i)].clone(),matrix.matrix[tmp.get(1)]);



                lists.addAll(findS(, , matrix, mat, zeroStart));
            }
        }
        return lists;
    }*/
}
