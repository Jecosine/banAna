# Database Design

## Tables

- user
  
field name | data type | description
|-|-|-|
userId|char(10)| primary key
userName|varchar(20) | not null
gender| char(1) |


- order

field name | data type | description
|-|-|-|
orderId|char(10)| primary key
dateTime| datatime() |
price | float


- shop
- item
- category