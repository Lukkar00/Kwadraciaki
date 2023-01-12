package lukkar.kwadraciaki;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.time.LocalTime;
/**
 * Okno glowne gry
 * @author Lukasz Syposz
 */
public class Okno extends JFrame {
    /** Panel w ktorym uzytkownik rysuje obrazek*/
    JPanel rysowanie;
    /** Panel w ktorym wyswietla się wzor obrazka*/
    JPanel wzor;
    /** Panel wyswietlajacy menu*/
    JPanel menu;
    /** Informacja o danym poziomie gry*/
    JLabel infoPoziomu;
    /** Informacja o grze wraz z instrukcja*/
    JTextArea infoGry;
    /** Manager do zarzadzania poziomami*/
     ZarzadzaniePoziomami manager;
    /** Szerokosc jednego kwadratu*/
    int kwadrat;
    /** Maksymalna liczba kwadratow w pionie i poziomie*/
    int lkwadrat;
    /** Szerokosc linii*/
    int linia;
    /** Maksymalna liczba linii w pionie i poziomie*/
    int llinia;
    /** skala obszaru ze wzorem w porownaniu z obszarem do rysowania*/
    double skalawzoru;
    /** Maksymalna szerokosc pola do rysowania*/
    int dlrys;
    /** Rozmiar przerwy miedzy polami w poziomie*/
    double xprzerwa;
    /** Rozmiar przerwy miedzy polami w pionie*/
    double yprzerwa;
    /** Rozmiar przerwy miedzy polem ze wzorem a polem menu*/
    double przerwawzormenu;
    /** Szerokosc pola graficznego gry*/
    int x;
    /** Wysokosc pola graficznego gry*/
    int y;
    /** Czas*/
    LocalTime startTime;

    /**
     *Ustalenie konkretnych wymiarow
     */
    Okno() {
        super("Kwadraciaki");
        x = 1280;
        y = 1024;
        this.manager = new ZarzadzaniePoziomami(this);
        this.setSize(x, y);
        this.setResizable(false);
        this.setLayout(null);
        kwadrat = 60;
        lkwadrat = 12;
        linia = 2;
        llinia = 13;
        skalawzoru = 0.5;
        dlrys = lkwadrat * kwadrat + llinia * linia;
        xprzerwa = (x - dlrys * (1+skalawzoru))/3;
        yprzerwa = (y - lkwadrat * kwadrat - llinia * linia)/2;
        przerwawzormenu = (y-dlrys*skalawzoru-2*yprzerwa)*0.02;
        startTime = LocalTime.now();
        this.rysowanie = new Rysowanie(this);;
        this.wzor = new Wzor(this);
        this.menu = new Menu(this);
        this.rysowanie.setBackground(new Color(128,128,128));
        this.wzor.setBackground(new Color(128,128,128));
        this.rysowanie.setLocation((int)xprzerwa, (int)yprzerwa);
        this.wzor.setLocation((int)(dlrys+2*xprzerwa), (int)yprzerwa);
        this.menu.setLocation((int)(dlrys+2*xprzerwa), (int)(yprzerwa+dlrys*skalawzoru+przerwawzormenu));
        this.rysowanie.setSize(dlrys, dlrys);
        this.wzor.setSize((int)(dlrys*skalawzoru), (int)(dlrys*skalawzoru));
        this.menu.setSize((int)(dlrys*skalawzoru), (int)(dlrys*skalawzoru-przerwawzormenu));
        this.infoPoziomu = new JLabel("Nr poziomu: 1");
        this.infoGry = new JTextArea("Gra zawiera 10 poziomow. Po uruchomieniu gry wlacza sie automatycznie poziom 1 i rozpoczyna sie liczenie czasu. Po przejsciu poziomu automatycznie przechodzi do nastepnego. Gdy ostatni poziom zostanie zakonczony gra zamyka sie i wyswietla sie czas. Celem jest dopasowanie elementow na polu z lewej strony do miniatury z prawej strony.");
        this.infoPoziomu.setLocation(0,0);
        this.infoGry.setLocation(0,30);
        this.menu.setBackground(new Color(140,140,140));
        this.infoGry.setBackground(new Color(135,135,135));
        this.infoPoziomu.setSize((int)(dlrys/2/2),30);
        this.infoGry.setSize((int)(dlrys/2),(int)(dlrys/2-przerwawzormenu-30));
        this.infoGry.setLineWrap(true);
        this.infoGry.setWrapStyleWord(true);
        this.infoGry.setEditable(false);
        this.infoGry.setFocusable(false);
        this.menu.setLayout(null);
        this.menu.add(this.infoPoziomu);
        this.menu.add(this.infoGry);
        this.add(this.rysowanie);
        this.add(this.wzor);
        this.add(this.menu);
        this.setVisible(true);
    }
}