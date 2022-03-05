import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Center_pane extends Container
{
    private Model_object data;
    private Table_panel table_panel;
    private JLabel out_label;
    private int index = 1;

    public void setOut(String out)
    {
        out_label.setText("OUT: "+out + " #" + index++);
    }

    public void setTableData(ArrayList column, ArrayList<ArrayList<String>> data)
    {
        table_panel.set_table_data(column, data);
    }

    Center_pane(Model_object DATA)
    {
        data = DATA;
        this.setLayout(new BorderLayout());

        table_panel = new Table_panel(data);
        out_label = new JLabel("Out: ");
        out_label.setFont(new Font(out_label.getFont().getName(), Font.BOLD, 20));
        this.add(table_panel, BorderLayout.CENTER);
        this.add(out_label, BorderLayout.SOUTH);
    }
}
