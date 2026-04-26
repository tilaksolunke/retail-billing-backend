markdown# Vendix - AI-Powered Retail Billing Software

A full-stack Point of Sale (POS) system for small retail shops with an integrated AI assistant that provides real-time business insights using natural language.

## 🚀 Live Demo
> Coming soon

---

## 📸 Screenshots

> Add screenshots of Dashboard, Explore, and AI Chat here

---

## ✨ Features

### Core Features
- 🧾 **Billing & Invoicing** — Cart-based billing with printable receipts
- 📦 **Product Management** — Add, edit, delete products with images
- 🗂️ **Category Management** — Organize products by category
- 📊 **Sales Dashboard** — Real-time today's sales and order count
- 📜 **Order History** — Complete order history with filters
- 👥 **User Management** — Admin-controlled staff account creation
- 💳 **Payment Integration** — Cash, UPI and Stripe online payments
- 🔐 **Role-Based Access** — Admin and Staff roles with JWT authentication

### 🤖 AI Features
- **Vendix AI Chatbot** — Natural language queries powered by Groq AI (Llama 3.3)
- **RAG Architecture** — AI reads real MySQL data to answer shop-specific questions
- **Smart Insights** — Ask about revenue, best sellers, order counts in plain English

---

## 🛠️ Tech Stack

### Backend
| Technology | Purpose |
|---|---|
| Spring Boot 3 | REST API framework |
| Spring Security | Authentication & Authorization |
| JWT | Stateless session management |
| MySQL | Primary database |
| Spring Data JPA | ORM & database queries |
| Groq AI API | LLM for AI chatbot |
| Stripe API | Online payment processing |
| WebFlux WebClient | HTTP client for AI API calls |

### Frontend
| Technology | Purpose |
|---|---|
| React.js | UI framework |
| React Router | Client-side routing |
| Axios | HTTP client |
| Bootstrap | UI components |
| React Hot Toast | Notifications |

---

## 🤖 AI Architecture (RAG)
User Question (React Chat Widget)
↓
Spring Boot Backend
↓
Fetch real-time data from MySQL
(orders, revenue, best sellers, payment methods)
↓
Build intelligent prompt with shop context
↓
Send to Groq AI (Llama 3.3-70b)
↓
Return human-friendly answer
↓
Display in chat widget

This pattern is called **RAG (Retrieval Augmented Generation)** — the AI answers questions based on YOUR data, not just general knowledge.

---

## ⚙️ Setup & Installation

### Prerequisites
- Java 17+
- Node.js 18+
- MySQL 8+
- Maven

### Backend Setup

**1. Clone the repository**
```bash
git clone https://github.com/yourusername/vendix.git
cd vendix
```

**2. Create MySQL database**
```sql
CREATE DATABASE vendix;
```

**3. Set environment variables in IntelliJ or as system variables**
DB_URL=jdbc:mysql://localhost:3306/vendix
DB_USERNAME=your_mysql_username
DB_PASSWORD=your_mysql_password
JWT_SECRET=your_jwt_secret_key
STRIPE_API_KEY=your_stripe_publishable_key
STRIPE_API_SECRET=your_stripe_secret_key
GROQ_API_KEY=your_groq_api_key

**4. Run the backend**
```bash
mvn spring-boot:run
```
Backend runs at `http://localhost:8080`

### Frontend Setup

**1. Navigate to client folder**
```bash
cd client
```

**2. Install dependencies**
```bash
npm install
```

**3. Run the frontend**
```bash
npm run dev
```
Frontend runs at `http://localhost:5173`

---

## 🔑 Default Admin Setup

After running the app, create your first admin user:

**1. Encode your password:**
POST http://localhost:8080/api/v1.0/encode
Body: { "password": "yourpassword" }

**2. Insert admin user directly in MySQL:**
```sql
INSERT INTO tbl_users (name, email, password, role) 
VALUES ('Admin', 'admin@example.com', 'encoded_password_here', 'ROLE_ADMIN');
```

---

## 📁 Project Structure
billingsoftware/
├── src/main/java/in/tilaksolunke/billingsoftware/
│   ├── ai/                    # AI chatbot (RAG implementation)
│   │   ├── AiController.java
│   │   ├── AiService.java
│   │   └── ChatRequest.java
│   ├── config/                # Security & CORS config
│   ├── controller/            # REST API endpoints
│   ├── entity/                # Database entities
│   ├── Filters/               # JWT request filter
│   ├── io/                    # Request/Response DTOs
│   ├── repository/            # JPA repositories
│   ├── service/               # Business logic
│   └── Util/                  # JWT utility
└── src/main/resources/
└── application.properties
client/
├── src/
│   ├── Components/            # Reusable UI components
│   │   ├── AiChat/           # AI chatbot widget
│   │   ├── CartItems/
│   │   ├── CartSummary/
│   │   └── ...
│   ├── pages/                 # Page components
│   ├── Service/               # API service layer
│   └── context/               # React context (global state)

---

## 🔐 API Endpoints

### Auth
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1.0/auth/login` | Login and get JWT token |

### Items
| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/v1.0/items` | Get all items |
| POST | `/api/v1.0/items` | Create item (Admin) |
| DELETE | `/api/v1.0/items/{id}` | Delete item (Admin) |

### Orders
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1.0/orders` | Create new order |
| GET | `/api/v1.0/orders` | Get all orders |
| DELETE | `/api/v1.0/orders/{id}` | Delete order |

### AI
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/v1.0/api/ai/chat` | Chat with Vendix AI |

### Dashboard
| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/v1.0/dashboard` | Get dashboard data |

---

## 📄 License
MIT License — feel free to use this project for learning and portfolio purposes.

---

## 👨‍💻 Author
**Tilak Solunke**
- LinkedIn: [linkedin.com/in/tilaksolunke](https://linkedin.com/in/tilaksolunke)
