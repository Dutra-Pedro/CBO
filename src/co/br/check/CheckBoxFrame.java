package co.br.check;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxFrame extends JFrame{
    private JCheckBox boldJCheckBox;
    private JCheckBox italicJCheckBox;
    private JTextField textField;



    public CheckBoxFrame(){
        setLayout(new FlowLayout());
        textField = new JTextField("Veja o estilo da fonte mudar", 20);
        textField.setFont(new Font("Serif",Font.PLAIN, 14));
        add(textField);

        boldJCheckBox = new JCheckBox("Negrito");
        italicJCheckBox = new JCheckBox("Italico");

        add(boldJCheckBox);
        add(italicJCheckBox);

        CheckBoxHandler handler = new CheckBoxHandler();
        boldJCheckBox.addItemListener(handler);
        italicJCheckBox.addItemListener(handler);
    }
    private class CheckBoxHandler implements ItemListener {
        private int valBold = Font.PLAIN;
        private int valItalic = Font.PLAIN;

        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == boldJCheckBox)
                valBold = boldJCheckBox.isSelected() ? Font.BOLD : Font.PLAIN;
            if (e.getSource() == italicJCheckBox)
                valItalic = italicJCheckBox.isSelected() ? Font.ITALIC : Font.PLAIN;

            textField.setFont(new Font("Serif", valBold + valItalic, 14));
        }
    }

        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                        CheckBoxFrame frame = new CheckBoxFrame();
                        frame.setVisible(true);
                }
            });
        }


}
