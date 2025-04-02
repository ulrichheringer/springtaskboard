--liquibase formatted sql
--changeset ulrich:202403031214
--comment: board table create

CREATE TABLE BOARDS (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
) ENGINE=InnoDB;

--rollback DROP TABLE BOARDS