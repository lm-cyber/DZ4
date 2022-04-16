import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Family {
    public static String[] find(MatrixOfIntersection matrix) {
        LinkedHashSet<String> rebro = new LinkedHashSet<>();
        rebro.add(matrix.names[0]);
        for(int i =1;i< matrix.kol;i++)
        {
            if(matrix.matrix[i][0]==0)
            {
                rebro.add(matrix.names[i]);

            }
        }
        return rebro.toArray(String[]::new);
    }
}
