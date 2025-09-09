# DS Products with Apache Cassandra

Projeto didático ministrado pelo professor Dr. Nelio Alves no capítulo 8: Workshop NoSQL Cassandra referenete ao módulo Java Spring Reference.

Link de acesso: https://devsuperior.club

Este projeto tem como intuito construir uma API REST para manipulação de departamentos e produtos com conexão com banco de dados NoSQL utilizando 
Spring Boot e Apache Cassandra. 

### Container Docker do Cassandra para desenvolvimento
```
docker run -d -p 9042:9042 --name cassandra1 cassandra:3.11.10
```
```
docker exec -it cassandra1 bash
```
### cqlsh
```
describe keyspaces

CREATE KEYSPACE testdb WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};

use testdb;

describe tables

CREATE TABLE post(id uuid, moment timestamp, body text, author varchar, PRIMARY KEY (id));

INSERT INTO post (id, moment, body, author) VALUES (uuid(), '2021-02-26T10:00:00Z', 'Bom dia!', 'Bob');
INSERT INTO post (id, moment, body, author) VALUES (uuid(), '2021-02-27T10:00:00Z', 'Partiu viagem', 'Maria');
INSERT INTO post (id, moment, body, author) VALUES (uuid(), '2021-02-27T10:00:00Z', 'Que dia bonito!', 'Maria');

SELECT * FROM post;

SELECT * FROM post WHERE author = 'Maria' ALLOW FILTERING;

CREATE CUSTOM INDEX body_idx ON post (body) USING 'org.apache.cassandra.index.sasi.SASIIndex' WITH OPTIONS = {'mode': 'CONTAINS', 'analyzer_class': 'org.apache.cassandra.index.sasi.analyzer.NonTokenizingAnalyzer','case_sensitive': 'false'};

SELECT * FROM post WHERE body LIKE '%MORNING%';
```
