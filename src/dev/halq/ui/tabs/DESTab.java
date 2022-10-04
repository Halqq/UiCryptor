package dev.halq.ui.tabs;

import dev.halq.utils.desCrypto.DecryptDES;
import dev.halq.utils.desCrypto.EncryptDES;
import dev.halq.utils.wattermark.Wattermark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static javafx.scene.input.KeyCode.J;

/**
 * @author Halq
 * @since 02/10/2022
 */

public class DESTab extends JPanel {

    static JLabel inputlabel;
    static JLabel outputlabel;
    static JCheckBox w;
    static JButton b;
    static JButton b2;
    static JPanel p;
    static JPanel p2;
    static JPanel p3;
    static JPanel p4;
    static JPanel p5;
    static JPanel p6;
    static JPanel p7;
    static JPanel p8;
    static JLabel name;
    static JScrollPane scrollBar;

    public DESTab() {
        renderGui();
    }

    public void renderGui() {

        inputlabel = new JLabel("Input file");

        outputlabel = new JLabel("Output file");

        p = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();
        p7 = new JPanel();
        p8 = new JPanel();
        b = new JButton("Encrypt");
        b2 = new JButton("Decrypt");
        w = new JCheckBox("Wattermark");

        Font font = new Font("Ariel", Font.BOLD, 13);
        Font font2 = new Font("Ariel", Font.BOLD, 9);

        //buttons
        p4.add(b);
        p4.add(b2);
        this.add(p4);

        //input files
        JTextField inputFile = new JTextField(20);
        p2.add(inputlabel);
        p2.add(inputFile);
        inputlabel.setFont(font);
        this.add(p2);

        //outputFiles
        JTextField outputFile = new JTextField(20);
        p3.add(outputlabel);
        p3.add(outputFile);
        outputlabel.setFont(font);
        this.add(p3);

        //console area
        JTextArea textArea = new JTextArea(20, 40);

        textArea.setFont(font2);
        textArea.setEditable(false);

        //encrypty button
        JLabel espace = new JLabel("                                             ");
        p4.add(espace);
        p4.add(b);
        p4.add(b2);
        this.add(p4);

        p8.add(w);
        this.add(p8);

        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("[UiCryptor] DES " + "Encrypt file resource");

                if (!(inputFile.getText() == null && outputFile.getText() == null)) {

                    File inFile = new File(inputFile.getText());
                    File outFile = new File(outputFile.getText());

                    if (inFile.exists() && !outputFile.getText().isEmpty()) {

                        try {
                            EncryptDES.encrypt(inFile, outFile);

                            if(w.isSelected()) {
                                Wattermark.addWattermark(outFile);
                            }

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                        System.out.println("[UiCryptor] DES " + "Your file is encrypted!");

                    } else {
                        System.out.println("[UiCryptor] DES " + "Please enter valid input and valid output");

                    }

                } else {
                    System.out.println("[UiCryptor] DES " + "Please put values in all text fields");
                }
            }
        });

        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("[UiCryptor] DES " + "Decrypt file resource");

                if (!(inputFile.getText() == null && outputFile.getText() == null)) {

                    File inFile = new File(inputFile.getText());
                    File outFile = new File(outputFile.getText());

                    if (inFile.exists() && !outputFile.getText().isEmpty()) {

                        try {
                            if(w.isSelected()) {
                                Wattermark.remove(inFile);
                            }
                            DecryptDES.decrypt(inFile, outFile);

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                        System.out.println("[UiCryptor] DES " + "Your file is decrypted!");

                    } else {
                        System.out.println("[UiCryptor] DES " + "Please enter valid input and valid output");

                    }

                } else {
                    System.out.println("[UiCryptor] DES " + "Please put values in all text fields");
                }
            }
        });

        name = new JLabel("\n" +
                "        " +
                "                         DES File Transformation");
        this.add(name);
    }

}
