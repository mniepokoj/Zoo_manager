import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public class Table_panel extends JPanel
{
    Model_object data;
    private JTable table;
    private JScrollPane scroll_pane;
    private DefaultTableModel tableModel;

    void set_table_data(ArrayList column, ArrayList<ArrayList<String>> data)
    {
        Object c[] = (column).toArray();

        int sx = data.size();
        if(sx > 0)
        {
            int sy = data.get(0).size();
            Object[][] d = new Object[sx][];
            for(int i = 0; i < sx; i++)
            {
                d[i] = data.get(i).toArray();
            }
            tableModel.setDataVector(d, c);
        }
        else
        {
            tableModel.setRowCount(0);
            tableModel.setColumnIdentifiers(column.toArray());
        }

    }

    public Table_panel(Model_object DATA)
    {
        data = DATA;
        this.setBackground(Color.WHITE);
        this.setPreferredSize(View.centerPanelSize);
        this.setLayout(new BorderLayout());

        String[] t = {"1", "2", "3", "4", "5"};
        Object[][] k = {{"", "", "", "", ""}};
        tableModel = new DefaultTableModel(k, t);

        table = new JTable(tableModel);
        scroll_pane = new JScrollPane(table);
        this.add(scroll_pane, BorderLayout.CENTER);
    }
}
