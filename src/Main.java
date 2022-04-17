import java.util.List;

public class Main {
    public static void main(String[] arg) {
        Matrix matrix = new Matrix();


        List<Integer> test = matrix.findGamiltonCikl();
        for (Integer integer :  test) {
            Integer p = integer+1 ;
            System.out.print(prob(p.toString().length(),3)+p );
        }
        System.out.println();
        for(Integer i = 0 ; i< 12 ;i++){
            Integer p = i+1 ;
            System.out.print( prob(p.toString().length(),3)+p);
        }
        System.out.println();
        System.out.println();
         for(int i = 0;i<12;i++) {
            for (int j =0 ;j<12;j++) {
                System.out.print(Matrix.matrix[i][j]+" ");

            }
            System.out.println();
        }

        System.out.println();
        Matrix.changeMatrix();
         for(int i = 0;i<12;i++) {
            for (int j =0 ;j<12;j++) {
                System.out.print(Matrix.newMatrix[i][j]+" ");

            }
            System.out.println();
        }
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
    public static String prob(int i,int probs)
    {
        String s="";
        while (i!=probs){
            s+=" ";
            i++;
        }
        return s;
    }
    public static void test(Integer i ) {
        i++;
    }
}
