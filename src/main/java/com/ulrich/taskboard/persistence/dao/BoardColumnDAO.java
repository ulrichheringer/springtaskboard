package com.ulrich.taskboard.persistence.dao;

import com.mysql.cj.jdbc.StatementImpl;
import com.ulrich.taskboard.persistence.entity.BoardColumnEntity;
import java.awt.List;
import java.sql.Connection;
import java.sql.SQLException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoardColumnDAO {

  private final Connection connection;

  public BoardColumnEntity insert(final BoardColumnEntity entity) throws SQLException {
    var sql = "INSERT INTO BOARDS_COLUMNS (name, `order`, kind, board_id) VALUES (?,?,?,?);";
    try (var statement = connection.prepareStatement(sql)) {
      var i = 1;
      statement.setString(i++, entity.getName());
      statement.setInt(i++, entity.getOrder());
      statement.setString(i++, entity.getKind().name());
      statement.setLong(i, entity.getBoard().getId());
      statement.executeUpdate();
      if (statement instanceof StatementImpl impl) {
        entity.setId(impl.getLastInsertID());
      }
      return entity;
    }
  }

  public List<BoardColumnEntity> findByBoardId(final Long id) throws SQLException {
    var sql = "SELECT id, name, `order` FROM BOARDS_COLUMNS WHERE board_id = ? ORDER BY `order`";
    try (var statement = connection.prepareStatement(sql)) {
      statement.setLong(1, id);
      statement.executeQuery();
    }
    return null;
  }
}
