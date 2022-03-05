import java.awt.*;

public interface View {
    public final static Dimension frameSize = new Dimension(800, 800);
    public final static Dimension leftPanelSize = new Dimension(220, frameSize.height);
    public final static Dimension centerPanelSize = new Dimension(frameSize.width-leftPanelSize.width, frameSize.height);
    public final static Dimension labelTitleSize = new Dimension(leftPanelSize.width, 23);
    public final static Dimension textFieldSize = new Dimension(90, 22);
    public final static Dimension labelFieldSize = new Dimension(leftPanelSize.width-textFieldSize.width-10, 22);
}
