	
	package com.mycompany.encounter;
	
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	
	public class EnCounter extends JFrame {
	    private JTextArea textArea;
	    private JLabel charCountLabel, wordCountLabel, sentenceCountLabel;
	
	    public EnCounter() {
	        setTitle("En-Counter");
	        setSize(600, 400);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	
	        JTabbedPane tabs = new JTabbedPane();
	
	        // Tab 1: Text Counter
	        JPanel textCounterPanel = createTextCounterTab();
	        tabs.addTab("📄 Text Counter", textCounterPanel);
	
	        // Placeholder tabs for Summary and Settings
	        tabs.addTab("ℹ️Summary", createAboutTab());
	        tabs.addTab("⚙️Settings", new JPanel());
	
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
	
	        countBtn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                countText();
	            }
	        });
	
	        clearBtn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                textArea.setText("");
	            }
	        });
	
	        buttonPanel.add(countBtn);
	        buttonPanel.add(clearBtn);
	        panel.add(buttonPanel, BorderLayout.NORTH);
	
	        return panel;
	    }
	
	    private JPanel createAboutTab() {
	        JPanel panel = new JPanel(new BorderLayout());
	
	        JTextArea aboutText = new JTextArea(
	            "En-Counter v1.0\n\n" +
	            "Developed by J. Roy Chowdhury\n" +
	            "Employee of wipro\n" +
	            "Specially Built for Facets Structure and Billing Install team\n\n" +
	            "En-Counter is a lightweight internal tool designed to help users count\n" +
	            "characters, words, and sentences in a given text input efficiently.\n\n" +
	            "Built using Java Programming.\n\n" +
	            "For feedback or support, contact: Your Manager"
	        );
	        aboutText.setEditable(false);
	        aboutText.setFont(new Font("Arial", Font.PLAIN, 14));
	        aboutText.setBackground(UIManager.getColor("Panel.background"));
	        aboutText.setLineWrap(true);
	        aboutText.setWrapStyleWord(true);
	
	        panel.add(aboutText, BorderLayout.CENTER);
	        return panel;
	    }
	
	    private void countText() {
	        String text = textArea.getText();
	        int charCount = text.length();
	        int wordCount = text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;
	        int sentenceCount = text.trim().isEmpty() ? 0 : text.split("[.!?]+").length;
	
	        charCountLabel.setText("Characters: " + charCount);
	        wordCountLabel.setText("Words: " + wordCount);
	        sentenceCountLabel.setText("Sentences: " + sentenceCount);
	    }
	
	    public static void main(String[] args) {
	    	System.setProperty("sun.java2d.uiScale", "1.0");

	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                new EnCounter();
	            }
	        });
	    }
	}
	
