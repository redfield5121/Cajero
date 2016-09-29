package cajero2;

/**
 *
 * @author alfredoerick
 */
import cajero2.Retiro;
import cajero2.Consulta;
import cajero2.Traspaso;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Inicio extends JFrame implements ActionListener {

    JButton consulta, traspaso, retiro;
    double saldo = 0;
    JFrame ventana = new JFrame();

    public Inicio(double Saldo) {
        super();
        this.saldo = Saldo;
        ventana.setSize(200,200);
        ventana.setTitle("Cajero");
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setVisible(true);
        
        
        
        addComponentsToPane(ventana.getContentPane());
 
        
        ventana.setVisible(true);
        
        

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Retiro")) {
            dispose();
            Retiro a = new Retiro(this.saldo);
        } else if (e.getActionCommand().equals("Consulta")) {
            JOptionPane.showMessageDialog(null, "su saldo actual es de: " + saldo);
        } else if (e.getActionCommand().equals("Traspaso")) {
            dispose();
            Traspaso c = new Traspaso(this.saldo);
        }
    }
    
    public  void addComponentsToPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
 
        addAButton("Consulta", pane);
        addAButton("Retiro", pane);
        addAButton("Traspaso", pane);
        
    }
 
    private  void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setSize(100, 200);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
        button.addActionListener(this);
    }
}
