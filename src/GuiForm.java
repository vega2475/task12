import javax.swing.*;

public class GuiForm extends JFrame {
    private JTextField inputPath;
    private JButton Button;
    private JTextArea output;
    private JPanel panelMain;








    public GuiForm() {
        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        Button.addActionListener(e -> {
            try {
                JOptionPane.showMessageDialog(null, "В выводе папки заключены в квадратные скобки [], а файлы просто");
                String pathToDir = inputPath.getText();
                ParseFromConsole ps = new ParseFromConsole(System.out);
                System.setOut(ps);
                Solution.solve(pathToDir);
                output.setText(ps.getAllWrittenText().toString());
            }
            catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Некорректные данные", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });


    }

}
