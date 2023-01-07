package lukkar.kwadraciaki;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;

class Okno extends JFrame {
    JPanel rysowanie;
    JPanel wzor;
    JPanel menu;
    JLabel infoPoziomu;
    JTextArea infoGry;
    ZarzadzaniePoziomami manager;
    int kwadrat;
    int lkwadrat;
    int linia;
    int llinia;
    double skalawzoru;
    int dlrys;
    double xprzerwa;
    double yprzerwa;
    double przerwawzormenu;
    int x;
    int y;
    Okno() {
        super("Kwadraciaki");
        int x = 1280;
        int y = 1024;
        this.manager = new ZarzadzaniePoziomami();
        this.setSize(x, y);
        this.setResizable(false);
        this.setLayout(null);
        kwadrat = 60;
        lkwadrat = 12;
        linia = 2;
        llinia = 13;
        skalawzoru = 0.5;
        dlrys = lkwadrat * kwadrat + llinia * linia;
        yprzerwa = (y - lkwadrat * kwadrat - llinia * linia)/2;
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
        this.menu.setSize((int)(dlrys*skalawzoru-xprzerwa), (int)(dlrys*skalawzoru-przerwawzormenu));
        this.infoPoziomu = new JLabel();
        this.infoGry = new JTextArea();
        this.infoPoziomu.setBackground(new Color(128,128,128));
        this.infoGry.setBackground(new Color(0,0,255));
        this.infoPoziomu.setSize((int)(dlrys/2),30);
        this.infoGry.setSize((int)(dlrys/2),(int)(dlrys/4-przerwawzormenu));
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
/*13 pionowych, 12 kwadratow, przerwa, 13 pionowych/2, 12 kwadratów/2 = 1280
13 poziomych, 12 kwadratow = 1024
kwadrat = 60*12=720
linia -| = 2*13=26
przerwa = ?
- 13*2+12*60+?+(13*2+12*60)/2=1280
- 746+?+373=1280
y = 161
| 746+y=1024
y 278
xmenu=1280-746-161=373
ymenu=1024-y-746/2=373
y/2
rysowanie | wzor
rysowanie | wzor/x+menu
y/2*/