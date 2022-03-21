import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Panel extends JPanel {

    Image image;
    private int hrs;
    private int min;
    private int sec;
    private int day;
    private int month;
    private int year;

    // Getter

    public int getHrs() {
        return hrs;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    Panel() {
        image = new ImageIcon("images/clockFace3.png").getImage();
        this.setPreferredSize(new Dimension(600, 600));

        setCurrentTime();
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        //Initialization
        int clockRadius = (int)(Math.min(getWidth(), getHeight()) * 0.8 * 0.5);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

        g2D.drawImage(image, xCenter - getWidth()/2, yCenter - getHeight()/2 , 600, 600, null);

        //Draw Hours hand
        int hLength = (int)(clockRadius * 0.75);
        int xHour = (int)(xCenter + hLength * Math.sin((hrs % 12 + min / 60.0) * (2 * Math.PI / 12)));
        int yHour = (int)(yCenter - hLength * Math.cos((hrs % 12 + min / 60.0) * (2 * Math.PI / 12)));
        g.setColor(Color.black);
        ((Graphics2D) g).setStroke(new BasicStroke(8));
        g.drawLine(xCenter, yCenter, xHour, yHour);

        //Draw Minutes hand
        int mLength = (int)(clockRadius * 0.95);
        int xMinute = (int)(xCenter + mLength * Math.sin(min * (2 * Math.PI / 60)));
        int yMinute = (int)(xCenter - mLength * Math.cos(min * (2 * Math.PI / 60)));
        g.setColor(Color.darkGray);
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.drawLine(xCenter, yCenter, xMinute, yMinute);

        g2D.setPaint(Color.black);
        g2D.fillOval(285, 285, 30, 30);

        //Draw Seconds hand
        int sLength = (int)(clockRadius * 1.0);
        int xSecond = (int)(xCenter + sLength * Math.sin(sec * (2 * Math.PI / 60)));
        int ySecond = (int)(yCenter - sLength * Math.cos(sec * (2 * Math.PI / 60)));
        g.setColor(Color.red);
        ((Graphics2D) g).setStroke(new BasicStroke(2));
        g.drawLine(xCenter, yCenter, xSecond, ySecond);

        // Draw circles
        g2D.setPaint(Color.black);
        g2D.fillOval(294, 294, 12, 12);
        g2D.setPaint(Color.red);
        g2D.setStroke(new BasicStroke(7));
        g2D.drawOval(294, 294, 12, 12);

        //Draw digital clock
        //((Graphics2D) g).setPaint(Color.black);
        //((Graphics2D) g).setStroke(new BasicStroke(2));
        //g.fillRect(200, 400, 200, 50);
        /*g.setColor(Color.red);
        g.setFont(new Font("Digital-7 Mono", Font.ITALIC, 40));
        DecimalFormat s = new DecimalFormat("00");
        g.drawString(s.format(getDay()) + ":" + s.format(getMonth()) + ":" + s.format(getYear()), xCenter - 75, yCenter - clockRadius + 378);*/

        // Draw date
        //((Graphics2D) g).setPaint(Color.white);
        //((Graphics2D) g).setStroke(new BasicStroke(2));
        //g.fillRect(175, 398, 260, 50);
        g.setColor(Color.black);
        g.setFont(new Font("Open Sans", Font.ITALIC, 40));
        SimpleDateFormat formatter= new SimpleDateFormat("dd MMM, yyyy");
        Date date = new Date(System.currentTimeMillis());
        g.drawString(formatter.format(date), xCenter - 115, yCenter - clockRadius + 378);
    }

    public void setCurrentTime() {
        Calendar calendar = new GregorianCalendar();

        this.hrs = calendar.get(Calendar.HOUR_OF_DAY);
        this.min = calendar.get(Calendar.MINUTE);
        this.sec = calendar.get(Calendar.SECOND);
        this.day = calendar.get((Calendar.DAY_OF_MONTH));
        this.month = calendar.get(Calendar.MONTH);
        this.year = calendar.get(Calendar.YEAR);
    }
}
