import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Left_dodaj_tablice_panel extends JPanel
{
    Model_object data;

    JButton opiekun_button;
    JButton zwierze_button;
    JButton opiekun_zwierze_button;
    JButton gatunek_button;
    JButton pasza_button;
    JButton magazynier_button;
    JButton kierownik_button;
    JButton ankieta_button;
    JButton kasjer_button;
    JButton powrot_button;

    JDialog dodaj_dialog;
    JLabel dodaj_label1;
    JLabel dodaj_label2;
    JLabel dodaj_label3;
    JLabel dodaj_label4;
    JLabel dodaj_label5;
    JLabel dodaj_label6;
    JLabel dodaj_label7;
    JLabel dodaj_label8;
    JLabel dodaj_label9;
    JTextField dodaj_text2;
    JTextField dodaj_text3;
    JTextField dodaj_text4;
    JTextField dodaj_text5;
    JTextField dodaj_text6;
    JTextField dodaj_text7;
    JTextField dodaj_text8;
    JTextField dodaj_text9;
    JButton dodaj_button;

    private void insert_opiekun()
    {
        dodaj_dialog = new JDialog(data.getMain_frame(), "Dodaj opiekuna");

        dodaj_label1 = new JLabel("Dodaj opiekuna");
        dodaj_label1.setPreferredSize(View.labelTitleSize);

        dodaj_label2 = new JLabel("Id_opiekun:");
        dodaj_label2.setPreferredSize(View.labelFieldSize);
        dodaj_text2 = new JTextField();
        dodaj_text2.setPreferredSize(View.textFieldSize);

        dodaj_label3 = new JLabel("Imie:");
        dodaj_label3.setPreferredSize(View.labelFieldSize);
        dodaj_text3 = new JTextField();
        dodaj_text3.setPreferredSize(View.textFieldSize);

        dodaj_label4 = new JLabel("Nazwisko:");
        dodaj_label4.setPreferredSize(View.labelFieldSize);
        dodaj_text4 = new JTextField();
        dodaj_text4.setPreferredSize(View.textFieldSize);

        dodaj_label5 = new JLabel("Numer_Telefonu:");
        dodaj_label5.setPreferredSize(View.labelFieldSize);
        dodaj_text5 = new JTextField();
        dodaj_text5.setPreferredSize(View.textFieldSize);

        dodaj_label6 = new JLabel("Data_zatrudnienia:");
        dodaj_label6.setPreferredSize(View.labelFieldSize);
        dodaj_text6 = new JTextField();
        dodaj_text6.setPreferredSize(View.textFieldSize);

        dodaj_label7 = new JLabel("Id_kierownik:");
        dodaj_label7.setPreferredSize(View.labelFieldSize);
        dodaj_text7 = new JTextField();
        dodaj_text7.setPreferredSize(View.textFieldSize);

        dodaj_label8 = new JLabel("Login:");
        dodaj_label8.setPreferredSize(View.labelFieldSize);
        dodaj_text8 = new JTextField();
        dodaj_text8.setPreferredSize(View.textFieldSize);

        dodaj_label9 = new JLabel("Hasło:");
        dodaj_label9.setPreferredSize(View.labelFieldSize);
        dodaj_text9 = new JTextField();
        dodaj_text9.setPreferredSize(View.textFieldSize);

        dodaj_button = new JButton("Dodaj");
        dodaj_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                data.getData_base().insert_opiekun(dodaj_text2.getText(), dodaj_text3.getText(), dodaj_text4.getText(),
                        dodaj_text5.getText(), dodaj_text6.getText(), dodaj_text7.getText(), dodaj_text8.getText(), dodaj_text9.getText());
            }
        });

        dodaj_dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        dodaj_dialog.add(dodaj_label2);
        dodaj_dialog.add(dodaj_text2);
        dodaj_dialog.add(dodaj_label3);
        dodaj_dialog.add(dodaj_text3);
        dodaj_dialog.add(dodaj_label4);
        dodaj_dialog.add(dodaj_text4);
        dodaj_dialog.add(dodaj_label5);
        dodaj_dialog.add(dodaj_text5);
        dodaj_dialog.add(dodaj_label6);
        dodaj_dialog.add(dodaj_text6);
        dodaj_dialog.add(dodaj_label7);
        dodaj_dialog.add(dodaj_text7);
        dodaj_dialog.add(dodaj_label8);
        dodaj_dialog.add(dodaj_text8);
        dodaj_dialog.add(dodaj_label9);
        dodaj_dialog.add(dodaj_text9);
        dodaj_dialog.add(dodaj_button);

        dodaj_dialog.setSize(new Dimension(View.leftPanelSize.width+40, 200));
        dodaj_dialog.setVisible(true);
    }


    private void insert_zwierze()
    {
        dodaj_dialog = new JDialog(data.getMain_frame(), "Dodaj zwierze");

        dodaj_label1 = new JLabel("Dodaj zwierze");
        dodaj_label1.setPreferredSize(View.labelTitleSize);

        dodaj_label2 = new JLabel("Id_zwierze:");
        dodaj_label2.setPreferredSize(View.labelFieldSize);
        dodaj_text2 = new JTextField();
        dodaj_text2.setPreferredSize(View.textFieldSize);

        dodaj_label3 = new JLabel("Imie:");
        dodaj_label3.setPreferredSize(View.labelFieldSize);
        dodaj_text3 = new JTextField();
        dodaj_text3.setPreferredSize(View.textFieldSize);

        dodaj_label4 = new JLabel("Id_gatunek:");
        dodaj_label4.setPreferredSize(View.labelFieldSize);
        dodaj_text4 = new JTextField();
        dodaj_text4.setPreferredSize(View.textFieldSize);

        dodaj_label5 = new JLabel("Data_urodzenia:");
        dodaj_label5.setPreferredSize(View.labelFieldSize);
        dodaj_text5 = new JTextField();
        dodaj_text5.setPreferredSize(View.textFieldSize);

        dodaj_label6 = new JLabel("Samiec:");
        dodaj_label6.setPreferredSize(View.labelFieldSize);
        dodaj_text6 = new JTextField();
        dodaj_text6.setPreferredSize(View.textFieldSize);

        dodaj_button = new JButton("Dodaj");
        dodaj_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                data.getData_base().insert_zwierze(dodaj_text2.getText(), dodaj_text3.getText(), dodaj_text4.getText(),
                        dodaj_text5.getText(), dodaj_text6.getText());
            }
        });

        dodaj_dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        dodaj_dialog.add(dodaj_label2);
        dodaj_dialog.add(dodaj_text2);
        dodaj_dialog.add(dodaj_label3);
        dodaj_dialog.add(dodaj_text3);
        dodaj_dialog.add(dodaj_label4);
        dodaj_dialog.add(dodaj_text4);
        dodaj_dialog.add(dodaj_label5);
        dodaj_dialog.add(dodaj_text5);
        dodaj_dialog.add(dodaj_label6);
        dodaj_dialog.add(dodaj_text6);
        dodaj_dialog.add(dodaj_button);

        dodaj_dialog.setSize(new Dimension(View.leftPanelSize.width+40, 200));
        dodaj_dialog.setVisible(true);
    }



    private void insert_gatunek()
    {
        dodaj_dialog = new JDialog(data.getMain_frame(), "Dodaj gatunek");

        dodaj_label1 = new JLabel("Dodaj gatunek");
        dodaj_label1.setPreferredSize(View.labelTitleSize);

        dodaj_label2 = new JLabel("Id_gatunek:");
        dodaj_label2.setPreferredSize(View.labelFieldSize);
        dodaj_text2 = new JTextField();
        dodaj_text2.setPreferredSize(View.textFieldSize);

        dodaj_label3 = new JLabel("Nazwa:");
        dodaj_label3.setPreferredSize(View.labelFieldSize);
        dodaj_text3 = new JTextField();
        dodaj_text3.setPreferredSize(View.textFieldSize);

        dodaj_label4 = new JLabel("Typ:");
        dodaj_label4.setPreferredSize(View.labelFieldSize);
        dodaj_text4 = new JTextField();
        dodaj_text4.setPreferredSize(View.textFieldSize);

        dodaj_label5 = new JLabel("id_pasza:");
        dodaj_label5.setPreferredSize(View.labelFieldSize);
        dodaj_text5 = new JTextField();
        dodaj_text5.setPreferredSize(View.textFieldSize);


        dodaj_button = new JButton("Dodaj");
        dodaj_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                data.getData_base().insert_gatunek(dodaj_text2.getText(), dodaj_text3.getText(), dodaj_text4.getText(),
                        dodaj_text5.getText());
            }
        });

        dodaj_dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        dodaj_dialog.add(dodaj_label2);
        dodaj_dialog.add(dodaj_text2);
        dodaj_dialog.add(dodaj_label3);
        dodaj_dialog.add(dodaj_text3);
        dodaj_dialog.add(dodaj_label4);
        dodaj_dialog.add(dodaj_text4);
        dodaj_dialog.add(dodaj_label5);
        dodaj_dialog.add(dodaj_text5);
        dodaj_dialog.add(dodaj_button);

        dodaj_dialog.setSize(new Dimension(View.leftPanelSize.width+40, 200));
        dodaj_dialog.setVisible(true);
    }

    private void insert_pasza()
    {
        dodaj_dialog = new JDialog(data.getMain_frame(), "Dodaj pasze");

        dodaj_label1 = new JLabel("Dodaj pasze");
        dodaj_label1.setPreferredSize(View.labelTitleSize);

        dodaj_label2 = new JLabel("Id_pasza:");
        dodaj_label2.setPreferredSize(View.labelFieldSize);
        dodaj_text2 = new JTextField();
        dodaj_text2.setPreferredSize(View.textFieldSize);

        dodaj_label3 = new JLabel("Opis:");
        dodaj_label3.setPreferredSize(View.labelFieldSize);
        dodaj_text3 = new JTextField();
        dodaj_text3.setPreferredSize(View.textFieldSize);

        dodaj_label4 = new JLabel("Id_magazynier:");
        dodaj_label4.setPreferredSize(View.labelFieldSize);
        dodaj_text4 = new JTextField();
        dodaj_text4.setPreferredSize(View.textFieldSize);


        dodaj_button = new JButton("Dodaj");
        dodaj_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                data.getData_base().insert_pasza(dodaj_text2.getText(), dodaj_text3.getText(), dodaj_text4.getText());
            }
        });

        dodaj_dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        dodaj_dialog.add(dodaj_label2);
        dodaj_dialog.add(dodaj_text2);
        dodaj_dialog.add(dodaj_label3);
        dodaj_dialog.add(dodaj_text3);
        dodaj_dialog.add(dodaj_label4);
        dodaj_dialog.add(dodaj_text4);
        dodaj_dialog.add(dodaj_button);

        dodaj_dialog.setSize(new Dimension(View.leftPanelSize.width+40, 200));
        dodaj_dialog.setVisible(true);
    }

    private void insert_magazynier()
    {
        dodaj_dialog = new JDialog(data.getMain_frame(), "Dodaj magazyniera");

        dodaj_label1 = new JLabel("Dodaj magazyniera");
        dodaj_label1.setPreferredSize(View.labelTitleSize);

        dodaj_label2 = new JLabel("Id_magazynier:");
        dodaj_label2.setPreferredSize(View.labelFieldSize);
        dodaj_text2 = new JTextField();
        dodaj_text2.setPreferredSize(View.textFieldSize);

        dodaj_label3 = new JLabel("Imie:");
        dodaj_label3.setPreferredSize(View.labelFieldSize);
        dodaj_text3 = new JTextField();
        dodaj_text3.setPreferredSize(View.textFieldSize);

        dodaj_label4 = new JLabel("Nazwisko:");
        dodaj_label4.setPreferredSize(View.labelFieldSize);
        dodaj_text4 = new JTextField();
        dodaj_text4.setPreferredSize(View.textFieldSize);

        dodaj_label5 = new JLabel("Numer_Telefonu:");
        dodaj_label5.setPreferredSize(View.labelFieldSize);
        dodaj_text5 = new JTextField();
        dodaj_text5.setPreferredSize(View.textFieldSize);

        dodaj_label6 = new JLabel("Data_zatrudnienia:");
        dodaj_label6.setPreferredSize(View.labelFieldSize);
        dodaj_text6 = new JTextField();
        dodaj_text6.setPreferredSize(View.textFieldSize);

        dodaj_label7 = new JLabel("Id_kierownik:");
        dodaj_label7.setPreferredSize(View.labelFieldSize);
        dodaj_text7 = new JTextField();
        dodaj_text7.setPreferredSize(View.textFieldSize);

        dodaj_label8 = new JLabel("Login:");
        dodaj_label8.setPreferredSize(View.labelFieldSize);
        dodaj_text8 = new JTextField();
        dodaj_text8.setPreferredSize(View.textFieldSize);

        dodaj_label9 = new JLabel("Hasło:");
        dodaj_label9.setPreferredSize(View.labelFieldSize);
        dodaj_text9 = new JTextField();
        dodaj_text9.setPreferredSize(View.textFieldSize);

        dodaj_button = new JButton("Dodaj");
        dodaj_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                data.getData_base().insert_magazynier(dodaj_text2.getText(), dodaj_text3.getText(), dodaj_text4.getText(),
                        dodaj_text5.getText(), dodaj_text6.getText(), dodaj_text7.getText(), dodaj_text8.getText(), dodaj_text9.getText());
            }
        });

        dodaj_dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        dodaj_dialog.add(dodaj_label2);
        dodaj_dialog.add(dodaj_text2);
        dodaj_dialog.add(dodaj_label3);
        dodaj_dialog.add(dodaj_text3);
        dodaj_dialog.add(dodaj_label4);
        dodaj_dialog.add(dodaj_text4);
        dodaj_dialog.add(dodaj_label5);
        dodaj_dialog.add(dodaj_text5);
        dodaj_dialog.add(dodaj_label6);
        dodaj_dialog.add(dodaj_text6);
        dodaj_dialog.add(dodaj_label7);
        dodaj_dialog.add(dodaj_text7);
        dodaj_dialog.add(dodaj_label8);
        dodaj_dialog.add(dodaj_text8);
        dodaj_dialog.add(dodaj_label9);
        dodaj_dialog.add(dodaj_text9);

        dodaj_dialog.add(dodaj_button);

        dodaj_dialog.setSize(new Dimension(View.leftPanelSize.width+40, 200));
        dodaj_dialog.setVisible(true);
    }

    private void insert_kierownik()
    {
        dodaj_dialog = new JDialog(data.getMain_frame(), "Dodaj kierownika");

        dodaj_label1 = new JLabel("Dodaj kierownika");
        dodaj_label1.setPreferredSize(View.labelTitleSize);

        dodaj_label2 = new JLabel("Id_kierownik:");
        dodaj_label2.setPreferredSize(View.labelFieldSize);
        dodaj_text2 = new JTextField();
        dodaj_text2.setPreferredSize(View.textFieldSize);

        dodaj_label3 = new JLabel("Imie:");
        dodaj_label3.setPreferredSize(View.labelFieldSize);
        dodaj_text3 = new JTextField();
        dodaj_text3.setPreferredSize(View.textFieldSize);

        dodaj_label4 = new JLabel("Nazwisko:");
        dodaj_label4.setPreferredSize(View.labelFieldSize);
        dodaj_text4 = new JTextField();
        dodaj_text4.setPreferredSize(View.textFieldSize);

        dodaj_label5 = new JLabel("Numer_Telefonu:");
        dodaj_label5.setPreferredSize(View.labelFieldSize);
        dodaj_text5 = new JTextField();
        dodaj_text5.setPreferredSize(View.textFieldSize);

        dodaj_label6 = new JLabel("Data_zatrudnienia:");
        dodaj_label6.setPreferredSize(View.labelFieldSize);
        dodaj_text6 = new JTextField();
        dodaj_text6.setPreferredSize(View.textFieldSize);

        dodaj_label7 = new JLabel("Login:");
        dodaj_label7.setPreferredSize(View.labelFieldSize);
        dodaj_text7 = new JTextField();
        dodaj_text7.setPreferredSize(View.textFieldSize);

        dodaj_label8 = new JLabel("Hasło:");
        dodaj_label8.setPreferredSize(View.labelFieldSize);
        dodaj_text8 = new JTextField();
        dodaj_text8.setPreferredSize(View.textFieldSize);


        dodaj_button = new JButton("Dodaj");
        dodaj_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                data.getData_base().insert_kierownik(dodaj_text2.getText(), dodaj_text3.getText(), dodaj_text4.getText(),
                        dodaj_text5.getText(), dodaj_text6.getText(), dodaj_text7.getText(), dodaj_text8.getText());
            }
        });

        dodaj_dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        dodaj_dialog.add(dodaj_label2);
        dodaj_dialog.add(dodaj_text2);
        dodaj_dialog.add(dodaj_label3);
        dodaj_dialog.add(dodaj_text3);
        dodaj_dialog.add(dodaj_label4);
        dodaj_dialog.add(dodaj_text4);
        dodaj_dialog.add(dodaj_label5);
        dodaj_dialog.add(dodaj_text5);
        dodaj_dialog.add(dodaj_label6);
        dodaj_dialog.add(dodaj_text6);
        dodaj_dialog.add(dodaj_label7);
        dodaj_dialog.add(dodaj_text7);
        dodaj_dialog.add(dodaj_label8);
        dodaj_dialog.add(dodaj_text8);
        dodaj_dialog.add(dodaj_button);

        dodaj_dialog.setSize(new Dimension(View.leftPanelSize.width+40, 200));
        dodaj_dialog.setVisible(true);
    }

    private void insert_ankieta()
    {
        dodaj_dialog = new JDialog(data.getMain_frame(), "Dodaj ankiete");

        dodaj_label1 = new JLabel("Dodaj ankiete");
        dodaj_label1.setPreferredSize(View.labelTitleSize);

        dodaj_label2 = new JLabel("Ankieta_id:");
        dodaj_label2.setPreferredSize(View.labelFieldSize);
        dodaj_text2 = new JTextField();
        dodaj_text2.setPreferredSize(View.textFieldSize);

        dodaj_label3 = new JLabel("id_ulubione_zwierze:");
        dodaj_label3.setPreferredSize(View.labelFieldSize);
        dodaj_text3 = new JTextField();
        dodaj_text3.setPreferredSize(View.textFieldSize);

        dodaj_button = new JButton("Dodaj");
        dodaj_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                data.getData_base().insert_ankieta(dodaj_text2.getText(), dodaj_text3.getText());
            }
        });

        dodaj_dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        dodaj_dialog.add(dodaj_label2);
        dodaj_dialog.add(dodaj_text2);
        dodaj_dialog.add(dodaj_label3);
        dodaj_dialog.add(dodaj_text3);
        dodaj_dialog.add(dodaj_button);

        dodaj_dialog.setSize(new Dimension(View.leftPanelSize.width+40, 200));
        dodaj_dialog.setVisible(true);
    }

    private void insert_kasjer()
    {
        dodaj_dialog = new JDialog(data.getMain_frame(), "Dodaj kasjera");

        dodaj_label1 = new JLabel("Dodaj kasjera");
        dodaj_label1.setPreferredSize(View.labelTitleSize);

        dodaj_label2 = new JLabel("Id_kasjer:");
        dodaj_label2.setPreferredSize(View.labelFieldSize);
        dodaj_text2 = new JTextField();
        dodaj_text2.setPreferredSize(View.textFieldSize);

        dodaj_label3 = new JLabel("Imie:");
        dodaj_label3.setPreferredSize(View.labelFieldSize);
        dodaj_text3 = new JTextField();
        dodaj_text3.setPreferredSize(View.textFieldSize);

        dodaj_label4 = new JLabel("Nazwisko:");
        dodaj_label4.setPreferredSize(View.labelFieldSize);
        dodaj_text4 = new JTextField();
        dodaj_text4.setPreferredSize(View.textFieldSize);

        dodaj_label5 = new JLabel("Numer_Telefonu:");
        dodaj_label5.setPreferredSize(View.labelFieldSize);
        dodaj_text5 = new JTextField();
        dodaj_text5.setPreferredSize(View.textFieldSize);

        dodaj_label6 = new JLabel("Data_zatrudnienia:");
        dodaj_label6.setPreferredSize(View.labelFieldSize);
        dodaj_text6 = new JTextField();
        dodaj_text6.setPreferredSize(View.textFieldSize);

        dodaj_label7 = new JLabel("Id_kierownik:");
        dodaj_label7.setPreferredSize(View.labelFieldSize);
        dodaj_text7 = new JTextField();
        dodaj_text7.setPreferredSize(View.textFieldSize);

        dodaj_label8 = new JLabel("Login:");
        dodaj_label8.setPreferredSize(View.labelFieldSize);
        dodaj_text8 = new JTextField();
        dodaj_text8.setPreferredSize(View.textFieldSize);

        dodaj_label9 = new JLabel("Hasło:");
        dodaj_label9.setPreferredSize(View.labelFieldSize);
        dodaj_text9 = new JTextField();
        dodaj_text9.setPreferredSize(View.textFieldSize);

        dodaj_button = new JButton("Dodaj");
        dodaj_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                data.getData_base().insert_kasjer(dodaj_text2.getText(), dodaj_text3.getText(), dodaj_text4.getText(),
                        dodaj_text5.getText(), dodaj_text6.getText(), dodaj_text7.getText(), dodaj_text8.getText(), dodaj_text9.getText());
            }
        });

        dodaj_dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        dodaj_dialog.add(dodaj_label2);
        dodaj_dialog.add(dodaj_text2);
        dodaj_dialog.add(dodaj_label3);
        dodaj_dialog.add(dodaj_text3);
        dodaj_dialog.add(dodaj_label4);
        dodaj_dialog.add(dodaj_text4);
        dodaj_dialog.add(dodaj_label5);
        dodaj_dialog.add(dodaj_text5);
        dodaj_dialog.add(dodaj_label6);
        dodaj_dialog.add(dodaj_text6);
        dodaj_dialog.add(dodaj_label7);
        dodaj_dialog.add(dodaj_text7);
        dodaj_dialog.add(dodaj_label8);
        dodaj_dialog.add(dodaj_text8);
        dodaj_dialog.add(dodaj_label9);
        dodaj_dialog.add(dodaj_text9);
        dodaj_dialog.add(dodaj_button);

        dodaj_dialog.setSize(new Dimension(View.leftPanelSize.width+40, 200));
        dodaj_dialog.setVisible(true);
    }

    private void insert_opiekun_zwierze()
    {
        dodaj_dialog = new JDialog(data.getMain_frame(), "Dodaj opiekun_zwierze");

        dodaj_label1 = new JLabel("Dodaj opiekun_zwierze");
        dodaj_label1.setPreferredSize(View.labelTitleSize);

        dodaj_label2 = new JLabel("Id_zwierze:");
        dodaj_label2.setPreferredSize(View.labelFieldSize);
        dodaj_text2 = new JTextField();
        dodaj_text2.setPreferredSize(View.textFieldSize);

        dodaj_label3 = new JLabel("Id_opiekun:");
        dodaj_label3.setPreferredSize(View.labelFieldSize);
        dodaj_text3 = new JTextField();
        dodaj_text3.setPreferredSize(View.textFieldSize);

        dodaj_button = new JButton("Dodaj");
        dodaj_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                data.getData_base().insert_opiekun_zwierze(dodaj_text2.getText(), dodaj_text3.getText());
            }
        });

        dodaj_dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        dodaj_dialog.add(dodaj_label2);
        dodaj_dialog.add(dodaj_text2);
        dodaj_dialog.add(dodaj_label3);
        dodaj_dialog.add(dodaj_text3);

        dodaj_dialog.add(dodaj_button);

        dodaj_dialog.setSize(new Dimension(View.leftPanelSize.width+40, 200));
        dodaj_dialog.setVisible(true);
    }

    private void powrot_fun()
    {
        data.set_current_page("main");
    }

    public Left_dodaj_tablice_panel(Model_object DATA)
    {
        data = DATA;

        opiekun_button= new JButton("Opiekun");
        zwierze_button=new JButton("Zwierze");
        opiekun_zwierze_button = new JButton("Opiekun_zwierze");
        gatunek_button=new JButton("Gatunek");
        pasza_button=new JButton("Pasza");
        magazynier_button=new JButton("Magazynier");
        kierownik_button=new JButton("Kierownik");
        ankieta_button =new JButton("Ankieta");
        kasjer_button=new JButton("Kasjer");
        powrot_button=new JButton("Powrót");

        opiekun_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insert_opiekun();
            }
        });
        zwierze_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insert_zwierze();
            }
        });
        opiekun_zwierze_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insert_opiekun_zwierze();
            }
        });
        gatunek_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insert_gatunek();
            }
        });
        pasza_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insert_pasza();
            }
        });
        magazynier_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insert_magazynier();
            }
        });
        kierownik_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insert_kierownik();
            }
        });
        ankieta_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insert_ankieta();
            }
        });
        kasjer_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insert_kasjer();
            }
        });
        powrot_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                powrot_fun();
            }
        });

        this.setLayout( new GridLayout(8, 1) );
        this.add(opiekun_button);
        this.add(zwierze_button);
        this.add(opiekun_zwierze_button);
        this.add(gatunek_button);
        this.add(pasza_button);
        this.add(magazynier_button);
        this.add(kierownik_button);
        this.add(ankieta_button);
        this.add(kasjer_button);
        this.add(powrot_button);

        this.setPreferredSize(View.leftPanelSize);
    }
}