import java.io.*;

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

    /* creazione degli oggetti per la lettura da tastiera */
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input);

    /* menù cifratura e decifratura */
    int scelta = 0;
    try{
      System.out.println("*** MENU' ***\n1) Cifrare\n2) Decifrare\n0) Exit\n");
      scelta = Integer.parseInt(reader.readLine());
    } catch (IOException ex){
      System.err.println("Errore nell'inserimento della scelta nel menù!");
    }

    if (scelta == 1){
      File file = null;
      String username = "";

      /* richiedo l'username dell'utente per la creazione di un suo file di cifratura */
      do {

        if(file != null){
          System.out.println("Attenzione! Lo username inserito non è utilizzabile");
        }

        try {
          System.out.println("Inserisci uno username (deve essere univoco - serve alla creazione del file di cifratura)");
          username = reader.readLine();
        } catch (IOException ex) {
          System.err.println("Errore nell'inserimento dello username");
        }

        /* verifico l'esistenza di un file dell'utente */
        file = new File(username + ".txt");

      } while (file.exists() && file.isFile());

      /* creazione del file di cifratura */
      file = new File(username + ".txt");
      FileWriter writer = null;
      try {
        writer = new FileWriter(file);
      } catch (IOException e) {
        System.out.println("Errore nella creazione del file di cifratura!");
      }

      /* inserimento della parola chiave per la cifratura-decifratura */
      try {
        System.out.print("Inserisci la chiave di cifratura: ");
        matrice.verme = reader.readLine();
      } catch (IOException ex){
        System.err.println("Errore nell'inserimento della chiave!");
      }

      /* inserimento del messaggio da cifrare */
      String testoInChiaro = "";
      try {
        System.out.print("Inserisci il testo da cifrare: ");
        testoInChiaro = reader.readLine();
      } catch (IOException ex){
        System.err.println("Errore nell'inserimento del testo!");
      }

      /* cifratura */
      String testoCifrato = matrice.cifra(testoInChiaro);

      /* salvataggio su File */
      if(writer != null){

        try {
          writer.write(testoCifrato);
        } catch (IOException e) {
          System.out.println("Errore nel salvataggio su File!");
        }

        try {
          writer.close();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }

      } else {
        System.err.println("Errore nel salvataggio su file!");
      }

    } else if (scelta == 2){
        //TODO: decifratura
    }
  }
}
