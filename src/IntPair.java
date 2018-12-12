public class IntPair{
    private int left;
    private int right;

    public IntPair(int a, int b){
        left  = a;
        right = b;
    }

    public int getFirst() { return left; }
    public int getSecond(){ return right; }


    public void setFirst(int a) { left  = a; }
    public void setSecond(int b){ right = b; }

    @Override
    public String toString(){
        return "( " + left + " " + right + " )";
    }

    public IntPair add(IntPair other){
        return new IntPair(left + other.getFirst(), right + other.getSecond());
    }


    // TODO: swap()
    /*
    public void swap(){
        int tmp = left;
        left = right;
        right = tmp;
    }
    */

    public IntPair swap(){
        return new IntPair(right, left);
    }

    // Testing in main
    public static void main(String[] args) {
        IntPair p1 = new IntPair(1,2);
        IntPair p2 = p1.swap();
        System.out.println("Original p1   = " + p1);
        System.out.println("Vertauscht p2 = " + p2);
    }
}


