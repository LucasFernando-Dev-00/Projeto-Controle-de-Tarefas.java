package application;

import java.util.List;

import entities.Tarefa;
import service.TarefasRepositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;

public class TelaTarefas extends JFrame {

    private TarefasRepositorio repo;

    private JTable tabela;
    private DefaultTableModel modelo;
    private JTextField txtId, txtTitulo, txtStatus;
    private JButton btnSalvar, btnDeletar, btnAtualizar, btnLimpar;

    public TelaTarefas(TarefasRepositorio repo) {
        this.repo = repo;
        configurarJanela();
        inicializarComponentes();
        configurarEventos();
        listarTarefas();
    }

    private void configurarJanela() {
        setTitle("Gerenciador de Tarefas:");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
    }

    private void inicializarComponentes() {
        JPanel painelEntrada = new JPanel(new GridLayout(3, 2, 5, 5));
        painelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txtId = new JTextField();
        txtId.setEditable(false);
        txtTitulo = new JTextField();
        txtStatus = new JTextField();

        painelEntrada.add(new JLabel("ID (selecionado):"));
        painelEntrada.add(txtId);
        painelEntrada.add(new JLabel("Título:"));
        painelEntrada.add(txtTitulo);
        painelEntrada.add(new JLabel("Status:"));
        painelEntrada.add(txtStatus);

        add(painelEntrada, BorderLayout.NORTH);

        modelo = new DefaultTableModel(new Object[]{"ID", "Título", "Status", "Data"}, 0);
        tabela = new JTable(modelo);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        btnSalvar = new JButton("Salvar Novo");
        btnAtualizar = new JButton("Atualizar Selecionado");
        btnDeletar = new JButton("Deletar");
        btnLimpar = new JButton("Limpar Compos");

        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnAtualizar);
        painelBotoes.add(btnDeletar);
        painelBotoes.add(btnLimpar);

        add(painelBotoes, BorderLayout.SOUTH);
    }

    private void configurarEventos() {

        btnSalvar.addActionListener(e -> {
            Tarefa t = new Tarefa(null, txtTitulo.getText(), txtStatus.getText(), LocalDate.now());
            repo.salvar(t);
            listarTarefas();
            limparCampos();
        });

        btnDeletar.addActionListener(e -> {
            int linha = tabela.getSelectedRow();
            if (linha != -1) {
                int id = (int) modelo.getValueAt(linha, 0);
                repo.deletar(id);
                listarTarefas();
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma tarefa na tabela!");
            }
        });

        tabela.getSelectionModel().addListSelectionListener(e -> {
            int linha = tabela.getSelectedRow();
            if (linha != -1) {
                txtId.setText(modelo.getValueAt(linha, 0).toString());
                txtTitulo.setText(modelo.getValueAt(linha, 1).toString());
                txtStatus.setText(modelo.getValueAt(linha, 1).toString());
            }
        });

        btnAtualizar.addActionListener(e -> {
            if (!txtId.getText().isEmpty()) {
                Tarefa t = new Tarefa(
                        Integer.parseInt(txtId.getText()),
                        txtTitulo.getText(),
                        txtStatus.getText(),
                        LocalDate.now()
                );
                repo.atualizar(t);
                listarTarefas();
            }
        });
    }

    private void listarTarefas() {
        modelo.setRowCount(0);
        List<Tarefa> lista = repo.selecionarLista();
        for (Tarefa t : lista) {
            modelo.addRow(new Object[]{t.getId(), t.getTitulo(), t.getStatus(), t.getData()});
        }
    }


    private void limparCampos() {
        txtId.setText("");
        txtTitulo.setText("");
        txtStatus.setText("");
    }
}
