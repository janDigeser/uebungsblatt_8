import java.lang.StringBuilder;

public class CA{
    private boolean[][] cArray;

    public CA(int d, int n){
        cArray = createArray(d, n);
    }

    // b)
    public static boolean[][] createArray(int d, int n){
        return new boolean[d][n];
    }

    // c)
    public void fillRow(int row, double p){
        if (cArray.length < 1) return;
        for (int i = 0; i < cArray[0].length; i++)
            cArray[row][i] = (Math.random() < p);
    }

    // d)
    public void fillArray(double p){
        for (int i = 0; i < cArray.length; i++)
            for (int j = 0; j < cArray[i].length; j++)
                cArray[i][j] = (Math.random() < p);
    }

    // e)
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cArray.length; i++){
            for (int j = 0; j < cArray[i].length; j++)
                sb.append(String.format("%-5b ", cArray[i][j]));
            sb.append("\n");
        }
        return sb.toString();
    }

    public void pprint(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cArray.length; i++){
            for (int j = 0; j < cArray[i].length; j++)
                sb.append(cArray[i][j] ? "\u25AE" : "\u25AF");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    // f)
    public void propagate(int row){
        if (row <= 0){
            System.err.println("Can't apply propagate to first row.");
            return;
        }
        if (row >= cArray.length){
            System.err.println("Row does not exist");
            return;
        }
        int clen = cArray[row].length;
        for (int col = 0; col < clen; col++){
            boolean a = cArray[row - 1][(clen + col - 1) % clen];
            boolean b = cArray[row - 1][col];
            boolean c = cArray[row - 1][(col + 1) % clen];
            cArray[row][col] = f(a,b,c);
        }
    }

    private boolean f(boolean a, boolean b, boolean c){
        return (a ^ c) ^ b;
    }

    // h)
    public void iterate(double p){
        // assert (0 <= p && p <= 1);
        fillRow(0, p);
        for(int row = 1; row < cArray.length; row++)
            propagate(row);
    }

    // testing our code
    public static void main(String[] args) {
        System.out.println("Random Fill");
        CA ca = new CA(20,40);
        ca.fillArray(0.4);
        // System.out.println(ca);
        ca.pprint();
        System.out.println("\n\n Iteration");
        ca.fillArray(0);
        ca.iterate(0.05);
        //System.out.println(ca);
        ca.pprint();
    }
}