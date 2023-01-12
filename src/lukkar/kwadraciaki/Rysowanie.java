package lukkar.kwadraciaki;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.lang.String;
/**
 * Klasa rysujaca obrazek przez gracza
 * @author Lukasz Syposz
 */
public class Rysowanie extends JPanel {
    Okno okno;

    /**
     *Przeslanie parametrow z klasy dziedziczacej
     * @param okno
     */
    Rysowanie(Okno okno){
        super();
        this.okno = okno;

        this.addMouseListener(new MouseListener(){
            /**
             * Metoda po kliknieciu (wcisnieciu i zwolnieniu) przycisku myszy na komponencie
             * @param e the event to be processed
             */
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                int valid = 0;
                int dim = okno.manager.poziomRysowany.length;
                for (int i = 0; i<dim; i++) {
                    for (int j = 0; j<dim; j++) {
                        if (x > (okno.linia+j*(okno.linia+okno.kwadrat)) && x < ((j+1)*(okno.linia+okno.kwadrat)) && y > (okno.linia+i*(okno.linia+okno.kwadrat)) && y < ((i+1)*(okno.linia+okno.kwadrat))) {
                            if (okno.manager.poziomRysowany[i][j] == 1) {
                                okno.manager.poziomRysowany[i][j] = 0;
                            } else {
                                okno.manager.poziomRysowany[i][j] = 1;
                            }
                        }
                        if (okno.manager.poziomRysowany[i][j] == okno.manager.poziomDocelowy[i][j]) {
                            valid++;
                        }
                    }
                }
                if (valid == dim*dim) {
                    okno.manager.wybierzPoziom(okno.manager.poziom+1);
                    okno.infoPoziomu.setText("Nr poziomu: "+String.valueOf(okno.manager.poziom));
                }
                okno.repaint();
            }

            /**
             *Metoda gdy mysz opuszcza komponent
             * @param e the event to be processed
             */
            public void mouseExited(MouseEvent e){};

            /**
             *Metoda gdy przycisk myszy został zwolniony na komponencie
             * @param e the event to be processed
             */
            public void mouseReleased(MouseEvent e){};

            /**
             *Metoda po naciśnięciu przycisku myszy na komponencie
             * @param e the event to be processed
             */
            public void mousePressed(MouseEvent e){};

            /**
             *Metoda gdy mysz wchodzi do komponentu
             * @param e the event to be processed
             */
            public void mouseEntered(MouseEvent e){};
            //(int)(this.okno.linia+j*(this.okno.linia+this.okno.kwadrat)), (int)(this.okno.linia+i*(this.okno.linia+this.okno.kwadrat)), this.okno.kwadrat, this.okno.kwadrat);
        });
    }

    /**
     * Metoda odpowiadająca za rysowanie elementów
     * @param g  the <code>Graphics</code> context in which to paint
     */
    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0, 0, this.okno.dlrys, this.okno.dlrys);
        for (int i = 0; i<this.okno.manager.poziomRysowany.length; i++) {
            for (int j = 0; j<this.okno.manager.poziomRysowany.length; j++) {
                if (this.okno.manager.poziomRysowany[i][j] == 1) {
                    g2.setColor(new Color(255,0,0));
                } else {
                    g2.setColor(new Color(0,255,0));
                }
                g2.fillRect((int)(this.okno.linia+j*(this.okno.linia+this.okno.kwadrat)), (int)(this.okno.linia+i*(this.okno.linia+this.okno.kwadrat)), this.okno.kwadrat, this.okno.kwadrat);
            }
        }
    }
}
