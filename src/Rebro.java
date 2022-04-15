public class Rebro {
    public int i;
    public int j;

    public String name;
    public Rebro(int i,int j)
    {
        this.i=i;
        this.j=j;
        this.name= new String(Integer.toString(i + 1) + "-" + Integer.toString(j + 1));
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object str) {
        return name.equals(str);
    }

    @Override
    public String toString() {
        return name;
    }
}
