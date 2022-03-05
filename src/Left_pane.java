import javax.swing.*;
import java.awt.*;

public class Left_pane extends Container
{
    Model_object data;
    JPanel left_main_panel, left_pracownicy_panel, left_odczytaj_tabele_panel, left_dodaj_tabele_panel, left_zwierzeta_panel, left_logowanie_panel;
    private CardLayout page_card_layout;
    private String current_page;
    Left_pane(Model_object DATA)
    {
        data = DATA;

        page_card_layout = new CardLayout(50, 70);
        this.setLayout(page_card_layout);
        current_page = "logowanie";

        left_main_panel = new Left_main_panel(data);
        left_pracownicy_panel = new Left_pracownicy_panel(data);
        left_zwierzeta_panel = new Left_zwierzeta_panel(data);
        left_odczytaj_tabele_panel = new Left_odczytaj_tablice_panel(data);
        left_dodaj_tabele_panel = new Left_dodaj_tablice_panel(data);
        left_logowanie_panel = new Left_logowanie_panel(data);

        this.add("main", left_main_panel);
        this.add("zwierzeta", left_zwierzeta_panel);
        this.add("pracownicy", left_pracownicy_panel);
        this.add("odczytaj_tabele", left_odczytaj_tabele_panel);
        this.add("dodaj_tabele", left_dodaj_tabele_panel);
        this.add("logowanie", left_logowanie_panel);

        setPage(current_page);
    }

    public void setPage(String page)
    {
        current_page = page;
        page_card_layout.show(this, page);
    }


}
