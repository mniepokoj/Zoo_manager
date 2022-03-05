import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Left_pracownicy_panel extends JPanel
{
    Model_object data;

    ///Lista wszystkich pracowników
    JPanel pobierz_pracownicy_panel;
    JLabel pobierz_pracownicy_label;
    JButton pobierz_pracownicy_button1;

    //Lista pracowników odpowiedzialnych za zwierze
    JPanel dodaj_pracownik_panel;
    JLabel dodaj_pracownik_label1;
    JDialog dodaj_pracownika_dialog;
    JLabel dodaj_pracownik_label2;
    JLabel dodaj_pracownik_label3;
    JLabel dodaj_pracownik_label4;
    JLabel dodaj_pracownik_label5;
    JLabel dodaj_pracownik_label6;
    JLabel dodaj_pracownik_label7;
    JLabel dodaj_pracownik_label8;
    JLabel dodaj_pracownik_label9;
    JLabel dodaj_pracownik_label10;
    JTextField dodaj_pracownik_text1;
    JTextField dodaj_pracownik_text2;
    JTextField dodaj_pracownik_text3;
    JTextField dodaj_pracownik_text4;
    JTextField dodaj_pracownik_text5;
    JTextField dodaj_pracownik_text6;
    JTextField dodaj_pracownik_text7;
    JTextField dodaj_pracownik_text8;
    JTextField dodaj_pracownik_text9;
    JButton dodaj_pracownik_button;
    JButton dodaj_pracownik_button2;

    public JPanel dodaj_ankiete_panel1;
    JDialog dodaj_ankiete_dialog;
    JLabel dodaj_ankiete_label1;
    JLabel dodaj_ankiete_label2;
    JTextField dodaj_ankiete_text2;
    JButton dodaj_ankiete_button;
    JButton dodaj_ankiete_button1;
    JLabel dodaj_ankiete_label;


    public JPanel  dodaj_opiekuna_panel1;
    JDialog dodaj_opiekuna_dialog;
    JComboBox dodaj_opiekuna_comboBox5;
    JLabel dodaj_opiekuna_label1;
    JLabel dodaj_opiekuna_label2;
    JLabel dodaj_opiekuna_label3;
    JLabel dodaj_opiekuna_label4;
    JLabel dodaj_opiekuna_label5;
    JTextField dodaj_opiekuna_text2;
    JTextField dodaj_opiekuna_text3;
    JTextField dodaj_opiekuna_text4;
    JButton dodaj_opiekuna_button;
    JButton dodaj_opiekuna_button1;
    JLabel dodaj_opiekuna_label;


    JPanel powrot_panel;
    JButton powrot_button;

    String[] get_pokarm_list()
    {
        String[] s = data.getData_base().getPasza();
        return s;
    }

    String[] get_Kierownik_Nazwisko()
    {
        return data.getData_base().getNazwiskoKierwonik();
    }


    private void wyszukaj_pracownicy()
    {
        ArrayList<String> columns = new ArrayList<String>();
        ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
        data.getData_base().getPracownicy( columns, rows);
        data.getCenterPane().setTableData(columns, rows);
    }

    private void dodaj_pracownika(String imie, String nazwisko, String stanowisko, String id_kierownik,
                                  String numer_telefonu, String data_zatrudnienia, String login, String haslo)
    {
        switch(stanowisko)
        {
            case "opiekun":
                data.getData_base().insert_opiekun("DEFAULT", imie, nazwisko, numer_telefonu, data_zatrudnienia, id_kierownik, login, haslo);
                break;
            case "magazynier":
                data.getData_base().insert_kasjer("DEFAULT", imie, nazwisko, numer_telefonu, data_zatrudnienia, id_kierownik, login, haslo);
                break;
            case "kasjer":
                data.getData_base().insert_magazynier("DEFAULT", imie, nazwisko, numer_telefonu, data_zatrudnienia, id_kierownik, login, haslo);
                break;
            case "kierownik":
                data.getData_base().insert_kierownik("DEFAULT", imie, nazwisko, numer_telefonu, data_zatrudnienia, login, haslo);
                break;
        }
    }

    private void wyszukaj_kierownik(String nazwisko)
    {
        ArrayList<String> columns = new ArrayList<String>();
        ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
        data.getData_base().getPracownicyKierownik(nazwisko, columns, rows);
        data.getCenterPane().setTableData(columns, rows);
    }

    private void wyszukaj_magazynier(String pokarm)
    {
        ArrayList<String> columns = new ArrayList<String>();
        ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
        data.getData_base().getMagazynier(pokarm, columns, rows);
        data.getCenterPane().setTableData(columns, rows);
    }

    private void powrot_fun()
    {
        data.set_current_page("main");
    }

    private void create_pracownicy()
    {
        pobierz_pracownicy_panel = new JPanel();
        pobierz_pracownicy_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        pobierz_pracownicy_label = new JLabel("Lista wszystkich pracowników", SwingConstants.CENTER);
        pobierz_pracownicy_label.setPreferredSize(View.labelTitleSize);
        pobierz_pracownicy_button1 = new JButton("Wypisz");
        pobierz_pracownicy_button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                wyszukaj_pracownicy();
            }
        });
        pobierz_pracownicy_panel.add(pobierz_pracownicy_label);
        pobierz_pracownicy_panel.add(pobierz_pracownicy_button1);
    }

    private void create_dodaj_pracownik()
    {
        dodaj_pracownik_panel = new JPanel();
        dodaj_pracownik_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        dodaj_pracownik_label1 = new JLabel("Dodaj pracownika", SwingConstants.CENTER);
        dodaj_pracownik_label1.setPreferredSize(View.labelTitleSize);


        dodaj_pracownik_button2 = new JButton("Dodaj");
        dodaj_pracownik_button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                dodaj_pracownika_dialog = new JDialog(data.getMain_frame(), "Dodaj pracownika");
                dodaj_pracownik_label2 = new JLabel("Imie:");
                dodaj_pracownik_label2.setPreferredSize(View.labelFieldSize);
                dodaj_pracownik_text1 = new JTextField();
                dodaj_pracownik_text1.setPreferredSize(View.textFieldSize);

                dodaj_pracownik_label3 = new JLabel("Nazwisko:");
                dodaj_pracownik_label3.setPreferredSize(View.labelFieldSize);
                dodaj_pracownik_text2 = new JTextField();
                dodaj_pracownik_text2.setPreferredSize(View.textFieldSize);

                dodaj_pracownik_label5 = new JLabel("Stanowisko:");
                dodaj_pracownik_label5.setPreferredSize(View.labelFieldSize);
                dodaj_pracownik_text4 = new JTextField();
                dodaj_pracownik_text4.setPreferredSize(View.textFieldSize);

                dodaj_pracownik_label6 = new JLabel("Id przełożonego:");
                dodaj_pracownik_label6.setPreferredSize(View.labelFieldSize);
                dodaj_pracownik_text5 = new JTextField();
                dodaj_pracownik_text5.setPreferredSize(View.textFieldSize);

                dodaj_pracownik_label7 = new JLabel("Numer telefonu:");
                dodaj_pracownik_label7.setPreferredSize(View.labelFieldSize);
                dodaj_pracownik_text6 = new JTextField();
                dodaj_pracownik_text6.setPreferredSize(View.textFieldSize);

                dodaj_pracownik_label8 = new JLabel("Data zatrudnienia:");
                dodaj_pracownik_label8.setPreferredSize(View.labelFieldSize);
                dodaj_pracownik_text7 = new JTextField();
                dodaj_pracownik_text7.setPreferredSize(View.textFieldSize);

                dodaj_pracownik_label9 = new JLabel("Login:");
                dodaj_pracownik_label9.setPreferredSize(View.labelFieldSize);
                dodaj_pracownik_text8 = new JTextField();
                dodaj_pracownik_text8.setPreferredSize(View.textFieldSize);

                dodaj_pracownik_label10 = new JLabel("Haslo:");
                dodaj_pracownik_label10.setPreferredSize(View.labelFieldSize);
                dodaj_pracownik_text9 = new JTextField();
                dodaj_pracownik_text9.setPreferredSize(View.textFieldSize);

                dodaj_pracownik_button = new JButton("Dodaj");
                dodaj_pracownik_button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        dodaj_pracownika(dodaj_pracownik_text1.getText(), dodaj_pracownik_text2.getText(), dodaj_pracownik_text4.getText(),
                                dodaj_pracownik_text5.getText(), dodaj_pracownik_text6.getText(), dodaj_pracownik_text7.getText(),
                                dodaj_pracownik_text8.getText(), dodaj_pracownik_text9.getText());
                    }
                });

                dodaj_pracownika_dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
                dodaj_pracownika_dialog.add(dodaj_pracownik_label2);
                dodaj_pracownika_dialog.add(dodaj_pracownik_text1);
                dodaj_pracownika_dialog.add(dodaj_pracownik_label3);
                dodaj_pracownika_dialog.add(dodaj_pracownik_text2);
                dodaj_pracownika_dialog.add(dodaj_pracownik_label5);
                dodaj_pracownika_dialog.add(dodaj_pracownik_text4);
                dodaj_pracownika_dialog.add(dodaj_pracownik_label6);
                dodaj_pracownika_dialog.add(dodaj_pracownik_text5);
                dodaj_pracownika_dialog.add(dodaj_pracownik_label7);
                dodaj_pracownika_dialog.add(dodaj_pracownik_text6);
                dodaj_pracownika_dialog.add(dodaj_pracownik_label8);
                dodaj_pracownika_dialog.add(dodaj_pracownik_text7);
                dodaj_pracownika_dialog.add(dodaj_pracownik_label9);
                dodaj_pracownika_dialog.add(dodaj_pracownik_text8);
                dodaj_pracownika_dialog.add(dodaj_pracownik_label10);
                dodaj_pracownika_dialog.add(dodaj_pracownik_text9);
                dodaj_pracownika_dialog.add(dodaj_pracownik_button);

                dodaj_pracownika_dialog.setSize(new Dimension(View.leftPanelSize.width+40, 280));
                dodaj_pracownika_dialog.setVisible(true);
            }
        });

        dodaj_pracownik_panel.add(dodaj_pracownik_label1);
        dodaj_pracownik_panel.add(dodaj_pracownik_button2);
    }


    private void create_dodaj_ankiete()
    {
        dodaj_ankiete_label = new JLabel("Zarejestruj ankiete:", SwingConstants.CENTER);
        dodaj_ankiete_label.setPreferredSize(View.labelTitleSize);
        dodaj_ankiete_button1 = new JButton("Dodaj");
        dodaj_ankiete_button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                dodaj_ankiete_dialog = new JDialog(data.getMain_frame(), "Rejestracja ankiety");

                dodaj_ankiete_label1 = new JLabel("Rejestracja ankiety");
                dodaj_ankiete_label1.setPreferredSize(View.labelTitleSize);

                dodaj_ankiete_label2 = new JLabel("Id zwierzęcia:");
                dodaj_ankiete_label2.setPreferredSize(View.labelFieldSize);
                dodaj_ankiete_text2 = new JTextField();
                dodaj_ankiete_text2.setPreferredSize(new Dimension(View.textFieldSize.width + 20, View.textFieldSize.height));


                dodaj_ankiete_button = new JButton("Dodaj");
                dodaj_ankiete_button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        data.getData_base().insert_ankieta("DEFAULT" ,dodaj_ankiete_text2.getText());
                    }
                });

                dodaj_ankiete_dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
                dodaj_ankiete_dialog.add(dodaj_ankiete_label2);
                dodaj_ankiete_dialog.add(dodaj_ankiete_text2);
                dodaj_ankiete_dialog.add(dodaj_ankiete_button);

                dodaj_ankiete_dialog.setSize(new Dimension(View.leftPanelSize.width+80, 100));
                dodaj_ankiete_dialog.setVisible(true);
            }
        });

        dodaj_ankiete_panel1 = new JPanel();
        dodaj_ankiete_panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        dodaj_ankiete_panel1.add(dodaj_ankiete_label);
        dodaj_ankiete_panel1.add(dodaj_ankiete_button1);
    }

    private void create_dodaj_opiekuna()
    {
        dodaj_opiekuna_label = new JLabel("Przydziel opiekuna", SwingConstants.CENTER);
        dodaj_opiekuna_label.setPreferredSize(View.labelTitleSize);
        dodaj_opiekuna_button1 = new JButton("Dodaj");
        dodaj_opiekuna_button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                dodaj_opiekuna_dialog = new JDialog(data.getMain_frame(), "Przydziel opiekuna");

                dodaj_opiekuna_label1 = new JLabel("Przydziel opiekuna");
                dodaj_opiekuna_label1.setPreferredSize(View.labelTitleSize);

                dodaj_opiekuna_label2 = new JLabel("Id opiekuna:");
                dodaj_opiekuna_label2.setPreferredSize(View.labelFieldSize);
                dodaj_opiekuna_text2 = new JTextField();
                dodaj_opiekuna_text2.setPreferredSize(new Dimension(View.textFieldSize.width + 20, View.textFieldSize.height));

                dodaj_opiekuna_label3 = new JLabel("Id zwierzęcia:");
                dodaj_opiekuna_label3.setPreferredSize(View.labelFieldSize);
                dodaj_opiekuna_text3 = new JTextField();
                dodaj_opiekuna_text3.setPreferredSize(new Dimension(View.textFieldSize.width + 20, View.textFieldSize.height));


                dodaj_opiekuna_button = new JButton("Dodaj");
                dodaj_opiekuna_button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        data.getData_base().insert_opiekun_zwierze( dodaj_opiekuna_text3.getText(),dodaj_opiekuna_text2.getText());
                    }
                });

                dodaj_opiekuna_dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
                dodaj_opiekuna_dialog.add(dodaj_opiekuna_label2);
                dodaj_opiekuna_dialog.add(dodaj_opiekuna_text2);
                dodaj_opiekuna_dialog.add(dodaj_opiekuna_label3);
                dodaj_opiekuna_dialog.add(dodaj_opiekuna_text3);
                dodaj_opiekuna_dialog.add(dodaj_opiekuna_button);

                dodaj_opiekuna_dialog.setSize(new Dimension(View.leftPanelSize.width+80, 130));
                dodaj_opiekuna_dialog.setVisible(true);
            }
        });

        dodaj_opiekuna_panel1 = new JPanel();
        dodaj_opiekuna_panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        dodaj_opiekuna_panel1.add(dodaj_opiekuna_label);
        dodaj_opiekuna_panel1.add(dodaj_opiekuna_button1);
    }

    private void create_powrot()
    {
        powrot_panel = new JPanel();
        powrot_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        powrot_button = new JButton("Powrót");
        powrot_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                powrot_fun();
            }
        });

        powrot_panel.add(powrot_button);
    }




    public Left_pracownicy_panel(Model_object DATA)
    {
        data = DATA;
        create_pracownicy();
        create_dodaj_pracownik();
        create_dodaj_ankiete();
        create_dodaj_opiekuna();
        create_powrot();


        this.setLayout( new BoxLayout(this, BoxLayout.Y_AXIS) );
        this.add(pobierz_pracownicy_panel);
        this.add(dodaj_pracownik_panel);
        this.add(dodaj_opiekuna_panel1);
        this.add(dodaj_ankiete_panel1);
        this.add(powrot_panel);

        this.setPreferredSize(View.leftPanelSize);
    }
}
