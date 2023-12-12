/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Monica Ciuchetti
 */

public class Matrice {

    char mv[][];
    String verme;

    public Matrice(String verme) {
        this.mv = new char[26][26];
        this.verme = verme;
    }

    public void setElemento(int r, int c, int el) {
        this.mv[r][c] = (char) el;
    }

    public char getElemento(int r, int c) {
        return mv[r][c];
    }

    public void stampa() {
        int r = 0;
        int c = 0;

        for (r = 0; r < 26; r++) {
            for (c = 0; c < 26; c++) {
                System.out.print(this.getElemento(r, c));
            }
            System.out.print("\n");
        }
    }

    public String cifra(String fch) {
        String fcf;
        int k, j, col, row;
        fcf = "";
        k = 0;

        for (j = 0; j < fch.length(); j++) {

            if (k == verme.length()) {
                k = 0;
            }

            if(!Character.isLetter(fch.charAt(j))){
                fcf = fcf + fch.charAt(j);
            } else {
                col = (int) fch.charAt(j) - 65;
                row = (int) verme.charAt(k) - 65;
                fcf = fcf + mv[row][col];
            }
            k++;
        }

        return (fcf);
    }

    public String deCifra(String fcf) {
        String fch = "";

        int k, j, col, row;

        k = 0;

        for (j = 0; j < fcf.length(); j++) {

            if (k == verme.length()) {
                k = 0;
            }

            if(!Character.isLetter(fcf.charAt(j))){
                fch = fch + fcf.charAt(j);
            } else {
                row = (int) verme.charAt(k) - 65;
                for (col = 0; col < 26; col++) {
                    if (mv[row][col] == fcf.charAt(j)) {
                        char car = (char) (col + 65);
                        fch += car;
                    }
                }
            }
            k++;
        }

        return (fch);
    }
}