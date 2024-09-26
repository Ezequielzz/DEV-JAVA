package com.br.ezequielzz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraAvancada extends JFrame {
    private JTextField displaySimples, displayCientifica;

    public CalculadoraAvancada() {
        setTitle("Calculadora Avançada");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criação das abas
        JTabbedPane tabbedPane = new JTabbedPane();

        // Aba "Calculadora Simples"
        JPanel panelSimples = criarCalculadoraSimples();
        tabbedPane.addTab("Calculadora Simples", panelSimples);

        // Aba "Calculadora Científica"
        JPanel panelCientifica = criarCalculadoraCientifica();
        tabbedPane.addTab("Calculadora Científica", panelCientifica);

        add(tabbedPane);
    }

    private JPanel criarCalculadoraSimples() {
        JPanel panel = new JPanel(new BorderLayout());
        displaySimples = new JTextField();
        displaySimples.setEditable(false);
        panel.add(displaySimples, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel(new GridLayout(4, 4));
        // Adicionar botões 0-9 e operações básicas (+, -, *, /, =)
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "=", "+", "C"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(new SimpleCalcActionListener());
            buttonsPanel.add(button);
        }

        panel.add(buttonsPanel, BorderLayout.CENTER);
        return panel;
    }

    private JPanel criarCalculadoraCientifica() {
        JPanel panel = new JPanel(new BorderLayout());
        displayCientifica = new JTextField();
        displayCientifica.setEditable(false);
        panel.add(displayCientifica, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel(new GridLayout(2, 2));
        // Adicionar botões para operações científicas
        String[] buttons = {"^", "√", "log", "C"};

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(new ScientificCalcActionListener());
            buttonsPanel.add(button);
        }

        panel.add(buttonsPanel, BorderLayout.CENTER);
        return panel;
    }

    // Listeners para as ações dos botões
    private class SimpleCalcActionListener implements ActionListener {
        private double num1 = 0;
        private double num2 = 0;
        private String operator = "";

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
                displaySimples.setText(displaySimples.getText() + command);
            } else if (command.equals("C")) {
                displaySimples.setText("");
                num1 = num2 = 0;
                operator = "";
            } else if (command.equals("=")) {
                num2 = Double.parseDouble(displaySimples.getText());
                switch (operator) {
                    case "+": displaySimples.setText(Double.toString(num1 + num2)); break;
                    case "-": displaySimples.setText(Double.toString(num1 - num2)); break;
                    case "*": displaySimples.setText(Double.toString(num1 * num2)); break;
                    case "/": displaySimples.setText(Double.toString(num1 / num2)); break;
                }
            } else {
                operator = command;
                num1 = Double.parseDouble(displaySimples.getText());
                displaySimples.setText("");
            }
        }
    }

    private class ScientificCalcActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            double num = Double.parseDouble(displayCientifica.getText());

            switch (command) {
                case "^":
                    num = Math.pow(num, 2);
                    displayCientifica.setText(Double.toString(num));
                    break;
                case "√":
                    num = Math.sqrt(num);
                    displayCientifica.setText(Double.toString(num));
                    break;
                case "log":
                    num = Math.log(num);
                    displayCientifica.setText(Double.toString(num));
                    break;
                case "C":
                    displayCientifica.setText("");
                    break;
            }
        }
    }
}

