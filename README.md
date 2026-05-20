📑 Controle de Tarefas

Aplicação Desktop desenvolvida em Java com interface gráfica (Swing) para gerenciamento dinâmico de atividades diárias. O sistema realiza operações completas de CRUD persistidas em banco de dados via JDBC, permitindo acompanhar o status de execução ("Fazer" / "Feito") e a data de criação de cada tarefa.

🚀 Sobre o Projeto

Este projeto foi desenvolvido com o objetivo de consolidar os conceitos de desenvolvimento de interfaces de usuário (GUI) e persistência de dados no ecossistema Java SE. A aplicação oferece uma experiência visual para que o usuário controle suas obrigações cotidianas de forma simples e intuitiva, com dados armazenados de forma persistente.

📂 Controle-de-Tarefas


└── 📂 src

    ├── 📂 application
    │   ├── ☕ Programa (Execução/Testes gerais)
    │   ├── ☕ ProgramaInterface (Classe principal que inicializa a GUI)
    │   └── ☕ TelaTarefas (Interface gráfica desenvolvida em Swing)
    │
    ├── 📂 entities
    │   └── ☕ Tarefa (Classe de domínio com id, descricao, status e data)
    │
    ├── 📂 repository
    │   └── ☕ DbBanco (Responsável pela conexão e configuração com o Banco de Dados)
    │
    └── 📂 service
        └── ☕ TarefasRepositorio (Gerencia o CRUD e executa as queries JDBC na tabela)
        
## 🖥️ Interface do Sistema

A interface foi projetada utilizando componentes nativos do Java Swing (`JFrame`, `JTable`, `JTextField` e `JButton`), oferecendo uma usabilidade simples:
1. **Seleção Inteligente:** Ao clicar em qualquer tarefa da tabela, os campos de ID, Título e Status são preenchidos automaticamente no topo.
2. **Atualização Dinâmica:** Permite alterar o status (ex: de "A fazer" para "Feito") e salvar as alterações diretamente na base de dados através do botão *Atualizar Selecionado*.
3. **Limpeza de Fluxo:** O botão *Limpar Campos* redefine o formulário para facilitar a inserção de uma nova atividade de forma limpa.
