import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Left_odczytaj_tablice_panel extends JPanel
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

    private void draw_opiekun()
    {
        ArrayList<String> columns = new ArrayList<String>();
        ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
        data.getData_base().getTable("opiekun", columns, rows);
        data.getCenterPane().setTableData(columns, rows);
    }

    private void draw_zwierze()
    {
        ArrayList<String> columns = new ArrayList<String>();
        ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
        data.getData_base().getTable("zwierze", columns, rows);
        data.getCenterPane().setTableData(columns, rows);

    }

    private void draw_gatunek()
    {
        ArrayList<String> columns = new ArrayList<String>();
        ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
        data.getData_base().getTable("gatunek", columns, rows);
        data.getCenterPane().setTableData(columns, rows);
    }

    private void draw_pasza()
    {
        ArrayList<String> columns = new ArrayList<String>();
        ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
        data.getData_base().getTable("pasza", columns, rows);
        data.getCenterPane().setTableData(columns, rows);
    }

    private void draw_magazynier()
    {
        ArrayList<String> columns = new ArrayList<String>();
        ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
        data.getData_base().getTable("magazynier", columns, rows);
        data.getCenterPane().setTableData(columns, rows);
    }

    private void draw_kierownik()
    {
        ArrayList<String> columns = new ArrayList<String>();
        ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
        data.getData_base().getTable("kierownik", columns, rows);
        data.getCenterPane().setTableData(columns, rows);
    }

    private void draw_klient()
    {
        ArrayList<String> columns = new ArrayList<String>();
        ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
        data.getData_base().getTable("ankieta", columns, rows);
        data.getCenterPane().setTableData(columns, rows);
    }

    private void draw_kasjer()
    {
        ArrayList<String> columns = new ArrayList<String>();
        ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
        data.getData_base().getTable("kasjer", columns, rows);
        data.getCenterPane().setTableData(columns, rows);
    }

    private void draw_opiekun_zwierze()
    {
        ArrayList<String> columns = new ArrayList<String>();
        ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();
        data.getData_base().getTable("opiekun_zwierze", columns, rows);
        data.getCenterPane().setTableData(columns, rows);
    }

    private void powrot_fun()
    {
        data.set_current_page("main");
    }

    public Left_odczytaj_tablice_panel(Model_object DATA)
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
                draw_opiekun();
            }
        });
        zwierze_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                draw_zwierze();
            }
        });
        opiekun_zwierze_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                draw_opiekun_zwierze();
            }
        });
        gatunek_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                draw_gatunek();
            }
        });
        pasza_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                draw_pasza();
            }
        });
        magazynier_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                draw_magazynier();
            }
        });
        kierownik_button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            draw_kierownik();
        }
    });
        ankieta_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                draw_klient();
            }
        });
        kasjer_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                draw_kasjer();
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
