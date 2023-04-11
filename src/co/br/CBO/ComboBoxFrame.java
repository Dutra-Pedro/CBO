package co.br.CBO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComboBoxFrame extends JFrame{
    private JComboBox cboGif;
    private JLabel label;
    private String names[] = {"bug1.gif", "bug2.gif", "buganim.gif", "travelbug.gif"};

    private Icon icons[] = {
            new ImageIcon(getClass().getResource(names[0])),
            new ImageIcon(getClass().getResource(names[1])),
            new ImageIcon(getClass().getResource(names[2])),
            new ImageIcon(getClass().getResource(names[3]))
    };

    public ComboBoxFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,300,100);
        setLayout(new FlowLayout());
        cboGif = new JComboBox(names);
        cboGif.setMaximumRowCount(4);
        cboGif.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED)
                    label.setIcon(icons[cboGif.getSelectedIndex()]);
            }
        });

        label = new JLabel(icons[0]);
        add(cboGif);
        add(label);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ComboBoxFrame frame = new ComboBoxFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}