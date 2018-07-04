/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threewinsserver;

/**
 *
 * @author francis
 */
public class Spielfeld {

    int[][] feld;

    public Spielfeld() {
        feld = new int[3][];
        for (int i = 0; i < feld.length; i++) {
            feld[i] = new int[3];
        }
    }

    public boolean isFree(char[] eingabe) {
        int a;
        int b;
        if (eingabe[0] == 'A') {
            a = 0;
        } else if (eingabe[0] == 'B') {
            a = 1;
        } else {
            a = 2;
        }
        if (eingabe[1] == '1') {
            b = 0;
        } else if (eingabe[1] == '2') {
            b = 1;
        } else {
            b = 2;
        }

        if (feld[a][b] == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFree(int a, int b) {
        if (feld[a][b] == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void setKachel(char[] eingabe, int symbol) {
        int a;
        int b;
        if (eingabe[0] == 'A') {
            a = 0;
        } else if (eingabe[0] == 'B') {
            a = 1;
        } else {
            a = 2;
        }
        if (eingabe[1] == '1') {
            b = 0;
        } else if (eingabe[1] == '2') {
            b = 1;
        } else {
            b = 2;
        }
        feld[a][b] = symbol;
    }

    public void setKachel(int a, int b, int symbol) {
        feld[a][b] = symbol;
    }

    public int gewonnen() {
        for (int i = 0; i <= 2; i++) {
            if (feld[i][0] == feld[i][1] && feld[i][0] == feld[i][2] && feld[i][2] != 0) {
                return feld[0][i] - 1;
            } else if (feld[0][i] == feld[1][i] && feld[0][i] == feld[2][i] && feld[2][i] != 0) {
                return feld[0][i] - 1;
            }
        }
        if (feld[0][0] == feld[1][1] && feld[0][0] == feld[2][2] && feld[0][0] != 0) {
            return feld[0][0] - 1;
        }
        if (feld[0][2] == feld[1][1] && feld[0][2] == feld[2][0] && feld[0][2] != 0) {
            return feld[1][1] - 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        String result = "    1  |  2 |  3\n";
        for (int i = 0; i < feld.length; i++) {
            if (i == 0) {
                result = result + "A | ";
            }else if (i == 1) {
                result = result + "B | ";
            }else{
                result = result + "C | ";
            }
            for (int j = 0; j < feld[i].length; j++) {
                if (feld[i][j] == 1) {
                    result = result + " X " + " | ";
                } else if (feld[i][j] == 2) {
                    result = result + " O " + " | ";
                } else {
                    result = result + "  " + " | ";
                }
            }
            result = result + "\n";
        }

        return result;
    }

}
