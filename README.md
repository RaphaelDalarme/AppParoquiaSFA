# ⛪ App Paróquia São Francisco de Assis (SFA)

[![Android](https://img.shields.io/badge/Platform-Android-brightgreen.svg)](https://developer.android.com)
[![Language](https://img.shields.io/badge/Language-Java-orange.svg)](https://www.java.com)
[![Database](https://img.shields.io/badge/Database-Room_SQLite-blue.svg)](https://developer.android.com/training/data-storage/room)

Um aplicativo Android nativo desenvolvido para centralizar a comunicação, horários e eventos da Paróquia São Francisco de Assis. O projeto simula um cenário real onde a equipe da **PASCOM (Pastoral da Comunicação)** atua como administradora do conteúdo, enquanto os paroquianos utilizam o app como leitores.

---

## 🚀 Funcionalidades Chave

* **Controle de Acesso por Nível (RBAC):** * **Leitor (Paroquiano):** Pode visualizar os horários de missas, confissões, ler o evangelho do dia e checar o carrossel de avisos.
    * **Administrador (PASCOM):** Além de todas as funções do leitor, possui privilégios exclusivos para acessar o formulário interno e cadastrar novos avisos/eventos diretamente no banco de dados.
* **Carrossel de Avisos Dinâmico:** Renderização de cards informativos horizontais utilizando `RecyclerView` integrada ao banco de dados.
* **Persistência de Dados Local:** Utilização do ecossistema Room (SQLite) para armazenamento seguro de usuários e eventos, aplicando migrações destrutivas automáticas durante o desenvolvimento.
* **Integração de Canais de Atendimento:** Atalhos rápidos que disparam intents nativas do Android para realizar ligações telefônicas ou abrir conversas diretas no WhatsApp da secretaria paroquial.

---

## 🛠️ Tecnologias e Arquitetura Utilizadas

* **Linguagem:** Java (Android SDK Nativo)
* **Banco de Dados:** Room Database (Abstração SQLite com mapeamento de Objetos)
* **Interface e UI:** * Material Design Components (`TextInputLayout`, `MaterialButton`)
    * ConstraintLayout & LinearLayout para interfaces responsivas
    * `NestedScrollView` para rolagem fluida de conteúdos mistos
* **Componentes de Listagem:** `RecyclerView` com `ListAdapter` customizado.
* **Concorrência:** Gerenciamento de Threads secundárias (`new Thread()`) e sincronização com a UI Principal através do `runOnUiThread()` para operações seguras de banco de dados.

---

## 🗄️ Estrutura do Banco de Dados Local (Room)

O aplicativo gerencia duas entidades principais no banco de dados `paroquia_database`:

### 1. Entidade `Usuario`
* `id` (int, Primary Key AutoGenerate)
* `nome` (String)
* `email` (String)
* `senha` (String)
* `perfil` (String) -> *Define as permissões do app (`ADMIN` ou `LEITOR`)*

### 2. Entidade `Evento`
* `id` (int, Primary Key AutoGenerate)
* `titulo` (String)
* `descricao` (String)
* `data` (String)
* `local` (String)

---

## ⚙️ Como Executar o Projeto

1. Faça o clone deste repositório:
   ```bash
   git clone [(https://github.com/RaphaelDalarme/AppParoquiaSFA)]
2. Abra o Android Studio.
3. Selecione a opção Open an Existing Project e escolha a pasta do projeto clonado.
4. Espere o Gradle sincronizar todas as dependências do projeto.
5. Execute o app em um Emulador ou dispositivo físico com Android 8.0 (API 26) ou superior.



💡 Nota de Inicialização: O aplicativo vem configurado para injetar automaticamente um usuário Administrador padrão na primeira execução caso o banco esteja vazio.

Login Admin Padrão: pascom@email.com

Senha: 1234

📄 Licença
Este projeto foi desenvolvido para fins acadêmicos e de portfólio. Sinta-se livre para clonar, estudar e sugerir melhorias!


---

### 🔥 Dica de Ouro para o GitHub:
Se você tirou prints do aplicativo rodando no emulador, salve essas imagens em uma pastinha chamada `screenshots` dentro do seu projeto, suba no GitHub e depois adicione a tag de imagem no README para deixá-lo visualmente impecável, assim:
```markdown
## 📱 Telas do Aplicativo
<p id="images" align="center">
  <img src="screenshots/login.png" width="250"/>
  <img src="screenshots/main.png" width="250"/>
</p>
