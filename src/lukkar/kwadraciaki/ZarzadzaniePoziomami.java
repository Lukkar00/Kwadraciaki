package lukkar.kwadraciaki;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import static java.time.temporal.ChronoUnit.SECONDS;
/**
 * Klasa sluzaca do zarzadzania poziomami
 * @author Lukasz Syposz
 */
class ZarzadzaniePoziomami {
    /** Numer poziomu*/
    int poziom;
    /** Poziom docelowy*/
    int poziomDocelowy[][];
    /** Poziom rysowany*/
    int poziomRysowany[][];
    Okno okno;

    /**
     * Wybranie poziomu 1
     * @param okno
     */
    ZarzadzaniePoziomami(Okno okno) {
        this.okno = okno;
        this.wybierzPoziom(1);
    }

    /**
     * Metoda wybierajaca poziom
     * @param poziom
     */
    void wybierzPoziom(int poziom) {
        Poziomy poziomy = new Poziomy();
        this.poziom = poziom;
        this.poziomDocelowy = poziomy.wybierzPoziom(poziom);
        if (this.poziomDocelowy == null) {
            int koniec = (int)SECONDS.between(okno.startTime,LocalTime.now());
            JOptionPane.showMessageDialog(this.okno, "Ukonczyles poziom: "+String.valueOf(this.okno.manager.poziom-1)+" z czasem: "+Integer.toString(koniec)+" sekund od wlaczenia gry");
            System.exit(0);
        }
        this.poziomRysowany = this.poziomDocelowy.clone();
        int temp[];
        for (int i = 0; i<poziom+2; i++) {
            temp = this.poziomRysowany[i].clone();
            for (int j = 0; j<poziom+2; j++) {
                temp[j] = 0;
            }
            this.poziomRysowany[i] = temp;
        }
    }

}
