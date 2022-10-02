package dev.halq.ui;

import com.formdev.flatlaf.FlatDarculaLaf;
import dev.halq.Main;
import dev.halq.utils.cryptoUtil.Decrypt;
import dev.halq.utils.cryptoUtil.Encrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Halq
 * @since 02/10/2022
 */

public class UiMain {

    static JFrame j;
    static JLabel inputlabel;
    static JLabel outputlabel;
    static JLabel keyLabel;
    static JButton b;
    static JButton b2;
    static JPanel p;
    static JPanel p2;
    static JPanel p3;
    static JPanel p4;
    static JPanel p5;
    static JPanel p6;
    static JPanel p7;
    static JScrollPane scrollBar;

    public static void renderGui() {

        FlatDarculaLaf.setup();

        j = new JFrame("UiCryptor " + Main.version);

        inputlabel = new JLabel("Input file");

        outputlabel = new JLabel("Output file");

        keyLabel = new JLabel("Key");

        p = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();
        p7 = new JPanel();
        b = new JButton("Encrypt");
        b2 = new JButton("Decrypt");

        Font font = new Font("Ariel", Font.BOLD, 13);

        //key text bar
        JTextField keyBar = new JTextField(10);
        p5.add(keyBar);
        p5.setBounds(-50, 315, 750, 100);
        p5.add(keyLabel);
        keyLabel.setFont(font);
        j.add(p5);



        //console area
        JTextArea textArea = new JTextArea(20, 40);

        textArea.setFont(font);
        textArea.setEditable(false);

        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                textArea.append(String.valueOf((char) b));
            }
        };

        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(out));

        p6.add(textArea);
        p6.setBounds(-50, 115, 900, 160);

        JScrollPane scroll = new JScrollPane (textArea );
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBounds(80, 115, 500, 160);

        j.add( scroll );

        j.add(p6);

        //encrypty button
        p4.add(b);
        p4.add(b2);
        p4.setBounds(-60, 440, 750, 100);
        j.add(p4);

        //outputFiles
        JTextField outputFile = new JTextField(20);
        p3.add(outputFile);
        p3.setBounds(-200, 30, 750, 100);
        p3.add(outputlabel);
        outputlabel.setFont(font);
        j.add(p3);

        //input files
        JTextField inputFile = new JTextField(20);
        p2.add(inputFile);
        p2.setBounds(-204, -2, 750, 100);
        p2.add(inputlabel);
        inputlabel.setFont(font);
        j.add(p2);

        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("[UiCryptor] " + "Encrypt file resource");


                if (!(inputFile.getText() == null && outputFile.getText() == null && keyBar.getText() == null)) {

                    File inFile = new File(inputFile.getText());
                    File outFile = new File(outputFile.getText());
                    String key = keyBar.getText();

                    if (inFile.exists() && !outputFile.getText().isEmpty()) {

                        try {
                            Encrypt.encrypt(key, inFile, outFile);

                        } catch (IOException | NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException | InvalidKeyException ex) {
                            ex.printStackTrace();
                            System.out.println(e);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }

                        System.out.println("[UiCryptor] " + "Your file is encrypted!");

                    } else {
                        System.out.println("[UiCryptor] " + "Please enter valid input and valid output");

                    }

                } else {
                    System.out.println("[UiCryptor] " + "Please put values in all text fields");
                }
            }
        });

        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("[UiCryptor] " + "Decrypt file resource");


                if (!(inputFile.getText() == null && outputFile.getText() == null && keyBar.getText() == null)) {

                    File inFile = new File(inputFile.getText());
                    File outFile = new File(outputFile.getText());
                    String key = keyBar.getText();

                    if (inFile.exists() && !outputFile.getText().isEmpty()) {

                        try {
                            Decrypt.encrypt(key, inFile, outFile);

                        } catch (IOException | NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException | InvalidKeyException ex) {
                            ex.printStackTrace();
                            System.out.println(e);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }

                        System.out.println("[UiCryptor] " + "Your file is decrypted!");

                    } else {
                        System.out.println("[UiCryptor] " + "Please enter valid input and valid output");

                    }

                } else {
                    System.out.println("[UiCryptor] " + "Please put values in all text fields");
                }
            }
        });


        p.setPreferredSize(new Dimension(640, 480));
        j.add(p, BorderLayout.CENTER);
        j.setLocation(150, 100);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setResizable(false);
        j.pack();

        j.setVisible(true);
        System.out.println("[UiCryptor] " + "Loaded GUI");

    }
}
