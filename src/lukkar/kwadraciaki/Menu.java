package lukkar.kwadraciaki;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
class Menu extends JPanel {
    JButton button;
    Okno okno;
    Menu(Okno okno) {
        super();
        this.okno = okno;
        this.button = new JButton("Zakończ grę");
        this.button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.button.setVisible(true);
        this.add(button);
    }
}
