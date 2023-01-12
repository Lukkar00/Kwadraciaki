package lukkar.kwadraciaki;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.Color;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import static java.time.temporal.ChronoUnit.SECONDS;
/**
 * Klasa Menu
 * @author Lukasz Syposz
 */
public class Menu extends JPanel {
    /**
     * Przycisk do zakanczania gry
     */
    JButton button;
    Okno okno;
    /**
     * Obszar w prawym dolnym rogu
     * @param okno Glowne okno
     */
    Menu(Okno okno) {
        super();
        this.okno = okno;
        this.button = new JButton("Zakoncz gre");
        this.button.setLocation(this.okno.dlrys/2/2, 0);
        this.button.setSize(this.okno.dlrys/2/2, 30);
        this.button.setBackground(new Color(128,128,128));
        this.button.addActionListener(new ActionListener() {
            /**
             * Wywolanie akcji ukonczenia poziomu
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                int koniec = (int)SECONDS.between(okno.startTime,LocalTime.now());
                JOptionPane.showMessageDialog(okno, "Ukonczyles poziom: "+String.valueOf(okno.manager.poziom-1)+" z czasem: "+Integer.toString(koniec)+" sekund od wlaczenia gry");
                System.exit(0);
            }
        });
        this.add(button);
    }
}
