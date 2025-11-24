# TaskList 📋

Um aplicativo Android simples para gerenciar tarefas (to-do list) usando SQLite.  
Permite adicionar, listar e excluir tarefas (tasks) com ID e nome.

---

## 🧱 Funcionalidades

- Adicionar novas tarefas com nome  
- Listar todas as tarefas salvas no banco local (SQLite)  
- Excluir tarefas com **long click**  
- Estrutura simples usando DAO + SQLiteOpenHelper  
- Adapter RecyclerView para exibir a lista das tarefas  

---

## 📐 Arquitetura & Organização

- `DBHelper` — gerencia criação e versão do banco SQLite  
- `TaskDAO` — camada de acesso a dados (inserir, buscar, deletar)  
- `Task` — modelo da tarefa (ID + nome)  
- `MainActivity` — tela principal com RecyclerView  
- `AddTaskActivity` — tela para inserir nova tarefa  
- `TaskAdapter` — adapter para converter lista de `Task` para a UI  

---

## 🚀 Como rodar o projeto

1. Clone este repositório:  
   ```bash
   git clone https://github.com/sdsamih/TaskList.git
