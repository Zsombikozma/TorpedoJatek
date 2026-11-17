package Torpedo;

public class Torpedo {
    private char[][] tabla;
    private char[][] tabla2;
    private boolean vege;
    private int hajoMezo;
    private int sor;
    private int oszlop;

    public Torpedo(char[][] eredeti) throws TorpedoException {
        if (eredeti == null || eredeti.length == 0) {
            throw new TorpedoException("A tábla nem lehet üres!");
        }

        this.sor = eredeti.length;
        this.oszlop = eredeti[0].length;
        this.tabla = new char[sor][oszlop];
        this.tabla2 = new char[sor][oszlop];

        for (int i = 0; i < sor; i++) {
            if (eredeti[i] == null || eredeti[i].length != oszlop) {
                throw new TorpedoException("Nem téglalap alakú!");
            }
            for (int j = 0; j < oszlop; j++) {
                if (eredeti[i][j] != 'h' && eredeti[i][j] != 'v') {
                    throw new TorpedoException("Nem megfelelő karakter: " + eredeti[i][j]);
                }
                this.tabla[i][j] = eredeti[i][j];
                this.tabla2[i][j] = 'v';
                if (eredeti[i][j] == 'h') {
                    hajoMezo++;
                }
            }
        }

        this.vege = false;
    }

    public String lo(int x, int y) throws TorpedoException {
        if (vege) {
            throw new TorpedoException("A játék már véget ért");
        }
        if (x < 0 || x >= sor || y < 0 || y >= oszlop) {
            throw new TorpedoException("A koordináták a táblán kívül vannak");
        }

        if (tabla2[x][y] != 'v') {
            return "Erre a mezőre már lőttél. Hátralévő hajómezők: " + hajoMezo;
        }

        if (tabla[x][y] == 'h') {
            tabla2[x][y] = 'h';
            hajoMezo--;
            if (hajoMezo == 0) {
                vege = true;
                return "Nyertél, minden hajó elsüllyedt!";
            }
            return "Talált! Hátralévő hajómezők: " + hajoMezo;
        }

        tabla2[x][y] = 'o';
        return "Mellé! Hátralévő hajómezők: " + hajoMezo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sor; i++) {
            for (int j = 0; j < oszlop; j++) {
                sb.append(tabla2[i][j]).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}