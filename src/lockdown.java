import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class lockdown extends ApplicationFrame {

    public lockdown(String applicationTitle) throws IOException {
        super(applicationTitle);
        this.add(new ChartPanel(createChart(createDataset())));
    }

    public XYSeriesCollection createDataset() {
        final XYSeries series = new XYSeries("X");
        try {
            BufferedReader in = new BufferedReader(new FileReader("DMCW.txt"));
            SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
            String s = null;
            while ((s = in.readLine()) != null) {
                String[] a = s.split(",");
                Date d = f.parse(a[6]);
                double v = Double.valueOf(a[10]);
                series.add(d.getTime(), v);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace(System.err);
        }
        return new XYSeriesCollection(series);
    }

    public JFreeChart createChart(XYDataset dataset)
        throws NumberFormatException, IOException {
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Rate of change in Cases vs Time", "Time", "Cases", dataset,
            false, true, false);
        return chart;
    }

    public static void main(String[] args) throws IOException {
        final lockdown demo = new lockdown("Test Time Series Chart");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}