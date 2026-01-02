class PR1 {
    public static void main(String[] args) {
        double d = 1.23;
        Decrement dec = new Decrement();    // an instance of inner class dec
        dec.decrement(d);
        System.out.println(d);
    }

    // static inner class
    static class Decrement {
        public void decrement(double d) {
            d = d - 0.1;    // this 'd' is a copy of the method parameter
        }
    }
}

