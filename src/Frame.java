import javax.swing.*;

public class Frame extends JFrame {

    Panel panel;

    Frame() {
        panel = new Panel();
        //this.setUndecorated(true);
        //this.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setTitle("Guliver Clock by Darko Jelic");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        while(true) {
            Panel clock = new Panel();
            this.getContentPane().add(clock);
            this.validate();
            try {
                Thread.sleep(1000);

            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            clock.setVisible(false);
            this.remove(clock);
            clock = null;
            this.validate();
        }
    }
}
