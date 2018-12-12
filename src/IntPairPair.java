public class IntPairPair{
    private IntPair left;
    private IntPair right;

    public IntPairPair(IntPair a, IntPair b){
        left  = a;
        right = b;
    }

    // TODO: Rest of class
    public IntPair getFirst() { return left; }
    public IntPair getSecond(){ return right; }


    public void setFirst(IntPair a) { left  = a; }
    public void setSecond(IntPair b){ right = b; }

    @Override
    public String toString(){
        return "[ " + left + " " + right + " ]";
    }

    public IntPairPair add(IntPairPair other){
        IntPair left  = this.left.add(other.getFirst());
        IntPair right = this.right.add(other.getSecond());
        return new IntPairPair(left, right);
    }

    // Testing in main
    public static void main(String[] args) {
        IntPair p1 = new IntPair(1,2);
        IntPair p2 = new IntPair(3,4);
        IntPairPair pp1 = new IntPairPair(p1,p2);
        IntPairPair pp2 = new IntPairPair(p2,p1);
        System.out.println("pp1: " + pp1);
        System.out.println("pp2: " + pp2);
    }
}



