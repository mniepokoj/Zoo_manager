import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Left_main_panel extends JPanel
{
    public JButton odczytaj_tabele_button, dodaj_tabele_button, zwierzeta_button, pracownicy_button, exit_button;

    Model_object data;

    public Left_main_panel(Model_object DATA)
    {
        data = DATA;
        this.setLayout( new GridLayout(5, 1, 0, 60));
        odczytaj_tabele_button = new JButton("Odczytaj tabele");
        dodaj_tabele_button = new JButton("Dodaj do tabeli");
        zwierzeta_button = new JButton("Zwierzęta");
        pracownicy_button = new JButton("Pracownicy");
        exit_button = new JButton("Wyjdź");

        odczytaj_tabele_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                data.set_current_page("odczytaj_tabele");
            }
        });

        dodaj_tabele_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                data.set_current_page("dodaj_tabele");
            }
        });

        zwierzeta_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                data.set_current_page("zwierzeta");
            }
        });
        pracownicy_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                data.set_current_page("pracownicy");
            }
        });

        exit_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                data.getMain_frame().dispose();
                System.exit(0);
            }
        });

        this.add(odczytaj_tabele_button);
        this.add(dodaj_tabele_button);
        this.add(zwierzeta_button);
        this.add(pracownicy_button);
        this.add(exit_button);
        this.setPreferredSize(new Dimension(140, 600));
    }

}
