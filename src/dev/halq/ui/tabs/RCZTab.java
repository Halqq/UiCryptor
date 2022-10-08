package dev.halq.ui.tabs;

import dev.halq.utils.textEncrypt.EncryptRCZ;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Halq
 * @since 02/10/2022
 */

public class RCZTab extends JPanel {


    static JScrollPane scrollBar;

    public RCZTab() {
        renderGui();
    }


    JTextField textField = new JTextField(20);
    JTextArea textArea = new JTextArea(5, 20);

    String mode[]={"Encode", "Decode"};
    JComboBox comboBox = new JComboBox(mode);
    JButton button = new JButton("RCZ!");

    public void renderGui() {
        JPanel p1 = new JPanel();
        p1.add(textField);
        this.add(p1);

        JPanel p2 = new JPanel();
        p2.add(comboBox);
        this.add(p2);

        JPanel p3 = new JPanel();
        p3.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBox.getSelectedItem().equals("Encode")){
                    textArea.setText(EncryptRCZ.encryptRCZ(EncryptRCZ.ENCODE_MODE, textField.getText()));
                    System.out.println(EncryptRCZ.encryptRCZ(EncryptRCZ.ENCODE_MODE, textField.getText()));
                } else if(comboBox.getSelectedItem().equals("Decode")){
                    textArea.setText(EncryptRCZ.encryptRCZ(EncryptRCZ.DECODE_MODE, textField.getText()));
                    System.out.println(EncryptRCZ.encryptRCZ(EncryptRCZ.DECODE_MODE, textField.getText()));
                }
            }
        });

        this.add(p3);

        JPanel p4 = new JPanel();
        textArea.setEditable(false);
        p4.add(textArea);
        this.add(p4);
    }
    ;
}
