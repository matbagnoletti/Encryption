<h1 align="center">Encryption</h1>

<p align="center" style="font-family: monospace">Made by <a href="https://github.com/matbagnoletti">@matbagnoletti</a></p>
<p align="center" style="font-family: monospace">Docenti: prof.ssa <a href="https://github.com/mciuchetti">@mciuchetti</a> e prof.ssa Fioroni</p>
<p align="center" style="font-family: monospace">Corso TPSIT a.s. 2023/2024, <a href="https://www.avoltapg.edu.it/">ITTS A. Volta (PG)</a></p>
<p align="center">
    <img src="https://img.shields.io/github/last-commit/matbagnoletti/JavaFileManager?style=for-the-badge" alt="Ultimo commit">
    <img src="https://img.shields.io/github/languages/top/matbagnoletti/JavaFileManager?style=for-the-badge" alt="Linguaggio">
</p>

## Descrizione
Questo progetto è un semplice programma di cifratura/decifratura che utilizza l'algoritmo del [**cifrario di Vigenère**](https://it.wikipedia.org/wiki/Cifrario_di_Vigen%C3%A8re).

## Struttura
Il progetto si compone dalle seguenti classi:
- [**Main**](Main.java): classe principale del programma, che contiene il metodo main.
- [**Vigenere**](Vigenere.java): classe che contiene i metodi popolare la matrice di Vigenère utilizzata per cifrare e decifrare. Implementa l'interfaccia [**Runnable**](https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html).
- [**Matrice**](Matrice.java): classe che contiene la matrice di Vigenère. Contiene i metodi per cifrare e decifrare un messaggio.

## Utilizzo
Per utilizzare il programma è necessario compilare il file [**Main.java**](Main.java) e avviare il programma.

Al primo avvio 4 Thread si occuperanno di popolare la matrice e la stamperanno a video.

Verrà successivamente chiesto di scegliere tramite menù tra (1) *cifrare*, (2) *decifrare* o (0) *terminare il programma*.

Entrambe le opzioni (1 e 2) richiederanno di:

1. Inserire uno username `<id>` che verrà utilizzato per identificare il *file di output*.

2. Inserire una chiave `<verme>` di cifratura, che verrà utilizzata per cifrare o decifrare i messaggi.

3. Inserire un messaggio da cifrare `<testoInChiaro>` o decifrare `<testoCifrato>`.

> [!NOTE]
> Il file di output si presenta come `<id>` (privo di estensione). Un apposito menù eviterà di inserire un `<id>` già utilizzato per non sovrascrivere, così, un file già esistente.

## Aggiornamenti (v.1.1)

- [x] Aggiunta di un loop nel menù per scegliere l'opzione da utilizzare.
- [x] Gestione di eventuali eccezioni generate durante l'inserimento di caratteri non supportati.

## Licenza d'uso
La seguente repository (e tutte le sue versioni) sono rilasciate sotto la [**MB General Copyleft License**](LICENSE).