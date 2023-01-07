package lukkar.kwadraciaki;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
class Wzor extends JPanel {
    Okno okno;
    Wzor(Okno okno){
        super();
        this.okno = okno;
    }
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(0,0,0));
        g2.fillRect(0, 0, (int)(this.okno.dlrys*this.okno.skalawzoru), (int)(this.okno.dlrys*this.okno.skalawzoru));
        for (int i = 0; i<this.okno.manager.poziomDocelowy.length; i++) {
            for (int j = 0; j<this.okno.manager.poziomDocelowy.length; j++) {
                if (this.okno.manager.poziomDocelowy[i][j] == 1) {   
                    g2.setColor(new Color(255,0,0));
                } else {
                    g2.setColor(new Color(0,255,0));
                }
                g2.fillRect((int)((this.okno.linia+j*(this.okno.linia+this.okno.kwadrat))*this.okno.skalawzoru), (int)((this.okno.linia+i*(this.okno.linia+this.okno.kwadrat))*this.okno.skalawzoru), (int)(this.okno.kwadrat*this.okno.skalawzoru), (int)(this.okno.kwadrat*this.okno.skalawzoru));
            }
        }
    }
}
