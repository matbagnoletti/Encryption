/**
 * @author Monica Ciuchetti
 * @version 1.0
 * @since 1.0
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html">Documentazione Oracle Runnable</a>
 */
public class Vigenere implements Runnable{

    private int ir;
    private int fr;
    private int ic;
    private int fc;
    private Matrice matrix;

    /**
     *
     * @param ir
     * @param fr
     * @param ic
     * @param fc
     * @param matrix
     */
    public Vigenere(int ir, int fr, int ic, int fc, Matrice matrix) {
        this.ir = ir;
        this.fr = fr;
        this.ic = ic;
        this.fc = fc;
        this.matrix = matrix;
    }

    @Override
    public void run() {
        popola();
    }

    private void popola(){
        int c,r,car;
        for(r=ir; r<fr; r++) {
            for(c=ic; c<fc; c++) {
                car = r + c + 65;
                if(car>90) {
                    car = car - 26;
                }
                this.matrix.setElemento(r, c, car);
            }
        }
    }
}