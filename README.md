# 🏦 Spring Boot ATM Application
Виконав ст.гр. САУ-м 24-1 Лобанов К.С.

## 📋 Опис
Це простий RESTful-застосунок для моделювання функціоналу банкомата. Реалізовано базову систему роботи з банківськими акаунтами, а також історію транзакцій.

## ✅ Реалізовані можливості

### 🔸 CRUD-операції над банківськими акаунтами (`BankAccount`)
- Створення акаунта
- Отримання балансу
- Оновлення балансу (поповнення / зняття)
- Отримання списку всіх акаунтів
- Видалення акаунта

### 🔸 Валідація та обробка винятків
- Перевірка наявності акаунта
- Перевірка коректності суми (неможливість мати від'ємний баланс)

### 🔸 Додатковий функціонал (до 100%)
- **Сутність `Transaction`**: автоматичне створення записів про зміну балансу
- **Зв’язок один-до-багатьох** між `BankAccount` та `Transaction`
- Отримання історії транзакцій певного акаунта

## 🛠️ Технології
- Java 17+
- Spring Boot 3+
- Spring Data JPA
- MySQL
- ModelMapper
- Lombok
- Postman (для тестування API)

## 📦 Структура бази даних

### Таблиця `account`
| Поле       | Тип         |
|------------|-------------|
| account_id | Long (PK)   |
| name       | String      |
| surname    | String      |
| number     | String      |
| balance    | double      |

### Таблиця `transactions`
| Поле       | Тип         |
|------------|-------------|
| id         | Long (PK)   |
| amount     | double      |
| timestamp  | LocalDateTime |
| account_id | FK → account.account_id |

## REST API
Створити акаунт  
POST http://localhost:8080/account

Отримати всі акаунти
GET http://localhost:8080/accounts

Отримання балансу за ID  
GET http://localhost:8080/1

Оновлення балансу (поповнення / зняття)
PUT http://localhost:8080/update/balance

Видалення акаунта  
DELETE http://localhost:8080/account/1

Отримання історії транзакцій акаунта
GET http://localhost:8080/account/1/transactions
