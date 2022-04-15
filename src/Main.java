public class Main {
    public static void main(String[] arg) {
        Matrix matrix = new Matrix();
        int[] count = matrix.count();
        MatrixOfIntersection matrixOfIntersection = matrix.matrixOfIntersection();
        String[] strings = matrixOfIntersection.names;
        int max = matrix.kol();
        System.out.print("      ");
        for (int i =0;i<max;i++)
        {

            System.out.print(prob(strings[i].length())+strings[i] );

        }
        System.out.println();
        for (int i=0;i<max; i++) {
            System.out.print(prob(strings[i].length())+strings[i] );
            for (int j=0;j<max;j++)
            {
                System.out.print("     " + matrixOfIntersection.matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static String prob(int i)
    {
        String s="";
        while (i!=6){
            s+=" ";
            i++;
        }
        return s;
    }
}
