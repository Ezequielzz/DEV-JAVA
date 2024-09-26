package com.br.ezequielzz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinhaJanela extends JFrame {

    public MinhaJanela() {
        super("Exemplo Swing");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);

        JPanel painel = new JPanel();
        this.add(painel);

        JButton botao = new JButton("Botao");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Botao clicado");
            }
        });

        this.setVisible(true);

    }


}
