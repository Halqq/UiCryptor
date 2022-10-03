package dev.halq.ui.tabs;

import dev.halq.utils.aesCrypto.DecryptAES;
import dev.halq.utils.aesCrypto.EncryptAES;
import dev.halq.utils.aesCrypto.RandomKey;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @author Halq
 * @since 02/10/2022
 */

public class AESTab extends JPanel {

    static JLabel inputlabel;
    static JLabel outputlabel;
    static JLabel keyLabel;
    static JButton b;
    static JButton b2;
    static JButton b3;
    static JPanel p;
    static JPanel p2;
    static JPanel p3;
    static JPanel p4;
    static JPanel p5;
    static JPanel p6;
    static JPanel p7;
    static JLabel name;
    static JScrollPane scrollBar;

    public AESTab() {
        renderGui();
    }

    public void renderGui() {

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
        b3 = new JButton("Generate key");

        Font font = new Font("Ariel", Font.BOLD, 13);
        Font font2 = new Font("Ariel", Font.BOLD, 9);


        //buttons
        p4.add(b);
        p4.add(b2);
        p4.add(b3);
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

        //key text bar
        JTextField keyBar = new JTextField(10);
        p5.add(keyLabel);
        p5.add(keyBar);
        keyLabel.setFont(font);
        this.add(p5);

        //encrypty button
        p4.add(b);
        p4.add(b2);
        this.add(p4);

        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("[UiCryptor] AES " + "Encrypt file resource");


                if (!(inputFile.getText() == null && outputFile.getText() == null && keyBar.getText() == null)) {

                    File inFile = new File(inputFile.getText());
                    File outFile = new File(outputFile.getText());
                    String key = keyBar.getText();

                    if (inFile.exists() && !outputFile.getText().isEmpty()) {

                        try {
                            EncryptAES.encrypt(key, inFile, outFile);

                        } catch (IOException | NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException | InvalidKeyException ex) {
                            ex.printStackTrace();
                            System.out.println(e);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }

                        System.out.println("[UiCryptor] AES " + "Your file is encrypted!");

                    } else {
                        System.out.println("[UiCryptor] AES " + "Please enter valid input and valid output");

                    }

                } else {
                    System.out.println("[UiCryptor] AES " + "Please put values in all text fields");
                }
            }
        });


        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("[UiCryptor] AES " + "Decrypt file resource");


                if (!(inputFile.getText() == null && outputFile.getText() == null && keyBar.getText() == null)) {

                    File inFile = new File(inputFile.getText());
                    File outFile = new File(outputFile.getText());
                    String key = keyBar.getText();

                    if (inFile.exists() && !outputFile.getText().isEmpty()) {

                        try {
                            DecryptAES.encrypt(key, inFile, outFile);

                        } catch (IOException | NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException | InvalidKeyException ex) {
                            ex.printStackTrace();
                            System.out.println(e);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }

                        System.out.println("[UiCryptor] AES " + "Your file is decrypted!");

                    } else {
                        System.out.println("[UiCryptor] AES " + "Please enter valid input and valid output");

                    }

                } else {
                    System.out.println("[UiCryptor] AES " + "Please put values in all text fields");
                }
            }
        });

        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Random r = new Random();
                int randomitem = r.nextInt(RandomKey.getRandomKeys().size());
                String randomKey = RandomKey.getRandomKeys().get(randomitem);

                keyBar.setText(randomKey);
            }
        });

        name = new JLabel("\n" +
                "AES File Transformation");
        this.add(name);
    }


}
