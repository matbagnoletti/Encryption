/**
 * @author (fork) Matteo Bagnoletti Tini
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html">Documentazione Oracle Thread</a>
 */

class Main {
  public static void main(String[] args) {
    Matrice matrice = new Matrice("TPSIT");

    /* creazione dei 4 thread (vermi) utilizzando istanze (vigenere*) della classe (Vigenere), la quale implementa Runnable */
    
    Vigenere vigenere1 = new Vigenere(0, 13, 0, 13, matrice);
    Thread thread1 = new Thread(vigenere1);

    Vigenere vigenere2 = new Vigenere(13, 26, 0, 16, matrice);
    Thread thread2 = new Thread(vigenere2);

    Vigenere vigenere3 = new Vigenere(0, 13, 13, 26, matrice);
    Thread thread3 = new Thread(vigenere3);

    Vigenere vigenere4 = new Vigenere(13, 26, 13, 26, matrice);
    Thread thread4 = new Thread(vigenere4);

    /* ciascun verme inizia il riempimento della propria sezione di matrice */
    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();

    /* al termine del riempimento viene stampata la matrice completa */
    try{
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
    } catch (InterruptedException ex){
      System.err.println("Errore nell'attendere i vermi per il riempimento della tabella! La matrice mostrata potrebbe essere incompleta.");
    } finally {
      matrice.stampa();
    }

    /* inserimento della parola chiave per la cifratura-decifratura */
  }
}
