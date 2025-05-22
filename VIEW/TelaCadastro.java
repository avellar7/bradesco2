package domain.VIEW;

import javax.swing.*;
import java.awt.*;

public class TelaCadastro extends JFrame {
    private JTextField txtNome, txtCPF, txtEmail, txtTelefone;
    private JButton btnEnviar, btnLimpar, btnFechar;

    public TelaCadastro() {
        setTitle("AntiGolpes BC");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 420);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel principal com fundo cinza claro
        JPanel panel = new JPanel();
        panel.setBackground(new Color(230, 230, 230));
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Fonte e cores
        Font fonte = new Font("Segoe UI", Font.PLAIN, 14);

        JLabel lblNome = new JLabel("Nome:");
        JLabel lblCPF = new JLabel("CPF:");
        JLabel lblEmail = new JLabel("E-mail:");
        JLabel lblTelefone = new JLabel("Telefone:");

        for (JLabel lbl : new JLabel[]{lblNome, lblCPF, lblEmail, lblTelefone}) {
            lbl.setForeground(Color.BLACK);
            lbl.setFont(fonte);
        }

        txtNome = new JTextField(20);
        txtCPF = new JTextField(20);
        txtEmail = new JTextField(20);
        txtTelefone = new JTextField(20);

        btnEnviar = new JButton("Enviar");
        btnLimpar = new JButton("Limpar");
        btnFechar = new JButton("Fechar");

        // Estilo padrão, sem borda branca personalizada
        Font fonteBotao = new Font("Segoe UI", Font.BOLD, 13);
        btnEnviar.setFont(fonteBotao);
        btnLimpar.setFont(fonteBotao);
        btnFechar.setFont(fonteBotao);

        // Adicionando componentes
        gbc.gridx = 0; gbc.gridy = 0; panel.add(lblNome, gbc);
        gbc.gridx = 1; panel.add(txtNome, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panel.add(lblCPF, gbc);
        gbc.gridx = 1; panel.add(txtCPF, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panel.add(lblEmail, gbc);
        gbc.gridx = 1; panel.add(txtEmail, gbc);

        gbc.gridx = 0; gbc.gridy = 3; panel.add(lblTelefone, gbc);
        gbc.gridx = 1; panel.add(txtTelefone, gbc);

        gbc.gridx = 0; gbc.gridy = 4; panel.add(btnLimpar, gbc);
        gbc.gridx = 1; panel.add(btnEnviar, gbc);

        add(panel, BorderLayout.CENTER);
        add(btnFechar, BorderLayout.SOUTH);

        // Ações
        btnEnviar.addActionListener(e -> enviarDados());
        btnLimpar.addActionListener(e -> limparCampos());
        btnFechar.addActionListener(e -> dispose());
    }

    private void enviarDados() {
        if (txtNome.getText().isEmpty() || txtCPF.getText().isEmpty()
                || txtEmail.getText().isEmpty() || txtTelefone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "<html><body style='font-size:12px;'>Dados enviados com sucesso!</body></html>",
                    "<html><span style='color:gold; font-weight:bold;'>Sucesso</span></html>",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtCPF.setText("");
        txtEmail.setText("");
        txtTelefone.setText("");
    }

    public static void main(String[] args) {
        try {
            // Estilo Metal do Java
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new TelaCadastro().setVisible(true);
        });
    }
}


