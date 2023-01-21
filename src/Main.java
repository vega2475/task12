public class Main {
    public static void winMain() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiForm().setVisible(true);
            }
        });
    }


    public static void main(String[] args) throws Exception {
        winMain();
    }
}
