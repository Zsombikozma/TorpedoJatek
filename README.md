# Torpedó

Egyszerűsített torpedó (hajócsata) játék Java nyelven, konzolos kezeléssel.

## Leírás

A játék egy kétdimenziós `char` tömbből indul, amiben `'h'` jelöli a hajó egy mezőjét,
`'v'` a vizet. A konstruktor ellenőrzi a táblát, és megszámolja a hajómezőket.
A játékos a `lo(x, y)` metódussal lő egy mezőre. A játékos által látott tábla
kezdetben csupa `'v'`, a találatot `'h'`, a mellélövést `'o'` jelzi.
A játék akkor ér véget, amikor minden hajómező el van találva.

## Funkciók

- tábla ellenőrzése (csak `'h'` és `'v'` engedélyezett, téglalap alakú)
- `TorpedoException` saját kivétel hibás táblára és hibás lövésre
- a hajók rejtve maradnak, a játékos csak a lövéseinek eredményét látja
- ugyanarra a mezőre lőve nem számol duplán
- nyerés felismerése, ha minden hajómező el van találva
- lövés Scannerrel a konzolról, hibás bemenetnél a program nem áll le

## Fájlok

| Fájl | Szerepe |
|---|---|
| `Torpedo.java` | a játék logikája |
| `TorpedoException.java` | saját kivétel |
| `TorpedoMain.java` | futtatható példa, beolvasás Scannerrel |

## Futtatás

```
javac *.java
java TorpedoMain
```

A lövést `sor oszlop` formában kell megadni, például `1 2`.
A számozás 0-tól indul.

## Jelölések

| Jel | Jelentése |
|---|---|
| `v` | ide még nem lőttél |
| `h` | találat |
| `o` | mellé |

## Példa

```
v v v v v v 
v v v v v v 
v v v v v v 
v v v v v v 
v v v v v v 
v v v v v v 

Sor és oszlop (pl. 1 2): 0 0
Talált! Hátralévő hajómezők: 7

h v v v v v 
v v v v v v 
v v v v v v 
v v v v v v 
v v v v v v 
v v v v v v 

Sor és oszlop (pl. 1 2): 5 5
Mellé! Hátralévő hajómezők: 7
```

## Használt technológiák

Java (OOP, kivételkezelés, kétdimenziós tömbök)