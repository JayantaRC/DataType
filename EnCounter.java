package com.mycompany.encounter;

import javax.swing.*;
import java.awt.*;
 
public class EnCounter extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
    private JLabel charCountLabel, wordCountLabel, sentenceCountLabel;
 
    public EnCounter() {
        setTitle("En-Counter");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //Set custom window icon
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/icon.png"));
        setIconImage(icon.getImage());
 
        // Create and add tabbed pane
        JTabbedPane tabs = new JTabbedPane();
 
        // Tab 1: Text Counter
        JPanel textCounterPanel = createTextCounterTab();
        tabs.addTab("📄 Text Counter", textCounterPanel);
 
        // Placeholder tabs for Stats and Settings
        tabs.addTab("📊 Stats", new JPanel());
        tabs.addTab("⚙️ Settings", new JPanel());
 
        add(tabs);
        setVisible(true);
    }
 
    private JPanel createTextCounterTab() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
 
        // Text Area
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);
 
        // Info Panel (counts)
        JPanel infoPanel = new JPanel(new GridLayout(1, 3));
        charCountLabel = new JLabel("Characters: 0");
        wordCountLabel = new JLabel("Words: 0");
        sentenceCountLabel = new JLabel("Sentences: 0");
        infoPanel.add(charCountLabel);
        infoPanel.add(wordCountLabel);
        infoPanel.add(sentenceCountLabel);
        panel.add(infoPanel, BorderLayout.SOUTH);
 
        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton countBtn = new JButton("Generate");
        JButton clearBtn = new JButton("Clear");
 
        countBtn.addActionListener(e -> countText());
        clearBtn.addActionListener(e -> textArea.setText(""));
 
        buttonPanel.add(countBtn);
        buttonPanel.add(clearBtn);
        panel.add(buttonPanel, BorderLayout.NORTH);
 
        return panel;
    }
 
    private void countText() {
        String text = textArea.getText();
        int charCount = text.length();
        int wordCount = text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;
        int sentenceCount = text.split("[.!?]+").length;
 
        charCountLabel.setText("Characters: " + charCount);
        wordCountLabel.setText("Words: " + wordCount);
        sentenceCountLabel.setText("Sentences: " + sentenceCount);
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(EnCounter::new);
    }
}