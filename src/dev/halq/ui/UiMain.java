package dev.halq.ui;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import dev.halq.Main;
import dev.halq.ui.tabs.AESTab;
import dev.halq.ui.tabs.DESTab;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class UiMain {

    public static void main(){

        FlatDarkPurpleIJTheme.setup();



        System.out.println("Loading gui");
        System.out.println("================================================================");
        System.out.println("Loading Library");

        JFrame j = new JFrame("UiCryptor " + Main.version);
        JTabbedPane p = new JTabbedPane();
        JPanel p6 = new JPanel();
        Font font2 = new Font("Ariel", Font.BOLD, 9);

        System.out.println("Loading fonts");
        String message = "Hi user! if you are having difficulties with UiEncryptor you can contact me on discord! HALSS#5072," + "\n" +
                " and please look at our github https://github.com/Halqq/UiCryptor";


        JOptionPane.showMessageDialog(j, message, "Alert", JOptionPane.PLAIN_MESSAGE, UIManager.getIcon("OptionPane.errorIcon"));

        JTextArea textArea = new JTextArea(20, 40);

        textArea.setFont(font2);
        textArea.setEditable(false);

        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                textArea.append(String.valueOf((char) b));
            }
        };

        System.out.println("Loading console");

        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(out));

        p6.add(textArea);
        p6.setBounds(-50, 115, 900, 160);

        JScrollPane scroll = new JScrollPane (textArea );
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBounds(80, 115, 500, 160);

        j.add( scroll );

        System.out.println("Loading scroll");

        j.add(p6);

        p.add("AES", new AESTab());
        System.out.println("Loaded AES tab");
        p.add("DES", new DESTab());
        System.out.println("Loaded DES tab");

        p.setPreferredSize(new Dimension(640, 300));
        j.add(p, BorderLayout.CENTER);
        j.setLocation(150, 100);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setResizable(false);
        j.pack();

        j.setVisible(true);
    }
}
