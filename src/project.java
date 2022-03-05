// import statements
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class project extends JFrame
{
    Model_object data;
    // button variables to hold the references of buttons

    Container main_pane;
    Left_pane left_pane;
    Center_pane center_pane;
    DataBase data_base;




    // constructor of the class
    project()
    {
        data = new Model_object(this);
        center_pane = new Center_pane(data);
        data.setCenterPane(center_pane);
        data_base = new DataBase(data);
        data.setData_base(data_base);
        left_pane = new Left_pane(data);
        data.setLeftPane(left_pane);

        main_pane = getContentPane();
        main_pane.setLayout(new BorderLayout(0, 10));


        main_pane.add(left_pane, BorderLayout.WEST);
        main_pane.add(center_pane, BorderLayout.CENTER);



        this.setSize(View.frameSize);
        this.setTitle("Projekt BD - Ogród zoologiczny");
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    // main method
    public static void main(String argvs[])
    {
        // creating an object of the class CardLayoutExample1
        project crdl = new project();


    }
}