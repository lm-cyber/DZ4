import java.util.*;

public class Family {


    public static Integer alfa=0;
    public static List<SortedSet<Integer>> psi = new ArrayList<>();
    public static byte[] byteOr(byte[] first,byte[] second) {
        byte[] result = new byte[first.length];
        for (int i = 0;i<first.length;i++) {
            result[i]= (byte) (first[i] | second[i]);
        }
        return result;
    }
    private static boolean chek(byte[] mat) {
        for(int i =0 ;i <mat.length;i++) {
            if(mat[i] ==0)
            {
                return false;
            }
        }
        return true;
    }
    public static void findSet(SortedSet<Integer> set,byte[] matrix,Integer last,byte[][] matrixOfMatrix) {
        if(chek(matrix)) {
            alfa++;
            psi.add(set);
        }

        for (int j = last+1;j<matrix.length;j++) {
            if(matrix[j] == 0) {
                set.add(j);
                findSet(set,byteOr(matrix,matrixOfMatrix[j]),j,matrixOfMatrix);
            }
        }
    }
    public static List<List<String>> find(MatrixOfIntersection matrix) {
        for(int i =0;i<matrix.matrix.length;i++) {
            SortedSet<Integer> startSet = new TreeSet<>();
            startSet.add(i);

            findSet(startSet,matrix.matrix[i],i, matrix.matrix);

        }
        List<List<String>> fam = new ArrayList<>();

        for(int i = 0; i< psi.size() ; i++) {
            List<String> tmp = new ArrayList<>();
            for (Integer nameNumber : psi.get(i)) {
                tmp.add(matrix.names[nameNumber]);
            }
            fam.add(tmp);
        }

        return fam;
    }
    public static int set(List<List<String>> fam, int index, int jndex) {
        int count = 0;
        int iLen = fam.get(index).size();
        int jLen = fam.get(jndex).size();
        for (int i = 0; i < iLen; i++) {
            for (int j = 0; j < jLen; j++) {
                if (fam.get(index).get(i).equals(fam.get(jndex).get(j))) {
                    count++;
                }
            }
        }
        return count;
    }


    public static int[][] genTable(List<List<String>> fam) {
        int count = fam.size();
        int[][] table = new int[count][count];
        for (int i = 0; i < count; i++) {
            for (int j = i; j < count; j++) {
                if (j == i) {
                    table[i][j] = 0;
                } else {
                    table[i][j] = fam.get(i).size() + fam.get(j).size() - set(fam, i, j);
                }


            }
        }


        return table;
    }

    public static int[] getMax(int[][] table) {
        int count = table.length;
        int max = 0;
        int[] maxVer = new int[2];
        for (int i = 0; i < count; i++) {
            for (int j = i; j < count; j++) {
                if(table[i][j]>max) {
                    max= table[i][j];
                    maxVer[0] = i;
                    maxVer[1] = j;
                }

            }
        }

        return maxVer;

    }
    public static List<List<String>> delete(List<List<String>> fam ,int[] maxVer) {
        List<String> copy1 =new ArrayList<>(fam.get(maxVer[0]));
        List<String> copy2 =new ArrayList<>(fam.get(maxVer[1]));
        for (List<String> psiI : fam) {
            psiI.removeAll(copy1);
            psiI.removeAll(copy2);
        }

        return fam;
    }
}
