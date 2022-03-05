import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Model_object
{
    private Left_pane LeftPane = null;

    private Center_pane CenterPane = null;

    private DefaultTableModel tableModel;

    private JFrame main_frame;

    private DataBase data_base;

    public JFrame getMain_frame() {
        return main_frame;
    }

    public Container getLeftPane() {
        return LeftPane;
    }

    public void setLeftPane(Left_pane leftPane) {
        LeftPane = leftPane;
    }

    public void setCenterPane(Center_pane centerPane) {
        CenterPane = centerPane;
    }

    public void set_current_page(String page)
    {
        LeftPane.setPage(page);
    }

    public DataBase getData_base() {
        return data_base;
    }

    public Center_pane getCenterPane() {
        return CenterPane;
    }

    public void setData_base(DataBase data_base) {
        this.data_base = data_base;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;



    public Model_object(JFrame MAIN_FRAME)
    {
        main_frame = MAIN_FRAME;
    }
}
