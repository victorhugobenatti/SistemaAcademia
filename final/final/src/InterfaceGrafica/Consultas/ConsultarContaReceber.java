package InterfaceGrafica.Consultas;

import Classes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConsultarContaReceber extends JFrame {
    JComboBox<ContaReceber> consulta = new JComboBox<>();
    JLabel txt1 = new JLabel();
    JLabel txt2 = new JLabel();
    JButton btn1 = new JButton();
    private static ContaReceber item_selecionado;

    public ConsultarContaReceber(){
        setTitle("Consulta de Contas à Receber");
        setVisible(true);
        setSize(800, 500);
        setResizable(false);
        setLocationRelativeTo(null);

        setLayout(null);

        JLabel titulo = new JLabel("Consulta de Contas à Receber");
        titulo.setBounds(330, 20, 250, 50);
        titulo.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        add(titulo);

        //Botão de seleção do objeto a ser consultado---------
        consulta.setBounds(20, 100, 300, 20);
        for(ContaReceber contaReceber : App.ContasReceber ){
            consulta.addItem(contaReceber);
        }
        add(consulta);

        //Botão de confirmação do objeto---------
        btn1.setText("Confirma");
        btn1.setBounds(330,100,100,20);
        btn1.setBackground(new Color(100, 100, 100));
        btn1.setForeground(new Color(255,255,255));
        add(btn1);
        btn1.addActionListener(this::btn1);

        //Textos que aparecem na consulta
        add(txt1);
        add(txt2);
    }

    public void btn1(ActionEvent ActionEvent){
        try {
            item_selecionado = (ContaReceber) consulta.getSelectedItem();

            txt1.setBounds(20, 130, 700, 20);
            txt1.setText("Nome: " + item_selecionado.getObs());

            txt2.setBounds(20, 160, 700, 20);
            txt2.setText("Valor: " + item_selecionado.getValor());
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Nenhum item selecionado!");
        }
    }
}