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
public class Spiel implements Runnable {

    Connection[] spieler;
    Spielfeld feld;

    public Spiel(Connection spieler1, Connection spieler2) {
        spieler = new Connection[2];
        this.spieler[0] = spieler1;
        this.spieler[1] = spieler2;
        feld = new Spielfeld();
    }

    @Override
    public void run() {
        // Einlesen der Namen
        spieler[1].send("Gib deinen Namen ein: ");
        spieler[1].send("Request");
        spieler[1].name = spieler[1].read();
        spieler[0].send("Gib deinen Namen ein: ");
        spieler[0].send("Request");
        spieler[0].name = spieler[0].read();
        spieler[1].send("Dein Gegner ist: " + spieler[0].name);
        spieler[1].send("Dein Spielsymbol ist \"O\"");
        spieler[0].send("Dein Gegebr ist: " + spieler[1].name);
        spieler[0].send("Dein Spielsymbol ist \"X\"");

        int anDerReihe = 0;
        int gewonnen=feld.gewonnen();
        while (feld.gewonnen()==-1) {
            String toSend="Du bist dran!\n"+feld.toString()+"Auf welches Feld möchtest du setzen?:";
            spieler[anDerReihe].send(toSend);
            spieler[anDerReihe].send("Request");
            String eingabe=spieler[anDerReihe].read();
            while(!valideEingabe(eingabe)||!feld.isFree(eingabe.toUpperCase().toCharArray())){
                if(!valideEingabe(eingabe)){
                    spieler[anDerReihe].send("Falsche Eingabe!\nAuf welches Feld möchtest du setzen?:");
                    spieler[anDerReihe].send("Request");
                }else{
                    spieler[anDerReihe].send("Feld bereits belegt\nAuf welches Feld möchtest du setzen?:");
                    spieler[anDerReihe].send("Request");
                }
                //spieler[anDerReihe].send("Auf welches Feld möchtest du setzen?:");
                eingabe=spieler[anDerReihe].read();
            }
            feld.setKachel(eingabe.toUpperCase().toCharArray(), anDerReihe+1);
            spieler[anDerReihe].send("Warte auf den Zug des Gegners");
            
            anDerReihe=Math.abs(anDerReihe-1);
            

        }
        spieler[1].send(feld.toString());
        spieler[1].send("Spieler: " + spieler[feld.gewonnen()].name+" hat gewonnen.");
        spieler[1].send("exit");
        spieler[0].send(feld.toString());
        spieler[0].send("Spieler: " + spieler[feld.gewonnen()].name+" hat gewonnen.");
        spieler[0].send("exit");
        
    }
    
    private boolean valideEingabe(String eingabe){
        char[]newEingabe=eingabe.toUpperCase().toCharArray();
        if(newEingabe.length==2){
            if(newEingabe[0]=='A'||newEingabe[0]=='B'||newEingabe[0]=='C'){
                if(newEingabe[1]=='1'||newEingabe[1]=='2'||newEingabe[1]=='3'){
                    return true;
                }
            }
        }
        return false;
    }

}
