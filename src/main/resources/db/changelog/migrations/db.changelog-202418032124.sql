--liquibase formatted sql
--changeset ulrich:202418032124
--comment: board_columns table create

CREATE TABLE BOARDS_COLUMNS (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    `order` INT NOT NULL,
    kind varchar(7) NOT NULL,
    board_id BIGINT NOT NULL,
    CONSTRAINT boards__boards_columns_fk FOREIGN
        KEY (board_id) REFERENCES BOARDS(ID) ON
        DELETE CASCADE,
    CONSTRAINT id_order_uk UNIQUE KEY
        unique_board_id_order (board_id, `order`)
) ENGINE=InnoDB;

--rollback DROP TABLE BOARDS_COLUMNS