import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] arg) {
        Matrix matrix = new Matrix();


        List<Integer> gamiltonCikl = matrix.findGamiltonCikl();
        for (Integer integer : gamiltonCikl) {
            Integer p = integer + 1;
            System.out.print(prob(p.toString().length(), 3) + p);
        }
        System.out.println();
        for (Integer i = 0; i < 12; i++) {
            Integer p = i + 1;
            System.out.print(prob(p.toString().length(), 3) + p);
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(Matrix.matrix[i][j] + " ");

            }
            System.out.println();
        }

        System.out.println();
        Matrix.changeMatrix();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(Matrix.newMatrix[i][j] + " ");

            }
            System.out.println();
        }
//        Matrix.newMatrix = new byte[][]{
//                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0},
//                {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
//                {0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
//        };

        MatrixOfIntersection matrixOfIntersection = matrix.matrixOfIntersection();
        String[] strings = matrixOfIntersection.names;
        int max = matrix.kol();
        System.out.print("      ");
        for (int i = 0; i < max; i++) {

            System.out.print(prob(strings[i].length()) + strings[i]);

        }
        System.out.println();
        for (int i = 0; i < max; i++) {
            System.out.print(prob(strings[i].length()) + strings[i]);
            for (int j = 0; j < max; j++) {
                System.out.print("     " + matrixOfIntersection.matrix[i][j]);
            }
            System.out.println();
        }

        List<List<String>> psi = Family.find(matrixOfIntersection);
        int indexPsi = 1;
        for (List<String> psiIndex: psi) {
            System.out.print("Psi" + indexPsi +" :");
            indexPsi++;
            for (String rebro : psiIndex) {
                System.out.print(rebro+" ");
            }
            System.out.println();
        }
        int[][] table = Family.genTable(psi);
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(prob(Integer.toString(table[i][j]).length(),3)+table[i][j]);
            }
            System.out.println();
        }
        int[] maxVer = Family.getMax(table);
        System.out.println("max: "+(maxVer[0] + 1) + " " + (maxVer[1] + 1));
        System.out.print("psi"+(maxVer[0]+1)+ " ");
         for (String rebro : psi.get(maxVer[0])) {
                System.out.print(rebro+" ");
         }
        System.out.print("\npsi"+(maxVer[1]+1)+" ");
         for (String rebro : psi.get(maxVer[1])) {
                System.out.print(rebro+" ");
         }
         System.out.println();
         psi= Family.delete(psi,maxVer);
         indexPsi=1;
          for (List<String> psiIndex: psi) {
            System.out.print("Psi" + indexPsi +" :");
            indexPsi++;
            for (String rebro : psiIndex) {
                System.out.print(rebro+" ");
            }
            System.out.println();
        }
        /*
        List<List<String>> test = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        tmp.add("1-3");
        tmp.add("3-7");
        tmp.add("3-6");
        tmp.add("3-5");
        test.add(tmp);
        tmp = new ArrayList<>();
        tmp.add("1-3");
        tmp.add("3-7");
        tmp.add("3-5");
        tmp.add("5-7");
        test.add(tmp);
        tmp = new ArrayList<>();
        tmp.add("1-3");
        tmp.add("3-7");
        tmp.add("4-7");
        tmp.add("5-7");
        test.add(tmp);
        tmp = new ArrayList<>();
        tmp.add("2-6");
        tmp.add("2-4");
        test.add(tmp);
        tmp = new ArrayList<>();
        tmp.add("2-6");
        tmp.add("3-6");
        tmp.add("3-5");
        test.add(tmp);
        tmp = new ArrayList<>();
        tmp.add("2-4");
        tmp.add("4-7");
        tmp.add("5-7");
        test.add(tmp);
        int[][] table = Family.genTable(test);
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        int[] maxVer = Family.getMax(table);
        System.out.println(maxVer[0] + 1 + " " + (maxVer[1] + 1));
        List<String> reb = new ArrayList<>();
        reb.add("2-6");
        reb.add("1-3");
        reb.add("5-7");
        reb.add("2-4");
        reb.add("3-7");
        reb.add("3-6");
        reb.add("3-5");
        reb.add("4-7");
        List<String> rebToChange = Family.delete(test, reb, maxVer);
        for (String rebro : rebToChange) {
            System.out.println(rebro);

        }

       */
    }


    public static String prob(int i) {
        String s = "";
        while (i != 6) {
            s += " ";
            i++;
        }
        return s;
    }

    public static String prob(int i, int probs) {
        String s = "";
        while (i != probs) {
            s += " ";
            i++;
        }
        return s;
    }
}
