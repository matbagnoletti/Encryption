# Encryption

> [!NOTE]
> Versione 1.0
> 
> Autore: [**Matteo Bagnoletti Tini**](https://github.com/matbagnoletti)
> 
> Docente: [**prof.ssa Monica Ciuchetti**](https://github.com/mciuchetti)
> 
> Docente di laboratorio: prof.ssa Ilaria Fioroni.
> 
> Corso: TPSIT 5AINF a.s. 2023/2024
> 
> Istituto: [**ITTS A. Volta**](https://www.avoltapg.edu..it/), Perugia (PG), Italia.

## Descrizione
Questo progetto è un semplice programma di cifratura/decifratura che utilizza l'algoritmo del [**cifrario di Vigenère**](https://it.wikipedia.org/wiki/Cifrario_di_Vigen%C3%A8re).

## Struttura
Il progetto si compone dalle seguenti classi:
- [**Main**](Main.java): classe principale del programma, contiene il metodo main.
- [**Vigenere**](Vigenere.java): classe che contiene i metodi popolare la matrice di Vigenère utilizzata per cifrare e decifrare. implementa [**Runnable**](https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html). viene utilizzata da diversi Thread.
- [**Matrice**](Matrice.java): classe che contiene la matrice di Vigenère. contiene i metodi cifrare e decifrare un messaggio.

## Utilizzo
Per utilizzare il programma è necessario compilare il file [**Main.java**](Main.java) e avviare il programma.

Al primo avvio 4 Thread si occuperanno di popolare la matrice.

Verrà successivamente chiesto di scegliere tramite menù tra (1) *cifrare*, (2) *decifrare* o (0) *terminare il programma*.

Entrambe le opzioni richiederanno di:
1. inserire un id che verrà utilizzato per identificare il *file di output*[^1].
2. inserire una chiave di cifratura, che verrà utilizzata per cifrare o decifrare i messaggi.
3. inserire un messaggio da cifrare o decifrare.

[^1]: Il file di output si presenta come `id` (privo di estensione). Un apposito menù eviterà di inserire un `id` già utilizzato per non sovrascrivere, così, un file già esistente.