import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Left_logowanie_panel extends JPanel
{
    public JButton logowanie_button;
    public JDialog dialog;

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JTextField text2;
    JTextField text3;
    JButton button;
    Model_object data;


    void create_logowanie()
    {
        logowanie_button = new JButton("Logowanie");
        logowanie_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                label1 = new JLabel("Logowanie");
                label1.setPreferredSize(View.labelTitleSize);

                label2 = new JLabel("Login:");
                label2.setPreferredSize(View.labelFieldSize);
                text2 = new JTextField();
                text2.setPreferredSize(new Dimension(View.textFieldSize.width + 20, View.textFieldSize.height));

                label3 = new JLabel("Hasło:");
                label3.setPreferredSize(View.labelFieldSize);
                text3 = new JTextField();
                text3.setPreferredSize(new Dimension(View.textFieldSize.width + 20, View.textFieldSize.height));


                button = new JButton("Zaloguj");
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int r = data.getData_base().login(text2.getText(), text3.getText());
                        if (r > 0)
                        {
                            data.setUsername(text2.getText());
                            data.set_current_page("main");
                            dialog.setVisible(false);
                        }
                    }
                });

                dialog = new JDialog(data.getMain_frame(), "Dodaj pracownika");
                dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
                dialog.add(label1);
                dialog.add(label2);
                dialog.add(text2);
                dialog.add(label3);
                dialog.add(text3);
                dialog.add(button);

                dialog.setSize(new Dimension(View.leftPanelSize.width+80, 160));
                dialog.setVisible(true);
            }
        });
    }



    public Left_logowanie_panel(Model_object DATA)
    {
        data = DATA;

        create_logowanie();
        this.setLayout( new GridLayout(1, 1, 100, 200) );
        this.add(logowanie_button);
        this.setPreferredSize(View.leftPanelSize);

    }

}
