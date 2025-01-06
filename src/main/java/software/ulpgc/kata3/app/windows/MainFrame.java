package software.ulpgc.kata3.app.windows;

import software.ulpgc.kata3.architecture.control.Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends javax.swing.JFrame {
    private final Map<String, Command> commands;
    private JFreeChartDisplay display;

    public MainFrame() {
        this.setTitle("Kata3");
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(BorderLayout.NORTH, menu());
        this.add(display = new JFreeChartDisplay());
        commands = new HashMap<>();
    }

    public Command put(String key, Command value) {
        return commands.put(key, value);
    }

    public JFreeChartDisplay getDisplay() {
        return display;
    }

    private Component menu() {
        JPanel panel = new JPanel();
        panel.add(toggle());
        return panel;
    }

    private Component toggle() {
        JButton button = new JButton("Toggle");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {commands.get("toggle").execute();}
        });
        return button;
    }
}
