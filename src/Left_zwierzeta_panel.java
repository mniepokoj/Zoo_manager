import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Left_zwierzeta_panel extends JPanel implements ActionListener
{
    public JPanel  pobierz_gatunek_panel;
    public JButton pobierz_gatunek_button;
    public JLabel  pobierz_gatunek_label1;
    public JLabel  pobierz_gatunek_label2;
    public JTextField pobierz_gatunek_text;

    public JPanel  pobierz_pracownik_panel1;
    public JButton pobierz_pracownik_button;
    public JLabel  pobierz_pracownik_label1;
    public JLabel pobierz_pracownik_label2;
    public JLabel pobierz_pracownik_label3;
    public JTextField pobierz_pracownik_text;

    public JPanel  dodaj_gatunek_panel1;
    JDialog dodaj_gatunek_dialog;
    JComboBox dodaj_gatunek_comboBox4;
    JLabel dodaj_gatunek_label1;
    JLabel dodaj_gatunek_label2;
    JLabel dodaj_gatunek_label3;
    JLabel dodaj_gatunek_label4;
    JTextField dodaj_gatunek_text2;
    JTextField dodaj_gatunek_text3;
    JTextField dodaj_gatunek_text4;
    JButton dodaj_gatunek_button;
    JButton dodaj_gatunek_button1;
    JLabel dodaj_gatunek_label;


    public JPanel  dodaj_zwierze_panel1;
    JDialog dodaj_zwierze_dialog;
    JComboBox dodaj_zwierze_comboBox5;
    JLabel dodaj_zwierze_label1;
    JLabel dodaj_zwierze_label2;
    JLabel dodaj_zwierze_label3;
    JLabel dodaj_zwierze_label4;
    JLabel dodaj_zwierze_label5;
    JTextField dodaj_zwierze_text2;
    JTextField dodaj_zwierze_text3;
    JTextField dodaj_zwierze_text4;
    JButton dodaj_zwierze_button;
    JButton dodaj_zwierze_button1;
    JLabel dodaj_zwierze_label;


    public JPanel powrot_panel;
    public JButton powrot_button;


    Model_object data;

    private void lista_zwierzat()
    {
        ArrayList<String> columns = new ArrayList<String>();
        ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
        data.getData_base().getZwierzeta(columns, rows);
        data.getCenterPane().setTableData(columns, rows);
    }

    private void lista_popularne_zwierzeta()
    {
        ArrayList<String> columns = new ArrayList<String>();
        ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
        data.getData_base().getPopularneZwierzeta( columns, rows);
        data.getCenterPane().setTableData(columns, rows);
    }

    private void dodaj_gatunek(String nazwa, String typ, String pozywienie)
    {
        data.getData_base().addGatunek(nazwa, typ, pozywienie);
    }

    private void dodaj_zwierze(String gatunek, String imie, String plec, String date)
    {
        data.getData_base().addZwierze(imie, gatunek, plec, date);
    }

    private void powrot_fun()
    {
        data.set_current_page("main");
    }

    private void create_pobierz_gatunek()
    {
        pobierz_gatunek_panel = new JPanel();
        pobierz_gatunek_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        pobierz_gatunek_label1 = new JLabel("Lista zwierząt", SwingConstants.CENTER);
        pobierz_gatunek_label1.setPreferredSize(View.labelTitleSize);
        pobierz_gatunek_button = new JButton("Wypisz");
        pobierz_gatunek_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    lista_zwierzat();
            }
        });

        pobierz_gatunek_panel.add(pobierz_gatunek_label1);
        pobierz_gatunek_panel.add(pobierz_gatunek_button);
    }


    private void create_pobierz_pracownik()
    {
        pobierz_pracownik_panel1 = new JPanel();
        pobierz_pracownik_panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        pobierz_pracownik_label1 = new JLabel("Najpopularniejsze zwierzęta", SwingConstants.CENTER);
        pobierz_pracownik_label1.setPreferredSize(View.labelTitleSize);
        pobierz_pracownik_label2 = new JLabel(Util.convertToMultiline("\n"), SwingConstants.CENTER);


        pobierz_pracownik_button = new JButton("Wypisz");
        pobierz_pracownik_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lista_popularne_zwierzeta();
            }
        });

        pobierz_pracownik_panel1.add(pobierz_pracownik_label1);
        pobierz_pracownik_panel1.add(pobierz_pracownik_label2);
        pobierz_pracownik_panel1.add(pobierz_pracownik_button);
    }

    private void create_dodaj_gatunek()
    {
        dodaj_gatunek_label = new JLabel("Dodaj gatunek:", SwingConstants.CENTER);
        dodaj_gatunek_label.setPreferredSize(View.labelTitleSize);
        dodaj_gatunek_button1 = new JButton("Dodaj");
        dodaj_gatunek_button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                dodaj_gatunek_dialog = new JDialog(data.getMain_frame(), "Dodaj gatunek");

                dodaj_gatunek_label1 = new JLabel("Dodaj gatunek");
                dodaj_gatunek_label1.setPreferredSize(View.labelTitleSize);

                dodaj_gatunek_label2 = new JLabel("Nazwa:");
                dodaj_gatunek_label2.setPreferredSize(View.labelFieldSize);
                dodaj_gatunek_text2 = new JTextField();
                dodaj_gatunek_text2.setPreferredSize(View.textFieldSize);

                dodaj_gatunek_label3 = new JLabel("Typ:");
                dodaj_gatunek_label3.setPreferredSize(View.labelFieldSize);
                dodaj_gatunek_text3 = new JTextField();
                dodaj_gatunek_text3.setPreferredSize(View.textFieldSize);

                dodaj_gatunek_label4 = new JLabel("Pokarm:");
                dodaj_gatunek_label4.setPreferredSize(View.labelFieldSize);
                dodaj_gatunek_comboBox4 = new JComboBox( data.getData_base().getPasza());

                dodaj_gatunek_button = new JButton("Dodaj");
                dodaj_gatunek_button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        data.getData_base().dodaj_gatunek(dodaj_gatunek_text2.getText(), dodaj_gatunek_text3.getText(), dodaj_gatunek_comboBox4.getSelectedItem().toString());
                    }
                });

                dodaj_gatunek_dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
                dodaj_gatunek_dialog.add(dodaj_gatunek_label2);
                dodaj_gatunek_dialog.add(dodaj_gatunek_text2);
                dodaj_gatunek_dialog.add(dodaj_gatunek_label3);
                dodaj_gatunek_dialog.add(dodaj_gatunek_text3);
                dodaj_gatunek_dialog.add(dodaj_gatunek_label4);
                dodaj_gatunek_dialog.add(dodaj_gatunek_comboBox4);
                dodaj_gatunek_dialog.add(dodaj_gatunek_button);

                dodaj_gatunek_dialog.setSize(new Dimension(View.leftPanelSize.width+40, 180));
                dodaj_gatunek_dialog.setVisible(true);
            }
        });

        dodaj_gatunek_panel1 = new JPanel();
        dodaj_gatunek_panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        dodaj_gatunek_panel1.add(dodaj_gatunek_label);
        dodaj_gatunek_panel1.add(dodaj_gatunek_button1);
    }

    private void create_dodaj_zwierze()
    {
        dodaj_zwierze_label = new JLabel("Dodaj zwierze:", SwingConstants.CENTER);
        dodaj_zwierze_label.setPreferredSize(View.labelTitleSize);
        dodaj_zwierze_button1 = new JButton("Dodaj");
        dodaj_zwierze_button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                dodaj_zwierze_dialog = new JDialog(data.getMain_frame(), "Dodaj zwierze");

                dodaj_zwierze_label1 = new JLabel("Dodaj zwierze");
                dodaj_zwierze_label1.setPreferredSize(View.labelTitleSize);

                dodaj_zwierze_label2 = new JLabel("Imie:");
                dodaj_zwierze_label2.setPreferredSize(View.labelFieldSize);
                dodaj_zwierze_text2 = new JTextField();
                dodaj_zwierze_text2.setPreferredSize(View.textFieldSize);

                dodaj_zwierze_label3 = new JLabel("Data urodzenia:");
                dodaj_zwierze_label3.setPreferredSize(View.labelFieldSize);
                dodaj_zwierze_text3 = new JTextField();
                dodaj_zwierze_text3.setPreferredSize(View.textFieldSize);

                dodaj_zwierze_label4 = new JLabel("Samiec:");
                dodaj_zwierze_label4.setPreferredSize(View.labelFieldSize);
                dodaj_zwierze_text4 = new JTextField();
                dodaj_zwierze_text4.setPreferredSize(View.textFieldSize);

                dodaj_zwierze_label5 = new JLabel("Gatunek:");
                dodaj_zwierze_label5.setPreferredSize(View.labelFieldSize);
                dodaj_zwierze_comboBox5 = new JComboBox( data.getData_base().getGatunek());

                dodaj_zwierze_button = new JButton("Dodaj");
                dodaj_zwierze_button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                        data.getData_base().dodaj_zwierze(dodaj_zwierze_text2.getText(), dodaj_zwierze_text3.getText(),
                                dodaj_zwierze_text4.getText(), dodaj_zwierze_comboBox5.getSelectedItem().toString());
                    }
                });

                dodaj_zwierze_dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
                dodaj_zwierze_dialog.add(dodaj_zwierze_label2);
                dodaj_zwierze_dialog.add(dodaj_zwierze_text2);
                dodaj_zwierze_dialog.add(dodaj_zwierze_label3);
                dodaj_zwierze_dialog.add(dodaj_zwierze_text3);
                dodaj_zwierze_dialog.add(dodaj_zwierze_label4);
                dodaj_zwierze_dialog.add(dodaj_zwierze_text4);
                dodaj_zwierze_dialog.add(dodaj_zwierze_label5);
                dodaj_zwierze_dialog.add(dodaj_zwierze_comboBox5);
                dodaj_zwierze_dialog.add(dodaj_zwierze_button);

                dodaj_zwierze_dialog.setSize(new Dimension(View.leftPanelSize.width+80, 180));
                dodaj_zwierze_dialog.setVisible(true);
            }
        });

        dodaj_zwierze_panel1 = new JPanel();
        dodaj_zwierze_panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        dodaj_zwierze_panel1.add(dodaj_zwierze_label);
        dodaj_zwierze_panel1.add(dodaj_zwierze_button1);
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

    public Left_zwierzeta_panel(Model_object DATA)
    {
        data = DATA;
        create_pobierz_gatunek();
        create_dodaj_gatunek();
        create_dodaj_zwierze();
        create_pobierz_pracownik();
        create_powrot();


        this.setLayout( new BoxLayout(this, BoxLayout.Y_AXIS) );
        this.add(pobierz_gatunek_panel);
        this.add(pobierz_pracownik_panel1);
        this.add(dodaj_gatunek_panel1);
        this.add(dodaj_zwierze_panel1);
        this.add(powrot_panel);
        this.setPreferredSize(View.leftPanelSize);
    }


    public void actionPerformed(ActionEvent e)
    {

    }
}
