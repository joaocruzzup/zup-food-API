# 🥪 Projeto: ZupFood - Documentação da API

Descrição:
O projeto ZupFood é uma API para gerenciar um sistema de pedidos de comida online. A API permite cadastrar, visualizar, atualizar e excluir itens do cardápio, categorias de itens, opções de itens, e itens adicionados ao carrinho de compras. Cada item do cardápio pode ter várias opções, e os clientes podem adicionar essas opções ao carrinho de compras para fazer seus pedidos.

## 💻 Tecnologias Utilizadas:

- Java 11
- Spring Boot
- Spring Data JPA
- Maven

## 🌐 URL utilizada
  `http://localhost:8080`

## ❗ Observação

A aplicação ao iniciar carrega as tabelas `item_option` e `item_category` com valores já pré-definidos, é possível adicionar novos valores e/ou alterar.

Para poder adicionar um novo item no cardápio (`item_menu`) ele deve conter a categoria presente em `item_category` e o nome presente em `item_option`.

Para adicionar um item no carrinho (`item_cart`) ele deve estar presente em `item_menu`

## 🔴 Endpoints

### Categorias de Itens:

Buscar todos os itens
- Método: GET
- Endpoint: /category

---

Buscar Categoria de Item por ID:
- Método: GET
- Endpoint: /category/{id}

---

Cadastrar Nova Categoria de Item:

Método: POST
- Endpoint: /category
- Exemplo de Requisição:
```
{
  "name": "fruta"
}
```

---

Método: PUT
- Endpoint: /category/{id}
- Exemplo de Requisição: /category/3

```
{
  "name": "sobremesa"
}
```

---

## Opções de Itens:

Listar Todas as Opções de Itens:
- Método: GET
- Endpoint: /option

---

Buscar Opção de Item por ID:
- Método: GET
- Endpoint: /option/{id}

---

Cadastrar Nova Opção de Item:
- Método: POST
- Endpoint: /option
- Exemplo de Requisição:
```
{
  "name": "suco",
  "price": 6.0,
  "itemCategoryId": 2
}
```

---

Atualizar Opção de Item por ID:
- Método: PUT
- Endpoint: /option/{id}
- Exemplo de Requisição: /option/4
```
{
  "name": "refrigerante",
  "price": 8.0,
  "itemCategoryId": 2
}
```

---

Excluir Opção de Item por ID:
- Método: DELETE
- Endpoint: /option/{id}

---

## Gerenciamento de itens do cardápio

Listar Todos os Itens do Cardápio:
- Método: GET
- Endpoint: /menu

---

Buscar Item do Cardápio por ID:
- Método: GET
- Endpoint: /menu/{id}

---

Cadastrar Novo Item do Cardápio:
- Método: POST
- Endpoint: /menu
- Exemplo de Requisição:

```
{
  "itemCategory": "lanche",
  "name": "x-calabresa",
  "unitPrice": 11.0
}
```

---

Atualizar Item do Cardápio por ID:
- Método: PUT
- Endpoint: /menu/{id}
Exemplo de Requisição: /menu/6
```
{
  "itemCategory": "lanche",
  "name": "x-calabresa",
  "unitPrice": 12.0
}
```

---

Excluir Item do Cardápio por ID:
- Método: DELETE
- Endpoint: /menu/{id}
- Exemplo de Requisição: /menu/6

---

## Gerenciamento do Carrinho de compras

Listar Todos os Itens no Carrinho:
- Método: GET
- Endpoint: /cart

---
 
Buscar Item no Carrinho por ID:
- Método: GET
- Endpoint: /cart/{id}
- Exemplo de Requisição: /cart/3

---

Adicionar Itens no Carrinho:  
- Método: POST
- Endpoint: /cart
- Exemplo de Requisição:
```
[
  {
    "menuId": 2,
    "totalPrice": 30.0,
    "quantity": 3
  }
]
```

---

Atualizar Item no Carrinho por ID:
- Método: PUT
- Endpoint: /cart/{id}
- Exemplo de Requisição: /cart/7
```
{
  "menuId": 2,
  "totalPrice": 40.0,
  "quantity": 4
}
```

---

Excluir Item no Carrinho por ID:
- Método: DELETE
- Endpoint: /cart/{id}
- Exemplo de Requisição: /cart/7

---

## 👨‍💻 Autor

Nome: João Cruz<br>Linkedin: https://www.linkedin.com/in/joaosilvacruz/

---

<h4 align=center>Made with 💚 by <a href="https://gith




  
