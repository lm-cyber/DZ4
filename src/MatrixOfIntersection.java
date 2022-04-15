public class MatrixOfIntersection {
    public String[] names;
    public byte[][] matrix;
    public int kol=0;
    public int find(String name) {
        for (int index = 0; index<kol;index++)
        {
            if(names[index].equals(name))
                return index;
        }
        return -12;
    }


}
