package dev.halq.ui.tabs;


import dev.halq.utils.blowFish.DecryptBlowFish;
import dev.halq.utils.blowFish.EncryptBlowFish;
import dev.halq.utils.blowFish.utils.ByteGenerator;
import dev.halq.utils.watermark.Watermark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * @author Halq
 * @since 02/10/2022
 */

public class BlowFishTab extends JPanel {

    static JLabel inputlabel;
    static JComboBox m;
    static JLabel outputlabel;
    static JButton files;
    static JButton files2;
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

    public BlowFishTab() {
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
        w = new JCheckBox("Watermark");
        String country[]={"64-bit","128-bit","256-bit"};
        m = new JComboBox(country);
        String value = m.getSelectedItem().toString();
        files = new JButton("...");
        files2 = new JButton("...");

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
        p2.add(files);
        inputlabel.setFont(font);
        this.add(p2);

        files.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NativeJFileChooser nfileChooser = new NativeJFileChooser(System.getProperty("user.home"));
                int option = nfileChooser.showOpenDialog(null);
                if (option == NativeJFileChooser.APPROVE_OPTION) {
                    File file = nfileChooser.getSelectedFile();
                    inputFile.setText(file.getAbsolutePath());

                }
            }

        });

        //outputFiles
        JTextField outputFile = new JTextField(20);
        p3.add(outputlabel);
        p3.add(outputFile);
        p3.add(files2);
        outputlabel.setFont(font);
        this.add(p3);

        files2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NativeJFileChooser nfileChooser = new NativeJFileChooser(System.getProperty("user.home"));
                int option = nfileChooser.showOpenDialog(null);
                if (option == NativeJFileChooser.APPROVE_OPTION) {
                    File file = nfileChooser.getSelectedFile();
                    outputFile.setText(file.getAbsolutePath());

                }
            }

        });

        //console area
        JTextArea textArea = new JTextArea(20, 40);

        textArea.setFont(font2);
        textArea.setEditable(false);

        //encrypty button
        JLabel espace = new JLabel("                                        ");
        p4.add(m);
        p4.add(espace);
        p4.add(b);
        p4.add(b2);
        this.add(p4);

        p8.add(w);
        this.add(p8);

        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("[UiCryptor] BlowFish " + "Encrypt file resource");

                if (!(inputFile.getText() == null && outputFile.getText() == null)) {

                    File inFile = new File(inputFile.getText());
                    File outFile = new File(outputFile.getText());

                    if (inFile.exists() && !outputFile.getText().isEmpty()) {

                        switch (value){

                            case "64-bit":
                                try{
                                    System.out.println("[UiCryptor] Blowfish " + "Encrypt file with 64-bit");
                                    EncryptBlowFish.encrypt(inFile, outFile, ByteGenerator.getByte64().getBytes());
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                                break;

                            case "128-bit":
                                try{
                                    System.out.println("[UiCryptor] Blowfish " + "Encrypt file with 128-bit");

                                    EncryptBlowFish.encrypt(inFile, outFile, ByteGenerator.getByte128().getBytes());
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                                break;

                            case "256-bit":
                                try{
                                    System.out.println("[UiCryptor] Blowfish " + "Encrypt file with 256-bit");
                                    EncryptBlowFish.encrypt(inFile, outFile, ByteGenerator.getByte256().getBytes());

                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                                break;

                        }

                            if(w.isSelected()) {
                                try {
                                    Watermark.addWattermark(outFile);
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }


                        System.out.println("[UiCryptor] BlowFish " + "Your file is encrypted!");

                    } else {
                        System.out.println("[UiCryptor] BlowFish " + "Please enter valid input and valid output");

                    }

                } else {
                    System.out.println("[UiCryptor] BlowFish " + "Please put values in all text fields");
                }
            }
        });

        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("[UiCryptor] BlowFish " + "Decrypt file resource");

                if (!(inputFile.getText() == null && outputFile.getText() == null)) {

                    File inFile = new File(inputFile.getText());
                    File outFile = new File(outputFile.getText());

                    if (inFile.exists() && !outputFile.getText().isEmpty()) {

                        try {
                            if (w.isSelected()) {
                                Watermark.remove(inFile);
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        switch (value){

                                case "64-bit":
                                    try{
                                        System.out.println("[UiCryptor] Blowfish " + "Encrypt file with 64-bit");
                                        DecryptBlowFish.decrypt(inFile, outFile, ByteGenerator.getByte64().getBytes());
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                    break;

                                case "128-bit":
                                    try{
                                        System.out.println("[UiCryptor] Blowfish " + "Encrypt file with 128-bit");
                                        DecryptBlowFish.decrypt(inFile, outFile, ByteGenerator.getByte128().getBytes());
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                    break;

                                case "256-bit":
                                    try{
                                        System.out.println("[UiCryptor] Blowfish " + "Encrypt file with 256-bit");
                                        DecryptBlowFish.decrypt(inFile, outFile, ByteGenerator.getByte256().getBytes());
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                    break;

                            }
                        System.out.println("[UiCryptor] BlowFish " + "Your file is decrypted!");

                    } else {
                        System.out.println("[UiCryptor] BlowFish " + "Please enter valid input and valid output");

                    }

                } else {
                    System.out.println("[UiCryptor] BlowFish " + "Please put values in all text fields");
                }
            }
        });

        name = new JLabel("\n" +
                "        " +
                "                    BlowFish File Transformation");
        this.add(name);
    }

}
