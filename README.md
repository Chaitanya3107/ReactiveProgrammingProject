# 📚 BookStore – Reactive Book Management API

A **reactive BookStore backend application** built using **Spring Boot WebFlux** and **Spring Data R2DBC**.  
The project demonstrates **non-blocking, asynchronous CRUD operations** with a MySQL database.

---

## 🚀 Tech Stack

- Java 21  
- Spring Boot 4  
- Spring WebFlux  
- Spring Data R2DBC  
- MySQL  
- Project Reactor (Mono & Flux)

---

## ✨ Features

- Create, read, update, delete and search books
- Fully **non-blocking reactive APIs**
- Uses **R2DBC** instead of Spring JPA
- Supports **Server-Sent Events (SSE)** for streaming book data
- Clean separation of Controller, Service, and Repository layers

---

## 📦 Book Entity

Each book contains:
- `bookId` (Auto-generated)
- `name`
- `description`
- `publisher`
- `author`

---
## ⚡ Reactive Highlights

- Uses **Flux** for streaming multiple books
- Uses **Mono** for single book operations
- Demonstrates the difference between:
  - Buffered responses (`application/json`)
  - Streaming responses (`text/event-stream`)
- No blocking calls (no JDBC, no `Thread.sleep`)

---
