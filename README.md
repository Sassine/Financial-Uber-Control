# Financial-Uber-Control

### English Version

Description:
Financial-Uber-Control is a project designed to help users manage their monthly Uber expenses. The application connects to a Gmail account, searches for emails with specific subjects within a defined date range, and sums up the total amount spent on Uber rides for the specified period. This tool is particularly useful since Uber does not provide an easy-to-access personal report for users.

Features:
- Gmail Integration: Connects to your Gmail account to fetch Uber ride receipts.
- Expense Calculation: Automatically calculates the total amount spent on Uber rides for a specified month.
- Customizable Search: Allows users to define the subject filter and date range for fetching emails.
- Real-time Updates: Fetches and processes emails in real-time to provide up-to-date expense reports.

Prerequisites:
- Java 21+
- Maven
- A Gmail account with IMAP enabled

Installation:
1. Clone the repository:
```bash 
    git clone https://github.com/Sassine/Financial-Uber-Control.git
```
2. Navigate to the project directory:
```bash 
cd Financial-Uber-Control
```
3. Configure your Gmail credentials in application.properties:
```bash 
   spring.mail.username=your-email@gmail.com
   spring.mail.password=your-app-password
```
   Ensure that you use an App Password if you have 2-Step Verification enabled on your Google account.

4. Build the project using Maven:
```bash 
mvn clean install
```
5. Run the application:
```bash 
   mvn spring-boot:run
```
Usage:
The application will automatically search for emails with the subject "[Personal] Sua viagem " within the specified date range (by default, the current month) and calculate the total amount spent on Uber rides.

License:
This project is licensed under the MIT License. See the LICENSE file for details.

---

### Versão em Português

Descrição:
O Financial-Uber-Control é um projeto desenvolvido para ajudar os usuários a gerenciar seus gastos mensais com Uber. A aplicação se conecta a uma conta do Gmail, procura por e-mails com assuntos específicos dentro de um intervalo de datas definido e soma o total gasto em corridas de Uber no período especificado. Essa ferramenta é especialmente útil, já que o Uber não fornece um relatório pessoal de fácil acesso para os usuários.

Funcionalidades:
- Integração com Gmail: Conecta-se à sua conta do Gmail para buscar recibos de corridas do Uber.
- Cálculo de Despesas: Calcula automaticamente o total gasto em corridas de Uber para um mês especificado.
- Busca Personalizável: Permite que os usuários definam o filtro de assunto e o intervalo de datas para a busca de e-mails.
- Atualizações em Tempo Real: Busca e processa e-mails em tempo real para fornecer relatórios de despesas atualizados.

Pré-requisitos:
- Java 21+
- Maven
- Uma conta do Gmail com IMAP habilitado

Instalação:
1. Clone o repositório:
```bash 
    git clone https://github.com/Sassine/Financial-Uber-Control.git
```
2. Navegue até o diretório do projeto:
```bash 
     cd Financial-Uber-Control
```
3. Configure suas credenciais do Gmail em application.properties:
```bash 
   spring.mail.username=seu-email@gmail.com
   spring.mail.password=sua-senha-de-aplicativo
```
   Certifique-se de usar uma Senha de Aplicativo se você tiver a Verificação em Duas Etapas habilitada na sua conta Google.

4. Compile o projeto usando Maven:
```bash 
   mvn clean install
```
5. Execute a aplicação:
```bash 
   mvn spring-boot:run
```
Uso:
A aplicação buscará automaticamente e-mails com o assunto "[Personal] Sua viagem" dentro do intervalo de datas especificado (por padrão, o mês atual) e calculará o total gasto em corridas de Uber.

Licença:
Este projeto é licenciado sob a Licença MIT. Veja o arquivo LICENSE para mais detalhes.