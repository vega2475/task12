public class Main {
    public static void winMain() {
        Util.setDefaultFont("Microsoft Sans Serif", 18);

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
